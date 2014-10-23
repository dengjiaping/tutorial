/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) LocationTest.java 2014-10-15 16:59
 */

package com.nonobank.user.domain.dict;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
public class LocationTest {

    @Test
    public void testGetState() throws Exception {

        State state = Location.getState(-1);
        assertThat(state, nullValue());

        state = Location.getState(0);
        assertThat(state, nullValue());

        state = Location.getState(310000);

        assertThat(state, notNullValue());
        assertThat(state.getCode(), Is.is(310000));

        try {
            Location.getState(null);
        } catch (Exception ex) {
            assertThat(ex, instanceOf(NullPointerException.class));
            assertThat(ex.getMessage(), Is.is(Location.PROP_CODE));
        }
    }

    @Test
    public void testGetCity() throws Exception {
        City city = Location.getCity(-1);
        assertThat(city, nullValue());

        city = Location.getCity(0);
        assertThat(city, nullValue());

        city = Location.getCity(310104);
        assertThat(city, notNullValue());
        assertThat(city.getCode(), Is.is(310104));
        assertThat(city.getShortName(), Is.is("徐汇区"));

        try {
            Location.getCity(null);
        } catch (Exception ex) {
            assertThat(ex, instanceOf(NullPointerException.class));
            assertThat(ex.getMessage(), Is.is(Location.PROP_CODE));
        }
    }

    @Test
    public void testGetCounty() throws Exception {
        County county = Location.getCounty(-1);
        assertThat(county, nullValue());

        county = Location.getCounty(0);
        assertThat(county, nullValue());

        county = Location.getCounty(530111);
        assertThat(county, notNullValue());
        assertThat(county.getCode(), Is.is(530111));
        assertThat(county.getShortName(), Is.is("官渡区"));

        try {
            Location.getCounty(null);
        } catch (Exception ex) {
            assertThat(ex, instanceOf(NullPointerException.class));
            assertThat(ex.getMessage(), Is.is(Location.PROP_CODE));
        }
    }

    @Test
    public void testAllStates() throws Exception {
        List<State> states = Location.allStates(null);

        assertThat(states, notNullValue());
        assertFalse(states.isEmpty());
        states.forEach(a -> {
            if (a.getCode() > 100000) {
                // dd0000
                assertTrue(a.getCode() % 10000 == 0);
            }
        });

        List<State> sortedStates = Location.allStates(
                new Sort(Sort.Direction.ASC, Location.PROP_FULL_NAME));

        assertThat(sortedStates, notNullValue());
        assertFalse(sortedStates.isEmpty());

        assertThat(sortedStates, IsNot.not(states));
    }

    @Test
    public void testGetCities() throws Exception {
        final Integer provCode = 310000; // 上海市
        State shanghai = Location.getState(provCode);
        assertNotNull(shanghai);

        List<City> cities = Location.getCities(shanghai.getCode(), null);

        assertThat(cities, notNullValue());
        assertFalse(cities.isEmpty());

        cities.forEach(c -> assertThat(c.getStateId(), Is.is(shanghai.getId())));
    }

    @Test
    public void testGetCounties() throws Exception {
        final Integer cityCode = 530100; // 昆明市
        City kunming = Location.getCity(cityCode);
        assertNotNull(kunming);

        List<County> counties = Location.getCounties(kunming.getCode(), null);
        assertThat(counties, notNullValue());
        assertFalse(counties.isEmpty());

        counties.forEach(c -> assertThat(c.getCityId(), Is.is(kunming.getId())));
    }

    @Test
    public void testGetChildrenAreas() throws Exception {
        final Integer provCode = 310000; // 上海市
        List<City> cities = Location.getChildrenAreas(provCode, null,
                l -> !l.getShortName().equals("浦东新区"),
                DelegatingCity::of);

        assertThat(cities, notNullValue());
        assertFalse(cities.isEmpty());

        cities.forEach(c -> assertThat(c.getShortName(), IsNot.not("浦东新区")));
    }
}