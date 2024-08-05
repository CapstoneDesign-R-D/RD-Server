package com.dgucd.dguspring.DTO;

import com.dgucd.dguspring.Entity.DetectedObjects;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetectionResponseDTO {
    private int ObjId;
    private String DetectedClass;
    private String Location;
    private LocalTime DetectedTime;
    private boolean DetectionCheck;
    private String DetectedDate;

    public String LocToTable(String Location){
        if (Location.contains("[")==true){
            String coordinates = Location.replace("[", "").replace("]", "");

            String[] values = coordinates.split(",");
            int x = Integer.parseInt(values[0].trim());
            int y = Integer.parseInt(values[1].trim());
            int z = Integer.parseInt(values[2].trim());

            int tableNumber = (x/10)+1;
            if (tableNumber<0){
                return Location;
            }
            return "Table " + tableNumber;
        }
        else return Location;
    }

    public DetectionResponseDTO(DetectedObjects detectedObjects) {
        this.ObjId=detectedObjects.getObjId();
        this.DetectedClass=detectedObjects.getDetectedClass();
        this.Location=LocToTable(detectedObjects.getLocation());
        this.DetectionCheck=detectedObjects.isDetectionCheck();
        this.DetectedTime=detectedObjects.getDetectedDate().toLocalTime();
        this.DetectedDate=(detectedObjects.getDetectedDate().toLocalDate()).toString()+" "+(detectedObjects.getDetectedDate().getDayOfWeek()).toString();
    }
}
