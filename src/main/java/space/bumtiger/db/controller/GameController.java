package space.bumtiger.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import space.bumtiger.db.repository.ChessGameRepository;

@Controller
@RequestMapping("/game")
@Slf4j
@AllArgsConstructor
public class GameController {
	@Autowired
	ChessGameRepository gameRepo;

	@GetMapping("/{blackPlayerName}")
	public void logGameByBlackPlayerName(
			@PathVariable String blackPlayerName) {
		var games = gameRepo.findByPlayerBlack(blackPlayerName);
		games.forEach(g -> log.info(g.toString()));
	}
}
