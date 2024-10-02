//package com.demo.project.coreusers.application;
//
//import com.demo.project.coreusers.domain.entity.MemberEntity;
//import com.demo.project.coreusers.domain.model.Search;
//import com.demo.project.coreusers.domain.model.SearchItem;
//import com.demo.project.coreusers.domain.service.MemberPersistenceService;
//import com.demo.project.coreusers.presentation.response.MemberResponse;
//import com.demo.project.coreusers.presentation.response.MembersResponse;
//import com.demo.project.coreusers.presentation.response.base.BaseApiException;
//import org.apache.commons.lang3.BooleanUtils;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.data.domain.Page;
//
//import java.util.Collections;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class MemberServiceTest {
//
//    private MemberService memberService;
//
//    @Mock
//    private MemberPersistenceService memberPersistenceService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        memberService = new MemberService(memberPersistenceService);
//    }
//
//    @Test
//    void getById_WhenMemberExists_ReturnsOptionalMemberEntity() {
//        // Given
//        Long memberId = 1L;
//        MemberEntity memberEntity = MemberEntity.builder()
//                .id(memberId)
//                .name("Test User")
//                .build();
//        Search search = Search.builder()
//                .items(Collections.singletonList(SearchItem.builder().key("id").value(memberId.toString()).build())
//                ).build();
//        when(memberPersistenceService.findAll(search)).thenReturn((Page<MemberEntity>) memberEntity);
//
//        // When
//        MembersResponse result = memberService.findAll(search);
//
//        // Then
//        assertTrue(BooleanUtils.isFalse(result.getMembers().isEmpty()));
//        assertEquals(memberEntity, result.getMembers());
////        verify(memberPersistenceService, times(1)).findById(memberId);
//    }
//
////    @Test
////    void getById_WhenMemberDoesNotExist_ReturnsEmptyOptional() {
////        // Given
////        Long memberId = 1L;
////        when(memberPersistenceService.findById(memberId)).thenReturn(Optional.empty());
////
////        // When
////        Optional<MemberEntity> result = memberService.getById(memberId);
////
////        // Then
////        assertFalse(result.isPresent());
////        verify(memberPersistenceService, times(1)).findById(memberId);
////    }
////
////    @Test
////    void getAll_ReturnsPageOfMemberEntities() {
////        // Given
////        Search search = Search.builder().build();
////        Page<MemberEntity> page = (Page<MemberEntity>) mock(Page.class);
////        when(memberPersistenceService.findAll(search)).thenReturn(page);
////
////        // When
////        Page<MemberEntity> result = memberService.getAll(search);
////
////        // Then
////        assertEquals(page, result);
////        verify(memberPersistenceService, times(1)).findAll(search);
////    }
////
////    @Test
////    void findById_WhenMemberExists_ReturnsMemberResponse() {
////        // Given
////        Long memberId = 1L;
////        MemberEntity memberEntity = MemberEntity.builder()
////                .id(memberId)
////                .name("Test User")
////                .build();
////        when(memberPersistenceService.findById(memberId)).thenReturn(Optional.of(memberEntity));
////
////        // When
////        MemberResponse result = memberService.findById(memberId);
////
////        // Then
////        assertNotNull(result);
////        assertEquals(memberEntity.getId(), result.getId());
////        assertEquals(memberEntity.getName(), result.getName());
////        verify(memberPersistenceService, times(1)).findById(memberId);
////    }
////
////    @Test
////    void findById_WhenMemberDoesNotExist_ThrowsBaseApiException() {
////        // Given
////        Long memberId = 1L;
////        when(memberPersistenceService.findById(memberId)).thenReturn(Optional.empty());
////
////        // When & Then
////        assertThrows(BaseApiException.class, () -> memberService.findById(memberId));
////        verify(memberPersistenceService, times(1)).findById(memberId);
////    }
////
////    @Test
////    void findAll_ReturnsMembersResponse() {
////        // Given
////        Search search = Search.builder().build();
////        Page<MemberEntity> page = (Page<MemberEntity>) mock(Page.class);
////        when(memberPersistenceService.findAll(search)).thenReturn(page);
////
////        // When
////        MembersResponse result = memberService.findAll(search);
////
////        // Then
////        assertNotNull(result);
////        assertEquals(page, result.getMembers());
////        verify(memberPersistenceService, times(1)).findAll(search);
////    }
//}
