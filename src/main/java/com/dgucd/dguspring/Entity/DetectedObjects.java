package com.dgucd.dguspring.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@Builder
public class DetectedObjects {
    @Id
    @Column(name = "ObjId")
    private int ObjId;
    @Column(name = "DetectedClass")
    private String DetectedClass;
    @Column(name = "Location")
    private String Location;
    @Column(name = "DetectedDate")
    private LocalDateTime DetectedDate;
    @Column(name = "DetectionCheck")
    private boolean DetectionCheck;

    @Builder
    public DetectedObjects(int ObjId, String DetectedClass, String Location, LocalDateTime DetectedDate, boolean DetectionCheck){
        this.ObjId=ObjId;
        this.DetectedClass=DetectedClass;
        this.Location=Location;
        this.DetectedDate =DetectedDate;
        this.DetectionCheck = DetectionCheck;
    }

    protected DetectedObjects(){

    }

}
