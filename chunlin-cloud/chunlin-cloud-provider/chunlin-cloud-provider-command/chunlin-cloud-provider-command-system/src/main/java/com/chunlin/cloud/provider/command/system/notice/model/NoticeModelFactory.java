package com.chunlin.cloud.provider.command.system.notice.model;

import com.chunlin.cloud.common.exception.GlobalException;
import com.chunlin.cloud.common.exception.error.ErrorCode.Business;
import com.chunlin.cloud.domain.system.entity.SysNoticeEntity;
import com.chunlin.cloud.provider.command.system.notice.service.SysNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 通知公告模型工厂
 */
@Component
@RequiredArgsConstructor
public class NoticeModelFactory {

    private final SysNoticeService noticeService;

    public NoticeModel loadById(Long noticeId) {
        SysNoticeEntity byId = noticeService.getById(noticeId);

        if (byId == null) {
            throw new GlobalException(Business.COMMON_OBJECT_NOT_FOUND, noticeId, "通知公告");
        }

        return new NoticeModel(byId);
    }

    public NoticeModel create() {
        return new NoticeModel();
    }

}
