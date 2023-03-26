create table if not exists order_number
(
    id varchar
(
    36
) not null primary key comment '订单编号',
    remark varchar
(
    36
) not null comment '备注',
    #---------------------------------------------------------------------------------------------------------------------------
    create_by varchar
(
    250
) not null comment '创建人',
    create_time datetime not null comment '创建日期',
    update_by varchar
(
    250
) null comment '更新人',
    update_time datetime null comment '更新日期',
    delete_time datetime comment '删除时间',
    delete_by varchar
(
    250
) comment '删除人',
    delete_status boolean default true not null comment '删除状态：false 0 数据无效已删除,true 1 数据有效未删除'
    ) Engine = InnoDB
    character set utf8 comment '订单表';

select *
from order_number;