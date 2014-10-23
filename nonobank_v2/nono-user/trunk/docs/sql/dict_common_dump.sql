
-- ----------------------------
-- Records of DICT_COMMON
-- ----------------------------
INSERT INTO `DICT_COMMON` VALUES
  ('1', 'marriage', '1', '未婚', 'marriage.unmarried', '1'),
  ('2', 'marriage', '2', '未婚有育', 'marriage.premarital', '2'),
  ('3', 'marriage', '3', '已婚未育', 'marriage.married_nulliparous', '3'),
  ('4', 'marriage', '4', '已婚已育', 'marriage.married_procreated', '4'),
  ('5', 'marriage', '5', '离异', 'marriage.divorced', '5'),
  ('6', 'marriage', '6', '丧偶', 'marriage.widowed', '6');
INSERT INTO `DICT_COMMON` VALUES
  ('7', 'education', '1', '高中以下', 'edu.basis', '1'),
  ('8', 'education', '2', '中专及高中', 'edu.middle_school', '2'),
  ('9', 'education', '3', '大专', 'edu.junior_college', '3'),
  ('10', 'education', '4', '本科', 'edu.bachelor', '4'),
  ('11', 'education', '5', '硕士研究生', 'edu.master', '5'),
  ('12', 'education', '6', '博士研究生', 'doctor', '6');
