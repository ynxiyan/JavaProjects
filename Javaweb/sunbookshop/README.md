# [基于ElementUI和Vue.js的SUNBOOK图书后台管理系统（纯HTML、原生Java后端开发）](https://www.cnblogs.com/ynxiyan/p/17187949.html)

### 一、项目介绍

---

```markdown
- 使用element-ui、axios和Vue.js实现SUNBOOK的页面结构及网页请求
- 通过JSON传递请求与响应参数
- 在后端使用JdbcUtilsByDruid实现对数据的增加、删除、修改、查询等操作
```

使用到的技术：Ajax、Servlet、JDBC、Maven、element-ui、Vue.js

源码地址：

```http
https://github.com/ynxiyan/JavaProjects/tree/main/Javaweb/sunbookshop
```

### 二、权限

---

```markdown
- 管理员：
	* 添加用户信息、删除用户信息、修改用户信息、查看用户信息
	* 删除订单信息、修改订单信息、查看订单信息
	* 添加图书信息、删除图书信息、修改图书信息、查看图书信息
	* 添加出版社信息、删除出版社信息、修改出版社信息、查看出版社信息
	* 修改管理员密码
```

### 三、类图

---

#### 1.数据库E-R图

![image-20230307091533948](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140619519-553808430.png)

#### 2.后端结构

1. Model

   ![image-20230307093201040](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140618875-781523311.png)

2. Dao

   ![image-20230307093009975](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140618206-484160818.png)

3. Service

   ![image-20230307093321236](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140617429-1840093312.png)

4. Servlet

   ![image-20230307093428491](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140616612-858977482.png)

### 四、数据库恢复

---

```sql
/*
 Navicat Premium Data Transfer
 Source Server         : MySQL 8.1.12
 Source Server Type    : MySQL
 Source Server Version : 100427 (10.4.27-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : sunbookshop
 Target Server Type    : MySQL
 Target Server Version : 100427 (10.4.27-MariaDB)
 File Encoding         : 65001

 Date: 07/03/2023 13:56:56
*/
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '出版社序号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社名称',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `province_id` int NOT NULL COMMENT '省份序号',
  `city_id` int NOT NULL COMMENT '城市序号',
  `address` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '出版社地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES (1, '中华书局', '莫言', '18262383173', 1, 1, '');
INSERT INTO `author` VALUES (2, '上海古籍出版社', '菲茨杰拉德', '17191755918', 7, 40, '');
INSERT INTO `author` VALUES (3, '国家图书馆出版社', '唐德刚', '18864321082', 10, 81, '');
INSERT INTO `author` VALUES (4, '凤凰出版社', '裘沙', '15113054666', 1, 1, '');
INSERT INTO `author` VALUES (5, '黄山书社', '夏目漱石', '17252316978', 15, 142, '');
INSERT INTO `author` VALUES (6, '崇文书局', '余秋雨', '15488852781', 17, 177, '');
INSERT INTO `author` VALUES (7, '九州出版社', '唐师曾', '18708284409', 19, 208, '');
INSERT INTO `author` VALUES (8, '岳麓书社', '林达', '15362429986', 22, 253, '');
INSERT INTO `author` VALUES (9, '浙江古籍出版社', '金庸', '15349276211', 24, 288, '');
INSERT INTO `author` VALUES (10, '广陵出版社', '今何在', '15995187407', 28, 337, '');
INSERT INTO `author` VALUES (11, '科学出版社', '川端康成', '15995184368', 17, 177, '');
INSERT INTO `author` VALUES (12, '中国经济出版社', '屠孟超', '15235187407', 19, 208, '');
-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '图书序号',
  `book_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `author_id` int NOT NULL COMMENT '出版社序号',
  `type_id` int NOT NULL COMMENT '图书类型序号',
  `ISBN` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ISBN号码',
  `price` double NOT NULL DEFAULT 0 COMMENT '价格',
  `inventory` int NOT NULL COMMENT '图书库存',
  `in_flg` int NOT NULL DEFAULT 0 COMMENT '上架标志',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `author_books`(`author_id` ASC) USING BTREE,
  INDEX `type_books`(`type_id` ASC) USING BTREE,
  CONSTRAINT `author_books` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `type_books` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (1, '双城记', 7, 4, '97875633534578', 45.53, 12, 1);
INSERT INTO `books` VALUES (2, '窗边的小豆豆', 5, 1, '97875633538942', 34.76, 45, 1);
INSERT INTO `books` VALUES (3, '袁氏当国', 7, 3, '9787563353476', 17.09, 24, 1);
INSERT INTO `books` VALUES (4, '故事新编', 3, 3, '9787563350032', 23.87, 1, 1);
INSERT INTO `books` VALUES (5, '我是猫', 8, 2, '9787563351276', 34.76, 465, 1);
INSERT INTO `books` VALUES (6, '山居笔记', 3, 4, '9787563358967', 78.34, 23, 1);
INSERT INTO `books` VALUES (7, '我钻进了金字塔', 2, 1, '9787563352365', 26.87, 75, 1);
INSERT INTO `books` VALUES (8, '带一本书去巴黎', 10, 2, '9787563351265', 17.89, 32, 1);
INSERT INTO `books` VALUES (10, '悟空传', 2, 1, '9787563359865', 25.87, 13, 1);
INSERT INTO `books` VALUES (11, '伊豆的舞女', 9, 4, '9787563351534', 26.78, 456, 1);
INSERT INTO `books` VALUES (12, '堂吉诃德', 1, 2, '9787563352645', 27.87, 12, 1);
INSERT INTO `books` VALUES (15, '111', 4, 4, '44444444', 11, 11, 1);
-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int NOT NULL COMMENT '城市序号',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '城市名称',
  `province_id` int NOT NULL COMMENT '省份序号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `province_city`(`province_id` ASC) USING BTREE,
  CONSTRAINT `province_city` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, '北京市', 1);
