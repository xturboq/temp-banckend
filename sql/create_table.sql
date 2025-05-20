# 数据库初始化
#
#

-- 创建库
create database if not exists temp_db;

-- 切换库
use temp_db;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    unionId      varchar(256)                           null comment '微信开放平台id',
    mpOpenId     varchar(256)                           null comment '公众号openId',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    index idx_unionId (unionId)
) comment '用户' collate = utf8mb4_unicode_ci;

CREATE TABLE `device_info`  (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `device_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备ID',
                                `set_temperature` decimal(5, 2) NULL DEFAULT NULL COMMENT '设定温度',
                                `current_temperature` decimal(5, 2) NULL DEFAULT NULL COMMENT '当前温度',
                                `channel1_time` int NULL DEFAULT NULL COMMENT '通道1时间(秒)',
                                `channel2_time` int NULL DEFAULT NULL COMMENT '通道2时间(秒)',
                                `channel3_time` int NULL DEFAULT NULL COMMENT '通道3时间(秒)',
                                `channel4_time` int NULL DEFAULT NULL COMMENT '通道4时间(秒)',
                                `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
                                PRIMARY KEY (`id`) USING BTREE,
                                INDEX `idx_device_time`(`device_id` ASC, `create_time` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '设备状态记录表' ROW_FORMAT = Dynamic;