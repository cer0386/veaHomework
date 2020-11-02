package cs.vsb.fei.veaHomework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cs.vsb.fei.veaHomework.businessLogic.ReportService;
import cs.vsb.fei.veaHomework.entities.Report;

@Controller
public class FirstController {

	private static int counter = 0;
	
	public FirstController() {
		counter++;
	}
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("FirstController "+ counter);
		model.addAttribute("report", new Report());
		return "index";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute @Validated Report report, BindingResult reportResult) {
		if(reportResult.hasErrors()) {
			System.out.println(reportResult.getAllErrors());
		}
		System.out.println("First controller "+ counter);
		reportService.saveReport(report);
		return "index";
	}
	
	
	
	@ModelAttribute("reports")
	public List<Report> getAllPersons(){
		//mojeTestovaciMetoda();
		return reportService.getAll();
	}
	
	@PostMapping("/selectReport")
	public String selectPeson(Report report) {
		System.out.println(report);
		return "index";
	}
}
