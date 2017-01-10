package br.com.finance.controll.backend.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import br.com.finance.controll.backend.configuration.SgaConfiguration;

public class WebAppInitializer implements ApplicationContextInitializer<AnnotationConfigWebApplicationContext> {

	public void initialize(AnnotationConfigWebApplicationContext context) {
		context.setDisplayName("fincance_controll");
		context.register(SgaConfiguration.class);
	}

}
