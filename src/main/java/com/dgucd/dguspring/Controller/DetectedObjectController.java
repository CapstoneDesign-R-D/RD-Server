package com.dgucd.dguspring.Controller;

import com.dgucd.dguspring.DTO.DetectionResponseDTO;
import com.dgucd.dguspring.DTO.ErrorResponseDTO;
import com.dgucd.dguspring.DTO.RegisterResponseDTO;
import com.dgucd.dguspring.Entity.DetectedObjects;
import com.dgucd.dguspring.Repository.DetectionRepository;
import com.dgucd.dguspring.Service.DetectionCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Tag(name="detectedObject-controller", description = "Detected Object Controller")
public class DetectedObjectController {

    private final DetectionRepository detectionRepository;
    @Autowired
    private DetectionCheckService detectionCheckService;

    @GetMapping("api/object/check")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = DetectionResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Server Error",content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))})
    @Operation(summary = "객체 인식 조회",description = "객체 인식 조회 api")
    public List<DetectionResponseDTO> getDetectedObjects(){
        List<DetectedObjects> detectedObjects = detectionRepository.findAll();
        return detectedObjects.stream()
                .map(DetectionResponseDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("api/object/{ObjId}/detectioncheck/update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error",content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))})
    @Operation(summary = "DetectionCheck update",description = "true로 값 바꾸기")
    public ResponseEntity<?> updateDetectionCheck(@RequestParam(value = "ObjId") Integer ObjId){
        detectionCheckService.updateDetectionCheck(ObjId);
        return ResponseEntity.ok().build();
    }

}
