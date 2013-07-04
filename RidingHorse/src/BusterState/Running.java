package BusterState;

import SubjectHorse.Horse;

public class Running implements RunState {
	private static Running instance = new Running();
	
	public static Running getInstance(){return instance;}
	
	public String toString(){return "Running!";}

	@Override
	public void startRunning(Horse horse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishRunning(Horse horse) {
		// TODO Auto-generated method stub
		horse.setRunState(Arrival.getInstance());
	}
}
