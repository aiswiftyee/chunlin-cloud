package com.chunlin.cloud.provider.command.system.notice;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公告通知：更新命令
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeUpdateCommand extends NoticeAddCommand {

    @NotNull
    @Positive
    protected Long noticeId;

}