INSERT INTO `DICT_COMMON` VALUES ('13', 'position', '1', 'CEO', null, '1');
INSERT INTO `DICT_COMMON` VALUES ('14', 'position', '2', 'IT架构设计师', null, '2');
INSERT INTO `DICT_COMMON` VALUES ('15', 'position', '3', '一般公司白领', null, '3');
INSERT INTO `DICT_COMMON` VALUES ('16', 'position', '4', '专家', null, '4');
INSERT INTO `DICT_COMMON` VALUES ('17', 'position', '5', '业务员', null, '5');
INSERT INTO `DICT_COMMON` VALUES ('18', 'position', '6', '业务拓展经理', null, '6');
INSERT INTO `DICT_COMMON` VALUES ('19', 'position', '7', '中介代理人员', null, '7');
INSERT INTO `DICT_COMMON` VALUES ('20', 'position', '8', '中学正/副校长', null, '8');
INSERT INTO `DICT_COMMON` VALUES ('21', 'position', '9', '中级管理人员 - IT架构设计师', null, '9');
INSERT INTO `DICT_COMMON` VALUES ('22', 'position', '10', '中级管理人员 - 保险精算师', null, '10');
INSERT INTO `DICT_COMMON` VALUES ('23', 'position', '11', '中级管理人员 - 厂长/副厂长', null, '11');
INSERT INTO `DICT_COMMON` VALUES ('24', 'position', '12', '中级管理人员 - 学校高级行政人员', null, '12');
INSERT INTO `DICT_COMMON` VALUES ('25', 'position', '13', '中级管理人员 - 幼儿园正/副园长', null, '13');
INSERT INTO `DICT_COMMON` VALUES ('26', 'position', '14', '中级管理人员 - 教授', null, '14');
INSERT INTO `DICT_COMMON` VALUES ('27', 'position', '15', '中级管理人员 - 经理/副经理', null, '15');
INSERT INTO `DICT_COMMON` VALUES ('28', 'position', '16', '中级管理人员 - 高级设计师', null, '16');
INSERT INTO `DICT_COMMON` VALUES ('29', 'position', '17', '主任', null, '17');
INSERT INTO `DICT_COMMON` VALUES ('30', 'position', '18', '主治(管）医/药/护/技师等中级技术职务', null, '18');
INSERT INTO `DICT_COMMON` VALUES ('31', 'position', '19', '主管', null, '19');
INSERT INTO `DICT_COMMON` VALUES ('32', 'position', '20', '主管/主任', null, '20');
INSERT INTO `DICT_COMMON` VALUES ('33', 'position', '21', '二/三甲医院正/副主任医/药/护/技师等高级技术职务', null, '21');
INSERT INTO `DICT_COMMON` VALUES ('34', 'position', '22', '二/三甲医院正/副院长', null, '22');
INSERT INTO `DICT_COMMON` VALUES ('35', 'position', '23', '人事专员/助理', null, '23');
INSERT INTO `DICT_COMMON` VALUES ('36', 'position', '24', '人力资源总监', null, '24');
INSERT INTO `DICT_COMMON` VALUES ('37', 'position', '25', '人力资源经理/主管', null, '25');
INSERT INTO `DICT_COMMON` VALUES ('38', 'position', '26', '会计人员', null, '26');
INSERT INTO `DICT_COMMON` VALUES ('39', 'position', '27', '会计师事务所正/副所长', null, '27');
INSERT INTO `DICT_COMMON` VALUES ('40', 'position', '28', '供应链', null, '28');
INSERT INTO `DICT_COMMON` VALUES ('41', 'position', '29', '保安', null, '29');
INSERT INTO `DICT_COMMON` VALUES ('42', 'position', '30', '保险代理人', null, '30');
INSERT INTO `DICT_COMMON` VALUES ('43', 'position', '31', '保险代理人/内勤', null, '31');
INSERT INTO `DICT_COMMON` VALUES ('44', 'position', '32', '保险精算师', null, '32');
INSERT INTO `DICT_COMMON` VALUES ('45', 'position', '33', '保险经纪人', null, '33');
INSERT INTO `DICT_COMMON` VALUES ('46', 'position', '34', '信贷/信用管理', null, '34');
INSERT INTO `DICT_COMMON` VALUES ('47', 'position', '35', '修理工', null, '35');
INSERT INTO `DICT_COMMON` VALUES ('48', 'position', '36', '停薪留职', null, '36');
INSERT INTO `DICT_COMMON` VALUES ('49', 'position', '37', '储备干部/培训生', null, '37');
INSERT INTO `DICT_COMMON` VALUES ('50', 'position', '38', '其他', null, '38');
INSERT INTO `DICT_COMMON` VALUES ('51', 'position', '39', '其他职位', null, '39');
INSERT INTO `DICT_COMMON` VALUES ('52', 'position', '40', '农民', null, '40');
INSERT INTO `DICT_COMMON` VALUES ('53', 'position', '41', '冲压/注塑/焊接', null, '41');
INSERT INTO `DICT_COMMON` VALUES ('54', 'position', '42', '列车长', null, '42');
INSERT INTO `DICT_COMMON` VALUES ('55', 'position', '43', '创意与策划', null, '43');
INSERT INTO `DICT_COMMON` VALUES ('56', 'position', '44', '初级管理人员 - 助理经理', null, '44');
INSERT INTO `DICT_COMMON` VALUES ('57', 'position', '45', '初级管理人员 - 店长', null, '45');
INSERT INTO `DICT_COMMON` VALUES ('58', 'position', '46', '前台/文员', null, '46');
INSERT INTO `DICT_COMMON` VALUES ('59', 'position', '47', '副教授', null, '47');
INSERT INTO `DICT_COMMON` VALUES ('60', 'position', '48', '办事处首席代表', null, '48');
INSERT INTO `DICT_COMMON` VALUES ('61', 'position', '49', '助理', null, '49');
INSERT INTO `DICT_COMMON` VALUES ('62', 'position', '50', '助理/秘书', null, '50');
INSERT INTO `DICT_COMMON` VALUES ('63', 'position', '51', '助理经理', null, '51');
INSERT INTO `DICT_COMMON` VALUES ('64', 'position', '52', '勤杂工', null, '52');
INSERT INTO `DICT_COMMON` VALUES ('65', 'position', '53', '化工人员', null, '53');
INSERT INTO `DICT_COMMON` VALUES ('66', 'position', '54', '医/护/技/师（士）', null, '54');
INSERT INTO `DICT_COMMON` VALUES ('67', 'position', '55', '医疗/护理', null, '55');
INSERT INTO `DICT_COMMON` VALUES ('68', 'position', '56', '医药代表', null, '56');
INSERT INTO `DICT_COMMON` VALUES ('69', 'position', '57', '厂长/副厂长', null, '57');
INSERT INTO `DICT_COMMON` VALUES ('70', 'position', '58', '厨师', null, '58');
INSERT INTO `DICT_COMMON` VALUES ('71', 'position', '59', '司机', null, '59');
INSERT INTO `DICT_COMMON` VALUES ('72', 'position', '60', '合伙人', null, '60');
INSERT INTO `DICT_COMMON` VALUES ('73', 'position', '61', '售票员', null, '61');
INSERT INTO `DICT_COMMON` VALUES ('74', 'position', '62', '商场导购', null, '62');
INSERT INTO `DICT_COMMON` VALUES ('75', 'position', '63', '土建工程师/建造师', null, '63');
INSERT INTO `DICT_COMMON` VALUES ('76', 'position', '64', '在校学生', null, '64');
INSERT INTO `DICT_COMMON` VALUES ('77', 'position', '65', '培训/教育', null, '65');
INSERT INTO `DICT_COMMON` VALUES ('78', 'position', '66', '培训经理/主管', null, '66');
INSERT INTO `DICT_COMMON` VALUES ('79', 'position', '67', '处级以上行政干部（公务员）', null, '67');
INSERT INTO `DICT_COMMON` VALUES ('80', 'position', '68', '多媒体/游戏开发', null, '68');
INSERT INTO `DICT_COMMON` VALUES ('81', 'position', '69', '大堂助理', null, '69');
INSERT INTO `DICT_COMMON` VALUES ('82', 'position', '70', '大学正/副校长', null, '70');
INSERT INTO `DICT_COMMON` VALUES ('83', 'position', '71', '失业', null, '71');
INSERT INTO `DICT_COMMON` VALUES ('84', 'position', '72', '学校一般行政人员', null, '72');
INSERT INTO `DICT_COMMON` VALUES ('85', 'position', '73', '学校高级行政人员', null, '73');
INSERT INTO `DICT_COMMON` VALUES ('86', 'position', '74', '学生', null, '74');
INSERT INTO `DICT_COMMON` VALUES ('87', 'position', '75', '实习生', null, '75');
INSERT INTO `DICT_COMMON` VALUES ('88', 'position', '76', '审计/税务', null, '76');
INSERT INTO `DICT_COMMON` VALUES ('89', 'position', '77', '客户咨询/热线支持', null, '77');
INSERT INTO `DICT_COMMON` VALUES ('90', 'position', '78', '客户经理/主管', null, '78');
INSERT INTO `DICT_COMMON` VALUES ('91', 'position', '79', '客房服务员', null, '79');
INSERT INTO `DICT_COMMON` VALUES ('92', 'position', '80', '家政人员', null, '80');
INSERT INTO `DICT_COMMON` VALUES ('93', 'position', '81', '导游', null, '81');
INSERT INTO `DICT_COMMON` VALUES ('94', 'position', '82', '导游/旅行顾问/票务', null, '82');
INSERT INTO `DICT_COMMON` VALUES ('95', 'position', '83', '工会主席/正/副党委书记', null, '83');
INSERT INTO `DICT_COMMON` VALUES ('96', 'position', '84', '工程师', null, '84');
INSERT INTO `DICT_COMMON` VALUES ('97', 'position', '85', '市场咨询/调研', null, '85');
INSERT INTO `DICT_COMMON` VALUES ('98', 'position', '86', '平面设计', null, '86');
INSERT INTO `DICT_COMMON` VALUES ('99', 'position', '87', '幼儿园正/副园长', null, '87');
INSERT INTO `DICT_COMMON` VALUES ('100', 'position', '88', '店长', null, '88');
INSERT INTO `DICT_COMMON` VALUES ('101', 'position', '89', '店面经理', null, '89');
INSERT INTO `DICT_COMMON` VALUES ('102', 'position', '90', '律师', null, '90');
INSERT INTO `DICT_COMMON` VALUES ('103', 'position', '91', '律师/法务', null, '91');
INSERT INTO `DICT_COMMON` VALUES ('104', 'position', '92', '律师事务所正/副所长', null, '92');
INSERT INTO `DICT_COMMON` VALUES ('105', 'position', '93', '快递送货员', null, '93');
INSERT INTO `DICT_COMMON` VALUES ('106', 'position', '94', '总工程师/副总工程师', null, '94');
INSERT INTO `DICT_COMMON` VALUES ('107', 'position', '95', '总经济师/银行行长/副行长', null, '95');
INSERT INTO `DICT_COMMON` VALUES ('108', 'position', '96', '总经理/副总经理/总监/副总监', null, '96');
INSERT INTO `DICT_COMMON` VALUES ('109', 'position', '97', '总裁/副总裁', null, '97');
INSERT INTO `DICT_COMMON` VALUES ('110', 'position', '98', '总裁助理/总经理助理', null, '98');
INSERT INTO `DICT_COMMON` VALUES ('111', 'position', '99', '房地产评估/中介/交易', null, '99');
INSERT INTO `DICT_COMMON` VALUES ('112', 'position', '100', '执行官/经理', null, '100');
INSERT INTO `DICT_COMMON` VALUES ('113', 'position', '101', '技工', null, '101');
INSERT INTO `DICT_COMMON` VALUES ('114', 'position', '102', '技术人员', null, '102');
INSERT INTO `DICT_COMMON` VALUES ('115', 'position', '103', '技术人员/工程师', null, '103');
INSERT INTO `DICT_COMMON` VALUES ('116', 'position', '104', '技术经理', null, '104');
INSERT INTO `DICT_COMMON` VALUES ('117', 'position', '105', '投融资项目/基金', null, '105');
INSERT INTO `DICT_COMMON` VALUES ('118', 'position', '106', '护理人员', null, '106');
INSERT INTO `DICT_COMMON` VALUES ('119', 'position', '107', '拍卖师', null, '107');
INSERT INTO `DICT_COMMON` VALUES ('120', 'position', '108', '招聘经理/主管', null, '108');
INSERT INTO `DICT_COMMON` VALUES ('121', 'position', '109', '搬运工', null, '109');
INSERT INTO `DICT_COMMON` VALUES ('122', 'position', '110', '收银员', null, '110');
INSERT INTO `DICT_COMMON` VALUES ('123', 'position', '111', '教授', null, '111');
INSERT INTO `DICT_COMMON` VALUES ('124', 'position', '112', '教授/老师/医生', null, '112');
INSERT INTO `DICT_COMMON` VALUES ('125', 'position', '113', '数据录入员', null, '113');
INSERT INTO `DICT_COMMON` VALUES ('126', 'position', '114', '时装模特', null, '114');
INSERT INTO `DICT_COMMON` VALUES ('127', 'position', '115', '普通公务员', null, '115');
INSERT INTO `DICT_COMMON` VALUES ('128', 'position', '116', '普通员工 - 一般公司白领', null, '116');
INSERT INTO `DICT_COMMON` VALUES ('129', 'position', '117', '普通员工 - 保险经纪人', null, '117');
INSERT INTO `DICT_COMMON` VALUES ('130', 'position', '118', '普通员工 - 医药代表', null, '118');
INSERT INTO `DICT_COMMON` VALUES ('131', 'position', '119', '普通员工 - 大堂助理', null, '119');
INSERT INTO `DICT_COMMON` VALUES ('132', 'position', '120', '普通技术工人', null, '120');
INSERT INTO `DICT_COMMON` VALUES ('133', 'position', '121', '普通职员', null, '121');
INSERT INTO `DICT_COMMON` VALUES ('134', 'position', '122', '有职业资格证书的技工', null, '122');
INSERT INTO `DICT_COMMON` VALUES ('135', 'position', '123', '服务人员', null, '123');
INSERT INTO `DICT_COMMON` VALUES ('136', 'position', '124', '服务人员/领班', null, '124');
INSERT INTO `DICT_COMMON` VALUES ('137', 'position', '125', '机械设计/制图', null, '125');
INSERT INTO `DICT_COMMON` VALUES ('138', 'position', '126', '机电/给排水/暖通工程师', null, '126');
INSERT INTO `DICT_COMMON` VALUES ('139', 'position', '127', '水利/水电工程师', null, '127');
INSERT INTO `DICT_COMMON` VALUES ('140', 'position', '128', '注册会计师', null, '128');
INSERT INTO `DICT_COMMON` VALUES ('141', 'position', '129', '测试工程师', null, '129');
INSERT INTO `DICT_COMMON` VALUES ('142', 'position', '130', '海员', null, '130');
INSERT INTO `DICT_COMMON` VALUES ('143', 'position', '131', '清洁工', null, '131');
INSERT INTO `DICT_COMMON` VALUES ('144', 'position', '132', '演员/歌星', null, '132');
INSERT INTO `DICT_COMMON` VALUES ('145', 'position', '133', '物业管理', null, '133');
INSERT INTO `DICT_COMMON` VALUES ('146', 'position', '134', '物料/仓库管理', null, '134');
INSERT INTO `DICT_COMMON` VALUES ('147', 'position', '135', '物流经理/主管', null, '135');
INSERT INTO `DICT_COMMON` VALUES ('148', 'position', '136', '特/高级教师', null, '136');
INSERT INTO `DICT_COMMON` VALUES ('149', 'position', '137', '环保工程师', null, '137');
INSERT INTO `DICT_COMMON` VALUES ('150', 'position', '138', '理货员', null, '138');
INSERT INTO `DICT_COMMON` VALUES ('151', 'position', '139', '生产工艺/技术', null, '139');
INSERT INTO `DICT_COMMON` VALUES ('152', 'position', '140', '生产经理/车间主任', null, '140');
INSERT INTO `DICT_COMMON` VALUES ('153', 'position', '141', '电力工程师', null, '141');
INSERT INTO `DICT_COMMON` VALUES ('154', 'position', '142', '电子/电路工程师', null, '142');
INSERT INTO `DICT_COMMON` VALUES ('155', 'position', '143', '电气工程师', null, '143');
INSERT INTO `DICT_COMMON` VALUES ('156', 'position', '144', '监理/安全工程师', null, '144');
INSERT INTO `DICT_COMMON` VALUES ('157', 'position', '145', '矿工', null, '145');
INSERT INTO `DICT_COMMON` VALUES ('158', 'position', '146', '研究员', null, '146');
INSERT INTO `DICT_COMMON` VALUES ('159', 'position', '147', '硬件开发工程师', null, '147');
INSERT INTO `DICT_COMMON` VALUES ('160', 'position', '148', '礼仪', null, '148');
INSERT INTO `DICT_COMMON` VALUES ('161', 'position', '149', '离/退休', null, '149');
INSERT INTO `DICT_COMMON` VALUES ('162', 'position', '150', '科研人员', null, '150');
INSERT INTO `DICT_COMMON` VALUES ('163', 'position', '151', '科研机构正/副所长', null, '151');
INSERT INTO `DICT_COMMON` VALUES ('164', 'position', '152', '科级以上行政干部（公务员）', null, '152');
INSERT INTO `DICT_COMMON` VALUES ('165', 'position', '153', '空运/海运操作', null, '153');
INSERT INTO `DICT_COMMON` VALUES ('166', 'position', '154', '精算师', null, '154');
INSERT INTO `DICT_COMMON` VALUES ('167', 'position', '155', '纺织/服装设计', null, '155');
INSERT INTO `DICT_COMMON` VALUES ('168', 'position', '156', '经理', null, '156');
INSERT INTO `DICT_COMMON` VALUES ('169', 'position', '157', '经理/副经理', null, '157');
INSERT INTO `DICT_COMMON` VALUES ('170', 'position', '158', '经理助理', null, '158');
INSERT INTO `DICT_COMMON` VALUES ('171', 'position', '159', '结构/建筑工程师', null, '159');
INSERT INTO `DICT_COMMON` VALUES ('172', 'position', '160', '编辑/记者/文案', null, '160');
INSERT INTO `DICT_COMMON` VALUES ('173', 'position', '161', '美容按摩师', null, '161');
INSERT INTO `DICT_COMMON` VALUES ('174', 'position', '162', '自由职业者', null, '162');
INSERT INTO `DICT_COMMON` VALUES ('175', 'position', '163', '艺术家', null, '163');
INSERT INTO `DICT_COMMON` VALUES ('176', 'position', '164', '营业员', null, '164');
INSERT INTO `DICT_COMMON` VALUES ('177', 'position', '165', '营业员/收银员', null, '165');
INSERT INTO `DICT_COMMON` VALUES ('178', 'position', '166', '营运总监/经理', null, '166');
INSERT INTO `DICT_COMMON` VALUES ('179', 'position', '167', '董事/总经理/总裁', null, '167');
INSERT INTO `DICT_COMMON` VALUES ('180', 'position', '168', '薪资福利经理/主管', null, '168');
INSERT INTO `DICT_COMMON` VALUES ('181', 'position', '169', '行政干部', null, '169');
INSERT INTO `DICT_COMMON` VALUES ('182', 'position', '170', '行政总监', null, '170');
INSERT INTO `DICT_COMMON` VALUES ('183', 'position', '171', '行政经理', null, '171');
INSERT INTO `DICT_COMMON` VALUES ('184', 'position', '172', '行李员', null, '172');
INSERT INTO `DICT_COMMON` VALUES ('185', 'position', '173', '装潢/陈列设计', null, '173');
INSERT INTO `DICT_COMMON` VALUES ('186', 'position', '174', '证券/期货', null, '174');
INSERT INTO `DICT_COMMON` VALUES ('187', 'position', '175', '证券/期货/房地产经纪人', null, '175');
INSERT INTO `DICT_COMMON` VALUES ('188', 'position', '176', '财务主管', null, '176');
INSERT INTO `DICT_COMMON` VALUES ('189', 'position', '177', '财务总监', null, '177');
INSERT INTO `DICT_COMMON` VALUES ('190', 'position', '178', '财务经理', null, '178');
INSERT INTO `DICT_COMMON` VALUES ('191', 'position', '179', '质量管理', null, '179');
INSERT INTO `DICT_COMMON` VALUES ('192', 'position', '180', '贸易经理/主管', null, '180');
INSERT INTO `DICT_COMMON` VALUES ('193', 'position', '181', '软件开发工程师', null, '181');
INSERT INTO `DICT_COMMON` VALUES ('194', 'position', '182', '退休人员', null, '182');
INSERT INTO `DICT_COMMON` VALUES ('195', 'position', '183', '通讯工程师', null, '183');
INSERT INTO `DICT_COMMON` VALUES ('196', 'position', '184', '邮递员', null, '184');
INSERT INTO `DICT_COMMON` VALUES ('197', 'position', '185', '酒店/宾馆管理', null, '185');
INSERT INTO `DICT_COMMON` VALUES ('198', 'position', '186', '采购专员/助理', null, '186');
INSERT INTO `DICT_COMMON` VALUES ('199', 'position', '187', '采购经理/主管', null, '187');
INSERT INTO `DICT_COMMON` VALUES ('200', 'position', '188', '金融分析师', null, '188');
INSERT INTO `DICT_COMMON` VALUES ('201', 'position', '189', '钟点工', null, '189');
INSERT INTO `DICT_COMMON` VALUES ('202', 'position', '190', '银行专员/柜台', null, '190');
INSERT INTO `DICT_COMMON` VALUES ('203', 'position', '191', '销售/市场', null, '191');
INSERT INTO `DICT_COMMON` VALUES ('204', 'position', '192', '销售主管/主任', null, '192');
INSERT INTO `DICT_COMMON` VALUES ('205', 'position', '193', '销售代表', null, '193');
INSERT INTO `DICT_COMMON` VALUES ('206', 'position', '194', '销售助理', null, '194');
INSERT INTO `DICT_COMMON` VALUES ('207', 'position', '195', '销售工程师', null, '195');
INSERT INTO `DICT_COMMON` VALUES ('208', 'position', '196', '销售总监', null, '196');
INSERT INTO `DICT_COMMON` VALUES ('209', 'position', '197', '销售经理', null, '197');
INSERT INTO `DICT_COMMON` VALUES ('210', 'position', '198', '项目管理', null, '198');
INSERT INTO `DICT_COMMON` VALUES ('211', 'position', '199', '项目经理', null, '199');
INSERT INTO `DICT_COMMON` VALUES ('212', 'position', '200', '领班', null, '200');
INSERT INTO `DICT_COMMON` VALUES ('213', 'position', '201', '风险管理', null, '201');
INSERT INTO `DICT_COMMON` VALUES ('214', 'position', '202', '餐饮/娱乐管理', null, '202');
INSERT INTO `DICT_COMMON` VALUES ('215', 'position', '203', '首席信息官（CIO）', null, '203');
INSERT INTO `DICT_COMMON` VALUES ('216', 'position', '204', '首席执行官/运营官', null, '204');
INSERT INTO `DICT_COMMON` VALUES ('217', 'position', '205', '首席技术官（CTO）', null, '205');
INSERT INTO `DICT_COMMON` VALUES ('218', 'position', '206', '首席财务管（CFO）', null, '206');
INSERT INTO `DICT_COMMON` VALUES ('219', 'position', '207', '高级工程师', null, '207');
INSERT INTO `DICT_COMMON` VALUES ('220', 'position', '208', '高级研究员', null, '208');
INSERT INTO `DICT_COMMON` VALUES ('221', 'position', '209', '高级经理', null, '209');
INSERT INTO `DICT_COMMON` VALUES ('222', 'position', '210', '高级设计师', null, '210');

