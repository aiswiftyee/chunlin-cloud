package com.chunlin.cloud.common.enums;

/**
 * 字典类型接口
 */
public interface DictionaryEnum<T> extends BasicEnum<T> {

    /**
     * 获取 css 标签
     * @return css 标签
     */
    String cssTag();

}
