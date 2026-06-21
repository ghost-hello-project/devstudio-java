package com.laolang.devstudio.module.system.facade;

import com.google.common.collect.Lists;
import com.laolang.devstudio.module.system.domain.res.SysDictTypeGroupInfoRes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author laolang
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SysDictFacade {

    /**
     * 字典分组信息
     */
    public List<SysDictTypeGroupInfoRes> typeGroupInfo() {
        return Lists.newArrayList(new SysDictTypeGroupInfoRes().setGroupCode("system").setGroupName("系统字典"));
    }

}
