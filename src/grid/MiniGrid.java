package grid;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import blokusShapes.Shape;

public class MiniGrid extends JPanel {
	public int miniGrid[][] = new int[9][9];
	public GridPanel gridPanel = new GridPanel();
	private JPanel buttonPanel = new JPanel();
	public JButton shapeUp = new JButton("Shape Up");
	public JButton shapeDown = new JButton("Shape Down");
	public JButton rotate = new JButton("Rotate");
	public JButton quit = new JButton("Quit");
	
	public int[] shapeSettings = new int[4]; //ShapeNumber//RotationState
	public Shape shapes;
	public int player; //If = no reference, grid wont paint()
	public boolean canMove = true;
	
	public MiniGrid(){
		shapeUp.addActionListener(new UpListener());
		shapeDown.addActionListener(new DownListener());
		rotate.addActionListener(new RotateListener());
		quit.addActionListener(new QuitListener());
		
		//shapeUp.setBackground(Color.getHSBColor(219, 98, 70));

		buttonPanel.add(shapeUp);
		buttonPanel.add(shapeDown);
		buttonPanel.add(rotate);
		buttonPanel.add(quit);
		
		setLayout(new BorderLayout());
		add(buttonPanel, new BorderLayout().SOUTH);
		add(gridPanel, new BorderLayout().CENTER);
		
		this.repaint();
	}
	
	//Check is all shapes are used. Returns false if they are.
	private boolean PlayableShapeCheck(){
			for (Shape shape: shapes.shapeList){
				if (shape.used == false) {
					return true;
				}
			}
			return false;
	}
	
	private void cycleShape(String cycle){
		shapeSettings[1] = 0;//resets rotation
		
		switch (cycle){
			case "DOWN": {
				shapeSettings[0]--;
				while (true){
					if (shapeSettings[0] < 0) shapeSettings[0] = shapes.shapeList.size() - 1; //Under-list reset to shapeList length/size - 1
					if (shapes.shapeList.get(shapeSettings[0]).used == true){
						shapeSettings[0]--;
					}
					else break;
				}
				break;
			}
			case  "UP":  { 
				
				shapeSettings[0]++;
				while(true){ 
					if (shapeSettings[0] >= shapes.shapeList.size()) shapeSettings[0] = 0; //Over-list reset to 0
					if (shapes.shapeList.get(shapeSettings[0]).used == true) {
						shapeSettings[0]++;
					}
					else break;
				}
			}
		}
	}
	
	class DownListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (PlayableShapeCheck() == true){
				cycleShape("DOWN");

							
				//System.out.println("Used = :" + shapes.shapeList.get(shapeSettings[0]).used + ", Shape: " + shapeSettings[0] + ", Shape Side: " + shapeSettings[1] + ", Shape Priority: " + shapes.shapeList.get(shapeSettings[0]).priority);
				for (int index = 0; index < shapes.shapeList.get(shapeSettings[0]).shapeSides[0][0].length ; index++)// Grabs the X ordinates of the rotations state.
					miniGrid[4 + shapes.shapeList.get(shapeSettings[0]).shapeSides[shapeSettings[1]][0][index]] 
							[4 + shapes.shapeList.get(shapeSettings[0]).shapeSides[shapeSettings[1]][1][index]]= player;
				gridPanel.repaint();
			}
			else canMove = false;
		}
	}
	
	class UpListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (PlayableShapeCheck() == true){
				cycleShape("UP");
				//System.out.println("Used = :" + shapes.shapeList.get(shapeSettings[0]).used + ", Shape: " + shapeSettings[0] + ", Shape Side: " + shapeSettings[1] + ", Shape Priority: " + shapes.shapeList.get(shapeSettings[0]).priority);
				for (int index = 0; index < shapes.shapeList.get(shapeSettings[0]).shapeSides[0][0].length ; index++)
					miniGrid[4 + shapes.shapeList.get(shapeSettings[0]).shapeSides[shapeSettings[1]][0][index]] 
							[4 + shapes.shapeList.get(shapeSettings[0]).shapeSides[shapeSettings[1]][1][index]]= player;
				gridPanel.repaint();
			}
			else canMove = false;
		}
	}
	
	class RotateListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (PlayableShapeCheck() == true){
			
				if (shapeSettings[1] == shapes.shapeList.get(shapeSettings[0]).shapeSides.length -1) shapeSettings[1] = 0;
				else shapeSettings[1]++;
				
				//System.out.println("Used = " + shapes.shapeList.get(shapeSettings[0]).used + ", Shape: " + shapeSettings[0] + ", Shape Side: " + shapeSettings[1] + ", Shape Priority: " + shapes.shapeList.get(shapeSettings[0]).priority);
				for (int index = 0; index < shapes.shapeList.get(shapeSettings[0]).shapeSides[0][0].length ; index++)
					miniGrid[4 + shapes.shapeList.get(shapeSettings[0]).shapeSides[shapeSettings[1]][0][index]] 
							[4 + shapes.shapeList.get(shapeSettings[0]).shapeSides[shapeSettings[1]][1][index]] = player;
				gridPanel.repaint();
			}
			else canMove = false;
		 }
	}
	
	class QuitListener implements ActionListener{
		@Override 
		public void actionPerformed(ActionEvent e){
				canMove = false;
			}
		}
		
	private class GridPanel extends JPanel{
		public void paint(Graphics g){
			super.paintComponent(g);
//	For displaying the shape in System.out
//			for(int x = 0; x < miniGrid.length; x++){
//				for(int y = 0; y < miniGrid.length; y++){
//					if(miniGrid[x][y] == 0) System.out.print("\u2588 ");
//					else System.out.print("" + miniGrid[x][y] + " ");
//					
//					//if (x == miniGrid.length -1) System.out.println();
//				}
//				System.out.println("");
//			}
			
			//Grabs the value for each unit of width and height for the square.
			int xUnit =  getWidth() / miniGrid.length;
			int yUnit = getHeight() / miniGrid.length;
			//Draws the color of each square on the miniGrid relative to the players number inside the selected element.
			
			for(int x = 0; x < miniGrid.length ; x++){		
				for (int y = 0; y < miniGrid.length ; y++){
					
					switch (miniGrid[x][y])
					{
					case 0: g.setColor(Color.gray); break;
					case 1: g.setColor(Color.blue); break;
					case 2: g.setColor(Color.yellow); break;
					case 3: g.setColor(Color.red); break;
					case 4: g.setColor(Color.green); break;
					}
					

					g.fillRect(yUnit * y, xUnit * x,  xUnit, yUnit);
					g.setColor(Color.orange);
					//g.drawString(x + "x, " + y + "y", 7 + (x * xUnit), 15 + (y * yUnit));
					if (x == 4 && y == 4)
					{
						g.setColor(Color.orange);
						g.drawString("Vertex", 4 + (4 * xUnit), 25 + (4 * yUnit));
					}
					else
					{
						g.setColor(Color.orange);
						//g.drawString("" + miniGrid[x][y], 7 + (x * xUnit), 15 + (y * yUnit));
					}

				}
				
				//Draws the grid lines. 
				for(int i = 1; i <= 20; i++)
				{
					g.setColor(Color.white);
					g.drawLine(0, yUnit * i, getWidth(), yUnit * i); //x-axis line
					g.drawLine(i * xUnit, 0, i * xUnit, getHeight());
					
				}					
			}
//			System.out.println(getWidth() + ")(" + getHeight());
			miniGrid = new int[9][9];
		}
	}
}
