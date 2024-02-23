package com.chunlin.cloud.config.basic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目基础配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "chunlincloud")
public class ProjectBasicConfiguration {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 版权年份
     */
    private String copyrightYear;

}