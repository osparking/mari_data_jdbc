package space.bumtiger.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import space.bumtiger.db.domain.ChessGame;
import space.bumtiger.db.domain.ChessMove;
import space.bumtiger.db.domain.ChessMove.MoveColor;
import space.bumtiger.db.repository.ChessGameRepository;

@SpringBootApplication
public class MariDataJdbcApplication {

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext ctx,
			ChessGameRepository repo) {
		return (args) -> {
			System.out.println("봄부트가 제공하는 빈들을 검사하자.");
			ChessGame game = new ChessGame();
			game.setPlayerWhite("Thorben Janssen");
			game.setPlayerBlack("A strong player");

			ChessMove move1white = new ChessMove();
			move1white.setColor(MoveColor.WHITE);
			move1white.setMove("e4");
			game.getMoves().add(move1white);

			ChessMove move1Black = new ChessMove();
			move1Black.setColor(MoveColor.BLACK);
			move1Black.setMove("e5");
			game.getMoves().add(move1Black);

			repo.save(game);
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(MariDataJdbcApplication.class, args);
	}

}
