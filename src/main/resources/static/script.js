// Função para obter dados JSON de uma URL usando a API Fetch
function getJson(url) {
  return fetch(url).then(response => {
    if (!response.ok) {
      throw new Error(`Erro: ${response.status}`);
    }
    return response.json();
  });
}

// Função principal para carregar dados no DOM
function carregarDados() {
  // Obtém a promessa para os dados da URL especificada
  const promise = getJson('http://localhost:8080/dados');

  // Manipula os dados quando a promessa é resolvida
  promise.then(function (dados) {
    // Atualiza elementos HTML com os dados obtidos
    document.getElementById('nome').textContent = dados.nome;
    document.getElementById('telefone').textContent = dados.telefone;
    document.getElementById('email').textContent = dados.email;
    document.getElementById('dataNascimento').textContent = dados.dataNascimento;

    // Atualiza links para redes sociais
    const aLinkedIn = document.getElementById('linkedin');
    aLinkedIn.href = dados.linkedin;
    aLinkedIn.textContent = 'LinkedIn';

    const aGitHub = document.getElementById('github');
    aGitHub.href = dados.github;
    aGitHub.textContent = 'GitHub';

    // Atualiza seção de experiência profissional
    const expProfH3 = document.getElementById('expprof').querySelector('h3');
    const expProfUl = document.getElementById('expprof').querySelector('ul');
    expProfH3.textContent = 'Experiência Profissional';

    dados.experienciaProfissional.forEach(exp => {
      const li = document.createElement('li');
      li.innerHTML = `<h4>${exp.empresa}</h4><p>${exp.cargo}</p><p>${exp.periodo}</p>`;
      expProfUl.appendChild(li);
    });

    // Atualiza seção de formação acadêmica
    const formAcadH3 = document.getElementById('formacad').querySelector('h3');
    const formAcadUl = document.getElementById('formacad').querySelector('ul');
    formAcadH3.textContent = 'Formação Acadêmica';

    dados.formacaoAcademica.forEach(form => {
      const li = document.createElement('li');
      li.innerHTML = `<h4>${form.curso}</h4><p>${form.instituicao}</p><p><a href="${form.link}" target="_blank">Certificado</a></p>`;
      formAcadUl.appendChild(li);
    });

    // Atualiza seção de idiomas
    const idiomasH3 = document.getElementById('idiomas').querySelector('h3');
    const idiomasTable = document.getElementById('idiomas').querySelector('table tbody');
    idiomasH3.textContent = 'Idiomas';

    dados.idiomas.forEach(idioma => {
      const tr = document.createElement('tr');
      tr.innerHTML = `<th>${idioma.idioma}</th><td>${idioma.leitura}</td><td>${idioma.escrita}</td><td>${idioma.conversacao}</td>`;
      idiomasTable.appendChild(tr);
    });

    // Atualiza seção de conhecimentos
    const conhecimentosH3 = document.getElementById('conhecimentos').querySelector('h3');
    const conhecimentosUl = document.getElementById('conhecimentos').querySelector('ul');
    conhecimentosH3.textContent = 'Conhecimentos';

    dados.conhecimentos.forEach(conhecimento => {
      const li = document.createElement('li');
      li.textContent = conhecimento;
      conhecimentosUl.appendChild(li);
    });
  }).catch(function (err) {
    // Manipula erros exibindo um alerta
    alert(`Erro: ${err.message}`);
  });
}

// Função para carregar seguidores (a implementação real está ausente)
function carregarSeguidores() {
  // Sua implementação para carregarSeguidores vai aqui
  console.log('Função carregarSeguidores chamada');
}

// Aguarda o carregamento completo do DOM antes de chamar as funções
document.addEventListener('DOMContentLoaded', function () {
  carregarDados();

  // Assumindo que carregarSeguidores está definida em outro lugar
  carregarSeguidores();
});
