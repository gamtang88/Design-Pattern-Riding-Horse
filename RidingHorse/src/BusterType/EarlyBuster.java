package BusterType;

public class EarlyBuster extends BusterType {
	public int getSpeedRate(int x){
		if(x>=-50 && x<=halfTrackLength) return 2;//ó������  Ʈ�����ݱ���
		else return 1;
	}
}
