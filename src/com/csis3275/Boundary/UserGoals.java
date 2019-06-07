package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

import com.csis3275.Controller.CalculateBMI;
import com.csis3275.Entities.BodyMeasurements;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class UserGoals {

	private JFrame frame;
	private static CalculateBMI bmi = new CalculateBMI();
	private BodyMeasurements userDetails;
	private DecimalFormat fmt;
	private JTextArea txtrBmiOutput;
	//CheckBoxes
	private JCheckBox chckboxDiabetes;
	private JCheckBox chckbxHypertension;
	private JCheckBox chckbxAsthma;
	private JCheckBox chckbxBoneOrJoint;
	private JCheckBox chckbxDizziness;
	private JCheckBox chckbxChestPain;
	private JTextArea textAreaHealthProblems;
	private JLabel lblChooseUnit;
	private JRadioButton rdbtnMetric;
	private JRadioButton rdbtnImperial;
	private JButton btnAddHealthProblems;
	private JTextField textFieldHeightFeets;
	private JTextField textFieldHeightInches;
	private JLabel labelHeightImperial;
	private JLabel labelWeightImperial;
	private JTextField textFieldWeightImperial;
	private JPanel panelMetric;
	private JPanel panelImperial;
	private JLabel lblHeightMetric;
	private JLabel lblWeightMetric;
	private JTextField textFieldHeightMetric;
	private JTextField textFieldWeightMetric;
	private ButtonGroup radBtnGrp = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGoals window = new UserGoals();
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
	public UserGoals() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelImperial = new JPanel();
		panelImperial.setBounds(22, 71, 218, 67);
		frame.getContentPane().add(panelImperial);
		panelImperial.setLayout(null);
		panelImperial.setVisible(false);
		
		textFieldHeightFeets = new JTextField();
		textFieldHeightFeets.setBounds(101, 11, 31, 20);
		textFieldHeightFeets.setColumns(10);
		panelImperial.add(textFieldHeightFeets);
		
		textFieldHeightInches = new JTextField();
		textFieldHeightInches.setBounds(142, 11, 45, 20);
		textFieldHeightInches.setColumns(10);
		panelImperial.add(textFieldHeightInches);
		
		labelHeightImperial = new JLabel("Height (Ft,In)");
		labelHeightImperial.setBounds(10, 14, 81, 14);
		panelImperial.add(labelHeightImperial);
		
		labelWeightImperial = new JLabel("Weight (lb)");
		labelWeightImperial.setBounds(10, 39, 81, 14);
		panelImperial.add(labelWeightImperial);
		
		textFieldWeightImperial = new JTextField();
		textFieldWeightImperial.setBounds(101, 36, 86, 20);
		textFieldWeightImperial.setColumns(10);
		panelImperial.add(textFieldWeightImperial);
		
		panelMetric = new JPanel();
		panelMetric.setBounds(22, 71, 218, 67);
		frame.getContentPane().add(panelMetric);
		panelMetric.setLayout(null);
		panelMetric.setVisible(false);
		
		lblHeightMetric = new JLabel("Height (CM)");
		lblHeightMetric.setBounds(12, 11, 72, 14);
		panelMetric.add(lblHeightMetric);
		
		lblWeightMetric = new JLabel("Weight (KG)");
		lblWeightMetric.setBounds(12, 36, 72, 14);
		panelMetric.add(lblWeightMetric);
		
		textFieldHeightMetric = new JTextField();
		textFieldHeightMetric.setBounds(94, 8, 86, 20);
		panelMetric.add(textFieldHeightMetric);
		textFieldHeightMetric.setColumns(10);
		
		textFieldWeightMetric = new JTextField();
		textFieldWeightMetric.setBounds(94, 33, 86, 20);
		panelMetric.add(textFieldWeightMetric);
		textFieldWeightMetric.setColumns(10);
		
		JLabel lblSetFitnessGoals = new JLabel("Get Fitness Status");
		lblSetFitnessGoals.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblSetFitnessGoals.setBounds(279, 11, 167, 38);
		lblSetFitnessGoals.setBackground(Color.GRAY);
		lblSetFitnessGoals.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblSetFitnessGoals.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblSetFitnessGoals);
		
		
		txtrBmiOutput = new JTextArea();
		txtrBmiOutput.setText("BMI output:");
		txtrBmiOutput.setBounds(279, 71, 460, 87);
		frame.getContentPane().add(txtrBmiOutput);
		
		JLabel lblSetFitnessGoals_1 = new JLabel("Set Fitness Goals");
		lblSetFitnessGoals_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblSetFitnessGoals_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetFitnessGoals_1.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblSetFitnessGoals_1.setBackground(Color.GRAY);
		lblSetFitnessGoals_1.setBounds(352, 178, 160, 38);
		frame.getContentPane().add(lblSetFitnessGoals_1);
		
		JLabel lblCheckMedication = new JLabel("Check Health Problems");
		lblCheckMedication.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckMedication.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblCheckMedication.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblCheckMedication.setBackground(Color.GRAY);
		lblCheckMedication.setBounds(22, 194, 218, 38);
		frame.getContentPane().add(lblCheckMedication);
		
		chckboxDiabetes = new JCheckBox("Diabetes");
		chckboxDiabetes.setBounds(22, 249, 97, 23);
		frame.getContentPane().add(chckboxDiabetes);
		
		chckbxHypertension = new JCheckBox("Hypertension");
		chckbxHypertension.setBounds(22, 275, 97, 23);
		frame.getContentPane().add(chckbxHypertension);
		
		chckbxAsthma = new JCheckBox("Asthma");
		chckbxAsthma.setBounds(22, 301, 97, 23);
		frame.getContentPane().add(chckbxAsthma);
		
		chckbxBoneOrJoint = new JCheckBox("Bone or Joint");
		chckbxBoneOrJoint.setBounds(22, 327, 97, 23);
		frame.getContentPane().add(chckbxBoneOrJoint);
		
		chckbxDizziness = new JCheckBox("Dizziness");
		chckbxDizziness.setBounds(22, 353, 97, 23);
		frame.getContentPane().add(chckbxDizziness);
		
		chckbxChestPain = new JCheckBox("Chest Pain");
		chckbxChestPain.setBounds(22, 379, 97, 23);
		frame.getContentPane().add(chckbxChestPain);
		
		textAreaHealthProblems = new JTextArea();
		textAreaHealthProblems.setFont(new Font("Monospaced", Font.BOLD, 13));
		textAreaHealthProblems.setBounds(129, 248, 111, 154);
		frame.getContentPane().add(textAreaHealthProblems);
		
		JRadioButton rdbtnStayFitPlan = new JRadioButton("Stay Fit Plan");
		rdbtnStayFitPlan.setBounds(308, 233, 109, 23);
		frame.getContentPane().add(rdbtnStayFitPlan);
		
		JRadioButton rdbtnWeightGainPaln = new JRadioButton("Weight Gain Plan");
		rdbtnWeightGainPaln.setBounds(447, 233, 109, 23);
		frame.getContentPane().add(rdbtnWeightGainPaln);
		
		JRadioButton rdbtnWeightLossPlan = new JRadioButton("Weight Loss Plan");
		rdbtnWeightLossPlan.setBounds(308, 285, 109, 23);
		frame.getContentPane().add(rdbtnWeightLossPlan);
		
		JRadioButton rdbtnExtremeWeightLoss = new JRadioButton("Extreme Weight Loss Plan");
		rdbtnExtremeWeightLoss.setBounds(447, 285, 152, 23);
		frame.getContentPane().add(rdbtnExtremeWeightLoss);
		
		lblChooseUnit = new JLabel("Choose Unit");
		lblChooseUnit.setBounds(24, 37, 70, 14);
		frame.getContentPane().add(lblChooseUnit);
		
		rdbtnMetric = new JRadioButton("Metric");
		rdbtnMetric.setBounds(101, 33, 70, 23);
		frame.getContentPane().add(rdbtnMetric);
		
		rdbtnImperial = new JRadioButton("Imperial");
		rdbtnImperial.setBounds(173, 33, 86, 23);
		frame.getContentPane().add(rdbtnImperial);
		
		radBtnGrp.add(rdbtnMetric);
		radBtnGrp.add(rdbtnImperial);
		
		rdbtnImperial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMetric.setVisible(false);
				panelImperial.setVisible(true);
			}
		});
		
		rdbtnMetric.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMetric.setVisible(true);
				panelImperial.setVisible(false);
				
			}
		});
		
		
		JButton btnCalculateBmi = new JButton("Calculate BMI");
		btnCalculateBmi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalculateBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userDetails = new BodyMeasurements();
					
				
				if(rdbtnImperial.isSelected()) {
					
					double heightFeets = Double.parseDouble(textFieldHeightFeets.getText().toString());
					double heightInches = Double.parseDouble(textFieldHeightInches.getText().toString());
					
					
					
					userDetails.setHeightFeets(heightFeets);
					userDetails.setHeightInches(heightInches);
					
					userDetails.setHeightType("inches");
					
					userDetails.setWeight(Double.parseDouble(textFieldWeightImperial.getText().toString()));
					userDetails.setWeightType("lb");
					
					fmt = new DecimalFormat("0.00");
					
					bmi.calculateBMI(userDetails);
					
					txtrBmiOutput.setText("BMI output = " + String.valueOf(fmt.format(bmi.calculateBMI(userDetails))) + "\n" 
					+ bmi.bmiResult());
				}
				
				else if(rdbtnMetric.isSelected()){
					userDetails.setHeightCm(Double.parseDouble(textFieldHeightMetric.getText().toString()));
					userDetails.setHeightType("cm");
					
					userDetails.setWeight(Double.parseDouble(textFieldWeightMetric.getText().toString()));
					userDetails.setWeightType("kg");
					
					fmt = new DecimalFormat("0.00");
					
					bmi.calculateBMI(userDetails);
					
					txtrBmiOutput.setText("BMI output = " + String.valueOf(fmt.format(bmi.calculateBMI(userDetails))) + "\n" 
					+ bmi.bmiResult());
				}
				
			}
		});
		btnCalculateBmi.setBounds(114, 147, 126, 38);
		frame.getContentPane().add(btnCalculateBmi);
		
		
		btnAddHealthProblems = new JButton("Add Health Problems");
		btnAddHealthProblems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String healthProblems = "";
				if(chckboxDiabetes.isSelected()) {
					healthProblems = chckboxDiabetes.getText().toString() + "\n";
				}
				if(chckbxHypertension.isSelected()) {
					healthProblems += chckbxHypertension.getText().toString() + "\n";
				}
				if(chckbxAsthma.isSelected()) {
					healthProblems += chckbxAsthma.getText().toString() + "\n";
				}
				if(chckbxBoneOrJoint.isSelected()) {
					healthProblems += chckbxBoneOrJoint.getText().toString() + "\n";
				}
				if(chckbxChestPain.isSelected()) {
					healthProblems += chckbxChestPain.getText().toString() + "\n";
				}
				if(chckbxDizziness.isSelected()) {
					healthProblems += chckbxDizziness.getText().toString() + "\n";
				}
				textAreaHealthProblems.setText(healthProblems);
			}
		});
		btnAddHealthProblems.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddHealthProblems.setBounds(68, 419, 161, 35);
		frame.getContentPane().add(btnAddHealthProblems);
		
	}
}
