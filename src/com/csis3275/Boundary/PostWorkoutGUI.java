package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PostWorkoutGUI {

	private JFrame frame;
	private JTextField textFieldExerciseName;
	private JTextField textFieldExerciseType;
	private JTextField textFieldCaloriesBurnt;
	private JTextField textFieldTotalTime;
	private JTextField textFieldWorkoutType;
	private JTextArea textAreaDescription;
	
	private static final String USER_AGENT = "Mozilla/5.0";
	

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
		lblPostWorkout.setBounds(221, 11, 160, 43);
		frame.getContentPane().add(lblPostWorkout);
		
		JLabel lblExerciseName = new JLabel("Exercise Name");
		lblExerciseName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExerciseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblExerciseName.setBounds(151, 55, 131, 32);
		frame.getContentPane().add(lblExerciseName);
		
		JLabel lblExerciseType = new JLabel("Exercise Type");
		lblExerciseType.setHorizontalAlignment(SwingConstants.LEFT);
		lblExerciseType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExerciseType.setBounds(151, 94, 131, 32);
		frame.getContentPane().add(lblExerciseType);
		
		JLabel lblCaloriesBurnt = new JLabel("Calories Burnt");
		lblCaloriesBurnt.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaloriesBurnt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCaloriesBurnt.setBounds(151, 130, 131, 32);
		frame.getContentPane().add(lblCaloriesBurnt);
		
		JLabel lblExerciseDescription = new JLabel("Exercise Description");
		lblExerciseDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblExerciseDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExerciseDescription.setBounds(151, 164, 160, 32);
		frame.getContentPane().add(lblExerciseDescription);
		
		JLabel lblWorkoutType = new JLabel("Workout Type");
		lblWorkoutType.setHorizontalAlignment(SwingConstants.LEFT);
		lblWorkoutType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWorkoutType.setBounds(151, 325, 160, 32);
		frame.getContentPane().add(lblWorkoutType);
		
		JLabel lblTotalTime = new JLabel("Total Time");
		lblTotalTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalTime.setBounds(151, 282, 160, 32);
		frame.getContentPane().add(lblTotalTime);
		
		textFieldExerciseName = new JTextField();
		textFieldExerciseName.setBounds(334, 65, 131, 24);
		frame.getContentPane().add(textFieldExerciseName);
		textFieldExerciseName.setColumns(10);
		
		textFieldExerciseType = new JTextField();
		textFieldExerciseType.setColumns(10);
		textFieldExerciseType.setBounds(334, 100, 131, 24);
		frame.getContentPane().add(textFieldExerciseType);
		
		textFieldCaloriesBurnt = new JTextField();
		textFieldCaloriesBurnt.setColumns(10);
		textFieldCaloriesBurnt.setBounds(334, 136, 131, 24);
		frame.getContentPane().add(textFieldCaloriesBurnt);
		
		textFieldTotalTime = new JTextField();
		textFieldTotalTime.setColumns(10);
		textFieldTotalTime.setBounds(334, 288, 131, 24);
		frame.getContentPane().add(textFieldTotalTime);
		
		textFieldWorkoutType = new JTextField();
		textFieldWorkoutType.setColumns(10);
		textFieldWorkoutType.setBounds(334, 331, 131, 24);
		frame.getContentPane().add(textFieldWorkoutType);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setBounds(334, 170, 238, 107);
		frame.getContentPane().add(textAreaDescription);
		
		JButton btnPostWorkout = new JButton("Post Workout");
		btnPostWorkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					postWorkout();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPostWorkout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPostWorkout.setBounds(236, 368, 151, 43);
		frame.getContentPane().add(btnPostWorkout);
	}
	
	public void postWorkout() throws IOException {
		URL obj = new URL("http://localhost:8080/exercises");
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		
		conn.setRequestMethod("POST");
		conn.setRequestProperty("User-Agent", USER_AGENT);
		
		conn.setDoOutput(true);
		
		String exerciseName = textFieldExerciseName.getText();
		String exerciseType = textFieldExerciseType.getText();
		double calB = Double.parseDouble(textFieldCaloriesBurnt.getText());
		String exerciseDescription = textAreaDescription.getText();
		int totalTime = Integer.parseInt(textFieldTotalTime.getText());
		String workoutType = textFieldWorkoutType.getText();
		
		exerciseDescription = exerciseDescription.replace("\n", ",");

		String exerciseString = "{\"exerciseName\":\"" + exerciseName
				+ "\",\"exerciseType\":\"" + exerciseType
				+ "\",\"caloriesBurnt\":" + calB
				+ ",\"exerciseDescription\":\"" + exerciseDescription
				+ "\",\"totalTime\":" + totalTime
				+ ",\"workoutType\":\"" + workoutType+"\"}";
		
		byte[] out = exerciseString.getBytes(StandardCharsets.UTF_8);
		int	length = out.length;

		conn.setFixedLengthStreamingMode(length);
		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		conn.connect();
		try(OutputStream os = conn.getOutputStream()) {
			os.write(out);
		}
		
		
	}
	
}
