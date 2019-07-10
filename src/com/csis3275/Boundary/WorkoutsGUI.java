package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class WorkoutsGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkoutsGUI window = new WorkoutsGUI();
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
	public WorkoutsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 862, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWorkouts = new JLabel("Workouts");
		lblWorkouts.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkouts.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblWorkouts.setBounds(371, 11, 106, 53);
		frame.getContentPane().add(lblWorkouts);
		
		JLabel lblWorkoutName = new JLabel("Workout Name");
		lblWorkoutName.setBounds(86, 86, 112, 32);
		frame.getContentPane().add(lblWorkoutName);
		
		JLabel lblWorkoutType = new JLabel("Workout Type");
		lblWorkoutType.setBounds(86, 129, 112, 23);
		frame.getContentPane().add(lblWorkoutType);
		
		JLabel lblCaloriesBurnt = new JLabel("Calories Burnt");
		lblCaloriesBurnt.setBounds(86, 163, 112, 23);
		frame.getContentPane().add(lblCaloriesBurnt);
		
		JLabel lblTotalTime = new JLabel("Total Time");
		lblTotalTime.setBounds(86, 195, 112, 23);
		frame.getContentPane().add(lblTotalTime);
		
		JLabel lblWorkoutDescription = new JLabel("Workout Description");
		lblWorkoutDescription.setBounds(86, 229, 112, 23);
		frame.getContentPane().add(lblWorkoutDescription);
		
		JLabel lblOutWorkoutName = new JLabel("Name");
		lblOutWorkoutName.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOutWorkoutName.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutWorkoutName.setBounds(246, 95, 213, 23);
		frame.getContentPane().add(lblOutWorkoutName);
		
		JLabel lblOutWorkoutType = new JLabel("Type");
		lblOutWorkoutType.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutWorkoutType.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOutWorkoutType.setBounds(246, 133, 213, 23);
		frame.getContentPane().add(lblOutWorkoutType);
		
		JLabel lblOutWorkoutCalories = new JLabel("Calories");
		lblOutWorkoutCalories.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutWorkoutCalories.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOutWorkoutCalories.setBounds(246, 167, 213, 23);
		frame.getContentPane().add(lblOutWorkoutCalories);
		
		JLabel lblOutWorkoutTime = new JLabel("Time");
		lblOutWorkoutTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutWorkoutTime.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOutWorkoutTime.setBounds(246, 199, 213, 23);
		frame.getContentPane().add(lblOutWorkoutTime);
		
		JLabel lblOutWorkoutDescription = new JLabel("Description");
		lblOutWorkoutDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutWorkoutDescription.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblOutWorkoutDescription.setBounds(246, 233, 213, 23);
		frame.getContentPane().add(lblOutWorkoutDescription);
	}

}
