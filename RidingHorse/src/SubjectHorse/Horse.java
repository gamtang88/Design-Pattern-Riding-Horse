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
	
	//����ü�� ���¸� ���������� �˷��ִ� ģ���Ժ��� �������� ���� ��ġ�� ���� �Ǵ��ϵ��� �ٲ㼭 �ʿ��������.
	/*
	public void changedRunState(RunState runState){  //runState �ٲ�� �˸�
		this.runState = runState;
		delegatedObservable.setChanged();
		delegatedObservable.notifyObservers(this);//������ �Ⱥ����� this ������ ������ 
		//�̰ɷ� 2���� �����带 �����ؾߵǾߵǼ� ��¿�� ����  cho ���� tang ���� �����ؾ���.
	}*/
	
	private void getSpeedRate(int x){
		rate = busterType.getSpeedRate(x);
	}
	
	public Image getImage(){return img;	}

	public abstract String toString();
}