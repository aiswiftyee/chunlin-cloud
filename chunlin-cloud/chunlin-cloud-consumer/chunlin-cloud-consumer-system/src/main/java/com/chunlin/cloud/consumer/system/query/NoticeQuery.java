package com.chunlin.cloud.consumer.system.query;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公告通知查询构造器
 */
@Data
@NoArgsConstructor
public class NoticeQuery {

    private String noticeType;

    private String noticeTitle;

    private String creatorName;

}