INSERT INTO `city` VALUES (2, '天津市', 2);
INSERT INTO `city` VALUES (3, '上海市', 3);
INSERT INTO `city` VALUES (4, '重庆市', 4);
INSERT INTO `city` VALUES (5, '石家庄市', 5);
INSERT INTO `city` VALUES (6, '唐山市', 5);
INSERT INTO `city` VALUES (7, '秦皇岛市', 5);
INSERT INTO `city` VALUES (8, '邯郸市', 5);
INSERT INTO `city` VALUES (9, '邢台市', 5);
INSERT INTO `city` VALUES (10, '保定市', 5);
INSERT INTO `city` VALUES (11, '张家口市', 5);
INSERT INTO `city` VALUES (12, '承德市', 5);
INSERT INTO `city` VALUES (13, '沧州市', 5);
INSERT INTO `city` VALUES (14, '廊坊市', 5);
INSERT INTO `city` VALUES (15, '衡水市', 5);
INSERT INTO `city` VALUES (16, '太原市', 6);
INSERT INTO `city` VALUES (17, '大同市', 6);
INSERT INTO `city` VALUES (18, '阳泉市', 6);
INSERT INTO `city` VALUES (19, '长治市', 6);
INSERT INTO `city` VALUES (20, '晋城市', 6);
INSERT INTO `city` VALUES (21, '朔州市', 6);
INSERT INTO `city` VALUES (22, '晋中市', 6);
INSERT INTO `city` VALUES (23, '运城市', 6);
INSERT INTO `city` VALUES (24, '忻州市', 6);
INSERT INTO `city` VALUES (25, '临汾市', 6);
INSERT INTO `city` VALUES (26, '吕梁市', 6);
INSERT INTO `city` VALUES (27, '台北市', 7);
INSERT INTO `city` VALUES (28, '高雄市', 7);
INSERT INTO `city` VALUES (29, '基隆市', 7);
INSERT INTO `city` VALUES (30, '台中市', 7);
INSERT INTO `city` VALUES (31, '台南市', 7);
INSERT INTO `city` VALUES (32, '新竹市', 7);
INSERT INTO `city` VALUES (33, '嘉义市', 7);
INSERT INTO `city` VALUES (34, '台北县', 7);
INSERT INTO `city` VALUES (35, '宜兰县', 7);
INSERT INTO `city` VALUES (36, '桃园县', 7);
INSERT INTO `city` VALUES (37, '新竹县', 7);
INSERT INTO `city` VALUES (38, '苗栗县', 7);
INSERT INTO `city` VALUES (39, '台中县', 7);
INSERT INTO `city` VALUES (40, '彰化县', 7);
INSERT INTO `city` VALUES (41, '南投县', 7);
INSERT INTO `city` VALUES (42, '云林县', 7);
INSERT INTO `city` VALUES (43, '嘉义县', 7);
INSERT INTO `city` VALUES (44, '台南县', 7);
INSERT INTO `city` VALUES (45, '高雄县', 7);
INSERT INTO `city` VALUES (46, '屏东县', 7);
INSERT INTO `city` VALUES (47, '澎湖县', 7);
INSERT INTO `city` VALUES (48, '台东县', 7);
INSERT INTO `city` VALUES (49, '花莲县', 7);
INSERT INTO `city` VALUES (50, '沈阳市', 8);
INSERT INTO `city` VALUES (51, '大连市', 8);
INSERT INTO `city` VALUES (52, '鞍山市', 8);
INSERT INTO `city` VALUES (53, '抚顺市', 8);
INSERT INTO `city` VALUES (54, '本溪市', 8);
INSERT INTO `city` VALUES (55, '丹东市', 8);
INSERT INTO `city` VALUES (56, '锦州市', 8);
INSERT INTO `city` VALUES (57, '营口市', 8);
INSERT INTO `city` VALUES (58, '阜新市', 8);
INSERT INTO `city` VALUES (59, '辽阳市', 8);
INSERT INTO `city` VALUES (60, '盘锦市', 8);
INSERT INTO `city` VALUES (61, '铁岭市', 8);
INSERT INTO `city` VALUES (62, '朝阳市', 8);
INSERT INTO `city` VALUES (63, '葫芦岛市', 8);
INSERT INTO `city` VALUES (64, '长春市', 9);
INSERT INTO `city` VALUES (65, '吉林市', 9);
INSERT INTO `city` VALUES (66, '四平市', 9);
INSERT INTO `city` VALUES (67, '辽源市', 9);
INSERT INTO `city` VALUES (68, '通化市', 9);
INSERT INTO `city` VALUES (69, '白山市', 9);
INSERT INTO `city` VALUES (70, '松原市', 9);
INSERT INTO `city` VALUES (71, '白城市', 9);
INSERT INTO `city` VALUES (72, '延边朝鲜族自治州', 9);
INSERT INTO `city` VALUES (73, '哈尔滨市', 10);
INSERT INTO `city` VALUES (74, '齐齐哈尔市', 10);
INSERT INTO `city` VALUES (75, '鹤岗市', 10);
INSERT INTO `city` VALUES (76, '双鸭山市', 10);
INSERT INTO `city` VALUES (77, '鸡西市', 10);
INSERT INTO `city` VALUES (78, '大庆市', 10);
INSERT INTO `city` VALUES (79, '伊春市', 10);
INSERT INTO `city` VALUES (80, '牡丹江市', 10);
INSERT INTO `city` VALUES (81, '佳木斯市', 10);
INSERT INTO `city` VALUES (82, '七台河市', 10);
INSERT INTO `city` VALUES (83, '黑河市', 10);
INSERT INTO `city` VALUES (84, '绥化市', 10);
INSERT INTO `city` VALUES (85, '大兴安岭地区', 10);
INSERT INTO `city` VALUES (86, '南京市', 11);
INSERT INTO `city` VALUES (87, '无锡市', 11);
INSERT INTO `city` VALUES (88, '徐州市', 11);
INSERT INTO `city` VALUES (89, '常州市', 11);
INSERT INTO `city` VALUES (90, '苏州市', 11);
INSERT INTO `city` VALUES (91, '南通市', 11);
INSERT INTO `city` VALUES (92, '连云港市', 11);
INSERT INTO `city` VALUES (93, '淮安市', 11);
INSERT INTO `city` VALUES (94, '盐城市', 11);
INSERT INTO `city` VALUES (95, '扬州市', 11);
INSERT INTO `city` VALUES (96, '镇江市', 11);
INSERT INTO `city` VALUES (97, '泰州市', 11);
INSERT INTO `city` VALUES (98, '宿迁市', 11);
INSERT INTO `city` VALUES (99, '杭州市', 12);
INSERT INTO `city` VALUES (100, '宁波市', 12);
INSERT INTO `city` VALUES (101, '温州市', 12);
INSERT INTO `city` VALUES (102, '嘉兴市', 12);
INSERT INTO `city` VALUES (103, '湖州市', 12);
INSERT INTO `city` VALUES (104, '绍兴市', 12);
INSERT INTO `city` VALUES (105, '金华市', 12);
INSERT INTO `city` VALUES (106, '衢州市', 12);
INSERT INTO `city` VALUES (107, '舟山市', 12);
INSERT INTO `city` VALUES (108, '台州市', 12);
INSERT INTO `city` VALUES (109, '丽水市', 12);
INSERT INTO `city` VALUES (110, '合肥市', 13);
INSERT INTO `city` VALUES (111, '芜湖市', 13);
INSERT INTO `city` VALUES (112, '蚌埠市', 13);
INSERT INTO `city` VALUES (113, '淮南市', 13);
INSERT INTO `city` VALUES (114, '马鞍山市', 13);
INSERT INTO `city` VALUES (115, '淮北市', 13);
INSERT INTO `city` VALUES (116, '铜陵市', 13);
INSERT INTO `city` VALUES (117, '安庆市', 13);
INSERT INTO `city` VALUES (118, '黄山市', 13);
INSERT INTO `city` VALUES (119, '滁州市', 13);
INSERT INTO `city` VALUES (120, '阜阳市', 13);
INSERT INTO `city` VALUES (121, '宿州市', 13);
INSERT INTO `city` VALUES (122, '巢湖市', 13);
INSERT INTO `city` VALUES (123, '六安市', 13);
INSERT INTO `city` VALUES (124, '亳州市', 13);
INSERT INTO `city` VALUES (125, '池州市', 13);
INSERT INTO `city` VALUES (126, '宣城市', 13);
INSERT INTO `city` VALUES (127, '福州市', 14);
INSERT INTO `city` VALUES (128, '厦门市', 14);
INSERT INTO `city` VALUES (129, '莆田市', 14);
INSERT INTO `city` VALUES (130, '三明市', 14);
INSERT INTO `city` VALUES (131, '泉州市', 14);
INSERT INTO `city` VALUES (132, '漳州市', 14);
INSERT INTO `city` VALUES (133, '南平市', 14);
INSERT INTO `city` VALUES (134, '龙岩市', 14);
INSERT INTO `city` VALUES (135, '宁德市', 14);
INSERT INTO `city` VALUES (136, '南昌市', 15);
INSERT INTO `city` VALUES (137, '景德镇市', 15);
INSERT INTO `city` VALUES (138, '萍乡市', 15);
INSERT INTO `city` VALUES (139, '九江市', 15);
INSERT INTO `city` VALUES (140, '新余市', 15);
INSERT INTO `city` VALUES (141, '鹰潭市', 15);
INSERT INTO `city` VALUES (142, '赣州市', 15);
INSERT INTO `city` VALUES (143, '吉安市', 15);
INSERT INTO `city` VALUES (144, '宜春市', 15);
INSERT INTO `city` VALUES (145, '抚州市', 15);
INSERT INTO `city` VALUES (146, '上饶市', 15);
INSERT INTO `city` VALUES (147, '济南市', 16);
INSERT INTO `city` VALUES (148, '青岛市', 16);
INSERT INTO `city` VALUES (149, '淄博市', 16);
INSERT INTO `city` VALUES (150, '枣庄市', 16);
INSERT INTO `city` VALUES (151, '东营市', 16);
INSERT INTO `city` VALUES (152, '烟台市', 16);
INSERT INTO `city` VALUES (153, '潍坊市', 16);
INSERT INTO `city` VALUES (154, '济宁市', 16);
INSERT INTO `city` VALUES (155, '泰安市', 16);
INSERT INTO `city` VALUES (156, '威海市', 16);
INSERT INTO `city` VALUES (157, '日照市', 16);
INSERT INTO `city` VALUES (158, '莱芜市', 16);
INSERT INTO `city` VALUES (159, '临沂市', 16);
INSERT INTO `city` VALUES (160, '德州市', 16);
INSERT INTO `city` VALUES (161, '聊城市', 16);
INSERT INTO `city` VALUES (162, '滨州市', 16);
INSERT INTO `city` VALUES (163, '菏泽市', 16);
INSERT INTO `city` VALUES (164, '郑州市', 17);
INSERT INTO `city` VALUES (165, '开封市', 17);
INSERT INTO `city` VALUES (166, '洛阳市', 17);
INSERT INTO `city` VALUES (167, '平顶山市', 17);
INSERT INTO `city` VALUES (168, '安阳市', 17);
INSERT INTO `city` VALUES (169, '鹤壁市', 17);
INSERT INTO `city` VALUES (170, '新乡市', 17);
INSERT INTO `city` VALUES (171, '焦作市', 17);
INSERT INTO `city` VALUES (172, '濮阳市', 17);
INSERT INTO `city` VALUES (173, '许昌市', 17);
INSERT INTO `city` VALUES (174, '漯河市', 17);
INSERT INTO `city` VALUES (175, '三门峡市', 17);
INSERT INTO `city` VALUES (176, '南阳市', 17);
INSERT INTO `city` VALUES (177, '商丘市', 17);
INSERT INTO `city` VALUES (178, '信阳市', 17);
INSERT INTO `city` VALUES (179, '周口市', 17);
INSERT INTO `city` VALUES (180, '驻马店市', 17);
INSERT INTO `city` VALUES (181, '济源市', 17);
INSERT INTO `city` VALUES (182, '武汉市', 18);
INSERT INTO `city` VALUES (183, '黄石市', 18);
INSERT INTO `city` VALUES (184, '十堰市', 18);
INSERT INTO `city` VALUES (185, '荆州市', 18);
INSERT INTO `city` VALUES (186, '宜昌市', 18);
INSERT INTO `city` VALUES (187, '襄樊市', 18);
INSERT INTO `city` VALUES (188, '鄂州市', 18);
INSERT INTO `city` VALUES (189, '荆门市', 18);
INSERT INTO `city` VALUES (190, '孝感市', 18);
INSERT INTO `city` VALUES (191, '黄冈市', 18);
INSERT INTO `city` VALUES (192, '咸宁市', 18);
INSERT INTO `city` VALUES (193, '随州市', 18);
INSERT INTO `city` VALUES (194, '仙桃市', 18);
INSERT INTO `city` VALUES (195, '天门市', 18);
INSERT INTO `city` VALUES (196, '潜江市', 18);
INSERT INTO `city` VALUES (197, '神农架林区', 18);
INSERT INTO `city` VALUES (198, '恩施土家族苗族自治州', 18);
INSERT INTO `city` VALUES (199, '长沙市', 19);
INSERT INTO `city` VALUES (200, '株洲市', 19);
INSERT INTO `city` VALUES (201, '湘潭市', 19);
INSERT INTO `city` VALUES (202, '衡阳市', 19);
INSERT INTO `city` VALUES (203, '邵阳市', 19);
INSERT INTO `city` VALUES (204, '岳阳市', 19);
INSERT INTO `city` VALUES (205, '常德市', 19);
INSERT INTO `city` VALUES (206, '张家界市', 19);
INSERT INTO `city` VALUES (207, '益阳市', 19);
INSERT INTO `city` VALUES (208, '郴州市', 19);
INSERT INTO `city` VALUES (209, '永州市', 19);
INSERT INTO `city` VALUES (210, '怀化市', 19);
INSERT INTO `city` VALUES (211, '娄底市', 19);
INSERT INTO `city` VALUES (212, '湘西土家族苗族自治州', 19);
INSERT INTO `city` VALUES (213, '广州市', 20);
INSERT INTO `city` VALUES (214, '深圳市', 20);
INSERT INTO `city` VALUES (215, '珠海市', 20);
INSERT INTO `city` VALUES (216, '汕头市', 20);
INSERT INTO `city` VALUES (217, '韶关市', 20);
INSERT INTO `city` VALUES (218, '佛山市', 20);
INSERT INTO `city` VALUES (219, '江门市', 20);
INSERT INTO `city` VALUES (220, '湛江市', 20);
INSERT INTO `city` VALUES (221, '茂名市', 20);
INSERT INTO `city` VALUES (222, '肇庆市', 20);
INSERT INTO `city` VALUES (223, '惠州市', 20);
INSERT INTO `city` VALUES (224, '梅州市', 20);
INSERT INTO `city` VALUES (225, '汕尾市', 20);
INSERT INTO `city` VALUES (226, '河源市', 20);
INSERT INTO `city` VALUES (227, '阳江市', 20);
INSERT INTO `city` VALUES (228, '清远市', 20);
INSERT INTO `city` VALUES (229, '东莞市', 20);
INSERT INTO `city` VALUES (230, '中山市', 20);
INSERT INTO `city` VALUES (231, '潮州市', 20);
INSERT INTO `city` VALUES (232, '揭阳市', 20);
INSERT INTO `city` VALUES (233, '云浮市', 20);
INSERT INTO `city` VALUES (234, '兰州市', 21);
INSERT INTO `city` VALUES (235, '金昌市', 21);
INSERT INTO `city` VALUES (236, '白银市', 21);
INSERT INTO `city` VALUES (237, '天水市', 21);
INSERT INTO `city` VALUES (238, '嘉峪关市', 21);
INSERT INTO `city` VALUES (239, '武威市', 21);
INSERT INTO `city` VALUES (240, '张掖市', 21);
INSERT INTO `city` VALUES (241, '平凉市', 21);
INSERT INTO `city` VALUES (242, '酒泉市', 21);
INSERT INTO `city` VALUES (243, '庆阳市', 21);
INSERT INTO `city` VALUES (244, '定西市', 21);
INSERT INTO `city` VALUES (245, '陇南市', 21);
INSERT INTO `city` VALUES (246, '临夏回族自治州', 21);
INSERT INTO `city` VALUES (247, '甘南藏族自治州', 21);
INSERT INTO `city` VALUES (248, '成都市', 22);
INSERT INTO `city` VALUES (249, '自贡市', 22);
INSERT INTO `city` VALUES (250, '攀枝花市', 22);
INSERT INTO `city` VALUES (251, '泸州市', 22);
INSERT INTO `city` VALUES (252, '德阳市', 22);
INSERT INTO `city` VALUES (253, '绵阳市', 22);
INSERT INTO `city` VALUES (254, '广元市', 22);
INSERT INTO `city` VALUES (255, '遂宁市', 22);
INSERT INTO `city` VALUES (256, '内江市', 22);
INSERT INTO `city` VALUES (257, '乐山市', 22);
INSERT INTO `city` VALUES (258, '南充市', 22);
INSERT INTO `city` VALUES (259, '眉山市', 22);
INSERT INTO `city` VALUES (260, '宜宾市', 22);
INSERT INTO `city` VALUES (261, '广安市', 22);
INSERT INTO `city` VALUES (262, '达州市', 22);
INSERT INTO `city` VALUES (263, '雅安市', 22);
INSERT INTO `city` VALUES (264, '巴中市', 22);
INSERT INTO `city` VALUES (265, '资阳市', 22);
INSERT INTO `city` VALUES (266, '阿坝藏族羌族自治州', 22);
INSERT INTO `city` VALUES (267, '甘孜藏族自治州', 22);
INSERT INTO `city` VALUES (268, '凉山彝族自治州', 22);
INSERT INTO `city` VALUES (269, '贵阳市', 23);
INSERT INTO `city` VALUES (270, '六盘水市', 23);
INSERT INTO `city` VALUES (271, '遵义市', 23);
INSERT INTO `city` VALUES (272, '安顺市', 23);
INSERT INTO `city` VALUES (273, '铜仁地区', 23);
INSERT INTO `city` VALUES (274, '毕节地区', 23);
INSERT INTO `city` VALUES (275, '黔西南布依族苗族自治州', 23);
INSERT INTO `city` VALUES (276, '黔东南苗族侗族自治州', 23);
INSERT INTO `city` VALUES (277, '黔南布依族苗族自治州', 23);
INSERT INTO `city` VALUES (278, '海口市', 24);
INSERT INTO `city` VALUES (279, '三亚市', 24);
INSERT INTO `city` VALUES (280, '五指山市', 24);
INSERT INTO `city` VALUES (281, '琼海市', 24);
INSERT INTO `city` VALUES (282, '儋州市', 24);
INSERT INTO `city` VALUES (283, '文昌市', 24);
INSERT INTO `city` VALUES (284, '万宁市', 24);
INSERT INTO `city` VALUES (285, '东方市', 24);
INSERT INTO `city` VALUES (286, '澄迈县', 24);
INSERT INTO `city` VALUES (287, '定安县', 24);
INSERT INTO `city` VALUES (288, '屯昌县', 24);
INSERT INTO `city` VALUES (289, '临高县', 24);
INSERT INTO `city` VALUES (290, '白沙黎族自治县', 24);
INSERT INTO `city` VALUES (291, '昌江黎族自治县', 24);
INSERT INTO `city` VALUES (292, '乐东黎族自治县', 24);
INSERT INTO `city` VALUES (293, '陵水黎族自治县', 24);
INSERT INTO `city` VALUES (294, '保亭黎族苗族自治县', 24);
INSERT INTO `city` VALUES (295, '琼中黎族苗族自治县', 24);
INSERT INTO `city` VALUES (296, '昆明市', 25);
INSERT INTO `city` VALUES (297, '曲靖市', 25);
INSERT INTO `city` VALUES (298, '玉溪市', 25);
INSERT INTO `city` VALUES (299, '保山市', 25);
INSERT INTO `city` VALUES (300, '昭通市', 25);
INSERT INTO `city` VALUES (301, '丽江市', 25);
INSERT INTO `city` VALUES (302, '思茅市', 25);
INSERT INTO `city` VALUES (303, '临沧市', 25);
INSERT INTO `city` VALUES (304, '文山壮族苗族自治州', 25);
INSERT INTO `city` VALUES (305, '红河哈尼族彝族自治州', 25);
INSERT INTO `city` VALUES (306, '西双版纳傣族自治州', 25);
INSERT INTO `city` VALUES (307, '楚雄彝族自治州', 25);
INSERT INTO `city` VALUES (308, '大理白族自治州', 25);
INSERT INTO `city` VALUES (309, '德宏傣族景颇族自治州', 25);
INSERT INTO `city` VALUES (310, '怒江傈傈族自治州', 25);
INSERT INTO `city` VALUES (311, '迪庆藏族自治州', 25);
INSERT INTO `city` VALUES (312, '西宁市', 26);
INSERT INTO `city` VALUES (313, '海东地区', 26);
INSERT INTO `city` VALUES (314, '海北藏族自治州', 26);
INSERT INTO `city` VALUES (315, '黄南藏族自治州', 26);
INSERT INTO `city` VALUES (316, '海南藏族自治州', 26);
INSERT INTO `city` VALUES (317, '果洛藏族自治州', 26);
INSERT INTO `city` VALUES (318, '玉树藏族自治州', 26);
INSERT INTO `city` VALUES (319, '海西蒙古族藏族自治州', 26);
INSERT INTO `city` VALUES (320, '西安市', 27);
INSERT INTO `city` VALUES (321, '铜川市', 27);
INSERT INTO `city` VALUES (322, '宝鸡市', 27);
INSERT INTO `city` VALUES (323, '咸阳市', 27);
INSERT INTO `city` VALUES (324, '渭南市', 27);
INSERT INTO `city` VALUES (325, '延安市', 27);
INSERT INTO `city` VALUES (326, '汉中市', 27);
INSERT INTO `city` VALUES (327, '榆林市', 27);
INSERT INTO `city` VALUES (328, '安康市', 27);
INSERT INTO `city` VALUES (329, '商洛市', 27);
INSERT INTO `city` VALUES (330, '南宁市', 28);
INSERT INTO `city` VALUES (331, '柳州市', 28);
INSERT INTO `city` VALUES (332, '桂林市', 28);
INSERT INTO `city` VALUES (333, '梧州市', 28);
INSERT INTO `city` VALUES (334, '北海市', 28);
INSERT INTO `city` VALUES (335, '防城港市', 28);
INSERT INTO `city` VALUES (336, '钦州市', 28);
INSERT INTO `city` VALUES (337, '贵港市', 28);
INSERT INTO `city` VALUES (338, '玉林市', 28);
INSERT INTO `city` VALUES (339, '百色市', 28);
INSERT INTO `city` VALUES (340, '贺州市', 28);
INSERT INTO `city` VALUES (341, '河池市', 28);
INSERT INTO `city` VALUES (342, '来宾市', 28);
INSERT INTO `city` VALUES (343, '崇左市', 28);
INSERT INTO `city` VALUES (344, '拉萨市', 29);
INSERT INTO `city` VALUES (345, '那曲地区', 29);
INSERT INTO `city` VALUES (346, '昌都地区', 29);
INSERT INTO `city` VALUES (347, '山南地区', 29);
INSERT INTO `city` VALUES (348, '日喀则地区', 29);
INSERT INTO `city` VALUES (349, '阿里地区', 29);
INSERT INTO `city` VALUES (350, '林芝地区', 29);
INSERT INTO `city` VALUES (351, '银川市', 30);
INSERT INTO `city` VALUES (352, '石嘴山市', 30);
INSERT INTO `city` VALUES (353, '吴忠市', 30);
INSERT INTO `city` VALUES (354, '固原市', 30);
INSERT INTO `city` VALUES (355, '中卫市', 30);
INSERT INTO `city` VALUES (356, '乌鲁木齐市', 31);
INSERT INTO `city` VALUES (357, '克拉玛依市', 31);
INSERT INTO `city` VALUES (358, '石河子市', 31);
INSERT INTO `city` VALUES (359, '阿拉尔市', 31);
INSERT INTO `city` VALUES (360, '图木舒克市', 31);
INSERT INTO `city` VALUES (361, '五家渠市', 31);
INSERT INTO `city` VALUES (362, '吐鲁番市', 31);
INSERT INTO `city` VALUES (363, '阿克苏市', 31);
INSERT INTO `city` VALUES (364, '喀什市', 31);
INSERT INTO `city` VALUES (365, '哈密市', 31);
INSERT INTO `city` VALUES (366, '和田市', 31);
INSERT INTO `city` VALUES (367, '阿图什市', 31);
INSERT INTO `city` VALUES (368, '库尔勒市', 31);
INSERT INTO `city` VALUES (369, '昌吉市', 31);
INSERT INTO `city` VALUES (370, '阜康市', 31);
INSERT INTO `city` VALUES (371, '米泉市', 31);
INSERT INTO `city` VALUES (372, '博乐市', 31);
INSERT INTO `city` VALUES (373, '伊宁市', 31);
INSERT INTO `city` VALUES (374, '奎屯市', 31);
INSERT INTO `city` VALUES (375, '塔城市', 31);
INSERT INTO `city` VALUES (376, '乌苏市', 31);
INSERT INTO `city` VALUES (377, '阿勒泰市', 31);
INSERT INTO `city` VALUES (378, '呼和浩特市', 32);
INSERT INTO `city` VALUES (379, '包头市', 32);
INSERT INTO `city` VALUES (380, '乌海市', 32);
INSERT INTO `city` VALUES (381, '赤峰市', 32);
INSERT INTO `city` VALUES (382, '通辽市', 32);
INSERT INTO `city` VALUES (383, '鄂尔多斯市', 32);
INSERT INTO `city` VALUES (384, '呼伦贝尔市', 32);
INSERT INTO `city` VALUES (385, '巴彦淖尔市', 32);
INSERT INTO `city` VALUES (386, '乌兰察布市', 32);
INSERT INTO `city` VALUES (387, '锡林郭勒盟', 32);
INSERT INTO `city` VALUES (388, '兴安盟', 32);
INSERT INTO `city` VALUES (389, '阿拉善盟', 32);
INSERT INTO `city` VALUES (390, '澳门特别行政区', 33);
INSERT INTO `city` VALUES (391, '香港特别行政区', 34);
-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员序号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;
-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES (1, 'admin', '123456');
-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单序号',
  `book_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `quantity` int NOT NULL COMMENT '购买数量',
  `price` double NOT NULL COMMENT '单价',
  `total` double NOT NULL COMMENT '合计',
  `user_id` int NOT NULL COMMENT '用户序号',
  `purchase_time` datetime NOT NULL COMMENT '购买时间',
  `out_fig` int NULL DEFAULT NULL COMMENT '出库标志',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_order`(`user_id` ASC) USING BTREE,
  CONSTRAINT `user_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (2, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (47, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (48, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (49, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (50, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 0);
INSERT INTO `orders` VALUES (51, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 0);
INSERT INTO `orders` VALUES (52, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (53, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 0);
INSERT INTO `orders` VALUES (54, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (55, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (56, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (57, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (58, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (59, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (60, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (61, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (62, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (63, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (64, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 0);
INSERT INTO `orders` VALUES (65, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 0);
INSERT INTO `orders` VALUES (66, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (67, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (69, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders` VALUES (70, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders` VALUES (71, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `id` int NOT NULL COMMENT '省份序号',
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES (1, '北京市');
INSERT INTO `province` VALUES (2, '天津市');
INSERT INTO `province` VALUES (3, '上海市');
INSERT INTO `province` VALUES (4, '重庆市');
INSERT INTO `province` VALUES (5, '河北省');
INSERT INTO `province` VALUES (6, '山西省');
INSERT INTO `province` VALUES (7, '台湾省');
INSERT INTO `province` VALUES (8, '辽宁省');
INSERT INTO `province` VALUES (9, '吉林省');
INSERT INTO `province` VALUES (10, '黑龙江省');
INSERT INTO `province` VALUES (11, '江苏省');
INSERT INTO `province` VALUES (12, '浙江省');
INSERT INTO `province` VALUES (13, '安徽省');
INSERT INTO `province` VALUES (14, '福建省');
INSERT INTO `province` VALUES (15, '江西省');
INSERT INTO `province` VALUES (16, '山东省');
INSERT INTO `province` VALUES (17, '河南省');
INSERT INTO `province` VALUES (18, '湖北省');
INSERT INTO `province` VALUES (19, '湖南省');
INSERT INTO `province` VALUES (20, '广东省');
INSERT INTO `province` VALUES (21, '甘肃省');
INSERT INTO `province` VALUES (22, '四川省');
INSERT INTO `province` VALUES (23, '贵州省');
INSERT INTO `province` VALUES (24, '海南省');
INSERT INTO `province` VALUES (25, '云南省');
INSERT INTO `province` VALUES (26, '青海省');
INSERT INTO `province` VALUES (27, '陕西省');
INSERT INTO `province` VALUES (28, '广西壮族自治区');
INSERT INTO `province` VALUES (29, '西藏自治区');
INSERT INTO `province` VALUES (30, '宁夏回族自治区');
INSERT INTO `province` VALUES (31, '新疆维吾尔自治区');
INSERT INTO `province` VALUES (32, '内蒙古自治区');
INSERT INTO `province` VALUES (33, '澳门特别行政区');
INSERT INTO `province` VALUES (34, '香港特别行政区');
-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '图书类型序号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '白话小说');
INSERT INTO `type` VALUES (2, '古代名著');
INSERT INTO `type` VALUES (3, '日常杂谈');
INSERT INTO `type` VALUES (4, '神话传说');
INSERT INTO `type` VALUES (5, '马克思主义');
INSERT INTO `type` VALUES (6, '哲学');
INSERT INTO `type` VALUES (7, '宗教');
INSERT INTO `type` VALUES (8, '社会科学');
INSERT INTO `type` VALUES (9, '政治');
INSERT INTO `type` VALUES (10, '法律');
INSERT INTO `type` VALUES (11, '军事');
INSERT INTO `type` VALUES (12, '经济');
INSERT INTO `type` VALUES (13, '文化');
INSERT INTO `type` VALUES (14, '语言');
INSERT INTO `type` VALUES (15, '文学');
INSERT INTO `type` VALUES (16, '艺术');
INSERT INTO `type` VALUES (17, '历史');
INSERT INTO `type` VALUES (18, '地理');
INSERT INTO `type` VALUES (19, '自然科学');
INSERT INTO `type` VALUES (20, '数理科学');
INSERT INTO `type` VALUES (21, '天文学');
INSERT INTO `type` VALUES (22, '地球科学');
INSERT INTO `type` VALUES (23, '生物科学');
INSERT INTO `type` VALUES (24, '医药');
INSERT INTO `type` VALUES (25, '农业科学');
INSERT INTO `type` VALUES (26, '工业技术');
INSERT INTO `type` VALUES (27, '交通运输');
INSERT INTO `type` VALUES (28, '航空、航天');
INSERT INTO `type` VALUES (29, '环境科学');
INSERT INTO `type` VALUES (30, '综合性图书');
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户序号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `province_id` int NOT NULL COMMENT '省份序号',
  `city_id` int NOT NULL COMMENT '城市序号',
  `address` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `city_user`(`city_id` ASC) USING BTREE,
  INDEX `province_user`(`province_id` ASC) USING BTREE,
  CONSTRAINT `city_user` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `province_user` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'tl', '3453564', '男', '18864321082', '596688434@qq.com', 10, 81, NULL);
INSERT INTO `user` VALUES (4, 'fw', '78567878', '女', '15113054666', '596538749@qq.com', 1, 1, '1111');
INSERT INTO `user` VALUES (5, 'sqw', '8685654', '女', '17252316978', '596368934@qq.com', 15, 142, '');
INSERT INTO `user` VALUES (6, 'cc', '0000', '男', '15488852781', '593689534@qq.com', 17, 177, NULL);
INSERT INTO `user` VALUES (7, 'ljm', '4656745', '女', '18708284409', '593587434@qq.com', 19, 208, NULL);
INSERT INTO `user` VALUES (8, 'dql', '8658678', '女', '15362429986', '5964678434@qq.com', 22, 32, NULL);
INSERT INTO `user` VALUES (9, 'xq', '234242', '男', '15349276211', '125518434@qq.com', 24, 288, NULL);
INSERT INTO `user` VALUES (10, 'xy', '7467456', '女', '15995187407', '596518234@qq.com', 28, 337, NULL);
-- ----------------------------
-- Function structure for generate_boyname
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_boyname`;
delimiter ;;
CREATE FUNCTION `generate_boyname`()
 RETURNS varchar(2) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    declare name varchar(2) default '';
    declare i int default 0;
    declare n int default 0;    
    set n = ceiling(rand()*2);    
    while i < n
    do
       set name = concat(name, elt(ceiling(rand()*1000)%200+1,"辰","逸","雨","泽","瑾","瑜","圣","杰","楷","瑞","浩","南","卡","思","旭","尧","俊","楠","天","磊","烨","伟","世","博","昊","哲","瀚","冠","明","辉","金","傲","越","材","霖","朋","健","柏","鸿","涛","懿","轩","鹏","煊","彬","益","弘","宸","苑","君","文","鑫","睿","渊","达","强","晓","啸","风","桦","驰","松","德","振","豪","鹤","绍","鼎","寒","志","靖","琪","擎","宇","国","龙","厉","诚","翰","超","晟","棋","沙","欧","智","劲","祺","皓","新","泰","佑","致","韵","舟","玮","伦","然","炫","星","野","雪","嘉","煜","城","昌","建","平","炎","峻","熙","洋","荣","展","远","图","翱","依","海","震","康","锋","崇","杭","运","贤","元","盛","江","春","凯","胜","福","来","聚","原","才","邦","庆","生","月","阳","岩","浪","晋","玄","欢","恒","羽","恩","青","余","波","修","永","润","若","信","勋","琦","晨","杉","畅","凡","翎","承","淘","茂","石","鉴","尚","唯","仁","敬","玉","全","帆","影","云","观","雷","常","柯","倚","向","镇","言","耀","耿","古","闻","名","东","悠","昆","宝","复","乔","柳","林","均"));
       set i = i + 1;
    end while;
    return name;
end
;;
delimiter ;
-- ----------------------------
-- Function structure for generate_brithplace
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_brithplace`;
delimiter ;;
CREATE FUNCTION `generate_brithplace`()
 RETURNS varchar(32) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    return  elt(ceiling(rand()*100)%34+1,"河北省","山西省","辽宁省","吉林省","黑龙省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","海南省","四川省","贵州省 ","云南省","陕西省","甘肃省","青海省","台湾省","北京市","上海市","重庆市","天津市","广西","宁夏","西藏","新疆","内蒙古","香港","澳门");
end
;;
delimiter ;
-- ----------------------------
-- Function structure for generate_girlname
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_girlname`;
delimiter ;;
CREATE FUNCTION `generate_girlname`()
 RETURNS varchar(2) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    declare name varchar(2) default '';
    declare i int default 0;
    declare n int default 0;    
    set n = ceiling(rand()*2);    
    while i < n
    do
       set name = concat(name, elt(ceiling(rand()*1000)%200+1,"静","敏","燕","艳","丽","娟","莉","芳","萍","玲","娜","丹","洁","红","颖","琳","霞","婷","慧","莹","晶","华","倩","英","佳","梅","雪","蕾","琴","璐","伟","云","蓉","青","薇","欣","琼","宁","平","媛","虹","杰","婧","雯","茜","楠","洋","君","辉","菲","琦","妍","阳","波","俊","鑫","磊","军","爽","兰","晨","冰","瑶","瑾","岩","瑛","悦","群","玮","欢","瑜","蕊","宇","明","珊","荣","超","琪","玉","怡","文","岚","杨","婕","旭","凤","健","芬","芸","晓","萌","飞","露","菁","惠","宏","瑞","蓓","林","璇","珍","月","利","勤","清","帆","迪","微","斌","娇","影","巍","朋","莎","彬","峰","昕","乐","星","新","烨","晖","卉","晴","曼","越","靖","维","晔","艺","睿","芹","淼","黎","畅","椒","鹏","春","彦","柳","梦","毅","妮","坤","翠","然","钰","蔚","曦","茹","凌","扬","凡","美","彤","园","炜","捷","亮","叶","苗","菊","勇","锐","雨","力","翔","庆","方","琰","聪","潇","威","甜","帅","进","琛","花","雅","立","姣","馨","珏","秀","亚","珂","思","哲","冉","骊","双","娅","胡","培","斐","嘉","莲","莺","佩","剑"));
       set i = i + 1;
    end while;
    return name;
end
;;
delimiter ;
-- ----------------------------
-- Function structure for generate_name
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_name`;
delimiter ;;
CREATE FUNCTION `generate_name`(sex varchar(2))
 RETURNS varchar(3) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    declare firstname varchar(2) default '';
    declare lastname varchar(2) default '';    
    set firstname = elt(ceiling(rand()*1000)%200+1,"赵","钱","孙","李","周","吴","郑","王","冯","陈","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","钟","徐","邱","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠");
    if ( sex = "男" ) then
        set lastname = generate_boyname();    
    else
        set lastname = generate_girlname();   
    end if;
    
    return concat(firstname, lastname);
end
;;
delimiter ;
-- ----------------------------
-- Function structure for generate_phone
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_phone`;
delimiter ;;
CREATE FUNCTION `generate_phone`()
 RETURNS varchar(11) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    declare phone varchar(11) default "1";    
    declare i int default 0; 
    set phone = concat(phone, elt(ceiling((rand()*10))%4+1,"3","5","7","8"));    
    while i < 9
    do
       set phone = concat(phone, elt(ceiling((rand()*10)),"0","1","2","3","4","5","6","7","8","9"));
       set i = i + 1;
    end while; 
    return phone;
end
;;
delimiter ;
-- ----------------------------
-- Function structure for generate_sex
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_sex`;
delimiter ;;
CREATE FUNCTION `generate_sex`()
 RETURNS varchar(2) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    return elt(ceiling(rand()*2), "男","女");
end
;;
delimiter ;
-- ----------------------------
-- Procedure structure for proc_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_data`;
delimiter ;;
CREATE PROCEDURE `proc_data`(in total int)
begin 
declare i int default 1;
declare phone varchar(32);
declare sex varchar(2);
declare continue handler for 1062 
begin
    select concat(i) "count", concat("phone ", phone, " alrady exist") "info"; 
    set i = i - 1 ;
end; 
while i <= total do
    set phone = generate_phone();
    set sex = generate_sex();
    insert into `user`(name, sex, phone) values(generate_name(sex), sex, phone);
    set i = i + 1 ;
end while;
end
;;
delimiter ;
SET FOREIGN_KEY_CHECKS = 1;
```

### 五、功能的实现

**注：相同功能仅演示一次，如有需要请移步源码**

---

#### 1.登录

```markdown
# 说明
- 1.通过管理员输入管理员账户和密码验证登录
```

1. 页面功能演示

   ![20230307_103146](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140613189-264961644.gif)

2. 前端请求

   ```javascript
   // 登录
   submit(ruleForm) {
       // 判断用户名和密码是否为空
       this.$refs[ruleForm].validate((valid) => {
           if (valid) {
               // 通过post方法发送ajax请求
               axios({
                   method: 'post',
                   url: localhost + '/login',
                   data: this.ruleForm,
               }).then((response) => {
                   // 判断传回来的响应数据是否是成功
                   if (response.data === "fail") {
                       this.$message.error('用户名或密码错误');
                   } else {
                       this.$message.success('登录成功');
                       // 登录验证成功后存储当前登录的用户名
                       localStorage.setItem('manage', this.ruleForm.name);
                       // 跳转至后台管理主页
                       location.href = 'managepanel.html';
                   }
               });
           } else {
               return false;
           }
       });
   },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/login.html
```

3. 后端响应

    1. Servlet

       ```java
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //从请求体读取一行数据
           String readLine = request.getReader().readLine();
           //将json字符串转为Java对象
           Manage manage = JSON.parseObject(readLine, Manage.class);
           //调用登录方法
           Manage login = manageService.login(manage);
           String result = "fail";
           //判断用户是否存在
           if (login != null) {
               //存储Session对象
               request.getSession().setAttribute("manage", login.getName());
               // 判断Session对象是否存储成功
               if (request.getSession().getAttribute("manage") != null) {
                   result = "succeed";
               }
           } else {
               //响应执行结果
               response.getWriter().write(result);
           }
       }
       ```

    2. Dao

       ```java
       /**
        * 通过用户名和密码查询管理员
        *
        * @param manage 传入用户名和密码
        * @return 返回查询结果
        */
       @Override
       public Manage selectMange(Manage manage) {
           //通过sql查询用户名和密码
           String sql = "select name,password from manage where name=? and password=?";
           return selectOne(Manage.class, sql, manage.getName(), manage.getPassword());
       }
       ```

完整代码：

```http
// Servlet
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/LoginServlet.java
// Service
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/ManageService.java
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/ManageServiceImpl.java
// Dao
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/ManageDao.java
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/ManageDaoImpl.java
```

#### 2.获取省份和城市信息

##### 2-1.获取省份信息

```markdown
# 说明
- 1.当页面渲染完成后向后端发送ajax请求
- 2.将响应回来的省份信息绑定到dropdown_province
```

1. 页面功能演示

   ![20230307_102619](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140610821-1332166215.gif)

2. 前端请求

   ```javascript
   // 获取省份列表
   // 通过get方法发送Ajax请求
   axios({
       method: 'get',
       url: localhost + '/province_city/getProvince',
   }).then((response) => {
       // 将响应的数据绑定到dropdown_province
       this.dropdown_province = response.data;
   });
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //获取省份列表
       public void getProvince(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取省份列表
           List<Province> provinceList = provinceAndCityService.getProvince();
           //将Java对象转为json字符串
           String jsonString = JSON.toJSONString(provinceList);
           //将数据响应给前端axios
           response.getWriter().write(jsonString);
       }
       ```

    2. Dao

       ```java
       /**
        * 查询省份列表
        *
        * @return 返回省份列表
        */
       @Override
       public List<Province> selectByProvince() {
           // 通过sql查询省份信息
           String sql = "select id,name as 'province' from province";
           return selectList(Province.class, sql);
       }
       ```

完整代码：

```http
// Servlet
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/ProvinceAndCityServlet.java
// Service
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/ProvinceAndCityService.java
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/ProvinceAndCityServiceImpl.java
// Dao
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/ProvinceAndCityDao.java
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/ProvinceAndCityDaoImpl.java
```

##### 2-2.获取城市信息

```markdown
# 说明
- 1.当管理员选择省份后触发事件
- 2.将响应回来的城市信息绑定到dropdown_city
```

1. 页面功能演示

   ![20230307_104739](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140609252-164258607.gif)

2. 前端请求

   ```javascript
   //获取城市列表
   getCity() {
       let province = '';
       // 判断查询的省份查询框是否为空
       if (this.ruleForm.province !== '') {
           //将查询省份存储到province
           province = this.ruleForm.province;
       }
       // 判断新增的省份查询框是否为空
       if (this.form.province !== '') {
           province = this.form.province;
       }
       // 判断编辑的省份查询框是否为空
       if (this.editForm.province !== '') {
           province = this.editForm.province;
       }
       // 通过get方式发送ajax请求
       axios({
           method: 'get',
           url: localhost + '/province_city/getCity?province=' + province,
       }).then((response) => {
           //将响应数据绑定到dropdown_city
           this.dropdown_city = response.data;
           // 清空省份查询数据
           this.ruleForm.city = '';
           this.form.city = '';
           this.editForm.city = '';
       });
   },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //获取城市列表
       public void getCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取省份列表
           int province_id = Integer.parseInt(request.getParameter("province"));
           // 创建省份对象
           Province newProvince = new Province();
           // 将省份序号赋值给省份对象
           newProvince.setId(province_id);
           // 查询城市列表
           List<City> cityList = provinceAndCityService.getCity(newProvince);
           //将Java对象转为json字符串
           String jsonString = JSON.toJSONString(cityList);
           //将数据响应给前端axios
           response.getWriter().write(jsonString);
       }
       ```

    2. Dao

       ```java
       /**
        * 查询城市列表
        *
        * @param province 传入省份序号
        * @return 返回城市列表
        */
       @Override
       public List<City> selectByCity(Province province) {
           // 通过sql查询城市列表
           String sql = "select city.id,city.name as 'city' from province,city where province_id=province.id and province.id=?";
           return selectList(City.class, sql, province.getId());
       }
       ```

完整代码：

```http
// Servlet
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/ProvinceAndCityServlet.java
// Service
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/ProvinceAndCityService.java
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/ProvinceAndCityServiceImpl.java
// Dao
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/ProvinceAndCityDao.java
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/ProvinceAndCityDaoImpl.java
```

#### 3.获取出版社和图书分类信息

```markdown
# 说明
- 1.当页面渲染完成后向后端发送ajax请求
- 2.将响应回来的出版社信息绑定到dropdown_author
- 3.将响应回来的图书分类信息绑定到dropdown_type
```

1. 页面功能演示

   ![20230307_110036](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140607240-993622060.gif)

1. 前端请求

   ```javascript
   // 获取出版社列表
   // 通过get方式发送ajax请求
   axios({
       method: 'get',
       url: localhost + '/getAuthor',
       // 使用箭头函数获取vue实例对象
   }).then((response) => {
       // 将响应数据绑定到dropdown_author
       this.dropdown_author = response.data;
   });
   // 获取图书分类列表
   axios({
       method: 'get',
       url: localhost + '/getType',
   }).then((response) => {
       // 将响应数据绑定到dropdown_type
       this.dropdown_type = response.data;
   });
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/book_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //获取出版社列表
       public void getAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取省份列表
           List<Author> authorList = bookService.getAuthor();
           //将Java对象转为json字符串
           String jsonString = JSON.toJSONString(authorList);
           //将数据响应给前端axios
           response.getWriter().write(jsonString);
       }
       
       //获取图书分类列表
       public void getType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取省份列表
           List<Type> typeList = bookService.getType();
           //将Java对象转为json字符串
           String jsonString = JSON.toJSONString(typeList);
           //将数据响应给前端axios
           response.getWriter().write(jsonString);
       }
       ```

    2. Dao

       ```java
       /**
        * 查询出版社列表
        *
        * @return 返回出版社列表
        */
       @Override
       public List<Author> selectByAuthor() {
           // 通过sql查询出版社列表
           String sql = "select id,name as 'name' from author";
           return selectList(Author.class, sql);
       }
       
       /**
        * 查询图书分类列表
        *
        * @return 返回图书分类列表
        */
       @Override
       public List<Type> selectByType() {
           // 通过sql查询图书分类列表
           String sql = "select id,name as 'type' from type";
           return selectList(Type.class, sql);
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/BookServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/BookService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/BookServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/BookDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/BookDaoImpl.java
   ```

#### 4.表格与卡片渲染

```markdown
# 说明
- 1.当页面渲染完成后向后端发送ajax请求
- 2.将响应回来的表格/卡片信息绑定到tableData/cardData
```

1. 页面功能演示

   ![20230307_111705](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140602010-535549337.gif)

1. 前端请求

   ```javascript
   // 获取用户列表
   list() {
       // 通过get方式发送ajax请求
       axios({
           method: 'get',
           url: localhost + '/user/list?currentPage=' + this.currentPage + '&pageSize=' + this.pageSize,
           // 使用箭头函数获取vue实例对象
       }).then((response) => {
           // 判断列表是否获取成功
           if (response.data !== 'fail') {
               // 将响应数据绑定到tableData和count
               this.tableData = response.data.data;
               this.count = response.data.count;
           } else {
               this.$message.error('系统错误');
           }
       });
   },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //获取用户列表
       public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取分页数据
           //当前页数
           int currentPage = Integer.parseInt(request.getParameter("currentPage"));
           //每页条数
           int pageSize = Integer.parseInt(request.getParameter("pageSize"));
           //获取学生列表
           Page<User> list = userService.list(pageSize, currentPage);
           String result = "fail";
           // 判断用户列表是否获取成功
           if (list.getCount() != 0) {
               //将Java对象转为json字符串
               String jsonString = JSON.toJSONString(list);
               //将数据响应给前端axios
               response.getWriter().write(jsonString);
           } else {
               response.getWriter().write(result);
           }
       }
       ```

    2. Service

       ```java
       /**
        * 逻辑判断用户列表
        *
        * @param pageSize    传入每页分页数
        * @param currentPage 传入当前页数
        * @return 返回用户列表
        */
       @Override
           public Page<User> list(int pageSize, int currentPage) {
               //计算开始索引
               int begin = (currentPage - 1) * pageSize;
               //获取分页后的数据
               List<User> list = userDao.selectUserAll(begin, pageSize);
               //获取数据总数
               int count = userDao.selectUserByCount();
               return new Page<>(count, list);
           }
       ```

    3. Dao

       ```java
       /**
        * 查询用户总数据
        *
        * @return 返回用户总数
        */
       @Override
       public int selectUserByCount() {
           // 通过sql查询用户总数
           String sql = "select " + count + "from user";
           return Integer.parseInt(selectAggregate(sql).toString());
       }
       
       /**
        * 查询用户列表
        *
        * @param begin    传入开始位置
        * @param pageSize 传入每页条数
        * @return 返回用户列表
        */
       @Override
       public List<User> selectUserAll(int begin, int pageSize) {
           // 通过sql查询用户列表
           String sql = select + from + "where user.province_id=province.id and user.city_id=city.id limit ?,?";
           return selectList(User.class, sql, begin, pageSize);
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/UserServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/UserService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/UserServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/UserDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/UserDaoImpl.java
   ```

#### 5.分页处理

```markdown
# 说明
- 1.当页面渲染完成后向后端发送ajax请求
- 2.将响应回来的表格/卡片信息绑定到tableData/cardData
```

1. 页面功能演示

   ![20230307_135003](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140558652-52511577.gif)

1. 前端请求

   ```javascript
   // 查询后的分页处理
   page() {
       if (this.ruleForm.name !== '') {
           this.select(1);
           return false;
       }
       if (this.ruleForm.book_name !== '') {
           this.select(2);
           return false;
       }
       if (this.ruleForm.purchase_time !== '') {
           this.select(3);
           return false;
       }
       this.list();
   },
       // 修改分页数量
       handleSizeChange(val) {
           this.pageSize = val;
           this.page();
       },
           // 切换页数
           handleCurrentChange(val) {
               this.currentPage = val;
               this.page();
           }
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Service

       ```java
       /**
        * 处理条件查询后的数据条数及用户列表
        *
        * @param list 传入需要处理的用户列表
        * @return 返回处理后用户列表
        */
       public Page<User> aggregate(List<User> list) {
           //计算数据总数
           int count = 0;
           // 遍历用户条数
           for (int i = 0; i < list.size(); i++) {
               count += list.get(i).getCount();
           }
           return new Page(count, list);
       }
       ```

完整代码：

```http
// Service
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/UserService.java
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/UserServiceImpl.java
```

#### 5.条件查询

1. 前端请求

   ```javascript
   // 条件查询
   select(index) {
       let url;
       // 按用户名查询
       if (index === 1 && this.ruleForm.name !== '') {
           // 清空其他查询
           this.ruleForm.province = '';
           this.ruleForm.city = '';
           this.ruleForm.phone = '';
           this.ruleForm.email = '';
           //重写url地址
           url = localhost + '/user/getByName?name=' + this.ruleForm.name + '&currentPage=' + this.currentPage + '&pageSize=' + this.pageSize;
       }
       // 按省份和城市查询
       else if (index === 2 && this.ruleForm.province !== '' && this.ruleForm.city !== '') {
           this.ruleForm.name = '';
           this.ruleForm.phone = '';
           this.ruleForm.email = '';
           url = localhost + '/user/getByProvince_city?province=' + this.ruleForm.province + '&city=' + this.ruleForm.city + '&currentPage=' + this.currentPage + '&pageSize=' + this.pageSize;
       }
       // 按电话号码查询
       else if (index === 3 && this.ruleForm.phone !== '') {
           this.ruleForm.province = '';
           this.ruleForm.city = '';
           this.ruleForm.name = '';
           this.ruleForm.email = '';
           url = localhost + '/user/getByPhone?phone=' + this.ruleForm.phone + '&currentPage=' + this.currentPage + '&pageSize=' + this.pageSize;
       }
       // 按电子邮箱查询
       else if (index === 4 && this.ruleForm.email !== '') {
           this.ruleForm.province = '';
           this.ruleForm.city = '';
           this.ruleForm.phone = '';
           this.ruleForm.name = '';
           url = localhost + '/user/getByEmail?email=' + this.ruleForm.email + '&currentPage=' + this.currentPage + '&pageSize=' + this.pageSize;
       } else {
           this.$message({
               message: '请输入需要查询的参数',
               type: 'warning'
           });
           return false;
       }
       // 通过get方式发送ajax请求
       axios({
           method: 'get',
           url: url,
       }).then((response) => {
           if (response.data !== 'fail') {
               // 绑定数据
               this.tableData = response.data.data;
               this.count = response.data.count;
           } else {
               this.$message('查询结果为空');
               // 清空查询参数
               this.ruleForm.province = '';
               this.ruleForm.city = '';
               this.ruleForm.phone = '';
               this.ruleForm.email = '';
               this.ruleForm.name = '';
           }
       });
   },
   ```

##### 5-1.文本框查询

```markdown
# 说明
- 1.当管理员输入查询参数并点击查询后提交数据到后端
- 2.将响应回来的表格/卡片信息绑定到tableData/cardData
```

1. 页面功能演示

   ![20230307_132428](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140557636-2034796866.gif)

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

2. 后端响应

    1. Servlet

       ```java
       //通过用户名查询用户
       public void getByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取分页数据
           //当前页数
           int currentPage = Integer.parseInt(request.getParameter("currentPage"));
           //每页条数
           int pageSize = Integer.parseInt(request.getParameter("pageSize"));
           //获取用户名
           String name = request.getParameter("name");
           //解码
           name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
           // 创建用户对象
           User newUser = new User();
           // 将用户名赋值给用户对象
           newUser.setName(name);
           Page<User> users = userService.getUserByName(pageSize, currentPage, newUser);
           String result = "fail";
           // 判断用户列表的总数是否为0
           if (users.getCount() != 0) {
               //将Java对象转为json字符串
               String jsonString = JSON.toJSONString(users);
               //将数据响应给前端axios
               response.getWriter().write(jsonString);
           } else {
               response.getWriter().write(result);
           }
       }
       ```

    2. Service

       ```java
       /**
        * 逻辑判断用户名查询用户信息
        *
        * @param pageSize    传入每页分页数
        * @param currentPage 传入当前页数
        * @param user        传入用户名
        * @return 返回用户列表
        */
       @Override
       public Page<User> getUserByName(int pageSize, int currentPage, User user) {
           //计算开始索引
           int begin = (currentPage - 1) * pageSize;
           return aggregate(userDao.selectUserByName(begin, pageSize, user));
       }
       ```

    3. Dao

       ```java
       /**
        * 通过用户名查询用户信息
        *
        * @param begin    传入开始位置
        * @param pageSize 传入每页条数
        * @param user     传入用户名
        * @return 返回用户列表
        */
       @Override
       public List<User> selectUserByName(int begin, int pageSize, User user) {
           String sql = select + "," + count + from + "where user.name like ? and user.province_id=province.id and user.city_id=city.id group by user.id limit ?,?";
           return selectList(User.class, sql, "%" + user.getName() + "%", begin, pageSize);
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/ProvinceAndCityServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/ProvinceAndCityService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/ProvinceAndCityServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/ProvinceAndCityDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/ProvinceAndCityDaoImpl.java
   ```

##### 5-2.下拉选择查询

```markdown
# 说明
- 1.当管理员选择查询参数并点击查询后提交数据到后端
- 2.将响应回来的表格/卡片信息绑定到tableData/cardData
```

1. 页面功能演示

   ![20230307_133005](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140556833-579815277.gif)

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

2. 后端响应

    1. Servlet

       ```java
       //通过省份和城市查询用户
       public void getByProvince_city(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取分页数据
           //当前页数
           int currentPage = Integer.parseInt(request.getParameter("currentPage"));
           //每页条数
           int pageSize = Integer.parseInt(request.getParameter("pageSize"));
           //获取省份序号
           String province_id = request.getParameter("province");
           //获取城市序号
           String city_id = request.getParameter("city");
           // 创建用户对象
           User newUser = new User();
           // 将省份序号和城市序号赋值给用户对象
           newUser.setProvince(province_id);
           newUser.setCity(city_id);
           Page<User> users = userService.getUserByProvince_city(pageSize, currentPage, newUser);
           String result = "fail";
           // 判断用户列表的总数是否为0
           if (users.getCount() != 0) {
               //将Java对象转为json字符串
               String jsonString = JSON.toJSONString(users);
               //将数据响应给前端axios
               response.getWriter().write(jsonString);
           } else {
               response.getWriter().write(result);
           }
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/UserServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/UserService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/UserServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/UserDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/UserDaoImpl.java
   ```

##### 5-3.日期查询

```markdown
# 说明
- 1.当管理员输入查询参数并点击查询后提交数据到后端
- 2.将响应回来的表格/卡片信息绑定到tableData/cardData
```

1. 页面功能演示

   ![20230307_133253(1)](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140555376-1012309429.gif)

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/order_list.html
```

2. 后端响应

    1. Servlet

       ```java
       //通过订购日期查询订单
       public void getByPurchase_time(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
           //获取分页数据
           //当前页数
           int currentPage = Integer.parseInt(request.getParameter("currentPage"));
           //每页条数
           int pageSize = Integer.parseInt(request.getParameter("pageSize"));
           //获取订购日期
           String purchase_time = request.getParameter("purchase_time");
           //解码
           purchase_time = new String(purchase_time.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
           //处理Date对象
           Date parseGMT = ParseGMT.parseGMT(purchase_time);
           //格式化日期时间格式
           String strDateFormat = "yyyy-MM-dd HH:mm:ss";
           SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
           //将日期时间对象转为字符串
           String format = sdf.format(parseGMT);
           Order newOrder = new Order();
           newOrder.setPurchase_time(format);
           Page<Order> orders = orderService.getOrderByPurchase_time(pageSize, currentPage, newOrder);
           String result = "fail";
           if (orders.getCount() != 0) {
               //将Java对象转为json字符串
               String jsonString = JSON.toJSONString(orders);
               //将数据响应给前端axios
               response.getWriter().write(jsonString);
           } else {
               response.getWriter().write(result);
           }
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/OrderServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/OrderService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/OrderServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/OrderDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/OrderDaoImpl.java
   ```

#### 6.新增

```markdown
# 说明
- 1.当管理员点击新增后显示新增弹窗
- 2.当管理员选择省份后触发查询城市列表
- 3.当管理员点击确定后将数据提交到后端
- 4.反馈提交结果并刷新页面
```

1. 页面功能演示

   ![20230307_113409](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140551061-644825099.gif)

1. 前端请求

   ```javascript
   // 新增用户的弹窗处理
   dialog() {
       // 清空省份查询信息
       this.form.province = '';
       this.ruleForm.province = '';
       // 显示新增弹窗
       this.dialogFormVisible = !this.dialogFormVisible;
   },
   
       // 新增用户
       submitForm(form) {
           // 判断表单是否已填写完成
           this.$refs[form].validate((valid) => {
               if (valid) {
                   // 通过post方式发送ajax请求
                   axios({
                       method: 'post',
                       url: localhost + '/user/addUser',
                       data: this.form,
                   }).then((response) => {
                       // 判断数据是否添加成功
                       if (response.data === 'succeed') {
                           this.$message({
                               message: '新增用户成功，初始密码为：0000',
                               type: 'success'
                           });
                           // 关闭新增弹窗
                           this.dialog();
                           // 清空新增用户数据
                           this.form = {
                               name: '',
                               sex: '男',
                               phone: '',
                               email: '',
                               province: '',
                               city: '',
                               address: '',
                           };
                           // 刷新页面
                           this.list();
                       } else {
                           this.$message.error('系统错误');
                       }
                   });
               } else {
                   this.$message({
                       message: '请填写信息',
                       type: 'warning'
                   });
                   return false;
               }
           });
           // 清空省份查询信息
           this.ruleForm.province = '';
       },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //新增用户
       public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取参数(通过请求体)
           String readLine = request.getReader().readLine();
           //json字符串转java对象
           User user = JSON.parseObject(readLine, User.class);
           //调用新增方法并返回执行结果
           String result = "fail";
           // 判断数据是否添加成功
           if (userService.addUser(user)) {
               result = "succeed";
           }
           //响应执行结果
           response.getWriter().write(result);
       }
       ```

    2. Dao

       ```java
       /**
        * 新增用户信息
        *
        * @param user 传入用户对象
        * @return 返回受影响的行数
        */
       @Override
       public int insertUser(User user) {
           // 通过sql添加用户信息
           String sql = "insert into user(name,password,sex,phone,email,province_id,city_id,address) values(?,'0000',?,?,?,?,?,?);";
           return update(sql, user.getName(), user.getSex(), user.getPhone(), user.getEmail(), user.getProvince(), user.getCity(), user.getAddress());
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/UserServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/UserService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/UserServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/UserDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/UserDaoImpl.java
   ```

#### 7.批量删除

```markdown
# 说明
- 1.当管理员通过多选并点击批量删除后将数据提交到后端
- 2.反馈提交结果并刷新页面
```

1. 页面功能演示

   ![20230307_115044](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140546353-1040192670.gif)

1. 前端请求

   ```javascript
   // 存储多选数据
   handleSelectionChange(val) {
       this.multipleSelection = val;
   },
       //批量删除
       checkboxdel() {
           // 通过post方式发送ajax请求
           axios({
               method: 'post',
               url: localhost + '/user/delUser',
               data: this.multipleSelection,
           }).then((response) => {
               // 判断数据是否删除成功
               if (response.data === 'succeed') {
                   this.$message({
                       message: '批量删除用户成功',
                       type: 'success'
                   });
                   // 清空多选
                   this.multipleSelection = [];
                   // 存储旧页数
                   let current = this.currentPage;
                   // 刷新页面
                   this.list();
                   // 判断页数是否显示正常
                   if (current > Math.floor(this.count / this.pageSize)) {
                       this.currentPage = Math.floor(this.count / this.pageSize);
                       this.list();
                   }
               } else {
                   this.$message.error('系统错误');
               }
           });
       },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //批量删除用户
       public void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取参数(通过请求体)
           String readLine = request.getReader().readLine();
           //json字符串转java对象
           User[] userList = JSON.parseObject(readLine, User[].class);
           //调用删除方法并返回执行结果
           String result = "";
           // 遍历用户数据
           for (int i = 0; i < userList.length; i++) {
               result = "fail";
               // 判断数据是否删除成功
               if (userService.delUserById(userList[i])) {
                   result = "succeed";
               }
               if ("fail".equals(result)) {
                   break;
               }
           }
           //响应执行结果
           response.getWriter().write(result);
       }
       ```

    2. Dao

       ```java
       /**
        * 通过用户序号删除用户信息
        *
        * @param user 传入用户序号
        * @return 返回受影响的行数
        */
       @Override
       public int deleteUserById(User user) {
           // 通过sql删除用户信息
           String sql = "delete from user where id=?";
           return update(sql, user.getId());
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/UserServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/UserService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/UserServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/UserDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/UserDaoImpl.java
   ```

#### 8.批量出库与批量上架

```markdown
# 说明
- 1.当管理员通过多选并点击批量出库/上架后将数据提交到后端
- 2.反馈提交结果并刷新页面
```

1. 页面功能演示

   ![20230307_120136](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140543516-1919816682.gif)

1. 前端请求

   ```javascript
   //批量出库
   checkboxout() {
       // 通过post方式发送ajax请求
       axios({
           method: 'post',
           url: localhost + '/outOrder',
           data: this.multipleSelection,
       }).then((response) => {
           // 判断数据是否更新成功
           if (response.data === 'succeed') {
               this.$message({
                   message: '批量出库成功',
                   type: 'success'
               });
               // 清空多选
               this.multipleSelection = [];
               let current = this.currentPage;
               // 刷新页面
               this.list();
           } else {
               this.$message.error('系统错误');
           }
       });
   },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/order_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //批量修改订单状态
       public void outOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取参数(通过请求体)
           String readLine = request.getReader().readLine();
           //json字符串转java对象
           Order[] OrdersList = JSON.parseObject(readLine, Order[].class);
           //调用修改方法并返回执行结果
           String result = "";
           // 遍历订单信息
           for (int i = 0; i < OrdersList.length; i++) {
               result = "fail";
               // 判断数据是否更新成功
               if (orderService.outOrderById(OrdersList[i])) {
                   result = "succeed";
               }
               if ("fail".equals(result)) {
                   break;
               }
           }
           //响应执行结果
           response.getWriter().write(result);
       }
       ```

    2. Dao

       ```java
       /**
        * 通过订单序号更新订单状态
        *
        * @param order 传入订单序号
        * @return 返回受影响的行数
        */
       @Override
       public int updateOrderById(Order order) {
           // 通过sql更新订单状态
           String sql = "update orders set out_fig=1 where id=?";
           return update(sql, order.getId());
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/OrderServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/OrderService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/OrderServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/OrderDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/OrderDaoImpl.java
   ```

#### 9.重置密码

```markdown
# 说明
- 1.当管理员点击重置密码后将数据提交到后端
- 2.反馈提交结果并刷新页面
```

1. 页面功能演示

   ![20230307_121420](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140540788-41819868.gif)

1. 前端请求

   ```javascript
   //重置密码
   handleReset(index, row) {
       // 通过post方式发送ajax请求
       axios({
           method: 'post',
           url: localhost + '/user/reUserById',
           data: row,
       }).then((response) => {
           // 判断数据是否更新成功
           if (response.data === 'succeed') {
               this.$message({
                   message: '重置用户密码成功，初始密码为：0000',
                   type: 'success'
               });
               // 刷新页面
               this.list();
           } else {
               this.$message.error('系统错误');
           }
       });
   },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //通过用户序号重置用户密码
       public void reUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取参数(通过请求体)
           String readLine = request.getReader().readLine();
           //json字符串转java对象
           User user = JSON.parseObject(readLine, User.class);
           //调用更新方法并返回执行结果
           String result = "fail";
           // 判断数据是否更新成功
           if (userService.reUserById(user)) {
               result = "succeed";
           }
           //响应执行结果
           response.getWriter().write(result);
       }
       ```

    2. Dao

       ```java
       /**
        * 通过用户序号重置用户密码
        *
        * @param user 传入用户序号
        * @return 返回受影响行数
        */
       @Override
       public int reUserById(User user) {
           // 通过sql更新用户信息
           String sql = "update user set password='0000' where id=?";
           return update(sql, user.getId());
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/UserServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/UserService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/UserServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/UserDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/UserDaoImpl.java
   ```

#### 10.编辑

```markdown
# 说明
- 1.当管理员点击编辑按钮后显示编辑弹窗
- 2.当管理员选择省份后触发查询城市列表
- 3.当管理员点击确定后将数据提交到后端
- 4.反馈提交结果并刷新页面
```

1. 页面功能演示

   ![20230307_122257](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140539621-174431997.gif)

1. 前端请求

   ```javascript
   //存储编辑的原始省份信息
   var province;
   // 存储编辑的原始城市信息
   var city;
   // 编辑用户弹窗处理
   dialogEdit() {
       // 清空省份查询
       this.form.province = '';
       this.ruleForm.province = '';
       // 显示编辑弹窗
       this.dialogEditVisible = !this.dialogEditVisible;
   },
       // 编辑
       handleEdit(index, row) {
           // 存储旧省份和城市
           province = row.province;
           city = row.city;
           this.dialogEdit();
           // 绑定表单数据
           this.editForm = row;
           this.editForm.province_id = row.province_id;
           this.editForm.city_id = row.city_id;
       },
           // 更新用户
           updateForm(editForm) {
               // 判断表单是否填写完整
               this.$refs[editForm].validate((valid) => {
                   // 处理省份和城市信息
                   if (this.editForm.province === province) {
                       this.editForm.province = this.editForm.province_id;
                   }
                   if (this.editForm.city === city) {
                       this.editForm.city = this.editForm.city_id;
                   }
                   if (valid) {
                       // 通过post方式发送ajax请求
                       axios({
                           method: 'post',
                           url: localhost + '/user/upUserById',
                           data: this.editForm,
                       }).then((response) => {
                           if (response.data === 'succeed') {
                               this.$message({
                                   message: '更新用户信息成功',
                                   type: 'success'
                               });
                               // 关闭编辑弹窗
                               this.dialogEdit();
                               // 刷新页面
                               this.list();
                           } else {
                               this.$message.error('系统错误');
                           }
                       });
                   } else {
                       this.$message({
                           message: '请填写信息',
                           type: 'warning'
                       });
                       return false;
                   }
               });
           },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //通过用户序号更新用户信息
       public void upUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取参数(通过请求体)
           String readLine = request.getReader().readLine();
           //json字符串转java对象
           User user = JSON.parseObject(readLine, User.class);
           //调用更新方法并返回执行结果
           String result = "fail";
           // 判断数据是否更新成功
           if (userService.upUserById(user)) {
               result = "succeed";
           }
           //响应执行结果
           response.getWriter().write(result);
       }
       ```

    2. Dao

       ```java
       /**
        * 通过用户序号更新用户信息
        *
        * @param user 传入用户序号和用户信息
        * @return 返回受影响的行数
        */
       @Override
       public int updateUserById(User user) {
           // 通过sql更新用户信息
           String sql = "update user set user.name=?,sex=?,phone=?,email=?,user.province_id=?,user.city_id=?,address=? where user.id=?";
           return update(sql, user.getName(), user.getSex(), user.getPhone(), user.getEmail(), user.getProvince(), user.getCity(), user.getAddress(), user.getId());
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/UserServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/UserService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/UserServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/UserDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/UserDaoImpl.java
   ```

#### 11.删除

```markdown
# 说明
- 1.当管理员点击删除后将数据提交到后端
- 2.反馈提交结果并刷新页面
```

1. 页面功能演示

   ![20230307_123706](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140538842-1057593026.gif)

1. 前端请求

   ```javascript
   // 删除
   handleDelete(index, row) {
       // 通过post方式发送ajax请求
       axios({
           method: 'post',
           url: localhost + '/user/delUserById',
           data: row,
       }).then((response) => {
           // 判断数据是否删除成功
           if (response.data === 'succeed') {
               this.$message({
                   message: '删除用户成功',
                   type: 'success'
               });
               // 存储旧页码
               let current = this.currentPage;
               // 刷新页面
               this.list();
               //判断页码显示是否正常
               if (current > Math.floor(this.count / this.pageSize)) {
                   this.currentPage = Math.floor(this.count / this.pageSize);
                   this.list();
               }
           } else {
               this.$message.error('系统错误');
           }
       });
   },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/user_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //通过用户序号删除用户
       public void delUserById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取参数(通过请求体)
           String readLine = request.getReader().readLine();
           //json字符串转java对象
           User user = JSON.parseObject(readLine, User.class);
           //调用删除方法并返回执行结果
           String result = "fail";
           // 判断数据是否删除成功
           if (userService.delUserById(user)) {
               result = "succeed";
           }
           //响应执行结果
           response.getWriter().write(result);
       }
       ```

    2. Dao

       ```java
       /**
        * 通过用户序号删除用户信息
        *
        * @param user 传入用户序号
        * @return 返回受影响的行数
        */
       @Override
       public int deleteUserById(User user) {
           // 通过sql删除用户信息
           String sql = "delete from user where id=?";
           return update(sql, user.getId());
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/UserServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/UserService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/UserServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/UserDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/UserDaoImpl.java
   ```

#### 12.出库与上架

```markdown
# 说明
- 1.当管理员点击出库或上架后将数据提交到后端
- 2.反馈提交结果并刷新页面
```

1. 页面功能演示

   ![20230307_124913](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140537782-1506908399.gif)

1. 前端请求

   ```javascript
   // 修改出库标志
   handleEdit(index, row) {
       // 通过post方式发送ajax请求
       axios({
           method: 'post',
           url: localhost + '/outOrderById',
           data: row,
       }).then((response) => {
           // 判断数据是否更新成功
           if (response.data === 'succeed') {
               this.$message({
                   message: '出库成功',
                   type: 'success'
               });
               let current = this.currentPage;
               // 刷新页面
               this.list();
           } else {
               this.$message.error('系统错误');
           }
       });
   },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/order_list.html
```

3. 后端响应

    1. Servlet

       ```java
       //通过订单序号修改订单状态
       public void outOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取参数(通过请求体)
           String readLine = request.getReader().readLine();
           //json字符串转java对象
           Order order = JSON.parseObject(readLine, Order.class);
           //调用删除方法并返回执行结果
           String result = "fail";
           // 判断数据是否更新成功
           if (orderService.outOrderById(order)) {
               result = "succeed";
           }
           //响应执行结果
           response.getWriter().write(result);
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/OrderServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/OrderService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/OrderServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/OrderDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/OrderDaoImpl.java
   ```

#### 13.修改密码

```markdown
# 说明
- 1.当管理员输入原始密码且文本框失去光标后将数据提交到后端
- 2.将响应回来的结果显示在页面上
```

1. 页面功能演示

   ![20230307_125543](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140536933-1125928461.gif)

1. 前端请求

   ```javascript
   // 判断原始密码与管理员输入的是否一致
   raw() {
       // 通过post方式发送ajax请求
       axios({
           method: 'post',
           url: localhost + '/manage/contrast',
           data: this.ruleForm,
       }).then((response) => {
           // 判断比对结果是否一致
           if (response.data !== 'fail') {
               this.status = 1;
           } else {
               this.$message.error('原始密码错误');
           }
       });
   },
       // 提交新密码
       submitForm(formName) {
           // 判断表单是否填写完整
           this.$refs[formName].validate((valid) => {
               if (valid) {
                   // 通过post方式发送ajax请求
                   axios({
                       method: 'post',
                       url: localhost + '/manage/chahge',
                       data: this.ruleForm,
                   }).then((response) => {
                       // 判断数据是否更新完成
                       if (response.data !== 'fail') {
                           this.$message({
                               message: '密码修改成功',
                               type: 'success'
                           });
                           parent.location.reload();
                       } else {
                           this.$message.error('系统错误');
                       }
                   });
               } else {
                   return false;
               }
           });
       },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/change.html
```

3. 后端响应

    1. Servlet

       ```java
       //比对原始密码与用户输入是否一致
       public void contrast(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //从请求体读取一行数据
           String readLine = request.getReader().readLine();
           //将json字符串转为Java对象
           Manage manage = JSON.parseObject(readLine, Manage.class);
           //调用登录方法
           Manage login = manageService.login(manage);
           //判断用户是否存在
           String result = "fail";
           // 判断管理员是否为空
           if (login != null) {
               result = "succeed";
           } else {
               //响应执行结果
               response.getWriter().write(result);
           }
       }
       
       //更新密码
       public void chahge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //从请求体读取一行数据
           String readLine = request.getReader().readLine();
           //将json字符串转为Java对象
           Manage manage = JSON.parseObject(readLine, Manage.class);
           //调用更新方法并返回执行结果
           String result = "fail";
           // 判断数据是否更新成功
           if (manageService.change(manage)) {
               result = "succeed";
           }
           //响应执行结果
           response.getWriter().write(result);
           //清空session对象
           request.getSession().invalidate();
       }
       ```

    2. Dao

       ```java
       /**
        * 通过用户名和密码查询管理员
        *
        * @param manage 传入用户名和密码
        * @return 返回查询结果
        */
       @Override
       public Manage selectMange(Manage manage) {
           //通过sql查询用户名和密码
           String sql = "select name,password from manage where name=? and password=?";
           return selectOne(Manage.class, sql, manage.getName(), manage.getPassword());
       }
       
       /**
        * 通过用户名修改密码
        *
        * @param manage 传入用户名和密码
        * @return 返回受影响的行数
        */
       @Override
       public int updateByName(Manage manage) {
           // 通过sql更新管理员密码
           String sql = "update manage set password=? where name=?";
           return update(sql, manage.getPass(), manage.getName());
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/ManageServlet.java
   // Service
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/ManageService.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/service/impl/ManageServiceImpl.java
   // Dao
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/ManageDao.java
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/ManageDaoImpl.java
   ```

#### 14.退出登录

```markdown
# 说明
- 1.当管理员点击退出后将触发退出登录
- 2.重定向到登录页
```

1. 页面功能演示

   ![20230307_130949](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230307140536091-209030542.gif)

1. 前端请求

   ```javascript
   // 退出登录
   handleCommand(logout) {
       // 通过get方式发送ajax请求
       axios({
           method: 'get',
           url: localhost + '/logout',
       }).then((response => {
           // 判断数据是否处理完成
           if (response.data !== "fail") {
               this.$message.success('退出登录成功');
               // 重定向
               location.href = 'login.html';
           } else {
               this.$message.error('系统错误');
           }
       }));
   },
   ```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/webapp/managepanel.html
```

3. 后端响应

    1. Servlet

       ```java
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //清空session对象
           request.getSession().invalidate();
           String result = "fail";
           //判断用户是否为登录状态
           if (request.getSession().getAttribute("manage") == null) {
               result = "succeed";
           }
           //响应执行结果
           response.getWriter().write(result);
       }
       ```

   完整代码：

   ```http
   // Servlet
   https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/LogoutServlet.java
   ```

### 六、Basic

---

#### 1.BasicDao

```markdown
# 说明
* BaseDao是所有针对数据库操作的基本类 需要在里面设置一些通用方法来解决增删查改代码重复的问题
```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/dao/impl/BasicDao.java
```

#### 2.BasicServlet

```markdown
# 说明
* 用于优化Servlet
```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/controller/BasicServlet.java
```

### 七、Utils

---

#### 1.JdbcUtilsByDruid

```markdown
# 说明
* 基于Druid数据库连接池的工具类
```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/utils/JdbcUtilsByDruid.java
```

#### 2.ParseGMT

来源于：[Java:格林威治时间(GMT)字符串转Date_gmt转date_刘显卓的博客-CSDN博客](https://blog.csdn.net/xianzhuo_sky/article/details/82803945)

```markdown
# 说明
* 用于处理格林威治时间（GMT） 字符串转Date（CST）
```

完整代码：

```http
https://github.com/ynxiyan/JavaProjects/blob/main/Javaweb/sunbookshop/src/main/java/com/utils/ParseGMT.java
```

















