/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CollegeRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.repository.dict;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.user.domain.dict.College;
import org.springframework.data.domain.Sort;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.zip.CRC32;

import static com.nonobank.user.domain.dict.QCollege.qc;

/**
 * The {@code College} entity repository.
 *
 * @author fuchun
 * @version $Id: CollegeRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface CollegeRepository extends QueryDslRepository<College, Integer> {

    public default College findByName(String name) {
        Objects.requireNonNull(name, College.PROP_NAME);
        CRC32 crc32 = new CRC32();
        crc32.update(name.getBytes(StandardCharsets.UTF_8));
        Long nameSrc = crc32.getValue();
        return findOne(qc.nameSrc.eq(nameSrc));
    }

    @Nonnull
    public default List<College> findByStateCode(Integer stateCode, @Nullable Sort sort) {
        Objects.requireNonNull(stateCode, College.PROP_STATE_CODE);
        return findAll(qc.stateCode.eq(stateCode), QueryDsl.toOrders(qc, sort));
    }
}
