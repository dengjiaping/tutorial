CREATE TABLE IF NOT EXISTS `members` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,                     -- UserAccount(UserProfile):USER_ID
  `ceb_mid` varchar(12) DEFAULT NULL,                         -- 无用(待确认)
  `m_username` varchar(50) NOT NULL COMMENT '用户名',          -- UserAccount(UserProfile):USER_NAME
  `m_key` varchar(32) DEFAULT NULL COMMENT 'md5加密后的用户名', -- UserAccount(UserProfile):HASHED_KEY
  `m_password` varchar(50) DEFAULT NULL COMMENT '登录密码(MD5)',  -- UserAccount:OLD_HASHED_PASSWD
  `is_del` tinyint(1) DEFAULT '0' COMMENT '删除',                -- UserAccount:IS_DELETED
  `login_count` int(11) DEFAULT '0' COMMENT '登陆次数',
  `time` datetime DEFAULT NULL COMMENT '注册时间',
  `sign_time` varchar(20) DEFAULT NULL COMMENT '登陆时间',
  `revious_login` varchar(20) DEFAULT NULL COMMENT '上次登录时间',
  `sign_ip` varchar(20) DEFAULT NULL COMMENT '登陆ip',
  `revious_ip` varchar(20) DEFAULT NULL COMMENT '上次登陆ip',
  
  `is_lend` tinyint(1) DEFAULT '0' COMMENT '是否是借出者',
  `is_borrow` tinyint(1) DEFAULT '0' COMMENT '是否是借入者',
  `m_publish_debt` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可以发布债权',
  `is_special` tinyint(1) DEFAULT '0' COMMENT '是否特殊客户',
  `m_reborrow_type` tinyint(1) DEFAULT '0' COMMENT '用户的再借款类型，0未使用，1表示借新还旧',
  `m_reborrow_status` int(1) DEFAULT '0' COMMENT '客服跟贷款状态:0,1,2正在跟,3续贷,4不续',
  
  `m_borrow_type` varchar(10) DEFAULT '理财' COMMENT '用户的借款类型，值：企业主，白领',  -- UserProfile:USER_TYPE
  `m_borrow_type_time` datetime DEFAULT NULL COMMENT '身份选择的时间',                 -- UserProfile:USER_TYPE_TIME
  
  `validate_mobile` varchar(11) DEFAULT NULL COMMENT '手机验证',
  `send_mobile_time` varchar(12) DEFAULT NULL COMMENT '发送时间',
  
  `is_mail` tinyint(1) DEFAULT '0',
  `validate_mail` varchar(200) DEFAULT NULL,
  `province_id` int(5) DEFAULT NULL COMMENT '当前所在省份',
  `city_id` int(5) DEFAULT NULL COMMENT '当前所在城市',
  `m_avatar` varchar(50) DEFAULT NULL COMMENT '头像',
  `m_avatar_b` varchar(255) DEFAULT NULL COMMENT '',           -- UserAccount:AVATAR
  `pc_id` int(11) DEFAULT '1' COMMENT '所属公司',
  `member_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户类型，如员工，借款用户',
  
  `is_deception` tinyint(1) DEFAULT '0' COMMENT '欺诈行为',
  `deception_info` text COMMENT '欺诈行为信息',
  
  `is_card` tinyint(1) DEFAULT '0' COMMENT '身份认证通过',
  `card_needcheck` tinyint(1) DEFAULT '0' COMMENT '自动通过，需要审核的',
  `m_nono_id_checked` int(11) NOT NULL DEFAULT '0' COMMENT '是否做过免费认证',
  `is_mobile` tinyint(1) DEFAULT '0' COMMENT '手机通过',
  `is_video` tinyint(1) DEFAULT '0' COMMENT '视频认证',
  `is_video_info` tinyint(1) DEFAULT '0' COMMENT '请求视频认证 1为请求,2,返回重新上传,0还没有认证 3通过',
  `is_student` tinyint(1) DEFAULT '0' COMMENT '学籍认证是否通过',
  `is_education` tinyint(1) DEFAULT '0' COMMENT '学历认证',
  `valid_education` varchar(20) DEFAULT NULL COMMENT '学历验证码',
  `create_edu_time` datetime DEFAULT NULL COMMENT '提交学历认证时间',
  `is_taobao` tinyint(1) DEFAULT '0' COMMENT '是否是淘宝大卖家',
  `taobao_name` varchar(40) DEFAULT NULL COMMENT '淘宝帐号',
  `is_alipay` tinyint(1) DEFAULT '0' COMMENT '是否关联支付宝账号',
  `alipay_userid` varchar(30) DEFAULT NULL COMMENT '支付宝数字ID',
  `alipay_realname` varchar(300) DEFAULT NULL COMMENT '支付宝真实姓名',
  `alipay_phone` varchar(20) DEFAULT NULL COMMENT '支付宝电话',
  
  `qqopenid` varchar(50) DEFAULT NULL COMMENT 'QQ的openid',
  `sinaid` varchar(50) DEFAULT NULL COMMENT '新浪微博用户ID',
  
  `borrow_count` int(11) DEFAULT '0' COMMENT '成功次数',
  `stream_count` int(11) DEFAULT '0' COMMENT '流标次数',
  `bidding_count` int(11) DEFAULT '0' COMMENT '会员投标成功次数',
  
  `m_password_pay` varchar(50) DEFAULT '' COMMENT '支付密码',
  `m_pass_question` varchar(40) DEFAULT NULL COMMENT '密码安全问题',
  `m_pass_answer` varchar(40) DEFAULT NULL COMMENT '安全问题答案',
  
  `lend_score` varchar(50) DEFAULT '0' COMMENT '借出者积分',
  
  `is_dunning` tinyint(1) DEFAULT '0' COMMENT '是否开始线下催收',
  `ver_state` tinyint(4) DEFAULT '0' COMMENT '审核进度',
  `ver_time` varchar(11) DEFAULT NULL COMMENT '审核时间',
  `ver_recent_time` varchar(20) DEFAULT NULL COMMENT '最近提交时间',
  `normalFAExtno` varchar(45) DEFAULT NULL,
  `profile_update_time` datetime DEFAULT NULL,
  `is_guide` tinyint(1) NOT NULL DEFAULT '0',
  `am_id_add` int(11) DEFAULT NULL COMMENT '创建用的销售人员id',
  `am_id_add_bak` int(11) DEFAULT NULL COMMENT '销售id的backup',
  `am_id_add_assign_time` datetime DEFAULT NULL COMMENT '销售分配时间',
  `am_id_add_assign_remark` varchar(1000) DEFAULT NULL COMMENT '销售分配备注',
  `am_id_follow` int(11) DEFAULT NULL COMMENT '来源渠道',
  `am_id_follow_cs` int(10) DEFAULT NULL COMMENT '负责跟踪的客服',
  `am_id_follow_cs_time` datetime DEFAULT NULL,
  `am_id_follow_invest` int(11) DEFAULT NULL COMMENT '负责跟踪的理财人员',
  `m_assurance_id` varchar(100) DEFAULT NULL COMMENT '线下用户担保人id',
  `m_audit_result` tinyint(4) NOT NULL DEFAULT '0' COMMENT '审核结果:1表示审核完\r\n\r\n成；2表示回退；3表示进入终审',
  `m_audit_remark` varchar(1000) DEFAULT NULL COMMENT '审核备注',
  `is_assess_charge` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否评估收费',
  `assess_charge_value` smallint(10) DEFAULT NULL COMMENT '评估收费',
  `is_email_send` varchar(500) DEFAULT NULL COMMENT '不接收的邮件类型',
  `m_exist_bidding` tinyint(4) NOT NULL DEFAULT '0',
  `m_is_protected` int(11) NOT NULL DEFAULT '0',
  `m_protected_endtime` datetime DEFAULT NULL,
  `m_caifu_id` int(11) DEFAULT NULL COMMENT '财富顾问ID',
  `m_caifu_id_bak` int(11) DEFAULT NULL COMMENT '保存之前的财富人员',
  `m_caifu_assign_time` datetime DEFAULT NULL,
  `m_recommender_id` int(11) DEFAULT NULL COMMENT '推荐会员ID',
  `channel_source_id` int(11) DEFAULT NULL COMMENT '渠道来源iD',
  `tel_record` varchar(100) DEFAULT NULL COMMENT '电话记录',
  `m_assign_caifu_id` int(11) DEFAULT NULL,
  `m_is_offline_recharge` tinyint(1) DEFAULT '0' COMMENT '线下充值用户',
  `bo_repay_empower` varchar(500) DEFAULT NULL COMMENT '还款授权',
  `m_contact_record` varchar(100) DEFAULT NULL COMMENT '联系记录',
  `is_old` tinyint(1) DEFAULT '1' COMMENT '财经道那边传过来的用户，1：老用户；0：新用户',
  `uaccount` varchar(30) DEFAULT NULL COMMENT '财经道那边传过来的用户名（回传用）',
  `m_my_server` int(11) DEFAULT NULL COMMENT '为我服务的校园大使m_id',
  `m_is_server` tinyint(1) DEFAULT NULL COMMENT '1：是校园大使',
  `m_is_server_admin` tinyint(1) DEFAULT '0' COMMENT '是否校园管理大使',
  
  PRIMARY KEY (`m_id`),
  UNIQUE KEY `m_username` (`m_username`),
  KEY `is_del` (`is_del`),
  KEY `is_assurance` (`is_special`),
  KEY `is_eception` (`is_deception`),
  KEY `m_ver_state` (`ver_state`),
  KEY `m_assurance_id` (`m_assurance_id`),
  KEY `m_caifu_id` (`m_caifu_id`),
  KEY `am_id_add` (`am_id_add`),
  KEY `am_id_follow` (`am_id_follow`),
  KEY `am_id_follow_cs` (`am_id_follow_cs`),
  KEY `m_recommender_id` (`m_recommender_id`),
  KEY `m_assign_caifu_id` (`m_assign_caifu_id`),
  KEY `sinaid` (`sinaid`),
  KEY `m_borrow_type` (`m_borrow_type`),
  KEY `m_my_server` (`m_my_server`),
  KEY `m_is_server` (`m_is_server`),
  KEY `is_video_info` (`is_video_info`),
  KEY `is_special` (`is_special`),
  KEY `is_mobile` (`is_mobile`),
  KEY `m_key` (`m_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `members_field_details` (
  `mfd_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `m_id` int(10) unsigned NOT NULL COMMENT '用户ID',
-- 用户基本信息
  `realname` varchar(20) DEFAULT NULL COMMENT '真实姓名',  -- UserProfile:REAL_NAME
  `usedname` varchar(20) DEFAULT NULL COMMENT '曾用名',    -- UserProfile:FORMER_NAME
  `englishname` varchar(20) DEFAULT NULL COMMENT '英文名', -- UserProfile:ENGLISH_NAME
  `idnum` varchar(18) DEFAULT NULL COMMENT '身份证号',     -- UserProfile:ID_CARD
  `age` varchar(3) DEFAULT NULL COMMENT '年龄',           -- UserProfile:age
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',           -- UserProfile:GENDER
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',       -- UserProfile:EMAIL
  `mobilenum` varchar(20) DEFAULT NULL COMMENT '手机号码', -- UserProfile(UserAccount):MOBILE_NO
  `qq` varchar(100) DEFAULT NULL COMMENT 'QQ号码',        -- UserProfile:QQ
  `cur_province` varchar(10) DEFAULT NULL COMMENT '当前所在省份',  -- UserProfile:LIVE_PROVINCE
  `cur_city` varchar(20) DEFAULT NULL COMMENT '当前所在城市',      -- UserProfile:LIVE_CITY
  `cur_address` varchar(100) DEFAULT NULL COMMENT '当前地址',     -- UserProfile:LIVE_ADDRESS
  `cur_phone` varchar(20) DEFAULT NULL COMMENT '居住地电话',      -- UserProfile:LIVE_CONTACT
  `huji_province` varchar(10) DEFAULT NULL COMMENT '户籍所在省份',  -- UserProfile:CENSUS_PROVINCE
  `huji_city` varchar(20) DEFAULT NULL COMMENT '户籍所在城市',      -- UserProfile:CENSUS_CITY
  `huji_address` varchar(100) DEFAULT NULL COMMENT '户籍地址',     -- UserProfile:CENSUS_ADDRESS
  `marriage` varchar(100) DEFAULT NULL COMMENT '婚姻',             -- UserProfile:MARRIAGE
  `education` varchar(100) DEFAULT NULL COMMENT '学历',            -- UserProfile:EDUCATION
  `passport` varchar(1) DEFAULT NULL COMMENT '护照',               -- UserProfile:PASSPORT
  `mobilenum2` varchar(100) DEFAULT NULL COMMENT '手机号码2',       -- UserProfile:MOBILE_NO2
  `shebao` varchar(1) DEFAULT NULL COMMENT '社保',                  -- UserProfile:SOCIAL_SECURITY
  `driving` varchar(1) DEFAULT NULL COMMENT '驾照',                -- UserProfile:DRIVING
  `work_type` tinyint(1) DEFAULT '0',

-- 公司相关信息
  `company` varchar(100) DEFAULT NULL COMMENT '公司名称', -- company_name
  `company_type` varchar(100) DEFAULT NULL COMMENT '公司性质', -- company_business_type
  `company_business` varchar(100) DEFAULT NULL COMMENT '公司行业',
  `company_business_sort` varchar(200) DEFAULT NULL COMMENT '具体企业类别',
  `company_business_sort_remark` varchar(300) DEFAULT NULL COMMENT '具体企业类别描述',
  `job` varchar(100) DEFAULT NULL COMMENT '职位',
  `company_depart` varchar(20) DEFAULT NULL COMMENT '所属部门',
  `company_tel` varchar(50) DEFAULT NULL COMMENT '公司电话', -- company_phone
  `company_district` varchar(20) DEFAULT NULL COMMENT '公司所在区',
  `company_address` varchar(100) DEFAULT NULL COMMENT '公司地址', -- company_place_address
  `company_website` varchar(100) DEFAULT NULL COMMENT '公司网站',
  `company_name` varchar(50) DEFAULT NULL COMMENT '企业名称',
  `company_products` varchar(100) DEFAULT NULL COMMENT '公司主要产品/服务',
  `company_age` varchar(4) DEFAULT NULL COMMENT '公司成立年限',
  `company_shareholders` varchar(100) DEFAULT NULL COMMENT '公司股东数量',
  `company_myshare` varchar(5) DEFAULT NULL COMMENT '我的股份比例',
  `company_place` varchar(100) DEFAULT NULL COMMENT '经营场所',
  `company_place_address` varchar(150) DEFAULT NULL COMMENT '详细经营场所地址',
  `company_phone` varchar(25) DEFAULT NULL COMMENT '企业固定电话',
  `company_rent` varchar(10) DEFAULT NULL COMMENT '租金',
  `company_rent_cycle` varchar(100) DEFAULT NULL COMMENT '租金时间单位',
  `company_renters` varchar(20) DEFAULT NULL COMMENT '公司租房房东名',
  `company_renters_contact` varchar(100) DEFAULT NULL COMMENT '公司租房房东联系方式',
  `company_account_bank` varchar(100) DEFAULT NULL COMMENT '公司账户开户行',
  `company_netprofit_lastyear` varchar(100) DEFAULT NULL COMMENT '公司上年度净利润',
  `company_employeenum` varchar(100) DEFAULT NULL COMMENT '公司雇佣人数',
  `company_loans` varchar(100) DEFAULT NULL COMMENT '公司是否有经营性贷款',
  `company_otherinfo` varchar(500) DEFAULT NULL COMMENT '其他说明',
  `company_remark` varchar(500) DEFAULT NULL COMMENT '备注说明',
  `company_account` varchar(100) DEFAULT NULL COMMENT '账号',
  `company_monthly_repay` varchar(100) DEFAULT NULL COMMENT '公司每月还款',
  `company_business_type` varchar(100) DEFAULT NULL COMMENT '企业类型',
  `company_income_stream` varchar(100) DEFAULT NULL COMMENT '公司利润来源',
  `company_this_year_income` varchar(10) DEFAULT NULL,
  `company_found_date` varchar(50) DEFAULT NULL,
  `company_check_up` varchar(50) DEFAULT NULL,
  `company_place_age` varchar(100) DEFAULT NULL COMMENT '特殊要求',
  `company_income_business` varchar(200) DEFAULT NULL,
  `company_before_year_income` varchar(10) DEFAULT NULL COMMENT '前年营业收入',
  `company_laset_year_income` varchar(10) DEFAULT NULL COMMENT '去年营业收入',
  `before_declare_dutiable_goods` varchar(100) DEFAULT NULL COMMENT '前年报税金额', --  ??
  `last_declare_dutiable_goods` varchar(100) DEFAULT NULL COMMENT '去年报税金额',  -- ??

  `second_contact_name` varchar(25) DEFAULT NULL COMMENT '第二联系人姓名',
  `second_contact_relation` varchar(100) DEFAULT NULL COMMENT '第二联系人关系',
  `second_contact_mobile` varchar(100) DEFAULT NULL COMMENT '第二联系人手机号码',
  `second_contact_work` varchar(100) DEFAULT NULL COMMENT '第二联系人工作单位',
  `contact_comment` varchar(300) DEFAULT NULL COMMENT '联系人备注',
  `msn` varchar(100) DEFAULT NULL COMMENT 'msn',
  `other_contact` varchar(100) DEFAULT NULL COMMENT '其他联系方式',
  `my_website` varchar(800) DEFAULT NULL COMMENT '其他网址',
  `personal_desc` varchar(300) DEFAULT NULL COMMENT '个人描述',
  `trade_success` varchar(5) DEFAULT NULL COMMENT '成功交易加分',
  `site` varchar(100) DEFAULT NULL COMMENT '网站加分',
  `late_repay` varchar(100) DEFAULT NULL COMMENT '逾期还款扣分',
  `reported` varchar(100) DEFAULT NULL COMMENT '被举报扣分',
  `friend_comment` varchar(100) DEFAULT NULL COMMENT 'friend_comment',
  `withdraw` varchar(100) DEFAULT NULL COMMENT '撤回借款扣分',
  `invite` varchar(100) DEFAULT NULL COMMENT '邀请得分',
  `skillcert` varchar(100) DEFAULT NULL COMMENT '职称和技能证书',       -- UserProfile:POSITION
  `monthly_wage_income` decimal(18,2) DEFAULT '0.00' COMMENT '月均工资流水',

  `creditcard_limit` varchar(20) DEFAULT NULL COMMENT '银行卡最高信用额',

  `job_level` varchar(100) DEFAULT NULL COMMENT '工作级别',
  `job_leave_remark` varchar(200) DEFAULT NULL COMMENT '工作级别及职位描述',
  `working_life_all` varchar(100) DEFAULT NULL COMMENT '总工作年限',
  `work_refer` varchar(25) DEFAULT NULL COMMENT '证明人（同事）',
  `work_refer_contact` varchar(100) DEFAULT NULL COMMENT '证明人联系方式',

-- 配偶信息
  `spouse_name` varchar(100) DEFAULT NULL COMMENT '配偶名称',
  `spouse_idnum` varchar(18) DEFAULT NULL COMMENT '配偶的身份证号码',
  `spouse_mobile` varchar(100) DEFAULT NULL COMMENT '配偶手机号码',
  `spouse_company` varchar(100) DEFAULT NULL COMMENT '配偶单位名称',
  `spouse_company_dept` varchar(100) DEFAULT NULL COMMENT '配偶所在部门名称',
  `spouse_monthly_income` varchar(100) DEFAULT NULL COMMENT '配偶月收入',
  `spouse_company_phone` varchar(100) DEFAULT NULL COMMENT '配偶单位电话',
  `spouse_company_address` varchar(100) DEFAULT NULL COMMENT '配偶单位地址',
  `spouse_comment` varchar(1000) DEFAULT NULL COMMENT '配偶评论',

  `ext_contact_mobiles` varchar(200) DEFAULT NULL COMMENT '其他联系人手机',
  `working_life_now` varchar(100) DEFAULT NULL COMMENT '现单位工作期限',

  `nobank_borrowing` varchar(100) DEFAULT NULL COMMENT '其他非银行机构借款总额',
  `net_borrowing` varchar(100) DEFAULT NULL COMMENT '其他网络借贷平台借款总额',

  `skill_other` varchar(100) DEFAULT NULL COMMENT '其他就业技能',
  `house_status` varchar(20) DEFAULT NULL COMMENT '住房条件',
  `house_info` varchar(1500) DEFAULT NULL COMMENT '房产信息',
  `car_status` varchar(20) DEFAULT NULL COMMENT '车产',
  `car_info` varchar(300) DEFAULT NULL COMMENT '车产信息',
  `bank_highest_late_record` varchar(100) DEFAULT NULL COMMENT '银行最高逾期记录',
  `bank_late_amount_now` varchar(100) DEFAULT NULL COMMENT '银行当前逾期金额',
  `bank_late_reason` varchar(100) DEFAULT NULL COMMENT '银行逾期原因',
  `creditcard_bank` varchar(100) DEFAULT NULL COMMENT '信用卡发卡银行',
  `monthly_bankcard_income` decimal(18,2) DEFAULT '0.00' COMMENT '月均个人常用银行卡进账流水',
  `monthly_bankcard_payout` decimal(18,2) DEFAULT '0.00' COMMENT '月均个人常用银行卡支出流水',
  `monthly_company_income` varchar(100) DEFAULT NULL COMMENT '月均公司银行进账流水',
  `education_info` varchar(1500) DEFAULT NULL COMMENT '教育经历',
  `bank_highest_late_day` varchar(100) DEFAULT NULL COMMENT '最长连续逾期天数',
  `approach` varchar(255) NOT NULL DEFAULT '推广营销渠道',
  `approach2` varchar(255) DEFAULT NULL COMMENT '推广营销渠道',
  `approach3` varchar(255) DEFAULT NULL COMMENT '推广营销渠道',
  `approach_detail` varchar(50) DEFAULT NULL COMMENT '渠道来源名称',
  `finance_name` varchar(10) DEFAULT NULL COMMENT '财务姓名',
  `finance_phone` varchar(20) DEFAULT NULL COMMENT '财务电话',
  `capital_landlord` varchar(20) DEFAULT NULL,
  `capital_landlord_contact` varchar(100) DEFAULT NULL,
  `legal_person` varchar(20) DEFAULT NULL COMMENT '法人姓名',
  `legal_person_contact` varchar(100) DEFAULT NULL COMMENT '法人联系方式',
  `house_monthly_repayment` varchar(10) DEFAULT NULL COMMENT '住房月还款金额',

  `house_rent` varchar(10) DEFAULT NULL COMMENT '住房月租金',
  `house_remark` varchar(500) DEFAULT NULL COMMENT '住房其他请注明',

  `credit_cards_maxamount` varchar(10) DEFAULT NULL COMMENT '单张信用卡最高额度',
  `credit_cards_maxbank` varchar(10) DEFAULT NULL COMMENT '单张信用卡最高额度发卡银行',

  `creditcard_overdraw` varchar(100) DEFAULT NULL COMMENT '信用卡透支总金额',
  `creditcard_monthly_repayment` varchar(100) DEFAULT NULL COMMENT '每月信用卡还款金额',
  `unsecured_loan` varchar(100) DEFAULT NULL COMMENT '银行无抵押贷款总金额',
  `unsecured_loan_monthly_repayment` varchar(100) DEFAULT NULL COMMENT '每月银行无抵押贷款还款金额',

  `secured_loan_unrepay` varchar(10) DEFAULT NULL COMMENT '银行机构抵押贷款未还金额',
  `secured_loan_unrepay_monthly_repayment` varchar(10) DEFAULT NULL COMMENT '银行机构抵押贷款未还金额每月还款',
  `secured_loan_unrepay_info` varchar(100) DEFAULT NULL COMMENT '银行机构抵押贷款未还金额',

  `unsecured_loan_unrepay` varchar(10) DEFAULT NULL COMMENT '银行机构无抵押贷款未还金额',
  `unsecured_loan_unrepay_monthly_repayment` varchar(10) DEFAULT NULL COMMENT '银行机构无抵押贷款未还金额每月还款',
  `unsecured_loan_unrepay_info` varchar(100) DEFAULT NULL COMMENT '银行机构无抵押贷款未还金额',

  `nobank_secured_loan_unrepay` varchar(10) DEFAULT NULL COMMENT '非银行机构抵押贷款金额',
  `nobank_secured_loan_unrepay_monthly_repayment` varchar(10) DEFAULT NULL COMMENT '非银行机构抵押贷款金额每月还款',
  `nobank_secured_loan_unrepay_info` varchar(100) DEFAULT NULL COMMENT '非银行机构抵押贷款金额',

  `nobank_unsecured_loan_unrepay` varchar(10) DEFAULT NULL COMMENT '非银行机构无抵押贷款金额',
  `nobank_unsecured_loan_unrepay_monthly_repayment` varchar(10) DEFAULT NULL COMMENT '银行机构无抵押贷款金额每月还款',
  `nobank_unsecured_loan_unrepay_info` varchar(100) DEFAULT NULL COMMENT '非银行机构无抵押贷款金额',

  `out_secured_loan_unrepay` varchar(10) DEFAULT NULL COMMENT '对外担保贷款未还金额',
  `out_secured_loan_unrepay_monthly_repayment` varchar(10) DEFAULT NULL COMMENT '对外担保贷款每月还款',
  `capital_house` varchar(1) DEFAULT NULL COMMENT '房产',
  `capital_car` varchar(1) DEFAULT NULL COMMENT '车产',
  `capital_stock` varchar(1) DEFAULT NULL COMMENT '股票',
  `capital_fund` varchar(1) DEFAULT NULL COMMENT '基金',
  `capital_shop` varchar(1) DEFAULT NULL COMMENT '商铺',
  `capital_other` varchar(1) DEFAULT NULL COMMENT '其他',
  `capital_other_text` varchar(500) DEFAULT NULL COMMENT '其他说明',
  `is_spouse_know` tinyint(1) DEFAULT '0' COMMENT '是否知晓此项贷款',
  `colleague_post` varchar(10) DEFAULT NULL COMMENT '同事职位',
  `is_legal_know` tinyint(1) NOT NULL DEFAULT '0' COMMENT '法人代表人是否知晓此项贷款',
  `production_sites` varchar(10) DEFAULT NULL COMMENT '生产场所',
  `production_sites_addr` varchar(100) DEFAULT NULL COMMENT '详细生产场所地址',
  `production_renters` varchar(50) DEFAULT NULL COMMENT '生产场所出租方',
  `production_renters_contact` varchar(100) DEFAULT NULL COMMENT '生产场所出租方联系方式',
  `production_addr_age` varchar(100) DEFAULT NULL COMMENT '特殊要求',
  `m_criminal_status` varchar(20) DEFAULT NULL COMMENT '犯罪情况',
  `m_criminal_deal_time` datetime DEFAULT NULL COMMENT '刑侦结果出现时间',
  `m_criminal_info` varchar(500) DEFAULT NULL COMMENT '刑侦详情',
  `spec_other_text` varchar(100) DEFAULT NULL COMMENT '特殊情况',
  `busniss_time` varchar(50) DEFAULT NULL,
  `other_contact_name` varchar(100) DEFAULT NULL COMMENT '亲属姓名',
  `other_contact_relation` varchar(100) DEFAULT NULL COMMENT '亲属关系',
  `other_contact_mobile` varchar(100) DEFAULT NULL COMMENT '亲属电话',
  `this_declare_dutiable_goods` varchar(10) DEFAULT NULL,
  `house_property` longtext COMMENT '审核房产情况',
  `car_property` longtext COMMENT '审核车产情况',
  `creditcard_statu` longtext COMMENT '审核征信',
  `spec_admin_text` varchar(200) DEFAULT NULL,
  `is_zhengxin` varchar(1) DEFAULT NULL,
  `overdue_record` longtext COMMENT '征信逾期情况',
  `base_benefits` int(10) DEFAULT NULL COMMENT '缴纳基数',
  `continu_pay_time` int(10) DEFAULT '0' COMMENT '连续缴纳时间',
  `provident_fund` int(10) DEFAULT NULL COMMENT '公积金',
  `pf_continue_pay_time` int(10) DEFAULT NULL COMMENT '公积金连续缴纳时间',

  -- 学校信息
  `institution` varchar(100) DEFAULT NULL COMMENT '院校。如：复旦大学医学院',
  `major` varchar(100) DEFAULT NULL COMMENT '专业',
  `into_school_time` varchar(20) DEFAULT NULL COMMENT '入校时间',
  `weixin` varchar(20) DEFAULT NULL COMMENT '微信号',
  `address_school` varchar(100) DEFAULT NULL COMMENT '详细地址（校园）',
  `address_home` varchar(100) DEFAULT NULL COMMENT '详细地址（老家）',
  `first_contact_name` varchar(20) DEFAULT NULL COMMENT '第一联系人姓名',
  `first_contact_mobile` varchar(100) DEFAULT NULL COMMENT '第一联系人手机号',
  `mfd_student_sn` varchar(30) DEFAULT NULL COMMENT '学号',
  `guarantees_remark` varchar(300) DEFAULT NULL COMMENT '抵押物情况',
  `bad_information_remark` varchar(300) DEFAULT NULL COMMENT '负面信息查询',

  PRIMARY KEY (`mfd_id`) USING BTREE,
  UNIQUE KEY `m_id` (`m_id`),
  KEY `realname` (`realname`),
  KEY `mobilenum` (`mobilenum`),
  KEY `mobilenum2` (`mobilenum2`),
  KEY `idnum` (`idnum`),
  KEY `company_name` (`company_name`),
  KEY `spouse_company` (`spouse_company`),
  KEY `spouse_idnum` (`spouse_idnum`),
  KEY `spouse_mobile` (`spouse_mobile`),
  KEY `approach` (`approach`),
  KEY `approach_detail` (`approach_detail`),
  KEY `institution` (`institution`),
  KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;