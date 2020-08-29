import java.util.Scanner;

public class Player {

	private String name;
	private int score;
	private Scanner scan;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void play(MineField field) {
		System.out.println(name + " poio keli theleis na anoikseis?");
		scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
		if (field.check(i, j)) {
			score++;
			System.out.println(name + " vrikes mia narkh. To score sou einai: " + score);
		}
	}
	
	public int getScore() {
		return score;
	}
	
}
