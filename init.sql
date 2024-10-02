/**
    * DB 초기화 스크립트
    * 1. DB 생성
    * 2. 사용자 생성
    * 3. 권한 부여
 */
SET NAMES utf8mb4;

CREATE DATABASE IF NOT EXISTS `users`;
CREATE DATABASE IF NOT EXISTS `products`;


CREATE USER 'users'@'%' IDENTIFIED BY 'dev00_users';
CREATE USER 'users_slave'@'%' IDENTIFIED BY 'dev00_users';

GRANT SELECT,UPDATE,DELETE,INSERT ON `users`.* TO 'users'@'%';
GRANT SELECT ON `users`.* TO 'users_slave'@'%';

CREATE USER 'products'@'%' IDENTIFIED BY 'dev00_products';
CREATE USER 'products_slave'@'%' IDENTIFIED BY 'dev00_products';

GRANT SELECT,UPDATE,DELETE,INSERT ON `products`.* TO 'products'@'%';
GRANT SELECT ON `products`.* TO 'products_slave'@'%';

FLUSH PRIVILEGES;


/**
    * users DB
    * member: 회원 정보
 */
USE users;
drop table if exists member;
create table member
(
    id         bigint auto_increment comment '회원 고유 ID'
        primary key,
    login_id   varchar(320)                           not null comment '로그인 ID',
    password   varchar(100)                           not null comment '로그인 비밀번호',
    total_view bigint     default 0                   not null comment '프로필 조회 수',
    name       varchar(100)                           null comment '실 성함',
    status     varchar(1) default 'A'                 not null comment '상태.  A: 활성, D:탈퇴, S: 휴면',
    created_at datetime   default current_timestamp() not null comment '등록일시',
    updated_at datetime   default current_timestamp() not null on update current_timestamp() comment '수정일시'
)
    comment '회원 정보';
INSERT INTO users.member (id, login_id, password, total_view, name, status, created_at, updated_at) VALUES (1, 'test', 'test', 2, '조용석', 'A', '2024-09-27 09:41:39', '2024-10-02 08:45:02');
INSERT INTO users.member (id, login_id, password, total_view, name, status, created_at, updated_at) VALUES (2, 'test2', 'test2', 1, '조용석', 'A', '2024-09-29 05:27:43', '2024-10-02 01:53:54');
INSERT INTO users.member (id, login_id, password, total_view, name, status, created_at, updated_at) VALUES (3, 'test3', 'test3', 0, '김말숙', 'A', '2024-09-29 05:27:43', '2024-09-29 05:27:43');
INSERT INTO users.member (id, login_id, password, total_view, name, status, created_at, updated_at) VALUES (4, 'test4', 'test4', 0, '조용석', 'D', '2024-09-29 05:27:56', '2024-09-29 05:27:56');



drop table if exists member_point;
create table if not exists member_point
(
    id                  bigint auto_increment comment '회원 포인트 정보 고유 ID'
        primary key,
    member_id  bigint                               not null comment '회원 고유 ID',
    total_point         decimal(10, 2)                         null comment '총 포인트',
    status              varchar(1) default 'A'               not null comment '상태.  A: 활성, D:삭제',
    created_at          datetime   default CURRENT_TIMESTAMP not null comment '등록일시',
    updated_at          datetime   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '수정일시',
    constraint FK_MEMBER_POINT_MEMBER_ID
        foreign key (member_id) references member (id)
)
    comment '회원 포인트 정보';
INSERT INTO users.member_point (id, member_id, total_point, status, created_at, updated_at) VALUES (1, 1, 0.00, 'A', '2024-09-28 11:17:06', '2024-10-02 08:51:46');
INSERT INTO users.member_point (id, member_id, total_point, status, created_at, updated_at) VALUES (2, 2, 0.00, 'A', '2024-09-29 05:33:21', '2024-09-29 05:33:21');
INSERT INTO users.member_point (id, member_id, total_point, status, created_at, updated_at) VALUES (3, 3, 0.00, 'A', '2024-09-29 05:33:21', '2024-09-29 05:33:21');
INSERT INTO users.member_point (id, member_id, total_point, status, created_at, updated_at) VALUES (4, 4, 0.00, 'A', '2024-09-29 05:33:21', '2024-09-29 05:33:21');

drop table if exists member_role;
create table if not exists member_role
(
    id                  bigint auto_increment comment '회원 Role 고유 ID'
        primary key,
    member_id  bigint                               not null comment '회원 고유 ID',
    member_role         varchar(100)                         null comment '회원 Role. ADMIN: 어드민, FREELANCER:프리렌서, ...',
    status              varchar(1) default 'A'               not null comment '상태.  A: 활성, D:삭제',
    created_at          datetime   default CURRENT_TIMESTAMP not null comment '등록일시',
    updated_at          datetime   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '수정일시',
    constraint FK_MEMBER_ROLE_MEMBER_ID
        foreign key (member_id) references member (id),
    constraint UK_MEMBER_ROLE_MEMBER_ID_ROLE
        unique (member_id, member_role)
)
    comment '회원 Role 정보';
INSERT INTO users.member_role (id, member_id, member_role, status, created_at, updated_at) VALUES (1, 1, 'ADMIN', 'A', '2024-09-27 09:43:20', '2024-09-27 09:43:20');
INSERT INTO users.member_role (id, member_id, member_role, status, created_at, updated_at) VALUES (2, 1, 'FREELANCER', 'A', '2024-09-27 09:43:20', '2024-09-27 09:43:20');
INSERT INTO users.member_role (id, member_id, member_role, status, created_at, updated_at) VALUES (3, 2, 'FREELANCER', 'A', '2024-09-29 05:32:53', '2024-09-29 05:32:53');
INSERT INTO users.member_role (id, member_id, member_role, status, created_at, updated_at) VALUES (4, 3, 'FREELANCER', 'A', '2024-09-29 05:32:53', '2024-09-29 05:32:53');
INSERT INTO users.member_role (id, member_id, member_role, status, created_at, updated_at) VALUES (5, 4, 'FREELANCER', 'D', '2024-09-29 05:32:53', '2024-09-29 05:32:53');







/**
    * products DB
    * point_info: 포인트 정보
 */
USE products;
drop table if exists point_info;
create table if not exists point_info
(
    id                  bigint auto_increment comment '포인트 정보 고유 ID'
        primary key,
    point_ratio            decimal(10, 3)                               not null comment '포임트 적립 비율',
    point_type         varchar(100)                         null comment '포인트 분류.  PURCHASE_POINT:포인트 구입...',
    status              varchar(1) default 'A'               not null comment '상태.  A: 활성, D:삭제',
    created_at          datetime   default CURRENT_TIMESTAMP not null comment '등록일시',
    updated_at          datetime   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '수정일시',
    constraint UK_POINT_INFO_POINT_TYPE
        unique (point_type)
)
    comment '포인트 정보';
INSERT INTO products.point_info (point_ratio, point_type, status) VALUES (1.000, 'PURCHASE_POINT', 'A');

