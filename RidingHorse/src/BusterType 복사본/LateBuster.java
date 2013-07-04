package BusterType;

public class LateBuster extends BusterType {
	public int getSpeedRate(int x){
		if(x>=halfTrackLength && x<=totalTrackLength)return 2;
		else return 1;
	}
}
