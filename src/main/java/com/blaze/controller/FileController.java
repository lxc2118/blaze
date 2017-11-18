package com.blaze.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import util.DateUtil;

@Controller
public class FileController {

	@ResponseBody
	@RequestMapping(value = "/upload")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("upload/") + DateUtil.format(new Date(), "yyyyMMdd");
		String fileName = file.getOriginalFilename();
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}
}
