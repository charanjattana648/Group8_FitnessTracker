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
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WorkoutsGUI {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tm = new DefaultTableModel();
	private JSONArray jArray = new JSONArray();
	private JSONObject jsonObj;

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
		lblWorkouts.setBounds(334, 11, 106, 53);
		frame.getContentPane().add(lblWorkouts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 75, 778, 289);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tm);
		
		updateTable();
		
	}
	
	@SuppressWarnings("rawtypes")
	public void updateTable() {
		
		tm = new DefaultTableModel();
		
		tm.addColumn("Id");
		tm.addColumn("Exercise Name");
		tm.addColumn("Exercise Type");
		tm.addColumn("Calories Burnt");
		tm.addColumn("Exercise Description");
		tm.addColumn("Total Time");
		tm.addColumn("Workout Type");
		
		getExercises();
		
		for(int i = 0; i < jArray.length(); ++i) {
			tm.addRow(getVector().get(i));
		}
		
		table.setModel(tm);
		
	}
	
	public void getExercises() {
		String url = "http://localhost:8080/exercises";
		try {
			URL obj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			
			int responseCode= conn.getResponseCode();
			
			System.out.println("Sending get request to url " + url);
			System.out.println("Response Code " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//System.out.println(response.toString());

			jArray = new JSONArray(response.toString());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<Vector> getVector() {
		//
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
			v.add(jsonObj.get("exerciseDescription"));
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
