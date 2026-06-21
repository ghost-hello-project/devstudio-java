package com.laolang.devstudio.module.system.mapstruct;

import cn.hutool.core.util.StrUtil;
import com.laolang.devstudio.module.system.domain.res.SysDictTypeGroupInfoRes;
import com.laolang.devstudio.module.system.enums.SysDictTypeEnums;
import java.util.Objects;
import org.mapstruct.Mapper;

/**
 * @author laolang
 */
@Mapper(componentModel = "spring")
public interface SysDictMapstruct {

    /**
     * 字典分组信息转换
     * @param code 字典分组编码
     * @return 字典分组信息
     */
    default SysDictTypeGroupInfoRes toSysDictTypeGroupInfoRes(String code) {
        if (StrUtil.isBlank(code)) {
            return null;
        }
        SysDictTypeEnums.GroupCode groupCode = SysDictTypeEnums.GroupCode.getByCode(code).orElse(null);
        if (Objects.isNull(groupCode)) {
            return new SysDictTypeGroupInfoRes().setGroupCode(SysDictTypeEnums.GroupCode.UNKNOWN_CODE)
                .setGroupName(SysDictTypeEnums.GroupCode.UNKNOWN_DESC);
        }
        return new SysDictTypeGroupInfoRes().setGroupCode(groupCode.getCode()).setGroupName(groupCode.getDesc());
    }

}
