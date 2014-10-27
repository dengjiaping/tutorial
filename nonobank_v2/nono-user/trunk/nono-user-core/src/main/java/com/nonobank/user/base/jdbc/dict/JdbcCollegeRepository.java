/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcCollegeRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.dict;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.dict.College;
import com.nonobank.user.domain.dict.QCollege;
import com.nonobank.user.domain.repository.dict.CollegeRepository;
import org.springframework.stereotype.Repository;

/**
 * The JDBC based on implementation of the {@code CollegeRepository}.
 * @author fuchun
 * @version $Id: JdbcCollegeRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("collegeRepository")
public class JdbcCollegeRepository extends QueryDslJdbcRepository<College, Integer>
        implements CollegeRepository {

    public JdbcCollegeRepository() {
        super(QCollege.qc);
    }
}
