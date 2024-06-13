package com.EastChinaGoldMedal.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.EastChinaGoldMedal.config.MailConfig;
import com.EastChinaGoldMedal.entity.EmailParam;
import com.EastChinaGoldMedal.utils.HtmlGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendEmailService {

    @Autowired
    private MailConfig config;

    private MailAccount initAccount(){
        MailAccount account = new MailAccount();

        account.setHost(config.getHost());
        account.setPort(config.getPort());
        account.setAuth(config.isAuth());
        account.setStarttlsEnable(config.isStarttlsEnable());
        account.setFrom(config.getFrom());
        account.setPass(config.getPass());

        return account;
    }

    public boolean sendTestEmailTo(String recipient){
        log.info(config.toString());
        try {
            MailAccount account = initAccount();
            MailUtil.send(account, CollUtil.newArrayList(recipient), "测试", "邮件测试", false);
            log.info("send success");
            return true;
        }catch (Exception e){
            log.error("send failed! {}",e.toString());
        }
        return false;
    }

    public boolean sendEmail(EmailParam emailParam){
        log.info(config.toString());
        try {
            MailAccount account = initAccount();
            String content = HtmlGenerator.loadHtml(emailParam.getContent());
            MailUtil.send(
                    account,
                    CollUtil.newArrayList(emailParam.getRecipient()),
                    emailParam.getTitle(),
                    content,
                    true);
            log.info("send success!");
            return true;
        }catch (Exception e){
            log.error("send failed! {}", e.toString());
        }
        return false;
    }
}
