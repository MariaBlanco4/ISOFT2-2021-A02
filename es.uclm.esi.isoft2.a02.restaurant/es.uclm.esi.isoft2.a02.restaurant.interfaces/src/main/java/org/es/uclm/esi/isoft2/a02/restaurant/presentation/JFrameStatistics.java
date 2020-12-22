package org.es.uclm.esi.isoft2.a02.restaurant.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.uclm.esi.isoft2.a02.restaurant.statistics.domain.Control_statistics;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameStatistics extends JFrame {

	private JPanel contentPane;
	private JTextField textPaneTakeCommand;
	private JTextField textPanePreparationTime;
	private JTextField textPaneDeliveryNote;
	private JTextField textPaneTableFree;
	private JFrame frmStat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameStatistics frame = new JFrameStatistics();
					frame.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public JFrameStatistics() throws Exception {
		frmStat = new JFrame();
		frmStat.setResizable(false);
		frmStat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStat.setBounds(100, 100, 527, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmStat.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JLabel lblTakeCommand = new JLabel("Average time to take command:");
		lblTakeCommand.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTakeCommand.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTakeCommand.setBounds(74, 97, 234, 15);
		contentPane.add(lblTakeCommand);

		JLabel lblStatisctis = new JLabel("STATISTICS");
		lblStatisctis.setFont(new Font("Dialog", Font.BOLD, 26));
		lblStatisctis.setBounds(169, 12, 190, 58);
		contentPane.add(lblStatisctis);

		textPaneTakeCommand = new JTextField();
		textPaneTakeCommand.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneTakeCommand.setEditable(false);
		textPaneTakeCommand.setBounds(342, 94, 68, 21);
		contentPane.add(textPaneTakeCommand);

		JLabel lblPreparationTime = new JLabel("Average meal preparation time:");
		lblPreparationTime.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPreparationTime.setBounds(83, 155, 250, 15);
		contentPane.add(lblPreparationTime);

		textPanePreparationTime = new JTextField();
		textPanePreparationTime.setHorizontalAlignment(SwingConstants.CENTER);
		textPanePreparationTime.setEditable(false);
		textPanePreparationTime.setBounds(342, 152, 68, 21);
		contentPane.add(textPanePreparationTime);

		JLabel lblDeliveryNote = new JLabel("Average time of delivery of the note:");
		lblDeliveryNote.setBounds(48, 210, 269, 15);
		contentPane.add(lblDeliveryNote);

		textPaneDeliveryNote = new JTextField();
		textPaneDeliveryNote.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneDeliveryNote.setEditable(false);
		textPaneDeliveryNote.setBounds(342, 207, 68, 21);
		contentPane.add(textPaneDeliveryNote);

		JLabel lblTableFree = new JLabel("Average preparation time  table is free:");
		lblTableFree.setBounds(26, 255, 304, 15);
		contentPane.add(lblTableFree);

		textPaneTableFree = new JTextField();
		textPaneTableFree.setHorizontalAlignment(SwingConstants.CENTER);
		textPaneTableFree.setEditable(false);
		textPaneTableFree.setBounds(342, 255, 71, 21);
		contentPane.add(textPaneTableFree);

		JButton btnBack = new JButton("Back ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameLogin login = new JFrameLogin();
				login.show();
				frmStat.dispose();
			}
		});
		btnBack.setBounds(142, 304, 117, 25);
		contentPane.add(btnBack);

		JLabel lblSecond = new JLabel("s");
		lblSecond.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSecond.setBounds(428, 99, 70, 15);
		contentPane.add(lblSecond);

		JLabel lblSecond_1 = new JLabel("s");
		lblSecond_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSecond_1.setBounds(428, 158, 70, 15);
		contentPane.add(lblSecond_1);

		JLabel lblSecond_1_1 = new JLabel("s");
		lblSecond_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSecond_1_1.setBounds(428, 207, 70, 15);
		contentPane.add(lblSecond_1_1);

		JLabel lblSecond_1_1_1 = new JLabel("s");
		lblSecond_1_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSecond_1_1_1.setBounds(428, 255, 70, 15);
		contentPane.add(lblSecond_1_1_1);
		
		JButton btnLoadStatistics = new JButton("Load statistics");
		btnLoadStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					showStatistics();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadStatistics.setBounds(301, 304, 153, 25);
		contentPane.add(btnLoadStatistics);

	}

	public void showStatistics() throws Exception {
		double [] stat= Control_statistics.getStatistics();
		textPaneTakeCommand.setText(String.format("%.2f", stat[0]));
		textPanePreparationTime.setText(String.format("%.2f", stat[1]));
		textPaneDeliveryNote.setText(String.format("%.2f", stat[2]));
		textPaneTableFree.setText(String.format("%.2f", stat[3]));
	}
	
	public JFrame getFrame() {
		return frmStat;
	}
}
