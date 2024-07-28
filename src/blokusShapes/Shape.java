package blokusShapes;
import java.util.ArrayList;

public class Shape {
	public int priority; //Should range from 1-21. 
	public boolean used = false;
	public ArrayList<Shape> shapeList = new ArrayList<Shape>();
	public int[][][] shapeSides; 
	
	//There are 21 total pieces.
	//For constructing the main Shape object.
	public Shape()
	{
			//Shape 1
			Shape shape1 = new Shape(0);
			shape1.priority = -5;
			shape1.shapeSides = new int[][][]{
			{{0}, {0}}};
			shapeList.add(shape1);
			
			//Shape 2
			Shape shape2 = new Shape(0);
			shape2.priority = 0;
			shape2.shapeSides = new int[][][]{
				{{0, 0}, {0, 1}},
				{{0, 1}, {0, 0}}};
			shapeList.add(shape2);
			
			//Shape 3
			Shape shape3 = new Shape(0);
			shape3.priority = 0;
			shape3.shapeSides = new int[][][]{
				{{0, -1, -1, 0, 0}, {0, 0, -1, 0, 0}},
				{{0, 0, -1, 0, 0}, {0, 1, 1, 0, 0}},	
				{{0, 1, 1, 0, 0}, {0, 0, 1, 0, 0}},
				{{0, 0, 1, 0, 0}, {0, -1, -1, 0, 0}}};
			shapeList.add(shape3);
			
			//Shape 4
			Shape shape4 = new Shape(0);
			shape4.priority = 0;
			shape4.shapeSides = new int[][][]{
					{{0, 0, 0}, {0, 1, 2}},
					{{0, 1, 2}, {0, 0, 0}}};
			shapeList.add(shape4);
			
			//Shape 5
			Shape shape5 = new Shape(0);
			shape5.priority = 1;
			shape5.shapeSides = new int[][][]{
					{{0, 1, 0, 1}, {0, 0, 1, 1}}};
			shapeList.add(shape5);
			
			//Shape 6  
			Shape shape6 = new Shape(0);
			shape6.priority = 2;
			shape6.shapeSides = new int[][][]{
					{{0, 1, 1, 1, 0}, {0, -1, 0, 1, 0}},
					{{0, -1, 0, 1, 0}, {0, -1, -1, -1, 0}},
					{{0, -1, -1, -1, 0}, {0, -1, 0, 1, 0}},
					{{0, -1, 0, 1, 0}, {0, 1, 1, 1, 0}}};
			shapeList.add(shape6);
			
			//Shape 7
			Shape shape7 = new Shape(0);
			shape7.priority = 1;
			shape7.shapeSides = new int[][][]{
					{{0, 0, 0, 0}, {0, -1, -2, -3}},
					{{0, -1, -2, -3}, {0, 0, 0, 0}}};
			        
			shapeList.add(shape7);
			
			//Shape 8
			Shape shape8 = new Shape(0);
			shape8.priority = 2;
			shape8.shapeSides = new int[][][]{
					{{0, 1, 1, 1}, {0, 0, -1, -2}},
					{{0, 0, -1, -2}, {0, -1, -1, -1}},
					{{0, -1, -1, -1}, {0, 0, 1, 2}},
					{{0, 0, 1, 2}, {0, 1, 1, 1}},
					{{0, 1, 1, 1}, {0, 0, 1, 2}},
					{{0, 0, 1, 2}, {0, -1, -1, -1}},
					{{0, -1, -1, -1}, {0, 0, -1, -2}},
					{{0, 0, -1, -2}, {0, 1, 1, 1}}};
			        
			shapeList.add(shape8);
			
			//Shape 9
			Shape shape9 = new Shape(0);
			shape9.priority = 2;
			shape9.shapeSides = new int[][][]{
					{{0, 0, 1, 1}, {0, 1, 0, -1}},
					{{0, 1, -1, 0}, {0, 0, -1, -1}},
					{{0, 0, 1, 1}, {0, -1, 1, 0}},
					{{0, -1, 1, 0}, {0, 0, -1, -1}}};
			shapeList.add(shape9);
			
			//Shape 10
			Shape shape10 = new Shape(0);
			shape10.priority = 3;
			shape10.shapeSides = new int[][][]{
					
					
					{{0, 1, 1, 1, 1}, {0, 0, 1, 2, 3}},
					{{0, 0, 1, 2, 3}, {0, -1, -1, -1, -1}},
					{{0, -1, -1, -1, -1}, {0, 0, -1, -2, -3}},
					{{0, 0, -1, -2, -3}, {0, 1, 1, 1, 1}},
					{{0, 1, 1, 1, 1}, {0, 0, -1, -2, -3}},
					{{0, 0, -1, -2, -3}, {0, -1, -1, -1, -1}},
					{{0, -1, -1, -1, -1}, {0, 0, 1, 2, 3}},
					{{0, 0, 1, 2, 3}, {0, 1, 1, 1, 1}}};
			shapeList.add(shape10);
			
			//Shape 11
			Shape shape11 = new Shape(0);
			shape11.priority = 3;
			shape11.shapeSides = new int[][][]{
					{{0, 1, 2, 2, 2}, {0, 0, -1, 0, 1}},
					{{0, 0, 0, 1, -1}, {0, -1, -2, -2, -2}},
					{{0, -1, -2, -2, -2}, {0, 0, 0, -1, 1}},
					{{0, 0, -1, 0, 1}, {0, 1, 2, 2, 2}}};
			shapeList.add(shape11);
			
			//Shape 12
			Shape shape12 = new Shape(0);
			shape12.priority = 3;
			shape12.shapeSides = new int[][][]{
					{{0, 0, 0, -1, -2}, {0, -1, -2, -2, -2}},
					{{0, -1, -2, -2, -2}, {0, 0, 0, 1, 2}},
					{{0, 0, 0, 1, 2}, {0, 1, 2, 2, 2,}},
					{{0, 1, 2, 2, 2}, {0, 0, 0, -1, -2}}};
			shapeList.add(shape12);
			
			//Shape 13
			Shape shape13 = new Shape(0);
			shape13.priority = 4;
			shape13.shapeSides = new int[][][]{
					{{0, 0, 0, 1, 1}, {0, 1, 2, -1, 0}},
					{{0, 1, 2, -1, 0}, {0, 0, 0,- 1, -1}},
					{{0, 0, 0, -1, -1}, {0, -1, -2, 0, 1}},
					{{0, 1, 0, -1, -2}, {0, 0, -1, -1, -1}},
					{{0, 0, -1, -1, -1}, {0, 1, -2, -1, 0}},
					{{0, 1, 0, -1, -2}, {0, 0, 1, 1, 1}},
					{{0, 0, 1, 1, 1}, {0, -1, 0, 1, 2}},
					{{0, -1, 0, 1, 2}, {0, 0, -1, -1, -1}},
					
					};
			shapeList.add(shape13);
			
			//Shape 14
			Shape shape14 = new Shape(0);
			shape14.priority = 4;
			shape14.shapeSides = new int[][][]{
					{{0, -2, -1, 0, -2}, {0, 1, 1, 1, 2}}, 
					{{0, 2, 1, 0, 2}, {0, 1, 1, 1, 2}}, 
					{{0, 1, 1, 1, 2}, {0, -2, -1, 0, -2}},
					{{0, -1, -1, -1, -2}, {0, -2, -1, 0, -2}},
					};
			shapeList.add(shape14);
			
			//Shape 15
			Shape shape15 = new Shape(0);
			shape15.priority = 3;
			shape15.shapeSides = new int[][][]{
					{{0, 0, 0, 0, 0}, {0, 1, 2, 3, 4,}},
					{{0, -1, -2, -3, -4}, {0, 0, 0, 0, 0}}};
			shapeList.add(shape15);
			
			//Shape 16
			Shape shape16 = new Shape(0);
			shape16.priority = 3;
			shape16.shapeSides = new int[][][]{
					
					{{0, 1, 1, 2, 2}, {0, 0, 1, 0, 1}},
					{{0, 0, 1, 0, 1}, {0, -1, -1, -2, -2}},
					{{0, -1, -1, -2, -2}, {0, 0, -1, 0, -1}},
					{{0, 0, -1, 0, -1}, {0, 1, 1, 2, 2}},
					{{0, 1, 1, 2, 2}, {0, 0, -1, 0, -1}},
					{{0, 0, -1, 0, -1}, {0, -1, -1, -2, -2,}},
					{{0, -1, -1, -2, -2}, {0, 0, 1, 0, 1}},
					{{0, 0, 1, 0, 1}, {0, 1, 1, 2, 2,}}};
			shapeList.add(shape16);
					
			//shape 17
			Shape shape17 = new Shape(0);
			shape17.priority = 5;
			shape17.shapeSides = new int[][][]{
					{{0, 1, -1, 0, -1}, {0, 0, 1, 1, 2,}},
					{{0, 0, 1, 1, 2}, {0, -1, 1, 0, 1}},
					{{0, -1, 1, 0, 1}, {0, 0, -1, -1, -2,}},
					{{0, 0, -1, -1, -2}, {0, 1, -1, 0, -1}}};
			shapeList.add(shape17);
			
			//Shape 18
			Shape shape18 = new Shape(0);
			shape18.priority = 5;
			shape18.shapeSides = new int [][][]{
					{{0, 0, -1, -2, -2,}, {0, 1, 0, 0, 1}},
					{{0, 1, 0, 0, 1}, {0, 0, 1, 2, 2,}},
					{{0, 0, 1, 2, 2,}, {0, -1, 0, 0, -1}},
					{{0, -1, 0, 0, -1}, {0, 0, -1, -2, -2,}}
					
					};
			shapeList.add(shape18);
	
			//shape 19
			Shape shape19 = new Shape(0);
			shape19.priority = 5;
			shape19.shapeSides = new int[][][]{
					
					{{0, 1, 1, 1, 2}, {0, -1, 0, 1, 1}},
					{{0, -1, 0, 1, 1}, {0, -1, -1, -1, -2,}},
					{{0, -1, -1, -1, -2}, {0, 1, 0, -1, -1}},
					{{0, 0, 1, 1, 2}, {0, 1, -1, 0, 0,}},
					{{0, 1, 1, 1, 2}, {0, -1, 0, 1, -1}},
					{{0, 0, 1, 2, 1}, {0, 1, 1, 1, 2}},
					{{0, 0, 1, 0, -1}, {0, 1, 1, 2, 2}},
					{{0, -1, 0, 1, 1}, {0, 1, 1, 1, 2}}};
					
			shapeList.add(shape19);
			
			//Shape 20
			Shape shape20 = new Shape(0);
			shape20.priority = 3;
			shape20.shapeSides = new int[][][]{
					{{0, 1, 1 , 1, 2,}, {0, 1, 0, -1, 0}}};
			shapeList.add(shape20);
			
			//Shape 21 
			Shape shape21 = new Shape(0);
			shape21.priority = 4;                                                                 
			shape21.shapeSides = new int[][][]{
					{{0, 1, 1, 1, 1}, {0, -1, 0, 1, 2}}, 
					{{0, -1, 0, 1, 2}, {0, -1, -1, -1, -1}},
					{{0, -1, -1, -1, -1}, {0, 1, 0, -1, -2}},
					{{0, 1, 0, -1, -2}, {0, 1, 1, 1, 1}},
					{{0, 1, 1, 1, 1,}, {0, 1, 0, -1, -2}},
					{{0, 1, 0, -1, -2}, {0, -1, -1, -1, -1,}},
					{{0, -1, -1, -1, -1,}, {0, -1, 0, 1, 2}},
					{{0, -1, 0, 1, 2}, {0, 1, 1, 1, 1,}},
					};
			shapeList.add(shape21);
		}
	
	
	//For constructing each of the shapes.
	public Shape(int priority)
	{
		this.priority = priority;
	}
}		
