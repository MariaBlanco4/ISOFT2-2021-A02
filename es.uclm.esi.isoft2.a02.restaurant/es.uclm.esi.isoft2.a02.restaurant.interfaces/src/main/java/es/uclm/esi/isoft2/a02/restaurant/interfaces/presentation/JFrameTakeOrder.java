package es.uclm.esi.isoft2.a02.restaurant.interfaces.presentation;

import java.awt.BorderLayout;     
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.TextArea;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Control_operational_table;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.State;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.User;
import es.uclm.esi.isoft2.a02.restaurant.making_orders.domain.Control_notification;
import es.uclm.esi.isoft2.a02.restaurant.making_orders.domain.Control_order;

import java.awt.Label;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.showMessageDialog;

public class JFrameTakeOrder extends JFrame {

	//User login

	private JPanel contentPane;
	private JTextField textDate;
	private JRadioButton rdbtnFree;
	private JRadioButton rdbtnBusy;
	private JRadioButton rdbtnReserve;
	private JRadioButton rdbtnAsking;
	private JRadioButton rdbtnWaitinFood;
	private JRadioButton rdbtnServed;
	private JRadioButton rdbtnPaying;
	private JRadioButton rdbtnPreparation;
	private JRadioButton rdbtnWaitinBill;
	private JLabel lblState;
	ButtonGroup groupState, groupTurn;
	private JLabel lblTurn;
	private JRadioButton rdbtnF_Lunch;
	private JRadioButton rdbtnS_Lunch;
	private JRadioButton rdbtnT_Lunch;
	private JRadioButton rdbtnF_Dinner;
	private JRadioButton rdbtnS_Dinner;
	private JRadioButton rdbtnT_Dinner;
	private JLabel lblN_table;
	private JLabel lblFirsts;
	private JLabel lblTortilla;
	private JLabel lblVarietyColdCuts;
	private JLabel lblSecond;
	private JLabel lblCarrotCream;
	private JLabel lblPumpkinPie;
	private JLabel lblDessert;
	private JLabel lblCheeseCake;
	private JLabel lblOreoShake;
	private JLabel lblStarter;
	private JLabel lblHam;
	private JSpinner spTortilla;
	private JSpinner spVariety;
	private JSpinner spCarrot;
	private JSpinner spPumkin;
	private JSpinner spCheese;
	private JSpinner spOreo;
	private JSpinner spHem;
	SpinnerNumberModel limit1 = new SpinnerNumberModel(0, 0, 6, 1);  //Spinner bounders
	SpinnerNumberModel limit2 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit3 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit4 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit5 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit6 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit7 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit8 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit9 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit10 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit11= new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit12  = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit13 = new SpinnerNumberModel(0, 0, 6, 1);
	SpinnerNumberModel limit20 = new SpinnerNumberModel(0, 0, 20, 1);
	private JLabel lblDrinks;
	private JSpinner spCoke;
	private JSpinner spHidromiel;
	private JLabel lblHidromiel;
	private JLabel lblCoke;
	private JTextField textID_USER;
	private JButton btnIntroduceOrder;
	private JButton btnChangeState;
	private JLabel label;
	private JLabel lblDestination;
	private JLabel lblIdUser;
	private JTextField textDestination;
	private JLabel lblFanta;
	private JSpinner spFanta;
	private JLabel lblNestea;
	private JSpinner spNestea;
	private JLabel lblPoorPeopleBeer;
	private JSpinner spP_Beer;
	private JLabel lblRichPeopleBeer;
	private JSpinner spR_beer;
	private JTextField textCaja;
	private JLabel lblMessage;
	private JButton btnSendMessage;
	private JButton btnGetMessage;
	private JTextField spTable;
	private static JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrameTakeOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public JFrameTakeOrder() throws ParseException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 808);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 20, -86, 233, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 75, 0, 0, 57, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 1;
		contentPane.add(lblDate, gbc_lblDate);
		MaskFormatter fdate;
	
		fdate = new MaskFormatter("##/##/####");
		fdate.setPlaceholderCharacter('X');
		textDate = new JFormattedTextField(fdate);
		
		GridBagConstraints gbc_textDate = new GridBagConstraints();
		gbc_textDate.insets = new Insets(0, 0, 5, 5);
		gbc_textDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDate.gridx = 1;
		gbc_textDate.gridy = 1;
		contentPane.add(textDate, gbc_textDate);
		textDate.setColumns(10);
		
		lblTurn = new JLabel("Select the table turn");
		GridBagConstraints gbc_lblTurn = new GridBagConstraints();
		gbc_lblTurn.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTurn.insets = new Insets(0, 0, 5, 5);
		gbc_lblTurn.gridx = 3;
		gbc_lblTurn.gridy = 1;
		contentPane.add(lblTurn, gbc_lblTurn);
		
		lblState = new JLabel("Select the next State");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 4;
		gbc_lblState.gridy = 1;
		contentPane.add(lblState, gbc_lblState);
		
		lblN_table = new JLabel("Table number");
		GridBagConstraints gbc_lblN_table = new GridBagConstraints();
		gbc_lblN_table.anchor = GridBagConstraints.EAST;
		gbc_lblN_table.insets = new Insets(0, 0, 5, 5);
		gbc_lblN_table.gridx = 0;
		gbc_lblN_table.gridy = 2;
		contentPane.add(lblN_table, gbc_lblN_table);
		
		spTable = new JTextField();
		GridBagConstraints gbc_spTable = new GridBagConstraints();
		gbc_spTable.fill = GridBagConstraints.HORIZONTAL;
		gbc_spTable.insets = new Insets(0, 0, 5, 5);
		gbc_spTable.gridx = 1;
		gbc_spTable.gridy = 2;
		contentPane.add(spTable, gbc_spTable);
		
		rdbtnF_Lunch = new JRadioButton("F_Lunch");
		GridBagConstraints gbc_rdbtnF_Lunch = new GridBagConstraints();
		gbc_rdbtnF_Lunch.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnF_Lunch.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnF_Lunch.gridx = 3;
		gbc_rdbtnF_Lunch.gridy = 2;
		contentPane.add(rdbtnF_Lunch, gbc_rdbtnF_Lunch);
		
		rdbtnFree = new JRadioButton("Free");
		GridBagConstraints gbc_rdbtnFree = new GridBagConstraints();
		gbc_rdbtnFree.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnFree.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFree.gridx = 4;
		gbc_rdbtnFree.gridy = 2;
		contentPane.add(rdbtnFree, gbc_rdbtnFree);
		
		rdbtnS_Lunch = new JRadioButton("S_Lunch");
		GridBagConstraints gbc_rdbtnS_Lunch = new GridBagConstraints();
		gbc_rdbtnS_Lunch.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnS_Lunch.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnS_Lunch.gridx = 3;
		gbc_rdbtnS_Lunch.gridy = 3;
		contentPane.add(rdbtnS_Lunch, gbc_rdbtnS_Lunch);
		
		rdbtnBusy = new JRadioButton("Busy");
		GridBagConstraints gbc_rdbtnBusy = new GridBagConstraints();
		gbc_rdbtnBusy.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnBusy.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBusy.gridx = 4;
		gbc_rdbtnBusy.gridy = 3;
		contentPane.add(rdbtnBusy, gbc_rdbtnBusy);
		
		lblFirsts = new JLabel("Firsts");
		GridBagConstraints gbc_lblFirsts = new GridBagConstraints();
		gbc_lblFirsts.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirsts.gridx = 0;
		gbc_lblFirsts.gridy = 4;
		contentPane.add(lblFirsts, gbc_lblFirsts);
		
		lblTortilla = new JLabel("Tortilla");
		GridBagConstraints gbc_lblTortilla = new GridBagConstraints();
		gbc_lblTortilla.insets = new Insets(0, 0, 5, 5);
		gbc_lblTortilla.gridx = 1;
		gbc_lblTortilla.gridy = 4;
		contentPane.add(lblTortilla, gbc_lblTortilla);
		
		spTortilla = new JSpinner(limit1);
		GridBagConstraints gbc_spTortilla = new GridBagConstraints();
		gbc_spTortilla.anchor = GridBagConstraints.WEST;
		gbc_spTortilla.insets = new Insets(0, 0, 5, 5);
		gbc_spTortilla.gridx = 2;
		gbc_spTortilla.gridy = 4;
		contentPane.add(spTortilla, gbc_spTortilla);
		
		rdbtnT_Lunch = new JRadioButton("T_Lunch");
		GridBagConstraints gbc_rdbtnT_Lunch = new GridBagConstraints();
		gbc_rdbtnT_Lunch.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnT_Lunch.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnT_Lunch.gridx = 3;
		gbc_rdbtnT_Lunch.gridy = 4;
		contentPane.add(rdbtnT_Lunch, gbc_rdbtnT_Lunch);
		
		rdbtnReserve = new JRadioButton("Reserved");
		GridBagConstraints gbc_rdbtnReserve = new GridBagConstraints();
		gbc_rdbtnReserve.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnReserve.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnReserve.gridx = 4;
		gbc_rdbtnReserve.gridy = 4;
		contentPane.add(rdbtnReserve, gbc_rdbtnReserve);
		
		lblVarietyColdCuts = new JLabel("Variety cold cuts");
		GridBagConstraints gbc_lblVarietyColdCuts = new GridBagConstraints();
		gbc_lblVarietyColdCuts.insets = new Insets(0, 0, 5, 5);
		gbc_lblVarietyColdCuts.gridx = 1;
		gbc_lblVarietyColdCuts.gridy = 5;
		contentPane.add(lblVarietyColdCuts, gbc_lblVarietyColdCuts);
		
		spVariety = new JSpinner(limit2);
		GridBagConstraints gbc_spVariety = new GridBagConstraints();
		gbc_spVariety.anchor = GridBagConstraints.WEST;
		gbc_spVariety.insets = new Insets(0, 0, 5, 5);
		gbc_spVariety.gridx = 2;
		gbc_spVariety.gridy = 5;
		contentPane.add(spVariety, gbc_spVariety);
		
		rdbtnF_Dinner = new JRadioButton("F_Dinner");
		GridBagConstraints gbc_rdbtnF_Dinner = new GridBagConstraints();
		gbc_rdbtnF_Dinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnF_Dinner.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnF_Dinner.gridx = 3;
		gbc_rdbtnF_Dinner.gridy = 5;
		contentPane.add(rdbtnF_Dinner, gbc_rdbtnF_Dinner);
		
		rdbtnAsking = new JRadioButton("Asking");
		GridBagConstraints gbc_rdbtnAsking = new GridBagConstraints();
		gbc_rdbtnAsking.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnAsking.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAsking.gridx = 4;
		gbc_rdbtnAsking.gridy = 5;
		contentPane.add(rdbtnAsking, gbc_rdbtnAsking);
		
		lblSecond = new JLabel("Second");
		GridBagConstraints gbc_lblSecond = new GridBagConstraints();
		gbc_lblSecond.insets = new Insets(0, 0, 5, 5);
		gbc_lblSecond.gridx = 0;
		gbc_lblSecond.gridy = 6;
		contentPane.add(lblSecond, gbc_lblSecond);
		
		lblCarrotCream = new JLabel("Carrot cream");
		GridBagConstraints gbc_lblCarrotCream = new GridBagConstraints();
		gbc_lblCarrotCream.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarrotCream.gridx = 1;
		gbc_lblCarrotCream.gridy = 6;
		contentPane.add(lblCarrotCream, gbc_lblCarrotCream);
		
		spCarrot = new JSpinner(limit3);
		GridBagConstraints gbc_spCarrot = new GridBagConstraints();
		gbc_spCarrot.anchor = GridBagConstraints.WEST;
		gbc_spCarrot.insets = new Insets(0, 0, 5, 5);
		gbc_spCarrot.gridx = 2;
		gbc_spCarrot.gridy = 6;
		contentPane.add(spCarrot, gbc_spCarrot);
		
		rdbtnS_Dinner = new JRadioButton("S_Dinner");
		GridBagConstraints gbc_rdbtnS_Dinner = new GridBagConstraints();
		gbc_rdbtnS_Dinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnS_Dinner.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnS_Dinner.gridx = 3;
		gbc_rdbtnS_Dinner.gridy = 6;
		contentPane.add(rdbtnS_Dinner, gbc_rdbtnS_Dinner);
		
		rdbtnWaitinFood = new JRadioButton("Waiting for food");
		GridBagConstraints gbc_rdbtnWaitinFood = new GridBagConstraints();
		gbc_rdbtnWaitinFood.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnWaitinFood.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWaitinFood.gridx = 4;
		gbc_rdbtnWaitinFood.gridy = 6;
		contentPane.add(rdbtnWaitinFood, gbc_rdbtnWaitinFood);
		
		lblPumpkinPie = new JLabel("Pumpkin pie");
		GridBagConstraints gbc_lblPumpkinPie = new GridBagConstraints();
		gbc_lblPumpkinPie.insets = new Insets(0, 0, 5, 5);
		gbc_lblPumpkinPie.gridx = 1;
		gbc_lblPumpkinPie.gridy = 7;
		contentPane.add(lblPumpkinPie, gbc_lblPumpkinPie);
		
		spPumkin = new JSpinner(limit4);
		GridBagConstraints gbc_spPumkin = new GridBagConstraints();
		gbc_spPumkin.anchor = GridBagConstraints.WEST;
		gbc_spPumkin.insets = new Insets(0, 0, 5, 5);
		gbc_spPumkin.gridx = 2;
		gbc_spPumkin.gridy = 7;
		contentPane.add(spPumkin, gbc_spPumkin);
		
		rdbtnT_Dinner = new JRadioButton("T_Dinner");
		GridBagConstraints gbc_rdbtnT_Dinner = new GridBagConstraints();
		gbc_rdbtnT_Dinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnT_Dinner.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnT_Dinner.gridx = 3;
		gbc_rdbtnT_Dinner.gridy = 7;
		contentPane.add(rdbtnT_Dinner, gbc_rdbtnT_Dinner);
		
		rdbtnServed = new JRadioButton("Served");
		GridBagConstraints gbc_rdbtnServed = new GridBagConstraints();
		gbc_rdbtnServed.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnServed.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnServed.gridx = 4;
		gbc_rdbtnServed.gridy = 7;
		contentPane.add(rdbtnServed, gbc_rdbtnServed);
		
		lblDessert = new JLabel("Dessert");
		GridBagConstraints gbc_lblDessert = new GridBagConstraints();
		gbc_lblDessert.insets = new Insets(0, 0, 5, 5);
		gbc_lblDessert.gridx = 0;
		gbc_lblDessert.gridy = 8;
		contentPane.add(lblDessert, gbc_lblDessert);
		
		lblCheeseCake = new JLabel("Cheese cake");
		GridBagConstraints gbc_lblCheeseCake = new GridBagConstraints();
		gbc_lblCheeseCake.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheeseCake.gridx = 1;
		gbc_lblCheeseCake.gridy = 8;
		contentPane.add(lblCheeseCake, gbc_lblCheeseCake);
		
		spCheese = new JSpinner(limit5);
		GridBagConstraints gbc_spCheese = new GridBagConstraints();
		gbc_spCheese.anchor = GridBagConstraints.WEST;
		gbc_spCheese.insets = new Insets(0, 0, 5, 5);
		gbc_spCheese.gridx = 2;
		gbc_spCheese.gridy = 8;
		contentPane.add(spCheese, gbc_spCheese);
		
		rdbtnPaying = new JRadioButton("Paying");
		GridBagConstraints gbc_rdbtnPaying = new GridBagConstraints();
		gbc_rdbtnPaying.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnPaying.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPaying.gridx = 4;
		gbc_rdbtnPaying.gridy = 8;
		contentPane.add(rdbtnPaying, gbc_rdbtnPaying);
		
		lblOreoShake = new JLabel("Oreo shake");
		GridBagConstraints gbc_lblOreoShake = new GridBagConstraints();
		gbc_lblOreoShake.insets = new Insets(0, 0, 5, 5);
		gbc_lblOreoShake.gridx = 1;
		gbc_lblOreoShake.gridy = 9;
		contentPane.add(lblOreoShake, gbc_lblOreoShake);
		
		spOreo = new JSpinner(limit6);
		GridBagConstraints gbc_spOreo = new GridBagConstraints();
		gbc_spOreo.anchor = GridBagConstraints.WEST;
		gbc_spOreo.insets = new Insets(0, 0, 5, 5);
		gbc_spOreo.gridx = 2;
		gbc_spOreo.gridy = 9;
		contentPane.add(spOreo, gbc_spOreo);
		
		rdbtnPreparation = new JRadioButton("In preparation");
		GridBagConstraints gbc_rdbtnPreparation = new GridBagConstraints();
		gbc_rdbtnPreparation.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnPreparation.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPreparation.gridx = 4;
		gbc_rdbtnPreparation.gridy = 9;
		contentPane.add(rdbtnPreparation, gbc_rdbtnPreparation);
		
		lblStarter = new JLabel("Starter");
		GridBagConstraints gbc_lblStarter = new GridBagConstraints();
		gbc_lblStarter.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarter.gridx = 0;
		gbc_lblStarter.gridy = 10;
		contentPane.add(lblStarter, gbc_lblStarter);
		
		lblHam = new JLabel("Ham");
		GridBagConstraints gbc_lblHam = new GridBagConstraints();
		gbc_lblHam.insets = new Insets(0, 0, 5, 5);
		gbc_lblHam.gridx = 1;
		gbc_lblHam.gridy = 10;
		contentPane.add(lblHam, gbc_lblHam);
		
		spHem = new JSpinner(limit7);
		GridBagConstraints gbc_spHem = new GridBagConstraints();
		gbc_spHem.anchor = GridBagConstraints.WEST;
		gbc_spHem.insets = new Insets(0, 0, 5, 5);
		gbc_spHem.gridx = 2;
		gbc_spHem.gridy = 10;
		contentPane.add(spHem, gbc_spHem);
		
		rdbtnWaitinBill = new JRadioButton("Waiting for the bill");
		GridBagConstraints gbc_rdbtnWaitinBill = new GridBagConstraints();
		gbc_rdbtnWaitinBill.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnWaitinBill.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWaitinBill.gridx = 4;
		gbc_rdbtnWaitinBill.gridy = 10;
		contentPane.add(rdbtnWaitinBill, gbc_rdbtnWaitinBill);
		
		groupState = new ButtonGroup();
		groupState.add(rdbtnPreparation);
		groupState.add(rdbtnPaying);
		groupState.add(rdbtnServed);
		groupState.add(rdbtnWaitinFood);
		groupState.add(rdbtnAsking);
		groupState.add(rdbtnReserve);
		groupState.add(rdbtnBusy);
		groupState.add(rdbtnFree);
		groupState.add(rdbtnFree);	
		groupState.add(rdbtnWaitinBill);
		
		groupTurn = new ButtonGroup();
		groupTurn.add(rdbtnF_Lunch);
		groupTurn.add(rdbtnS_Lunch);
		groupTurn.add(rdbtnT_Lunch);
		groupTurn.add(rdbtnF_Dinner);
		groupTurn.add(rdbtnS_Dinner);
		groupTurn.add(rdbtnT_Dinner);
		
		lblDrinks = new JLabel("Drinks");
		GridBagConstraints gbc_lblDrinks = new GridBagConstraints();
		gbc_lblDrinks.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrinks.gridx = 0;
		gbc_lblDrinks.gridy = 11;
		contentPane.add(lblDrinks, gbc_lblDrinks);
		
		lblCoke = new JLabel("Coke");
		GridBagConstraints gbc_lblCoke = new GridBagConstraints();
		gbc_lblCoke.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoke.gridx = 1;
		gbc_lblCoke.gridy = 11;
		contentPane.add(lblCoke, gbc_lblCoke);
		
		spCoke = new JSpinner(limit8);
		GridBagConstraints gbc_spCoke = new GridBagConstraints();
		gbc_spCoke.anchor = GridBagConstraints.WEST;
		gbc_spCoke.insets = new Insets(0, 0, 5, 5);
		gbc_spCoke.gridx = 2;
		gbc_spCoke.gridy = 11;
		contentPane.add(spCoke, gbc_spCoke);
		
		lblFanta = new JLabel("Fanta");
		GridBagConstraints gbc_lblFanta = new GridBagConstraints();
		gbc_lblFanta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFanta.gridx = 1;
		gbc_lblFanta.gridy = 12;
		contentPane.add(lblFanta, gbc_lblFanta);
		
		spFanta = new JSpinner(limit12);
		GridBagConstraints gbc_spFanta = new GridBagConstraints();
		gbc_spFanta.anchor = GridBagConstraints.WEST;
		gbc_spFanta.insets = new Insets(0, 0, 5, 5);
		gbc_spFanta.gridx = 2;
		gbc_spFanta.gridy = 12;
		contentPane.add(spFanta, gbc_spFanta);
		
		lblNestea = new JLabel("Nestea");
		GridBagConstraints gbc_lblNestea = new GridBagConstraints();
		gbc_lblNestea.insets = new Insets(0, 0, 5, 5);
		gbc_lblNestea.gridx = 1;
		gbc_lblNestea.gridy = 13;
		contentPane.add(lblNestea, gbc_lblNestea);
		
		spNestea = new JSpinner(limit11);
		GridBagConstraints gbc_spNestea = new GridBagConstraints();
		gbc_spNestea.anchor = GridBagConstraints.WEST;
		gbc_spNestea.insets = new Insets(0, 0, 5, 5);
		gbc_spNestea.gridx = 2;
		gbc_spNestea.gridy = 13;
		contentPane.add(spNestea, gbc_spNestea);
		
		lblHidromiel = new JLabel("Hidromiel");
		GridBagConstraints gbc_lblHidromiel = new GridBagConstraints();
		gbc_lblHidromiel.insets = new Insets(0, 0, 5, 5);
		gbc_lblHidromiel.gridx = 1;
		gbc_lblHidromiel.gridy = 14;
		contentPane.add(lblHidromiel, gbc_lblHidromiel);
		
		spHidromiel = new JSpinner(limit9);
		GridBagConstraints gbc_spHidromiel = new GridBagConstraints();
		gbc_spHidromiel.anchor = GridBagConstraints.WEST;
		gbc_spHidromiel.insets = new Insets(0, 0, 5, 5);
		gbc_spHidromiel.gridx = 2;
		gbc_spHidromiel.gridy = 14;
		contentPane.add(spHidromiel, gbc_spHidromiel);
		
		btnIntroduceOrder = new JButton("Introduce order");
		btnIntroduceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] dishes = computeDishes();
					String[] drinks = computeDrinks();
					Turn turn = getTurn();
					order(turn, drinks, dishes);
				}catch(NumberFormatException e1) {
					e1.printStackTrace();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnIntroduceOrder = new GridBagConstraints();
		gbc_btnIntroduceOrder.anchor = GridBagConstraints.EAST;
		gbc_btnIntroduceOrder.insets = new Insets(0, 0, 5, 5);
		gbc_btnIntroduceOrder.gridx = 3;
		gbc_btnIntroduceOrder.gridy = 14;
		contentPane.add(btnIntroduceOrder, gbc_btnIntroduceOrder);
		
		btnChangeState = new JButton("Change state");
		btnChangeState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					change();
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnChangeState = new GridBagConstraints();
		gbc_btnChangeState.anchor = GridBagConstraints.EAST;
		gbc_btnChangeState.insets = new Insets(0, 0, 5, 5);
		gbc_btnChangeState.gridx = 4;
		gbc_btnChangeState.gridy = 14;
		contentPane.add(btnChangeState, gbc_btnChangeState);
		
		lblPoorPeopleBeer = new JLabel("Poor people beer");
		GridBagConstraints gbc_lblPoorPeopleBeer = new GridBagConstraints();
		gbc_lblPoorPeopleBeer.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoorPeopleBeer.gridx = 1;
		gbc_lblPoorPeopleBeer.gridy = 15;
		contentPane.add(lblPoorPeopleBeer, gbc_lblPoorPeopleBeer);
		
		spP_Beer = new JSpinner(limit10);
		GridBagConstraints gbc_spP_Beer = new GridBagConstraints();
		gbc_spP_Beer.anchor = GridBagConstraints.WEST;
		gbc_spP_Beer.insets = new Insets(0, 0, 5, 5);
		gbc_spP_Beer.gridx = 2;
		gbc_spP_Beer.gridy = 15;
		contentPane.add(spP_Beer, gbc_spP_Beer);
		
		lblRichPeopleBeer = new JLabel("Rich people beer");
		GridBagConstraints gbc_lblRichPeopleBeer = new GridBagConstraints();
		gbc_lblRichPeopleBeer.insets = new Insets(0, 0, 5, 5);
		gbc_lblRichPeopleBeer.gridx = 1;
		gbc_lblRichPeopleBeer.gridy = 16;
		contentPane.add(lblRichPeopleBeer, gbc_lblRichPeopleBeer);
		
		spR_beer = new JSpinner(limit13);
		GridBagConstraints gbc_spR_beer = new GridBagConstraints();
		gbc_spR_beer.anchor = GridBagConstraints.WEST;
		gbc_spR_beer.insets = new Insets(0, 0, 5, 5);
		gbc_spR_beer.gridx = 2;
		gbc_spR_beer.gridy = 16;
		contentPane.add(spR_beer, gbc_spR_beer);
		
		label = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 6;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 17;
		contentPane.add(label, gbc_label);
		
		lblDestination = new JLabel("Destination");
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.anchor = GridBagConstraints.WEST;
		gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestination.gridx = 0;
		gbc_lblDestination.gridy = 18;
		contentPane.add(lblDestination, gbc_lblDestination);
		
		textDestination = new JTextField();
		GridBagConstraints gbc_textDestination = new GridBagConstraints();
		gbc_textDestination.insets = new Insets(0, 0, 5, 5);
		gbc_textDestination.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDestination.gridx = 1;
		gbc_textDestination.gridy = 18;
		contentPane.add(textDestination, gbc_textDestination);
		textDestination.setColumns(10);
		
		lblMessage = new JLabel("Message");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessage.anchor = GridBagConstraints.EAST;
		gbc_lblMessage.gridx = 2;
		gbc_lblMessage.gridy = 18;
		contentPane.add(lblMessage, gbc_lblMessage);
		
		textCaja = new JTextField();
		GridBagConstraints gbc_textCaja = new GridBagConstraints();
		gbc_textCaja.gridwidth = 2;
		gbc_textCaja.insets = new Insets(0, 0, 5, 5);
		 textCaja.setBounds(150, 50, 100, 25);
		gbc_textCaja.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCaja.gridx = 3;
		gbc_textCaja.gridy = 18;
		contentPane.add(textCaja, gbc_textCaja);
		textCaja.setColumns(10);
		
		lblIdUser = new JLabel("ID user");
		GridBagConstraints gbc_lblIdUser = new GridBagConstraints();
		gbc_lblIdUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdUser.anchor = GridBagConstraints.WEST;
		gbc_lblIdUser.gridx = 0;
		gbc_lblIdUser.gridy = 19;
		contentPane.add(lblIdUser, gbc_lblIdUser);
		
		textID_USER = new JTextField();
		textID_USER.setEnabled(false);
		GridBagConstraints gbc_textID_USER = new GridBagConstraints();
		gbc_textID_USER.insets = new Insets(0, 0, 5, 5);
		gbc_textID_USER.fill = GridBagConstraints.HORIZONTAL;
		gbc_textID_USER.gridx = 1;
		gbc_textID_USER.gridy = 19;
		contentPane.add(textID_USER, gbc_textID_USER);
		textID_USER.setColumns(10);
		
		btnSendMessage = new JButton("Send message");
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					notification();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnSendMessage = new GridBagConstraints();
		gbc_btnSendMessage.insets = new Insets(0, 0, 5, 5);
		gbc_btnSendMessage.gridx = 3;
		gbc_btnSendMessage.gridy = 19;
		contentPane.add(btnSendMessage, gbc_btnSendMessage);
		
		btnGetMessage = new JButton("Get message");
		btnGetMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getNotification();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGetMessage = new GridBagConstraints();
		gbc_btnGetMessage.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetMessage.gridx = 4;
		gbc_btnGetMessage.gridy = 19;
		contentPane.add(btnGetMessage, gbc_btnGetMessage);
		
	}
	public String[] computeDishes(){
		String[] dishes = null;
		ArrayList<String> dish = new ArrayList<String>();
		if((Integer) spTortilla.getValue() > 0) for(int i = 0; i< ((Integer) spTortilla.getValue()); i++) dish.add("tortilla");
		if((Integer) spVariety.getValue() > 0) for(int i = 0; i< ((Integer) spVariety.getValue()); i++) dish.add("variety_cold_cuts");
		if((Integer) spCarrot.getValue() > 0) for(int i = 0; i< ((Integer) spCarrot.getValue()); i++) dish.add("carrot_cream");
		if((Integer) spPumkin.getValue() > 0) for(int i = 0; i< ((Integer) spPumkin.getValue()); i++) dish.add("pumpkin_pie");
		if((Integer) spCheese.getValue() > 0) for(int i = 0; i< ((Integer) spCheese.getValue()); i++) dish.add("cheese_cake");
		if((Integer) spOreo.getValue() > 0) for(int i = 0; i< ((Integer) spOreo.getValue()); i++) dish.add("oreo_shake");
		if((Integer) spHem.getValue() > 0) for(int i = 0; i< ((Integer) spHem.getValue()); i++) dish.add("ham");
					
		dishes = new String[dish.size()];	
		for(int i = 0 ; i<dish.size(); i++) {
			dishes[i] = dish.get(i);
		}
		return dishes;
	}
	
	public String[] computeDrinks() {
		String[] drinks = null;
		ArrayList<String> drink = new ArrayList<String>();
		
		if((Integer) spCoke.getValue() > 0) for(int i = 0; i< ((Integer) spCoke.getValue()); i++) drink.add("cola");
		if((Integer) spFanta.getValue() > 0) for(int i = 0; i< ((Integer) spFanta.getValue()); i++) drink.add("fanta");
		if((Integer) spNestea.getValue() > 0)for(int i = 0; i< ((Integer) spNestea.getValue()); i++) drink.add("nestea");
		if((Integer) spHidromiel.getValue() > 0)for(int i = 0; i< ((Integer) spHidromiel.getValue()); i++) drink.add("hidromiel");
		if((Integer) spP_Beer.getValue() > 0) for(int i = 0; i< ((Integer) spP_Beer.getValue()); i++) drink.add("poor_people_beer");
		if((Integer) spR_beer.getValue() > 0) for(int i = 0; i< ((Integer) spR_beer.getValue()); i++) drink.add("rich_people_beer");
		
		drinks = new String[drink.size()];	
		for(int i = 0 ; i<drink.size(); i++) {
			drinks[i] = drink.get(i);
		}
		return drinks;
	}

	public void order(Turn turn, String[] drinks, String[] dishes) throws NumberFormatException, Exception, SQLException{
		
		int result = Control_order.checkOrder(Integer.parseInt(spTable.getText()),textDate.getText(), turn,drinks, dishes );
		if(result == 0) {
			showMessageDialog(null, "Order insert");
		}else if(result == -1){
			showMessageDialog(null, "Error making the order, something goes wrong");
		}else if(result == -2) {
			showMessageDialog(null, "Error, some ingredient or drink doesn't exist");
		}else if(result == -3) {
			showMessageDialog(null, "No enough drink or food, we are replacing it");
		}
	}
	
	/*
	 * Method to send a notification to an specific user
	 */
	public void notification() throws NumberFormatException, SQLException, Exception {
		boolean noti = false;
		noti = Control_notification.notify(textCaja.getText(), Integer.parseInt(textID_USER.getText()), Integer.parseInt(textDestination.getText()));
		if(noti) {
			showMessageDialog(null, "Notification send");
		}else {
			showMessageDialog(null, "Error sending the notification");
		}
	}
	/*
	 * Method to get the turn selected, possible turns:
	 * 		F_Lunch
	 * 		S_Lunch
	 *		T_Lunch
	 * 		F_Dinner
	 * 		S_Dinner
	 * 		T_Dinner
	 */
	public Turn getTurn() {
		Turn turn = null;
		if(rdbtnS_Lunch.isSelected() == true) turn = Turn.S_Lunch;
		if(rdbtnT_Lunch.isSelected() == true) turn = Turn.T_Lunch;
		if(rdbtnF_Lunch.isSelected() == true) turn = Turn.F_Lunch;
		if(rdbtnF_Dinner.isSelected() == true) turn = Turn.F_Dinner;
		if(rdbtnS_Dinner.isSelected() == true) turn = Turn.S_Dinner;
		if(rdbtnT_Dinner.isSelected() == true) turn = Turn.T_Dinner;
			
		return turn;
	} 
	
	/*
	 * Method to get the state selected, possible states:
	 * 		Busy
	 * 		Reserved
	 * 		Asking
	 * 		Waiting_for_food
	 *		Served
	 * 		Paying
	 *		In_preparation
	 * 		Waiting
	 * 		Free
	 * 
	 */
	public State computeState() {
		State state = State.Asking;
		if(rdbtnBusy.isSelected()) state = State.Busy;
		if(rdbtnReserve.isSelected()) state =  State.Reserved;
		if(rdbtnAsking.isSelected())  state = State.Asking;
		if(rdbtnWaitinFood.isSelected()) state = State.Waiting_for_food;
		if(rdbtnServed.isSelected()) state = State.Served;
		if(rdbtnPaying.isSelected()) state = State.Paying;
		if(rdbtnPreparation.isSelected()) state = State.In_preparation;
		if(rdbtnWaitinBill.isSelected()) state = State.Waiting;
		if(rdbtnFree.isSelected()) state = State.Free;
		
		return state;
	}
	
	/*
	 * Method to change the state of a table
	 */
	public void change() throws NumberFormatException, Exception {
		State state = computeState();
		Turn turn = getTurn();
		boolean result = false;
	
		try {
		result = Control_operational_table.changeState(state, Integer.parseInt(spTable.getText()), textDate.getText(), turn);
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(result == true) {
			showMessageDialog(null, "State change to "+state);
		}else {
			showMessageDialog(null, "Error changing the state, try again");
		}
	}

	/*
	 * Method to get the notification of a recipient
	 */
	public void getNotification() throws NumberFormatException, SQLException, Exception {
		String[] notifications;
		notifications = Control_notification.getNotifications(Integer.parseInt(textDestination.getText()));
		if(notifications != null) {
			String n = " ";
			for(int i = 0 ; i<notifications.length ; i++) n += notifications[i]+"\n";
			JTextArea msg = new JTextArea(n);
			msg.setLineWrap(true);
			msg.setWrapStyleWord(true);

			JScrollPane scrollPane = new JScrollPane(msg);

			JOptionPane.showMessageDialog(null, scrollPane);
		}else {
			showMessageDialog(null, "No notifications for this user");
		}
	}
}