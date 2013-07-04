package SubjectHorse;

import java.awt.Image;
import java.util.Observer;

import javax.swing.ImageIcon;

import BusterState.Ready;
import BusterState.RunState;
import BusterType.BusterType;

public abstract class Horse{
	protected int x,y,rate;
	protected BusterType busterType;
	protected RunState runState;
	protected DelegatedObservable delegatedObservable;
	protected ImageIcon ic ;
	protected Image img;
	
	public Horse (){
		rate = 1;
		runState=Ready.getInstance();
		delegatedObservable = new DelegatedObservable();
	}
	
	public void addObserver(Observer o){
		delegatedObservable.addObserver(o);
	}
	
	public void deleteObserver(Observer o){
		delegatedObservable.deleteObserver(o);
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public void setRunState(RunState runState){
		this.runState = runState;
	}
	public RunState getRunState(){return runState;}
	public void changeRunning(){
		runState.startRunning(this);
	}
	
	public void changeFinish(){
		runState.finishRunning(this);
	}
	
	public void setX(int addInterval){
		getSpeedRate(x);
		
		x += addInterval*rate;
		delegatedObservable.setChanged();
		delegatedObservable.notifyObservers(this);
	}
	public void setY(int addHeight){
		y += addHeight;
	}
	
	//말객체가 상태를 옵저버에게 알려주는 친절함보단 옵저버가 말의 위치를 보고 판단하도록 바꿔서 필요없어졌다.
	/*
	public void changedRunState(RunState runState){  //runState 바뀌면 알림
		this.runState = runState;
		delegatedObservable.setChanged();
		delegatedObservable.notifyObservers(this);//변수를 안보내고 this 보내는 이유는 
		//이걸로 2가지 쓰레드를 구별해야되야되서 어쩔수 없다  cho 인지 tang 인지 구별해야함.
	}*/
	
	private void getSpeedRate(int x){
		rate = busterType.getSpeedRate(x);
	}
	
	public Image getImage(){return img;	}

	public abstract String toString();
}