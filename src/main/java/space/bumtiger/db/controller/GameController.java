package space.bumtiger.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import space.bumtiger.db.domain.ChessGame;
import space.bumtiger.db.repository.ChessGameRepository;

@Controller
@RequestMapping("/game")
@Slf4j
@AllArgsConstructor
public class GameController {
	@Autowired
	ChessGameRepository gameRepo;

	@GetMapping("/{blackPlayerName}")
	public ResponseEntity<List<ChessGame>> logGameByBlackPlayerName(
			@PathVariable String blackPlayerName) {
		var games = gameRepo.findByPlayerBlack(blackPlayerName);
		
		if (games.size() == 0) {
			log.info(blackPlayerName + " 흑잡고 둔 체스는 없다.");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			games.forEach(g -> log.info(g.toString()));
			return new ResponseEntity<>(games, HttpStatus.OK);
		}
	}
}
