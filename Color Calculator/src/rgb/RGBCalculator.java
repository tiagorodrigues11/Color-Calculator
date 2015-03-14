package rgb;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class RGBCalculator extends JPanel {

	private JLabel rLabel;
	private JLabel gLabel;
	private JLabel bLabel;
	private JLabel hLabel;
	private JLabel sLabel;
	private JLabel vLabel;
	private JTextField rTextField;
	private JTextField gTextField;
	private JTextField bTextField;
	private JTextField hTextField;
	private JTextField sTextField;
	private JTextField vTextField;
	private JTextArea colorArea;
	private JButton calculateButton;
	private Border border;
	
	public RGBCalculator() {
		border = BorderFactory.createLineBorder(Color.BLACK);
		
		setLayout(new BorderLayout());
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2,1));
		
		JPanel rgbPanel = new JPanel();
		rgbPanel.setLayout(new GridLayout(3, 1));
		rgbPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		rLabel = new JLabel("R: ");
		rTextField = new JTextField();
		rgbPanel.add(rLabel);
		rgbPanel.add(rTextField);
		
		gLabel = new JLabel("G: ");
		gTextField = new JTextField();
		rgbPanel.add(gLabel);
		rgbPanel.add(gTextField);
		
		bLabel = new JLabel("B: ");
		bTextField = new JTextField();
		rgbPanel.add(bLabel);
		rgbPanel.add(bTextField);
		
		inputPanel.add(rgbPanel);
		
		JPanel hsvPanel = new JPanel();
		hsvPanel.setLayout(new GridLayout(3, 1));
		hsvPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		hLabel = new JLabel("H: ");
		hTextField = new JTextField();
		hTextField.setEditable(false);
		hsvPanel.add(hLabel);
		hsvPanel.add(hTextField);
		
		sLabel = new JLabel("S: ");
		sTextField = new JTextField();
		sTextField.setEditable(false);
		hsvPanel.add(sLabel);
		hsvPanel.add(sTextField);
		
		vLabel = new JLabel("V: ");
		vTextField = new JTextField();
		vTextField.setEditable(false);
		hsvPanel.add(vLabel);
		hsvPanel.add(vTextField);
		
		inputPanel.add(hsvPanel);
		
		add(inputPanel);
		
		colorArea = new JTextArea(12,8);
		colorArea.setEditable(false);
		colorArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		add(colorArea, BorderLayout.EAST);
		
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!rTextField.getText().isEmpty() && !gTextField.getText().isEmpty() && !bTextField.getText().isEmpty()){
					int red = Integer.valueOf(rTextField.getText());
					int green = Integer.valueOf(gTextField.getText());
					int blue = Integer.valueOf(bTextField.getText());
					
					colorArea.setBackground(new Color(red, green, blue));
					
					float[] hsv = new float[3];
					Color.RGBtoHSB(red, green, blue, hsv);
			        
					DecimalFormat df = new DecimalFormat("#.0"); 
					
					double h = Math.round(hsv[0]*360);
			        double s = Double.valueOf(df.format(hsv[1]*100));
			        double v = Double.valueOf(df.format(hsv[2]*100));
					
					hTextField.setText(String.valueOf(h));
					sTextField.setText(String.valueOf(s));
					vTextField.setText(String.valueOf(v));
					
				}
				
			}
		});
		add(calculateButton, BorderLayout.SOUTH);
		
	}
	
}
