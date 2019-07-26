package com.csis3275.Boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import com.csis3275.Controller.CalculateCaloriesNeeded;
import com.csis3275.Entities.BodyMeasurements;
import com.csis3275.Entities.CaloriesConsumed;
import com.csis3275.Entities.DailyActivity;
import com.csis3275.Entities.ProgressActivity;
import com.csis3275.Entities.UserDiet;

import javax.swing.JButton;
import javax.swing.JDialog;
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
/**
 * 
 * @author charanpreet Singh
 * ProgressActivityGUI
 */
public class ProgressActivityGUI {

	private JFrame frame;
	private JTextField txtInitialWeight;
	private JTextField txtGoalWeight;
	private JTextField txtCalBurned;
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
	private JTable table;
	private ArrayList<DailyActivity> daList=new ArrayList<DailyActivity>();
	private DailyActivityDAOImpl daI=new DailyActivityDAOImpl();
	private BodyMeasurementsDAOImpl bmI=new BodyMeasurementsDAOImpl();
	private BodyMeasurements bm=new BodyMeasurements();
	private ArrayList<BodyMeasurements> bmList=new ArrayList<BodyMeasurements>();
	private static String[] currUser=new String[2];
	private JTextField txtCalConsumed;
	private JTextField txtCalNeededConsm;
	private JTextField txtCurrWeight;
	private JRadioButton rdbtnBargraph;
	private JLabel lblCurrentCalNeeded;
	private JLabel txtUnit ;
	private JLabel lblCurrentDate;

