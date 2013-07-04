package SubjectHorse;

import javax.swing.ImageIcon;

import BusterType.LateBuster;

public class HorseTang extends Horse {
	private static HorseTang instance = new HorseTang();
	public HorseTang(){
		x = -50; y = 20;
		busterType = new LateBuster();
		ic = new ImageIcon("image/gam.gif");
		img = ic.getImage();
	}
	
	public static HorseTang getInstance(){return instance;}

	public String toString(){return "tang";} //옵저버가 스레드라서 2개라 구별하렬고 쓰는거.. 되려나는 모르겟다.
}
