/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) EnumAsValueTypeTest.java 2014-09-29 11:01
 */

package com.nonobank.data.jdbc.types;

import com.nonobank.common.base.Gender;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * @author fuchun
 * @version $Id: EnumValueTypeTest.java 117 2014-10-13 02:50:58Z fuchun $
 */
public class EnumValueTypeTest {

    private final EnumValueType<Gender, Number> evt = new EnumValueType<>(
            Gender.class);

    @Test
    public void testGetValue() throws Exception {
        ResultSet rs = createMock(ResultSet.class);
        expect(rs.getObject(0)).andReturn(Gender.FEMALE.getValue());
        expect(rs.getInt(0)).andReturn(Gender.FEMALE.getValue().intValue());
        replay(rs);

        Gender g = evt.getValue(rs, 0);
        assertNotNull(g);
        assertThat(g, Is.is(Gender.FEMALE));

        reset(rs);
        expect(rs.getObject(0)).andReturn(0);
        expect(rs.getInt(0)).andReturn(0);
        replay(rs);

        g = evt.getValue(rs, 0);
        assertNull(g);
    }

    @Test
    public void testSetValue() throws Exception {
        PreparedStatement ps = createNiceMock(PreparedStatement.class);
        ps.setInt(0, Gender.UNKNOWN.getValue().intValue());
        replay(ps);

        evt.setValue(ps, 0, Gender.UNKNOWN);
        verify(ps);

        reset(ps);
        ps.setNull(0, Types.SMALLINT);
        replay(ps);

        evt.setValue(ps, 0, null);
        verify(ps);
    }
}