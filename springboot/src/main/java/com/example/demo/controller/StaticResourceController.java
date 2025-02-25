package com.example.demo.controller;

import lombok.val;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Controller
public class StaticResourceController {
    @GetMapping("/files/{fileName}")
    public ResponseEntity<Resource> getStaticResource(@PathVariable String fileName) {
        val resource = (Resource) new ClassPathResource("./resources/static/image/" + fileName);
        return ResponseEntity.ok(resource);
    }
}
