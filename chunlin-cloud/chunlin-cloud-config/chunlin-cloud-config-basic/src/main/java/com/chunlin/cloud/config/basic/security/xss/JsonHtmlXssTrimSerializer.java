package com.chunlin.cloud.config.basic.security.xss;

import cn.hutool.http.HtmlUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

/**
 * 防 XSS 脚本注入，去除 HTML 标签
 */
public class JsonHtmlXssTrimSerializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getValueAsString();
        if (value != null) {
            // 去除掉 html 标签，如果想要转义的话，可使用 HtmlUtil.escape()
            return HtmlUtil.cleanHtmlTag(value);
        }
        return null;
    }

    @Override
    public Class<String> handledType() {
        return String.class;
    }

}