	/**
	 * Launch the application.
	 * @param args which is String array which contains userEmail and userType.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(args.length>0)
					{
						currUser[0]=args[0];
						currUser[1]=args[1];
						
					}
					System.out.println("PA Email : "+currUser[0]);
					System.out.println("PA Type : "+currUser[1]);
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
		userplanPanel.setBounds(93, 99, 1196, 175);
		frame.getContentPane().add(userplanPanel);
		userplanPanel.setLayout(null);
		
		rdbtnBargraph = new JRadioButton("BarGraph");
		buttonGroup.add(rdbtnBargraph);
		rdbtnBargraph.setSelected(true);
		rdbtnBargraph.setBounds(790, 283, 127, 25);
		frame.getContentPane().add(rdbtnBargraph);
		
		JRadioButton rdbtnLinegraph = new JRadioButton("LineGraph");
		buttonGroup.add(rdbtnLinegraph);
		rdbtnLinegraph.setBounds(921, 283, 127, 25);
		frame.getContentPane().add(rdbtnLinegraph);
		
		JLabel lblWeight = new JLabel("Initial Weight : ");
		lblWeight.setBounds(29, 51, 96, 16);
		userplanPanel.add(lblWeight);
		
		txtInitialWeight = new JTextField();
		txtInitialWeight.setEditable(false);
		txtInitialWeight.setBounds(127, 48, 116, 22);
		userplanPanel.add(txtInitialWeight);
		txtInitialWeight.setColumns(10);
		
		JLabel lblGoalWeight = new JLabel("Goal Type :");
		lblGoalWeight.setBounds(29, 129, 85, 16);
		userplanPanel.add(lblGoalWeight);
		
		txtGoalWeight = new JTextField();
		txtGoalWeight.setEditable(false);
		txtGoalWeight.setBounds(127, 126, 116, 22);
		userplanPanel.add(txtGoalWeight);
		txtGoalWeight.setColumns(10);
		
		JLabel lblUpdateWeight = new JLabel("Calories Burned :");
		lblUpdateWeight.setBounds(295, 91, 109, 16);
		userplanPanel.add(lblUpdateWeight);
		
		txtCalBurned = new JTextField();
		txtCalBurned.setText("0");
		txtCalBurned.setBounds(421, 88, 116, 22);
		userplanPanel.add(txtCalBurned);
		txtCalBurned.setColumns(10);
		
		lblCurrentCalNeeded = new JLabel("Calories Needed to Consumed : ");
		lblCurrentCalNeeded.setBounds(549, 51, 185, 16);
		userplanPanel.add(lblCurrentCalNeeded);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if(txtCurrWeight.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter current Weight.");
				}else
				{
					ProgressActivity pa=getProgressData();
					String newd=paI.saveProgress(pa);
					CalculateCaloriesNeeded ccn=new CalculateCaloriesNeeded();
				if(!newd.isEmpty())
				{
				 double calneeded=ccn.calNeeded(txtCaloriesDifference.getText(), txtCalConsumed.getText(), txtCalBurned.getText(), currUser[0]);
				 if(calneeded>0)
				 {
					 lblCurrentCalNeeded.setText("Calories Needed to Consumed : ");
					 txtCalNeededConsm.setText(calneeded+"");
				 }else if(calneeded<0)
				 {
					 lblCurrentCalNeeded.setText("Calories Needed to Burned : ");
					 txtCalNeededConsm.setText(Math.abs(calneeded)+"");
				 }else {
					 lblCurrentCalNeeded.setText("Calories Needed to Consumed : ");
					 txtCalNeededConsm.setText(0+"");
				 }
				 updateTable();
				}else {
					JOptionPane.showMessageDialog(null, "Entry for "+pa.getDate()+" is already added you can update data.");
				}
				}
				
			}
		});
		btnAdd.setBounds(619, 125, 97, 25);
		userplanPanel.add(btnAdd);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setBounds(567, 13, 56, 16);
		userplanPanel.add(lblDate);
		
		lblCurrentDate = new JLabel("");
		lblCurrentDate.setBounds(615, 13, 119, 16);
		userplanPanel.add(lblCurrentDate);
		
		JLabel lblUnits = new JLabel("Units :");
		lblUnits.setBounds(58, 13, 56, 16);
		userplanPanel.add(lblUnits);
		
		txtUnit = new JLabel("lbs.");
		txtUnit.setBounds(127, 13, 56, 16);
		userplanPanel.add(txtUnit);
		
		JLabel lblPlanSelected = new JLabel("Plan Selected :");
		lblPlanSelected.setBounds(29, 91, 96, 16);
		userplanPanel.add(lblPlanSelected);
		
		txtPlanSelected = new JTextField();
		txtPlanSelected.setEditable(false);
		txtPlanSelected.setColumns(10);
		txtPlanSelected.setBounds(127, 88, 116, 22);
		userplanPanel.add(txtPlanSelected);
		
		JLabel lblCaloriesToBe = new JLabel("Calories Difference :");
		lblCaloriesToBe.setBounds(277, 48, 168, 16);
		userplanPanel.add(lblCaloriesToBe);
		
		txtCaloriesDifference = new JTextField();
		txtCaloriesDifference.setText("0");
		txtCaloriesDifference.setEditable(false);
		txtCaloriesDifference.setColumns(10);
		txtCaloriesDifference.setBounds(421, 45, 116, 22);
		userplanPanel.add(txtCaloriesDifference);
		
		chartPanel = new JPanel();
		chartPanel.setBounds(584, 317, 707, 345);
		frame.getContentPane().add(chartPanel);
		chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.X_AXIS));
		
		bmList=(ArrayList<BodyMeasurements>) bmI.getBodyDataList();
		
		txtUnit.setText(bmList.get(0).getWeightType());
		txtInitialWeight.setText(bmList.get(0).getWeight()+"");
		
		txtCalConsumed = new JTextField();
		txtCalConsumed.setText("0");
		txtCalConsumed.setColumns(10);
		txtCalConsumed.setBounds(421, 126, 116, 22);
		userplanPanel.add(txtCalConsumed);
		
		JLabel lblCaloriesConsumed = new JLabel("Calories Consumed : ");
		lblCaloriesConsumed.setBounds(277, 129, 127, 16);
		userplanPanel.add(lblCaloriesConsumed);
		
	
		JLabel lblCurrentWeight_1 = new JLabel("Current Weight :");
		lblCurrentWeight_1.setBounds(635, 91, 109, 16);
		userplanPanel.add(lblCurrentWeight_1);
		
		txtCalNeededConsm = new JTextField();
		txtCalNeededConsm.setEditable(false);
		txtCalNeededConsm.setText("0");
		txtCalNeededConsm.setColumns(10);
		txtCalNeededConsm.setBounds(736, 48, 116, 22);
		userplanPanel.add(txtCalNeededConsm);
		
		txtCurrWeight = new JTextField();
		txtCurrWeight.setColumns(10);
		txtCurrWeight.setBounds(736, 88, 116, 22);
		userplanPanel.add(txtCurrWeight);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(txtCurrWeight.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter current Weight.");
				}else {
				ProgressActivity pa=getProgressData();
				paI.updateProgress(pa);
				CalculateCaloriesNeeded ccn=new CalculateCaloriesNeeded();
				 double calneeded=ccn.calNeeded(txtCaloriesDifference.getText(), txtCalConsumed.getText(), txtCalBurned.getText(), currUser[0]);
				 if(calneeded>0)
				 {
					 lblCurrentCalNeeded.setText("Calories Needed to Consumed : ");
					 txtCalNeededConsm.setText(calneeded+"");
				 }else if(calneeded<0)
				 {
					 lblCurrentCalNeeded.setText("Calories Needed to Burned : ");
					 txtCalNeededConsm.setText(Math.abs(calneeded)+"");
				 }else {
					 lblCurrentCalNeeded.setText("Calories Needed to Consumed : ");
					 txtCalNeededConsm.setText(0+"");
				 }
				 
				 updateTable();
				}
			}
		});
		btnUpdate.setBounds(736, 125, 97, 25);
		userplanPanel.add(btnUpdate);
		
		JButton btnDailyActivity = new JButton("Daily Activity");
		btnDailyActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DailyActivitiesGUI.main(currUser);
			}
		});
		btnDailyActivity.setBounds(93, 712, 125, 25);
		frame.getContentPane().add(btnDailyActivity);
		
		JButton btnWalkingStatus = new JButton("Walking Status");
		btnWalkingStatus.setBounds(266, 712, 141, 25);
		btnWalkingStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			
				daList=daI.getDailyActivitiesList(currUser[0]);
				  			
					DefaultCategoryDataset dcd=new DefaultCategoryDataset();
					int j=0;
					for(int i=daList.size()-1;i>=0 && j<7;i--)
					{
						j++;
						double hr=daList.get(i).getWalkingHour();
						double min=daList.get(i).getWalkingMinute();
						double time=(hr)+(min*.01);
					dcd.addValue(time, "Hours",daList.get(i).getDate());
					}
					if(rdbtnBargraph.isSelected())
					{
					updateBarChart("Walking Status", "Date", "Hours", dcd);
					}else {
					updateLineChart("Walking Status", "Date", "Hours", dcd);
					}
			}
		});
		frame.getContentPane().add(btnWalkingStatus);
		
		JButton btnExerciseStatus = new JButton("Exercise Status");
		btnExerciseStatus.setBounds(465, 712, 134, 25);
		btnExerciseStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				daList=daI.getDailyActivitiesList(currUser[0]);				  			
					DefaultCategoryDataset dcd=new DefaultCategoryDataset();
					int j=0;
					for(int i=daList.size()-1;i>=0 && j<7;i--)
					{
						j++;
						double hr=daList.get(i).getExerciseHour();
						double min=daList.get(i).getExerciseMinute();
						double time=(hr)+(min*.01);
					dcd.addValue(time, "Hours",daList.get(i).getDate());
					}
					if(rdbtnBargraph.isSelected())
					{
					updateBarChart("Exercise Status", "Date", "Hours", dcd);
					}else {
					updateLineChart("Exercise Status", "Date", "Hours", dcd);
					}
			}
		});
		frame.getContentPane().add(btnExerciseStatus);
		
		updateData();
		
		
		JButton btnDietStatus = new JButton("Diet Status ");
		btnDietStatus.setBounds(664, 712, 111, 25);
		btnDietStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			ArrayList<Double> calList=new ArrayList<Double>();
			   calList=paI.getCaloriesConsumed(currUser[0]);				
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				int j=0;
				for(int i=calList.size()-1;i>=0 && j<7;i--)
				{
					j++;
					System.out.println(calList.get(i)+"Calories Consumed");
					
				dcd.addValue(calList.get(i), "Calories Consumed",udI.getLastDPDates(currUser[0]).get(i));
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
		btnSleepStatus.setBounds(825, 712, 116, 25);
		btnSleepStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				daList=daI.getDailyActivitiesList(currUser[0]);	  			
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				int j=0;
				for(int i=daList.size()-1;i>=0 && j<7;i--)
				{
					j++;
					double hr=daList.get(i).getSleepHour();
					double min=daList.get(i).getSleepMinute();
					double time=(hr)+(min*.01);
				dcd.addValue(time, "Hours",daList.get(i).getDate());
				}
				if(rdbtnBargraph.isSelected())
				{
				updateBarChart("Sleep Status", "Date", "Hours", dcd);
				}else {
				updateLineChart("Sleep Status", "Date", "Hours", dcd);
				}
				
			}
		});
		frame.getContentPane().add(btnSleepStatus);
		
		JButton btnGoalProgress = new JButton("Goal Progress");
		btnGoalProgress.setBounds(962, 712, 111, 25);
		btnGoalProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgressActivityDAOImpl paI=new ProgressActivityDAOImpl();
             ArrayList<ProgressActivity> paList=paI.getProgress(currUser[0]);
				ArrayList<BodyMeasurements> bmList=new ArrayList<BodyMeasurements>();
				bmList=(ArrayList<BodyMeasurements>) bmI.getBodyDataList();
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				dcd.addValue(bmList.get(0).getWeight(),bmList.get(0).getWeightType() , "Initial Weight");
				
				int j=0;
				for(int i=paList.size()-2;i>=0 && j<6;i--)
				{
					j++;	
				dcd.addValue(paList.get(i).getCurrentWeight(), bmList.get(0).getWeightType(),paList.get(i).getDate());
				}
				if(rdbtnBargraph.isSelected())
				{
				updateBarChart("Weight Status", "Date", "Weight "+bmList.get(0).getWeightType() , dcd);
				}else {
				updateLineChart("Weight Status", "Date", "Weight "+bmList.get(0).getWeightType() , dcd);
				}
			}
		});
		frame.getContentPane().add(btnGoalProgress);
		
		JButton btnDietActivity = new JButton("Diet Activity");
		btnDietActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DietGUI.main(currUser);
			}
		});
		btnDietActivity.setBounds(1115, 712, 111, 25);
		frame.getContentPane().add(btnDietActivity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 317, 438, 345);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblCalorieStatus = new JLabel("Calorie Status");
		lblCalorieStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCalorieStatus.setBounds(244, 287, 116, 21);
		frame.getContentPane().add(lblCalorieStatus);
		
	
		 updateTable();
	}
	/**
	 * updateBarChart() is method to create BarChart.
	 * @param title is a String, Title of BarChart. 
	 * @param categoryAxisLabel is a String, category Axis Label of BarChart.
	 * @param valueAxisLabel is a String, value Axis Label of BarChart.
	 * @param dataset contains data that is to be shown in Chart.
	 */
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
	/**
	 * updateLineChart() is method to create LineChart.
	 * @param title is a String, Title of LineChart. 
	 * @param categoryAxisLabel is a String, category Axis Label of LineChart.
	 * @param valueAxisLabel is a String, value Axis Label of LineChart.
	 * @param dataset contains data that is to be shown in LineChart.
	 */
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
	/**
	 * updateTable() used to update table.
	 */
	private void updateTable()
	{
		table.getSelectionModel();
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.addColumn("Date");
		dtm.addColumn("Calories Consumed");
		dtm.addColumn("Calories Burned");
		dtm.addColumn("Calories Req Difference");
		ArrayList<ProgressActivity> paList=new ArrayList<ProgressActivity>();
		paList=paI.getProgress(currUser[0]);
		for(ProgressActivity pa:paList)
		{
			dtm.addRow(pa.getVector());
		}
		table.setModel(dtm);
		
		}
	/**
	 * updateData() is used to update data in text fields as well as in labels.
	 */
	private void updateData()
	{
		BodyMeasurementsDAOImpl bmI=new BodyMeasurementsDAOImpl();
		ArrayList<BodyMeasurements> bList=bmI.getBodyDatabyEmail(currUser[0]);
		if(bList.size()>0)
		{
		txtPlanSelected.setText(bList.get(0).getFitnessPlanType());
		txtGoalWeight.setText(bList.get(0).getUserGoalType());
		txtUnit.setText(bList.get(0).getWeightType());
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		lblCurrentDate.setText(sdf.format(d));
		if(bList.get(0).getFitnessPlanType().equalsIgnoreCase("Stay Fit Plan")){
			
		}else if(bList.get(0).getFitnessPlanType().equalsIgnoreCase("Weight Loss Plan"))
		{
			setCalDiff(bList);
		}else if(bList.get(0).getFitnessPlanType().equalsIgnoreCase("Weight Gain Plan"))
		{
			setCalDiff(bList);
		}else
		{			
			 if(bList.get(0).getUserGoalType().contains("3 LB"))
			 {
				 txtCaloriesDifference.setText(""+400);
			 }else if(bList.get(0).getUserGoalType().contains("5 LB"))
			 {
				 txtCaloriesDifference.setText(""+700);
			 }
			 else if(bList.get(0).getUserGoalType().contains("7 LB"))
			 {
				 txtCaloriesDifference.setText(""+1000);
			 }else {
				 txtCaloriesDifference.setText(""+1400);
			 }
		}
		}	
		
	}
	
