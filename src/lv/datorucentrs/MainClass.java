package lv.datorucentrs;

import lv.datorucentrs.formas.Kvits;
import lv.datorucentrs.formas.PrakseServiss;

public class MainClass {
	public static void main(String[] args) {
		Kvits frame = new Kvits();
		frame.setVisible(true);
		
		PrakseServiss frame2 = new PrakseServiss();
		frame2.setVisible(true);
	}
}