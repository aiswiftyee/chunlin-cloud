package com.chunlin.cloud.common.enums.common;

import com.chunlin.cloud.common.enums.DictionaryEnum;
import com.chunlin.cloud.common.enums.dictionary.CssTag;
import com.chunlin.cloud.common.enums.dictionary.Dictionary;

/**
 * 对应 sys_notice 的 notice_type 字段，名称一般由对应的 <strong>表名.字段构成</strong>，全局的话使用 common 作为表名
 */
@Dictionary(name = "sysNotice.noticeType")
public enum NoticeTypeEnum implements DictionaryEnum<Integer> {

    /**
     * 通知类型
     */
    NOTIFICATION(1, "通知", CssTag.WARNING), ANNOUNCEMENT(2, "公告", CssTag.SUCCESS);

    private final int value;

    private final String description;

    private final String cssTag;

    NoticeTypeEnum(int value, String description, String cssTag) {
        this.value = value;
        this.description = description;
        this.cssTag = cssTag;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String cssTag() {
        return cssTag;
    }

}
