package common;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoanCalculator {

	private JFrame frame;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoanCalculator window = new LoanCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoanCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("LOAN CALCULATOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 414, 23);
		frame.getContentPane().add(lblNewLabel);

		txt1 = new JTextField();
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setBounds(225, 61, 104, 20);
		frame.getContentPane().add(txt1);
		txt1.setColumns(10);
		txt1.setText("0");

		txt2 = new JTextField();
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setBounds(225, 92, 104, 20);
		frame.getContentPane().add(txt2);
		txt2.setColumns(10);
		txt2.setText("0");

		txt3 = new JTextField();
		txt3.setHorizontalAlignment(SwingConstants.CENTER);
		txt3.setBounds(225, 124, 104, 20);
		frame.getContentPane().add(txt3);
		txt3.setColumns(10);
		txt3.setText("0");

		JLabel lblNewLabel_1 = new JLabel("Loan amount");
		lblNewLabel_1.setBounds(37, 64, 154, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Interest rate in %");
		lblNewLabel_2.setBounds(37, 95, 154, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Period in years");
		lblNewLabel_3.setBounds(37, 127, 154, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JComboBox cbx1 = new JComboBox();
		cbx1.setBounds(225, 155, 104, 20);
		frame.getContentPane().add(cbx1);
		cbx1.addItem("Equal");
		cbx1.addItem("Decreasing");

		JLabel lblNewLabel_4 = new JLabel("Kind of installment");
		lblNewLabel_4.setBounds(37, 158, 154, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JButton btn1 = new JButton("COUNT");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				double amount = Double.parseDouble(txt1.getText());
				double rate = 1 + (((Double.parseDouble(txt2.getText())) / 12) / 100);
				double period = Double.parseDouble(txt3.getText()) * 12;

				if (amount == 0 | rate == 0 | period == 0) {
					JOptionPane.showMessageDialog(frame, "Please enter data.", "Loan Calculator",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (cbx1.getSelectedItem() == "Equal") {
					double equalInstallment = Math
							.round(amount * (Math.pow(rate, period)) * ((rate - 1) / (Math.pow(rate, period) - 1)));

					JOptionPane.showMessageDialog(frame, "Amount of installment will be  " + equalInstallment + " z³",
							"Loan calculator", JOptionPane.INFORMATION_MESSAGE);
				} else {
					double firstInstallment = Math.round((amount / period) * (1 + (period - 1 + 1) * (rate - 1)));

					double lastInstallment = Math.round(((amount / period) * (1 + (period - period + 1) * (rate - 1))));

					JOptionPane.showMessageDialog(frame,
							"Amount of the first installment:  " + firstInstallment + "\n"
									+ "Amount of the last installment: " + lastInstallment,
							"Loan calculator", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setBounds(161, 208, 104, 43);
		frame.getContentPane().add(btn1);

	}
}
