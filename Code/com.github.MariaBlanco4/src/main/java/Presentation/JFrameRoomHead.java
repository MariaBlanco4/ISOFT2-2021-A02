package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Domain.ReserveAgent;
import Domain.State;
import Domain.Turn;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameRoomHead extends JFrame {

	private JPanel contentPane;
	private JTextField txtfTable;
	private JTextField txtfDate;
	private JTextField txtfTurn;
	private JTextField txtfHour;
	private JTextField txtfChairs;
	private JLabel lblState;
	Turn turn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameRoomHead frame = new JFrameRoomHead();
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
	public JFrameRoomHead() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblState = new JLabel("");
		contentPane.add(lblState, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(358, 181, 70, 15);
		panel.add(lblDate);
		
		JLabel lblTable = new JLabel("Table:");
		lblTable.setBounds(358, 142, 70, 15);
		panel.add(lblTable);
		
		JLabel lblTurn = new JLabel("Turn:");
		lblTurn.setBounds(358, 223, 70, 15);
		panel.add(lblTurn);
		
		JLabel lblHour = new JLabel("Hour:");
		lblHour.setBounds(358, 262, 70, 15);
		panel.add(lblHour);
		
		JLabel lblReservation = new JLabel("BOOKING TABLE\n");
		lblReservation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblReservation.setBounds(426, 66, 229, 27);
		panel.add(lblReservation);
		
		txtfTable = new JTextField();
		txtfTable.setBounds(441, 140, 114, 19);
		panel.add(txtfTable);
		txtfTable.setColumns(10);
		
		txtfDate = new JTextField();
		txtfDate.setBounds(441, 179, 114, 19);
		panel.add(txtfDate);
		txtfDate.setColumns(10);
		
		txtfTurn = new JTextField();
		txtfTurn.setBounds(441, 221, 114, 19);
		panel.add(txtfTurn);
		txtfTurn.setColumns(10);
		
		txtfHour = new JTextField();
		txtfHour.setBounds(441, 260, 114, 19);
		panel.add(txtfHour);
		txtfHour.setColumns(10);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReserve.setBounds(562, 353, 117, 25);
		panel.add(btnReserve);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtfTable.setText("");
				txtfDate.setText("");
				txtfTurn.setText("");
				txtfHour.setText("");
				txtfChairs.setText("");
				lblState.setText("");
			}
		});
		btnClear.setBounds(285, 353, 117, 25);
		panel.add(btnClear);
		
		JLabel lblChairs = new JLabel("Chairs:");
		lblChairs.setBounds(347, 302, 70, 15);
		panel.add(lblChairs);
		
		txtfChairs = new JTextField();
		txtfChairs.setBounds(441, 300, 114, 19);
		panel.add(txtfChairs);
		txtfChairs.setColumns(10);
	}

	
	public void reserve() {
		
		if(txtfTurn.getText() == "F_Lunch") {
			turn = Turn.F_Lunch;
		}else if(txtfTurn.getText() == "S_Lunch") {
			turn = Turn.S_Lunch;
		}else if(txtfTurn.getText() == "T_Lunch") {
			turn = Turn.T_Lunch;
		}else if(txtfTurn.getText() == "F_Dinner") {
			turn = Turn.F_Dinner;
		}else if(txtfTurn.getText() == "S_Dinner") {
			turn = Turn.S_Dinner;
		}else if(txtfTurn.getText() == "T_Dinner") {
			turn = Turn.T_Dinner;
		}
		boolean result = ReserveAgent.generate_reserve(turn, txtfChairs.getText(), txtfHour.getText(), txtfDate.getText(), txtfTable.getText(), hour);
		if(result == false) {
			lblState.setText("Algun error no se bro xd");
		}else {
			lblState.setText("Reserve done");
		}
		throw new UnsupportedOperationException();
	}

	public void check() {
		
		throw new UnsupportedOperationException();
	}

	public void change() {
		boolean result = ReserveAgent.changeState(Integer.parseInt(txtfTable.getText()), State.Reserved);
		if(result == false) {
			lblState.setText("Error changing the state");
		}else {
			lblState.setText("State changed");
		}
		throw new UnsupportedOperationException();
	}

	public void setWaiter() {
		// TODO - implement JFrameRoomHead.setWaiter
		throw new UnsupportedOperationException();
	}

	public void getWaiter() {
		String [] waiters = ReserveAgent.getWaiter("Waiter");
		throw new UnsupportedOperationException();
	}
}
