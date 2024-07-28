package players;
import grid.MainGrid;
import grid.MiniGrid;
import java.util.ArrayList;
import java.util.Random;


public class AI extends Player{
	//Clear the logs at the end of their use!!!
	ArrayList<int[]> logHotZones; // Possible adjacent x,y locations for a playable shape.
	ArrayList<int[]> logPossablePlays;//logs the {shape, orientation(the side), x, y, value} of playable pieces.
	ArrayList<int[]> logFinals; //All the plays that land on a hot zone and is playable.

	public AI(int player, MiniGrid miniGrid, MainGrid mainGrid)
	{
		super(player, miniGrid, mainGrid);
		this.isHuman = false;
	}
	
	public void moveSteps() 
	{
		logHotZones = new ArrayList<int[]>();
		logPossablePlays = new ArrayList<int[]>();
		logFinals = new ArrayList<int[]>();
	
		
		logHotZones();
		addAdjacentValue();
		//addInvasionValue();
		logAIPlays();
	}

	//done?
	public void logHotZones(){
		for(int x = 1; x < grid.length - 1; x++)
		{
			for(int y = 1; y < grid.length - 1; y++)
			{
				try 
				{	  //Checks for adjacent being empty  && Checks selected x,y == player
					if((grid[x + 1][y + 1] == player|| //Bottom Right
					   grid[x - 1][y - 1] == player || //Top Left
					   grid[x + 1][y - 1] == player || //Top Right
					   grid[x - 1][y + 1] == player)&& //Bottom Left
					   grid[x][y] == 0) //The selected cell must be empty.
					{
						logHotZones.add(new int[]{x, y , 0});
					}
				}
				catch (IndexOutOfBoundsException e)
				{
				}
			}
		}
	}
	
	//done?
	public void addAdjacentValue(){
		for(int i = 0; i < logHotZones.size(); i++)
		{
			for(int caseIndex = 0; caseIndex <= 3; caseIndex++)
			{
				try 
				{	//The occurrence of a players cell adds to the value. This also avoids the boarders. 
					if (grid[logHotZones.get(i)[0] + 1][logHotZones.get(i)[1] + 1] != 0 && 
						grid[logHotZones.get(i)[0] + 1][logHotZones.get(i)[1] + 1] != 5) logHotZones.get(i)[2]++;
					if (grid[logHotZones.get(i)[0] - 1][logHotZones.get(i)[1] - 1] != 0 && 
						grid[logHotZones.get(i)[0] - 1][logHotZones.get(i)[1] - 1] != 5) logHotZones.get(i)[2]++;
					if (grid[logHotZones.get(i)[0] + 1][logHotZones.get(i)[1] - 1] != 0 && 
						grid[logHotZones.get(i)[0] + 1][logHotZones.get(i)[1] - 1] != 5) logHotZones.get(i)[2]++;
					if (grid[logHotZones.get(i)[0] - 1][logHotZones.get(i)[1] - 1] != 0 && 
						grid[logHotZones.get(i)[0] - 1][logHotZones.get(i)[1] - 1] != 5) logHotZones.get(i)[2]++;
				}
				catch (IndexOutOfBoundsException e)
				{
					caseIndex++; //In the case of and IndexOutOfBoundsException, this will move the selection forward.
				}
			}
		}
	}
	
	/*
	//needs work
	public void addInvasionValue(){
		int leftTop = 0;
		int rightTop = 0;
		int leftBottom = 0;
		int rightBottm = 0;
		
		//Check top
		for(int i = 0; i < logHotZones.size(); i++){
			try{
				//Scan leftTop
				for(int )
			}
			catch (IndexOutOfBoundsException e)
			{
				
			}	
			
		}
	}
	*/
	//done?
	
	public void logAIPlays(){
		//logAIPlays() logs all valid plays to the logFinals. 
		//Final log {shape, orientation(the side), x, y, value}
		//To get the x, y: shapes.shapeList(shape).shapeSides[orientation][orientation.lenght][orientation.lenght];
		for(int shapeIndexer = 0; shapeIndexer < shapes.shapeList.size(); shapeIndexer++){ //Gets list size.
			for(int orientationIndexer = 0; orientationIndexer < shapes.shapeList.get(shapeIndexer).shapeSides.length; orientationIndexer++){ //Selects shapes with list size.	
				for(int hotZoneIndexer = 0; hotZoneIndexer < logHotZones.size(); hotZoneIndexer++){
					if(	
					shapes.shapeList.get(shapeIndexer).used == false && //Will skip over a shape that has been used. No point in logging it if it's used.
					validity.isValidPlacement(player, shapes, shapeIndexer, orientationIndexer, logHotZones.get(hotZoneIndexer)[0], logHotZones.get(hotZoneIndexer)[1]) == true
				   ){
					logFinals.add
					(new int[]
							{ //***This is where the AI magic happens***
							shapeIndexer, //Selected shape Number
							orientationIndexer, //Selected orientation/rotation state
							logHotZones.get(hotZoneIndexer)[0], //x co-ordinate of the validity tested cell
							logHotZones.get(hotZoneIndexer)[1], //y co-ordinate of the validity tested cell
							logHotZones.get(hotZoneIndexer)[2] + //The sum value from all the checks value
							shapes.shapeList.get(shapeIndexer).priority + //Shapes priority value
							new Random().nextInt(15) //For adding some randomness to the selection but not enough to override the main decisions. 
							}
					); 
					}
				}
			}
		}
	}
	

	@Override	//done? FIX THIS
	public void setAPiece() {
		moveSteps();
		
		int highValue = 0;
		int indexOfHighValue = 0;
		int [] tempInt = null;
		ArrayList<int[]> tempLogFinals = new ArrayList<int[]>();
		
		//Sorts the logFinals from highest to lowest.
		for(int i = 0; i < logFinals.size(); i++){
			for (int j = 0; j < logFinals.size(); j++){ 
				if (highValue < logFinals.get(i)[4])
				{
					highValue = logFinals.get(i)[4];
					indexOfHighValue = i;
				}
			}
			tempLogFinals.add(logFinals.get(indexOfHighValue));
			logFinals.remove(indexOfHighValue);
		}
		
		logFinals = tempLogFinals;
		
		//Places the highest value in the selection. 
		if( logFinals.size() != 0 &&
			validity.setPiece(false, player, shapes, 		
		    logFinals.get(indexOfHighValue)[0], //Shape Number
			logFinals.get(indexOfHighValue)[1], //x
			logFinals.get(indexOfHighValue)[2], //y
			logFinals.get(indexOfHighValue)[3]) //Value
			== true
		) 
		{
			shapes.shapeList.get(logFinals.get(indexOfHighValue)[0]).used = true;
		}
		else canMove = false; //Might be wrong about to find out
		
		mainGrid.resetLayout();
	}
}
