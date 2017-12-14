package com.igs.ipi.tpspringbootnutakor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootnutakor.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/new")
	public ModelAndView newGame() {
		ModelAndView mav  = new ModelAndView("game");
		System.out.println(gameService.toString());
        mav.addObject("game", gameService.newGame());
        
        return mav;
	}
}