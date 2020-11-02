package cs.vsb.fei.veaHomework.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cs.vsb.fei.veaHomework.businessLogic.ReportService;
import cs.vsb.fei.veaHomework.entities.Report;

@Component
public class ReportConverter2 implements Converter<String, Report> {
	
	@Autowired
	private ReportService reportService;
	
	@Override
	public Report convert(String source) {
		if(source == null) {
			return null;
		}
		
		try {
			return reportService.find(Long.parseLong(source));
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	
}
