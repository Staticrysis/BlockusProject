package grid;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JButton;
import players.Human;

public class CustomButton extends JButton implements ActionListener{
	public int x;
	public int y;
	public int playerColor;
	public Human humanReference;
	
	public CustomButton(){}
	
	public CustomButton(int x, int y, int playerColor){
		this.x = x;
		this.y = y;
		this.playerColor = playerColor;
		this.addActionListener(this);
		
		switch (playerColor)
		{
		case 0: setBackground(Color.gray); break;
		case 1: setBackground(Color.blue); break;
		case 2: setBackground(Color.yellow); break;
		case 3: setBackground(Color.red); break;
		case 4: setBackground(Color.green); break;
		case 5: setBackground(Color.black); break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.print(x + " = x : " + y + " = y");
		MainGrid.x = this.x;
		MainGrid.y = this.y;
		
		//System.out.println("Button was pressed");
	}
}
