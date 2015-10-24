import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Hoang Viet t143870
 * 
 */
public class cHW02_Calculator_T143870 extends JFrame {
	boolean isAppend = false;
	int isOperator = 0; // 0 : default, 1, 2, 3, 4 -> + - * /

	// Variables a
	double aNumber = 0;
	double bNumber = 0;
	double mNumber = 0;
	double tNumber = 0;

	public static void main(String[] args) {
		cHW02_Calculator_T143870 GUI = new cHW02_Calculator_T143870();
		GUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GUI.setVisible(true);

	}

	public cHW02_Calculator_T143870() {
		/* FORM Properties */
		setTitle("My calculator - T143870");
		setSize(255, 310);
		setResizable(false);
		setLayout(null);

		/* ALL COMPONENTS */

		/* TEXT FILED */
		final JTextField txtCal = new JTextField("0");
		txtCal.setHorizontalAlignment(JTextField.RIGHT);
		txtCal.setEditable(false);
		txtCal.setBounds(10, 10, 218, 30);
		add(txtCal);

		/* BUTTONS */

		// Memories
		JButton btnMC = new JButton("MC");
		JButton btnMcong = new JButton("M+");
		JButton btnMtru = new JButton("M-");
		JButton btnMR = new JButton("MR");
		JButton btnAC = new JButton("AC");
		JButton btnCE = new JButton("CE");

		Insets iButon = new Insets(1, 1, 1, 1);

		// Memories Properties
		btnMC.setBounds(10, 50, 38, 36);
		btnMcong.setBounds(55, 50, 38, 36);
		btnMtru.setBounds(100, 50, 38, 36);
		btnMR.setBounds(145, 50, 38, 36);
		btnAC.setBounds(190, 50, 38, 36);

		btnMC.setMargin(iButon);
		btnMcong.setMargin(iButon);
		btnMtru.setMargin(iButon);
		btnMR.setMargin(iButon);
		btnAC.setMargin(iButon);

		add(btnMC);
		add(btnMcong);
		add(btnMtru);
		add(btnMR);
		add(btnAC);

		// Numbers button
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");
		JButton btn0 = new JButton("0");
		JButton btn00 = new JButton("00");

		// Button Properties
		btn7.setBounds(10, 90, 38, 36);
		btn8.setBounds(55, 90, 38, 36);
		btn9.setBounds(100, 90, 38, 36);
		btnCE.setBounds(190, 90, 38, 36);
		btn4.setBounds(10, 130, 38, 36);
		btn5.setBounds(55, 130, 38, 36);
		btn6.setBounds(100, 130, 38, 36);
		btn1.setBounds(10, 170, 38, 36);
		btn2.setBounds(55, 170, 38, 36);
		btn3.setBounds(100, 170, 38, 36);
		btn0.setBounds(10, 210, 38, 36);
		btn00.setBounds(55, 210, 38, 36);

		//
		btn4.setMargin(iButon);
		btn5.setMargin(iButon);
		btn6.setMargin(iButon);
		btn7.setMargin(iButon);
		btn8.setMargin(iButon);
		btn9.setMargin(iButon);
		btnCE.setMargin(iButon);
		btn1.setMargin(iButon);
		btn2.setMargin(iButon);
		btn3.setMargin(iButon);
		btn0.setMargin(iButon);
		btn00.setMargin(iButon);

		//
		add(btn7);
		add(btn8);
		add(btn9);
		add(btnCE);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn0);
		add(btn00);

		// Operator
		JButton btnCong = new JButton("+");
		JButton btnTru = new JButton("-");
		JButton btnNhan = new JButton("x");
		JButton btnChia = new JButton("/");
		JButton btnCongTru = new JButton("-/+");
		JButton btnCham = new JButton(".");
		JButton btnBang = new JButton("=");

		// Operator Properties
		btnCongTru.setBounds(145, 90, 38, 36);
		btnNhan.setBounds(145, 130, 38, 36);
		btnChia.setBounds(190, 130, 38, 36);
		btnTru.setBounds(190, 170, 38, 36);
		btnCham.setBounds(100, 210, 38, 36);
		btnCong.setBounds(145, 170, 38, 76);
		btnBang.setBounds(190, 210, 38, 36);

		btnCongTru.setMargin(iButon);
		btnNhan.setMargin(iButon);
		btnChia.setMargin(iButon);
		btnTru.setMargin(iButon);
		btnCham.setMargin(iButon);
		btnCong.setMargin(iButon);
		btnBang.setMargin(iButon);

		add(btnNhan);
		add(btnChia);
		add(btnCongTru);
		add(btnTru);
		add(btnCham);
		add(btnCong);
		add(btnBang);

		/* EVENTS */

		/* BUTTON NUMBER */
		ActionListener ActionNumbers = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Create variables
				String txt = txtCal.getText();
				String temp = "";

				JButton bButton = (JButton) arg0.getSource();

				// Check 0 button

