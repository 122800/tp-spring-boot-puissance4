package com.igs.ipi.tpspringbootnutakor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@GetMapping("/new")
	public ModelAndView newGame() {
		ModelAndView mav  = new ModelAndView();
        mav.addObject("title", "Sample title").addObject("body", "Sample body");
        mav.setViewName("game");
        return mav;
	}
}