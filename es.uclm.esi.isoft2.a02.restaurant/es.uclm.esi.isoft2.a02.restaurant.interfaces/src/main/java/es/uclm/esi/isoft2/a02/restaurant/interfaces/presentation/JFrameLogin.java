package es.uclm.esi.isoft2.a02.restaurant.interfaces.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.User;
import es.uclm.esi.isoft2.a02.restaurant.table_booking.domain.LoginAgent;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtfId;
	private JTextField txtfName;
	private JTextField txtfPosition;
	private JLabel lblState;
	private static JFrameLogin frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblState = new JLabel();
		contentPane.add(lblState, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(635, 241, 26, 15);
		panel.add(lblId);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(613, 305, 70, 15);
		panel.add(lblName);

		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(601, 368, 70, 15);
		panel.add(lblPosition);

		txtfId = new JTextField();
		txtfId.setBounds(701, 239, 114, 19);
		panel.add(txtfId);
		txtfId.setColumns(10);

		txtfName = new JTextField();
		txtfName.setBounds(701, 303, 114, 19);
		panel.add(txtfName);
		txtfName.setColumns(10);

		txtfPosition = new JTextField();
		txtfPosition.setBounds(701, 366, 114, 19);
		panel.add(txtfPosition);
		txtfPosition.setColumns(10);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblLogin.setBounds(720, 150, 70, 24);
		panel.add(lblLogin);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtfId.getText().length() == 0 || txtfName.getText().length() == 0 || txtfPosition.getText().length() == 0) {
					lblState.setText("You must fill all the fields.");
					return;
				}
				try {
					login();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnEnter.setBounds(844, 490, 117, 25);
		panel.add(btnEnter);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtfId.setText("");
				txtfName.setText("");
				txtfPosition.setText("");
				lblState.setText("");
			}
		});
		btnClear.setBounds(535, 490, 117, 25);
		panel.add(btnClear);
	}

	public void login() throws NumberFormatException, SQLException, Exception {
		User user = LoginAgent.VerifyLogin(Integer.parseInt(txtfId.getText()), txtfName.getText(),
				txtfPosition.getText());
		if (user == null) {
			lblState.setText("Introduce again");
		} else {
			lblState.setText("Login success");
			if (user.getPosition().equalsIgnoreCase("room head")) {
				JFrameRoomHead rh = new JFrameRoomHead();
				rh.show();
				frame.dispose();
			}else if(user.getPosition().equalsIgnoreCase("waiter")) {
				JFrameTakeOrder tk = new JFrameTakeOrder(user);
				tk.show();
				frame.dispose();
			}
		}
	}
}