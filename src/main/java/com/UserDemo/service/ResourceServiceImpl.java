package com.UserDemo.service;

import com.UserDemo.model.Resource;
import com.UserDemo.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
    @Service
    public class ResourceServiceImpl implements ResourceService{
        @Autowired
        private ResourceRepository resourceRepository;

        @Override
        public List<Resource> getAll() {
            List<Resource> resources = new ArrayList<>();
            resourceRepository.findAll().forEach(resources::add);
            return resources;
        }

        @Override
        public ResponseEntity<Object> getById(Long id) {
            if(resourceRepository.findById(id).isPresent()){
                return new ResponseEntity<>(resourceRepository.findById(id).get(), HttpStatus.OK);
            }
            else if(resourceRepository.findById(id).isEmpty()){
                return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
            }
            return null;
        }

        @Override
        public Resource create(Resource resource) {
            return resourceRepository.save(resource);
        }

        @Override
        public void update(Long id, Resource resource) {
            resourceRepository.save(resource);
        }

        @Override
        public void delete(Long id) {
            resourceRepository.deleteById(id);
        }
    }
