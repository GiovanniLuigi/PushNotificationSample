package br.com.batcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.relayrides.pushy.apns.ApnsClient;
import com.relayrides.pushy.apns.ApnsClientBuilder;

import io.netty.util.concurrent.Future;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Beans {
	
	@Value("${cert.filename}")
	private String certFileName;
	
	@Value("${cert.pass}")
	private String certPass;
	
	@Bean
	public ApnsClient apnsClient() throws Exception {
		
		final ApnsClient apnsClient = new ApnsClientBuilder()
		        .setClientCredentials(new ClassPathResource(certFileName).getFile(), certPass)
		        .build();		
		
		final Future<Void> connectFuture = apnsClient.connect(ApnsClient.DEVELOPMENT_APNS_HOST);
		connectFuture.await();
		return apnsClient;
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        		
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}
