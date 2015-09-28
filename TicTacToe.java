import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[][] grid = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j <3; j++) {
				grid[i][j] = 'N';
			}
		}
		int emptyGrid = 9;
		boolean isWon = isWon(grid);
		while(emptyGrid > 0 && !isWon) {
			display(grid);
			switch(emptyGrid % 2) {
			case 0: 
				boolean assignedY = false;
				while(assignedY == false) {
					System.out.print("Enter a row (1, 2, or 3) for player Y: ");
					int rowY = input.nextInt();
					System.out.println();
					System.out.print("Enter a column (1, 2, or 3) for player Y: ");
					int colY = input.nextInt();
					if(grid[rowY - 1][colY - 1] == 'N') {
						grid[rowY - 1][colY - 1] = 'O';
						assignedY = true;
						emptyGrid--;
						isWon = isWon(grid);
					}
					else{
						System.out.println("This grid has been taken");
					}
				}
				break;
				
			case 1:
				boolean assignedX = false;
				while(assignedX == false) {
					System.out.print("Enter a row (1, 2, or 3) for player X: ");
					int rowX = input.nextInt();
					System.out.println();
					System.out.print("Enter a column (1, 2, or 3) for player X: ");
					int colX = input.nextInt();
					if(grid[rowX - 1][colX - 1] == 'N') {
						grid[rowX - 1][colX - 1] = 'X';
						assignedX = true;
						emptyGrid--;
						isWon = isWon(grid);
					}
					else{
						System.out.println("This grid has been taken!\n");
					}
				}
				break;
			}
			
		}
		display(grid);
		System.out.print("Game Over! ");
		if(isWon) {
			if(emptyGrid % 2 == 0) {
				System.out.print("The winner is player X!");
			}
			else{
				System.out.print("The winner is player Y!");
			}
		}
		else{
			System.out.print("There's no winner!");
		}
	}
	
	public static boolean isWon(char[][] grid) {
		for(int i = 0; i < 3; i++) {
			if(grid[i][0] != 'N' && grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]) {
				return true;
			}
		}
		
		for(int i = 0; i < 3; i++) {
			if(grid[0][i] != 'N' && grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i]) {
				return true;
			}
		}
		
		if((grid[0][0] != 'N' && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) ||
				(grid[0][2] != 'N' && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0])) {
			return true;
		}
		
		return false;
	}
	
	
	public static void display(char[][] grid) {
		for(int i = 0; i < 3; i++) {
			System.out.printf("-------------\n");
			char[] contents = new char[3];
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] == 'O' || grid[i][j] == 'X') {
					contents[j] = grid[i][j];
				}
				
			}
			System.out.printf("| %c | %c | %c |\n", contents[0], contents[1],
					contents[2]);
		}
		System.out.printf("-------------\n");
	}
}
  