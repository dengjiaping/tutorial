/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserDictController.java 2014-10-22 16:20
 */

package com.nonobank.user.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.nonobank.common.json.Views;
import com.nonobank.user.domain.dict.CommonDict;
import com.nonobank.user.domain.dict.Dict;
import com.nonobank.user.domain.dict.UserDict;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 用户属性字典数据控制器。
 *
 * @author fuchun
 * @version $Id: UserDictController.java 254 2014-10-23 03:00:31Z fuchun $
 * @since 2.0
 */
@RestController
@RequestMapping("/dict")
public class UserDictController extends UserBaseController {

    @RequestMapping(value = "/marriages", method = GET)
    @JsonView(Views.Public.class)
    public List<Dict> listMarriages(
            @SortDefault(sort = CommonDict.PROP_CODE)Sort sort) {
        return UserDict.findMarriages(sort);
    }

    @RequestMapping(value = "/educations", method = GET)
    @JsonView(Views.Public.class)
    public List<Dict> listEducations(
            @SortDefault(sort = CommonDict.PROP_CODE)Sort sort) {
        return UserDict.findEducations(sort);
    }

    @RequestMapping(value = "/positions", method = GET)
    @JsonView(Views.Public.class)
    public List<Dict> listPositions(
            @SortDefault(sort = CommonDict.PROP_CODE)Sort sort) {
        return UserDict.findPositions(sort);
    }

    @RequestMapping(value = "/skill_certs", method = GET)
    @JsonView(Views.Public.class)
    public List<Dict> listSkillCerts(
            @SortDefault(sort = CommonDict.PROP_CODE)Sort sort) {
        return UserDict.findSkillCerts(sort);
    }
}
