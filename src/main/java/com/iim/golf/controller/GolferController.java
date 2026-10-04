package com.iim.golf.controller;
import com.iim.golf.model.Golfer;
import com.iim.golf.service.AddGolferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/golf")
public class GolferController
{
    @Value("${role.user:USER,DEFAULT}")
    private List<String> roleUser;


    private final AddGolferService addGolferService;
    @Autowired
    public GolferController(AddGolferService addGolferService){
        this.addGolferService = addGolferService;
    }

    //new Golfer(nom,club,handicap,reflexe,force)

   @PostMapping("/add")
   public Golfer create(@RequestParam String nom,@RequestParam String club , @RequestParam int handicap ,@RequestParam int swing ,int force){
       roleUser.forEach(System.out::println);
       return addGolferService.create(nom, club,handicap,swing,force);


   }

    //@PostMapping("")
    //public int multi(@RequestParam int force, @RequestParam int reflexe){
      //  return addGolferService.calcul(reflexe,force);
    //}
//}

    @GetMapping("/get")
    public Golfer getById(@RequestParam int id){
        return addGolferService.getById(id);
    }



}
