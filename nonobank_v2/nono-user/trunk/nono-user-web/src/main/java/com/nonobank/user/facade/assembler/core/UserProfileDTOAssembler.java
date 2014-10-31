/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserProfileDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.core;

import com.nonobank.user.domain.core.UserProfile;
import com.nonobank.user.domain.dict.Exist;
import com.nonobank.user.facade.assembler.dict.DictDTOAssembler;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.core.UserProfileDTO;

/**
 * @author Yichuan
 * @version $Id: UserProfileDTOAssembler.java 315 2014-10-30 08:24:25Z yichuan $
 * @since 2.0
 */
public class UserProfileDTOAssembler extends AbstractAssembler<UserProfile, UserProfileDTO> {

    public static final UserProfileDTOAssembler ASSEMBLER = new UserProfileDTOAssembler();

    @Override
    public UserProfileDTO toDTO(UserProfile entity) {
        if (entity == null)
            return null;
        Exist social = entity.getSocialSecurity();
        if (social == null) social = Exist.UNKNOWN;
        Exist passport = entity.getPassport();
        if (passport == null) passport = Exist.UNKNOWN;
        Exist driving = entity.getDriving();
        if (driving == null) driving = Exist.UNKNOWN;
        return new UserProfileDTO(
                entity.getUserId(), entity.getUserName(), entity.getHashedKey(),
                entity.getEnglishName(), entity.getFormerName(), entity.getMobileNO(),
                entity.isMobileVerified(), entity.getMobileNO2(), entity.getEmail(),
                entity.isEmailVerified(), entity.getIdCard(), entity.getRealName(),
                entity.getAge(), entity.getGender().getValue(), entity.getCensusProvince(),
                entity.getCensusCity(), entity.getCensusAddress(), entity.getLiveProvince(),
                entity.getLiveCity(), entity.getLiveAddress(), entity.getLiveContact(),
                entity.getQq(), DictDTOAssembler.ASSEMBLER.toDTO(entity.getMarriage()),
                DictDTOAssembler.ASSEMBLER.toDTO(entity.getEducation()),
                DictDTOAssembler.ASSEMBLER.toDTO(entity.getPosition()),
                DictDTOAssembler.ASSEMBLER.toDTO(entity.getSkillCert()),
                social.getBool(), passport.getBool(), driving.getBool(), entity.getUserType(),
                entity.getUserTypeTime(), entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public UserProfile toEntity(UserProfileDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserProfile.");
    }
}
