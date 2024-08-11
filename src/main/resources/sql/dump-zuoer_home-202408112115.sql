-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: zuoer_home
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `config_ad`
--

DROP TABLE IF EXISTS `config_ad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_ad` (
  `ad_id` bigint NOT NULL AUTO_INCREMENT,
  `ad_type` varchar(100) NOT NULL COMMENT '广告类型',
  `ad_source_type` int DEFAULT NULL COMMENT '资源类型（1：图片 2：视频）',
  `ad_source_url` text COMMENT '广告资源URL',
  `ad_link` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '链接地址',
  `status` int DEFAULT '1' COMMENT '0 未启用 1 启用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_ad`
--

LOCK TABLES `config_ad` WRITE;
/*!40000 ALTER TABLE `config_ad` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_ad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_fitment_category`
--

DROP TABLE IF EXISTS `config_fitment_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_fitment_category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '需求表、定稿平面...',
  `fitment_stage` int DEFAULT NULL COMMENT '装修阶段 1：设计 2：施工 3：维保',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='装修阶段类型配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_fitment_category`
--

LOCK TABLES `config_fitment_category` WRITE;
/*!40000 ALTER TABLE `config_fitment_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_fitment_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_house`
--

DROP TABLE IF EXISTS `config_house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_house` (
  `house_id` bigint NOT NULL AUTO_INCREMENT,
  `house_name` varchar(255) DEFAULT NULL COMMENT '房屋名',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `gps_lat_lon` varchar(100) DEFAULT NULL COMMENT '经纬度',
  `live_streaming_link` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '直播链接',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='房屋配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_house`
--

LOCK TABLES `config_house` WRITE;
/*!40000 ALTER TABLE `config_house` DISABLE KEYS */;
INSERT INTO `config_house` VALUES (1,'铂悦溪上99-501','江苏省无锡市滨湖区雪浪街道',NULL,NULL,NULL,NULL),(2,'太湖国际111-202','江苏省无锡市经开区',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `config_house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fitment_category_item`
--

DROP TABLE IF EXISTS `fitment_category_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fitment_category_item` (
  `item_id` bigint NOT NULL AUTO_INCREMENT,
  `house_id` bigint NOT NULL COMMENT '房屋id',
  `category_id` bigint NOT NULL COMMENT '文件类型id',
  `create_date` date DEFAULT NULL COMMENT '项目日期',
  `construction_desc` text COMMENT '施工说明',
  `suggestion` text COMMENT '建议',
  `check_date` date DEFAULT NULL COMMENT '项目检查日期',
  `check_desc` text COMMENT '检查说明',
  `create_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='装修类型项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fitment_category_item`
--

LOCK TABLES `fitment_category_item` WRITE;
/*!40000 ALTER TABLE `fitment_category_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `fitment_category_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house_user`
--

DROP TABLE IF EXISTS `house_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `house_user` (
  `house_user_id` bigint NOT NULL AUTO_INCREMENT,
  `house_id` bigint NOT NULL COMMENT '房屋id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `house_role` int DEFAULT '1' COMMENT '1：管理员 2：管家 3：业主',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`house_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='房屋用户关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house_user`
--

LOCK TABLES `house_user` WRITE;
/*!40000 ALTER TABLE `house_user` DISABLE KEYS */;
INSERT INTO `house_user` VALUES (1,1,1,1,NULL,NULL),(2,2,1,1,NULL,NULL);
/*!40000 ALTER TABLE `house_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_attachment`
--

DROP TABLE IF EXISTS `item_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_attachment` (
  `file_id` bigint NOT NULL AUTO_INCREMENT,
  `item_id` bigint DEFAULT NULL COMMENT '项目id',
  `is_check` int DEFAULT '0' COMMENT '0:不是检查 1:是检查',
  `original_file_name` varchar(255) DEFAULT NULL COMMENT '原始文件名',
  `save_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `save_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='装修项目文件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_attachment`
--

LOCK TABLES `item_attachment` WRITE;
/*!40000 ALTER TABLE `item_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_request`
--

DROP TABLE IF EXISTS `permission_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission_request` (
  `request_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_name` varchar(100) DEFAULT NULL COMMENT '申请角色名',
  `status` int DEFAULT '0' COMMENT '0：申请中 1：申请成功 2：拒绝',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号权限申请表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_request`
--

LOCK TABLES `permission_request` WRITE;
/*!40000 ALTER TABLE `permission_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_config` (
  `config_id` bigint NOT NULL AUTO_INCREMENT,
  `config_key` varchar(100) NOT NULL COMMENT '配置key',
  `config_value` varchar(100) NOT NULL COMMENT '配置值',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL COMMENT '角色名',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'admin',NULL,NULL),(2,'housekeeper',NULL,NULL),(3,'owner',NULL,NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `wechat_account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信号',
  `wechat_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信名',
  `wechat_avatar` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '微信头像',
  `open_id` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `last_login_time` datetime DEFAULT NULL COMMENT '上一次登录时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '0 审核中 1正常 2禁用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'xm19','xm','/xm.png','888888','15651716157',NULL,1,NULL,NULL),(2,'xm20','x2m','/xm.png','89998','13323322332',NULL,0,'2024-08-10 18:03:01','2024-08-10 18:03:01');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `user_role_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1,1,NULL,NULL);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'zuoer_home'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-11 21:15:55
