package com.diaosichengxuyuan.spring.mvc.common.encrypt;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * DES加解密类
 *
 * @author liuhaipeng
 * @date 2018/8/29
 */
public class DESEncryptUtil {

    private static final Key KEY;

    private static final String ENCRYPT_ALGORITHM_KEY = "encrypt.algorithm.key";

    private static final String ENCRYPT_ALGORITHM = "DES";

    private static final String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";

    private static final String ENCODE = "UTF-8";

    static {
        String encryptAlgorithmKey = System.getProperty(ENCRYPT_ALGORITHM_KEY);
        if(StringUtils.isEmpty(encryptAlgorithmKey)) {
            throw new RuntimeException("未配置JVM参数encrypt.algorithm.key");

        }
        try {
            KeyGenerator generator = KeyGenerator.getInstance(ENCRYPT_ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
            secureRandom.setSeed(encryptAlgorithmKey.getBytes());
            generator.init(secureRandom);
            KEY = generator.generateKey();
        } catch(Exception e) {
            throw new RuntimeException("加密初始化失败", e);
        }
    }

    /**
     * 对字符串进行加密，返回BASE64的加密字符串
     *
     * @param str 被加密字符串
     * @return
     */
    public static String encrypt(String str) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        System.out.println(KEY);
        try {
            byte[] strBytes = str.getBytes(ENCODE);
            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, KEY);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return base64Encoder.encode(encryptStrBytes);
        } catch(Exception e) {
            throw new RuntimeException(String.format("加密%s失败", str), e);
        }

    }

    /**
     * 对BASE64加密字符串进行解密
     *
     * @param str 被解密字符串
     * @return
     */
    public static String decrypt(String str) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] strBytes = base64Decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, KEY);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return new String(encryptStrBytes, ENCODE);
        } catch(Exception e) {
            throw new RuntimeException(String.format("解密%s失败", str), e);
        }
    }

}
