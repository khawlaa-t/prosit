package com.example.prosit.services;

import com.example.prosit.entities.job;

import java.util.List;
import java.util.Optional;

public interface IJob {


    job addJob(job job);



    job getJob(Long id);



    job getJobByService(String service);

    List<job> getAllJobs();

    job updateJob(job job);


}
