package com.example.excel.homewok2.controllers;

import com.example.excel.homewok2.services.ExelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/excel")
public class DataController {
    private final ExelService excelService;

    @Autowired
    public DataController(ExelService exelService) {
        this.excelService = exelService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select an Excel file to upload.");
        }

        try {
            excelService.processExcelFile(file.getInputStream());

            return ResponseEntity.ok("Excel file uploaded and data inserted into the database successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while processing the Excel file.");
        }
    }
}