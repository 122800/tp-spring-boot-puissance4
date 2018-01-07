package com.igs.ipi.tpspringbootnutakor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootnutakor.model.Game;
import com.igs.ipi.tpspringbootnutakor.model.Player;
import com.igs.ipi.tpspringbootnutakor.service.GameService;
import com.igs.ipi.tpspringbootnutakor.service.PlayerService;

@Controller
@RequestMapping("game")
public class GameController {
	
	@Autowired private GameService gameService;
	@Autowired private PlayerService playerService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@GetMapping("/new")
	public ModelAndView newGame() {
		
		ModelAndView mav = new ModelAndView("game");
		
		Player p1 = playerService.findById(1);
		Player p2 = playerService.findById(2);
		
		Game game = gameService.newGame(p1, p2, null, null);
		
        mav.addObject("player1", p1)
        .addObject("player2", p1);
        
        return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView globalExceptionHandler(Exception e) {
	    ModelAndView modelAndView = new ModelAndView("error");
	    e.printStackTrace();
	    modelAndView.addObject("error", "hello");
	    
	    return modelAndView;
	}
}