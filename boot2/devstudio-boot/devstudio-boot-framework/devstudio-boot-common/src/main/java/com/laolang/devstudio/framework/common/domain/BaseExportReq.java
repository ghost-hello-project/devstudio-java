package com.laolang.devstudio.framework.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseExportReq extends BaseIdReq {

    private Boolean exportAll;

}
