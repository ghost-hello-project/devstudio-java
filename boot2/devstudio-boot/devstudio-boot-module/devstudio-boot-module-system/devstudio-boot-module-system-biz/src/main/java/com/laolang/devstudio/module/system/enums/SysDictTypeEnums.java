package com.laolang.devstudio.module.system.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author laolang
 */
public class SysDictTypeEnums {

    @Getter
    @AllArgsConstructor
    public enum GroupCode {

        /**
         * 系统字典
         */
        SYSTEM("system", "系统字典");

        private final String code;

        private final String desc;

        public static final String UNKNOWN_CODE = "unknown";

        public static final String UNKNOWN_DESC = "未分类字典";

        private static final Map<String, GroupCode> CODE_MAP;

        static {
            CODE_MAP = Arrays.stream(values()).collect(Collectors.toMap(GroupCode::getCode, Function.identity()));
        }

        public static Optional<GroupCode> getByCode(String code) {
            return Optional.ofNullable(CODE_MAP.get(code));
        }

    }

}
