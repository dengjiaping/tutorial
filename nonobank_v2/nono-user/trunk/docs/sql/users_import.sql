
-- 重构前的数据导入重构后的数据库 - 用户系统
-- created by Fuchun 2014-10-13
-- @(#) version $Id: users_import.sql 281 2014-10-24 08:41:15Z fuchun $

-- ---------------------------------------------------------------------------------
-- 会员表数据处理
-- ---------------------------------------------------------------------------------
UPDATE members SET m_avatar = null WHERE m_avatar = '';
UPDATE members SET m_borrow_type = '理财' WHERE m_borrow_type IN ('', '2', '=理财', 'çè´¢');
UPDATE members SET m_pass_question = null WHERE  m_pass_question = '';
UPDATE members SET m_pass_answer = null WHERE  m_pass_answer = '';

-- 数据从老的数据表导到新的表结构
INSERT INTO USER_ACCOUNT
(USER_ID, USER_NAME, HASHED_KEY, AVATAR, MOBILE_NO, OLD_HASHED_PASSWD,
 PASSWD_QUESTION, PASSWD_ANSWER, IS_DELETED, LAST_MODIFIED_DATE, CREATED_DATE)
  (
    SELECT m.m_id, m.m_username, m.m_key, m.m_avatar_b, mf.mobilenum, m.m_password,
      m.m_pass_question, m.m_pass_answer, m.is_del, m.profile_update_time, m.time
    FROM members m, members_field_details mf
    WHERE m.m_id = mf.m_id
  );

-- 修复密码哈希未加盐的问题
UPDATE USER_ACCOUNT SET
  OLD_HASHED_PASSWD = NULL,
  PASSWD_SALT = RAND_STR(16),
  HASHED_PASSWD = SHA1(CONCAT(OLD_HASHED_PASSWD, '{', PASSWD_SALT, '}'))
WHERE PASSWD_SALT IS NOT NULL;

-- 修复安全问题答案是明文的问题
UPDATE USER_ACCOUNT SET
  ANSWER_SALT = RAND_STR(12),
  PASSWD_ANSWER = SHA1(CONCAT(PASSWD_ANSWER, '_[', ANSWER_SALT, ']'))
WHERE PASSWD_QUESTION IS NOT NULL AND ANSWER_SALT IS NOT NULL;

-- ---------------------------------------------------------------------------------
-- 会员详细信息表数据处理
-- ---------------------------------------------------------------------------------

-- 测试执行时间：~ 60s
UPDATE members_field_details SET `sex` = 'N' WHERE `sex` IS NULL OR `sex` = '';
-- 测试执行时间：~ 10s
UPDATE members_field_details SET `sex` = 'F' WHERE `sex` = '女';
-- 测试执行时间：~ 14s
UPDATE members_field_details SET `sex` = 'M' WHERE `sex` = '男' OR `sex` = '1';

-- 修正 marriage 属性值
UPDATE members_field_details SET marriage = '0' WHERE marriage = '' OR marriage IS NULL;
UPDATE members_field_details SET marriage = '1' WHERE marriage = '未婚';
UPDATE members_field_details SET marriage = '2' WHERE marriage IN ('已婚', '未婚有育', '未婚已育');
UPDATE members_field_details SET marriage = '3' WHERE marriage IN ('已婚未育', '已婚无育');
UPDATE members_field_details SET marriage = '4' WHERE marriage = '已婚已育';
UPDATE members_field_details SET marriage = '5' WHERE marriage = '离异';
UPDATE members_field_details SET marriage = '6' WHERE marriage = '丧偶';
UPDATE members_field_details SET marriage = '0' WHERE marriage NOT IN ('0', '1', '2', '3', '4', '5', '6');

-- 修正 education 属性值
UPDATE members_field_details SET education = '0' WHERE education = '' OR education IS NULL;
UPDATE members_field_details SET education = '1' WHERE education IN ('小学', '高中以下');
UPDATE members_field_details SET education = '2' WHERE education IN ('中专及高中', '中专');
UPDATE members_field_details SET education = '3' WHERE education = '大专';
UPDATE members_field_details SET education = '4' WHERE education = '本科';
UPDATE members_field_details SET education = '5' WHERE education IN ('硕士研究生', '硕士及以上');
UPDATE members_field_details SET education = '6' WHERE education = '博士研究生';
UPDATE members_field_details SET education = '0' WHERE education NOT IN ('0', '1', '2', '3', '4', '5', '6');

-- 修正 shebao, passport, driving 属性值
UPDATE members_field_details SET shebao = null WHERE shebao = '';
UPDATE members_field_details SET passport = null WHERE passport = '';
UPDATE members_field_details SET driving = null WHERE driving = '';

UPDATE members_field_details SET shebao = 'Y' WHERE shebao = '有';
UPDATE members_field_details SET passport = 'Y' WHERE passport = '有';
UPDATE members_field_details SET driving = 'Y' WHERE driving = '有';
UPDATE members_field_details SET shebao = 'N' WHERE shebao = '无';
UPDATE members_field_details SET passport = 'N' WHERE passport = '无';
UPDATE members_field_details SET driving = 'N' WHERE driving = '无';

-- 修正 age, email 属性值
UPDATE members_field_details SET `age` = null WHERE `age` = '';
UPDATE members_field_details SET `email` = null WHERE `email` = '';
UPDATE members_field_details SET `idnum` = null WHERE `idnum` = '';
UPDATE members_field_details SET `realname` = null WHERE `realname` = '';
UPDATE members_field_details SET `huji_province` = null WHERE `huji_province` = '';
UPDATE members_field_details SET `huji_city` = null WHERE `huji_city` = '';
UPDATE members_field_details SET `huji_address` = null WHERE `huji_address` = '';
UPDATE members_field_details SET `cur_province` = null WHERE `cur_province` = '';
UPDATE members_field_details SET `cur_city` = null WHERE `cur_city` = '';
UPDATE members_field_details SET `cur_address` = null WHERE `cur_address` = '';
UPDATE members_field_details SET `cur_phone` = null WHERE `cur_phone` = '';
UPDATE members_field_details SET `qq` = null WHERE `qq` = '';
UPDATE members_field_details SET `mobilenum` = null WHERE `mobilenum` = '';
UPDATE members_field_details SET `mobilenum2` = null WHERE `mobilenum2` = '';
UPDATE members_field_details SET `englishname` = null WHERE `englishname` = '';
UPDATE members_field_details SET `usedname` = null WHERE `usedname` = '';

-- 修正 job 属性值。添加一个 job 的临时索引，用于快速更新数据
ALTER TABLE `members_field_details`
ADD INDEX `idx_mfd_job` (`job`) USING BTREE ;
-- （测试运行：~~ 9s）
UPDATE members_field_details SET job = null WHERE job = '';
-- 执行此句更新前，必须要建立一个 job 的临时索引，否则会执行超过20分钟
UPDATE members_field_details mf, DICT_COMMON md SET job = D_CODE
WHERE mf.job = D_NAME AND job IS NOT NULL AND TYPE_KEY = 'position';

UPDATE members_field_details mf, DICT_COMMON md SET skillcert = D_CODE
WHERE mf.skillcert = D_NAME AND skillcert IS NOT NULL AND TYPE_KEY = 'skillCert';

UPDATE members_field_details SET skillcert = null WHERE skillcert = '';

UPDATE members_field_details m SET m.marriage = null WHERE m.marriage = 0;
UPDATE members_field_details m SET m.education = null WHERE m.education = 0;
UPDATE members_field_details m SET m.job = null WHERE m.job = 0;

-- 修复脏数据 institution
UPDATE members_field_details SET institution = NULL WHERE institution = '杭州';
UPDATE members_field_details SET institution = '中国矿业大学(徐州)' WHERE institution = '中国矿业大学';
UPDATE members_field_details SET into_school_time = NULL WHERE into_school_time <= 1949;


-- 导 USER_PROFILE 表
INSERT INTO USER_PROFILE (
  USER_ID, USER_NAME, HASHED_KEY, ENGLISH_NAME, FORMER_NAME, MOBILE_NO, MOBILE_NO2, MOBILE_VERIFIED,
  EMAIL, EMAIL_VERIFIED, ID_CARD, REAL_NAME, GENDER, AGE, CENSUS_PROVINCE, CENSUS_CITY, CENSUS_ADDRESS,
  LIVE_PROVINCE, LIVE_CITY, LIVE_ADDRESS, LIVE_CONTACT, QQ, MARRIAGE, EDUCATION, POSITION, SKILL_CERT,
  SOCIAL_SECURITY, PASSPORT, DRIVING, USER_TYPE, USER_TYPE_TIME, LAST_MODIFIED_DATE, CREATED_DATE
)
  (SELECT m.m_id, m.m_username, m.m_key, mf.englishname, mf.usedname, mf.mobilenum, mf.mobilenum2,
     m.is_mobile, mf.email, m.is_mail, mf.idnum, mf.realname, mf.sex, mf.age, mf.huji_province,
     mf.huji_city, mf.huji_address, mf.cur_province, mf.cur_city, mf.cur_address, mf.cur_phone,
     mf.qq, mf.marriage, mf.education, mf.job, mf.skillcert, mf.shebao, mf.passport, mf.driving,
     m.m_borrow_type, m.m_borrow_type_time, m.profile_update_time, m.time
   FROM members m, members_field_details mf
   WHERE m.m_id = mf.m_id);

-- 将不是数字且大于100的年龄字段值置为null
UPDATE USER_PROFILE SET AGE = null WHERE AGE NOT BETWEEN 1 AND 100;


-- 导入 USER_SOCIAL 表
INSERT INTO USER_SOCIAL
(USER_ID, USER_NAME, OPEN_ID, SOCIAL_SOURCE,
 TOKEN_UPDATE_TIME, LAST_MODIFIED_DATE, CREATED_DATE)
  (SELECT m.m_id, m.m_username, m.qqopenid, 'QQ', m.profile_update_time, m.profile_update_time, m.time from
    members m, members_field_details mf
  WHERE m.m_id = mf.m_id AND m.qqopenid is not null);

INSERT INTO USER_SOCIAL
(USER_ID, USER_NAME, OPEN_ID, SOCIAL_SOURCE,
 TOKEN_UPDATE_TIME, LAST_MODIFIED_DATE, CREATED_DATE)
  (SELECT m.m_id, m.m_username, m.qqopenid, 'WEIBO', m.profile_update_time, m.profile_update_time, m.time from
    members m, members_field_details mf
  WHERE m.m_id = mf.m_id AND m.sinaid is not null);

-- 注：USER_EDUCATION表的数据必须写程序完成，涉及members_field_details的education_info

-- 插入积分等级表SCORE_RANK配置信息
INSERT INTO `SCORE_RANK` (`ID`,`RANK_NAME`,`RANK_ICON`,`START_SCORE`,`END_SCORE`,`SCORE_CAPITAL_INFO`,`REMARKS`,`LAST_MODIFIED_DATE`,`CREATED_DATE`) VALUES
  (1,'AA等级','{"name":"s_cap_2.gif","path":"/Public/images/index/s_cap_2.gif","width":34,"height":16,"dynamic":true}',90,120,'[{"type":"ACPI","minRate":0.06,"maxAmount":250000,"maxGuarantee":500000},{"type":"ACAI","minRate":0.0988,"maxAmount":1000000,"maxGuarantee":1000000,"guaranteeRate":1.0}]',null,null,NOW()),
  (2,'A等级','{"name":"s_cap_1.gif","path":"/Public/images/index/s_cap_1.gif","width":16,"height":16,"dynamic":true}',80,89,'[{"type":"ACPI","minRate":0.08,"maxAmount":80000,"maxGuarantee":160000},{"type":"ACAI","minRate":0.1088,"maxAmount":250000,"maxGuarantee":500000,"guaranteeRate":2.0}]',null,null,NOW()),
  (3,'B等级','{"name":"star5.gif","path":"/Public/images/index/star5.gif","width":88,"height":16,"dynamic":true}',70,79,'[{"type":"ACPI","minRate":0.10,"maxAmount":70000,"maxGuarantee":140000},{"type":"ACAI","minRate":0.1188,"maxAmount":150000,"maxGuarantee":300000,"guaranteeRate":2.0}]',null,null,NOW()),
  (4,'C等级','{"name":"star4.gif","path":"/Public/images/index/star4.gif","width":70,"height":16,"dynamic":true}',60,69,'[{"type":"ACPI","minRate":0.12,"maxAmount":60000,"maxGuarantee":60000},{"type":"ACAI","minRate":0.1288,"maxAmount":100000,"maxGuarantee":200000,"guaranteeRate":2.0}]',null,null,NOW()),
  (5,'D等级','{"name":"star3.gif","path":"/Public/images/index/star3.gif","width":52,"height":16,"dynamic":true}',50,59,'[{"type":"ACPI","minRate":0.15,"maxAmount":50000,"maxGuarantee":50000},{"type":"ACAI","minRate":0.1388,"maxAmount":60000,"maxGuarantee":100000,"guaranteeRate":2.0}]',null,null,NOW()),
  (6,'E等级','{"name":"star2.gif","path":"/Public/images/index/star2.gif","width":34,"height":16,"dynamic":true}',38,49,'[{"type":"ACPI","minRate":0.18,"maxAmount":20000,"maxGuarantee":20000},{"type":"ACAI","minRate":0.1488,"maxAmount":40000,"maxGuarantee":60000,"guaranteeRate":1.5}]',null,null,NOW()),
  (7,'HR等级','{"name":"star.gif","path":"/Public/images/index/star.gif","width":16,"height":16,"dynamic":true}',25,37,'[{"type":"ACPI","minRate":0.21,"maxAmount":10000,"maxGuarantee":10000},{"type":"ACAI","minRate":0.1588,"maxAmount":20000,"maxGuarantee":30000,"guaranteeRate":1.5}]',null,null,NOW());

-- 导积分类型表SCORE_ALLOC(KEYWORD需要另作修改)
INSERT INTO SCORE_ALLOC
(ID, ALLOC_NAME, KEYWORD, ALLOC_DESC, MIN_SCORE, MAX_SCORE, IS_ENABLED, REFUSE_REASON, ORDER_NUM, IS_AUTO_ASSIGN)
  (SELECT mt.mist_id, mt.mist_name, mt.mist_kwd, mt.mist_note, mt.mist_score_min, mt.mist_score_max,
     mt.mist_enabled, mt.mist_refuse_info, mist_order, mt.is_auto_assign FROM members_info_score_type mt);


-- 导用户属性表USER_FIELD(FIELD_KWD另作修改)
INSERT INTO USER_FIELD
(ID, SCORE_ALLOC_ID, FIELD_NAME, FIELD_KWD, IS_REQUIRED, FIELD_MAX_LEN, FIELD_NOTE, VERIFY_MODE, IS_INTEGRITY, FIELD_DESC)
  (SELECT mt.mf_id, mt.mist_id, mt.mf_name, mt.mf_kwd, mt.mf_required, mt.mf_length,
     mt.mf_note, mt.mf_verify_mode, mt.is_enabled, mt.mf_dscrpt FROM members_field mt);

-- 更新属性中的关键字
UPDATE USER_FIELD SET FIELD_KWD='userProfile.realName' WHERE FIELD_KWD='realname';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.idCard' WHERE FIELD_KWD='idnum';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.gender' WHERE FIELD_KWD='sex';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.email' WHERE FIELD_KWD='email';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.mobileNO' WHERE FIELD_KWD='mobilenum';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.censusProvince' WHERE FIELD_KWD='huji_province';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.censusCity' WHERE FIELD_KWD='huji_city';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.liveProvince' WHERE FIELD_KWD='cur_province';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.liveCity' WHERE FIELD_KWD='cur_city';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.marriage' WHERE FIELD_KWD='marriage';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.education' WHERE FIELD_KWD='education';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.passport' WHERE FIELD_KWD='passport';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.socialSecurity' WHERE FIELD_KWD='shebao';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.driving' WHERE FIELD_KWD='driving';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.age' WHERE FIELD_KWD='age';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.liveAddress' WHERE FIELD_KWD='cur_address';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.liveContact' WHERE FIELD_KWD='cur_phone';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.qq' WHERE FIELD_KWD='qq';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.mobileNO2' WHERE FIELD_KWD='mobilenum2';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.censusAddress' WHERE FIELD_KWD='huji_address';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.skillCert' WHERE FIELD_KWD='skillcert';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.formerName' WHERE FIELD_KWD='usedname';
UPDATE USER_FIELD SET FIELD_KWD='userProfile.englishName' WHERE FIELD_KWD='englishname';

-- 导用户积分收入表USER_SCORE_INCOME
INSERT INTO USER_SCORE_INCOME(ID,USER_ID,SCORE_ALLOC_ID,SCORE,AUDIT_SCORE,AUDITOR_ID,AUDIT_TIME,IS_CONFIRM,REMARKS)
  (SELECT m.msd_id, m.m_id, m.mist_id, m.score, m.suggest_score, m.suggest_am, m.suggest_time, m.fixed, m.ms_remark FROM members_score_details m);

-- 导用户上传类型表USER_UPLOAD_TYPE
INSERT INTO USER_UPLOAD_TYPE(ID,SCORE_ALLOC_ID,TYPE_NAME,UPLOAD_NOTE,UPLOAD_EXAMPLE)
  (SELECT m.mut_id, m.mist_id, m.mut_name, m.mut_note, m.mut_example FROM members_upload_type m);

-- 导用户上传文件信息表USER_UPLOAD_ITEM
INSERT INTO USER_UPLOAD_ITEM(ID,UPLOAD_ID,FILE_NAME,FILE_TYPE,FILE_URL,FILE_SIZE,FILE_DESC,CREATED_DATE)
  (SELECT m.mup_it_id, m.mup_id, m.filename, m.filetype, m.fileurl, m.filesize, m.dscrpt, m.time_create FROM members_uploads_items m);


-- 更新members_uploads表字段is_auditing的值
UPDATE members_uploads mu SET mu.is_auditing =11 WHERE mu.is_auditing=1;
UPDATE members_uploads mu SET mu.is_auditing =12 WHERE mu.is_auditing=-1;
UPDATE members_uploads mu SET mu.is_auditing =13 WHERE mu.is_auditing=2;
UPDATE members_uploads mu SET mu.is_auditing =14 WHERE mu.is_auditing=-2;
-- members_idcard_check的数据同步到members_uploads
UPDATE members_uploads mu, members_idcard_check mic
SET mu.is_auditing = mic.mic_is_auditing, mu.audit_operator=mic.operation_m_id, mu.audit_time=mic.create_time, mu.audit_remark=mic.remark
WHERE mu.m_id = mic.mic_m_id and mu.mup_id=mic.mup_id;
-- 导用户上传表USER_UPLOAD
INSERT INTO USER_UPLOAD(ID,USER_ID,UPLOAD_TYPE_ID,UPLOAD_CONTENT,AUDIT_STATUS,AUDIT_TIME,OPERATOR_ID,ASSIGNER_ID,ASSIGN_TIME,REMARKS,CREATED_DATE)
  (SELECT m.mup_id,m.m_id,m.mut_id,m.mup_title,m.is_auditing,m.audit_time,m.audit_operator,m.mup_assign_am_id,m.mup_assign_time,m.audit_remark,m.time_create FROM members_uploads m);
-- 导用户国政通查询信息表USER_ID5_RECORD
INSERT INTO USER_ID5_RECORD(ID,USER_ID,REAL_NAME,ID_CARD,SCHOOL_NAME,EDUCATION,ENTRANCE_TIME,PROFESSION,GRADUATION,STUDY_RESULT,STUDY_CHANNEL)
  (SELECT m.mier_id,m.m_id,m.mier_name,m.mier_idnum,m.mier_graduate,m.mier_educationdegree,m.mier_enroldate,m.mier_specialityname,m.mier_graduatetime,m.mier_studyresult,m.mier_studystyle FROM member_id5_edu_record m);


-- 导入 USER_STUDENT 表数据
INSERT INTO USER_STUDENT
(USER_ID, COLLEGE_ID, COLLEGE_NAME, CAMPUS, MAJOR, STUDENT_NO, ATTN_YEAR, EDU_CODE)
  SELECT mf.m_id, dc.ID, dc.C_NAME, mf.address_school, mf.major,
    mf.mfd_student_sn, mf.into_school_time, mf.education FROM members_field_details mf, DICT_COLLEGE dc
  WHERE mf.institution = dc.C_NAME AND mf.institution IS NOT NULL;