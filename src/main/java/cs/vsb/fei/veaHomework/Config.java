package cs.vsb.fei.veaHomework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cs.vsb.fei.veaHomework.converters.ReportConverter;
import cs.vsb.fei.veaHomework.converters.ReportConverter2;


@Configuration
public class Config implements WebMvcConfigurer{
	
	@Autowired
	private ReportConverter2 reportConverter2;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(reportConverter2);
		registry.addConverter(new ReportConverter());
	}
	
}
