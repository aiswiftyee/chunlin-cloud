package com.chunlin.cloud.domain.system.dto;

import cn.hutool.core.bean.BeanUtil;
import com.chunlin.cloud.domain.system.entity.SysNoticeEntity;
import java.util.Date;
import lombok.Data;

/**
 * 通知公告数据传输对象
 */
@Data
public class NoticeDTO {

    /**
     * 公告 ID
     */
    private String noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告类型（1-通知，2-公告）
     */
    private Integer noticeType;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告状态（1-正常，0-关闭）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String creatorName;

    public NoticeDTO(SysNoticeEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }

}

