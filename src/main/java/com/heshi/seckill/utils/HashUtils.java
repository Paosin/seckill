package com.heshi.seckill.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.util.Objects;

/**
 * 通过Guava的Hashing来做加密
 *
 * @author Paosin
 * @version 1.0
 * @className HashUtils
 * @date 2018/2/4 20:56
 */
public class HashUtils {
    private static final Logger logger = LoggerFactory.getLogger(HashUtils.class);

    /**
     * 将字符串加盐加密
     *
     * @param str 被加密的字符串
     * @param salt 盐
     * @return 加密串
     */
    public static String saltMD5(String str, String salt) {
        return getMD5(getMD5(str) + salt);
    }

    /**
     * 获取字符串的MD5，长度32
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        return Hashing.md5().newHasher().putString(str, Charsets.UTF_8).hash().toString();
    }


    /**
     * 在MappedByteBuffer释放后再对它进行读操作的话就会引发jvm crash，在并发情况下很容易发生
     * 正在释放时另一个线程正开始读取，于是crash就发生了。所以为了系统稳定性释放前一般需要检 查是否还有线程在读或写
     *
     * @param mappedByteBuffer
     */
    public static void freedMappedByteBuffer(final MappedByteBuffer mappedByteBuffer) {
        try {
            if (mappedByteBuffer == null) {
                return;
            }

            mappedByteBuffer.force();
            AccessController.doPrivileged(new PrivilegedAction<Object>() {
                @Override
                public Object run() {
                    try {
                        Method getCleanerMethod = mappedByteBuffer.getClass().getMethod("cleaner", new Class[0]);
                        getCleanerMethod.setAccessible(true);
                        sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(mappedByteBuffer,
                                new Object[0]);
                        cleaner.clean();
                    } catch (Exception e) {
                        logger.error("clean MappedByteBuffer error!!!", e);
                    }
                    logger.info("clean MappedByteBuffer completed!!!");
                    return null;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
