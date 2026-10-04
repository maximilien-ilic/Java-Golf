package com.iim.golf.controller;

import com.iim.golf.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/play")
    public String jouer(@RequestParam int joueur1,
                        @RequestParam int joueur2,
                        @RequestParam int terain) {
        return gameService.jouer(joueur1, joueur2, terain);
    }
}
