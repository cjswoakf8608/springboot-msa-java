package com.demo.project.coreproducts.presentation.controller;

import com.demo.project.coreproducts.application.PointInfoService;
import com.demo.project.coreproducts.presentation.request.SearchRequest;
import com.demo.project.coreproducts.presentation.response.PointInfosResponse;
import com.demo.project.coreproducts.presentation.response.base.BaseApiResponse;
import com.demo.project.globals.presentation.controller.BaseApiController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping(value = "/v1/points")
@RestController
public class PointInfoController extends BaseApiController {
    private final PointInfoService pointInfoService;

    @Operation(summary = "포인트 정보 조건 검색", description = "정책으로 정의된 포인트 정보(정책)을 검색합니다.")
    @GetMapping("")
    @Parameter(name = "searches", description = "Format= key:value", array = @ArraySchema(schema = @Schema(implementation = String.class)))
    @Parameter(name = "sort", description = "Format= property:direction", array = @ArraySchema(schema = @Schema(implementation = String.class)))
    public BaseApiResponse<PointInfosResponse> findAll(@ParameterObject SearchRequest searchRequest) {
        PointInfosResponse response = pointInfoService.findAll(searchRequest.toDto());

        return BaseApiResponse.success(response);
    }
}
