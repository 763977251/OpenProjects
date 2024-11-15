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
				//String siteName = GenericServiceProxy.getConstantMap().SiteName_XY;
				//String userNumber = in.getString("USERNUMBER");//用户账号
				//String boxId = in.getString("BOXID"); //箱号
				//String wipEntityName = in.getString("WIPENTITYNAME"); //任务单号，多个用逗号隔开
				//String groupCode = in.getString("GROUPCODE"); //班组
				//BigDecimal consumeQty = in.getBigDecimal("CONSUMEQTY"); //本次消耗数量
				//String processCode = in.getString("PROCESSCODE"); //工序编码
				//String lineName = in.getString("LINENAME");
				//String optimizationNo = in.getString("OPTIMIZATIONNO"); //优化包号
				//String optimizationNoSeq = in.getString("OPTIMIZATIONNOSEQ"); //优化包版图号
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
				String body = HttpUtil.post("http://10.107.1.35:31300/materialpick/materialConsumeReport", JSONUtil.toJsonStr(paramMap));
//				String body = HttpRequest.of("http://127.0.0.1:17878/materialpick/materialConsumeReport")
//						.body(JSONUtil.toJsonStr(paramMap)).execute().body();
				System.out.println(index++ + body);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
