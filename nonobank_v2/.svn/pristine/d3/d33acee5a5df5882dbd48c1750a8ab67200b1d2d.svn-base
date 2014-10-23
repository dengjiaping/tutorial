/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) RedisRepositoryTest.java 2014-10-17 15:47
 */

package com.nonobank.data.repository.support;

import com.nonobank.data.convert.beanutils.EnumConverter;
import com.nonobank.data.convert.beanutils.JodaDateTimeConverter;
import com.nonobank.data.domain.TUserStatus;
import com.nonobank.data.domain.TestDomain;
import com.nonobank.data.redis.BeanUtilsBeanHashMapper;
import com.nonobank.data.repository.GenericRepository;
import org.hamcrest.core.IsNull;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
@DirtiesContext
public class RedisRepositoryTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private TestDomainRedisRepository domainRedisRepository;

    @Before
    public void setUp() throws Exception {
        domainRedisRepository = new TestDomainRedisRepository();
        domainRedisRepository.setStringRedisTemplate(stringRedisTemplate);
        domainRedisRepository.afterPropertiesSet();
    }

    @Test
    public void testSaveAndFind() throws Exception {
        TestDomain td1 = TestDomain.newInstance("Tomas", TUserStatus.VALIDATED)
                .id(100);
        TestDomain td2 = TestDomain.newInstance("Jack", TUserStatus.VALIDATED).id(101);

        domainRedisRepository.save(td1);
        domainRedisRepository.save(td2);

        TestDomain retrieved = domainRedisRepository.findOne(td1.getId());

        Assert.assertThat(retrieved, IsNull.notNullValue());

        retrieved = domainRedisRepository.findByName(td1.getName());

        Assert.assertThat(retrieved, IsNull.notNullValue());

        domainRedisRepository.deleteAll();

        retrieved = domainRedisRepository.findByName(td1.getName());

        Assert.assertThat(retrieved, IsNull.nullValue());

        retrieved = domainRedisRepository.findByName(td2.getName());

        Assert.assertThat(retrieved, IsNull.nullValue());
    }

    private static class TestDomainRedisRepository extends RedisRepository<TestDomain, Integer>
            implements GenericRepository<TestDomain, Integer> {

        TestDomainRedisRepository() {
            super();

            BeanUtilsBeanHashMapper<TestDomain> beanHashMapper =
                    new BeanUtilsBeanHashMapper<>(TestDomain.class);
            beanHashMapper.getBeanUtilsBean().getConvertUtils()
                    .register(new JodaDateTimeConverter(), DateTime.class);
            beanHashMapper.getBeanUtilsBean().getConvertUtils()
                    .register(new EnumConverter<>(TUserStatus.class, TUserStatus.CREATED),
                            TUserStatus.class);
            setHashMapper(beanHashMapper);
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            super.afterPropertiesSet();

            getRedisQuery().setEntityShortName("tdn");
            getRedisQuery().setExcludeProperties(new String[]{"new", "class"});
            getRedisQuery().addPropIndex(TestDomain.PROP_NAME, TestDomain.PROP_NAME, true);
        }

        public TestDomain findByName(String name) {
            String propIndexKey = getRedisQuery().getPropIndexKey(
                    TestDomain.PROP_NAME, name);
            String id = redisTemplate.opsForValue().get(propIndexKey);
            if (id == null) {
                return null;
            }
            return findOne(Integer.valueOf(id));
        }
    }
}