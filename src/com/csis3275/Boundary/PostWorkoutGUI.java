package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PostWorkoutGUI {

	private JFrame frame;
	private JTextField textFieldExerciseName;
	private JTextField textFieldExerciseType;
	private JTextField textFieldCaloriesBurnt;
	private JTextField textFieldDescription;
	private JTextField textFieldTotalTime;
	private JTextField textFieldWorkoutType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostWorkoutGUI window = new PostWorkoutGUI();
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
	public PostWorkoutGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPostWorkout = new JLabel("Post Workout");
		lblPostWorkout.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostWorkout.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPostWorkout.setBounds(221, 27, 160, 43);
		frame.getContentPane().add(lblPostWorkout);
		
		JLabel lblExerciseName = new JLabel("Exercise Name");
		lblExerciseName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExerciseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblExerciseName.setBounds(151, 82, 131, 32);
		frame.getContentPane().add(lblExerciseName);
		
		JLabel lblExerciseType = new JLabel("Exercise Type");
		lblExerciseType.setHorizontalAlignment(SwingConstants.LEFT);
		lblExerciseType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExerciseType.setBounds(151, 125, 131, 32);
		frame.getContentPane().add(lblExerciseType);
		
		JLabel lblCaloriesBurnt = new JLabel("Calories Burnt");
		lblCaloriesBurnt.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaloriesBurnt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCaloriesBurnt.setBounds(151, 168, 131, 32);
		frame.getContentPane().add(lblCaloriesBurnt);
		
		JLabel lblExerciseDescription = new JLabel("Exercise Description");
		lblExerciseDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblExerciseDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExerciseDescription.setBounds(151, 211, 160, 32);
		frame.getContentPane().add(lblExerciseDescription);
		
		JLabel lblWorkoutType = new JLabel("Workout Type");
		lblWorkoutType.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkoutType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWorkoutType.setBounds(151, 291, 160, 32);
		frame.getContentPane().add(lblWorkoutType);
		
		JLabel lblTotalTime = new JLabel("Total Time");
		lblTotalTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalTime.setBounds(151, 254, 160, 32);
		frame.getContentPane().add(lblTotalTime);
		
		textFieldExerciseName = new JTextField();
		textFieldExerciseName.setBounds(334, 90, 131, 24);
		frame.getContentPane().add(textFieldExerciseName);
		textFieldExerciseName.setColumns(10);
		
		textFieldExerciseType = new JTextField();
		textFieldExerciseType.setColumns(10);
		textFieldExerciseType.setBounds(334, 133, 131, 24);
		frame.getContentPane().add(textFieldExerciseType);
		
		textFieldCaloriesBurnt = new JTextField();
		textFieldCaloriesBurnt.setColumns(10);
		textFieldCaloriesBurnt.setBounds(334, 176, 131, 24);
		frame.getContentPane().add(textFieldCaloriesBurnt);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(334, 219, 131, 24);
		frame.getContentPane().add(textFieldDescription);
		
		textFieldTotalTime = new JTextField();
		textFieldTotalTime.setColumns(10);
		textFieldTotalTime.setBounds(334, 256, 131, 24);
		frame.getContentPane().add(textFieldTotalTime);
		
		textFieldWorkoutType = new JTextField();
		textFieldWorkoutType.setColumns(10);
		textFieldWorkoutType.setBounds(334, 299, 131, 24);
		frame.getContentPane().add(textFieldWorkoutType);
		
		JButton btnPostWorkout = new JButton("Post Workout");
		btnPostWorkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnPostWorkout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPostWorkout.setBounds(242, 344, 151, 43);
		frame.getContentPane().add(btnPostWorkout);
	}
}
