package br.com.meli.tutorialsdh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialRequest {
    private String titulo;
    private String descricao;
    private boolean situacao;

}
