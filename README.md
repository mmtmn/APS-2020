As Atividades Práticas Supervisionadas serão constituídas pelos seguintes tópicos:

1)	O grupo deverá desenvolver um sistema para gerenciamento da Univerdade “Amazônia”, responsável por pesquisar desenvolver artigos científicos e livros relacionados à ciência e ao meio ambiente.

2)	O grupo deverá usar a linguagem Java e um sistema de arquivos no formato CSV. Para fazer a interface deve ser desenvolvido um menu na “entrada padrão” do sistema.

3)	No banco de dados teremos três tipos de arquivos:
■	Um arquivo CSV com os dados dos alunos, na ordem “id;nome”
■	Um arquivo CSV com os dados dos cursos na ordem “nome;nível;ano”
■	Para cada curso, um arquivo com o nome “nome_nível_ano.csv”, com as informações das notas dos alunos naquele curso, na ordem “id_do_aluno;nota_NP1;nota_NP2;nota_reposicao;nota_exame”. Havendo a possibilidade de o arquivo não ter nenhum dado, representando o fato de que ninguém cursou aquela matéria naquele ano.
4)	É esperado que o sistema tenha um controle de erros para entradas do usuário final.

Para rodar o projeto:
git clone
javac Menu.java
javac Metodos.java
java Menu


