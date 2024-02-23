package com.chunlin.cloud.domain.system.dto;

import cn.hutool.core.bean.BeanUtil;
import com.chunlin.cloud.common.utils.poi.annotation.ExcelColumn;
import com.chunlin.cloud.common.utils.poi.annotation.ExcelSheet;
import com.chunlin.cloud.domain.system.entity.SysUserEntity;
import com.chunlin.cloud.domain.system.entity.db.SearchUserDO;
import java.util.Date;
import lombok.Data;

/**
 * 用户数据传输对象
 */
@Data
@ExcelSheet(name = "用户列表")
public class UserDTO {

    @ExcelColumn(name = "用户 ID")
    private Long userId;

    @ExcelColumn(name = "职位 ID")
    private Long postId;

    @ExcelColumn(name = "职位名称")
    private String postName;

    @ExcelColumn(name = "角色 ID")
    private Long roleId;

    @ExcelColumn(name = "角色名称")
    private String roleName;

    @ExcelColumn(name = "部门 ID")
    private Long deptId;

    @ExcelColumn(name = "部门名称")
    private String deptName;

    @ExcelColumn(name = "用户名")
    private String username;

    @ExcelColumn(name = "用户昵称")
    private String nickname;

    @ExcelColumn(name = "用户类型")
    private Integer userType;

    @ExcelColumn(name = "邮件")
    private String email;

    @ExcelColumn(name = "号码")
    private String phoneNumber;

    @ExcelColumn(name = "性别")
    private Integer sex;

    @ExcelColumn(name = "用户头像")
    private String avatar;

    @ExcelColumn(name = "状态")
    private Integer status;

    @ExcelColumn(name = "IP")
    private String loginIp;

    @ExcelColumn(name = "登录时间")
    private Date loginDate;

    @ExcelColumn(name = "创建者ID")
    private Long creatorId;

    @ExcelColumn(name = "创建者")
    private String creatorName;

    @ExcelColumn(name = "创建时间")
    private Date createTime;

    @ExcelColumn(name = "修改者 ID")
    private Long updaterId;

    @ExcelColumn(name = "修改者")
    private String updaterName;

    @ExcelColumn(name = "修改时间")
    private Date updateTime;

    @ExcelColumn(name = "备注")
    private String remark;

    public UserDTO(SysUserEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }

    public UserDTO(SearchUserDO entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }

}

