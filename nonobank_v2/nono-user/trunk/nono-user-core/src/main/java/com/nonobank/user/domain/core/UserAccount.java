/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserAccount.java 2014-10-09 14:11
 */

package com.nonobank.user.domain.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.nonobank.common.base.RandomStrings;
import com.nonobank.user.domain.ctx.UserCmdContext;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * 用户帐号实体。
 *
 * @author fuchun
 * @version $Id: UserAccount.java 199 2014-10-17 03:33:41Z fuchun $
 * @since 2.0
 */
public class UserAccount extends BaseUser<UserAccount> {

    public static final String PROP_USER_NAME = "userName";
    public static final String PROP_HASHED_KEY = "hashedKey";
    public static final String PROP_AVATAR = "avatar";
    public static final String PROP_MOBILE_NO = "mobileNO";
    public static final String PROP_OLD_HASHED_PASSWD = "oldHashedPasswd";
    public static final String PROP_HASHED_PASSWD = "hashedPasswd";
    public static final String PROP_PASSWD_SALT = "passwdSalt";
    public static final String PROP_PASSWD_QUESTION = "passwdQuestion";
    public static final String PROP_PASSWD_ANSWER = "passwdAnswer";
    public static final String PROP_ANSWER_SALT = "answerSalt";
    public static final String PROP_DELETED = "deleted";

    private static final long serialVersionUID = -1106730501746235514L;

    /**
     * 获取指定用户名的{@code Optional} 封装的用户帐号信息。
     * <p>
     * 该方法永远不会返回{@code null}，如果没有找到指定的用户，则返回一个{@code empty optional}。
     * <pre>{@code
     * // 1: 未找到用户时抛出实体未找到异常
     * UserAccount account =
     *         UserAccount.get("Tomas")
     *         .orElseThrow(() -> new EntityNotFoundException("Tomas"));
     * // 2: 未找到用户时从指定的地方加载
     * UserAccount account =
     *         UserAccount.get("Tomas")
     *         .orElseGet(... ...)
     * // 3: 未找到用户时，返回指定默认值
     * UserAccount account =
     *         UserAccount.get("Tomas").orElse(null);
     * }</pre>
     *
     * @param userName 用户名。
     * @return 返回指定用户名的{@code Optional} 封装的用户帐号信息。
     */
    @Nonnull
    public static Optional<UserAccount> get(String userName) {
        return Optional.ofNullable(getIfPresent(userName));
    }

    /**
     * 获取指定用户id的{@code Optional} 封装的用户帐号信息。
     * <p>
     * 该方法永远不会返回{@code null}，如果没有找到指定的用户，则返回一个{@code empty optional}。
     * <pre>{@code
     * // 1: 未找到用户时抛出实体未找到异常
     * UserAccount account =
     *         UserAccount.get(10002L)
     *         .orElseThrow(() -> new EntityNotFoundException(10002L));
     * // 2: 未找到用户时从指定的地方加载
     * UserAccount account =
     *         UserAccount.get(10002L).orElseGet(... ...)
     * // 3: 未找到用户时，返回指定默认值
     * UserAccount account =
     *         UserAccount.get(10002L).orElse(null);
     * }</pre>
     *
     * @param userId 用户id。
     * @return 返回指定用户id的{@code Optional} 封装的用户帐号信息。
     */
    @Nonnull
    public static Optional<UserAccount> get(Long userId) {
        return Optional.ofNullable(getIfPresent(userId));
    }

    /**
     * 获取指定用户id的用户帐号信息，如果不存在，返回{@code null}。
     *
     * @param userId 用户id。
     * @return 返回指定用户id的用户帐号信息，如果不存在，返回{@code null}。
     */
    @Nullable
    public static UserAccount getIfPresent(Long userId) {
        if (userId == null || userId <= 0) {
            return null;
        }
        return UserCmdContext.userAccountRepository().findOne(userId);
    }

    /**
     * 获取指定用户名的用户帐号信息，如果不存在，返回{@code null}。
     *
     * @param userName 用户名。
     * @return 返回指定用户名的用户帐号信息，如果不存在，返回{@code null}。
     */
    @Nullable
    public static UserAccount getIfPresent(String userName) {
        if (userName == null || userName.length() == 0) {
            return null;
        }
        return UserCmdContext.userAccountRepository()
                .findByUserName(userName);
    }

