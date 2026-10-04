package com.iim.golf.service;

import com.iim.golf.model.Golfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iim.golf.repository.GolfRepository;

@Service
public class AddGolferService {
    private GolfRepository golfRepository;

    @Autowired
    public AddGolferService(GolfRepository golfRepository) {
        this.golfRepository = golfRepository;
    }

    public Golfer create(String nom, String club, int handicap, int swing, int force) {
        Golfer nouveauGolfer = new Golfer(nom, club, handicap, swing, force);
        Golfer golferInsere = (Golfer) golfRepository.save(nouveauGolfer);
        return golferInsere;
    }

    public Golfer getById(int id) {
        return golfRepository.findById(id).get();
    }

}

