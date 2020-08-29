import java.util.Random;

public class MineField {
	
	private int mines = 20;
	private int findMines = 0;
	private int[][] field = new int[10][10];
	private int[][] openBoxes = new int[10][10];
	
	public MineField() {
		putMines();
		calcCounters();
	}
	
	public MineField(int mines) {
		this.mines = mines;
		putMines();
		calcCounters();
	}
	
	public void putMines() {
		Random rndGen = new Random();
		int m = 0;
		while (m < mines) {
			int i = rndGen.nextInt(10);
			int j = rndGen.nextInt(10);
			if (field[i][j] != -1) {
				field[i][j] = -1;
				m++;
			}
		}
	}
	
	public void calcCounters() {
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (field[i][j] == 0) {
					int mine_counter = 0;
					if (j-1 >= 0) {
						if (field[i][j-1] == -1) {
							mine_counter++;
						}
					}
					if (i-1 >= 0 && j-1 >= 0) {
						if (field[i-1][j-1] == -1) {
							mine_counter++;
						}
					}
					if (i-1 >= 0) {
						if (field[i-1][j] == -1) {
							mine_counter++;
						}
					}
					if (i-1 >= 0 && j+1 < 10) {
						if (field[i-1][j+1] == -1) {
							mine_counter++;
						}
					}
					if (j+1 < 10) {
						if (field[i][j+1] == -1) {
							mine_counter++;
						}
					}
					if (i+1 < 10 && j+1 < 10) {
						if (field[i+1][j+1] == -1) {
							mine_counter++;
						}
					}
					if (i+1 < 10) {
						if (field[i+1][j] == -1) {
							mine_counter++;
						}
					}
					if (i+1 < 10 && j-1 >= 0) {
						if (field[i+1][j-1] == -1) {
							mine_counter++;
						}
					}
					field[i][j] = mine_counter;
				}
			}
		}
	}
	
	public boolean check(int i, int j) {
		if (i>=0 && i<10 && j>=0 && j<10) {
			if (openBoxes[i][j] == 0) {
				openBoxes[i][j] = 1;
				if (field[i][j] == -1) {
					findMines++;
					return true;
				}
			}
		}
		return false;
	}
	
	public void print() {
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (openBoxes[i][j] == 0) {
					System.out.printf("X  ");
				}else {
					if (field[i][j] == -1) {
						System.out.printf(field[i][j] + " ");
					}else {
						System.out.printf(field[i][j] + "  ");
					}
				}
			}
			System.out.println("");
		}	
	}
	
	public int getFindMines() {
		return findMines;
	}
	
	public int getMines() {
		return mines;
	}

}
