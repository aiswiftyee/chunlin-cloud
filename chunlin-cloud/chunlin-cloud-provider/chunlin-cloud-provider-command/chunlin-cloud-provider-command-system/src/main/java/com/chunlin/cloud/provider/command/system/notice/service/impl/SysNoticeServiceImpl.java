package com.chunlin.cloud.provider.command.system.notice.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chunlin.cloud.domain.system.entity.SysNoticeEntity;
import com.chunlin.cloud.provider.command.system.notice.mapper.SysNoticeMapper;
import com.chunlin.cloud.provider.command.system.notice.service.SysNoticeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     通知公告服务实现类
 * </p>
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNoticeEntity> implements SysNoticeService {

    @Override
    public Page<SysNoticeEntity> getNoticeList(Page<SysNoticeEntity> page, Wrapper<SysNoticeEntity> queryWrapper) {
        return this.baseMapper.getNoticeList(page, queryWrapper);
    }

}
