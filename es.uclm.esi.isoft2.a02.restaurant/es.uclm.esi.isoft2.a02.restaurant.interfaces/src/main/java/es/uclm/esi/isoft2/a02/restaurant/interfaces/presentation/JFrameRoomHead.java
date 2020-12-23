package es.uclm.esi.isoft2.a02.restaurant.interfaces.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Control_operational_table;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.State;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn;
import es.uclm.esi.isoft2.a02.restaurant.table_booking.domain.ReserveAgent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.lang.NumberFormatException;

public class JFrameRoomHead extends JFrame {

	private JPanel contentPane;
	private JTextField txtfTableReserve;
	private JTextField txtfDateCheck;
	private JLabel lblState;
	Turn turn;
	Timer timer;
	String tableCancelled;
	String turnCancelled;
	String dateCancelled;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtfDateReserve;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private JTextField txtfDateWaiter;
	private JTextField txtfTableWaiter;
	private JTextField txtfWaiterWaiter;
	private JTextField txtfDateState;
	private JTextField txtfTableState;
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();

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
		
		JLabel lblDateCheck = new JLabel("Date:");
		lblDateCheck.setBounds(60, 142, 70, 15);
		panel.add(lblDateCheck);
		
		JLabel lblTableReserve = new JLabel("Table:");
		lblTableReserve.setBounds(953, 285, 70, 15);
		panel.add(lblTableReserve);
		
		JLabel lblTurnCheck = new JLabel("Turn:");
		lblTurnCheck.setBounds(261, 142, 70, 15);
		panel.add(lblTurnCheck);
		
		JLabel lblReservation = new JLabel("BOOKING TABLE\n");
		lblReservation.setFont(new Font("Dialog", Font.BOLD, 20));
		lblReservation.setBounds(500, 38, 229, 27);
		panel.add(lblReservation);
		
		txtfTableReserve = new JTextField();
		txtfTableReserve.setBounds(1011, 283, 114, 19);
		panel.add(txtfTableReserve);
		txtfTableReserve.setColumns(10);
		
		txtfDateCheck = new JTextField();
		txtfDateCheck.setBounds(121, 140, 114, 19);
		panel.add(txtfDateCheck);
		txtfDateCheck.setColumns(10);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reserve();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnReserve.setBounds(1175, 280, 117, 25);
		panel.add(btnReserve);
		
		
		
		
		JLabel lblChairsCheck = new JLabel("Chairs:");
		lblChairsCheck.setBounds(686, 142, 70, 15);
		panel.add(lblChairsCheck);
		
		JRadioButton rdbtn2chairsCheck = new JRadioButton("2");
		rdbtn2chairsCheck.setActionCommand("2");
		buttonGroup.add(rdbtn2chairsCheck);
		rdbtn2chairsCheck.setBounds(770, 138, 47, 23);
		panel.add(rdbtn2chairsCheck);
		
		JRadioButton rdbtn4chairsCheck = new JRadioButton("4");
		rdbtn4chairsCheck.setActionCommand("4");
		buttonGroup.add(rdbtn4chairsCheck);
		rdbtn4chairsCheck.setBounds(819, 138, 47, 23);
		panel.add(rdbtn4chairsCheck);
		
		JRadioButton rdbtn6chairsCheck = new JRadioButton("6");
		rdbtn6chairsCheck.setActionCommand("6");
		buttonGroup.add(rdbtn6chairsCheck);
		rdbtn6chairsCheck.setBounds(870, 138, 47, 23);
		panel.add(rdbtn6chairsCheck);
		
		JRadioButton rdbtnFlunchCheck = new JRadioButton("F_Lunch");
		rdbtnFlunchCheck.setActionCommand("F_Lunch");
		buttonGroup_1.add(rdbtnFlunchCheck);
		rdbtnFlunchCheck.setBounds(325, 118, 93, 23);
		panel.add(rdbtnFlunchCheck);
		
		JRadioButton rdbtnFdinnerCheck = new JRadioButton("F_Dinner");
		rdbtnFdinnerCheck.setActionCommand("F_Dinner");
		buttonGroup_1.add(rdbtnFdinnerCheck);
		rdbtnFdinnerCheck.setBounds(331, 151, 101, 23);
		panel.add(rdbtnFdinnerCheck);
		
