package BusterState;

import SubjectHorse.Horse;

public interface RunState {
	public String toString();
	public void startRunning(Horse horse);//�ٱ����
	public void finishRunning(Horse horse);//������
}
