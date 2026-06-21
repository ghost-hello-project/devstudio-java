package com.laolang.devstudio.framework.common.util;

import cn.hutool.core.util.StrUtil;
import lombok.experimental.UtilityClass;
import org.slf4j.MDC;

@UtilityClass
public class TraceUtil {

    public static String getTraceId() {
        String tl = MDC.get("tl");
        if (StrUtil.isBlank(tl)) {
            return "";
        }

        tl = StrUtil.replace(tl, "<", "");
        tl = StrUtil.replace(tl, ">", "");
        return tl;
    }

}
