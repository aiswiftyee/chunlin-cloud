package com.chunlin.cloud.consumer.system.config;

import com.chunlin.cloud.consumer.system.feign.SysNoticeClient;
import com.chunlin.cloud.consumer.system.feign.fallback.SysNoticeClientFallback;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public SysNoticeClient sysNoticeClientFallback() {
        return new SysNoticeClientFallback();
    }

}
