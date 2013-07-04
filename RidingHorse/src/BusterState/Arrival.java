package BusterState;

import SubjectHorse.Horse;

public class Arrival implements RunState {
	private static Arrival instance = new Arrival();
	
	public static Arrival getInstance(){return instance;}
	
	public String toString(){return "Goal in!!";}

	@Override
	public void startRunning(Horse horse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishRunning(Horse horse) {
		// TODO Auto-generated method stub
		
	}
}
