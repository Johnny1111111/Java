package Backgammon;



enum BasicColour {
	
	RED,
	BLACK,

}

 
enum BarColour {

		
RedBar (DisplayColour.RED+ "Bar1", BasicColour.RED),
BlackBar (DisplayColour.BLACK + "Bar2", BasicColour.BLACK);
	
		
private String symbol;
private BasicColour colour;


BarColour (String symbol, BasicColour colour) {		

	this.symbol = symbol;
this.colour = colour;
	    	
		}
		 
		
public String getSymbol() {
return symbol;
			 
		 }
		
public BasicColour getColour() {
return colour;
		 }
		


} 
		 

enum ChessColour {

	
	RedChess (DisplayColour.RED+ "Bar1", BasicColour.RED),
	BlackChess (DisplayColour.BLACK + "Bar2", BasicColour.BLACK);
	
	private String symbol;
	private BasicColour colour;

	
	ChessColour (String symbol, BasicColour colour) {
	
		 this.symbol = symbol;
	
		this.colour = colour;
    	
	}
	 
	
	 public String getSymbol() {
		 return symbol;
		 
	 }
	
	 public BasicColour getColour() {
		 return colour;
	 }
}
	




		 
