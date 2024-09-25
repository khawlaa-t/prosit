package com.example.prosit.services;

import com.example.prosit.entities.job;
import com.example.prosit.repositories.Jobrepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor

public class JobImpl implements IJob{
    Jobrepository jobrepository;
    @Override
    public job addJob(job job) {
        return jobrepository.save(job);
    }
    @Override
    public job getJob(Long id) {
        return jobrepository.findById(id).orElse(null);
    }
    @Override
    public job getJobByService(String service) {
        return jobrepository.findByService(service).orElse(null);
    }
    @Override
    public List<job> getAllJobs() { return
            jobrepository.findAll();
    }
    @Override
    public job updateJob(job job) {
        return jobrepository.save(job);
    }



}
