package com.EastChinaGoldMedal.utils;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;

@Slf4j
public class HtmlGenerator {
    private static final String EMAIL_HTML_TEMPLATE  = "templates/HtmlEmailTemplates/temp3.html";

    public static String loadHtml(String content) throws IOException {
        String templateContent = ResourceUtil.readUtf8Str(EMAIL_HTML_TEMPLATE);
        String result = StrUtil.format(templateContent, content);
        return result;
    }

}
