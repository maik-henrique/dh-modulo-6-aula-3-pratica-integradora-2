package br.com.meli.tutorialsdh.repository;

import br.com.meli.tutorialsdh.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findTutorialByTitulo(String titulo);
    List<Tutorial> findTutorialBySituacao(boolean publicacao);
}
