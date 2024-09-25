package com.example.prosit.repositories;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prosit.entities.job;

import java.util.Optional;

public interface Jobrepository extends JpaRepository <job , Long> {
    Optional<job> findById(Integer id);
    Optional<job> findByService(String service);

}