INSERT INTO `DICT_COMMON` VALUES ('223', 'skillCert', '1', '政府机关事业单位国有企业中层以上或高级职称', null, '1');
INSERT INTO `DICT_COMMON` VALUES ('224', 'skillCert', '2', '注册会计师等国家颁布的资格证书', null, '2');
INSERT INTO `DICT_COMMON` VALUES ('225', 'skillCert', '3', '软件工程师等技术专业人才', null, '3');
INSERT INTO `DICT_COMMON` VALUES ('226', 'skillCert', '4', '中级职称', null, '4');
INSERT INTO `DICT_COMMON` VALUES ('227', 'skillCert', '5', '会计上岗证', null, '5');
INSERT INTO `DICT_COMMON` VALUES ('228', 'skillCert', '6', '中高级会计师', null, '6');
INSERT INTO `DICT_COMMON` VALUES ('229', 'skillCert', '7', '注册金融分析师', null, '7');
INSERT INTO `DICT_COMMON` VALUES ('230', 'skillCert', '8', '保险精算师', null, '8');
INSERT INTO `DICT_COMMON` VALUES ('231', 'skillCert', '9', '律师证', null, '9');
INSERT INTO `DICT_COMMON` VALUES ('232', 'skillCert', '10', '具有其他就业技能', null, '10');
INSERT INTO `DICT_COMMON` VALUES ('233', 'skillCert', '11', '无上述职称或技能证书', null, '11');
