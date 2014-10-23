/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) LocationServiceRemotingTest.java 2014-10-22 12:27
 */

package com.nonobank.user.facade;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.nonobank.user.facade.dto.dict.CityDTO;
import com.nonobank.user.facade.dto.dict.CountyDTO;
import com.nonobank.user.facade.dto.dict.RegionDTO;
import com.nonobank.user.facade.dto.dict.StateDTO;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * 此测试需要启动 nono-user-web 应用后才能进行，故单独进行测试。
 *
 * @author fuchun
 * @version $Id: LocationServiceRemotingTest.java 244 2014-10-22 05:45:01Z fuchun $
 * @since 2.0
 */
@Ignore
public class LocationServiceRemotingTest extends AbstractUserRemotingTest {

    LocationService locationService;

    @Before
    public void setUp() throws Exception {
        locationService = remotingInterface(LocationService.class,
                "/remoting/LocationService");
    }

    @Test
    public void testListRegions() throws Exception {
        List<RegionDTO> regions = locationService.listRegions();

        assertThat(regions, notNullValue());
        assertFalse(regions.isEmpty());

        regions.forEach(r -> assertThat(r.getStates(), nullValue()));
    }

    @Test
    public void testListStates() throws Exception {
        List<StateDTO> states = locationService.listStates();

        assertThat(states, notNullValue());
        assertFalse(states.isEmpty());

        states.forEach(s -> assertThat(s.getCities(), nullValue()));
    }

    @Test
    public void testListStatesByRegion() throws Exception {
        List<RegionDTO> regions = locationService.listRegions();

        assertThat(regions, notNullValue());
        assertFalse(regions.isEmpty());

        regions.forEach(r -> {
            List<StateDTO> states = locationService.listStates(r.getCode());

            assertThat(states, notNullValue());
            if (r.getName().equals("台湾") || r.getName().contains("澳门") ||
                    r.getName().contains("香港")) {
                assertTrue(states.isEmpty());
            } else {
                assertFalse(states.isEmpty());
            }
        });
    }

    @Test
    public void testListCitiesAndCounties() throws Exception {
        List<StateDTO> states = locationService.listStates();

        assertThat(states, notNullValue());
        assertFalse(states.isEmpty());

        Set<String> noCountyCities = Sets.newHashSet();
        states.forEach(s -> {
            List<CityDTO> cities = locationService.listCities(s.getCode());

            assertThat(cities, notNullValue());
            if (s.getName().contains("台湾") || s.getName().contains("澳门") ||
                    s.getName().contains("香港")) {
                assertTrue(cities.isEmpty());
            } else {
                assertFalse(s.toString(), cities.isEmpty());
            }

            if (cities.size() > 0) {
                cities.forEach(c -> {
                    List<CountyDTO> counties = locationService.listCounties(c.getCode());

                    assertThat(counties, notNullValue());

                    if (counties.isEmpty()) {
                        noCountyCities.add(c.getName());
                    }
                });
            }
        });
        final List<String> lines = Lists.newArrayList();
        int i = noCountyCities.size();
        for (String cityName : noCountyCities) {
            if (lines.size() == 10 || i-- == 0) {
                System.out.printf("%s no counties.\n",
                        Joiner.on(", ").join(lines));
                lines.clear();
            }
            lines.add(cityName);
        }
    }
}
