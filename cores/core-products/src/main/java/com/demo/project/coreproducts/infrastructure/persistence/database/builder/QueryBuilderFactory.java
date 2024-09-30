package com.demo.project.coreproducts.infrastructure.persistence.database.builder;


public class QueryBuilderFactory {

    public QueryBuilder createWhere(String type) {
        return switch (type) {
            case "POINT_INFO" -> new PointInfoEntityBuilder(); // point_info table
            // 테이블 단위로 조회가 더 필요한 것이 있다면 추가
            default -> null;
        };
    }
}
