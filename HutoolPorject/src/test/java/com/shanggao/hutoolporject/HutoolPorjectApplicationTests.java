package com.shanggao.hutoolporject;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class HutoolPorjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void excel() {
		ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\10699518\\Desktop\\物料消耗.xlsx"), 0);
		List<Map<String, Object>> list = reader.readAll();
		System.out.println(JSONUtil.toJsonStr(list));
		int index = 1;
		for (Map<String, Object> map : list) {
			try {
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("PROCESSCODE", map.get("PROCESSCODE"));
				paramMap.put("USERNUMBER", map.get("USERNUMBER"));
				paramMap.put("BOXID", map.get("BOXID"));
				paramMap.put("WIPENTITYNAME", map.get("WIPENTITYNAME"));
				paramMap.put("GROUPCODE", map.get("GROUPCODE"));
				paramMap.put("CONSUMEQTY", map.get("CONSUMEQTY"));
				paramMap.put("LINENAME", map.get("LINENAME"));
				paramMap.put("OPTIMIZATIONNO", map.get("OPTIMIZATIONNO"));
				paramMap.put("OPTIMIZATIONNOSEQ", map.get("OPTIMIZATIONNOSEQ"));
				String body = HttpUtil.post("URL", JSONUtil.toJsonStr(paramMap));
				System.out.println(index++ + body);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
