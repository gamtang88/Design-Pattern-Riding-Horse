package Main;

import javax.swing.JFrame;

public class RidingHorse extends JFrame{
	MyContentPane myContentPane;
	public static void main(String [] args){
		new RidingHorse();
	}
	public RidingHorse(){
		myContentPane = new MyContentPane();
		setTitle("�渶�� �վ���!!!!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(myContentPane);
		
		
		
		setSize(950, 550);
		setVisible(true);
	}
}

//�ƹ����� ���⿡ ������ Ŭ������ ������ �ҵ�.
