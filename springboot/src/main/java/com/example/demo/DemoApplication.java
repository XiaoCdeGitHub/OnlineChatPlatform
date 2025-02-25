package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		// 检查静态资源目录权限
//		String imagePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "image").toFile().getAbsolutePath();
//		Path path = Paths.get(imagePath);
//		System.out.println(System.getProperty("user.dir"));
//		if (Files.isReadable(path)) {
//			System.out.println("图片路径可读");
//		} else {
//			System.out.println("图片路径不可读");
//		}

		SpringApplication.run(	DemoApplication.class, args);
	}

}

