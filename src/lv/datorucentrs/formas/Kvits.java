package lv.datorucentrs.formas;

import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Kvits extends JFrame implements ActionListener, ItemListener {
private Container frame;

public Kvits() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setBounds(100, 100, 570, 800);
	
	init();

	setContentPane(panel);
}
	public JPanel panel;
	JLabel tehnikis, datums, darbs, cena, klients, matreali, tel, problema, dator, piezimes, km, h, apraksts;

	public JRadioButton izbraukuma, uzvietas;
	public JTextField tehnikis1, datums1, darbs1,  klients1, tel1, dator1, h1, km1, cena1;
	public JRadioButton pievienot, dzest, labot;
	public JTextArea problema1, piezimes1, apraksts1, matreali1;

	private void init() {
		panel = new JPanel();
		panel.setLayout(null);
		
		pievienot = new JRadioButton("Pievienot");
		pievienot.setBounds(20, 20, 80, 30);
		pievienot.addActionListener(this);

		dzest = new JRadioButton("Dzçst");
		dzest.setBounds(100, 20, 70, 30);
		dzest.addActionListener(this);

		labot = new JRadioButton("Labot");
		labot.setBounds(170, 20, 100, 30);
		labot.addActionListener(this);
		
		izbraukuma = new JRadioButton("Izbraukumâ");
		izbraukuma.setBounds(430, 20, 100, 30);
		izbraukuma.addActionListener(this);

		uzvietas = new JRadioButton("Uz vietas");
		uzvietas.setBounds(430, 60, 100, 30);
		uzvietas.addActionListener(this);
		
		
	
		tehnikis = new JLabel("Tehniíis: ");
		tehnikis.setBounds(30, 60, 150, 30);

		datums = new JLabel("Datums: ");
		datums.setBounds(30, 95, 150, 30);
		
		darbs = new JLabel("Darbs: ");
		darbs.setBounds(30, 130, 150, 30);
		
		klients = new JLabel("Klients: ");
		klients.setBounds(30, 180, 150, 30);
		
		tel = new JLabel("Tel. ");
		tel.setBounds(370, 180, 150, 30);

		problema = new JLabel("Problçma: ");
		problema.setBounds(30, 215, 150, 30);
		
		dator = new JLabel("Datortehnika: ");
		dator.setBounds(30, 310, 150, 30);
		
		piezimes = new JLabel("Piezîmes:");
		piezimes.setBounds(30, 350, 150, 30);
		
		km = new JLabel("Transports (km)-");
		km.setBounds(30, 415, 150, 30);
		
		h = new JLabel("Darba laiks: (H)-");
		h.setBounds(260, 415, 150, 30);
		
		apraksts = new JLabel("Darba apraksts:");
		apraksts.setBounds(30, 450, 150, 30);
		
		matreali = new JLabel("Izmantotie matreâli:");
		matreali.setBounds(30, 595, 150, 30);
		
		matreali1 = new JTextArea();
		matreali1.setBounds(148, 595, 395, 85);
		
		cena = new JLabel("Cena:");
		cena.setBounds(430, 700, 150, 30);
		
		cena1 = new JTextField();
		cena1.setBounds(465, 700, 80, 30);
		
		
		km1 = new JTextField();
		km1.setBounds(128, 415, 125, 30);
		
		h1 = new JTextField();
		h1.setBounds(353, 415, 125, 30);
		
		apraksts1 = new JTextArea();
		apraksts1.setBounds(125, 450, 420, 140);
		
		dator1 = new JTextField();
		dator1.setBounds(120, 310, 430, 30);
		
		klients1 = new JTextField();
		klients1.setBounds(100, 180, 250, 30);
		
		
		piezimes1 = new JTextArea();
		piezimes1.setBounds(100, 350, 450, 50);
		
		tel1 = new JTextField();
		tel1.setBounds(400, 178, 155, 30);
		
		problema1 = new JTextArea();
		problema1.setBounds(100, 215, 450, 80);
		
		tehnikis1 = new JTextField();
		tehnikis1.setBounds(100, 60, 180, 30);

		datums1 = new JTextField();
		datums1.setBounds(100, 95, 180, 30);

		darbs1 = new JTextField();
		darbs1.setBounds(100, 130, 180, 30);

		panel.add(tehnikis);
		panel.add(datums);
		panel.add(darbs);
		panel.add(tehnikis1);
		panel.add(datums1);
		panel.add(darbs1);
		panel.add(pievienot);
		panel.add(labot);
		panel.add(dzest);
		panel.add(izbraukuma);
		panel.add(uzvietas);
		panel.add(klients);
		panel.add(tel);
		panel.add(problema);
		panel.add(klients1);
		panel.add(tel1);
		panel.add(problema1);
		panel.add(dator);
		panel.add(piezimes);
		panel.add(dator1);
		panel.add(piezimes1);
		panel.add(km);
		panel.add(h);
		panel.add(apraksts);
		panel.add(km1);
		panel.add(h1);
		panel.add(apraksts1);
		panel.add(matreali);
		panel.add(matreali1);
		panel.add(cena);
		panel.add(cena1);
		
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
