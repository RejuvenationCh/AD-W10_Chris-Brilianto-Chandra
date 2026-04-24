package com.springboot.porto.demoporto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StatusController {
    private final ProjectService projectService;
    public StatusController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @GetMapping("/")
    public String index() {
        return "HomePage"; 
    }
    
    @GetMapping("/portfolio")
    public String showPortfolio(Model model) {
        model.addAttribute("daftarProyek", projectService.loadProjects());
        return "MainPage";
    }

}



