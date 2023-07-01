create table "user"
(
    id bigint primary key auto_increment,           -- id, pk
    name varchar(255),                              -- name, 이름
    type varchar(10),                               -- type, 메신저 타입 (slack or telegram)
    token varchar(128),                             -- token, 메신저 토큰 정보
    channel varchar(255),                           -- channel, 메신저 채널 정보
    created_at timestamp default current_timestamp
);
create table "group"
(
    id bigint primary key auto_increment,           -- id, pk
    name varchar(255),                              -- name, 이름
    created_at timestamp default current_timestamp
);
create table "group_user"
(
    id bigint primary key auto_increment,           -- id, pk
    group_id bigint not null,                       -- group_id, 그룹 id
    user_id bigint not null,                        -- user_id, 사용자 id
    created_at timestamp default current_timestamp
);

