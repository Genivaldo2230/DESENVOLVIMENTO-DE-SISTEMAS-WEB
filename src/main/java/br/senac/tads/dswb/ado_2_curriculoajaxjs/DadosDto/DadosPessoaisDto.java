package br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto;

import br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto.ExperienciaProfissionalDtos;
import br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto.FormacaoAcademicaDtos;
import br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto.Idioma;
import lombok.Data;

import java.util.List;
@Data
public class DadosPessoaisDto {

    private String nome;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String linkedin;
    private String github;
    private List<ExperienciaProfissionalDtos> experienciaProfissional;
    private List<String> conhecimentos;
    private List<FormacaoAcademicaDtos> formacaoAcademica;
    private List<Idioma> idiomas;

}
