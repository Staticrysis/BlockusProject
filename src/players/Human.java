package players;
import grid.MainGrid;
import grid.MiniGrid;

public class Human extends Player {
	int flagX, flagY;
	
	public Human(int player, MiniGrid miniGrid, MainGrid mainGrid){
		super(player, miniGrid, mainGrid);
		this.isHuman = true;
		this.miniGrid = miniGrid;
		this.miniGrid.shapes = this.shapes;
		miniGrid.player = this.player;
		miniGrid.shapes = this.shapes;
		flagX = mainGrid.x;
		flagY = mainGrid.y;
	}

	public void setMiniGridValues(){
		miniGrid.player = this.player;
		miniGrid.shapes = this.shapes;
		this.miniGrid.repaint();
		this.mainGrid.revalidate();
	}
	
	public void setAPiece() {
		setMiniGridValues();
		
		//Avoids letting the user mainGrid button clicks remaining the same
		//If left alown, a piece could be set on the button the user last clicked 
		//as the they cycle through the different shapes
		mainGrid.x = 0;
		mainGrid.y = 0;
		flagX = 0;
		flagY = 0;
		
		while (true){
			while(true){
			//  This code loops indefinitely until a flag is tripped by a click on the mainGrid
				if (miniGrid.canMove == false || mainGrid.x != flagX || mainGrid.y != flagY){
					break;
				}
				try {Thread.sleep(300);} 
				catch (InterruptedException e) {e.printStackTrace();}
			}
			if (miniGrid.canMove == false) {miniGrid.canMove = true; this.canMove = false; break;}
			
			if(validity.setPiece(
					isHuman, //Set in the parent class
					player, 
					shapes, 
					miniGrid.shapeSettings[0], //Set when user selects shape from the miniGrid panel
					miniGrid.shapeSettings[1], 
					MainGrid.x, 			   //Set when user clicks on the mainGrid panel
					MainGrid.y) == true) break;
			
			//this.shapes.shapeList.get(miniGrid.shapeSettings[0]).used = true;
			mainGrid.x = 0;
			mainGrid.y = 0;
			flagX = 0;
			flagY = 0;
		}
		mainGrid.resetLayout();
	}
}
