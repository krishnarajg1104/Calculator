 package Calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator implements ActionListener{
	JFrame frame;
	JTextField textField;
	JPanel panel;
	JButton[] numBtn = new JButton[10];
	JButton[] funBtn = new JButton[10];
	JButton addBtn, subBtn, mulBtn, divBtn, equBtn, bsBtn, clrBtn, dotBtn, opnBtn, clsBtn;
	
	Font font = new Font("verdana", Font.BOLD, 30);
	Color bCol = new Color(245, 245, 245);
	Color fCol = new Color(50, 50, 50);
	
	double n1=0, n2=0, res=0;
	char op;
	Calculator(){	
	frame = new JFrame("Calculator");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(420, 550);
	frame.setLayout(null);
	
	textField = new JTextField();
	textField.setBounds(50, 25, 300, 50);
	textField.setFont(font);
	textField.setEditable(false);
	
	addBtn = new JButton("+");
	subBtn = new JButton("-");
	mulBtn = new JButton("*");
	divBtn = new JButton("/");
	dotBtn = new JButton(".");
	bsBtn = new JButton("B");
	clrBtn = new JButton("C");
	opnBtn = new JButton("(");
	clsBtn = new JButton(")");
	equBtn = new JButton("=");
	
	equBtn.setBackground(new Color(0, 0, 128));
	equBtn.setForeground(Color.white);
	
	funBtn[0] = addBtn;
	funBtn[1] = subBtn;
	funBtn[2] = mulBtn;
	funBtn[3] = divBtn;
	funBtn[4] = equBtn;
	funBtn[5] = dotBtn;
	funBtn[6] = opnBtn;
	funBtn[7] = clsBtn;
	funBtn[8] = bsBtn;
	funBtn[9] = clrBtn;
	
	for (int i=0; i<10; i++) {
		funBtn[i].addActionListener(this);
		funBtn[i].setFont(font);
		funBtn[i].setFocusable(false);
	}
	
	for (int i=0; i<10; i++) {
		numBtn[i] = new JButton(String.valueOf(i));
		numBtn[i].addActionListener(this);
		numBtn[i].setFont(font);
		numBtn[i].setFocusable(false);
	}
	
	panel = new JPanel();
	panel.setBounds(50, 80, 300, 420);
	panel.setLayout(new GridLayout(5, 4, 10, 10));
	panel.setBackground(new Color(112, 128, 144));
	
	panel.add(opnBtn);
	panel.add(clsBtn);
	panel.add(bsBtn);
	panel.add(clrBtn);
	
	panel.add(numBtn[7]);
	panel.add(numBtn[8]);
	panel.add(numBtn[9]);
	panel.add(divBtn);
	
	panel.add(numBtn[4]);
	panel.add(numBtn[5]);
	panel.add(numBtn[6]);
	panel.add(mulBtn);
	
	panel.add(numBtn[1]);
	panel.add(numBtn[2]);
	panel.add(numBtn[3]);
	panel.add(subBtn);
	
	panel.add(dotBtn);
	panel.add(numBtn[0]);
	panel.add(addBtn);
	panel.add(equBtn);
	
	frame.add(panel);
	frame.add(textField);
	frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i=0; i<10; i++) {
			if(e.getSource() == numBtn[i]) {
				textField.setText(textField.getText() + String.valueOf(i));
			}
		}
		if(e.getSource() == dotBtn) {
			textField.setText(textField.getText() + ".");
		}
		if(e.getSource() == clrBtn) {
			textField.setText(null);
		}
		if(e.getSource() == bsBtn) {
			String sr = textField.getText();
			textField.setText("");
			for (int i=0; i<sr.length()-1; i++) {
				textField.setText(textField.getText() + sr.charAt(i));
			}
		}
		
		if (e.getSource() == addBtn) {
			n1 = Double.parseDouble(textField.getText());
			op = '+';
			textField.setText("");
		}
		if (e.getSource() == subBtn) {
			n1 = Double.parseDouble(textField.getText());
			op = '-';
			textField.setText("");
		}
		if (e.getSource() == mulBtn) {
			n1 = Double.parseDouble(textField.getText());
			op = '*';
			textField.setText("");
		}
		if (e.getSource() == divBtn) {
			n1 = Double.parseDouble(textField.getText());
			op = '/';
			textField.setText("");
		}
		if (e.getSource() == equBtn) {
			n2 = Double.parseDouble(textField.getText());
			
			switch (op) {
			case '+':
				res = n1+n2;
				textField.setText(String.valueOf(res));
			break;
			case '-':
			res = n1-n2;
			textField.setText(String.valueOf(res));
			break;
			case '*':
				res = n1*n2;
				textField.setText(String.valueOf(res));
			break;
			case '/':
				res = n1/n2;
				textField.setText(String.valueOf(res));
			break;
			}
		}
		
	}
}
