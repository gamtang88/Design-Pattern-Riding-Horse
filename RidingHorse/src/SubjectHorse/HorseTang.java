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

	public String toString(){return "tang";} //�������� ������� 2���� �����Ϸİ� ���°�.. �Ƿ����� �𸣰ٴ�.
}
