package com.chunlin.cloud.consumer.system.controller;

import com.chunlin.cloud.consumer.system.feign.SysNoticeClient;
import com.chunlin.cloud.consumer.system.query.NoticeQuery;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 远程调用公告通知控制器
 */
@RestController
@RequestMapping("/system/notices")
public class SysNoticeController {

    @Resource
    private SysNoticeClient sysNoticeClient;

    @GetMapping
    public String getList(NoticeQuery query) {
        return sysNoticeClient.getList(query);
    }

    @GetMapping("/{noticeId}")
    public String getInfo(@PathVariable Long noticeId) {
        return sysNoticeClient.getInfo(noticeId);
    }

}
