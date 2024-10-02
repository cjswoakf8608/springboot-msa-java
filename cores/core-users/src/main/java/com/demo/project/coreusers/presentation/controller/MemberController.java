package com.demo.project.coreusers.presentation.controller;

import com.demo.project.coreusers.application.MemberService;
import com.demo.project.coreusers.presentation.request.SearchRequest;
import com.demo.project.coreusers.presentation.response.MemberResponse;
import com.demo.project.coreusers.presentation.response.MembersResponse;
import com.demo.project.coreusers.presentation.response.base.BaseApiResponse;
import com.demo.project.globals.presentation.controller.BaseApiController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping(value = "/v1/members")
@RestController
public class MemberController extends BaseApiController {
    private final MemberService memberService;

    @Operation(summary = "사용자 조건 검색", description = "다수 사용자를 조건 검색합니다.")
    @GetMapping("")
    @Parameter(name = "searches", description = "Format= key:value", array = @ArraySchema(schema = @Schema(implementation = String.class)))
    @Parameter(name = "sort", description = "Format= property:direction", array = @ArraySchema(schema = @Schema(implementation = String.class)))
    public BaseApiResponse<MembersResponse> findAll(@ParameterObject SearchRequest searchRequest) {
        MembersResponse response = memberService.findAll(searchRequest.toDto());

        return BaseApiResponse.success(response);
    }

}
