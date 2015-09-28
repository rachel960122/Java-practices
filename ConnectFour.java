import java.util.Scanner;

public class ConnectFour {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[][] grid = new char[6][7];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = 'N';
			}
		}
		int emptyGrid = 42;
		boolean isFour = isFour(grid);
		
		while(emptyGrid > 0 && !isFour) {
			display(grid);
			switch(emptyGrid % 2) {
			case 0:
				boolean placedR = false;
				while(!placedR) {
					System.out.print("Drop a red disk at column (0¨C6): ");
					int colR = input.nextInt();
					for(int row = 5; row >= 0; row--) {
						if(grid[row][colR] == 'N') {
							grid[row][colR] = 'R';
							placedR = true;
							break;
						}
					}
					if(!placedR) {
						System.out.printf("Column %d is full!\n", colR);
					}
				}
				emptyGrid--;
				isFour = isFour(grid);
				break;
			case 1:
				boolean placedY = false;
				while(!placedY) {
					System.out.print("Drop a yellow disk at column (0¨C6): ");
					int colY = input.nextInt();
					for(int row = 5; row >= 0; row--) {
						if(grid[row][colY] == 'N') {
							grid[row][colY] = 'Y';
							placedY = true;
							break;
						}
					}
					if(!placedY) {
						System.out.printf("Column %d is full!\n", colY);
					}
				}
				emptyGrid--;
				isFour = isFour(grid);
				break;
			}
		}
		display(grid);
		System.out.print("Game Over!");
		if(isFour) {
			if(emptyGrid % 2 == 0) {
				System.out.print("Yellow wins!");
			}
			else{
				System.out.print("Red wins!");
			}
		}
		else{
			System.out.print("Draw!");
		}
	}
	
	public static void display(char[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			char[] contents = grid[i];
			for(int j = 0; j < contents.length; j++) {
				if(contents[j] != 'N') {
					System.out.printf("|%c", contents[j]);
				}
				else{
					System.out.print("| ");
				}
				
			}
			System.out.print("|\n");
		}
	}
	
	public static boolean isFour(char[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j <= 3; j++) {
				if(grid[i][j] == grid[i][j+1] &&
				   grid[i][j] == grid[i][j+2] &&
				   grid[i][j] == grid[i][j+3] &&
				   grid[i][j] != 'N') {
					return true;
				}
			}
		}
		
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == grid[i+1][j] &&
				   grid[i][j] == grid[i+2][j] &&
				   grid[i][j] == grid[i+3][j] &&
				   grid[i][j] != 'N') {
					return true;
				}
			}
		}
		
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 3; j++) {
				if(grid[i][j] == grid[i+1][j+1] &&
				   grid[i][j] == grid[i+2][j+2] &&
				   grid[i][j] == grid[i+3][j+3] &&
				   grid[i][j] != 'N') {
					return true;
				}
			}
		}
		
		for(int i = 3; i <= 5; i++) {
			for(int j = 0; j <= 3; j++) {
				if(grid[i][j] == grid[i-1][j+1] &&
				   grid[i][j] == grid[i-2][j+2] &&
				   grid[i][j] == grid[i-3][j+3] &&
				   grid[i][j] != 'N') {
					return true;
				}
			}
		}
		return false;
	}

}
