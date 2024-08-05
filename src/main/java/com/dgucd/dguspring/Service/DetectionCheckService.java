package com.dgucd.dguspring.Service;

import com.dgucd.dguspring.DTO.DetectionCheckRequestDTO;
import com.dgucd.dguspring.DTO.DetectionResponseDTO;
import com.dgucd.dguspring.Entity.DetectedObjects;
import com.dgucd.dguspring.Entity.User;
import com.dgucd.dguspring.Repository.DetectionCheckTrueRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetectionCheckService {
    @Autowired
    private final DetectionCheckTrueRepository detectionCheckTrueRepository;

    public void updateDetectionCheck(Integer ObjId){
        DetectedObjects detectedObjects = detectionCheckTrueRepository.findById(ObjId).orElseThrow(() -> new RuntimeException("Not found"));
        detectedObjects.setDetectionCheck(true);
        detectionCheckTrueRepository.save(detectedObjects);
        }
    public List<DetectedObjects> findAll(){
        return detectionCheckTrueRepository.findAll();
    }
}
