package hsv;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class HSVCalculator extends JPanel {

	private JLabel hLabel;
	private JLabel sLabel;
	private JLabel vLabel;
	private JLabel rLabel;
	private JLabel gLabel;
	private JLabel bLabel;
	private JTextField hTextField;
	private JTextField sTextField;
	private JTextField vTextField;
	private JTextField rTextField;
	private JTextField gTextField;
	private JTextField bTextField;
	private JTextArea colorArea;
	private JButton calculateButton;
	private Border border;
	
	public HSVCalculator() {
		border = BorderFactory.createLineBorder(Color.BLACK);
		
		setLayout(new BorderLayout());
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2,1));
		
		JPanel hsvPanel = new JPanel();
		hsvPanel.setLayout(new GridLayout(3, 1));
		hsvPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		hLabel = new JLabel("H: ");
		hTextField = new JTextField();
		hsvPanel.add(hLabel);
		hsvPanel.add(hTextField);
		
		sLabel = new JLabel("S: ");
		sTextField = new JTextField();
		hsvPanel.add(sLabel);
		hsvPanel.add(sTextField);
		
		vLabel = new JLabel("V: ");
		vTextField = new JTextField();
		hsvPanel.add(vLabel);
		hsvPanel.add(vTextField);
		
		inputPanel.add(hsvPanel);
		
		JPanel rgbPanel = new JPanel();
		rgbPanel.setLayout(new GridLayout(3, 1));
		rgbPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		rLabel = new JLabel("R: ");
		rTextField = new JTextField();
		rTextField.setEditable(false);
		rgbPanel.add(rLabel);
		rgbPanel.add(rTextField);
		
		gLabel = new JLabel("G: ");
		gTextField = new JTextField();
		gTextField.setEditable(false);
		rgbPanel.add(gLabel);
		rgbPanel.add(gTextField);
		
		bLabel = new JLabel("B: ");
		bTextField = new JTextField();
		bTextField.setEditable(false);
		rgbPanel.add(bLabel);
		rgbPanel.add(bTextField);
		
		inputPanel.add(rgbPanel);
		
		add(inputPanel);
		
		colorArea = new JTextArea(12,8);
		colorArea.setEditable(false);
		colorArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		add(colorArea, BorderLayout.EAST);
		
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!hTextField.getText().isEmpty() && !sTextField.getText().isEmpty() && !vTextField.getText().isEmpty()){
					int rgb = Color.HSBtoRGB(Float.valueOf(hTextField.getText())/360, Float.valueOf(sTextField.getText())/100, Float.valueOf(vTextField.getText())/100);
					Color color = new Color(rgb);
					
					colorArea.setBackground(color);
					
					rTextField.setText(String.valueOf(color.getRed()));
					gTextField.setText(String.valueOf(color.getGreen()));
					bTextField.setText(String.valueOf(color.getBlue()));
					
				}
				
			}
		});
		add(calculateButton, BorderLayout.SOUTH);
		
	}
	
}
