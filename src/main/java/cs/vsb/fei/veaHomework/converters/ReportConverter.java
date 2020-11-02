package cs.vsb.fei.veaHomework.converters;

import org.springframework.core.convert.converter.Converter;
import cs.vsb.fei.veaHomework.entities.Report;

public class ReportConverter implements Converter<Report, String> {

	
	@Override
	public String convert(Report source) {
		if(source == null) {
			return "null";
		}
		
		return Long.toString(source.getId());
	}
	
	
}
