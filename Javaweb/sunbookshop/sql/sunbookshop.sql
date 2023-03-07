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
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`
(
    `id`          int                                                     NOT NULL AUTO_INCREMENT COMMENT '出版社序号',
    `name`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社名称',
    `contact`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人',
    `phone`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
    `province_id` int                                                     NOT NULL COMMENT '省份序号',
    `city_id`     int                                                     NOT NULL COMMENT '城市序号',
    `address`     varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '出版社地址',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author`
VALUES (1, '中华书局', '莫言', '18262383173', 1, 1, '');
INSERT INTO `author`
VALUES (2, '上海古籍出版社', '菲茨杰拉德', '17191755918', 7, 40, '');
INSERT INTO `author`
VALUES (3, '国家图书馆出版社', '唐德刚', '18864321082', 10, 81, '');
INSERT INTO `author`
VALUES (4, '凤凰出版社', '裘沙', '15113054666', 1, 1, '');
INSERT INTO `author`
VALUES (5, '黄山书社', '夏目漱石', '17252316978', 15, 142, '');
INSERT INTO `author`
VALUES (6, '崇文书局', '余秋雨', '15488852781', 17, 177, '');
INSERT INTO `author`
VALUES (7, '九州出版社', '唐师曾', '18708284409', 19, 208, '');
INSERT INTO `author`
VALUES (8, '岳麓书社', '林达', '15362429986', 22, 253, '');
INSERT INTO `author`
VALUES (9, '浙江古籍出版社', '金庸', '15349276211', 24, 288, '');
INSERT INTO `author`
VALUES (10, '广陵出版社', '今何在', '15995187407', 28, 337, '');
INSERT INTO `author`
VALUES (11, '科学出版社', '川端康成', '15995184368', 17, 177, '');
INSERT INTO `author`
VALUES (12, '中国经济出版社', '屠孟超', '15235187407', 19, 208, '');

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`
(
    `id`        int    NOT NULL AUTO_INCREMENT COMMENT '图书序号',
    `book_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图书名称',
    `author_id` int    NOT NULL COMMENT '出版社序号',
    `type_id`   int    NOT NULL COMMENT '图书类型序号',
    `ISBN`      varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ISBN号码',
    `price`     double NOT NULL DEFAULT 0 COMMENT '价格',
    `inventory` int    NOT NULL COMMENT '图书库存',
    `in_flg`    int    NOT NULL DEFAULT 0 COMMENT '上架标志',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX       `author_books`(`author_id` ASC) USING BTREE,
    INDEX       `type_books`(`type_id` ASC) USING BTREE,
    CONSTRAINT `author_books` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT `type_books` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books`
VALUES (1, '双城记', 7, 4, '97875633534578', 45.53, 12, 1);
INSERT INTO `books`
VALUES (2, '窗边的小豆豆', 5, 1, '97875633538942', 34.76, 45, 1);
INSERT INTO `books`
VALUES (3, '袁氏当国', 7, 3, '9787563353476', 17.09, 24, 1);
INSERT INTO `books`
VALUES (4, '故事新编', 3, 3, '9787563350032', 23.87, 1, 1);
INSERT INTO `books`
VALUES (5, '我是猫', 8, 2, '9787563351276', 34.76, 465, 1);
INSERT INTO `books`
VALUES (6, '山居笔记', 3, 4, '9787563358967', 78.34, 23, 1);
INSERT INTO `books`
VALUES (7, '我钻进了金字塔', 2, 1, '9787563352365', 26.87, 75, 1);
INSERT INTO `books`
VALUES (8, '带一本书去巴黎', 10, 2, '9787563351265', 17.89, 32, 1);
INSERT INTO `books`
VALUES (10, '悟空传', 2, 1, '9787563359865', 25.87, 13, 1);
INSERT INTO `books`
VALUES (11, '伊豆的舞女', 9, 4, '9787563351534', 26.78, 456, 1);
INSERT INTO `books`
VALUES (12, '堂吉诃德', 1, 2, '9787563352645', 27.87, 12, 1);
INSERT INTO `books`
VALUES (15, '111', 4, 4, '44444444', 11, 11, 1);

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`
(
    `id`          int                                                          NOT NULL COMMENT '城市序号',
    `name`        varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '城市名称',
    `province_id` int                                                          NOT NULL COMMENT '省份序号',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `province_city`(`province_id` ASC) USING BTREE,
    CONSTRAINT `province_city` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city`
VALUES (1, '北京市', 1);
INSERT INTO `city`
VALUES (2, '天津市', 2);
INSERT INTO `city`
VALUES (3, '上海市', 3);
INSERT INTO `city`
VALUES (4, '重庆市', 4);
INSERT INTO `city`
VALUES (5, '石家庄市', 5);
INSERT INTO `city`
VALUES (6, '唐山市', 5);
INSERT INTO `city`
VALUES (7, '秦皇岛市', 5);
INSERT INTO `city`
VALUES (8, '邯郸市', 5);
INSERT INTO `city`
VALUES (9, '邢台市', 5);
INSERT INTO `city`
VALUES (10, '保定市', 5);
INSERT INTO `city`
VALUES (11, '张家口市', 5);
INSERT INTO `city`
VALUES (12, '承德市', 5);
INSERT INTO `city`
VALUES (13, '沧州市', 5);
INSERT INTO `city`
VALUES (14, '廊坊市', 5);
INSERT INTO `city`
VALUES (15, '衡水市', 5);
INSERT INTO `city`
VALUES (16, '太原市', 6);
INSERT INTO `city`
VALUES (17, '大同市', 6);
INSERT INTO `city`
VALUES (18, '阳泉市', 6);
INSERT INTO `city`
VALUES (19, '长治市', 6);
INSERT INTO `city`
VALUES (20, '晋城市', 6);
INSERT INTO `city`
VALUES (21, '朔州市', 6);
INSERT INTO `city`
VALUES (22, '晋中市', 6);
INSERT INTO `city`
VALUES (23, '运城市', 6);
INSERT INTO `city`
VALUES (24, '忻州市', 6);
INSERT INTO `city`
VALUES (25, '临汾市', 6);
INSERT INTO `city`
VALUES (26, '吕梁市', 6);
INSERT INTO `city`
VALUES (27, '台北市', 7);
INSERT INTO `city`
VALUES (28, '高雄市', 7);
INSERT INTO `city`
VALUES (29, '基隆市', 7);
INSERT INTO `city`
VALUES (30, '台中市', 7);
INSERT INTO `city`
VALUES (31, '台南市', 7);
INSERT INTO `city`
VALUES (32, '新竹市', 7);
INSERT INTO `city`
VALUES (33, '嘉义市', 7);
INSERT INTO `city`
VALUES (34, '台北县', 7);
INSERT INTO `city`
VALUES (35, '宜兰县', 7);
INSERT INTO `city`
VALUES (36, '桃园县', 7);
INSERT INTO `city`
VALUES (37, '新竹县', 7);
INSERT INTO `city`
VALUES (38, '苗栗县', 7);
INSERT INTO `city`
VALUES (39, '台中县', 7);
INSERT INTO `city`
VALUES (40, '彰化县', 7);
INSERT INTO `city`
VALUES (41, '南投县', 7);
INSERT INTO `city`
VALUES (42, '云林县', 7);
INSERT INTO `city`
VALUES (43, '嘉义县', 7);
INSERT INTO `city`
VALUES (44, '台南县', 7);
INSERT INTO `city`
VALUES (45, '高雄县', 7);
INSERT INTO `city`
VALUES (46, '屏东县', 7);
INSERT INTO `city`
VALUES (47, '澎湖县', 7);
INSERT INTO `city`
VALUES (48, '台东县', 7);
INSERT INTO `city`
VALUES (49, '花莲县', 7);
INSERT INTO `city`
VALUES (50, '沈阳市', 8);
INSERT INTO `city`
VALUES (51, '大连市', 8);
INSERT INTO `city`
VALUES (52, '鞍山市', 8);
INSERT INTO `city`
VALUES (53, '抚顺市', 8);
INSERT INTO `city`
VALUES (54, '本溪市', 8);
INSERT INTO `city`
VALUES (55, '丹东市', 8);
INSERT INTO `city`
VALUES (56, '锦州市', 8);
INSERT INTO `city`
VALUES (57, '营口市', 8);
INSERT INTO `city`
VALUES (58, '阜新市', 8);
INSERT INTO `city`
VALUES (59, '辽阳市', 8);
INSERT INTO `city`
VALUES (60, '盘锦市', 8);
INSERT INTO `city`
VALUES (61, '铁岭市', 8);
INSERT INTO `city`
VALUES (62, '朝阳市', 8);
INSERT INTO `city`
VALUES (63, '葫芦岛市', 8);
INSERT INTO `city`
VALUES (64, '长春市', 9);
INSERT INTO `city`
VALUES (65, '吉林市', 9);
INSERT INTO `city`
VALUES (66, '四平市', 9);
INSERT INTO `city`
VALUES (67, '辽源市', 9);
INSERT INTO `city`
VALUES (68, '通化市', 9);
INSERT INTO `city`
VALUES (69, '白山市', 9);
INSERT INTO `city`
VALUES (70, '松原市', 9);
INSERT INTO `city`
VALUES (71, '白城市', 9);
INSERT INTO `city`
VALUES (72, '延边朝鲜族自治州', 9);
INSERT INTO `city`
VALUES (73, '哈尔滨市', 10);
INSERT INTO `city`
VALUES (74, '齐齐哈尔市', 10);
INSERT INTO `city`
VALUES (75, '鹤岗市', 10);
INSERT INTO `city`
VALUES (76, '双鸭山市', 10);
INSERT INTO `city`
VALUES (77, '鸡西市', 10);
INSERT INTO `city`
VALUES (78, '大庆市', 10);
INSERT INTO `city`
VALUES (79, '伊春市', 10);
INSERT INTO `city`
VALUES (80, '牡丹江市', 10);
INSERT INTO `city`
VALUES (81, '佳木斯市', 10);
INSERT INTO `city`
VALUES (82, '七台河市', 10);
INSERT INTO `city`
VALUES (83, '黑河市', 10);
INSERT INTO `city`
VALUES (84, '绥化市', 10);
INSERT INTO `city`
VALUES (85, '大兴安岭地区', 10);
INSERT INTO `city`
VALUES (86, '南京市', 11);
INSERT INTO `city`
VALUES (87, '无锡市', 11);
INSERT INTO `city`
VALUES (88, '徐州市', 11);
INSERT INTO `city`
VALUES (89, '常州市', 11);
INSERT INTO `city`
VALUES (90, '苏州市', 11);
INSERT INTO `city`
VALUES (91, '南通市', 11);
INSERT INTO `city`
VALUES (92, '连云港市', 11);
INSERT INTO `city`
VALUES (93, '淮安市', 11);
INSERT INTO `city`
VALUES (94, '盐城市', 11);
INSERT INTO `city`
VALUES (95, '扬州市', 11);
INSERT INTO `city`
VALUES (96, '镇江市', 11);
INSERT INTO `city`
VALUES (97, '泰州市', 11);
INSERT INTO `city`
VALUES (98, '宿迁市', 11);
INSERT INTO `city`
VALUES (99, '杭州市', 12);
INSERT INTO `city`
VALUES (100, '宁波市', 12);
INSERT INTO `city`
VALUES (101, '温州市', 12);
INSERT INTO `city`
VALUES (102, '嘉兴市', 12);
INSERT INTO `city`
VALUES (103, '湖州市', 12);
INSERT INTO `city`
VALUES (104, '绍兴市', 12);
INSERT INTO `city`
VALUES (105, '金华市', 12);
INSERT INTO `city`
VALUES (106, '衢州市', 12);
INSERT INTO `city`
VALUES (107, '舟山市', 12);
INSERT INTO `city`
VALUES (108, '台州市', 12);
INSERT INTO `city`
VALUES (109, '丽水市', 12);
INSERT INTO `city`
VALUES (110, '合肥市', 13);
INSERT INTO `city`
VALUES (111, '芜湖市', 13);
INSERT INTO `city`
VALUES (112, '蚌埠市', 13);
INSERT INTO `city`
VALUES (113, '淮南市', 13);
INSERT INTO `city`
VALUES (114, '马鞍山市', 13);
INSERT INTO `city`
VALUES (115, '淮北市', 13);
INSERT INTO `city`
VALUES (116, '铜陵市', 13);
INSERT INTO `city`
VALUES (117, '安庆市', 13);
INSERT INTO `city`
VALUES (118, '黄山市', 13);
INSERT INTO `city`
VALUES (119, '滁州市', 13);
INSERT INTO `city`
VALUES (120, '阜阳市', 13);
INSERT INTO `city`
VALUES (121, '宿州市', 13);
INSERT INTO `city`
VALUES (122, '巢湖市', 13);
INSERT INTO `city`
VALUES (123, '六安市', 13);
INSERT INTO `city`
VALUES (124, '亳州市', 13);
INSERT INTO `city`
VALUES (125, '池州市', 13);
INSERT INTO `city`
VALUES (126, '宣城市', 13);
INSERT INTO `city`
VALUES (127, '福州市', 14);
INSERT INTO `city`
VALUES (128, '厦门市', 14);
INSERT INTO `city`
VALUES (129, '莆田市', 14);
INSERT INTO `city`
VALUES (130, '三明市', 14);
INSERT INTO `city`
VALUES (131, '泉州市', 14);
INSERT INTO `city`
VALUES (132, '漳州市', 14);
INSERT INTO `city`
VALUES (133, '南平市', 14);
INSERT INTO `city`
VALUES (134, '龙岩市', 14);
INSERT INTO `city`
VALUES (135, '宁德市', 14);
INSERT INTO `city`
VALUES (136, '南昌市', 15);
INSERT INTO `city`
VALUES (137, '景德镇市', 15);
INSERT INTO `city`
VALUES (138, '萍乡市', 15);
INSERT INTO `city`
VALUES (139, '九江市', 15);
INSERT INTO `city`
VALUES (140, '新余市', 15);
INSERT INTO `city`
VALUES (141, '鹰潭市', 15);
INSERT INTO `city`
VALUES (142, '赣州市', 15);
INSERT INTO `city`
VALUES (143, '吉安市', 15);
INSERT INTO `city`
VALUES (144, '宜春市', 15);
INSERT INTO `city`
VALUES (145, '抚州市', 15);
INSERT INTO `city`
VALUES (146, '上饶市', 15);
INSERT INTO `city`
VALUES (147, '济南市', 16);
INSERT INTO `city`
VALUES (148, '青岛市', 16);
INSERT INTO `city`
VALUES (149, '淄博市', 16);
INSERT INTO `city`
VALUES (150, '枣庄市', 16);
INSERT INTO `city`
VALUES (151, '东营市', 16);
INSERT INTO `city`
VALUES (152, '烟台市', 16);
INSERT INTO `city`
VALUES (153, '潍坊市', 16);
INSERT INTO `city`
VALUES (154, '济宁市', 16);
INSERT INTO `city`
VALUES (155, '泰安市', 16);
INSERT INTO `city`
VALUES (156, '威海市', 16);
INSERT INTO `city`
VALUES (157, '日照市', 16);
INSERT INTO `city`
VALUES (158, '莱芜市', 16);
INSERT INTO `city`
VALUES (159, '临沂市', 16);
INSERT INTO `city`
VALUES (160, '德州市', 16);
INSERT INTO `city`
VALUES (161, '聊城市', 16);
INSERT INTO `city`
VALUES (162, '滨州市', 16);
INSERT INTO `city`
VALUES (163, '菏泽市', 16);
INSERT INTO `city`
VALUES (164, '郑州市', 17);
INSERT INTO `city`
VALUES (165, '开封市', 17);
INSERT INTO `city`
VALUES (166, '洛阳市', 17);
INSERT INTO `city`
VALUES (167, '平顶山市', 17);
INSERT INTO `city`
VALUES (168, '安阳市', 17);
INSERT INTO `city`
VALUES (169, '鹤壁市', 17);
INSERT INTO `city`
VALUES (170, '新乡市', 17);
INSERT INTO `city`
VALUES (171, '焦作市', 17);
INSERT INTO `city`
VALUES (172, '濮阳市', 17);
INSERT INTO `city`
VALUES (173, '许昌市', 17);
INSERT INTO `city`
VALUES (174, '漯河市', 17);
INSERT INTO `city`
VALUES (175, '三门峡市', 17);
INSERT INTO `city`
VALUES (176, '南阳市', 17);
INSERT INTO `city`
VALUES (177, '商丘市', 17);
INSERT INTO `city`
VALUES (178, '信阳市', 17);
INSERT INTO `city`
VALUES (179, '周口市', 17);
INSERT INTO `city`
VALUES (180, '驻马店市', 17);
INSERT INTO `city`
VALUES (181, '济源市', 17);
INSERT INTO `city`
VALUES (182, '武汉市', 18);
INSERT INTO `city`
VALUES (183, '黄石市', 18);
INSERT INTO `city`
VALUES (184, '十堰市', 18);
INSERT INTO `city`
VALUES (185, '荆州市', 18);
INSERT INTO `city`
VALUES (186, '宜昌市', 18);
INSERT INTO `city`
VALUES (187, '襄樊市', 18);
INSERT INTO `city`
VALUES (188, '鄂州市', 18);
INSERT INTO `city`
VALUES (189, '荆门市', 18);
INSERT INTO `city`
VALUES (190, '孝感市', 18);
INSERT INTO `city`
VALUES (191, '黄冈市', 18);
INSERT INTO `city`
VALUES (192, '咸宁市', 18);
INSERT INTO `city`
VALUES (193, '随州市', 18);
INSERT INTO `city`
VALUES (194, '仙桃市', 18);
INSERT INTO `city`
VALUES (195, '天门市', 18);
INSERT INTO `city`
VALUES (196, '潜江市', 18);
INSERT INTO `city`
VALUES (197, '神农架林区', 18);
INSERT INTO `city`
VALUES (198, '恩施土家族苗族自治州', 18);
INSERT INTO `city`
VALUES (199, '长沙市', 19);
INSERT INTO `city`
VALUES (200, '株洲市', 19);
INSERT INTO `city`
VALUES (201, '湘潭市', 19);
INSERT INTO `city`
VALUES (202, '衡阳市', 19);
INSERT INTO `city`
VALUES (203, '邵阳市', 19);
INSERT INTO `city`
VALUES (204, '岳阳市', 19);
INSERT INTO `city`
VALUES (205, '常德市', 19);
INSERT INTO `city`
VALUES (206, '张家界市', 19);
INSERT INTO `city`
VALUES (207, '益阳市', 19);
INSERT INTO `city`
VALUES (208, '郴州市', 19);
INSERT INTO `city`
VALUES (209, '永州市', 19);
INSERT INTO `city`
VALUES (210, '怀化市', 19);
INSERT INTO `city`
VALUES (211, '娄底市', 19);
INSERT INTO `city`
VALUES (212, '湘西土家族苗族自治州', 19);
INSERT INTO `city`
VALUES (213, '广州市', 20);
INSERT INTO `city`
VALUES (214, '深圳市', 20);
INSERT INTO `city`
VALUES (215, '珠海市', 20);
INSERT INTO `city`
VALUES (216, '汕头市', 20);
INSERT INTO `city`
VALUES (217, '韶关市', 20);
INSERT INTO `city`
VALUES (218, '佛山市', 20);
INSERT INTO `city`
VALUES (219, '江门市', 20);
INSERT INTO `city`
VALUES (220, '湛江市', 20);
INSERT INTO `city`
VALUES (221, '茂名市', 20);
INSERT INTO `city`
VALUES (222, '肇庆市', 20);
INSERT INTO `city`
VALUES (223, '惠州市', 20);
INSERT INTO `city`
VALUES (224, '梅州市', 20);
INSERT INTO `city`
VALUES (225, '汕尾市', 20);
INSERT INTO `city`
VALUES (226, '河源市', 20);
INSERT INTO `city`
VALUES (227, '阳江市', 20);
INSERT INTO `city`
VALUES (228, '清远市', 20);
INSERT INTO `city`
VALUES (229, '东莞市', 20);
INSERT INTO `city`
VALUES (230, '中山市', 20);
INSERT INTO `city`
VALUES (231, '潮州市', 20);
INSERT INTO `city`
VALUES (232, '揭阳市', 20);
INSERT INTO `city`
VALUES (233, '云浮市', 20);
INSERT INTO `city`
VALUES (234, '兰州市', 21);
INSERT INTO `city`
VALUES (235, '金昌市', 21);
INSERT INTO `city`
VALUES (236, '白银市', 21);
INSERT INTO `city`
VALUES (237, '天水市', 21);
INSERT INTO `city`
VALUES (238, '嘉峪关市', 21);
INSERT INTO `city`
VALUES (239, '武威市', 21);
INSERT INTO `city`
VALUES (240, '张掖市', 21);
INSERT INTO `city`
VALUES (241, '平凉市', 21);
INSERT INTO `city`
VALUES (242, '酒泉市', 21);
INSERT INTO `city`
VALUES (243, '庆阳市', 21);
INSERT INTO `city`
VALUES (244, '定西市', 21);
INSERT INTO `city`
VALUES (245, '陇南市', 21);
INSERT INTO `city`
VALUES (246, '临夏回族自治州', 21);
INSERT INTO `city`
VALUES (247, '甘南藏族自治州', 21);
INSERT INTO `city`
VALUES (248, '成都市', 22);
INSERT INTO `city`
VALUES (249, '自贡市', 22);
INSERT INTO `city`
VALUES (250, '攀枝花市', 22);
INSERT INTO `city`
VALUES (251, '泸州市', 22);
INSERT INTO `city`
VALUES (252, '德阳市', 22);
INSERT INTO `city`
VALUES (253, '绵阳市', 22);
INSERT INTO `city`
VALUES (254, '广元市', 22);
INSERT INTO `city`
VALUES (255, '遂宁市', 22);
INSERT INTO `city`
VALUES (256, '内江市', 22);
INSERT INTO `city`
VALUES (257, '乐山市', 22);
INSERT INTO `city`
VALUES (258, '南充市', 22);
INSERT INTO `city`
VALUES (259, '眉山市', 22);
INSERT INTO `city`
VALUES (260, '宜宾市', 22);
INSERT INTO `city`
VALUES (261, '广安市', 22);
INSERT INTO `city`
VALUES (262, '达州市', 22);
INSERT INTO `city`
VALUES (263, '雅安市', 22);
INSERT INTO `city`
VALUES (264, '巴中市', 22);
INSERT INTO `city`
VALUES (265, '资阳市', 22);
INSERT INTO `city`
VALUES (266, '阿坝藏族羌族自治州', 22);
INSERT INTO `city`
VALUES (267, '甘孜藏族自治州', 22);
INSERT INTO `city`
VALUES (268, '凉山彝族自治州', 22);
INSERT INTO `city`
VALUES (269, '贵阳市', 23);
INSERT INTO `city`
VALUES (270, '六盘水市', 23);
INSERT INTO `city`
VALUES (271, '遵义市', 23);
INSERT INTO `city`
VALUES (272, '安顺市', 23);
INSERT INTO `city`
VALUES (273, '铜仁地区', 23);
INSERT INTO `city`
VALUES (274, '毕节地区', 23);
INSERT INTO `city`
VALUES (275, '黔西南布依族苗族自治州', 23);
INSERT INTO `city`
VALUES (276, '黔东南苗族侗族自治州', 23);
INSERT INTO `city`
VALUES (277, '黔南布依族苗族自治州', 23);
INSERT INTO `city`
VALUES (278, '海口市', 24);
INSERT INTO `city`
VALUES (279, '三亚市', 24);
INSERT INTO `city`
VALUES (280, '五指山市', 24);
INSERT INTO `city`
VALUES (281, '琼海市', 24);
INSERT INTO `city`
VALUES (282, '儋州市', 24);
INSERT INTO `city`
VALUES (283, '文昌市', 24);
INSERT INTO `city`
VALUES (284, '万宁市', 24);
INSERT INTO `city`
VALUES (285, '东方市', 24);
INSERT INTO `city`
VALUES (286, '澄迈县', 24);
INSERT INTO `city`
VALUES (287, '定安县', 24);
INSERT INTO `city`
VALUES (288, '屯昌县', 24);
INSERT INTO `city`
VALUES (289, '临高县', 24);
INSERT INTO `city`
VALUES (290, '白沙黎族自治县', 24);
INSERT INTO `city`
VALUES (291, '昌江黎族自治县', 24);
INSERT INTO `city`
VALUES (292, '乐东黎族自治县', 24);
INSERT INTO `city`
VALUES (293, '陵水黎族自治县', 24);
INSERT INTO `city`
VALUES (294, '保亭黎族苗族自治县', 24);
INSERT INTO `city`
VALUES (295, '琼中黎族苗族自治县', 24);
INSERT INTO `city`
VALUES (296, '昆明市', 25);
INSERT INTO `city`
VALUES (297, '曲靖市', 25);
INSERT INTO `city`
VALUES (298, '玉溪市', 25);
INSERT INTO `city`
VALUES (299, '保山市', 25);
INSERT INTO `city`
VALUES (300, '昭通市', 25);
INSERT INTO `city`
VALUES (301, '丽江市', 25);
INSERT INTO `city`
VALUES (302, '思茅市', 25);
INSERT INTO `city`
VALUES (303, '临沧市', 25);
INSERT INTO `city`
VALUES (304, '文山壮族苗族自治州', 25);
INSERT INTO `city`
VALUES (305, '红河哈尼族彝族自治州', 25);
INSERT INTO `city`
VALUES (306, '西双版纳傣族自治州', 25);
INSERT INTO `city`
VALUES (307, '楚雄彝族自治州', 25);
INSERT INTO `city`
VALUES (308, '大理白族自治州', 25);
INSERT INTO `city`
VALUES (309, '德宏傣族景颇族自治州', 25);
INSERT INTO `city`
VALUES (310, '怒江傈傈族自治州', 25);
INSERT INTO `city`
VALUES (311, '迪庆藏族自治州', 25);
INSERT INTO `city`
VALUES (312, '西宁市', 26);
INSERT INTO `city`
VALUES (313, '海东地区', 26);
INSERT INTO `city`
VALUES (314, '海北藏族自治州', 26);
INSERT INTO `city`
VALUES (315, '黄南藏族自治州', 26);
INSERT INTO `city`
VALUES (316, '海南藏族自治州', 26);
INSERT INTO `city`
VALUES (317, '果洛藏族自治州', 26);
INSERT INTO `city`
VALUES (318, '玉树藏族自治州', 26);
INSERT INTO `city`
VALUES (319, '海西蒙古族藏族自治州', 26);
INSERT INTO `city`
VALUES (320, '西安市', 27);
INSERT INTO `city`
VALUES (321, '铜川市', 27);
INSERT INTO `city`
VALUES (322, '宝鸡市', 27);
INSERT INTO `city`
VALUES (323, '咸阳市', 27);
INSERT INTO `city`
VALUES (324, '渭南市', 27);
INSERT INTO `city`
VALUES (325, '延安市', 27);
INSERT INTO `city`
VALUES (326, '汉中市', 27);
INSERT INTO `city`
VALUES (327, '榆林市', 27);
INSERT INTO `city`
VALUES (328, '安康市', 27);
INSERT INTO `city`
VALUES (329, '商洛市', 27);
INSERT INTO `city`
VALUES (330, '南宁市', 28);
INSERT INTO `city`
VALUES (331, '柳州市', 28);
INSERT INTO `city`
VALUES (332, '桂林市', 28);
INSERT INTO `city`
VALUES (333, '梧州市', 28);
INSERT INTO `city`
VALUES (334, '北海市', 28);
INSERT INTO `city`
VALUES (335, '防城港市', 28);
INSERT INTO `city`
VALUES (336, '钦州市', 28);
INSERT INTO `city`
VALUES (337, '贵港市', 28);
INSERT INTO `city`
VALUES (338, '玉林市', 28);
INSERT INTO `city`
VALUES (339, '百色市', 28);
INSERT INTO `city`
VALUES (340, '贺州市', 28);
INSERT INTO `city`
VALUES (341, '河池市', 28);
INSERT INTO `city`
VALUES (342, '来宾市', 28);
INSERT INTO `city`
VALUES (343, '崇左市', 28);
INSERT INTO `city`
VALUES (344, '拉萨市', 29);
INSERT INTO `city`
VALUES (345, '那曲地区', 29);
INSERT INTO `city`
VALUES (346, '昌都地区', 29);
INSERT INTO `city`
VALUES (347, '山南地区', 29);
INSERT INTO `city`
VALUES (348, '日喀则地区', 29);
INSERT INTO `city`
VALUES (349, '阿里地区', 29);
INSERT INTO `city`
VALUES (350, '林芝地区', 29);
INSERT INTO `city`
VALUES (351, '银川市', 30);
INSERT INTO `city`
VALUES (352, '石嘴山市', 30);
INSERT INTO `city`
VALUES (353, '吴忠市', 30);
INSERT INTO `city`
VALUES (354, '固原市', 30);
INSERT INTO `city`
VALUES (355, '中卫市', 30);
INSERT INTO `city`
VALUES (356, '乌鲁木齐市', 31);
INSERT INTO `city`
VALUES (357, '克拉玛依市', 31);
INSERT INTO `city`
VALUES (358, '石河子市', 31);
INSERT INTO `city`
VALUES (359, '阿拉尔市', 31);
INSERT INTO `city`
VALUES (360, '图木舒克市', 31);
INSERT INTO `city`
VALUES (361, '五家渠市', 31);
INSERT INTO `city`
VALUES (362, '吐鲁番市', 31);
INSERT INTO `city`
VALUES (363, '阿克苏市', 31);
INSERT INTO `city`
VALUES (364, '喀什市', 31);
INSERT INTO `city`
VALUES (365, '哈密市', 31);
INSERT INTO `city`
VALUES (366, '和田市', 31);
INSERT INTO `city`
VALUES (367, '阿图什市', 31);
INSERT INTO `city`
VALUES (368, '库尔勒市', 31);
INSERT INTO `city`
VALUES (369, '昌吉市', 31);
INSERT INTO `city`
VALUES (370, '阜康市', 31);
INSERT INTO `city`
VALUES (371, '米泉市', 31);
INSERT INTO `city`
VALUES (372, '博乐市', 31);
INSERT INTO `city`
VALUES (373, '伊宁市', 31);
INSERT INTO `city`
VALUES (374, '奎屯市', 31);
INSERT INTO `city`
VALUES (375, '塔城市', 31);
INSERT INTO `city`
VALUES (376, '乌苏市', 31);
INSERT INTO `city`
VALUES (377, '阿勒泰市', 31);
INSERT INTO `city`
VALUES (378, '呼和浩特市', 32);
INSERT INTO `city`
VALUES (379, '包头市', 32);
INSERT INTO `city`
VALUES (380, '乌海市', 32);
INSERT INTO `city`
VALUES (381, '赤峰市', 32);
INSERT INTO `city`
VALUES (382, '通辽市', 32);
INSERT INTO `city`
VALUES (383, '鄂尔多斯市', 32);
INSERT INTO `city`
VALUES (384, '呼伦贝尔市', 32);
INSERT INTO `city`
VALUES (385, '巴彦淖尔市', 32);
INSERT INTO `city`
VALUES (386, '乌兰察布市', 32);
INSERT INTO `city`
VALUES (387, '锡林郭勒盟', 32);
INSERT INTO `city`
VALUES (388, '兴安盟', 32);
INSERT INTO `city`
VALUES (389, '阿拉善盟', 32);
INSERT INTO `city`
VALUES (390, '澳门特别行政区', 33);
INSERT INTO `city`
VALUES (391, '香港特别行政区', 34);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`
(
    `id`       int                                                          NOT NULL AUTO_INCREMENT COMMENT '管理员序号',
    `name`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
    `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage`
VALUES (1, 'admin', '123456');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`            int                                                    NOT NULL AUTO_INCREMENT COMMENT '订单序号',
    `book_name`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
    `quantity`      int                                                    NOT NULL COMMENT '购买数量',
    `price`         double                                                 NOT NULL COMMENT '单价',
    `total`         double                                                 NOT NULL COMMENT '合计',
    `user_id`       int                                                    NOT NULL COMMENT '用户序号',
    `purchase_time` datetime                                               NOT NULL COMMENT '购买时间',
    `out_fig`       int NULL DEFAULT NULL COMMENT '出库标志',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX           `user_order`(`user_id` ASC) USING BTREE,
    CONSTRAINT `user_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders`
VALUES (1, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (2, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (47, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (48, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (49, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (50, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 0);
INSERT INTO `orders`
VALUES (51, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 0);
INSERT INTO `orders`
VALUES (52, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (53, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 0);
INSERT INTO `orders`
VALUES (54, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (55, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (56, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (57, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (58, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (59, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (60, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (61, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (62, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (63, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (64, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 0);
INSERT INTO `orders`
VALUES (65, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 0);
INSERT INTO `orders`
VALUES (66, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (67, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (69, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);
INSERT INTO `orders`
VALUES (70, '笑傲江湖', 2, 34.67, 69.34, 6, '2023-03-13 14:12:05', 1);
INSERT INTO `orders`
VALUES (71, '双城记', 1, 45.53, 45.53, 8, '2023-03-23 14:12:00', 1);

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`
(
    `id`   int                                                          NOT NULL COMMENT '省份序号',
    `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省份名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province`
VALUES (1, '北京市');
INSERT INTO `province`
VALUES (2, '天津市');
INSERT INTO `province`
VALUES (3, '上海市');
INSERT INTO `province`
VALUES (4, '重庆市');
INSERT INTO `province`
VALUES (5, '河北省');
INSERT INTO `province`
VALUES (6, '山西省');
INSERT INTO `province`
VALUES (7, '台湾省');
INSERT INTO `province`
VALUES (8, '辽宁省');
INSERT INTO `province`
VALUES (9, '吉林省');
INSERT INTO `province`
VALUES (10, '黑龙江省');
INSERT INTO `province`
VALUES (11, '江苏省');
INSERT INTO `province`
VALUES (12, '浙江省');
INSERT INTO `province`
VALUES (13, '安徽省');
INSERT INTO `province`
VALUES (14, '福建省');
INSERT INTO `province`
VALUES (15, '江西省');
INSERT INTO `province`
VALUES (16, '山东省');
INSERT INTO `province`
VALUES (17, '河南省');
INSERT INTO `province`
VALUES (18, '湖北省');
INSERT INTO `province`
VALUES (19, '湖南省');
INSERT INTO `province`
VALUES (20, '广东省');
INSERT INTO `province`
VALUES (21, '甘肃省');
INSERT INTO `province`
VALUES (22, '四川省');
INSERT INTO `province`
VALUES (23, '贵州省');
INSERT INTO `province`
VALUES (24, '海南省');
INSERT INTO `province`
VALUES (25, '云南省');
INSERT INTO `province`
VALUES (26, '青海省');
INSERT INTO `province`
VALUES (27, '陕西省');
INSERT INTO `province`
VALUES (28, '广西壮族自治区');
INSERT INTO `province`
VALUES (29, '西藏自治区');
INSERT INTO `province`
VALUES (30, '宁夏回族自治区');
INSERT INTO `province`
VALUES (31, '新疆维吾尔自治区');
INSERT INTO `province`
VALUES (32, '内蒙古自治区');
INSERT INTO `province`
VALUES (33, '澳门特别行政区');
INSERT INTO `province`
VALUES (34, '香港特别行政区');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`
(
    `id`   int NOT NULL AUTO_INCREMENT COMMENT '图书类型序号',
    `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书类型名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type`
VALUES (1, '白话小说');
INSERT INTO `type`
VALUES (2, '古代名著');
INSERT INTO `type`
VALUES (3, '日常杂谈');
INSERT INTO `type`
VALUES (4, '神话传说');
INSERT INTO `type`
VALUES (5, '马克思主义');
INSERT INTO `type`
VALUES (6, '哲学');
INSERT INTO `type`
VALUES (7, '宗教');
INSERT INTO `type`
VALUES (8, '社会科学');
INSERT INTO `type`
VALUES (9, '政治');
INSERT INTO `type`
VALUES (10, '法律');
INSERT INTO `type`
VALUES (11, '军事');
INSERT INTO `type`
VALUES (12, '经济');
INSERT INTO `type`
VALUES (13, '文化');
INSERT INTO `type`
VALUES (14, '语言');
INSERT INTO `type`
VALUES (15, '文学');
INSERT INTO `type`
VALUES (16, '艺术');
INSERT INTO `type`
VALUES (17, '历史');
INSERT INTO `type`
VALUES (18, '地理');
INSERT INTO `type`
VALUES (19, '自然科学');
INSERT INTO `type`
VALUES (20, '数理科学');
INSERT INTO `type`
VALUES (21, '天文学');
INSERT INTO `type`
VALUES (22, '地球科学');
INSERT INTO `type`
VALUES (23, '生物科学');
INSERT INTO `type`
VALUES (24, '医药');
INSERT INTO `type`
VALUES (25, '农业科学');
INSERT INTO `type`
VALUES (26, '工业技术');
INSERT INTO `type`
VALUES (27, '交通运输');
INSERT INTO `type`
VALUES (28, '航空、航天');
INSERT INTO `type`
VALUES (29, '环境科学');
INSERT INTO `type`
VALUES (30, '综合性图书');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int                                                          NOT NULL AUTO_INCREMENT COMMENT '用户序号',
    `name`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
    `password`    varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
    `sex`         varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '性别',
    `phone`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
    `email`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
    `province_id` int                                                          NOT NULL COMMENT '省份序号',
    `city_id`     int                                                          NOT NULL COMMENT '城市序号',
    `address`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `city_user`(`city_id` ASC) USING BTREE,
    INDEX         `province_user`(`province_id` ASC) USING BTREE,
    CONSTRAINT `city_user` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `province_user` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (3, 'tl', '3453564', '男', '18864321082', '596688434@qq.com', 10, 81, NULL);
INSERT INTO `user`
VALUES (4, 'fw', '78567878', '女', '15113054666', '596538749@qq.com', 1, 1, '1111');
INSERT INTO `user`
VALUES (5, 'sqw', '8685654', '女', '17252316978', '596368934@qq.com', 15, 142, '');
INSERT INTO `user`
VALUES (6, 'cc', '0000', '男', '15488852781', '593689534@qq.com', 17, 177, NULL);
INSERT INTO `user`
VALUES (7, 'ljm', '4656745', '女', '18708284409', '593587434@qq.com', 19, 208, NULL);
INSERT INTO `user`
VALUES (8, 'dql', '8658678', '女', '15362429986', '5964678434@qq.com', 22, 32, NULL);
INSERT INTO `user`
VALUES (9, 'xq', '234242', '男', '15349276211', '125518434@qq.com', 24, 288, NULL);
INSERT INTO `user`
VALUES (10, 'xy', '7467456', '女', '15995187407', '596518234@qq.com', 28, 337, NULL);

-- ----------------------------
-- Function structure for generate_boyname
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_boyname`;
delimiter;;
CREATE FUNCTION `generate_boyname`()
    RETURNS varchar(2) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    declare
name varchar(2) default '';
    declare
i int default 0;
    declare
n int default 0;
    set
n = ceiling(rand()*2);
    while
i < n
    do
       set name = concat(name, elt(ceiling(rand()*1000)%200+1,"辰","逸","雨","泽","瑾","瑜","圣","杰","楷","瑞","浩","南","卡","思","旭","尧","俊","楠","天","磊","烨","伟","世","博","昊","哲","瀚","冠","明","辉","金","傲","越","材","霖","朋","健","柏","鸿","涛","懿","轩","鹏","煊","彬","益","弘","宸","苑","君","文","鑫","睿","渊","达","强","晓","啸","风","桦","驰","松","德","振","豪","鹤","绍","鼎","寒","志","靖","琪","擎","宇","国","龙","厉","诚","翰","超","晟","棋","沙","欧","智","劲","祺","皓","新","泰","佑","致","韵","舟","玮","伦","然","炫","星","野","雪","嘉","煜","城","昌","建","平","炎","峻","熙","洋","荣","展","远","图","翱","依","海","震","康","锋","崇","杭","运","贤","元","盛","江","春","凯","胜","福","来","聚","原","才","邦","庆","生","月","阳","岩","浪","晋","玄","欢","恒","羽","恩","青","余","波","修","永","润","若","信","勋","琦","晨","杉","畅","凡","翎","承","淘","茂","石","鉴","尚","唯","仁","敬","玉","全","帆","影","云","观","雷","常","柯","倚","向","镇","言","耀","耿","古","闻","名","东","悠","昆","宝","复","乔","柳","林","均"));
       set
i = i + 1;
end while;
return name;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for generate_brithplace
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_brithplace`;
delimiter;;
CREATE FUNCTION `generate_brithplace`()
    RETURNS varchar(32) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
return elt(ceiling(rand() * 100)%34+1, "河北省", "山西省", "辽宁省", "吉林省", "黑龙省", "江苏省", "浙江省", "安徽省",
           "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省 ",
           "云南省", "陕西省", "甘肃省", "青海省", "台湾省", "北京市", "上海市", "重庆市", "天津市", "广西", "宁夏",
           "西藏", "新疆", "内蒙古", "香港", "澳门");
end
;;
delimiter ;

-- ----------------------------
-- Function structure for generate_girlname
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_girlname`;
delimiter;;
CREATE FUNCTION `generate_girlname`()
    RETURNS varchar(2) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    declare
name varchar(2) default '';
    declare
i int default 0;
    declare
n int default 0;
    set
n = ceiling(rand()*2);
    while
i < n
    do
       set name = concat(name, elt(ceiling(rand()*1000)%200+1,"静","敏","燕","艳","丽","娟","莉","芳","萍","玲","娜","丹","洁","红","颖","琳","霞","婷","慧","莹","晶","华","倩","英","佳","梅","雪","蕾","琴","璐","伟","云","蓉","青","薇","欣","琼","宁","平","媛","虹","杰","婧","雯","茜","楠","洋","君","辉","菲","琦","妍","阳","波","俊","鑫","磊","军","爽","兰","晨","冰","瑶","瑾","岩","瑛","悦","群","玮","欢","瑜","蕊","宇","明","珊","荣","超","琪","玉","怡","文","岚","杨","婕","旭","凤","健","芬","芸","晓","萌","飞","露","菁","惠","宏","瑞","蓓","林","璇","珍","月","利","勤","清","帆","迪","微","斌","娇","影","巍","朋","莎","彬","峰","昕","乐","星","新","烨","晖","卉","晴","曼","越","靖","维","晔","艺","睿","芹","淼","黎","畅","椒","鹏","春","彦","柳","梦","毅","妮","坤","翠","然","钰","蔚","曦","茹","凌","扬","凡","美","彤","园","炜","捷","亮","叶","苗","菊","勇","锐","雨","力","翔","庆","方","琰","聪","潇","威","甜","帅","进","琛","花","雅","立","姣","馨","珏","秀","亚","珂","思","哲","冉","骊","双","娅","胡","培","斐","嘉","莲","莺","佩","剑"));
       set
i = i + 1;
end while;
return name;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for generate_name
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_name`;
delimiter;;
CREATE FUNCTION `generate_name`(sex varchar (2))
    RETURNS varchar(3) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    declare
firstname varchar(2) default '';
    declare
lastname varchar(2) default '';
    set
firstname = elt(ceiling(rand()*1000)%200+1,"赵","钱","孙","李","周","吴","郑","王","冯","陈","卫","蒋","沈","韩","杨","朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","范","彭","郎","鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","鲍","史","唐","费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常","乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄","和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧","计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁","杜","阮","蓝","席","季","麻","强","贾","路","娄","危","江","童","颜","郭","梅","盛","林","刁","钟","徐","邱","骆","高","夏","蔡","田","樊","胡","凌","霍","虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗","丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚","程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠");
    
    if
( sex = "男" ) then
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
delimiter;;
CREATE FUNCTION `generate_phone`()
    RETURNS varchar(11) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
    declare
phone varchar(11) default "1";
    declare
i int default 0;
    set
phone = concat(phone, elt(ceiling((rand()*10))%4+1,"3","5","7","8"));
    while
i < 9
    do
       set phone = concat(phone, elt(ceiling((rand()*10)),"0","1","2","3","4","5","6","7","8","9"));
       set
i = i + 1;
end while;
return phone;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for generate_sex
-- ----------------------------
DROP FUNCTION IF EXISTS `generate_sex`;
delimiter;;
CREATE FUNCTION `generate_sex`()
    RETURNS varchar(2) CHARSET utf8mb4 COLLATE utf8mb4_general_ci
begin
return elt(ceiling(rand() * 2), "男", "女");
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for proc_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_data`;
delimiter;;
CREATE PROCEDURE `proc_data`(in total int)
begin 
declare
i int default 1;
declare
phone varchar(32);
declare
sex varchar(2);
declare
continue handler for 1062
begin
select concat(i) "count", concat("phone ", phone, " alrady exist") "info";
set
i = i - 1 ;
end; 
while
i <= total do
    set phone = generate_phone();
    set
sex = generate_sex();
insert into `user`(name, sex, phone)
values (generate_name(sex), sex, phone);
set
i = i + 1 ;
end while;
end
;;
delimiter ;

SET
FOREIGN_KEY_CHECKS = 1;
