package com.chunlin.cloud.consumer.system.feign.fallback;

import com.chunlin.cloud.consumer.system.feign.SysNoticeClient;
import com.chunlin.cloud.consumer.system.query.NoticeQuery;

/**
 * 公告通知容错回退
 */
public class SysNoticeClientFallback implements SysNoticeClient {


    @Override
    public String getList(NoticeQuery query) {
        return "获取公告通知列表失败，请稍候再试";
    }

    @Override
    public String getInfo(Long noticeId) {
        return "获取公告通知详情失败，请稍候再试";
    }

}
