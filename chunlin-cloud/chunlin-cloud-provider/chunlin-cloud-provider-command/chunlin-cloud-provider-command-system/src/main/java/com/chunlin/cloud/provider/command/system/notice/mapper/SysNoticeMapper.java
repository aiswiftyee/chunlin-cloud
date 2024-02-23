package com.chunlin.cloud.provider.command.system.notice.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chunlin.cloud.domain.system.entity.SysNoticeEntity;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 通知公告 Mapper 接口
 * </p>
 */
public interface SysNoticeMapper extends BaseMapper<SysNoticeEntity> {

    /**
     * 根据条件，分页查询公告列表
     * @param page 分页对象
     * @param queryWrapper 查询构造器
     * @return 分页处理后的公告列表
     */
    Page<SysNoticeEntity> getNoticeList(Page<SysNoticeEntity> page, @Param(Constants.WRAPPER) Wrapper<SysNoticeEntity> queryWrapper);

}
