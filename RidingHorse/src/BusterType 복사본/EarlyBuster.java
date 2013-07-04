package BusterType;

public class EarlyBuster extends BusterType {
	public int getSpeedRate(int x){
		if(x>=-50 && x<=halfTrackLength) return 2;//처음부터  트랙절반까지
		else return 1;
	}
}
