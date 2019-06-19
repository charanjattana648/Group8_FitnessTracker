package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JDialog;
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
	private ButtonGroup unitBtnGroup = new ButtonGroup();
	private ButtonGroup fitnessGoalsBtnGroup = new ButtonGroup();
	private JPanel panelWeightLoss;
	private JLabel lblWeightLossPlan;
	private JRadioButton rdbtnLooseLb;
	private JRadioButton rdbtnLooseLb_1;
	private JRadioButton rdbtnLooseLb_2;
	private JRadioButton rdbtnLooseLb_3;
	private ButtonGroup weightLossGroup = new ButtonGroup();
	private JPanel panelWeightGain;
	private JLabel lblWeightGainPlan;
	private JRadioButton rdbtnGainLb;
	private JRadioButton rdbtnGainLb_1;
	private JRadioButton rdbtnGainLb_2;
	private JRadioButton rdbtnGainLb_3;
	private ButtonGroup weightGainGroup = new ButtonGroup();
	private JPanel panelExtremeWeightLoss;
	private JLabel lblExtremeWeightLoss;
	private JRadioButton rdbtnEXLooseLb_1;
	private JRadioButton rdbtnEXLooseLb_2;
	private JRadioButton rdbtnExLooseLb_3;
	private JRadioButton rdbtnExLooseLb_4;
	private ButtonGroup extremeLossGroup = new ButtonGroup();
	private JButton btnFindWorkouts;
	private JPanel panelStayFit;
	private JLabel lblClickOnFind;

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
		lblSetFitnessGoals_1.setBounds(279, 194, 160, 38);
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
		rdbtnStayFitPlan.setBounds(279, 249, 109, 23);
		frame.getContentPane().add(rdbtnStayFitPlan);
		
		JRadioButton rdbtnWeightGainPlan = new JRadioButton("Weight Gain Plan");
		rdbtnWeightGainPlan.setBounds(279, 327, 109, 23);
		frame.getContentPane().add(rdbtnWeightGainPlan);
		
		JRadioButton rdbtnWeightLossPlan = new JRadioButton("Weight Loss Plan");
		rdbtnWeightLossPlan.setBounds(279, 288, 109, 23);
		frame.getContentPane().add(rdbtnWeightLossPlan);
		
		JRadioButton rdbtnExtremeWeightLoss = new JRadioButton("Extreme Weight Loss Plan");
		rdbtnExtremeWeightLoss.setBounds(279, 364, 152, 23);
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
		
		panelStayFit = new JPanel();
		panelStayFit.setBounds(469, 255, 270, 113);
		frame.getContentPane().add(panelStayFit);
		panelStayFit.setLayout(null);
		panelStayFit.setVisible(false);
		
		lblClickOnFind = new JLabel("Click on Find Workouts");
		lblClickOnFind.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickOnFind.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClickOnFind.setBounds(35, 38, 171, 52);
		panelStayFit.add(lblClickOnFind);
		
		panelWeightLoss = new JPanel();
		panelWeightLoss.setBounds(469, 250, 270, 126);
		frame.getContentPane().add(panelWeightLoss);
		panelWeightLoss.setLayout(null);
		panelWeightLoss.setVisible(false);
		
		lblWeightLossPlan = new JLabel("Weight Loss Plan (Weekly)");
		lblWeightLossPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeightLossPlan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWeightLossPlan.setBounds(50, 11, 183, 24);
		panelWeightLoss.add(lblWeightLossPlan);
		
		rdbtnLooseLb = new JRadioButton("Loose 0.5 LB");
		rdbtnLooseLb.setBounds(18, 46, 99, 23);
		panelWeightLoss.add(rdbtnLooseLb);
		
		rdbtnLooseLb_1 = new JRadioButton("Loose 1 LB");
		rdbtnLooseLb_1.setBounds(144, 46, 99, 23);
		panelWeightLoss.add(rdbtnLooseLb_1);
		
		rdbtnLooseLb_2 = new JRadioButton("Loose 1.5 LB");
		rdbtnLooseLb_2.setBounds(18, 80, 109, 23);
		panelWeightLoss.add(rdbtnLooseLb_2);
		
		rdbtnLooseLb_3 = new JRadioButton("Loose 2 LB");
		rdbtnLooseLb_3.setBounds(144, 80, 109, 23);
		panelWeightLoss.add(rdbtnLooseLb_3);
		
		panelExtremeWeightLoss = new JPanel();
		panelExtremeWeightLoss.setBounds(469, 249, 270, 122);
		frame.getContentPane().add(panelExtremeWeightLoss);
		panelExtremeWeightLoss.setLayout(null);
		panelExtremeWeightLoss.setVisible(false);
		
		lblExtremeWeightLoss = new JLabel("Extreme Weight Loss Plan (Monthly)");
		lblExtremeWeightLoss.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtremeWeightLoss.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExtremeWeightLoss.setBounds(10, 5, 250, 42);
		panelExtremeWeightLoss.add(lblExtremeWeightLoss);
		
		rdbtnEXLooseLb_1 = new JRadioButton("Loose 3 LB");
		rdbtnEXLooseLb_1.setBounds(20, 45, 109, 23);
		panelExtremeWeightLoss.add(rdbtnEXLooseLb_1);
		
		rdbtnEXLooseLb_2 = new JRadioButton("Loose 5 LB");
		rdbtnEXLooseLb_2.setBounds(131, 45, 109, 23);
		panelExtremeWeightLoss.add(rdbtnEXLooseLb_2);
		
		rdbtnExLooseLb_3 = new JRadioButton("Loose 7 LB");
		rdbtnExLooseLb_3.setBounds(20, 80, 109, 23);
		panelExtremeWeightLoss.add(rdbtnExLooseLb_3);
		
		rdbtnExLooseLb_4 = new JRadioButton("Loose 10 LB");
		rdbtnExLooseLb_4.setBounds(131, 80, 109, 23);
		panelExtremeWeightLoss.add(rdbtnExLooseLb_4);
		
		panelWeightGain = new JPanel();
		panelWeightGain.setBounds(469, 250, 270, 126);
		frame.getContentPane().add(panelWeightGain);
		panelWeightGain.setLayout(null);
		panelWeightGain.setVisible(false);
		
		lblWeightGainPlan = new JLabel("Weight Gain Plan (Weekly)");
		lblWeightGainPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeightGainPlan.setBounds(45, 5, 182, 25);
		lblWeightGainPlan.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelWeightGain.add(lblWeightGainPlan);
		
		rdbtnGainLb = new JRadioButton("Gain 0.5 LB");
		rdbtnGainLb.setBounds(17, 37, 109, 23);
		panelWeightGain.add(rdbtnGainLb);
		
		rdbtnGainLb_1 = new JRadioButton("Gain 1 LB");
		rdbtnGainLb_1.setBounds(141, 37, 109, 23);
		panelWeightGain.add(rdbtnGainLb_1);
		
		rdbtnGainLb_2 = new JRadioButton("Gain 1.5 LB");
		rdbtnGainLb_2.setBounds(17, 77, 109, 23);
		panelWeightGain.add(rdbtnGainLb_2);
		
		rdbtnGainLb_3 = new JRadioButton("Gain 2 LB");
		rdbtnGainLb_3.setBounds(141, 77, 109, 23);
		panelWeightGain.add(rdbtnGainLb_3);
		
		
		unitBtnGroup.add(rdbtnMetric);
		unitBtnGroup.add(rdbtnImperial);
		
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
		
		
		fitnessGoalsBtnGroup.add(rdbtnStayFitPlan);
		fitnessGoalsBtnGroup.add(rdbtnWeightGainPlan);
		fitnessGoalsBtnGroup.add(rdbtnWeightLossPlan);
		fitnessGoalsBtnGroup.add(rdbtnExtremeWeightLoss);
		
		weightGainGroup.add(rdbtnGainLb);
		weightGainGroup.add(rdbtnGainLb_1);
		weightGainGroup.add(rdbtnGainLb_2);
		weightGainGroup.add(rdbtnGainLb_3);
		
		weightLossGroup.add(rdbtnLooseLb);
		weightLossGroup.add(rdbtnLooseLb_1);
		weightLossGroup.add(rdbtnLooseLb_2);
		weightLossGroup.add(rdbtnLooseLb_3);
		
		extremeLossGroup.add(rdbtnEXLooseLb_1);
		extremeLossGroup.add(rdbtnEXLooseLb_2);
		extremeLossGroup.add(rdbtnExLooseLb_3);
		extremeLossGroup.add(rdbtnExLooseLb_4);
		
		rdbtnStayFitPlan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelWeightGain.setVisible(false);
				panelWeightLoss.setVisible(false);
				panelExtremeWeightLoss.setVisible(false);
				panelStayFit.setVisible(true);
				
			}
		});
		
		rdbtnWeightGainPlan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelWeightLoss.setVisible(false);
				panelExtremeWeightLoss.setVisible(false);
				panelStayFit.setVisible(false);
				panelWeightGain.setVisible(true);
				
			}
		});
		
		rdbtnWeightLossPlan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelExtremeWeightLoss.setVisible(false);
				panelStayFit.setVisible(false);
				panelWeightGain.setVisible(false);
				panelWeightLoss.setVisible(true);
				
			}
		});
		
		rdbtnExtremeWeightLoss.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelWeightGain.setVisible(false);
				panelWeightLoss.setVisible(false);
				panelStayFit.setVisible(false);
				panelExtremeWeightLoss.setVisible(true);
				
			}
		});
		
		
		JButton btnCalculateBmi = new JButton("Calculate BMI");
		btnCalculateBmi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalculateBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userDetails = new BodyMeasurements();
					
				
				if(rdbtnImperial.isSelected()) {
					
					if(textFieldHeightFeets.getText().isEmpty() || textFieldHeightInches.getText().isEmpty()
							|| textFieldWeightImperial.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Please Enter Height and weight Values");
					}
					
					else {
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
				}
				
				else if(rdbtnMetric.isSelected()){
					
					if(textFieldHeightMetric.getText().isEmpty() || textFieldWeightMetric.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Please Enter Height and weight Values");
					}
					else {
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
				if(chckbxDizziness.isSelected()) {
					healthProblems += chckbxDizziness.getText().toString() + "\n";
				}
				if(chckbxChestPain.isSelected()) {
					healthProblems += chckbxChestPain.getText().toString() + "\n";
				}
				textAreaHealthProblems.setText(healthProblems);
			}
		});
		btnAddHealthProblems.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddHealthProblems.setBounds(68, 419, 161, 35);
		frame.getContentPane().add(btnAddHealthProblems);
		
		
		
		btnFindWorkouts = new JButton("Find Workouts");
		btnFindWorkouts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Have paitence work in progress");
				
			}
		});
		btnFindWorkouts.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFindWorkouts.setBounds(420, 413, 137, 35);
		frame.getContentPane().add(btnFindWorkouts);
		
	}
}