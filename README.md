# Matera

## Projeto Java + Cucumber

Este é o projeto de Testes de API automatizado.

##  Requisitos
- Java 17+ JDK deve estar instalado
- Cucumber
- RestAssured
 
## Como executar a aplicação 

Abra o projeto no Eclipse IDE. Após instalar as dependências, rode como (Run as) JUnit. 


## Casos de Testes

O arquivo "src/test/resources/features/breeds.feature" possui todos os cenários descritos em linguagem Gherkin. Abaixo a lista de cenários:

1. Successful Listing 
2. Invalid URL 
3. Invalid Token 


## Observação

O caso de teste número 3 "Invalid Token" executa com falha pois o retorno da api está divergente do comportamento esperado. A api retorna status code 200 enquanto o comportamento esperado é status code 401.
