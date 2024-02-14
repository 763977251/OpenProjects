package com.shanggao.hutoolporject.controller;

import com.shanggao.hutoolporject.service.ConvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * convert相关接口
 * @Author 10699518
 * @Description: convert相关接口
 */
@RestController
@RequiredArgsConstructor
public class ConvertController {

	private final ConvertService convertService;

	/**
	 * 字符串转Date
	 * @param dateStr
	 */
	@GetMapping("/hutool/convert/date")
	public void convertDate(String dateStr) {
		convertService.toDate(dateStr);
	}
}
