package com.laolang.devstudio.module.system.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "devstudio.mq.system")
public class SystemMqProperties {

    private String systemDictExportTopic;

    private String systemStreamName;

    private String systemDictExportGroup;

}
