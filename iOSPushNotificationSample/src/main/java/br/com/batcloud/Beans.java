package br.com.batcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.relayrides.pushy.apns.ApnsClient;
import com.relayrides.pushy.apns.ApnsClientBuilder;

import io.netty.util.concurrent.Future;

@Configuration
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
}
