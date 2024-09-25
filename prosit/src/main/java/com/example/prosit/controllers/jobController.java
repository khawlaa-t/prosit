package com.example.prosit.controllers;

import com.example.prosit.entities.job;
import com.example.prosit.repositories.Jobrepository;
import com.example.prosit.services.IJob;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class jobController {
    IJob iJob;
    Jobrepository jobrepository;
    @PostMapping("/addJob")
    public job addJob(@RequestBody job job){

        return  iJob.addJob(job);
    }
    @GetMapping("/Job/{id}")
    public job getJob(@PathVariable long id){
        return iJob.getJob(id);
    }
    @GetMapping("/service/{service}")
    public job getJobByService(@PathVariable("service") String service) {
        return jobrepository.findByService(service)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with service: " + service));
    }

    @GetMapping("/jobs")
    public List<job> getAllJobs() {
        return iJob.getAllJobs();
    }

    @PutMapping("/{id}")
    public ResponseEntity<job> updateJobStatus(@PathVariable Integer id, @RequestBody job jobDetails) {
        Optional<job> optionalJob = jobrepository.findById(id);
        if (optionalJob.isPresent()) {
            job job = optionalJob.get();
            job.setEtat(jobDetails.getEtat());
            return ResponseEntity.ok(jobrepository.save(job));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
