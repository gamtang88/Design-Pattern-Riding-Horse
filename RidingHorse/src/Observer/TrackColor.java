package Observer;

import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.ImageIcon;

import Main.MyContentPane;
import SubjectHorse.Horse;
import SubjectHorse.HorseCho;
import SubjectHorse.HorseTang;

public class TrackColor implements Observer{
	static final int orangeTrack = -55;
	static final int greenTrack = 120;
	static final int skyblueTrack =275;
	static final int purpleTrack = 450;
	MyContentPane myContentPane;
	Horse horse;
	HorseTang horseTang = HorseTang.getInstance();
	HorseCho horseCho = HorseCho.getInstance();
	ImageIcon ic;
	Image imgGreen,imgOrange,imgPurple,imgSkyblue;
	

	public TrackColor(MyContentPane myContentPane){
		this.myContentPane = myContentPane;
		for(int i=0 ; i< myContentPane.getHorseList().size() ;i++){
			myContentPane.getHorseList().elementAt(i).addObserver(this);
		}
		ic = new ImageIcon("image/green.png");
		imgGreen = ic.getImage();
		ic = new ImageIcon("image/orange.png");
		imgOrange = ic.getImage();
		ic = new ImageIcon("image/purple.png");
		imgPurple = ic.getImage();
		ic = new ImageIcon("image/skyblue.png");
		imgSkyblue = ic.getImage();
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof Horse){
			horse = (Horse)arg;
			if(horse.getX()>=orangeTrack && horse.getX()<greenTrack){
				if(arg instanceof HorseTang){
					myContentPane.setTangPresentTrack(imgOrange);
				}
				else{
					myContentPane.setChoPresentTrack(imgOrange);
				}
			}
			else if(horse.getX()>=greenTrack && horse.getX()<skyblueTrack){
				if(arg instanceof HorseTang){
					myContentPane.setTangPresentTrack(imgGreen);
				}
				else{
					myContentPane.setChoPresentTrack(imgGreen);
				}
			}
			else if(horse.getX()>=skyblueTrack && horse.getX()<purpleTrack){
				if(arg instanceof HorseTang){
					myContentPane.setTangPresentTrack(imgSkyblue);
				}
				else{
					myContentPane.setChoPresentTrack(imgSkyblue);
				}
			}
			else{
				if(arg instanceof HorseTang){
					myContentPane.setTangPresentTrack(imgPurple);
				}
				else{
					myContentPane.setChoPresentTrack(imgPurple);
				}
			}
		}
	}

}
