/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) LocationRepository.java 2014-10-14 15:32
 */

package com.nonobank.user.domain.repository.dict;

import com.nonobank.data.repository.GenericRepository;
import com.nonobank.user.domain.dict.Location;
import org.springframework.data.domain.Sort;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * The {@code Location} entity repository.
 *
 * @author fuchun
 * @version $Id: LocationRepository.java 209 2014-10-17 09:45:19Z fuchun $
 * @since 2.0
 */
public interface LocationRepository extends GenericRepository<Location, Integer> {

    @Nonnull
    public List<Location> findChildrenByCode(Integer code, Sort sort);

    @Nonnull
    public List<Location> findChildrenByShortName(String shortName, Sort sort);

    public Location findByCode(Integer code);

    public Location findByShortNameAndParentId(String shortName, Integer parentId);

    @Nonnull
    public List<Location> findByTier(Short tier, Sort sort);

    @Nonnull
    public List<Location> findByParentId(Integer parentId, Sort sort);
}