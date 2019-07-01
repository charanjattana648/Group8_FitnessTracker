package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProgressActivityGUI {

	private JFrame frame;
	private JTextField txtInitialWeight;
	private JTextField txtGoalWeight;
	private JTextField txtCurrentWeight;
	private JTable table;
	private JTextField txtPlanSelected;
	private JTextField txtCaloriesDifference;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressActivityGUI window = new ProgressActivityGUI();
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
	public ProgressActivityGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1372, 830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProgressActivity = new JLabel("Progress Activity");
		lblProgressActivity.setBounds(630, 34, 185, 25);
		lblProgressActivity.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblProgressActivity);
		
		JPanel userplanPanel = new JPanel();
		userplanPanel.setBounds(93, 99, 1196, 128);
		frame.getContentPane().add(userplanPanel);
		userplanPanel.setLayout(null);
		
		JLabel lblWeight = new JLabel("Initial Weight : ");
		lblWeight.setBounds(29, 51, 96, 16);
		userplanPanel.add(lblWeight);
		
		txtInitialWeight = new JTextField();
		txtInitialWeight.setBounds(127, 48, 116, 22);
		userplanPanel.add(txtInitialWeight);
		txtInitialWeight.setColumns(10);
		
		JLabel lblGoalWeight = new JLabel("Goal Weight :");
		lblGoalWeight.setBounds(301, 54, 85, 16);
		userplanPanel.add(lblGoalWeight);
		
		txtGoalWeight = new JTextField();
		txtGoalWeight.setBounds(399, 51, 116, 22);
		userplanPanel.add(txtGoalWeight);
		txtGoalWeight.setColumns(10);
		
		JLabel lblUpdateWeight = new JLabel("Current Weight : ");
		lblUpdateWeight.setBounds(605, 49, 104, 16);
		userplanPanel.add(lblUpdateWeight);
		
		txtCurrentWeight = new JTextField();
		txtCurrentWeight.setBounds(721, 46, 116, 22);
		userplanPanel.add(txtCurrentWeight);
		txtCurrentWeight.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(871, 45, 97, 25);
		userplanPanel.add(btnUpdate);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setBounds(567, 13, 56, 16);
		userplanPanel.add(lblDate);
		
		JLabel lblCurrentDate = new JLabel("");
		lblCurrentDate.setBounds(615, 13, 56, 16);
		userplanPanel.add(lblCurrentDate);
		
		JLabel lblUnits = new JLabel("Units :");
		lblUnits.setBounds(58, 13, 56, 16);
		userplanPanel.add(lblUnits);
		
		JLabel txtUnit = new JLabel("lbs.");
		txtUnit.setBounds(127, 13, 56, 16);
		userplanPanel.add(txtUnit);
		
		JLabel lblPlanSelected = new JLabel("Plan Selected ");
		lblPlanSelected.setBounds(29, 99, 96, 16);
		userplanPanel.add(lblPlanSelected);
		
		txtPlanSelected = new JTextField();
		txtPlanSelected.setColumns(10);
		txtPlanSelected.setBounds(127, 96, 116, 22);
		userplanPanel.add(txtPlanSelected);
		
		JLabel lblCaloriesToBe = new JLabel("Calories Difference :");
		lblCaloriesToBe.setBounds(301, 99, 168, 16);
		userplanPanel.add(lblCaloriesToBe);
		
		txtCaloriesDifference = new JTextField();
		txtCaloriesDifference.setColumns(10);
		txtCaloriesDifference.setBounds(479, 96, 116, 22);
		userplanPanel.add(txtCaloriesDifference);
		
		JPanel panel = new JPanel();
		panel.setBounds(672, 269, 616, 393);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 269, 548, 393);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnPreviousActivity = new JButton("Previous Activity");
		btnPreviousActivity.setBounds(93, 712, 125, 25);
		frame.getContentPane().add(btnPreviousActivity);
		
		JButton btnWalkingStatus = new JButton("Walking Status");
		btnWalkingStatus.setBounds(266, 712, 141, 25);
		frame.getContentPane().add(btnWalkingStatus);
		
		JButton btnExerciseStatus = new JButton("Exercise Status");
		btnExerciseStatus.setBounds(465, 712, 134, 25);
		frame.getContentPane().add(btnExerciseStatus);
		
		JButton btnDietStatus = new JButton("Diet Status ");
		btnDietStatus.setBounds(664, 712, 97, 25);
		frame.getContentPane().add(btnDietStatus);
		
		JButton btnSleepStatus = new JButton("Sleep Status");
		btnSleepStatus.setBounds(844, 712, 97, 25);
		frame.getContentPane().add(btnSleepStatus);
		
		JButton btnGoalProgress = new JButton("Goal Progress");
		btnGoalProgress.setBounds(976, 712, 97, 25);
		frame.getContentPane().add(btnGoalProgress);
		
		JButton btnNextActivity = new JButton("Next Activity");
		btnNextActivity.setBounds(1115, 712, 97, 25);
		frame.getContentPane().add(btnNextActivity);
		
		JLabel lblTable = new JLabel("Table");
		lblTable.setBounds(266, 240, 56, 16);
		frame.getContentPane().add(lblTable);
		
		JLabel lblChart = new JLabel("Chart");
		lblChart.setBounds(941, 240, 56, 16);
		frame.getContentPane().add(lblChart);
	}
}
