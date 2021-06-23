package com.kosmo.k11springlegacy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import di.AnnotationBean;
import di.Circle;
import di.Persons;

@Controller
public class DIController {
	
	@RequestMapping("/di/mydi1.do")
	public ModelAndView mydi1(Model model) {
		ModelAndView mv = new ModelAndView();
		
		// XML설정파일의 위치 저장
		String configLocation = "classpath:my_di1.xml";
		// 설정파일을 통해 스프링 컨테이너 생성
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		// getBean()으로 Circle타입의 객체circle을 주입받음
		Circle circle = ctx.getBean("circle", Circle.class);
		//주입받은 객체를 Model에 저장하고 View를 설정
		mv.setViewName("04DI/mydi1");
		mv.addObject("circle", circle);
		
		return mv;
		
	}
	
	@RequestMapping("/di/mydi2.do")
	public ModelAndView mydi2(Model model) {
		ModelAndView mv = new ModelAndView();
		
		// XML설정파일을 기반으로 생성한 컨텍스트를 통해 빈을 주입받음
		String configLocation = "classpath:my_di2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		Persons person = ctx.getBean("person", Persons.class);
		
		// 뷰 경로에 대한 설정과 정보 저장
		mv.setViewName("04DI/mydi2");
		mv.addObject("person", person.getInfo());
		
		return mv;
	}
	
	
	// 어노테이션을 통한 빈 생성 및 주입받기
	@RequestMapping("/di/mydi3.do")
	public ModelAndView mydi3(Model model) {
		ModelAndView mv = new ModelAndView();
		
		// 어노테이션을 통해 생성된 빈을 받기 위한 컨텍스트 선언
		AnnotationConfigApplicationContext aCtx = new AnnotationConfigApplicationContext(AnnotationBean.class);
		
		// 빈 주입받기
		Circle circle1 = aCtx.getBean("circleBean", Circle.class);
		Persons person1 = aCtx.getBean("personBean" , Persons.class);
		
		mv.setViewName("04DI/mydi3");
		mv.addObject("person", person1.getInfo());
		mv.addObject("circle", circle1);
		
		return mv;
	}
	
	/*
	@RequestMapping("/di/myCalculator")
	public String myCal(Model model) {
	 
		String configLocation = "classpath:DIAppCtxCalculator.xml";
				 
		AbstractApplicationContext ctx = 
			new GenericXmlApplicationContext(configLocation);
				 
		calculator calculator = ctx.getBean("calculator", Calculator.class);
				 
		model.addAttribute("addResult", calculator.adder());
		model.addAttribute("subResult", calculator.sub());
		model.addAttribute("mulResult", calculator.multi());
		model.addAttribute("divResult", calculator.divide());
		
		return "04DI/myCalculator";
	}
	*/
}
