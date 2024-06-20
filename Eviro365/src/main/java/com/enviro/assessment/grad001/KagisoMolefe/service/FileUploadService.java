package com.enviro.assessment.grad001.KagisoMolefe.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    void uploadFile(MultipartFile file);
}
