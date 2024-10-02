package com.demo.project.apps.application;

import com.demo.project.apps.domain.document.ProfileViewDocument;
import com.demo.project.apps.domain.service.ProfileViewPersistenceService;
import com.demo.project.apps.domain.service.QueueMessagingService;
import com.demo.project.apps.domain.service.UsersIntegrationService;
import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.infrastructure.messaging.request.ProfileViewEvent;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.MemberApiResponse;
import com.demo.project.apps.presentation.response.MembersApiResponse;
import com.demo.project.apps.presentation.response.base.BaseApiException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MemberServiceTest {

    private MemberService memberService;

    @Mock
    private UsersIntegrationService usersIntegrationService;

    @Mock
    private ProfileViewPersistenceService profileViewPersistenceService;

    @Mock
    private QueueMessagingService queueMessagingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        memberService = new MemberService(usersIntegrationService, profileViewPersistenceService, queueMessagingService);
    }

    @Test
    void getById_WhenMemberExists_ReturnsMembersResponse() {
        // Given
        Long memberId = 1L;
        MembersResponse membersResponse = MembersResponse.builder()
                .members(Collections.singletonList(
                        MemberResponse.builder().id(memberId).name("Test User").build()))
                .build();

        when(usersIntegrationService.findAll(any(SearchRequest.class))).thenReturn(membersResponse);

        // When
        MembersResponse result = memberService.getById(memberId);

        // Then
        assertNotNull(result);
        assertEquals(membersResponse, result);
        verify(usersIntegrationService, times(1)).findAll(any(SearchRequest.class));
    }

    @Test
    void getById_WhenMemberDoesNotExist_ReturnsEmptyMembersResponse() {
        // Given
        Long memberId = 1L;
        MembersResponse emptyResponse = MembersResponse.builder()
                .members(Collections.emptyList())
                .build();

        when(usersIntegrationService.findAll(any(SearchRequest.class))).thenReturn(emptyResponse);

        // When
        MembersResponse result = memberService.getById(memberId);

        // Then
        assertNotNull(result);
        assertTrue(result.getMembers().isEmpty());
        verify(usersIntegrationService, times(1)).findAll(any(SearchRequest.class));
    }

    @Test
    void findById_WhenMemberExists_ReturnsMemberApiResponse() {
        // Given
        Long memberId = 1L;
        MembersResponse membersResponse = MembersResponse.builder()
                .members(Collections.singletonList(
                        MemberResponse.builder().id(memberId).name("Test User").build()))
                .build();

        when(usersIntegrationService.findAll(any(SearchRequest.class))).thenReturn(membersResponse);

        // When
        MemberApiResponse result = memberService.findById(memberId);

        // Then
        assertNotNull(result);
        assertEquals(memberId, result.getId());

        // Verify that profileViewPersistenceService and queueMessagingService were called
        verify(profileViewPersistenceService, times(1)).save(any(ProfileViewDocument.class));
        verify(queueMessagingService, times(1)).sendProfileView(any(ProfileViewEvent.class));
    }

    @Test
    void findById_WhenMemberDoesNotExist_ThrowsBaseApiException() {
        // Given
        Long memberId = 1L;
        MembersResponse emptyResponse = MembersResponse.builder()
                .members(Collections.emptyList())
                .build();

        when(usersIntegrationService.findAll(any(SearchRequest.class))).thenReturn(emptyResponse);

        // When, Then
        assertThrows(BaseApiException.class, () -> memberService.findById(memberId));
        verify(usersIntegrationService, times(1)).findAll(any(SearchRequest.class));
    }

    @Test
    void findAll_ReturnsMembersApiResponse() {
        // Given
        SearchRequest searchRequest = SearchRequest.builder().build();
        MembersResponse membersResponse = MembersResponse.builder()
                .members(Collections.singletonList(
                        MemberResponse.builder().id(1L).name("Test User").build()))
                .build();

        when(usersIntegrationService.findAll(any(SearchRequest.class))).thenReturn(membersResponse);

        // When
        MembersApiResponse result = memberService.findAll(searchRequest);

        // Then
        assertNotNull(result);
        assertEquals(membersResponse.getMembers(), result.getMembers());
        verify(usersIntegrationService, times(1)).findAll(any(SearchRequest.class));
    }
}
