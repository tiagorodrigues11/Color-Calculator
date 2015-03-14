package main;

import hsv.HSVCalculator;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import rgb.RGBCalculator;

@SuppressWarnings("serial")
public class GeneralCalculator extends JFrame {

	private JTabbedPane tabbedPane;
	
	public GeneralCalculator() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		
		gui();
		
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void gui(){
		Container container = getContentPane();
		container.add(tabbedPane);
		
		JPanel rgbPanel = new RGBCalculator();
		JPanel hsvPanel = new HSVCalculator();
		
		tabbedPane.addTab("RGB", rgbPanel);
		tabbedPane.addTab("HSV", hsvPanel);
	}
	
	public static void main(String[] args) {
		new GeneralCalculator();
	}
	
}
