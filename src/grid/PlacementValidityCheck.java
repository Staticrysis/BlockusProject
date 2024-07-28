package grid;

import java.util.InputMismatchException;
import blokusShapes.Shape;


public class PlacementValidityCheck extends Thread{
	int[][] grid;
	int cellSelectionX = 0;
	int cellSelectionY = 0;
	boolean angleFound = false; 
	boolean errorSimilar = false;
	boolean errorOverlapping = false;
	boolean errorAdjacent = false;
	int loopCount = 0;
	
	public PlacementValidityCheck(int[][] grid){
		this.grid = grid;
	}
	
	//INFO DISCLAMER:
	//Cell selection temporarily holds each cell of a selected shape relative to the x and y values passed(mainGrid mouse click event x and y).
	//The outer FOR LOOP gets every cell in a shape. (Contained in the cellSelectionX,Y)
	//The inner FOR LOOPS cycle through each cell of the shape to insure that each cell passes the validity check.
	public boolean isValidPlacement(int player, Shape shapes, int shapeNumber, int rotationState, int x, int y){
		angleFound = false; 
		errorSimilar = false;
		errorOverlapping = false;
		errorAdjacent = false;


		for (int index = 0; index < shapes.shapeList.get(shapeNumber).shapeSides[0][0].length; index++){
			cellSelectionX = x + shapes.shapeList.get(shapeNumber).shapeSides[rotationState][0][index]; //Gets the selected cell's X axis relative to the vertex. 
			cellSelectionY = y + shapes.shapeList.get(shapeNumber).shapeSides[rotationState][1][index]; //Gets the selected cell's Y axis relative to the vertex.
			
		//Used + Overlapping error check
		//Note: to avoid unnecessary iterations, this method will return if shape is used
		if (shapes.shapeList.get(shapeNumber).used == true){ 
			return false;
			}
			try{
				if(grid[cellSelectionX][cellSelectionY] != 0) {errorOverlapping = true;}
			}
			catch(java.lang.ArrayIndexOutOfBoundsException e){}
			

			//Set false if: adjacent is equal to player number.
			for(int caseIndex = 0; caseIndex <= 3; caseIndex++){
				try 
				{
					switch (caseIndex) 
					{
					case 0: if(grid[cellSelectionX + 1][cellSelectionY] == player ) errorAdjacent = true; //adjacent of: right
					case 1: if(grid[cellSelectionX - 1][cellSelectionY] == player ) errorAdjacent = true; //adjacent of: left
					case 2: if(grid[cellSelectionX][cellSelectionY + 1] == player ) errorAdjacent = true; //adjacent of: bottom
					case 3: if(grid[cellSelectionX][cellSelectionY - 1] == player ) errorAdjacent = true; //adjacent of: top
					//System.out.println("Adject Found at: (" + (cellSelectionX + 1) + "x, " + (cellSelectionY) + "y)");
					}
				}
				catch (IndexOutOfBoundsException e)
				{
					caseIndex++; //In the case of and IndexOutOfBoundsException, this will move the selection forward.
				}	
			}
			
			//Must find similar angle: True if found, else remain False
			for(int caseIndex = 0; caseIndex <= 3; caseIndex++)
			{
				try 
				{	
					switch (caseIndex) 
					{
					case 0: if(grid[cellSelectionX - 1][cellSelectionY - 1] == player) {angleFound = true;} //angle of x,y: top left
					case 1: if(grid[cellSelectionX + 1][cellSelectionY - 1] == player) {angleFound = true;} //angle of x,y: top right
					case 2: if(grid[cellSelectionX - 1][cellSelectionY + 1] == player) {angleFound = true;} //angle of x,y: bottom left
					case 3: if(grid[cellSelectionX + 1][cellSelectionY + 1] == player) {angleFound = true;} //angle of x,y: bottom right
					}
				}
				catch (IndexOutOfBoundsException e)
				{
					caseIndex++; //In the case of and IndexOutOfBoundsException, this will move the selection forward.
				}
			}
		}
			if(
					angleFound == true &&
					errorSimilar == false &&
					errorOverlapping == false &&
					errorAdjacent == false 
				) return true;	
			else  return false; 
	}
	
	
	
	//Fills the mainGrid with values and uses the piece if it passes the validity check. 
	public boolean setPiece(boolean isHuman, int player, Shape shapes, int shapeNumber, int rotationState, int x, int y)
	{
			//System.out.println("Player " + player + ": Step " + loopCount + ": Shape " + shapeNumber + ": Rotation " + rotationState +  ": Location X = " + x + ": Y = " + y);
			loopCount++;
		
		
		try 
		{		
			if(isValidPlacement(player, shapes, shapeNumber, rotationState, x, y) == false) return false;
			
			for (int index = 0; index < shapes.shapeList.get(shapeNumber).shapeSides[0][0].length; index++)// Grabs the X ordinates of the rotations state.
				grid[x + shapes.shapeList.get(shapeNumber).shapeSides[rotationState][0][index]] 
					[y + shapes.shapeList.get(shapeNumber).shapeSides[rotationState][1][index]]= player;
			
			shapes.shapeList.get(shapeNumber).used = true;
			
			
			return true;//Breaks out and sets the piece when no exception is found.
		}
		catch(IndexOutOfBoundsException e)
		{
			return false;
		}
		catch(InputMismatchException e)
		{
			return false;
		}
	}
}




