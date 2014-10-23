/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcLocationRepositoryTest.java 2014-10-15 11:39
 */

package com.nonobank.user.base.jdbc.dict;

import com.nonobank.user.domain.dict.Location;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
public class JdbcLocationRepositoryTest {

    @Resource
    private JdbcLocationRepository locationRepository;

    @Test
    public void testFindByCode() throws Exception {
        Location location = locationRepository.findByCode(120100);

        assertThat(location, IsNull.notNullValue());

        location = locationRepository.findByCode(810);
        assertThat(location, IsNull.nullValue());
    }

    @Test
    public void testFindByShortNameAndParentId() throws Exception {
        Location prov = locationRepository.findOne(109);
        Location location = locationRepository.findByShortNameAndParentId(
                "浦东新区", prov.getId());

        assertThat(location, IsNull.notNullValue());
    }

    @Test
    public void testFindByTier() throws Exception {
        List<Location> provList = locationRepository.findByTier(
                Location.TIER_STATE, new Sort(Sort.Direction.ASC, Location.PROP_CODE));

        assertThat(provList, IsNull.notNullValue());
        assertFalse(provList.isEmpty());
    }

    @Test
    public void testFindByParentId() throws Exception {

        for (int i = 101; i <= 131; i++) {
            List<Location> cities = locationRepository.findByParentId(i, null);

            assertThat(cities, IsNull.notNullValue());
            assertFalse(cities.isEmpty());
        }
    }

    @Test
    public void testFindChildrenByCode() throws Exception {
        // 上海市
        List<Location> locations = locationRepository.findChildrenByCode(310000, null);

        assertThat(locations, IsNull.notNullValue());
        assertTrue(locations.size() > 0);
    }

    @Test
    public void testFindChildrenByShortName() throws Exception {
        List<Location> locations = locationRepository.findChildrenByShortName("上海市", null);

        assertThat(locations, IsNull.notNullValue());
        assertTrue(locations.size() > 0);

        List<Location> locations2 = locationRepository.findChildrenByCode(310000, null);

        assertThat(locations2, IsNull.notNullValue());
        assertTrue(locations2.size() > 0);
        assertThat(locations, Is.is(locations2));
    }
}