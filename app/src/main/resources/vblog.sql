/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : vblog

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-08-04 20:54:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for valentine_comments
-- ----------------------------
DROP TABLE IF EXISTS `valentine_comments`;
CREATE TABLE `valentine_comments` (
  `coid` int(10) NOT NULL AUTO_INCREMENT COMMENT 'comment表主键',
  `cid` int(10) NOT NULL COMMENT 'post表主键,关联字段',
  `created` datetime DEFAULT NULL COMMENT '评论生成时的GMT unix时间戳',
  `author` varchar(200) DEFAULT NULL COMMENT '评论作者',
  `mail` varchar(200) DEFAULT NULL COMMENT '评论者网址',
  `url` varchar(200) DEFAULT NULL COMMENT '评论者网址',
  `ip` varchar(64) DEFAULT NULL COMMENT '评论者ip地址',
  `agent` varchar(200) DEFAULT NULL COMMENT '评论者客户端',
  `text` text COMMENT '评论文字',
  `status` char(1) DEFAULT NULL COMMENT '评论状态',
  `parent` int(10) DEFAULT NULL COMMENT '父级评论',
  PRIMARY KEY (`coid`),
  KEY `comments_cid` (`cid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for valentine_contents
-- ----------------------------
DROP TABLE IF EXISTS `valentine_contents`;
CREATE TABLE `valentine_contents` (
  `cid` int(10) NOT NULL AUTO_INCREMENT COMMENT 'post表主键',
  `title` varchar(200) DEFAULT NULL COMMENT '内容标题',
  `slug` varchar(200) DEFAULT NULL COMMENT '内容缩略名',
  `created` datetime DEFAULT NULL COMMENT '内容生成时的GMT unix时间戳',
  `modified` datetime DEFAULT NULL COMMENT '内容更改时的GMT unix时间戳',
  `text` text COMMENT '内容文字',
  `authorId` int(10) NOT NULL COMMENT '内容所属用户id',
  `status` int(1) DEFAULT '1' COMMENT '内容状态',
  `allowComment` int(1) DEFAULT '2' COMMENT '是否允许评论',
  PRIMARY KEY (`cid`),
  KEY `post_slug` (`slug`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for valentine_metas
-- ----------------------------
DROP TABLE IF EXISTS `valentine_metas`;
CREATE TABLE `valentine_metas` (
  `mid` int(10) NOT NULL AUTO_INCREMENT COMMENT '项目主键',
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `slug` varchar(200) DEFAULT NULL COMMENT '项目缩略名',
  `type` varchar(32) DEFAULT NULL COMMENT '项目类型',
  `description` varchar(200) DEFAULT NULL COMMENT '选项描述',
  `count` int(10) DEFAULT '0' COMMENT '项目所属内容个数',
  PRIMARY KEY (`mid`),
  KEY `metas_slug` (`slug`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for valentine_relationships
-- ----------------------------
DROP TABLE IF EXISTS `valentine_relationships`;
CREATE TABLE `valentine_relationships` (
  `cid` int(10) NOT NULL COMMENT '内容主键',
  `mid` int(10) NOT NULL COMMENT '项目主键',
  PRIMARY KEY (`cid`,`mid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for valentine_users
-- ----------------------------
DROP TABLE IF EXISTS `valentine_users`;
CREATE TABLE `valentine_users` (
  `uid` int(10) NOT NULL AUTO_INCREMENT COMMENT 'user表主键',
  `name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `mail` varchar(200) DEFAULT NULL COMMENT '用户的邮箱',
  `created` datetime NOT NULL COMMENT '用户注册时的GMT unix时间戳',
  `activated` datetime NOT NULL COMMENT '最后活动时间',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `users_name` (`name`) USING BTREE,
  UNIQUE KEY `users_mail` (`mail`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
