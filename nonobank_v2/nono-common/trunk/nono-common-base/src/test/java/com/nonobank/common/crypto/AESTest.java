/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) AESTest.java 2014-09-24 16:01
 */

package com.nonobank.common.crypto;

import com.nonobank.common.base.RandomStrings;
import org.junit.Test;

import java.security.Key;

/**
 * {@link AES} test case.
 *
 * @author Fuchun
 * @version $Id: AESTest.java 24 2014-09-24 08:02:42Z fuchun $
 */
public class AESTest extends CryptoTest {

    @Test
    public void testCbcPKCS5Padding() {
        Key key = AES.getKey128();
        byte[] iv = RandomStrings.randomAlphanumeric(16).getBytes();
        AES aes = AES.cbcPKCS5Padding(key.getEncoded(), iv);
        LOGGER.debug("========== mode: CBC, padding: PKCS5, keySize: 128 ==========");
        testGivenSource(aes);

        key = AES.getKey192();
        aes = AES.cbcPKCS5Padding(key.getEncoded(), iv);
        LOGGER.debug("\n========== mode: CBC, padding: PKCS5, keySize: 192 ==========");
        testGivenSource(aes);

        key = AES.getKey256();
        aes = AES.cbcPKCS5Padding(key.getEncoded(), iv);
        LOGGER.debug("\n========== mode: CBC, padding: PKCS5, keySize: 256 ==========");
        testGivenSource(aes);
    }

    @Test
    public void testCbcNoPadding() {
        Key key = AES.getKey128();
        byte[] iv = RandomStrings.randomAlphanumeric(16).getBytes();
        AES aes = AES.cbcNoPadding(key.getEncoded(), iv);
        LOGGER.debug("\n========== mode: CBC, padding: No, keySize: 128 ==========");
        testGivenSource(aes);

        key = AES.getKey192();
        aes = AES.cbcNoPadding(key.getEncoded(), iv);
        LOGGER.debug("\n========== mode: CBC, padding: No, keySize: 192 ==========");
        testGivenSource(aes);

        key = AES.getKey256();
        aes = AES.cbcNoPadding(key.getEncoded(), iv);
        LOGGER.debug("\n========== mode: CBC, padding: No, keySize: 256 ==========");
        testGivenSource(aes);
    }

    @Test
    public void testEcbPKCS5Padding() {
        Key key = AES.getKey128();
        AES aes = AES.ecbPKCS5Padding(key.getEncoded());
        LOGGER.debug("\n========== mode: ECB, padding: PKCS5, keySize: 128 ==========");
        testGivenSource(aes);

        key = AES.getKey192();
        aes = AES.ecbPKCS5Padding(key.getEncoded());
        LOGGER.debug("\n========== mode: ECB, padding: PKCS5, keySize: 192 ==========");
        testGivenSource(aes);

        key = AES.getKey256();
        aes = AES.ecbPKCS5Padding(key.getEncoded());
        LOGGER.debug("\n========== mode: ECB, padding: PKCS5, keySize: 256 ==========");
        testGivenSource(aes);
    }

    @Test
    public void testEcbNoPadding() {
        Key key = AES.getKey128();
        AES aes = AES.ecbNoPadding(key.getEncoded());
        LOGGER.debug("\n========== mode: ECB, padding: No, keySize: 128 ==========");
        testGivenSource(aes);

        key = AES.getKey192();
        aes = AES.ecbNoPadding(key.getEncoded());
        LOGGER.debug("\n========== mode: ECB, padding: No, keySize: 192 ==========");
        testGivenSource(aes);

        key = AES.getKey256();
        aes = AES.ecbNoPadding(key.getEncoded());
        LOGGER.debug("\n========== mode: ECB, padding: No, keySize: 256 ==========");
        testGivenSource(aes);
    }
}