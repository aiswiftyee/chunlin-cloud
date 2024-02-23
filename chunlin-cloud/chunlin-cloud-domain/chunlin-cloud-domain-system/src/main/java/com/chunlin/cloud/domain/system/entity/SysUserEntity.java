package com.chunlin.cloud.domain.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chunlin.cloud.common.pojo.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户信息实体类
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUserEntity extends BaseEntity<SysUserEntity> {

    private static final long serialVersionUID = 7177153168233400844L;

    /**
     * 用户 ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 职位 ID
     */
    @TableField("post_id")
    private Long postId;

    /**
     * 角色 ID
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 部门 ID
     */
    @TableField("dept_id")
    private Long deptId;

    /**
     * 用户账号
     */
    @TableField("username")
    private String username;

    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 用户类型（00-系统用户）
     */
    @TableField("user_type")
    private Integer userType;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号码
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 用户性别（0-男，1-女，2-未知）
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 头像地址
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 密码
     */
    @TableField("`password`")
    private String password;

    /**
     * 帐号状态（1-正常，2-停用，3-冻结）
     */
    @TableField("`status`")
    private Integer status;

    /**
     * 最后登录 IP
     */
    @TableField("login_ip")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @TableField("login_date")
    private Date loginDate;

    /**
     * 超级管理员标志（1-是，0-否）
     */
    @TableField("is_admin")
    private Boolean isAdmin;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    @Override
    public Serializable pkVal() {
        return this.userId;
    }

}

