package com.demo.project.coreusers.infrastructure.persistence.database.builder;



public class QueryBuilderFactory {

    public QueryBuilder createWhere(String type) {
        return switch (type) {
            case "MEMBER" -> new MemberEntityBuilder(); // member table
            case "MEMBER_ROLE" -> new MemberRoleEntityBuilder(); // member_role table
            // 테이블 단위로 조회가 더 필요한 것이 있다면 추가
            default -> null;
        };
    }
}
