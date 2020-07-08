# Docker-Containers
 Repositório versionado Git e GitHub

containerempresa
decricao do projeto: Esse projeto contém 2 conteiners de microserviço maven empresa e cliente utilizando JDK8.
2 springboot conteinerzados
1 - springboot vai ter uma base de clientes, Salvar em uma base H2
2 - Springboot vai ter um outro h2
Empresa com FK logica com o id da pessoa
Consultar a pessoa da empresa retornando em json pelo ID

Para executar o projeto, será necessário instalar os seguintes programas:
JDK8
Maven 3.6.3: necessario para realizar o build do projeto Spring Boot
Spring Boot com as configurações abaixo: 
Spring Boot DevTools, Spring Data JPA, H2 Database, OpenFeign, Spring Web, Spring Web Services, Ribbon[Maintenance].
Desenvolvimento:
Para iniciar o desenvolvimento, é nescessario criar um repositorio no GitHub.

Docker:
criar dois containers, 1 microservice container para empresa e 1 microservice contairner para cliente. 

Construção (Build):
Para construir o projeto com o Maven, executar os comandos abaixo:
mvn clean install
O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos
construídos, o que incluem o arquivo .jar do projeto.

Features:
