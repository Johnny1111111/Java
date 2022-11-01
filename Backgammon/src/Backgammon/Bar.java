package Backgammon;

import java.util.*;

public class Bar {

	BasicColour barColour ;
	ArrayList<Chess> bar;
	
	Bar(BasicColour barColour){
		this.barColour = barColour;
		this.bar = new ArrayList<Chess>();//Bar a = new Bar();
	
		
	}
	
	public void putChess (Chess boardchess) {
		

		bar.add(boardchess); 
	
		System.out.println("done");
	}
	
	public void outChess (Chess barchess) {
		

	
	
	}
	

	}
	
