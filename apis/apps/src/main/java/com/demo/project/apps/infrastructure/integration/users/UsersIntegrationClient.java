package com.demo.project.apps.infrastructure.integration.users;

import com.demo.project.apps.infrastructure.configuration.FeignConfig;
import com.demo.project.apps.infrastructure.integration.users.response.MemberResponse;
import com.demo.project.apps.infrastructure.integration.users.response.MembersResponse;
import com.demo.project.apps.presentation.request.SearchRequest;
import com.demo.project.apps.presentation.response.base.BaseApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Users", url="${externals.apis.core-network.users.host}", configuration = {FeignConfig.class})
public interface UsersIntegrationClient {

    @GetMapping(value =  "${externals.apis.core-network.users.version}" + "${externals.apis.core-network.users.uris.members.resource}/{memberId}")
    ResponseEntity<BaseApiResponse<MemberResponse>> findById(@PathVariable("memberId") Long memberId);

    @GetMapping(value =  "${externals.apis.core-network.users.version}" + "${externals.apis.core-network.users.uris.members.resource}")
    ResponseEntity<BaseApiResponse<MembersResponse>> findAll(@SpringQueryMap SearchRequest searchRequest);
}
