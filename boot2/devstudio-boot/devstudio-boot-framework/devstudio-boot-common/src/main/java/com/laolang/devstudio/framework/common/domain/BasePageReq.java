package com.laolang.devstudio.framework.common.domain;

import lombok.Data;

@Data
public class BasePageReq {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
