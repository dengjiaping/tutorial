/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserAccountRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.repository.core;


import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.core.QUserAccount;
import com.nonobank.user.domain.core.UserAccount;

import static java.util.Objects.requireNonNull;

/**
 * {@code UserAccount} entity repository.
 *
 * @author fuchun
 * @version $Id: UserAccountRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface UserAccountRepository extends QueryDslRepository<UserAccount, Long> {

    public default UserAccount findByUserName(String userName) {
        requireNonNull(userName, UserAccount.PROP_USER_NAME);
        if (userName.length() == 0) {
            return null;
        }
        return findOne(QUserAccount.qua.userName.eq(userName));
    }

    public default UserAccount findByMobileNo(String mobileNo) {
        requireNonNull(mobileNo, UserAccount.PROP_MOBILE_NO);
        if (mobileNo.length() == 0) {
            return null;
        }
        return findOne(QUserAccount.qua.mobileNO.eq(mobileNo));
    }
}
