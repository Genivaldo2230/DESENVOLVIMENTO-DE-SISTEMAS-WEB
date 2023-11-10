package br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto;

import lombok.Data;

import java.util.List;

@Data
public class DadosPessoaisDtos {
    private String nome;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String linkedin;
    private String github;
    private List<ExperienciaProfissionalDtos> experienciaProfissional;
    private List<String> conhecimentos;
    private List<FormacaoAcademicaDtos> formacaoAcademica;
    private List<Idiomas> idiomas;
}
