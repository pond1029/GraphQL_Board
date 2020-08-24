package com.pond.graph_ql.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BoardController {
		
	@ResponseBody
	@RequestMapping(path="/board.do", produces="text/plain; charset=UTF-8")
	public ModelAndView tft(@RequestParam Map<String, Object> paramMap) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView("/board");	
		return modelAndView;
	}
	
}
