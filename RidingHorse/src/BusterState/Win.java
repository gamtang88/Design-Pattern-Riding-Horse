package BusterState;

import SubjectHorse.Horse;

public class Win implements RunState{
	private static Win instance = new Win();
	
	public static Win getInstance(){return instance;}

	public String toString(){return "Win!!";}
	
	@Override
	public void startRunning(Horse horse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishRunning(Horse horse) {
		// TODO Auto-generated method stub
		
	}

}
