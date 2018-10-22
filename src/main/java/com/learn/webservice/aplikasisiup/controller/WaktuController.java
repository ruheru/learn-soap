package com.learn.webservice.aplikasisiup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaktuController {

	@GetMapping("/waktu")
	public String sekarang() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMM yyyy", new Locale("id", "ID"));
		return sdf.format(new Date());
	}
	
	@GetMapping("/appInfo")
	public Map<String, String> getAppInfo(@RequestParam(required =false)  String nama){
		Map<String, String> data = new LinkedHashMap<>();
		data.put("application.name", "Aplikasi SIUP");
		data.put("application.version", "1.0.0");
		data.put("last update", "2018-01-02");
		data.put("nama", nama);
		
		return data;
	}
}
