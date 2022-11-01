package Backgammon;

public class BarRule {

	public static void main(String[] args) {
		
		Bar redBar = new Bar(BasicColour.RED);
		Bar blackBar = new Bar(BasicColour.BLACK);
		Chess chess = new Chess (BasicColour.RED);

		BasicColour a = BasicColour.RED;
//		System.out.println(a);
//		System.out.println(redBar);
//		System.out.println(chess.colour);
		switch(chess.colour) {
		case RED:
			redBar.putChess(chess);

			break;
		case BLACK:
			blackBar.putChess(chess);
			break;
			
		}//
	}
}
