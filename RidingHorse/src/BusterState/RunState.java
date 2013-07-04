package BusterState;

import SubjectHorse.Horse;

public interface RunState {
	public String toString();
	public void startRunning(Horse horse);//¶Ù±â½ÃÀÛ
	public void finishRunning(Horse horse);//µµÂø½Ã
}
