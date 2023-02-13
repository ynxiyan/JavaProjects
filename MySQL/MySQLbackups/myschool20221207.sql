/*
 Navicat Premium Data Transfer

 Source Server         : MySQL 8.1.12
 Source Server Type    : MySQL
 Source Server Version : 100427
 Source Host           : localhost:3306
 Source Schema         : myschool

 Target Server Type    : MySQL
 Target Server Version : 100427
 File Encoding         : 65001

 Date: 07/12/2022 16:08:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `gradeID` int NOT NULL AUTO_INCREMENT COMMENT '年级编号',
  `gradeName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '年级名称',
  PRIMARY KEY (`gradeID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '年级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '阶段一');
INSERT INTO `grade` VALUES (2, '阶段二');
INSERT INTO `grade` VALUES (3, '阶段三');

-- ----------------------------
-- Table structure for phonelist
-- ----------------------------
DROP TABLE IF EXISTS `phonelist`;
CREATE TABLE `phonelist`  (
  `studentName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phonelist
-- ----------------------------
INSERT INTO `phonelist` VALUES ('郭靖', '13645667783');
INSERT INTO `phonelist` VALUES ('李文才', '13645667890');
INSERT INTO `phonelist` VALUES ('李斯文', '13645556793');
INSERT INTO `phonelist` VALUES ('张萍', '13642345112');
INSERT INTO `phonelist` VALUES ('韩秋洁', '13812344566');
INSERT INTO `phonelist` VALUES ('张秋丽', '13567893246');
INSERT INTO `phonelist` VALUES ('肖梅', '13563456721');
INSERT INTO `phonelist` VALUES ('秦洋', '13056434411');
INSERT INTO `phonelist` VALUES ('何睛睛', '13053445221');
INSERT INTO `phonelist` VALUES ('王宝宝', '15076552323');
INSERT INTO `phonelist` VALUES ('何小华', '13318877954');
INSERT INTO `phonelist` VALUES ('陈志强', '13689965430');
INSERT INTO `phonelist` VALUES ('李露露', '13685678854');

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result`  (
  `studentNo` int NOT NULL COMMENT '学号',
  `subjectNo` int NOT NULL COMMENT '课程编号',
  `examDate` datetime NOT NULL COMMENT '考试日期',
  `studentResult` int NOT NULL COMMENT '考试成绩',
  PRIMARY KEY (`studentNo`, `subjectNo`, `examDate`) USING BTREE,
  CONSTRAINT `fk_student_studentNo` FOREIGN KEY (`studentNo`) REFERENCES `student` (`studentNo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '成绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES (10000, 1, '2016-02-15 00:00:00', 71);
INSERT INTO `result` VALUES (10000, 1, '2016-02-17 00:00:00', 60);
INSERT INTO `result` VALUES (10001, 1, '2016-02-17 00:00:00', 46);
INSERT INTO `result` VALUES (10002, 1, '2016-02-17 00:00:00', 83);
INSERT INTO `result` VALUES (10003, 1, '2016-02-17 00:00:00', 60);
INSERT INTO `result` VALUES (10004, 1, '2016-02-17 00:00:00', 60);
INSERT INTO `result` VALUES (10005, 1, '2016-02-17 00:00:00', 95);
INSERT INTO `result` VALUES (10006, 1, '2016-02-17 00:00:00', 93);
INSERT INTO `result` VALUES (10007, 1, '2016-02-17 00:00:00', 23);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentNo` int NOT NULL AUTO_INCREMENT COMMENT '学号',
  `loginPwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `studentName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `gradeID` int NULL DEFAULT NULL COMMENT '年级编号',
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '地址不详' COMMENT '地址',
  `bornDate` datetime NULL DEFAULT NULL COMMENT '出生日期',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `identityCard` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  PRIMARY KEY (`studentNo`) USING BTREE,
  UNIQUE INDEX `identityCard`(`identityCard` ASC) USING BTREE,
  INDEX `index_studentName`(`studentName` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30013 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (10000, '123', '郭靖', '男', 1, '13645667783', '天津市河西区', '1990-09-08 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (10001, '123', '李文才', '男', 1, '13645667890', '地址不详', '1994-04-12 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (10002, '123', '李斯文', '男', 1, '13645556793', '河南洛阳', '1993-07-23 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (10003, '123', '张萍', '女', 1, '13642345112', '地址不详', '1995-06-10 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (10004, '123', '韩秋洁', '女', 1, '13812344566', '北京市海淀区', '1995-07-15 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (10005, '123', '张秋丽', '女', 1, '13567893246', '北京市东城区', '1994-01-17 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (10006, '123', '肖梅', '女', 1, '13563456721', '河北省石家庄市', '1991-02-17 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (10007, '123', '秦洋', '男', 1, '13056434411', '上海市卢湾区', '1992-04-18 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (10008, '123', '何睛睛', '女', 1, '13053445221', '广州市天河区', '1997-07-23 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (20000, '123', '王宝宝', '男', 2, '15076552323', '地址不详', '1996-06-05 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (20010, '123', '何小华', '女', 2, '13318877954', '地址不详', '1995-09-10 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (30011, '123', '陈志强', '男', 3, '13689965430', '地址不详', '1994-09-27 00:00:00', NULL, NULL);
INSERT INTO `student` VALUES (30012, '123', '李露露', '女', 3, '13685678854', '地址不详', '1992-09-27 00:00:00', NULL, NULL);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `subjectNo` int NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `subjectName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `classHour` int NULL DEFAULT NULL COMMENT '学时',
  `gradeID` int NULL DEFAULT NULL COMMENT '年级编号',
  PRIMARY KEY (`subjectNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '科目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, 'javaBasic', 220, 1);
INSERT INTO `subject` VALUES (2, 'html', 120, 1);
INSERT INTO `subject` VALUES (3, 'mysql', 120, 1);

SET FOREIGN_KEY_CHECKS = 1;
