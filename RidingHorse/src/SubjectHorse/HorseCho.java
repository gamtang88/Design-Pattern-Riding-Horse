package SubjectHorse;

import javax.swing.ImageIcon;

import BusterType.EarlyBuster;

public class HorseCho extends Horse {
	private static HorseCho instance = new HorseCho();
	public HorseCho(){
		x = -50; y = 120;
		busterType = new EarlyBuster();
		ic = new ImageIcon("image/cho.gif");
		img = ic.getImage();
	}
	public static HorseCho getInstance(){return instance;}
	
	public String toString(){return "cho";}
}