    /**
     * 对指定的密码使用指定的密码盐进行{@code hash} 操作。
     *
     * @param passwd 要 hash 的密码。
     * @param salt   密码盐。
     * @return 返回哈希后的字符串。
     */
    public static String hashPasswd(String passwd, String salt) {
        String src = String.format("%s{%s}", passwd, salt);
        return DigestUtils.sha1Hex(src);
    }

    /**
     * 对指定的安全问题答案使用指定的盐进行{@code hash} 操作。
     *
     * @param answer 要 hash 的密码。
     * @param salt   盐。
     * @return 返回哈希后的字符串。
     */
    public static String hashAnswer(String answer, String salt) {
        String src = String.format("%s_[%s]", answer, salt);
        return DigestUtils.sha1Hex(src);
    }

    /**
     * 生成一个指定长度的随机密码盐。
     *
     * @param length 密码盐长度。
     * @return 返回一个指定长度的随机密码盐。
     */
    public static String newSalt(int length) {
        return RandomStrings.randomAlphanumeric(length);
    }

    private String userName;
    private String hashedKey;
    private String avatar;
    private String mobileNO;
    private String oldHashedPasswd;
    private String hashedPasswd;
    private String passwdSalt;
    private String passwdQuestion;
    private String passwdAnswer;
    private String answerSalt;
    private UserStatus status;

    private boolean deleted;

    /**
     * 使用 * 替换旧指定原字符串中的部份重要信息。
     *
     * @param source 原字符串。
     * @return 返回处理后的字符串。
     */
    protected String secureMark(String source) {
        String src = String.valueOf(source).trim(); // null to "null"
        int srcLen = src.length();
        if ("null".equals(src)) {
            return src;
        } else if (srcLen <= 2) {
            return "****";
        } else if (srcLen > 2 && srcLen <= 10) {
            return String.format("%s****%s",
                    src.substring(0, 1), src.substring(srcLen - 1, srcLen));
        } else {
            return String.format("%s****%s",
                    src.substring(0, 2), src.substring(srcLen - 3, srcLen));
        }
    }

    public UserAccount() {
        super();
        initialize();
    }

    public UserAccount(Long userId) {
        super();
        setUserId(userId);
        initialize();
    }

