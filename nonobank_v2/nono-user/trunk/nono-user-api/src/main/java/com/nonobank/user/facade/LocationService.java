/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) LocationService.java 2014-10-21 13:48
 */

package com.nonobank.user.facade;

import com.nonobank.user.facade.dto.dict.CityDTO;
import com.nonobank.user.facade.dto.dict.CountyDTO;
import com.nonobank.user.facade.dto.dict.RegionDTO;
import com.nonobank.user.facade.dto.dict.StateDTO;

import javax.annotation.Nonnull;
import java.rmi.Remote;
import java.util.List;

/**
 * 所在地（城市）信息服务接口。
 *
 * @author fuchun
 * @version $Id: LocationService.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public interface LocationService extends Remote {

    /**
     * 返回所有中国的区域信息。例：华北、东北、华东、华中、华南、西南、西北、台湾、香港、澳门。
     */
    @Nonnull
    public List<RegionDTO> listRegions();

    /**
     * 返回所有中国的省（自治区）信息。例：上海市、台湾省、广西省、香港等。
     */
    @Nonnull
    public List<StateDTO> listStates();

    /**
     * 返回指定区域代码的中国的省（自治区）信息。
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
     * @param regionCode 中国区域代码。
     */
    @Nonnull
    public List<StateDTO> listStates(Integer regionCode);

    /**
     * 返回指定省（直辖市、自治区）代码的城市（直辖市行政区）信息。
     * <p />
     * 例如：上海市的代码是：310000、北京市的代码是：110000
     *
     * @param stateCode 省（直辖市、自治区）代码。
     */
    @Nonnull
    public List<CityDTO> listCities(Integer stateCode);

    /**
     * 返回指定城市（行政区）的代码的区（县）信息。此方法不能查询辖市的区信息，因为直辖市只有两级。
     * <p />
     * 例如：南京市的城市代码是：320100
     *
     * @param cityCode 城市（行政区）代码。
     */
    @Nonnull
    public List<CountyDTO> listCounties(Integer cityCode);
}
