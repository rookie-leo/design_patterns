# language: pt

@leilao
Funcionalidade: Cadastrando um novo leilao

 Cenario: Um usuario logado pode cadastrar um leilao
  Dado o usuario logado
  Quando acessa a pagina de novo leilao
  E preenche o formulario com dados validos
  Entao volta para a pagina de leiloes
  E o novo leilao aparece na tabela