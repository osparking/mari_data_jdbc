package space.bumtiger.db.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import space.bumtiger.db.domain.ChessGame;

public interface ChessGameRepository 
			extends CrudRepository<ChessGame, Long>{
	List<ChessGame> findByPlayerBlack(String playerBlack);

}
