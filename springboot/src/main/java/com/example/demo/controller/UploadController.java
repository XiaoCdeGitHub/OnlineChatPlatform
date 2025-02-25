package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/files/**")
//                .addResourceLocations("file:///C:/Users/yu/Desktop/OnlineChatPlatformSystem/springboot/src/main/resources/static/image/");
//    }
//}

@RestController
@RequestMapping
public class UploadController {

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        System.out.println("文件上传");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timestampString=timestamp.getTime()+"";
        String fileName=file.getOriginalFilename()+"";
        String fileTypesName=fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        try {
//            String path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(fileTypesName);
            String imagePath="C:\\Users\\yu\\Desktop\\OnlineChatPlatformSystem\\springboot\\src\\main\\resources\\static\\image\\"+timestampString+fileTypesName;
//            String imagePath="D:\\FishWallpaper"+timestampString+fileTypesName;
            file.transferTo(new java.io.File(imagePath));
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        System.out.println("已上传");
        return "http://localhost:8081/image/"+timestampString+fileTypesName;
//        return timestampString+fileTypesName;
    }
}



//@RestController
//@RequestMapping
//public class UploadController {
//
//    @PostMapping("/upload")
//    public String fileUpload(@RequestParam("file") MultipartFile file) {
//        System.out.println("文件上传");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        String timestampString = String.valueOf(timestamp.getTime());
//        String fileName = file.getOriginalFilename();
//        String fileTypeName = fileName.substring(fileName.lastIndexOf("."));
//
//        try {
//            // 获取 classpath 根目录的绝对路径
//            String path = ResourceUtils.getURL("classpath:").getPath();
//            // 构建保存文件的路径
//            String imagePath = path + "static/image/" + timestampString + fileTypeName;
//            // 保存文件
//            file.transferTo(new File(imagePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("已上传");
//        // 返回文件访问 URL
//        return "http:\\localhost:8081/image/" + timestampString + fileTypeName;
//    }
//}

