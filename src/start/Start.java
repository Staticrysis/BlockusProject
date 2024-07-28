package start;
import java.awt.*;
import java.util.ArrayList;

import grid.MainGrid;
import grid.MiniGrid;

import javax.swing.*;

import players.*;


public class Start extends JFrame{
	JPanel sidePanel = new JPanel(new BorderLayout());
	static MainGrid mainGrid = new MainGrid();
	static MiniGrid miniGrid = new MiniGrid();
	static int humanPlayerCount;
	static ArrayList<Player> playerList = new ArrayList<>();
	private java.util.Scanner input;
	
	public Start()
	{
            System.out.println(
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                "Objective:\n" +
                "   Each player has to fit as many of his/her 21 pieces on the board as possible\n" +
                "and have the highest score. The score is calculated by adding up the total \n" +
                "number of cells for each player. Therefore, the player who played the\n" +
                " most pieces (cells from the pieces) wins the game.\n" +
     
                "   When setting a piece on the board, use the vertex of each shape as a marker.\n" + 
                "If a player cannot perform another play, that player can \n" +
                "click the 'Quit' button to remove them self from play and to allow player \n" +
                "rotation to continue. If no player can continue, the game will end and display \n" +
                "score results." +
                "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
            );
        
		System.out.print("Hint: enter 0 to watch the game play itself.\n" + 
                        "Enter the number of players (integer only or this program will close): ");
                
                
                
		try {
			input = new java.util.Scanner(System.in);
			humanPlayerCount = input.nextInt();
			if (humanPlayerCount > 4) humanPlayerCount = 4;
			else if (humanPlayerCount < 0) humanPlayerCount = 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		
		//Player initialization 
		//Four player initializations will be required
                int countCopy = humanPlayerCount;
		for(int player = 1; player <= 4; player++)
		{
			if (countCopy >= 1){
				countCopy -= 1;
				playerList.add(new Human(player, miniGrid, mainGrid));
			}
			else
			{
				playerList.add(new AI(player, miniGrid, mainGrid));
			}
		}
		
		mainGrid.resetLayout();
		setLayout(new BorderLayout());
		add(mainGrid, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Start frame1 = new Start();
		frame1.setSize(750, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setAlwaysOnTop(true);
		frame1.setResizable(true);
		frame1.setVisible(true);
		

                    JFrame frame2 = new JFrame();
                    frame2.setSize(367, 430);
                    frame2.add(miniGrid);
                    frame2.move(755, 5);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setAlwaysOnTop(true);
                    frame2.setResizable(false);
                    frame2.setVisible(true);	
                    frame2.validate();
		if (humanPlayerCount == 0)frame2.setVisible(false);
                
		
while (playerList.get(0).canMove == true || playerList.get(1).canMove == true
		|| playerList.get(2).canMove == true || playerList.get(3).canMove == true)
		{
			if(playerList.get(0).canMove == true) {
				playerList.get(0).setAPiece(); 
				if (playerList.get(0).isHuman == false)Thread.sleep(80); 
				} 

			if(playerList.get(1).canMove == true) {
				playerList.get(1).setAPiece(); 
				if (playerList.get(1).isHuman == false)Thread.sleep(80); 
				} 

			if(playerList.get(2).canMove == true) {
				playerList.get(2).setAPiece(); 
				if (playerList.get(2).isHuman == false)Thread.sleep(80); 
				} 

			if(playerList.get(3).canMove == true) {
				playerList.get(3).setAPiece(); 
				if (playerList.get(3).isHuman == false)Thread.sleep(80); 
				} 
		}
		
		int[] summery = new int[4];
		for(int x = 1; x < MainGrid.grid.length - 1; x++){
			for(int y = 1; y < MainGrid.grid.length - 1; y++){
				switch (MainGrid.grid[x][y]){
				case 1: summery[0]++; break;
				case 2: summery[1]++; break;
				case 3: summery[2]++; break;
				case 4: summery[3]++; break;
				}
			}
		}
		
		System.out.print("Score Results:" +
						 "\nBlue \t" + summery[0] +
						 "\nYellow \t" + summery[1] +
						 "\nRed \t" + summery[2] +
						 "\nGreen \t" + summery[3]);
                frame2.setVisible(false);
	}
}
