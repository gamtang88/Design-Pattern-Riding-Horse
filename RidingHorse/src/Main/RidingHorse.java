package Main;

import javax.swing.JFrame;

public class RidingHorse extends JFrame{
	MyContentPane myContentPane;
	public static void main(String [] args){
		new RidingHorse();
	}
	public RidingHorse(){
		myContentPane = new MyContentPane();
		setTitle("경마를 합씨당!!!!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(myContentPane);
		
		
		
		setSize(950, 550);
		setVisible(true);
	}
}

//아무래도 여기에 쓰레드 클래스를 만들어야 할듯.