				if ((bButton.getText().equals("0") == true || (bButton
						.getText().equals("00") == true))) {
					if (txt.equals("0") == true) {
						txtCal.setText("0");
						return;
					}
				}

				// Check dot Button :

				String iChar = "";
				if ((bButton.getText().equals(".") == true)) {
					// Screen is empty
					if (txt.length() == 0) {
						return;
					} else {
						for (int i = 0; i < txt.length(); i++) {
							iChar = txt.substring(i, i + 1);
							// More dot here ? No it can't
							if (iChar.equals(".") == true) {
								return;
							}
						}
					}
				}

				// The second, ... time
				if (isAppend) {

					temp = txt + bButton.getText();
				} else { // The first time ...

					temp = bButton.getText();

					isAppend = true;
				}
				txtCal.setText(temp);
			}

		};

		/* OPERATORS */
		ActionListener Operators = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Check if screen is empty
				if (txtCal.getText().length() == 0) {
					return;
				} else {
					try {
						aNumber = Double.parseDouble(txtCal.getText());
					} catch (Exception e) {
						return;
					}
				}
				JButton bButton = (JButton) arg0.getSource();
				String txt = bButton.getText();

				// -/+ button
				if (txt.equals("-/+") == true) {
					aNumber *= -1;
					String swNum = Double.toString(aNumber);
					txtCal.setText(swNum);
				} else {
					// Check operator + - * /
					if (txt.equals("+") == true) {
						isOperator = 1;
					}
					if (txt.equals("-") == true) {
						isOperator = 2;
					}
					if (txt.equals("x") == true) {
						isOperator = 3;
					}
					if (txt.equals("/") == true) {
						isOperator = 4;
					}
					isAppend = false;
					txtCal.setText("");
				}
			}
		};

		/* EQUAL OPERATOR */
		ActionListener Equal = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Create empty string
				String output = "";

				try {
					bNumber = Double.parseDouble(txtCal.getText());
				} catch (Exception e) {
					return;
				}

				// set default // no operator set
				if (isOperator == 0) {
					output = Double.toString(bNumber);
					txtCal.setText(output);
					isAppend = false;
					return;
				}

				// Set operator
				if (isOperator == 1) { // +
					aNumber += bNumber;
				}

				if (isOperator == 2) { // -
					aNumber -= bNumber;
				}

				if (isOperator == 3) { // *
					aNumber *= bNumber;
				}

				if (isOperator == 4) { // /
					aNumber /= bNumber;
				}

				output = Double.toString(aNumber);
				txtCal.setText(output);
				isAppend = false;
				isOperator = 0; // set default

			}
		};

		/* MEMORY FUNCTION */
		ActionListener Memory = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JButton bButton = (JButton) arg0.getSource();
				String txt = bButton.getText();

				if (txt.equals("MC") == true) {
					//
					mNumber = 0;
				}
				if (txt.equals("M+") == true) {
					//
					tNumber = Double.parseDouble(txtCal.getText());
					mNumber += tNumber;
					isAppend = false;
				}
				if (txt.equals("M-") == true) {

					tNumber = Double.parseDouble(txtCal.getText());
					mNumber -= tNumber;
					isAppend = false;
				}
				if (txt.equals("MR") == true) {
					String strnum = Double.toString(mNumber);
					txtCal.setText(strnum);
				}
				if (txt.equals("AC") == true) {
					//
					mNumber = 0;
					txtCal.setText("0");
					// System.out.println(mNumber);

				}
				if (txt.equals("CE") == true) {

					// // Convert String to double
					// double a = Double.parseDouble(txtCal.getText());
					//
					// // Convert Double to string
					// String c = Double.toString(a);
					//
					// // Clear last number
					// int b = c.length() - 1;
					// System.out.println(c.substring(0, b));
					//
					// txtCal.setText(c.substring(0, b));

					txtCal.setText("0");

				}

				return;

			}
		};

		/* BUTTON ACTIONS */
		btn0.addActionListener(ActionNumbers);
		btn1.addActionListener(ActionNumbers);
		btn2.addActionListener(ActionNumbers);
		btn3.addActionListener(ActionNumbers);
		btn4.addActionListener(ActionNumbers);
		btn5.addActionListener(ActionNumbers);
		btn6.addActionListener(ActionNumbers);
		btn7.addActionListener(ActionNumbers);
		btn8.addActionListener(ActionNumbers);
		btn9.addActionListener(ActionNumbers);
		btn00.addActionListener(ActionNumbers);
		btnCham.addActionListener(ActionNumbers);
		btnCong.addActionListener(Operators);
		btnTru.addActionListener(Operators);
		btnNhan.addActionListener(Operators);
		btnChia.addActionListener(Operators);
		btnCongTru.addActionListener(Operators);
		btnBang.addActionListener(Equal);
		btnAC.addActionListener(Memory);
		btnMC.addActionListener(Memory);
		btnMcong.addActionListener(Memory);
		btnMtru.addActionListener(Memory);
		btnMR.addActionListener(Memory);
		btnCE.addActionListener(Memory);

	}

}
