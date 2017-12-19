package com.igs.ipi.tpspringbootnutakor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootnutakor.game.Player;
import com.igs.ipi.tpspringbootnutakor.model.Game;
import com.igs.ipi.tpspringbootnutakor.service.GameService;

@Controller
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("game/new")
	public ModelAndView newGame() {
		
		ModelAndView mav = new ModelAndView("game");
		
		Player p1 = new Player();
		Player p2 = new Player();
		
		Game game = gameService.newGame(p1, p2);
		
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