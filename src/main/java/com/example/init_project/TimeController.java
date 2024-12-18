package com.example.init_project;

import com.example.init_project.model.TimeEntry;
import com.example.init_project.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TimeController {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    @GetMapping("/time")
    public Map<String, String> getSystemTime() {
        Map<String, String> response = new HashMap<>();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        response.put("systemTime", date.format(now));

        TimeEntry timeEntry = new TimeEntry(date.format(now));
        timeEntryRepository.save(timeEntry);

        return response;
    }
}
