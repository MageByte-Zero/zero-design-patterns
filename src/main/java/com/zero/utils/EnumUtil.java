package com.zero.utils;

import java.util.Random;

/**
 * 枚举工具类
 * Created by unique on 2018/4/1.
 */
public class EnumUtil {
    private static Random rand = new Random(47);

    /**
     * 随机获取枚举
     * @param ec
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    /**
     * 随机获取枚举
     * @param values
     * @param <T>
     * @return
     */
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
