package com.EastChinaGoldMedal.utils;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

@Slf4j
public class HtmlGenerator {
    public static String loadHtml(String content) throws IOException {
        File input = new File("src/main/resources/templates/HtmlEmailTemplates/temp1.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        String message = doc.outerHtml();
        String result = StrUtil.format(message, content);
        return result;
    }

}
