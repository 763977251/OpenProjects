package com.shanggao.hutoolporject.service;

import cn.hutool.core.convert.Convert;
import org.springframework.stereotype.Service;

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
	}
}
