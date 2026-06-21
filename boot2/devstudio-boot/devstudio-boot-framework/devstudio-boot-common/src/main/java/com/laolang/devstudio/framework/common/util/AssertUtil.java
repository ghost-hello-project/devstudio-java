package com.laolang.devstudio.framework.common.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.laolang.devstudio.framework.common.exception.BusinessException;
import java.util.Collection;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class AssertUtil {

    public static void nonNull(Object obj, String message) {
        nonNull(obj, message, null);
    }

    public static void nonNull(Object obj, String message, Runnable logRunnable) {
        if (Objects.nonNull(obj)) {
            return;
        }

        if (Objects.nonNull(logRunnable)) {
            logRunnable.run();
        }

        throw new BusinessException(message);
    }

    public static void isNull(Object obj, String message) {
        isNull(obj, message, null);
    }

    public static void isNull(Object obj, String message, Runnable logRunnable) {
        if (Objects.isNull(obj)) {
            return;
        }

        if (Objects.nonNull(logRunnable)) {
            logRunnable.run();
        }

        throw new BusinessException(message);
    }

    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throw new BusinessException(message);
        }
    }

    public static void collectionSizeEquals(Collection<?> a, Collection<?> b, String message) {
        if (Objects.isNull(a) && Objects.isNull(b)) {
            throw new BusinessException("集合比较不允许有 null 值");
        }
        if (CollUtil.size(a) != CollUtil.size(b)) {
            throw new BusinessException(message);
        }
    }

}
