package com.springboot.porto.demoporto;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ProjectService {
    public record Project(
        String title, 
        String subtitle, 
        String imageUrl, 
        String description,
        boolean isPortrait
    ) {}
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    public List<Project> loadProjects() {
        try {
            InputStream inputStream = new ClassPathResource("Data.json").getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<List<Project>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
