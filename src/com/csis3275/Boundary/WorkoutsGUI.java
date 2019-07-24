package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.csis3275.Entities.BodyMeasurements;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkoutsGUI {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tm = new DefaultTableModel();
	private JSONArray jArray = new JSONArray();
	private JSONObject jsonObj;
	private ListSelectionListener lsl;
	private JTextArea textAreaExerciseDescription;
	static String[] currentUser = new String[2];
	private BodyMeasurements bodyMeasurements;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					currentUser[1] = args[1];
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
		frame.setBounds(100, 100, 1027, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lsl = new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int currentId = (int) table.getValueAt(table.getSelectedRow(), 0);
				
				try {
					textAreaExerciseDescription.setText("");
					for (int i = 0; i < jArray.length(); ++i)
					{
						jsonObj = jArray.getJSONObject(i);
					int id = jsonObj.getInt("id");
					
						if(id == currentId) {
							
							textAreaExerciseDescription.setText(jsonObj.getString("exerciseDescription"));
								
						}
					}
					
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				
			}
		};
		
		JLabel lblWorkouts = new JLabel("Workouts");
		lblWorkouts.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkouts.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblWorkouts.setBounds(334, 11, 106, 53);
		frame.getContentPane().add(lblWorkouts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 75, 634, 297);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tm);
		table.getSelectionModel().addListSelectionListener(lsl);
		
		JLabel lblExerciseDescription = new JLabel("Exercise Description");
		lblExerciseDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExerciseDescription.setBounds(692, 76, 162, 22);
		frame.getContentPane().add(lblExerciseDescription);
		
		textAreaExerciseDescription = new JTextArea();
		textAreaExerciseDescription.setLineWrap(true);
		textAreaExerciseDescription.setWrapStyleWord(true);
		textAreaExerciseDescription.setBounds(688, 112, 300, 260);
		frame.getContentPane().add(textAreaExerciseDescription);
	
		updateTable();
		
	}
	
	@SuppressWarnings("rawtypes")
	public void updateTable() {
		
		table.getSelectionModel().removeListSelectionListener(lsl);
		
		tm = new DefaultTableModel();
		
		tm.addColumn("Id");
		tm.addColumn("Exercise Name");
		tm.addColumn("Exercise Type");
		tm.addColumn("Calories Burnt");
		tm.addColumn("Total Time(min)");
		tm.addColumn("Workout Type");
		
		getExercises();
		
		if(UserGoals.numberOfHealthProblems > 3) {
			
			try {
				for (int i = 0; i < jArray.length(); ++i)
				{
					jsonObj = jArray.getJSONObject(i);
					String workoutType = jsonObj.getString("workoutType");
				
					if(workoutType.equals("Light")) {
						tm.addRow(getVector().get(i));
					}
				}
				
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			
		}
		
		else if(UserGoals.numberOfHealthProblems >= 1 && UserGoals.numberOfHealthProblems <= 3) {
			try {
				for (int i = 0; i < jArray.length(); ++i)
				{
					jsonObj = jArray.getJSONObject(i);
					String workoutType = jsonObj.getString("workoutType");
				
					if(workoutType.equals("Medium")) {
						tm.addRow(getVector().get(i));
					}
				}
				
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		else if(UserGoals.numberOfHealthProblems == 0) {
			try {
				for (int i = 0; i < jArray.length(); ++i)
				{
					jsonObj = jArray.getJSONObject(i);
					//String workoutType = jsonObj.getString("workoutType");
				
						tm.addRow(getVector().get(i));
				}
				
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		
		table.setModel(tm);
		table.getSelectionModel().addListSelectionListener(lsl);
	}
	
	public void getExercises() {
		String url = "http://localhost:8080/exercises";
		try {
			URL obj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			
			int responseCode= conn.getResponseCode();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			jArray = new JSONArray(response.toString());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<Vector> getVector() {
		ArrayList<Vector> vl = new ArrayList<Vector>();
		try {
			for (int i = 0; i < jArray.length(); ++i)
			{
				jsonObj = jArray.getJSONObject(i);
				Vector v = new Vector();
			v.add(jsonObj.getInt("id"));
			v.add(jsonObj.get("exerciseName"));
			v.add(jsonObj.get("exerciseType"));
			v.add(jsonObj.getDouble("caloriesBurnt"));
			v.add(jsonObj.getInt("totalTime"));
			v.add(jsonObj.get("workoutType"));
			vl.add(v);
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return vl;
	}
}
