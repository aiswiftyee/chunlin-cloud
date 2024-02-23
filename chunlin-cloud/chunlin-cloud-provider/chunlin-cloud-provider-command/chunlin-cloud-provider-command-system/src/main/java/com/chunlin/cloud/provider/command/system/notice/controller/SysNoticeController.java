package com.chunlin.cloud.provider.command.system.notice.controller;

import com.chunlin.cloud.common.pojo.dto.ResponseResult;
import com.chunlin.cloud.common.pojo.page.PageDTO;
import com.chunlin.cloud.domain.system.dto.NoticeDTO;
import com.chunlin.cloud.provider.command.system.notice.handler.NoticeCommandHandler;
import com.chunlin.cloud.provider.command.system.notice.query.NoticeQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公告通知控制器
 */
@RestController
@RequestMapping("/system/notices")
@Validated
@RequiredArgsConstructor
public class SysNoticeController {

    private final NoticeCommandHandler noticeCommandHandler;

    /**
     * 获取列表
     */
    @GetMapping
    public ResponseResult<PageDTO<NoticeDTO>> list(NoticeQuery query) {
        PageDTO<NoticeDTO> pageDTO = noticeCommandHandler.getNoticeList(query);
        return ResponseResult.success(pageDTO);
    }

    /**
     * 获取详情
     */
    @GetMapping("/{noticeId}")
    public ResponseResult<NoticeDTO> getInfo(@PathVariable @NotNull @Positive Long noticeId) {
        return ResponseResult.success(noticeCommandHandler.getNoticeInfo(noticeId));
    }

}
