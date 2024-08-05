package com.dgucd.dguspring.Repository;

import com.dgucd.dguspring.Entity.DetectedObjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectionRepository extends JpaRepository<DetectedObjects, Integer> {
}
