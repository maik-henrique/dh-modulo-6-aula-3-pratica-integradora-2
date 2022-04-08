package br.com.meli.tutorialsdh.service;

import br.com.meli.tutorialsdh.entity.Tutorial;
import br.com.meli.tutorialsdh.repository.TutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TutorialService {

    private final TutorialRepository testCaseRepository;

    public Tutorial save(Tutorial testCase) {
        return testCaseRepository.save(testCase);
    }

    public List<Tutorial> findAll() {
        return testCaseRepository.findAll();
    }

    public Tutorial findById(Long id) {
        return testCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("TestCase not found"));
    }

    public Tutorial update(Long id, Tutorial testCase) {
        Tutorial oldTestCase = findById(id);
        oldTestCase.setDescricao(testCase.getDescricao());
        oldTestCase.setTitulo(testCase.getTitulo());
        return testCaseRepository.save(oldTestCase);
    }

    public void deleteById(Long id) {
        testCaseRepository.deleteById(id);
    }

    public void deleteAll() {
        testCaseRepository.deleteAll();
    }

    public List<Tutorial> findByPublicacao(boolean publicacao) {
        return testCaseRepository.findTutorialBySituacao(publicacao);
    }

    public List<Tutorial> findByTitulo(String titulo) {
        return testCaseRepository.findTutorialByTitulo(titulo);
    }
}
