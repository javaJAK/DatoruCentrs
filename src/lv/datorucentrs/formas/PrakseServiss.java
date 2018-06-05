package lv.datorucentrs.formas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrakseServiss extends JFrame implements ActionListener, ItemListener {
	public JPanel panel;
	public JLabel inzenieris, piegadesveids, apmaksastermins, prece, serialaisnr, defekts, piezimes, bojajums, remontadarbibas, komplektacija, izlietotiemateriali, precunosaukums, daudzums, precusanemsanasvieta, sanemejs, vieta, kas;
	public JComboBox piegadesveids1, apmaksastermins1, prece1, serialaisnr1, defekts1, piezimes1, bojajums1, remontadarbibas1, komplektacija1, izlietotiemateriali1, precunosaukums1, daudzums1;
	public JTextField inzenieris1;
	
	
	
	public PrakseServiss() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 200, 800, 900);
		setTitle("PrakseServiss");
		
		init();
		
		setContentPane(panel);
		
	}
	
	public void init() {
		panel = new JPanel();	
		panel.setLayout(null);
		
		inzenieris = new JLabel("INÞENIERIS");
		inzenieris.setBounds(20, 310, 150, 30);
		inzenieris.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		
		piegadesveids = new JLabel("PIEGÂDES VEIDS");
		piegadesveids.setBounds(20, 335, 170, 30);
		piegadesveids.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		apmaksastermins = new JLabel("APMAKSAS TERMIÒÐ");
		apmaksastermins.setBounds(400, 310, 180, 30);
		apmaksastermins.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		prece = new JLabel("PRECE");
		prece.setBounds(20, 380, 100, 30);
		prece.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		serialaisnr = new JLabel("SERIÂLAIS NR.");
		serialaisnr.setBounds(20, 400, 100, 30);
		serialaisnr.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		defekts = new JLabel("DEFEKTS");
		defekts.setBounds(20, 420, 100, 30);
		defekts.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		piezimes = new JLabel("PIEZÎMES");
		piezimes.setBounds(20, 440, 100, 30);
		piezimes.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		bojajums = new JLabel("BOJÂJUMS");
		bojajums.setBounds(20, 460, 100, 30);
		bojajums.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		remontadarbibas = new JLabel("REMONTA DARBÎBAS");
		remontadarbibas.setBounds(20, 480, 125, 30);
		remontadarbibas.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		komplektacija = new JLabel("KOMPLEKTÂCIJA");
		komplektacija.setBounds(20, 500, 110, 30);
		komplektacija.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		izlietotiemateriali = new JLabel("IZLIETOTIE MATERIÂLI / DARBS");
		izlietotiemateriali.setBounds(20, 540, 200, 30);
		izlietotiemateriali.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		precunosaukums = new JLabel("PREÈU NOSAUKUMS");
		precunosaukums.setBounds(20, 560, 150, 30);
		precunosaukums.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		daudzums = new JLabel("DAUDZUMS (GAB.)");
		daudzums.setBounds(580, 560, 180, 30);
		daudzums.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		precusanemsanasvieta = new JLabel("PREÈU SAÒEMÐANAS VIETA");
		precusanemsanasvieta.setBounds(400, 200, 180, 30);
		precusanemsanasvieta.setFont(new Font("Times New Roman",Font.BOLD, 12));
		
		sanemejs = new JLabel("SIA Datoru centrs");
		sanemejs.setBounds(400, 220, 220, 30);
		sanemejs.setFont(new Font("Courier New",Font.BOLD, 12));
		
		vieta = new JLabel("Draudzîbas aleja 9, Jçkabpils, Latvija, LV-5201");
		vieta.setBounds(400, 240, 400, 30);
		vieta.setFont(new Font("Courier New",Font.BOLD, 12));
		
		kas = new JLabel("Iluta Ûbele, 65235131, 29422227");
		kas.setBounds(400, 260, 260, 30);
		kas.setFont(new Font("Courier New",Font.BOLD, 12));
		
		inzenieris1 = new JTextField();
		inzenieris1.setBounds(140, 315, 150, 20);
		
		piegadesveids1 = new JComboBox();
		piegadesveids1.setBounds(140, 335, 170, 20);
		
		apmaksastermins1 = new JComboBox();
		apmaksastermins1.setBounds(540, 310, 180, 25);
		
		prece1 = new JComboBox();
		prece1.setBounds(120, 380, 100, 20);
		
		serialaisnr1 = new JComboBox();
		serialaisnr1.setBounds(120, 400, 100, 20);
		
		defekts1 = new JComboBox();
		defekts1.setBounds(120, 420, 100, 20);
		
		piezimes1 = new JComboBox();
		piezimes1.setBounds(120, 440, 100, 20);
		
		bojajums1 = new JComboBox();
		bojajums1.setBounds(120, 460, 100, 20);
		
		remontadarbibas1 = new JComboBox();
		remontadarbibas1.setBounds(150, 480, 125, 20);
		
		komplektacija1 = new JComboBox();
		komplektacija1.setBounds(150, 500, 110, 20);
		
		precunosaukums1 = new JComboBox();
		precunosaukums1.setBounds(220, 560, 150, 20);
		
		daudzums1 = new JComboBox();
		daudzums1.setBounds(560, 590, 180, 30);
		
		panel.add(inzenieris);
		panel.add(piegadesveids);
		panel.add(apmaksastermins);
		panel.add(prece);
		panel.add(serialaisnr);
		panel.add(defekts);
		panel.add(piezimes);
		panel.add(bojajums);
		panel.add(remontadarbibas);
		panel.add(komplektacija);
		panel.add(izlietotiemateriali);
		panel.add(precunosaukums);
		panel.add(daudzums);
		panel.add(precusanemsanasvieta);
		panel.add(sanemejs);
		panel.add(vieta);
		panel.add(kas);
		panel.add(inzenieris1);
		panel.add(piegadesveids1);
		panel.add(apmaksastermins1);
		panel.add(prece1);
		panel.add(serialaisnr1);
		panel.add(defekts1);
		panel.add(piezimes1);
		panel.add(bojajums1);
		panel.add(remontadarbibas1);
		panel.add(komplektacija1);
		panel.add(precunosaukums1);
		panel.add(daudzums1);
		
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
