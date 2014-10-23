/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) LocationController.java 2014-10-22 14:44
 */

package com.nonobank.user.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.nonobank.common.json.Views;
import com.nonobank.user.domain.dict.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 所在地（位置）字典数据控制器。
 *
 * @author fuchun
 * @version $Id: LocationController.java 254 2014-10-23 03:00:31Z fuchun $
 * @since 2.0
 */
@RestController
@RequestMapping("/dict")
public class LocationController extends UserBaseController {

    @RequestMapping(value = "/regions", method = GET)
    @JsonView(Views.Public.class)
    public List<Region> listRegions() {
        return Location.allRegions();
    }

    @RequestMapping(value = "/states", method = GET)
    @JsonView(Views.Public.class)
    public List<State> listStates(
            @SortDefault(sort = Location.PROP_CODE) Sort sort) {
        return Location.allStates(sort);
    }

    @RequestMapping(value = "/states/{region_code}", method = GET)
    @JsonView(Views.Public.class)
    public List<State> listStates(
            @PathVariable(value = "region_code") Integer regionCode,
            @SortDefault(sort = Location.PROP_CODE) Sort sort) {
        return Location.getStates(regionCode, sort);
    }

    @RequestMapping(value = "/cities/{state_code}", method = GET)
    @JsonView(Views.Public.class)
    public List<City> listCities(
            @PathVariable("state_code") Integer stateCode,
            @SortDefault(sort = Location.PROP_CODE) Sort sort) {
        return Location.getCities(stateCode, sort);
    }

    @RequestMapping(value = "/counties/{city_code}", method = GET)
    @JsonView(Views.Public.class)
    public List<County> listCounties(
            @PathVariable("city_code") Integer cityCode,
            @SortDefault(sort = Location.PROP_CODE) Sort sort) {
        return Location.getCounties(cityCode, sort);
    }
}
