package Observer;

import java.util.Observable;
import java.util.Observer;

import Main.MyContentPane;
import SubjectHorse.HorseCho;
import SubjectHorse.HorseTang;

public class MovedDistance implements Observer{
	int x;
	MyContentPane myContentPane;
	HorseTang horseTang = HorseTang.getInstance();
	HorseCho horseCho = HorseCho.getInstance();
	
	public MovedDistance(MyContentPane myContentPane){
		this.myContentPane = myContentPane;
		//옵저버 등록.....될까 과연..
		for(int i =0 ;i<myContentPane.getHorseList().size();i++)
			myContentPane.getHorseList().elementAt(i).addObserver(this);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof HorseTang){
			horseTang = (HorseTang)arg;
			myContentPane.setTangRunnedDistance(horseTang.getX()+50);
		}
		else if(arg instanceof HorseCho){
			horseCho = (HorseCho)arg;
			myContentPane.setChoRunnedDistance(horseCho.getX()+50);
		}
	}
}