    protected void initialize() {
        status = UserStatus.NOT_ACTIVE;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public String getOldHashedPasswd() {
        return oldHashedPasswd;
    }

    public void setOldHashedPasswd(String oldHashedPasswd) {
        this.oldHashedPasswd = oldHashedPasswd;
    }

    public String getHashedPasswd() {
        return hashedPasswd;
    }

    public void setHashedPasswd(String hashedPasswd) {
        this.hashedPasswd = hashedPasswd;
    }

    public String getPasswdSalt() {
        return passwdSalt;
    }

    public void setPasswdSalt(String passwdSalt) {
        this.passwdSalt = passwdSalt;
    }

    public String getPasswdQuestion() {
        return passwdQuestion;
    }

    public void setPasswdQuestion(String passwdQuestion) {
        this.passwdQuestion = passwdQuestion;
    }

    public String getPasswdAnswer() {
        return passwdAnswer;
    }

    public void setPasswdAnswer(String passwdAnswer) {
        this.passwdAnswer = passwdAnswer;
    }

    public String getAnswerSalt() {
        return answerSalt;
    }

    public void setAnswerSalt(String answerSalt) {
        this.answerSalt = answerSalt;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    // logical method
    // ----------------------------------------------------------------------------------

    /**
     * 如果当前用户被锁定，则返回{@code true}，否则{@code false}。
     */
    @JsonIgnore
    public boolean isLocked() {
        return status == UserStatus.LOCKED;
    }

    /**
     * 如果当前用户还没有被激活，则返回{@code true}，否则{@code false}。
     */
    @JsonIgnore
    public boolean isNotActivated() {
        return status == UserStatus.NOT_ACTIVE;
    }

    /**
     * 如果当前用户是正常状态，则返回{@code true}，否则{@code false}。
     */
    @JsonIgnore
    public boolean isNormal() {
        return status == UserStatus.NORMAL;
    }

    /**
     * 检验指定的安全问题答案与设定的是否一致。
     * <p />
     * 旧的数据中，密码安全问题答案是明文存储的，该方法仅作为校验，不会去更新新的加盐的{@code hash} 计算。
     *
     * @param passwdAnswer 用户输入的密码安全问题答案。
     * @return 如果指定的安全问题答案与设定的一致，则返回{@code true}，否则{@code false}。
     */
    public boolean verifyPasswdAnswer(String passwdAnswer) {
        final String answer = Strings.nullToEmpty(passwdAnswer).trim();
        if (answer.length() == 0 ||
                (getPasswdQuestion() == null && getPasswdAnswer() == null)) {
            // 输入空或者没有设置安全问题与答案，直接返回 false
            return false;
        }
        if (getPasswdAnswer().length() < 40) { // 旧的数据
            return answer.equals(getPasswdAnswer());
        }

        String hashedAnswer = hashAnswer(answer, getAnswerSalt());
        return hashedAnswer.equals(getPasswdAnswer());
    }

    /**
     * 校验指定的密码与当前用户的密码是否匹配。
     * <p>
     * 存在旧的没有加盐的{@code MD5} hash 数据，该方法仅作为校验，不会去更新新的加盐的{@code hash}
     * 计算。
     *
     * @param password 要校验的密码。
     * @return 如果指定的密码与当前用户的密码匹配，则返回{@code true}，否则{@code false}。
     */
    public boolean verifyPasswd(String password) {
        String passwd = Strings.nullToEmpty(password).trim();
        if (passwd.length() == 0) {
            return false;
        }

        if (passwd.length() < 32) {
            passwd = DigestUtils.md5Hex(passwd);
        }
        if (getOldHashedPasswd() != null) {
            return Objects.equals(getOldHashedPasswd(), passwd);
        }
        String hashedPasswd = hashPasswd(passwd, getPasswdSalt());
        return Objects.equals(getHashedPasswd(), hashedPasswd);
    }

    /**
     * 更改用户密码。更新成功后，{@code hashedPasswd} 和{@code passwdSalt} 一同被更新。
     *
     * @param password 原始密码或使用{@code MD5} hash 后的字符串。
     * @param newSalt  新的密码盐（maybe null）。
     * @return 返回当前用户帐号信息。
     */
    @Nonnull
    public UserAccount changePasswd(String password, String newSalt) {
        checkArgument(password != null && password.length() > 0, "password");
        if (newSalt != null) {
            newSalt = newSalt(16);
        }
        assert password != null;
        if (password.length() < 32) {
            password = DigestUtils.md5Hex(password);
        }
        final String hashedPasswd = hashPasswd(password, newSalt);
        setHashedPasswd(hashedPasswd);
        setPasswdSalt(newSalt);
        if (getOldHashedPasswd() != null) setOldHashedPasswd(null);
        return this;
    }

    /**
     * 更新用户密码安全问题答案。
     *
     * @param passwdAnswer 新的密码安全问题答案。
     * @param newSalt 新的密码盐（maybe null）。
     * @return 返回当前用户帐号信息。
     */
    @Nonnull
    public UserAccount changePasswdAnswer(String passwdAnswer, String newSalt) {
        checkArgument(passwdAnswer != null && passwdAnswer.length() > 0, PROP_PASSWD_ANSWER);
        if (newSalt == null) {
            newSalt = newSalt(12);
        }
        assert passwdAnswer != null && passwdAnswer.length() > 0;
        String hashedAnswer = hashAnswer(passwdAnswer, newSalt);
        setPasswdAnswer(hashedAnswer);
        setAnswerSalt(newSalt);
        return this;
    }

    /**
     * 用于修复明文的旧的密码安全问题。
     */
    public UserAccount fixedOldPasswdAnswer() {
        final String pa = getPasswdAnswer();
        if (pa == null || (pa.length() == 40 && getAnswerSalt() != null)) {
            // 已经被修复了
            return this;
        }
        return changePasswdAnswer(pa, null);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_USER_NAME, getUserName())
                .add(PROP_HASHED_KEY, getHashedKey())
                .add(PROP_AVATAR, getAvatar())
                .add(PROP_MOBILE_NO, getMobileNO())
                .add(PROP_OLD_HASHED_PASSWD, secureMark(getOldHashedPasswd()))
                .add(PROP_HASHED_PASSWD, secureMark(getHashedPasswd()))
                .add(PROP_PASSWD_SALT, secureMark(getPasswdSalt()))
                .add(PROP_PASSWD_QUESTION, getPasswdQuestion())
                .add(PROP_PASSWD_ANSWER, secureMark(getPasswdAnswer()))
                .add(PROP_ANSWER_SALT, secureMark(getAnswerSalt()))
                .add(PROP_STATUS, getStatus())
                .add(PROP_DELETED, isDeleted())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate())
                .toString();
    }
}
