
public class MineSweeper {
	
	public static void main(String[] args) {
		MineField mine = new MineField();
		Player a = new Player("Kostas");
		Player b = new Player("John");
		while (mine.getFindMines() < mine.getMines()) {
			mine.print();
			a.play(mine);
			if (mine.getFindMines() == mine.getMines()) {
				System.out.println("The game is over" + "Kostas wins");
				break;
			}
			System.out.println("Kostas score is: " + a.getScore());
			System.out.println("John score is: " + b.getScore());
			
			mine.print();
			b.play(mine);
			if (mine.getFindMines() == mine.getMines()) {
				System.out.println("The game is over" + "John wins");
				break;
			}
			System.out.println("Kostas score is: " + a.getScore());
			System.out.println("John score is: " + b.getScore());
		}
	}
	
}
