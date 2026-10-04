package com.iim.golf.service;

import com.iim.golf.model.Game;
import com.iim.golf.model.Golfer;
import com.iim.golf.model.Terain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final AddGolferService addGolferService;
    private final AddTerainService addTerainService;
    private final Game game = new Game();

    @Autowired
    public GameService(AddGolferService addGolferService, AddTerainService addTerainService) {
        this.addGolferService = addGolferService;
        this.addTerainService = addTerainService;
    }

    public String jouer(int joueur1Id, int joueur2Id, int terainId) {
        Golfer joueur1 = addGolferService.getById(joueur1Id);
        Golfer joueur2 = addGolferService.getById(joueur2Id);
        Terain terain = addTerainService.getById(terainId);

        return game.jouer(joueur1, joueur2, terain);
    }
}
