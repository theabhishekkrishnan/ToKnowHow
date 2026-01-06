package com.toknowhow.education.service;

import com.toknowhow.education.model.Resource;
import com.toknowhow.education.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

        @Autowired
        private ResourceRepository resourceRepository;

        public List<Resource> getAllResources() {
                return resourceRepository.findAll();
        }

        public Resource saveResource(Resource resource) {
                return resourceRepository.save(resource);
        }

        public List<Resource> getResourcesByCategory(Long categoryId) {
                return resourceRepository.findByCategoryId(categoryId);
        }

        public Resource getResourceById(Long id) {
                return resourceRepository.findById(id).orElse(null);
        }

        public void deleteResource(Long id) {
                if (id != null) {
                        resourceRepository.deleteById(id);
                }
        }
}
