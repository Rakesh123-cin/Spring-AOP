package com.rakesh.SpringRestProject.controller;

import com.rakesh.SpringRestProject.model.JobPost;
import com.rakesh.SpringRestProject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping(path="/jobposts", produces = {"application/json"})
    //@ResponseBody
    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }
    @GetMapping("/jobpost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId)
    {
        return service.getJob(postId);
    }
    @PostMapping(path="/jobpost", consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @PutMapping("/jobpost")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @DeleteMapping("/jobpost/{postId}")
    public void deleteJob(@PathVariable("postId") int postId)
    {
        service.deleteJob(postId);
    }

    @GetMapping("/load")
    public void loadData()
    {
        service.loadData();
    }
}
