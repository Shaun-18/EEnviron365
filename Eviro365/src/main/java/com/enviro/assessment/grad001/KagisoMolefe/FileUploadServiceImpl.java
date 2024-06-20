package com.enviro.assessment.grad001.KagisoMolefe;


import com.enviro.assessment.grad001.KagisoMolefe.model.EnvironmentalData;
import com.enviro.assessment.grad001.KagisoMolefe.repository.EnvironmentalDataRepository;
import com.enviro.assessment.grad001.KagisoMolefe.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private EnvironmentalDataRepository repository;

    @Override
    public void uploadFile(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String content = reader.lines().collect(Collectors.joining("\n"));
            EnvironmentalData data = new EnvironmentalData();
            data.setData(content);
            repository.save(data);
        } catch (Exception e) {
            throw new RuntimeException("Error processing file", e);
        }
    }
}
