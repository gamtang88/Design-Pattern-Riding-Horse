package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import BusterState.Ready;
import Observer.MovedDistance;
import Observer.StateOfRun;
import Observer.TrackColor;
import SubjectHorse.Horse;
import SubjectHorse.HorseCho;
import SubjectHorse.HorseTang;

public class MyContentPane extends JPanel{
	static final int WidthOfbtnStart = 150;
	static final int HeightOfbtnStart = 50;
	static final int WidthOfTrack = 120;
	static final int HeightOfTrack = 60;
	static final int lengthOfHorseImage = 100;
	JButton btnStartNum;
	ImageIcon ic,imageIconstartBtn;
	Image backGround,horseImage1,horseImage2,tangPresentTrack,choPresentTrack;
	MyActionListener mal = new MyActionListener();
	MovedDistance movedDistance;
	StateOfRun stateOfRun;
	TrackColor trackColor;
	boolean isGameOver;

	ThreadHorse threadHorse;

	private int tangRunnedDistance;//표시할 달린거리
	private int choRunnedDistance;//표시할 달린거리
	String tangRunStateText;
	String choRunStateText;
	Vector<Horse> horseList = new Vector<Horse>();


	public MyContentPane(){
		setLayout(null);
		ic = new ImageIcon("image/backGround_State.png");
		backGround = ic.getImage();
		
		imageIconstartBtn = new ImageIcon("image/btnStart.png");
		btnStartNum = new JButton(imageIconstartBtn);
		btnStartNum.addActionListener(mal);
		btnStartNum.setBounds(785, 100, WidthOfbtnStart , HeightOfbtnStart);
		add(btnStartNum);
		tangRunnedDistance = 0; choRunnedDistance = 0;
		tangRunStateText = Ready.getInstance().toString(); 
		choRunStateText = Ready.getInstance().toString();
		horseImage1 = null; horseImage1 = null; 
		tangPresentTrack = null; choPresentTrack = null;

		horseList.addElement(HorseTang.getInstance());
		horseList.addElement(HorseCho.getInstance());

		addMouseListener(new MyMouseListener());
		movedDistance = new MovedDistance(this); //이놈이 여기에 그릴려면 컨트롤해야함
		stateOfRun =new StateOfRun(this); 
		trackColor = new TrackColor(this);

	}

	public int getTangRunnedDistance(){return tangRunnedDistance;}
	public int getChoRunnedDistance(){return choRunnedDistance;}
	public void setTangRunnedDistance(int tangRunnedDistance){this.tangRunnedDistance = tangRunnedDistance;}
	public void setChoRunnedDistance(int choRunnedDistance){this.choRunnedDistance = choRunnedDistance;}
	public void setTangRunStateText(String tangRunStateText){
		this.tangRunStateText = tangRunStateText;
	}
	public void setChoRunStateText(String choRunStateText){
		this.choRunStateText = choRunStateText;
	}
	public void setGameOver(){isGameOver = true;}
	public void setTangPresentTrack(Image tangPresentTrack){
		this.tangPresentTrack = tangPresentTrack;
	}
	public void setChoPresentTrack(Image choPresentTrack){
		this.choPresentTrack = choPresentTrack;
	}
	public Vector<Horse> getHorseList(){return horseList;}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backGround, 0, 0, getWidth(), getHeight(),this);
		g.setColor(Color.black);
		g.setFont(new Font("Jokerman",Font.ITALIC,30));
		g.drawString(""+tangRunnedDistance+"m", 200, 370);
		g.drawString(tangRunStateText, 630, 370);
		
		g.drawString(""+choRunnedDistance+"m", 200, 470);
		g.drawString(choRunStateText, 630, 470);
		g.drawImage(horseImage1, HorseTang.getInstance().getX() , HorseTang.getInstance().getY(), lengthOfHorseImage, lengthOfHorseImage, this);
		g.drawImage(horseImage2, HorseCho.getInstance().getX() , HorseCho.getInstance().getY(), lengthOfHorseImage, lengthOfHorseImage, this);
		g.drawImage(tangPresentTrack, 385, 330, WidthOfTrack, HeightOfTrack,this);
		g.drawImage(choPresentTrack, 385, 430, WidthOfTrack, HeightOfTrack,this);
	}

	public class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			JButton btn = (JButton)ae.getSource();
			if(btn.equals(btnStartNum)){
				threadHorse = new ThreadHorse("tang", HorseTang.getInstance());
				threadHorse.start();
				threadHorse = new ThreadHorse("cho", HorseCho.getInstance());
				threadHorse.start();
			}
		}
	}

	public class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent me){
			System.out.println("x:"+me.getX()+", y:"+me.getY());
		}
	}

	public class ThreadHorse extends Thread{
		Horse horse;
		String name;
		int yy=1;

		public ThreadHorse(String name,Horse horse){
			this.name = name;
			this.horse = horse;
			isGameOver = false;
			if(name.equals("tang")){
				horseImage1 = horse.getImage();
			}
			else if(name.equals("cho")){
				horseImage2 = horse.getImage();
			}
		}

		public void run(){
			int i =0;
			while(!isGameOver){
				try {
					Thread.sleep(100);
					int addInterval = (int)(Math.random()*5)+1;
					System.out.println(name+" "+horse.getX()+" interval:"+addInterval);
					System.out.println("tangRunnedDistance: "+ tangRunnedDistance +" , choRunnedDistance :"+choRunnedDistance);
					horse.setX(addInterval);
					if(i%5==0)yy*=-1;// 오의 배수 될때마다 부호 바궈서 더하고 빼줌
					horse.setY(yy);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				i++;
			}

		}
	}
}
