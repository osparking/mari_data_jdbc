package space.bumtiger.db.domain;

import lombok.Data;

@Data
public class ChessMove {
	public enum MoveColor {
		WHITE, BLACK
	}

	private Integer moveNumber;

	private MoveColor color;

	private String move;
}
