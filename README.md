**Meu Projeto Agenda de Oportunidades**

Esse projeto foi feito com muito carinho, pensando no meu pai, que é pastor da igreja onde frequento. Ele sempre usou uma agenda física para anotar o que cada pessoa fez nos cultos,
quem pregou, quem dirigiu, quem louvou, quem teve uma oportunidade de saudação e etc. A ideia do meu projeto surgiu de uma situação bem simples, mas que, na hora, me fez pensar:
Como posso facilitar a vida dele?

Durante um culto, enquanto ele estava anotando as atividades na agenda, eu pensei: Por que não criar um sistema onde ele possa cadastrar tudo isso digitalmente?
Ele poderia salvar os dados de forma prática, fazer buscas rápidas e, no próximo culto, facilmente ver quem já participou e quem ainda não teve uma oportunidade.

Eu estava na reta final do meu aprendizado em Java e, na hora, comecei a pensar em como poderia construir esse sistema. 
Então, fui para casa, comecei a estudar, programar e, com o tempo, finalizei essa aplicação.

O objetivo do meu projeto é simples: substituir a agenda física do meu pai por um sistema digital. Com isso, ele consegue registrar os nomes das pessoas, o tipo de oportunidade
que elas tiveram na igreja (se pregou, se dirigiu, se louvou) e a data do culto. Ele pode buscar pelo nome de qualquer pessoa e encontrar facilmente a data e a atividade
que a pessoa realizou no culto. Assim, ele não precisa mais ficar procurando nas anotações, basta digitar o nome da pessoa e encontrar tudo o que precisa.

Esse sistema facilita muito o trabalho dele, já que ele pode dar oportunidade para mais pessoas de forma organizada, sem perder tempo buscando nas anotações. 
No fundo, foi a minha forma de ajudar meu pai, usando o que eu aprendi em programação.

Eu sei que ainda é um projeto simples, mas ele já serve para o propósito e ajuda bastante no dia a dia da igreja. E, claro, para mim, foi uma grande oportunidade 
de praticar o que aprendi em Spring Boot, Java e JPA, e também de aplicar a tecnologia para resolver um problema real que estava ao meu redor.


🚀 **Tecnologias utilizadas**

Java 17+
Spring Boot (principal framework)
Spring Data JPA 
HTML / CSS / JavaScript (para a interface)


🖥️ **Sobre o projeto**

Esse sistema permite:
Cadastrar membros da igreja com nome, tipo de oportunidade e data do culto.

Buscar pessoas por nome com uma pesquisa simples.
Listar todos os membros cadastrados e ver as informações diretamente na tabela da interface.


📷 **Interface do sistema**

Aqui está a parte visual do projeto: https://github.com/Samuel-Silva-adm/ProjetoSpringBootIgreja/blob/main/InterfaceVisualCadastro.png



🖥️ **Como funciona**

A classe PessoaController gerencia a parte de comunicação com a interface. Ela recebe as requisições POST para cadastrar pessoas, GET para listar todas e GET para buscar
pessoas pelo nome.

A classe Pessoa é o modelo que mapeia os dados de cada membro, como nome, tipo de oportunidade e data do culto. Ela usa o JPA para salvar esses dados no banco de dados.

A PessoaRepository é responsável por interagir diretamente com o banco de dados para salvar e buscar os dados dos membros.

O front-end é bem simples, mas funcional. Ele tem um formulário para cadastrar membros e uma tabela para exibir todos os cadastrados.
Você também pode buscar membros por nome, tudo isso sendo atualizado dinamicamente através do uso de JavaScript com fetch.
