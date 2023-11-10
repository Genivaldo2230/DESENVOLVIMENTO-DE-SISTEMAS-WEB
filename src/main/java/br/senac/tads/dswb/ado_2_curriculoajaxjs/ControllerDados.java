package br.senac.tads.dswb.ado_2_curriculoajaxjs;



import br.senac.tads.dswb.ado_2_curriculoajaxjs.DadosDto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;




@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ControllerDados {

    @GetMapping("/dados")
    public DadosPessoaisDtos obterDadosPessoais() {
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

        // Existing code...

        List<FormacaoAcademicaDtos> formacaoAcademica = new ArrayList<>();

        FormacaoAcademicaDtos formacao1 = new FormacaoAcademicaDtos();
        formacao1.setCurso("Programador Front-end: Introdução");
        formacao1.setInstituicao("DevMedia");
        formacao1.setLink("https://www.devmedia.com.br/cursos/certificado/novo_certificado.php?id=114298"); // You can set this to null or leave it if you want to keep it null

        FormacaoAcademicaDtos formacao2 = new FormacaoAcademicaDtos();
        formacao2.setCurso("HTML: Fundamentos do HTML");
        formacao2.setInstituicao("DevMedia");
        formacao2.setLink("https://www.devmedia.com.br/certificado/tecnologia/html/genivaldo-alves");

        formacaoAcademica.add(formacao1);
        formacaoAcademica.add(formacao2);

        dados.setFormacaoAcademica(formacaoAcademica);

// Existing code...


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
    @RequestMapping("/minhaPagina")
    public class MinhaPaginaController {

        @GetMapping
        public ModelAndView pagina() {
            ModelAndView mv = new ModelAndView();
            mv.addObject("dados", obterDadosPessoais());
            mv.setViewName("Dados");
            return mv;
        }
    }
}
