package br.senac.tads.dswb.ado_2_curriculoajaxjs;


import br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto.DadosPessoaisDtos;
import br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto.ExperienciaProfissionalDtos;
import br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto.FormacaoAcademicaDtos;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto.Idiomas;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ControllerDados {

    //http://127.0.0.1:8080/dados

    @GetMapping("/dados")
    public DadosPessoaisDtos obterDadosPessoais(){

        DadosPessoaisDtos dados = new DadosPessoaisDtos();

        dados.setNome("Genivaldo Alves dos Anjos");
        dados.setTelefone("(11) 9 6092-0552");
        dados.setEmail("gda_anjos@hotmail.com.br");
        dados.setLinkedin("https://linkedin.com/genivaldo-alves-anjos");
        dados.setGithub("https://github.com/Genivaldo2230");
        dados.setDataNascimento("08-Março-1977");

        List<ExperienciaProfissionalDtos> experienciaProfissional = new ArrayList<>();

        ExperienciaProfissionalDtos experiencia = new ExperienciaProfissionalDtos();
        experiencia.setEmpresa("viação Pirajussara");
        experiencia.setCargo("Motorista Urbano");
        experiencia.setPeriodo("2023 Atualmente");
        experienciaProfissional.add(experiencia);
        dados.setExperienciaProfissional(experienciaProfissional);

        List<String> conhecimentos = new ArrayList<>();

        conhecimentos.add("Java");
        conhecimentos.add("Html");
        conhecimentos.add("Css");
        conhecimentos.add("Bootstrap");
        conhecimentos.add("JavaScript");
        dados.setConhecimentos(conhecimentos);

        List<FormacaoAcademicaDtos> formacaoAcademica = new ArrayList<>();
        FormacaoAcademicaDtos formacao1 = new FormacaoAcademicaDtos();
        FormacaoAcademicaDtos formacao2 = new FormacaoAcademicaDtos();
        formacao1.setCurso("Html Css javaScript");
        formacao1.setInstituicao("DevMedia");
        formacao2.setCurso("Aws Cloud foundation");
        formacao2.setInstituicao("Amazon");
        formacao2.setLink("#");

        formacaoAcademica.add(formacao1);
        formacaoAcademica.add(formacao2);

        dados.setFormacaoAcademica(formacaoAcademica);

        List<Idiomas> idiomas = new ArrayList<>();

        Idiomas idioma1 = new Idiomas();
        Idiomas idioma2 = new Idiomas();
        Idiomas idioma3 = new Idiomas();

        idioma1.setIdioma("Inglês");
        idioma1.setLeitura("Médio");
        idioma1.setEscrita("Médio");
        idioma1.setConversacao("Médio");
        idioma2.setIdioma("Espanhol");
        idioma2.setLeitura("Médio");
        idioma2.setEscrita("Médio");
        idioma2.setConversacao("Médio");
        idioma3.setIdioma("chinês");
        idioma3.setLeitura("ruim");
        idioma3.setEscrita("ruim");
        idioma3.setConversacao("ruim");


        idiomas.add(idioma1);
        idiomas.add(idioma2);
        idiomas.add(idioma3);


        dados.setIdiomas(idiomas);

        return dados;
    }
    @Controller
    public class MinhaPaginaController {

        @GetMapping("/minhaPagina")
        public ModelAndView pagina(Model model) {
            ModelAndView mv = new ModelAndView();
            model.addText("dados"); // Adicione os dados ao model

            mv.setViewName("Dados");
            return mv;
        }

    }


}
