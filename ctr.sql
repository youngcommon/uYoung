DROP TABLE tb_user_info;
CREATE TABLE tb_user_info (
  id          INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  real_name   VARCHAR(10) COMMENT '真实姓名',
  nick_name   VARCHAR(10)        NOT NULL
  COMMENT '昵称',
  password    VARCHAR(50)        NOT NULL
  COMMENT '密码',
  email       VARCHAR(50)                 DEFAULT NULL
  COMMENT 'Email',
  gender      TINYINT(1)                  DEFAULT 1
  COMMENT '性别',
  avatar_url  VARCHAR(250)                DEFAULT NULL
  COMMENT '头像',
  phone       VARCHAR(20)                 DEFAULT NULL
  COMMENT '电话号码',
  address     INT(4)                      DEFAULT NULL
  COMMENT '城市ID',
  company     VARCHAR(40) COMMENT '公司',
  position    VARCHAR(20) COMMENT '职位',
  equipment   VARCHAR(20) COMMENT '设备/器材',
  style       TINYINT(2) COMMENT '风格',
  create_time TIMESTAMP          NULL
  COMMENT '创建时间',
  update_time TIMESTAMP          NULL     DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8;

DROP TABLE tb_mobile_info;
CREATE TABLE tb_mobile_info (
  id          INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  platform    TINYINT(1)         NOT NULL
  COMMENT '设备名称 ios android',
  version     VARCHAR(10)        NOT NULL
  COMMENT '版本',
  token       VARCHAR(128)       NOT NULL
  COMMENT '密码',
  imei        VARCHAR(250)                DEFAULT NULL
  COMMENT 'Email',
  user_id     INT                NOT NULL
  COMMENT '用户ID',
  validate    TINYINT(2)         NOT NULL
  COMMENT '是否有效',
  create_time TIMESTAMP          NULL
  COMMENT '创建时间',
  update_time TIMESTAMP          NULL     DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8;

DROP TABLE tb_activity_info;
CREATE TABLE tb_activity_info (
  id            INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title         VARCHAR(30)        NOT NULL
  COMMENT '主题',
  ori_user_id   INT                NOT NULL
  COMMENT '发起人',
  begin_time    TIMESTAMP          NULL
  COMMENT '开始时间',
  end_time      TIMESTAMP          NULL
  COMMENT '结束时间',
  address       VARCHAR(100)       NOT NULL
  COMMENT '活动地点',
  need_num      INT                NOT NULL
  COMMENT '要求参与人数',
  real_num      INT                NOT NULL
  COMMENT '实际参与人数',
  activity_type TINYINT(2)         NOT NULL
  COMMENT '活动类型',
  fee_type      TINYINT(1)         NOT NULL
  COMMENT '费用类型',
  description   VARCHAR(500) COMMENT '描述',
  status        TINYINT(1)         NOT NULL
  COMMENT '活动状态',
  create_time   TIMESTAMP          NULL
  COMMENT '创建时间',
  update_time   TIMESTAMP          NULL     DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8;
/*- 活动报名信息表-*/
DROP TABLE tb_activity_signup;
CREATE TABLE tb_activity_signup (
  id          INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  activity_id INT(1)             NOT NULL
  COMMENT '活动报名信息表',
  user_id     INT                NOT NULL
  COMMENT '用户ID',
  status      TINYINT(4)         NOT NULL
  COMMENT '状态',
  create_time TIMESTAMP          NULL
  COMMENT '创建时间',
  update_time TIMESTAMP          NULL     DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8;


/*- 相册表-*/
DROP TABLE tb_album_info;
CREATE TABLE tb_album_info (
  id              INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title           VARCHAR(20)        NOT NULL
  COMMENT '相册主题',
  create_user_id  INT                NOT NULL
  COMMENT '创建者ID',
  album_name      VARCHAR(10)        NOT NULL
  COMMENT '相册名称',
  album_url       VARCHAR(250)       NOT NULL
  COMMENT '相册地址',
  first_photo_url VARCHAR(250)       NOT NULL
  COMMENT '封面图片地址',
  create_time     TIMESTAMP          NULL
  COMMENT '创建时间',
  update_time     TIMESTAMP          NULL     DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8;

/*-图片表-*/
DROP TABLE tb_photo_info;
CREATE TABLE tb_photo_info (
  id             INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  photo_name     VARCHAR(10)        NOT NULL
  COMMENT '名称',
  photo_desc     VARCHAR(50) COMMENT '描述',
  photo_url      VARCHAR(250) COMMENT '地址',
  create_user_id INT                NOT NULL
  COMMENT '用户ID',
  exif_camera    VARCHAR(32) COMMENT '相机',
  exif_aperture  VARCHAR(10) COMMENT '光圈',
  exif_facus     VARCHAR(10) COMMENT '焦距',
  exif_shutter   VARCHAR(10) COMMENT '快门',
  exif_iso       VARCHAR(10) COMMENT '感光度',
  exif_other     VARCHAR(50) COMMENT '其他信息',
  view_count     INT                NOT NULL
  COMMENT '浏览数',
  like_count     INT                NOT NULL
  COMMENT '喜欢数',
  comment_count  INT                NULL
  COMMENT '评论数',
  create_time    TIMESTAMP          NULL
  COMMENT '创建时间',
  update_time    TIMESTAMP          NULL     DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8;

/*- 点赞表-*/
DROP TABLE tb_photo_like;
CREATE TABLE tb_photo_like (
  id          INT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  photo_id    INT                NOT NULL
  COMMENT '照片ID',
  user_id     INT                NOT NULL
  COMMENT '用户ID',
  create_time TIMESTAMP          NULL
  COMMENT '创建时间',
  update_time TIMESTAMP          NULL     DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8;

DROP TABLE tb_photo_info;
CREATE TABLE tb_photo_info (
  create_user_id INT       NOT NULL
  COMMENT '用户ID',
  exif_camera    VARCHAR(32) COMMENT '相机',
  update_time    TIMESTAMP NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8;






