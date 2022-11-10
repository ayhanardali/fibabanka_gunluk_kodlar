package com.example.fibabootcamp2.configuration.relation.mvc;

import com.example.fibabootcamp2.configuration.relation.entity.Player;
import com.example.fibabootcamp2.configuration.relation.entity.Team;
import com.example.fibabootcamp2.configuration.relation.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/team/insert")
    @ResponseBody
    public String insertTeam() {
        Team teamA = new Team(0, "Batmanspor");
        teamA.setPlayerList(new ArrayList<>());

        Player player1 = new Player(0, "Barış Manço", 65);
        player1.setTeam(teamA);
        teamA.getPlayerList().add(player1);

        Player player2 = new Player(0, "Arda Güler", 50);
        player2.setTeam(teamA);
        teamA.getPlayerList().add(player2);

        Player player3 = new Player(0, "Fikret Kızılok", 85);
        player3.setTeam(teamA);
        teamA.getPlayerList().add(player3);

        teamRepository.save(teamA);

        return "Ekleme başarılı: " + teamA.getTeamId();
    }
}
