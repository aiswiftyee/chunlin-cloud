package com.chunlin.cloud.provider.command.system.notice.model;

import cn.hutool.core.bean.BeanUtil;
import com.chunlin.cloud.common.enums.BasicEnumUtil;
import com.chunlin.cloud.common.enums.common.NoticeTypeEnum;
import com.chunlin.cloud.common.enums.common.StatusEnum;
import com.chunlin.cloud.domain.system.entity.SysNoticeEntity;
import com.chunlin.cloud.provider.command.system.notice.NoticeAddCommand;
import com.chunlin.cloud.provider.command.system.notice.NoticeUpdateCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 通知公告
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class NoticeModel extends SysNoticeEntity {

    public NoticeModel(SysNoticeEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }

    public void loadAddCommand(NoticeAddCommand command) {
        if (command != null) {
            BeanUtil.copyProperties(command, this, "noticeId");
        }
    }

    public void loadUpdateCommand(NoticeUpdateCommand command) {
        if (command != null) {
            loadAddCommand(command);
        }
    }

    public void checkFields() {
        BasicEnumUtil.fromValue(NoticeTypeEnum.class, getNoticeType());
        BasicEnumUtil.fromValue(StatusEnum.class, getStatus());
    }

}
