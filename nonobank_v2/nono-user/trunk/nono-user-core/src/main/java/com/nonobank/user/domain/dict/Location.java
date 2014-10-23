/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Location.java 2014-10-14 15:26
 */

package com.nonobank.user.domain.dict;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.nonobank.data.domain.AbstractEntity;
import com.nonobank.user.domain.ctx.DictCmdContext;
import org.springframework.data.domain.Sort;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 省、城市、县区数据字典实体。
 *
 * @author fuchun
 * @version $Id: Location.java 237 2014-10-22 02:24:20Z fuchun $
 * @since 2.0
 */
public class Location extends AbstractEntity<Integer, Location> {

    public static final Short TIER_REGION = 1;
    public static final Short TIER_STATE = 2;
    public static final Short TIER_CITY = 3;
    public static final Short TIER_COUNTY = 4;

    public static final String PROP_TIER = "tier";
    public static final String PROP_CODE = "code";
    public static final String PROP_FULL_NAME = "fullName";
    public static final String PROP_SHORT_NAME = "shortName";
    public static final String PROP_PARENT_ID = "parentId";

    /* {"省直辖行政单位", "市辖区", "县"} */
    private static final List<String> SPECIAL_CITIES =
            ImmutableList.of(
                    "\u7701\u76f4\u8f96\u884c\u653f\u5355\u4f4d",
                    "\u5e02\u8f96\u533a", "\u53bf");

    private static final long serialVersionUID = 8364454477609336186L;

    /**
     * 获取指定代码的大区信息。
     * <pre>{@code
     * 1000 - 华北
     * 2000 - 东北
     * 3000 - 华东
     * 4000 - 华中
     * 5000 - 华南
     * 6000 - 西南
     * 7000 - 西北
     * }</pre>
     *
     * @param regionCode 区域代码。
     * @return 返回指定代码的大区信息。
     */
    public static Region getRegion(Integer regionCode) {
        return getByCode(regionCode, DelegatingRegion::of);
    }

    public static State getState(Integer stateCode) {
        return getByCode(stateCode, DelegatingState::of);
    }

    public static City getCity(Integer cityCode) {
        return getByCode(cityCode, DelegatingCity::of);
    }

    public static County getCounty(Integer countyCode) {
        return getByCode(countyCode, DelegatingCounty::of);
    }

    public static <T extends Area> T getByCode(
            Integer code, Function<Location, T> func) {
        if (code == null || code <= 0) {
            return null;
        }
        Location location = DictCmdContext.locationRepository().findByCode(code);
        return location != null ? func.apply(location) : null;
    }

    @Nonnull
    public static List<Region> allRegions() {
        List<Location> locations = DictCmdContext.locationRepository()
                .findByTier(TIER_REGION, new Sort(Sort.Direction.ASC, Location.PROP_CODE));
        if (locations.isEmpty()) {
            return Collections.emptyList();
        }
        return locations.stream().map(DelegatingRegion::of)
                .collect(Collectors.toList());
    }

    @Nonnull
    public static List<State> allStates(Sort sort) {
        List<Location> locations = DictCmdContext.locationRepository()
                .findByTier(TIER_STATE, sort);
        if (locations.isEmpty()) {
            return Collections.emptyList();
        }
        return locations.stream()
                .map(DelegatingState::of)
                .collect(Collectors.toList());
    }

    @Nonnull
    public static List<State> getStates(Integer regionCode, Sort sort) {
        return getChildrenAreas(regionCode, sort, null, DelegatingState::of);
    }

    @Nonnull
    public static List<City> getCities(Integer provCode, Sort sort) {
        return getChildrenAreas(provCode, sort, null, DelegatingCity::of);
    }

    @Nonnull
    public static List<County> getCounties(Integer cityCode, Sort sort) {
        return getChildrenAreas(cityCode, sort, null, DelegatingCounty::of);
    }

    @Nonnull
    public static <T extends Area> List<T> getChildrenAreas(
            Integer code, Sort sort, Predicate<Location> filter, Function<Location, T> func) {
        List<Location> counties = DictCmdContext.locationRepository()
                .findChildrenByCode(code, sort);
        if (counties.isEmpty()) {
            return Collections.emptyList();
        }

        final Predicate<Location> defaultPredicate =
                c -> !SPECIAL_CITIES.contains(c.getShortName());
        Predicate<Location> predicate = filter != null ?
                filter.and(defaultPredicate) :
                defaultPredicate;
        return counties.stream()
                .filter(predicate)
                .map(func)
                .collect(Collectors.toList());
    }

    public static Location of(
            Integer id, Short tier, Integer code, String fullName,
            String shortName, Integer parentId) {
        Location l = new Location();
        l.setId(id);
        l.setTier(tier);
        l.setCode(code);
        l.setFullName(fullName);
        l.setShortName(shortName);
        l.setParentId(parentId);
        return l;
    }

    private Short tier;
    private Integer code;
    private String fullName;
    private String shortName;
    private Integer parentId;

    public Short getTier() {
        return tier;
    }

    public void setTier(Short tier) {
        this.tier = tier;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_ID, getId())
                .add(PROP_TIER, getTier())
                .add(PROP_CODE, getCode())
                .add(PROP_FULL_NAME, getFullName())
                .add(PROP_SHORT_NAME, getShortName())
                .add(PROP_PARENT_ID, getParentId())
                .toString();
    }
}
