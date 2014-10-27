/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcBankRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.dict;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.dict.Bank;
import com.nonobank.user.domain.dict.QBank;
import com.nonobank.user.domain.repository.dict.BankRepository;
import org.springframework.stereotype.Repository;

/**
 * The JDBC based on implementation of the {@code BankRepository}.
 *
 * @author fuchun
 * @version $Id: JdbcBankRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("bankRepository")
public class JdbcBankRepository extends QueryDslJdbcRepository<Bank, Integer>
        implements BankRepository {

    public JdbcBankRepository() {
        super(QBank.qb);
    }
}
