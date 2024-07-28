package players;
import blokusShapes.Shape;
import grid.MiniGrid;
import grid.PlacementValidityCheck;
import grid.MainGrid;



public abstract class Player{
	public boolean isHuman;
	public int player;
	public Shape shapes = new Shape();
	public boolean canMove = true;
	public static int[][] grid = MainGrid.grid;
	
	public MiniGrid miniGrid;
	public MainGrid mainGrid = new MainGrid();
	protected PlacementValidityCheck validity = new PlacementValidityCheck(grid);

	
	public Player(int player, MiniGrid miniGrid, MainGrid mainGrid){
		this.player = player;
		this.mainGrid = mainGrid;
		this.miniGrid = miniGrid;
	}
	
	abstract public void setAPiece();
}
