package BusterState;

import SubjectHorse.Horse;

public class Ready implements RunState {
	private static Ready instance = new Ready();
	
	public static Ready getInstance(){return instance;}
	
	public String toString(){return "Ready!";}

	@Override
	public void startRunning(Horse horse) {
		// TODO Auto-generated method stub
		horse.setRunState(Running.getInstance());
	}

	@Override
	public void finishRunning(Horse horse) {
		// TODO Auto-generated method stub
		
		
	}
}
