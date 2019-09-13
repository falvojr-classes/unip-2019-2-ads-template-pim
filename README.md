# Template PIM

Bibliotecas e Frameworks: Spring, REST, Swagger, JPA, Hibernate, MySQL.

## Importacão

No IDE eclipe, após baixar e extrair o projeto, siga os seguintes passos:

***File => Import... => Gradle / Existing Gradle project***

Após selecionar o projeto e concluir o processo de importacão, o Gradle irá baixar todas as dependências do projeto. Esse procedimento pode demorar um pouco.

## Execucão

Para executar o projeto, primeiro certifique-se de que as configuracões de Banco de Dados e porta estão configuradas corretamente no *application.properties*, por exemplo:

```
# Configuracoes de Banco de Dados
spring.datasource.url=jdbc:mysql://db4free.net:3306/pim_frotas?useSSL=false
spring.datasource.username=falvojr
spring.datasource.password=12345678

# Configuracoes do JPA/Hibernate
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
```

Com isso, basta executar a classe ***Application.java*** da seguinte forma: 

***Botão Direito => Run As... => Java Application***

## Testes

Antes de iniciar os testes, certifique-se de que a API está rodando corretamente. Para isso, analise o log na aba *Console* do seu eclipse. Nele, não deve haver nenhuma excecão e uma das ultimas linhas deve indicar que ela está pronta para uso: *Tomcat started on port(s): 8080 (http)*.

Com isso, basta acessar a URL do Swagger que contém a documentacão da API: http://localhost:8080/swagger-ui.html (considere a porta configurada no *application.properties*).


#### Nota
Lembre-se que os endpoints da API são protegidos via Basic Authentication. Com isso, você deve se autenticar com um usuário válido (cadastrado em sua respectiva tabela no Banco de Dados).
