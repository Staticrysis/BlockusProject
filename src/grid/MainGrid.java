package grid;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import players.Human;


public class MainGrid extends JPanel implements MouseListener{	
	public static int grid[][] = new int[22][22];
	public static int x = 0; //Set by the mouse listener
	public static int y = 0; //Set by the mouse listener
	public static ArrayList<CustomButton> buttons;
	public Human playerObject;	
	
	public MainGrid()
	{
		addMouseListener(this);
		resetLayout();

		for(int i = 0; grid.length > i; i++)
		{
			grid[i][0] = 5;
			grid[0][i] = 5;
			grid[grid.length - 1][i] = 5;
			grid[i][grid.length - 1] = 5;
		}
		grid[0][0] = 4;
		grid[21][0] = 1;
		grid[0][21] = 3;
		grid[21][21] = 2;
		
	}
	
	public void mouseClicked(MouseEvent arg0) {}
	@Override public void mouseEntered(MouseEvent arg0) {}
	@Override public void mouseExited(MouseEvent arg0) {}
	@Override public void mousePressed(MouseEvent arg0) {
		revalidate();
	}
	@Override public void mouseReleased(MouseEvent arg0) {}
	
	
	public void resetLayout(){
		removeAll();
		
		setLayout(new GridLayout(22,22));
		buttons = new ArrayList<CustomButton>();
		CustomButton tempButton;
		
		// For a button panel
		setLayout(new GridLayout(22, 22));
		for(int x = 0; x < grid.length ; x++){		
			for (int y = 0; y < grid.length ; y++){
				tempButton = new CustomButton(x, y, grid[x][y]);
				buttons.add(tempButton);
				add(tempButton);
			}
		}
		
		revalidate();
	}
}