package com.EastChinaGoldMedal.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("mail")
public class MailConfig {

    /**
     * 服务器地址
     */
    private String host;
    /**
     * 端口，默认25
     */
    private int port;
    /**
     * 默认true
     */
    private boolean auth;
    /**
     * 发件人邮箱地址
     */
    private String from;
    /**
     * 发件人的邮箱授权码
     */
    private String pass;

    //开启ssl
    private boolean starttlsEnable;
    private boolean sslEnable;
    private String socketFactoryClass;
    private boolean socketFactoryFallback;
    private int socketFactoryPort;
}