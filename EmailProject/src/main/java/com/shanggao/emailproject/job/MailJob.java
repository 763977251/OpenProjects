package com.shanggao.emailproject.job;

import com.shanggao.emailproject.util.MailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author 10699518
 * @Description: 邮件定时任务
 */
@Component
@RequiredArgsConstructor
public class MailJob {

	private final MailUtil mailUtil;

	/**
	 * 邮件接收定时任务
	 */
	@Scheduled(cron = "30 */5 * * * ?") // 每5分钟执行一次邮件接收
	public void receiveMail() {
		mailUtil.receive();
	}
}
