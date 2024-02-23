package com.chunlin.cloud.common.pojo.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity 基类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseEntity<T extends Model<?>> extends Model<T> {

    /**
     * 创建者 ID
     */
    @TableField(value = "creator_id", fill = FieldFill.INSERT)
    private Long creatorId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者 ID
     */
    @TableField(value = "updater_id", fill = FieldFill.UPDATE, updateStrategy = FieldStrategy.NOT_NULL)
    private Long updaterId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 删除标志（0-存在，1-删除）
     * <p>
     * deleted 字段请在数据库中设置为 tinyint 并且非 null 默认值为 0
     * </p>
     */
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;

}