	/**
	 * sets the value for text field.
	 * @param bList is a ArrayList<BodyMeasurements> of BodyMeasurements Object.
	 */
	private void setCalDiff(ArrayList<BodyMeasurements> bList)
	{
		double calDiff=0;
		 if(bList.get(0).getUserGoalType().contains("0.5 LB"))
		 {
			 calDiff=42;
			
		 }else if(bList.get(0).getUserGoalType().contains("1 LB"))
		 {
			 calDiff=70;
		 }
		 else if(bList.get(0).getUserGoalType().contains("1.5 LB"))
		 {
			 calDiff=110;
		 }else {
			 calDiff=140;
		 }		
		 txtCaloriesDifference.setText(""+calDiff);
		 
	}
	
	/**
	 * getProgressData() is a method which sets the values for ProgressActivity object and return it. 
	 * @return pa which is ProgressActivity.
	 */
	private ProgressActivity getProgressData()
	{
		double calCons=Double.parseDouble(txtCalConsumed.getText());
		double calBurned=Double.parseDouble(txtCalBurned.getText());
		ProgressActivity pa=new ProgressActivity();
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		pa.setDate(sdf.format(d));
		pa.setUserEmail(currUser[0]);
		pa.setCurrentWeight(Double.parseDouble(txtCurrWeight.getText()));
		pa.setCaloriesBurned(calBurned);
		pa.setCaloriesConsumed(calCons);
		pa.setCaloriesDifference(Double.parseDouble(txtCaloriesDifference.getText()));
		return pa;
	}
	
}
