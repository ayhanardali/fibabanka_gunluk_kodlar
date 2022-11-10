package com.example.fibabootcamp2.configuration.relation.mvc;

import com.example.fibabootcamp2.configuration.relation.entity.Player;
import com.example.fibabootcamp2.configuration.relation.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/sports")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players/byteam")
    @ResponseBody
    public String getPlayersByTeam() {
        long teamId = 1;
        List<Player> players = playerRepository.findAllByTeamId(teamId);
        double totalScore = 0;
        for (Player player : players) {
            System.out.println(player.getPlayerId()
                    + " "
                    + player.getPlayerName()
                    + " "
                    + player.getAverageScore());
            totalScore += player.getAverageScore();
        }
        double averageScore = totalScore / players.size();
        return "Ortalama skor: " + averageScore;
    }
}
