package settlers;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DiceController {
	
	private int die1, die2;
	private ImageView die1View, die2View;
	private int sum;

	public DiceController() {
		
	}
	
	public int getDie1() {
		return die1;
	}

	public void setDie1(int die1) {
		this.die1 = die1;
	}

	public int getDie2() {
		return die2;
	}

	public void setDie2(int die2) {
		this.die2 = die2;
	}

	public ImageView getDie1View() {
		return die1View;
	}

	public void setDie1View(ImageView die1View) {
		this.die1View = die1View;
	}

	public ImageView getDie2View() {
		return die2View;
	}

	public void setDie2View(ImageView die2View) {
		this.die2View = die2View;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public void rollDice() {
		Random generator1 = new Random();
		Random generator2 = new Random();
		setDie1(generator1.nextInt(6) + 1);
		setDie2(generator2.nextInt(6) + 1);
		setSum(getDie1() + getDie2());
		switch (getDie1()) {
			case 1:
				setDie1View(new ImageView(new Image("die1.png")));
				break;
			case 2:
				setDie1View(new ImageView(new Image("die2.png")));
				break;
			case 3:
				setDie1View(new ImageView(new Image("die3.png")));
				break;
			case 4:
				setDie1View(new ImageView(new Image("die4.png")));
				break;
			case 5:
				setDie1View(new ImageView(new Image("die5.png")));
				break;
			case 6:
				setDie1View(new ImageView(new Image("die6.png")));
				break;
		}
		switch (getDie2()) {
			case 1:
				setDie2View(new ImageView(new Image("die1.png")));
				break;
			case 2:
				setDie2View(new ImageView(new Image("die2.png")));
				break;
			case 3:
				setDie2View(new ImageView(new Image("die3.png")));
				break;
			case 4:
				setDie2View(new ImageView(new Image("die4.png")));
				break;
			case 5:
				setDie2View(new ImageView(new Image("die5.png")));
				break;
			case 6:
				setDie2View(new ImageView(new Image("die6.png")));
				break;
		}
		
	}



}
