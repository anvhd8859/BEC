package com.example.JWTSecure.controller;

import com.example.JWTSecure.DTO.CurriculumDTO;
import com.example.JWTSecure.DTO.SearchResultDTO;
import com.example.JWTSecure.domain.Curriculum;
import com.example.JWTSecure.service.CurriculumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/curriculum")
@AllArgsConstructor
public class CurriculumController {
    private CurriculumService curriculumService;

    @PostMapping("/")
    public CurriculumDTO createCurriculum(@RequestBody Curriculum curr) throws Exception {
        if (curr.getId() != null) throw new Exception("Id of Curriculum must null");
        return curriculumService.save(curr);
    }

    @PutMapping("/")
    public CurriculumDTO updateCurriculum(@RequestBody Curriculum curr) throws Exception {
        if (curr.getId() == null) throw new Exception("Id of Curriculum must not null");
        return curriculumService.save(curr);
    }

    @GetMapping("/{id}")
    public SearchResultDTO<CurriculumDTO> findById(@PathVariable Long id) {
        return curriculumService.getCurriculum(id);
    }

    @GetMapping("/course/{courseId}/{page}")
    public SearchResultDTO<CurriculumDTO> findByCourseId(
            @PathVariable Long courseId, @PathVariable Integer page
    ) {
        return curriculumService.findByCourseId(courseId, page);
    }
}