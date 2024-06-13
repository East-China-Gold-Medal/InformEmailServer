package com.EastChinaGoldMedal.entity;

import lombok.Data;

@Data
public class EmailParam {

    /**
     * 收件人Email
     */
    private String recipient;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;
}
