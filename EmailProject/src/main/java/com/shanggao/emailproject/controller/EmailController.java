package com.shanggao.emailproject.controller;

import com.shanggao.emailproject.util.MailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final MailUtil mailUtil;

    /**
     * 邮件接收触发接口
     * @return
     */
    @PostMapping("/receiveEmail")
    public String receiveEmail() {
        try {
            mailUtil.receive();
            return "接收邮件成功";
        } catch (MailException e) {
            e.printStackTrace();
            return "接收邮件方失败";
        }
    }

}
