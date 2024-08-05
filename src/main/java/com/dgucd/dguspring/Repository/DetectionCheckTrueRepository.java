package com.dgucd.dguspring.Repository;

import com.dgucd.dguspring.Entity.DetectedObjects;
import com.dgucd.dguspring.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetectionCheckTrueRepository extends JpaRepository<DetectedObjects, Integer> {

}
