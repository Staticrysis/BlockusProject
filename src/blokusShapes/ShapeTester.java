package blokusShapes;

public class ShapeTester {
	
	
	public static void main(String args[]){
		Shape shapes = new Shape();
		int miniGrid[][] = new int[9][9];
		
		for(int shapeIndexer = 0; shapeIndexer <= 20; shapeIndexer++){ //Gets list size.{	
			for(int orientationIndexer = 0; orientationIndexer < shapes.shapeList.get(shapeIndexer).shapeSides.length; orientationIndexer++){ //Selects shapes with list size.
				System.out.println("Shape/Side/Orientation");
				for(int cells = 0; cells < shapes.shapeList.get(shapeIndexer).shapeSides[orientationIndexer][0].length; cells++){
					miniGrid[4 + shapes.shapeList.get(shapeIndexer).shapeSides[orientationIndexer][0][cells]] 
							[4 + shapes.shapeList.get(shapeIndexer).shapeSides[orientationIndexer][1][cells]] = cells + 1;//shapes.shapeList.get(shapeNumber).shapeSides[0][0].length
					System.out.println((shapeIndexer) + " / " + (orientationIndexer) + " / " + cells + " / ");
				
				}
			
			for(int x = 0; x < miniGrid.length; x++){
				for(int y = 0; y < miniGrid.length; y++){
					if(miniGrid[x][y] == 0) System.out.print("\u2588 ");
					else System.out.print("" + miniGrid[x][y] + " ");
					
					//if (x == miniGrid.length -1) System.out.println();
				}
				System.out.println("");
			}
			
			
			miniGrid = new int[9][9];
			}
		}
	}
}
