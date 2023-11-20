package com.example.excel.homewok2.controllers;

import com.example.excel.homewok2.entities.Data;
import com.example.excel.homewok2.repositories.DataRepository;
import com.example.excel.homewok2.services.ExelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/excel")
public class DataController {
    private final ExelService excelService;
    private final DataRepository dataRepository;


    @GetMapping("/data")
    public ResponseEntity<List<Data>> getAllData() {
        List<Data> allData = dataRepository.findAll();
        return ResponseEntity.ok(allData);
    }

    @Autowired
    public DataController(ExelService exelService, DataRepository dataRepository) {
        this.excelService = exelService;
        this.dataRepository = dataRepository;
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