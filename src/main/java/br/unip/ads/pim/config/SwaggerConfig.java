package br.unip.ads.pim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final String TAG_LOGIN = "Login";
	public static final String TAG_OCORRENCIA = "Ocorrências";
	public static final String TAG_USUARIO = "Usuários";
	public static final String TAG_VEICULO = "Veículos";

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("br.unip.ads.pim.controller"))              
          .build()
          .apiInfo(apiInfo())
          .tags(new Tag(TAG_LOGIN, "Recursos relacionados ao domínio de Login"),
                  new Tag(TAG_OCORRENCIA, "Recursos relacionados ao domínio de Ocorrências"),
                  new Tag(TAG_USUARIO, "Recursos relacionados ao domínio de Usuários"),
                  new Tag(TAG_VEICULO, "Recursos relacionados ao domínio de Veículos"));                                           
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("API RESTful do PIM")
        		.version("1.0.0").build();
    }
}

