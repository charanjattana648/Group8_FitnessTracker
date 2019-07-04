package com.csis3275.Boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.csis3275.Entities.BodyMeasurements;
import com.csis3275.Entities.CaloriesConsumed;
import com.csis3275.Entities.DailyActivity;
import com.csis3275.Entities.ProgressActivity;
import com.csis3275.Entities.UserDiet;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ProgressActivityGUI {

	private JFrame frame;
	private JTextField txtInitialWeight;
	private JTextField txtGoalWeight;
	private JTextField txtCurrentWeight;
	private JTextField txtPlanSelected;
	private JTextField txtCaloriesDifference;
	private JPanel chartPanel;
	private ProgressActivityDAOImpl paI=new ProgressActivityDAOImpl();
	private ArrayList<UserDiet> udList=new ArrayList<UserDiet>();
	private CaloriesConsumed cc =new CaloriesConsumed(); 
	private UserDietDAOImpl udI=new UserDietDAOImpl();
	private DefaultTableModel dtm=new DefaultTableModel();
	private JLabel lblProgressActivity;
	private JPanel userplanPanel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnBargraph;
	private JRadioButton rdbtnLinegraph;
	private JTable table;
	private String currUser="csis@gmail.com";
	private ArrayList<DailyActivity> daList=new ArrayList<DailyActivity>();
	private DailyActivityDAOImpl daI=new DailyActivityDAOImpl();
	private BodyMeasurementsDAOImpl bmI=new BodyMeasurementsDAOImpl();
	private BodyMeasurements bm=new BodyMeasurements();

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
		
		lblProgressActivity = new JLabel("Progress Activity");
		lblProgressActivity.setBounds(630, 34, 185, 25);
		lblProgressActivity.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblProgressActivity);
		
		userplanPanel = new JPanel();
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
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgressActivity pa=new ProgressActivity();
				Date d=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat();
				pa.setDate(sdf.format(d));
				pa.setUserEmail(currUser);
				pa.setCurrentWeight(Double.parseDouble(txtCurrentWeight.getText()));
				pa.setCaloriesBurned(50);
				pa.setCaloriesConsumed(220);				
				paI.saveProgress(pa);
				
			}
		});
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
		
		rdbtnBargraph = new JRadioButton("BarGraph");
		buttonGroup.add(rdbtnBargraph);
		rdbtnBargraph.setSelected(true);
		rdbtnBargraph.setBounds(677, 95, 127, 25);
		userplanPanel.add(rdbtnBargraph);
		
		rdbtnLinegraph = new JRadioButton("LineGraph");
		buttonGroup.add(rdbtnLinegraph);
		rdbtnLinegraph.setBounds(808, 95, 127, 25);
		userplanPanel.add(rdbtnLinegraph);
		
		chartPanel = new JPanel();
		chartPanel.setBounds(584, 269, 707, 393);
		frame.getContentPane().add(chartPanel);
		chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.X_AXIS));
		
		JButton btnPreviousActivity = new JButton("Previous Activity");
		btnPreviousActivity.setBounds(93, 712, 125, 25);
		frame.getContentPane().add(btnPreviousActivity);
		
		JButton btnWalkingStatus = new JButton("Walking Status");
		btnWalkingStatus.setBounds(266, 712, 141, 25);
		btnWalkingStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				daList=daI.getDailyActivitiesList(currUser);
				  			
					DefaultCategoryDataset dcd=new DefaultCategoryDataset();
					for(int i=0;i<daList.size();++i)
					{
						double hr=daList.get(i).getWalkingHour();
						double min=daList.get(i).getWalkingMinute();
						double time=(hr*60)+min;
					dcd.addValue(time, "minutes",daList.get(i).getDate());
					}
					if(rdbtnBargraph.isSelected())
					{
					updateBarChart("Walking Status", "Date", "minutes", dcd);
					}else {
					updateLineChart("Walking Status", "Date", "minutes", dcd);
					}
			}
		});
		frame.getContentPane().add(btnWalkingStatus);
		
		JButton btnExerciseStatus = new JButton("Exercise Status");
		btnExerciseStatus.setBounds(465, 712, 134, 25);
		btnExerciseStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				daList=daI.getDailyActivitiesList(currUser);				  			
					DefaultCategoryDataset dcd=new DefaultCategoryDataset();
					for(int i=0;i<daList.size();++i)
					{
						double hr=daList.get(i).getExerciseHour();
						double min=daList.get(i).getExerciseMinute();
						double time=(hr*60)+min;
					dcd.addValue(time, "minutes",daList.get(i).getDate());
					}
					if(rdbtnBargraph.isSelected())
					{
					updateBarChart("Exercise Status", "Date", "minutes", dcd);
					}else {
					updateLineChart("Exercise Status", "Date", "minutes", dcd);
					}
			}
		});
		frame.getContentPane().add(btnExerciseStatus);
		
		JButton btnDietStatus = new JButton("Diet Status ");
		btnDietStatus.setBounds(664, 712, 97, 25);
		btnDietStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			ArrayList<Double> calList=new ArrayList<Double>();
			   calList=paI.getCaloriesConsumed(currUser);				
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				for(int i=0;i<calList.size();++i)
				{
					System.out.println(calList.get(i)+"Calories Consumed");
					
				dcd.addValue(calList.get(i), "Calories Consumed",udI.getLastDPDates(currUser).get(i));
				}
				if(rdbtnBargraph.isSelected())
				{
				updateBarChart("Diet Status", "Date", "Calories", dcd);
				}else {
				updateLineChart("Diet Status", "Date", "Calories", dcd);
				}
			}
		});
		frame.getContentPane().add(btnDietStatus);
		
		JButton btnSleepStatus = new JButton("Sleep Status");
		btnSleepStatus.setBounds(844, 712, 97, 25);
		btnSleepStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				daList=daI.getDailyActivitiesList(currUser);
	  			
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				for(int i=daList.size()-1;i>0;i--)
				{
					double hr=daList.get(i).getSleepHour();
					double min=daList.get(i).getSleepMinute();
					double time=(hr*60)+min;
				dcd.addValue(time, "minutes",daList.get(i).getDate());
				}
				if(rdbtnBargraph.isSelected())
				{
				updateBarChart("Sleep Status", "Date", "minutes", dcd);
				}else {
				updateLineChart("Sleep Status", "Date", "minutes", dcd);
				}
				
			}
		});
		frame.getContentPane().add(btnSleepStatus);
		
		JButton btnGoalProgress = new JButton("Goal Progress");
		btnGoalProgress.setBounds(976, 712, 97, 25);
		btnGoalProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
            // daList=daI.getDailyActivitiesList(currUser);
				ArrayList<BodyMeasurements> bmList=new ArrayList<BodyMeasurements>();
				bmList=(ArrayList<BodyMeasurements>) bmI.getBodyData();
             
	  		//getBodyData()	
				
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				dcd.addValue(bmList.get(0).getWeight(),bmList.get(0).getWeightType() , "Initial Weight");
//				for(int i=daList.size()-1;i>0;i--)
//				{
//					double hr=daList.get(i).getSleepHour();
//					double min=daList.get(i).getSleepMinute();
//					double time=(hr*60)+min;
//				dcd.addValue(time, "minutes",daList.get(i).getDate());
//				}
				if(rdbtnBargraph.isSelected())
				{
				updateBarChart("Sleep Status", "Date", "Weight"+bmList.get(0).getWeightType() , dcd);
				}else {
				updateLineChart("Sleep Status", "Date", "Weight"+bmList.get(0).getWeightType() , dcd);
				}
			}
		});
		frame.getContentPane().add(btnGoalProgress);
		
		JButton btnNextActivity = new JButton("Next Activity");
		btnNextActivity.setBounds(1115, 712, 97, 25);
		frame.getContentPane().add(btnNextActivity);
		
		JLabel lblLineChart = new JLabel("Line Chart");
		lblLineChart.setBounds(266, 240, 73, 16);
		frame.getContentPane().add(lblLineChart);
		
		JLabel lblChart = new JLabel("Bar Chart");
		lblChart.setBounds(941, 240, 73, 16);
		frame.getContentPane().add(lblChart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 269, 438, 393);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		 updateTable();
	}
	public void updateBarChart(String title,String categoryAxisLabel,String valueAxisLabel,DefaultCategoryDataset dataset)
	{		
		JFreeChart jfc=ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, dataset,PlotOrientation.VERTICAL,true,true,false);		
		CategoryPlot cp=jfc.getCategoryPlot();
		cp.setRangeGridlinePaint(Color.BLACK);
		ChartPanel cPanel=new ChartPanel(jfc);
		BarRenderer br=(BarRenderer) cp.getRenderer();
		//br.setBarPainter(painter);
		//br.setItemMargin(0.40);
		br.setMaximumBarWidth(0.1);
		chartPanel.removeAll();
		chartPanel.add(cPanel);
		chartPanel.updateUI();		
	}
	public void updateLineChart(String title,String categoryAxisLabel,String valueAxisLabel,DefaultCategoryDataset dataset)
	{		
		JFreeChart jfc=ChartFactory.createLineChart(title, categoryAxisLabel, valueAxisLabel, dataset,PlotOrientation.VERTICAL,true,true,false);		
		CategoryPlot cp=jfc.getCategoryPlot();
		cp.setRangeGridlinePaint(Color.BLACK);
		ChartPanel cPanel=new ChartPanel(jfc);
		chartPanel.removeAll();
		chartPanel.add(cPanel);
		chartPanel.updateUI();		
	}
	private void updateTable()
	{
		table.getSelectionModel();
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.addColumn("Date");
		dtm.addColumn("Calories Consumed");
		dtm.addColumn("Calories Burned");
		ArrayList<ProgressActivity> paList=new ArrayList<ProgressActivity>();
		paList=paI.getProgress(currUser);
		for(ProgressActivity pa:paList)
		{
			dtm.addRow(pa.getVector());
		}
		table.setModel(dtm);
		
		}
}
