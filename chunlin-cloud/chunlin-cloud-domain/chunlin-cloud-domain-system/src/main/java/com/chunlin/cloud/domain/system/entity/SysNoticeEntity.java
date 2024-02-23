package com.chunlin.cloud.domain.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chunlin.cloud.common.pojo.base.BaseEntity;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * 通知公告实体类
 */
@Getter
@Setter
@TableName("sys_notice")
public class SysNoticeEntity extends BaseEntity<SysNoticeEntity> {

    private static final long serialVersionUID = -1277501556509663242L;

    /**
     * 公告 ID
     */
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;

    /**
     * 公告标题
     */
    @TableField("notice_title")
    private String noticeTitle;

    /**
     * 公告类型（1-通知，2-公告）
     */
    @TableField("notice_type")
    private Integer noticeType;

    /**
     * 公告内容
     */
    @TableField("notice_content")
    private String noticeContent;

    /**
     * 公告状态（1-正常，0-关闭）
     */
    @TableField("`status`")
    private Integer status;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    @Override
    public Serializable pkVal() {
        return this.noticeId;
    }

}

