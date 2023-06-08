package com.UserDemo.controller;

import com.UserDemo.model.Resource;
import com.UserDemo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    @GetMapping("/resources")
    public List<Resource> getAll(){
        return resourceService.getAll();
    }
    @GetMapping("/resources/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return resourceService.getById(id);
    }
    @PostMapping("/resources")
    public Resource create(@RequestBody Resource resource) {
        return resourceService.create(resource);
    }

    @PutMapping("/resources/{id}")
    public void update(@PathVariable Long id, @RequestBody Resource resource) {
        resourceService.update(id,resource);
    }

    @DeleteMapping("/resources/{id}")
    public void delete(@PathVariable Long id) {
        resourceService.delete(id);
    }
}

