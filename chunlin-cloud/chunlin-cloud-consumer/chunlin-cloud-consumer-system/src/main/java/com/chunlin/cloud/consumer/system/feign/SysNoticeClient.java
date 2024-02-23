package com.chunlin.cloud.consumer.system.feign;

import com.chunlin.cloud.consumer.system.config.FeignConfiguration;
import com.chunlin.cloud.consumer.system.feign.fallback.SysNoticeClientFallback;
import com.chunlin.cloud.consumer.system.query.NoticeQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 公告通知客户端
 */
@FeignClient(name = "provider-command-system", fallback = SysNoticeClientFallback.class, configuration = FeignConfiguration.class)
public interface SysNoticeClient {

    /**
     * 远程调用提供者-获取公告通知列表
     *
     * @param query 注意：需要使用 @SpringQueryMap 注解将参数改为 Map 格式才能传递
     */
    @GetMapping("/system/notices")
    String getList(@SpringQueryMap NoticeQuery query);

    /**
     * 远程调用提供者-获取公告通知详情
     */
    @GetMapping("/system/notices/{noticeId}")
    String getInfo(@PathVariable("noticeId") Long noticeId);

}
