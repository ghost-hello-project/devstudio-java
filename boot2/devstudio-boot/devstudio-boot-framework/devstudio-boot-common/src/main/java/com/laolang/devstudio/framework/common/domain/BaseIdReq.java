package com.laolang.devstudio.framework.common.domain;

import java.util.List;
import lombok.Data;

@Data
public class BaseIdReq {

    private Long id;

    private List<Long> ids;

}
