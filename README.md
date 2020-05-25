# API
API RESTful que possibilita a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

## Requisitos
Para execução do projeto, é necessário instalação do JDK 8.
O passo-a-passo abaixo foi feito com base no Eclipse.

## Execução do projeto
Não é necessário instalação. 
 - Incluir o arquivo movielist.csv com os dados no seguinte diretório *src/main/resources/* a fim de que a aplicação leia os dados no momento da primeira execução.
 - Importe o projeto como projeto Maven existente (foi utilizada a IDE Eclipse);
 - Atualize o projeto maven para que ele baixe as bibliotecas utilizadas.
 - Execute o projeto a partir da classe Aplication, como uma Aplicação Java.
 

## EndPoints
É possível verificar os EndPoints utilizando o Swagger. Basta ter a aplicação rodando e acessar: http://localhost:8080/api/swagger-ui.html#/

## Testes
Para executar os testes abra a classe AppTest.java, clique em Run -> Run As -> JUnit Test. Isso fará com que todos os testes de integração implementados sejam executados.
