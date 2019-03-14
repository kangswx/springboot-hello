package com.swkang.springboot.springboothello.controller;

import com.swkang.springboot.springboothello.domain.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {

    public static final String filePath = "E:\\software programe\\ideaprogram\\springboot-hello\\src\\main\\resources\\static\\images\\";

    @RequestMapping("/api/v1/gapage")
    public Object index() {
        return "index";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

        String name = request.getParameter("name");
        System.out.println("name: " + name);

        //获取文件名称
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名称为： " + fileName);

        //获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf('.'));
        System.out.println("上传文件的后缀名为： " + suffixName);

        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的文件名称为： " + fileName);
        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);   //性能比流的形式保存文件快很多
            return new JsonData(0, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, "上传失败");
    }
}
