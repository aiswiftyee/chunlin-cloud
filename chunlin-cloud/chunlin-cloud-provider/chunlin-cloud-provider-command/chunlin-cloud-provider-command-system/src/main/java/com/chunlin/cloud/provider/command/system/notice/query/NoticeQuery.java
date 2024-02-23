package com.chunlin.cloud.provider.command.system.notice.query;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chunlin.cloud.common.pojo.page.AbstractPageQuery;
import com.chunlin.cloud.domain.system.entity.SysNoticeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 公告通知查询构造器
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class NoticeQuery extends AbstractPageQuery<SysNoticeEntity> {

    private String noticeType;

    private String noticeTitle;

    private String creatorName;

    @Override
    public QueryWrapper<SysNoticeEntity> addQueryCondition() {
        return new QueryWrapper<SysNoticeEntity>()
            .like(StrUtil.isNotEmpty(noticeTitle), "notice_title", noticeTitle)
            .eq(StrUtil.isNotEmpty(noticeType), "notice_type", noticeType)
            .eq("n.deleted", 0)
            .like(StrUtil.isNotEmpty(creatorName), "u.username", creatorName);
    }
}
