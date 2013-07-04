package BusterState;

import SubjectHorse.Horse;

public class Lose implements RunState {
	private static Lose instance = new Lose();
	
	public static Lose getInstance(){return instance;}
	
	public String toString(){return "LoseT-T";}

	@Override
	public void startRunning(Horse horse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishRunning(Horse horse) {
		// TODO Auto-generated method stub
		
	}
}
