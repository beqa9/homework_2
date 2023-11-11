package com.example.excel.homewok2.services;

import com.example.excel.homewok2.entities.Data;
import com.example.excel.homewok2.entities.DataHistory;
import com.example.excel.homewok2.repositories.DataHistoryRepository;
import com.example.excel.homewok2.repositories.DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DataService {
    private final DataRepository dataRepository;
    private final DataHistoryRepository dataHistoryRepository;

    public void saveToDatabase(Data data) {
        LocalDateTime currentTimestamp = LocalDateTime.now();
        data.setCreatedAt(currentTimestamp);
        if (!dataRepository.existsByLatitudeAndLongitude(data.getLatitude(), data.getLongitude())) {
            dataRepository.save(data);
        }
    }

    public void saveToHistoryDatabase(DataHistory dataHistory) {
        LocalDateTime currentTimestamp = LocalDateTime.now();
        dataHistory.setCreatedAt(currentTimestamp);

        dataHistoryRepository.save(dataHistory);
    }

    public void saveToHistoryDatabase(List<DataHistory> dataHistoryList) {
        dataHistoryRepository.saveAll(dataHistoryList);
    }

    public List<Data> getAllData() {
        return dataRepository.findAll();
    }

    public List<DataHistory> getAllDataHistory() {
        return dataHistoryRepository.findAll();
    }
}
