package Observer;

import java.util.Observable;
import java.util.Observer;

import BusterState.Win;
import Main.MyContentPane;
import SubjectHorse.HorseCho;
import SubjectHorse.HorseTang;

public class StateOfRun implements Observer{
	MyContentPane myContentPane;
	HorseTang horseTang = HorseTang.getInstance();
	HorseCho horseCho = HorseCho.getInstance(); 
	public StateOfRun(MyContentPane myContentpane){
		this.myContentPane = myContentpane;
		for(int i =0 ;i<myContentPane.getHorseList().size();i++) //옵저버 등록
			myContentPane.getHorseList().elementAt(i).addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
			if(arg instanceof HorseTang){
				horseTang = (HorseTang)arg;
				if(horseTang.getX()>0 && horseTang.getX()<=620)
					horseTang.changeRunning();
				else if(horseTang.getX()>620){
					horseTang.changeFinish();
					myContentPane.setGameOver();
					horseTang.setRunState(Win.getInstance());
				}
				myContentPane.setTangRunStateText(horseTang.getRunState().toString());//상태출력
			}
			else if(arg instanceof HorseCho){
				horseCho = (HorseCho)arg;
				if(horseCho.getX()>0 && horseCho.getX()<=620)
					horseCho.changeRunning();
				else if(horseCho.getX()>620){
					horseCho.changeFinish();
					myContentPane.setGameOver();
					horseCho.setRunState(Win.getInstance());
				}
				myContentPane.setChoRunStateText(horseCho.getRunState().toString());//상태출력
			}
	}

}
