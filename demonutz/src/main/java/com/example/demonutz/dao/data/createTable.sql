/**
团队支付售卖的权限
*/
CREATE TABLE sell_products (
	id BIGINT (20) NOT NULL AUTO_INCREMENT,
	service_type VARCHAR (64) NOT NULL DEFAULT '',
	COMMENT VARCHAR (128) NOT NULL DEFAULT '',
	activity TINYINT (1) NOT NULL DEFAULT '0' COMMENT 'wheatherisselling',
	start_time BIGINT (20) NOT NULL DEFAULT '0' COMMENT 'products start ',
	expired_time BIGINT (20) NOT NULL DEFAULT '0',
	category BIGINT (20) NOT NULL DEFAULT '0',
	description VARCHAR (1024) NOT NULL DEFAULT '',
	price DOUBLE (10, 2) NOT NULL DEFAULT '0.00',
	authority VARCHAR (64) NOT NULL DEFAULT '' COMMENT 'with get the product, you can get  the authority',
	auth_time BIGINT (20) NOT NULL DEFAULT '0',
	shop VARCHAR (64) NOT NULL DEFAULT '' COMMENT 'where sold the product',
	properties VARCHAR (1024) NOT NULL DEFAULT '',
	PRIMARY KEY (id),
	UNIQUE KEY `name` (service_type)
) ENGINE = INNODB DEFAULT charset = utf8mb4
/*BF=id policy=hash startid=1 remainid=1000000000000 assignidtype=MSB*/


/**
 订单系统
 */
CREATE TABLE common_payment(
id bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id key',
payment_id varchar(128) NOT NULL comment 'id of payment',
user_id varchar(128) comment 'user id of payment',
authority varchar(128) NOT NULL comment 'authority',
service_type varchar(64) comment 'service type of payment',
amount bigint(20) NOT NULL comment 'amount of payment',
base_fee double NOT NULL comment 'base of payment',
discount double NOT NULL comment 'discount of payment',
order_time bigint(20) NOT NULL comment 'order time of payment, not null',
pay_time bigint(20) DEFAULT NULL comment 'pay time of payment',
refund_time bigint(20) DEFAULT NULL comment 'refund time of payment',
cancel_time bigint(20) DEFAULT NULL comment 'cancel time of payment',
status tinyint(3) NOT NULL comment 'status of payment, not null.',
service_start_time bigint(20) DEFAULT NULL comment 'start time of payment service',
service_end_time bigint(20) DEFAULT NULL comment 'end time of payment service',
platform tinyint(3) NOT NULL comment 'platform of the payment.',
off_price double NOT NULL DEFAULT 0 comment 'cut off price',
invoice_id varchar(128) NOT NULL DEFAULT '' comment 'invoice id',
invoice_code varchar(128) NOT NULL DEFAULT '' comment 'invoice code',
business_id bigint(20) NOT NULL DEFAULT 0,
properties VARCHAR(1024) NOT NULL DEFAULT '',
db_create_time timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT 'create time of record, for db',
db_update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update time of record, for db',
PRIMARY KEY (`id`),
UNIQUE KEY `index_by_payment_id_user_id` (`user_id`, `payment_id`)
) ENGINE=INNODB DEFAULT charset=utf8mb4
/* BF=user_id policy=hash startid=1 remainid=1000000000000 assignidtype=MSB */
