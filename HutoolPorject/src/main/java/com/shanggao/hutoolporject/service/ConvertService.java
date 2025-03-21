package com.shanggao.hutoolporject.service;

import cn.hutool.core.convert.Convert;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * convert服务类
 * @Author 10699518
 * @Description: convert服务类
 */
@Service
public class ConvertService {

	/**
	 * 字符串转Date
	 * @param dateStr
	 */
	public void toDate(String dateStr) {
		Date date = Convert.toDate(dateStr);
		System.out.println(date);

		LocalDateTime localDateTime = Convert.toLocalDateTime(date);
		System.out.println(localDateTime);

		Date date1 = Convert.toDate(localDateTime);
		System.out.println(date1);
	}

	/**
	 * 金额转大写
	 * @param dateStr
	 */
	public void digitToChinese(String dateStr) {
		double a = 67556.32;
		//结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
		String digitUppercase = Convert.digitToChinese(a);
		System.out.println(digitUppercase);
	}
}
