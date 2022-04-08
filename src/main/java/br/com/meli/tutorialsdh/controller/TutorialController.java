package br.com.meli.tutorialsdh.controller;

import br.com.meli.tutorialsdh.dto.TutorialRequest;
import br.com.meli.tutorialsdh.entity.Tutorial;
import br.com.meli.tutorialsdh.service.TutorialService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
@AllArgsConstructor
public class TutorialController {

    private final TutorialService testCaseService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TutorialRequest testcaseRequest) {
        Tutorial testCase = modelMapper.map(testcaseRequest, Tutorial.class);
        Tutorial savedTestCase = testCaseService.save(testCase);
        return ResponseEntity.created(URI.create("/" + savedTestCase.getId())).body(savedTestCase);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Tutorial> testCases = testCaseService.findAll();
        return ResponseEntity.ok(testCases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Tutorial testCase = testCaseService.findById(id);
        return ResponseEntity.ok(testCase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TutorialRequest testcaseRequest) {
        Tutorial testCase = modelMapper.map(testcaseRequest, Tutorial.class);
        Tutorial updatedTestCase = testCaseService.update(id, testCase);
        return ResponseEntity.ok(updatedTestCase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        testCaseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        testCaseService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> findByTitulo(@RequestParam String title) {
        List<Tutorial> tutoriais = testCaseService.findByTitulo(title);
        return ResponseEntity.ok(tutoriais);
    }

    @GetMapping("/published")
    public ResponseEntity<?> findByPublished() {
        List<Tutorial> publicacoes = testCaseService.findByPublicacao(true);
        return ResponseEntity.ok(publicacoes);
    }

}
