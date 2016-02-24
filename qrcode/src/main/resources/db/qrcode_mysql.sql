CREATE TABLE `t_qrcode_account`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账号流水号',
  `user_name` varchar(256) NOT NULL DEFAULT '' COMMENT '账号，用于登录',
  `password` varchar(256) NOT NULL DEFAULT '' COMMENT '密码',
  `status` tinyint(1) DEFAULT 1 COMMENT '状态激活0 状态冻结1',
  `phone_number` varchar(256) DEFAULT '' COMMENT '手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='账号表';

CREATE TABLE `t_qrcode_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品流水号',
  `device_code` varchar(256) NOT NULL DEFAULT '' COMMENT '设备编码',
  `device_model` varchar(256) NOT NULL DEFAULT '' COMMENT '设备型号',
  `device_qrcode` varchar(256) NOT NULL DEFAULT '' COMMENT '二维码',
  `project_name` varchar(256) NOT NULL DEFAULT '' COMMENT '项目名称',
  `project_leader` varchar(256) NOT NULL DEFAULT '' COMMENT '项目经理',
  `project_others` varchar(256) NOT NULL DEFAULT '' COMMENT '项目成员,逗号分开',
  `debug_date` datetime   COMMENT '计划调试时间',
  `finish_date` datetime  COMMENT '计划验证时间',
  `contract_point` varchar(256) NOT NULL DEFAULT '' COMMENT '合同指标',
  `client_name` varchar(256) NOT NULL DEFAULT '' COMMENT '客户名称',
  `client_site` varchar(256) NOT NULL DEFAULT '' COMMENT '客户地址',
  `client` varchar(256) NOT NULL DEFAULT '' COMMENT '客户',
  `client_tel` varchar(256) NOT NULL DEFAULT '' COMMENT '客户电话',
  `activation_code` varchar(8) NOT NULL DEFAULT '' COMMENT '激活码',
  `activation_code2` varchar(8)  DEFAULT '' COMMENT '激活码2',
  `activation_code3` varchar(8)  DEFAULT '' COMMENT '激活码3',
  `activation_code4` varchar(8)  DEFAULT '' COMMENT '激活码4',
  `wlan` varchar(20) DEFAULT '' COMMENT '无线路由',
  `sim_phone` varchar(11)  DEFAULT '' COMMENT 'sim手机号',
  `sim_fee` varchar(20)  DEFAULT '' COMMENT 'sim资费',
  `bak` varchar(100)  DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='产品表';

CREATE TABLE `t_qrcode_service_type` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '服务类型流水号',
  `service_type` varchar(256) NOT NULL DEFAULT '' COMMENT '服务类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='服务类型表';

CREATE TABLE `t_qrcode_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '服务流水号',
  `service_type_id` int(2) NOT NULL  COMMENT '服务类型流水号',
  `device_code` varchar(256) NOT NULL DEFAULT '' COMMENT '设备编码',
  `service_name` varchar(256) NOT NULL DEFAULT '' COMMENT '服务人',
  `service_date` datetime COMMENT '服务时间',
  `service_location` varchar(256) NOT NULL DEFAULT '' COMMENT '服务位置',
  `service_content` varchar(300) NOT NULL DEFAULT '' COMMENT '服务内容',
  `bak` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='服务类型表';

CREATE TABLE `t_qrcode_permission` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '权限流水号',
  `permission_name` varchar(20) NOT NULL DEFAULT ''  COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='权限表';

CREATE TABLE `t_qrcode_notice` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '通告流水号',
  `notice` varchar(100) NOT NULL  COMMENT '通告',
  `add_date` datetime COMMENT '通告时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='通告表';

 insert into t_qrcode_device(device_code,device_model,device_qrcode,project_name,project_leader,project_others,contract_point,client_name,client_site,client,client_tel,activation_code,activation_code2,activation_code4,wlan,sim_phone,sim_fee,bak)values('4938c918f9a24d5cb2df10fd898b8246','device_110','4938c918f9a24d5cb2df10fd898b8246','device_007','lucy','lili,lilei','','clientA','','','','','','','','','','');
 
insert into t_qrcode_service(service_type_id,device_code,service_name,service_date,service_location,service_content,bak)values(1,'4938c918f9a24d5cb2df10fd898b8246','服务名称','2016-1-19','湖南长沙','售前服务','备注');