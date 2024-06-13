package com.EastChinaGoldMedal.controller;

import com.EastChinaGoldMedal.entity.EmailParam;
import com.EastChinaGoldMedal.entity.dto.ResponseDTO;
import com.EastChinaGoldMedal.service.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
public class EmailSendController {

    @Autowired
    private SendEmailService sendEmailService;

    @GetMapping("/sendTestTo")
    public ResponseDTO<Void> sendTest(@RequestParam String recipient) {
        boolean result = sendEmailService.sendTestEmailTo(recipient);
        if(result) return ResponseDTO.success();
        return ResponseDTO.error();
    }

    @PostMapping("/sendEmail")
    public ResponseDTO<Void> sendEmail(@RequestBody Map<String, String> params) throws IOException {
        EmailParam emailParam = new EmailParam();
        emailParam.setRecipient(params.get("recipient"));
        emailParam.setTitle(params.get("title"));
        emailParam.setContent(params.get("content"));
//        log.info(emailParam.toString());

        boolean result = sendEmailService.sendEmail(emailParam);
        if(result) return ResponseDTO.success();
        return ResponseDTO.error();
    }

}