		JRadioButton rdbtnSlunchCheck = new JRadioButton("S_Lunch");
		rdbtnSlunchCheck.setActionCommand("S_Lunch");
		buttonGroup_1.add(rdbtnSlunchCheck);
		rdbtnSlunchCheck.setBounds(440, 118, 101, 23);
		panel.add(rdbtnSlunchCheck);
		
		JRadioButton rdbtnSdinnerCheck = new JRadioButton("S_Dinner");
		rdbtnSdinnerCheck.setActionCommand("S_Dinner");
		buttonGroup_1.add(rdbtnSdinnerCheck);
		rdbtnSdinnerCheck.setBounds(440, 151, 105, 23);
		panel.add(rdbtnSdinnerCheck);
		
		JRadioButton rdbtnTlunchCheck = new JRadioButton("T_Lunch");
		rdbtnTlunchCheck.setActionCommand("T_Lunch");
		buttonGroup_1.add(rdbtnTlunchCheck);
		rdbtnTlunchCheck.setBounds(544, 118, 149, 23);
		panel.add(rdbtnTlunchCheck);
		
		JRadioButton rdbtnTdinnerCheck = new JRadioButton("T_Dinner");
		rdbtnTdinnerCheck.setActionCommand("T_Dinner");
		buttonGroup_1.add(rdbtnTdinnerCheck);
		rdbtnTdinnerCheck.setBounds(545, 151, 101, 23);
		panel.add(rdbtnTdinnerCheck);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtfDateCheck.setText("");
				txtfDateReserve.setText("");
				txtfTableReserve.setText("");
				txtfDateWaiter.setText("");
				txtfTableWaiter.setText("");
				txtfWaiterWaiter.setText("");
				txtfDateState.setText("");
				txtfTableState.setText("");
				
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
				buttonGroup_3.clearSelection();
				buttonGroup_4.clearSelection();
				buttonGroup_5.clearSelection();
				buttonGroup_6.clearSelection();
			}
		});
		btnClear.setBounds(576, 734, 117, 25);
		panel.add(btnClear);
		
		JButton btnCheckTable = new JButton("Check table\n");
		btnCheckTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					check();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCheckTable.setBounds(943, 137, 117, 25);
		panel.add(btnCheckTable);
		
		JLabel lblDateReserve = new JLabel("Date");
		lblDateReserve.setBounds(60, 285, 70, 15);
		panel.add(lblDateReserve);
		
		txtfDateReserve = new JTextField();
		txtfDateReserve.setBounds(121, 283, 114, 19);
		panel.add(txtfDateReserve);
		txtfDateReserve.setColumns(10);
		
		JLabel lblTurnReserve = new JLabel("Turn:");
		lblTurnReserve.setBounds(261, 285, 70, 15);
		panel.add(lblTurnReserve);
		
		JRadioButton rdbtnFlunchReserve = new JRadioButton("F_Lunch");
		rdbtnFlunchReserve.setActionCommand("F_Lunch");
		buttonGroup_3.add(rdbtnFlunchReserve);
		rdbtnFlunchReserve.setBounds(331, 264, 101, 23);
		panel.add(rdbtnFlunchReserve);
		
		JRadioButton rdbtnFdinnerReserve = new JRadioButton("F_Dinner");
		rdbtnFdinnerReserve.setActionCommand("F_Dinner");
		buttonGroup_3.add(rdbtnFdinnerReserve);
		rdbtnFdinnerReserve.setBounds(331, 291, 97, 23);
		panel.add(rdbtnFdinnerReserve);
		
		JRadioButton rdbtnSlunchReserve = new JRadioButton("S_Lunch");
		rdbtnSlunchReserve.setActionCommand("S_Lunch");
		buttonGroup_3.add(rdbtnSlunchReserve);
		rdbtnSlunchReserve.setBounds(440, 264, 101, 23);
		panel.add(rdbtnSlunchReserve);
		
		JRadioButton rdbtnSdinnerReserve = new JRadioButton("S_Dinner");
		rdbtnSdinnerReserve.setActionCommand("S_Dinner");
		buttonGroup_3.add(rdbtnSdinnerReserve);
		rdbtnSdinnerReserve.setBounds(440, 291, 101, 23);
		panel.add(rdbtnSdinnerReserve);
		
		JRadioButton rdbtnTlunchReserve = new JRadioButton("T_Lunch");
		rdbtnTlunchReserve.setActionCommand("T_Lunch");
		buttonGroup_3.add(rdbtnTlunchReserve);
		rdbtnTlunchReserve.setBounds(544, 264, 93, 23);
		panel.add(rdbtnTlunchReserve);
		
		JRadioButton rdbtnTdinnerReserve = new JRadioButton("T_Dinner");
		rdbtnTdinnerReserve.setActionCommand("T_Dinner");
		buttonGroup_3.add(rdbtnTdinnerReserve);
		rdbtnTdinnerReserve.setBounds(544, 291, 105, 23);
		panel.add(rdbtnTdinnerReserve);
		
		JLabel lblChairsReserve = new JLabel("Chairs:");
		lblChairsReserve.setBounds(686, 285, 70, 15);
		panel.add(lblChairsReserve);
		
		JRadioButton rdbtn2chairsReserve = new JRadioButton("2");
		rdbtn2chairsReserve.setActionCommand("2");
		buttonGroup_2.add(rdbtn2chairsReserve);
		rdbtn2chairsReserve.setBounds(763, 281, 54, 23);
		panel.add(rdbtn2chairsReserve);
		
		JRadioButton rdbtn4chairsReserve = new JRadioButton("4");
		rdbtn4chairsReserve.setActionCommand("4");
		buttonGroup_2.add(rdbtn4chairsReserve);
		rdbtn4chairsReserve.setBounds(819, 281, 47, 23);
		panel.add(rdbtn4chairsReserve);
		
		JRadioButton rdbtn6chairsReserve = new JRadioButton("6");
		rdbtn6chairsReserve.setActionCommand("6");
		buttonGroup_2.add(rdbtn6chairsReserve);
		rdbtn6chairsReserve.setBounds(873, 281, 54, 23);
		panel.add(rdbtn6chairsReserve);
		
		JLabel lblDateWaiter = new JLabel("Date:");
		lblDateWaiter.setBounds(60, 419, 70, 15);
		panel.add(lblDateWaiter);
		
		txtfDateWaiter = new JTextField();
		txtfDateWaiter.setBounds(121, 417, 114, 19);
		panel.add(txtfDateWaiter);
		txtfDateWaiter.setColumns(10);
		
		JLabel lblTurnWaiter = new JLabel("Turn:");
		lblTurnWaiter.setBounds(261, 419, 70, 15);
		panel.add(lblTurnWaiter);
		
		JRadioButton rdbtnFlunchWaiter = new JRadioButton("F_Lunch");
		rdbtnFlunchWaiter.setActionCommand("F_Lunch");
		buttonGroup_4.add(rdbtnFlunchWaiter);
		rdbtnFlunchWaiter.setBounds(325, 398, 93, 23);
		panel.add(rdbtnFlunchWaiter);
		
		JRadioButton rdbtnFdinnerWaiter = new JRadioButton("F_Dinner");
		rdbtnFdinnerWaiter.setActionCommand("F_Dinner");
		buttonGroup_4.add(rdbtnFdinnerWaiter);
		rdbtnFdinnerWaiter.setBounds(325, 425, 93, 23);
		panel.add(rdbtnFdinnerWaiter);
		
		JRadioButton rdbtnSlunchWaiter = new JRadioButton("S_Lunch");
		rdbtnSlunchWaiter.setActionCommand("S_Lunch");
		buttonGroup_4.add(rdbtnSlunchWaiter);
		rdbtnSlunchWaiter.setBounds(440, 398, 101, 23);
		panel.add(rdbtnSlunchWaiter);
		
		JRadioButton rdbtnSdinnerWaiter = new JRadioButton("S_Dinner");
		rdbtnSdinnerWaiter.setActionCommand("S_Dinner");
		buttonGroup_4.add(rdbtnSdinnerWaiter);
		rdbtnSdinnerWaiter.setBounds(440, 425, 101, 23);
		panel.add(rdbtnSdinnerWaiter);
		
		JRadioButton rdbtnTlunchWaiter = new JRadioButton("T_Lunch");
		rdbtnTlunchWaiter.setActionCommand("T_Lunch");
		buttonGroup_4.add(rdbtnTlunchWaiter);
		rdbtnTlunchWaiter.setBounds(544, 398, 93, 23);
		panel.add(rdbtnTlunchWaiter);
		
		JRadioButton rdbtnTdinnerWaiter = new JRadioButton("T_Dinner");
		rdbtnTdinnerWaiter.setActionCommand("T_Dinner");
		buttonGroup_4.add(rdbtnTdinnerWaiter);
		rdbtnTdinnerWaiter.setBounds(544, 425, 93, 23);
		panel.add(rdbtnTdinnerWaiter);
		
		JLabel lblTableWaiter = new JLabel("Table:");
		lblTableWaiter.setBounds(686, 419, 70, 15);
		panel.add(lblTableWaiter);
		
		txtfTableWaiter = new JTextField();
		txtfTableWaiter.setBounds(752, 417, 114, 19);
		panel.add(txtfTableWaiter);
		txtfTableWaiter.setColumns(10);
		
		JLabel lblWaiterWaiter = new JLabel("Waiter:");
		lblWaiterWaiter.setBounds(953, 419, 70, 15);
		panel.add(lblWaiterWaiter);
		
		txtfWaiterWaiter = new JTextField();
		txtfWaiterWaiter.setBounds(1011, 417, 114, 19);
		panel.add(txtfWaiterWaiter);
		txtfWaiterWaiter.setColumns(10);
		
		JButton btnCheckWaiters = new JButton("Check waiters");
		btnCheckWaiters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getWaiter();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCheckWaiters.setBounds(1175, 397, 157, 25);
		panel.add(btnCheckWaiters);
		
		JButton btnSetWaiter = new JButton("Set waiter");
		btnSetWaiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setWaiter();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSetWaiter.setBounds(1175, 437, 157, 25);
		panel.add(btnSetWaiter);
		
		JLabel lblDateState = new JLabel("Date:");
		lblDateState.setBounds(60, 578, 70, 15);
		panel.add(lblDateState);
		
		txtfDateState = new JTextField();
		txtfDateState.setBounds(121, 576, 114, 19);
		panel.add(txtfDateState);
		txtfDateState.setColumns(10);
		
		JLabel lblTurnState = new JLabel("Turn:");
		lblTurnState.setBounds(261, 578, 70, 15);
		panel.add(lblTurnState);
		
		JRadioButton rdbtnFlunchState = new JRadioButton("F_Lunch");
		rdbtnFlunchState.setActionCommand("F_Lunch");
		buttonGroup_5.add(rdbtnFlunchState);
		rdbtnFlunchState.setBounds(325, 558, 93, 23);
		panel.add(rdbtnFlunchState);
		
		JRadioButton rdbtnFdinnerState = new JRadioButton("F_Dinner");
		rdbtnFdinnerState.setActionCommand("F_Dinner");
		buttonGroup_5.add(rdbtnFdinnerState);
		rdbtnFdinnerState.setBounds(325, 585, 101, 23);
		panel.add(rdbtnFdinnerState);
		
		JRadioButton rdbtnSlunchState = new JRadioButton("S_Lunch");
		rdbtnSlunchState.setActionCommand("S_Lunch");
		buttonGroup_5.add(rdbtnSlunchState);
		rdbtnSlunchState.setBounds(440, 558, 93, 23);
		panel.add(rdbtnSlunchState);
		
		JRadioButton rdbtnSdinnerState = new JRadioButton("S_Dinner");
		rdbtnSdinnerState.setActionCommand("S_Dinner");
		buttonGroup_5.add(rdbtnSdinnerState);
		rdbtnSdinnerState.setBounds(440, 585, 101, 23);
		panel.add(rdbtnSdinnerState);
		
		JRadioButton rdbtnTlunchState = new JRadioButton("T_Lunch");
		rdbtnTlunchState.setActionCommand("T_Lunch");
		buttonGroup_5.add(rdbtnTlunchState);
		rdbtnTlunchState.setBounds(544, 558, 93, 23);
		panel.add(rdbtnTlunchState);
		
		JRadioButton rdbtnTdinnerState = new JRadioButton("T_Dinner");
		rdbtnTdinnerState.setActionCommand("T_Dinner");
		buttonGroup_5.add(rdbtnTdinnerState);
		rdbtnTdinnerState.setBounds(544, 585, 101, 23);
		panel.add(rdbtnTdinnerState);
		
		JLabel lblTableState = new JLabel("Table:");
		lblTableState.setBounds(686, 578, 70, 15);
		panel.add(lblTableState);
		
		txtfTableState = new JTextField();
		txtfTableState.setBounds(752, 576, 114, 19);
		panel.add(txtfTableState);
		txtfTableState.setColumns(10);
		
		JLabel lblStateState = new JLabel("State:");
		lblStateState.setBounds(916, 578, 70, 15);
		panel.add(lblStateState);
		
		JRadioButton rdbtnFreeState = new JRadioButton("Free");
		rdbtnFreeState.setActionCommand("Free");
		buttonGroup_6.add(rdbtnFreeState);
		rdbtnFreeState.setBounds(976, 558, 75, 23);
		panel.add(rdbtnFreeState);
		
		JRadioButton rdbtnReservedState = new JRadioButton("Reserved");
		rdbtnReservedState.setActionCommand("Reserved");
		buttonGroup_6.add(rdbtnReservedState);
		rdbtnReservedState.setBounds(1073, 558, 93, 23);
		panel.add(rdbtnReservedState);
		
		JRadioButton rdbtnBusyState = new JRadioButton("Busy");
		rdbtnBusyState.setActionCommand("Busy");
		buttonGroup_6.add(rdbtnBusyState);
		rdbtnBusyState.setBounds(1217, 558, 75, 23);
		panel.add(rdbtnBusyState);
		
		JRadioButton rdbtnAskingState = new JRadioButton("Asking");
		rdbtnAskingState.setActionCommand("Asking");
		buttonGroup_6.add(rdbtnAskingState);
		rdbtnAskingState.setBounds(976, 604, 87, 23);
		panel.add(rdbtnAskingState);
		
		JRadioButton rdbtnWaitingforfoodState = new JRadioButton("Waiting_for_food");
		rdbtnWaitingforfoodState.setActionCommand("Waiting_for_food");
		buttonGroup_6.add(rdbtnWaitingforfoodState);
		rdbtnWaitingforfoodState.setBounds(1073, 604, 149, 23);
		panel.add(rdbtnWaitingforfoodState);
		
		JRadioButton rdbtnServerState = new JRadioButton("Server");
		rdbtnServerState.setActionCommand("Server");
		buttonGroup_6.add(rdbtnServerState);
		rdbtnServerState.setBounds(1219, 604, 114, 23);
		panel.add(rdbtnServerState);
		
		JRadioButton rdbtnWaitingState = new JRadioButton("Waiting");
		rdbtnWaitingState.setActionCommand("Waiting");
		buttonGroup_6.add(rdbtnWaitingState);
		rdbtnWaitingState.setBounds(976, 655, 93, 23);
		panel.add(rdbtnWaitingState);
		
		JRadioButton rdbtnPayingState = new JRadioButton("Paying");
		rdbtnPayingState.setActionCommand("Paying");
		buttonGroup_6.add(rdbtnPayingState);
		rdbtnPayingState.setBounds(1073, 655, 149, 23);
		panel.add(rdbtnPayingState);
		
		JRadioButton rdbtnInpreparationState = new JRadioButton("In_preparation");
		rdbtnInpreparationState.setActionCommand("In_preparation");
		buttonGroup_6.add(rdbtnInpreparationState);
		rdbtnInpreparationState.setBounds(1219, 655, 149, 23);
		panel.add(rdbtnInpreparationState);
		
		JButton btnChangeState = new JButton("Change state");
		btnChangeState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					change();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnChangeState.setBounds(1345, 603, 133, 25);
		panel.add(btnChangeState);
	}

	
	public void reserve() throws NumberFormatException, Exception {
		Turn turn = Turn.valueOf(Turn.class, buttonGroup_3.getSelection().getActionCommand());
		int n_chairs = Integer.parseInt(buttonGroup_2.getSelection().getActionCommand());
		State state = State.Reserved;
		if(Integer.parseInt(txtfTableReserve.getText()) > 6 || Integer.parseInt(txtfTableReserve.getText()) < 1) {
			lblState.setText("This table does not exists.");
			return;
		}
		int result = 0;
		try {
		result = ReserveAgent.generate_reserve(state, txtfDateReserve.getText(), Integer.parseInt(txtfTableReserve.getText()), turn, n_chairs);		
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			lblState.setText("Table already reserved.");
		}
		if(result == 0) {
			lblState.setText("Error.");
		}else if(result == 1) {
			timer = new Timer(1200000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Turn turnCancelled2 = Turn.valueOf(Turn.class, turnCancelled);
					try {
						Control_operational_table.deleteReserve(Integer.parseInt(tableCancelled), turnCancelled2, dateCancelled);
					} catch (NumberFormatException e1) {
						lblState.setText("Table must be a number.");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					lblState.setText("Reservation cancelled. Table: " + tableCancelled + "; Turn: " + turnCancelled + "; Date: " + dateCancelled);
					timer.stop();
				}
			});
			tableCancelled = txtfTableReserve.getText();
			turnCancelled = buttonGroup_3.getSelection().getActionCommand();
			dateCancelled = txtfDateReserve.getText();
			timer.start();
			lblState.setText("Reserve done.");
		}
	}

	public void check() throws NumberFormatException, Exception {
		Turn turn = Turn.valueOf(Turn.class, buttonGroup_1.getSelection().getActionCommand());
		int result = ReserveAgent.checkReserves(turn, txtfDateCheck.getText(), Integer.parseInt(buttonGroup.getSelection().getActionCommand()));
		if(result == -1) {
			lblState.setText("Error reading database.");
		}else if(result == 0){
			lblState.setText("No table available");
		}else if(result > 0) {
			lblState.setText("Table avilable: " + result);
		}
	}

	public void change() throws NumberFormatException, Exception {
		Turn turn = Turn.valueOf(Turn.class, buttonGroup_5.getSelection().getActionCommand());
		State state = State.valueOf(State.class, buttonGroup_6.getSelection().getActionCommand());
		boolean result = false;
		
		if(Integer.parseInt(txtfTableState.getText()) > 6 || Integer.parseInt(txtfTableState.getText()) < 1) {
			lblState.setText("This table does not exists.");
			return;
		}
		
		try {
		result = Control_operational_table.changeState(state, Integer.parseInt(txtfTableState.getText()), txtfDateState.getText(), turn);
		} catch (NumberFormatException e1) {
			lblState.setText("Table must be a number.");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(result == false) {
			lblState.setText("Error changing the state.");
		}else {
			lblState.setText("State successfully changed.");
		}
	}

	public void setWaiter() throws NumberFormatException, Exception {
		Turn turn = Turn.valueOf(Turn.class, buttonGroup_4.getSelection().getActionCommand());
		int result = -1;
		
		if(Integer.parseInt(txtfTableWaiter.getText()) > 6 || Integer.parseInt(txtfTableWaiter.getText()) < 1) {
			lblState.setText("This table does not exists.");
			return;
		}
		
		if(Integer.parseInt(txtfWaiterWaiter.getText()) > 2 || Integer.parseInt(txtfWaiterWaiter.getText()) < 1) {
			lblState.setText("This waiter does not exists.");
			return;
		}
		
		try {
		result = ReserveAgent.setWaiter(txtfDateWaiter.getText(), Integer.parseInt(txtfTableWaiter.getText()), turn, Integer.parseInt(txtfWaiterWaiter.getText()));
		} catch (NumberFormatException e1) {
			lblState.setText("Table or waiter must be a number.");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(result == -1) {
			lblState.setText("Error reading the database.");
		}else if(result == 0) {
			lblState.setText("Waiter set.");
		}else if(result == -2) {
			lblState.setText("Error updating the database.");
		}
	}

	public void getWaiter() throws Exception {
		String position = "waiter";
		int [] result = ReserveAgent.getWaiter(position);
		if(result[0] == 0) {
			lblState.setText("Error reading waiters");
		}else {
			String idsWaiter = "Waiters available: " + result[0];
			for(int i = 3; i < result.length; i=i+3) {
				idsWaiter += ", " + result[i];
			}
			lblState.setText(idsWaiter);
		}
		
	}
}
