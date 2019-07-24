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
	//private String currUser="csis@gmail.com";
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

	/**
	 * Launch the application.
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
		rdbtnBargraph.setSelected(true);
		rdbtnBargraph.setBounds(790, 283, 127, 25);
		frame.getContentPane().add(rdbtnBargraph);
		
		JRadioButton radioButton_1 = new JRadioButton("LineGraph");
		radioButton_1.setBounds(921, 283, 127, 25);
		frame.getContentPane().add(radioButton_1);
		
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
		//
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgressActivity pa=new ProgressActivity();
				Date d=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat();
				pa.setDate(sdf.format(d));
				pa.setUserEmail(currUser[0]);
				pa.setCurrentWeight(Double.parseDouble(txtCalBurned.getText()));
				pa.setCaloriesBurned(50);
				pa.setCaloriesConsumed(220);				
				paI.saveProgress(pa);
				
				 double calneeded=calNeeded();
				 if(calneeded>0)
				 {
					 lblCurrentCalNeeded.setText("Calories Needed to Consumed : ");
					 //calneeded=calneeded;
					 txtCalNeededConsm.setText(calneeded+"");
				 }else if(calneeded<0)
				 {
					 lblCurrentCalNeeded.setText("Calories Needed to Burned : ");
					 txtCalNeededConsm.setText(Math.abs(calneeded)+"");
				 }else {
					 lblCurrentCalNeeded.setText("Calories Needed to Consumed : ");
					 txtCalNeededConsm.setText(0+"");
				 }
				
			}
		});
		btnUpdate.setBounds(619, 125, 97, 25);
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
		txtCalNeededConsm.setText("0");
		txtCalNeededConsm.setColumns(10);
		txtCalNeededConsm.setBounds(736, 48, 116, 22);
		userplanPanel.add(txtCalNeededConsm);
		
		txtCurrWeight = new JTextField();
		txtCurrWeight.setColumns(10);
		txtCurrWeight.setBounds(736, 88, 116, 22);
		userplanPanel.add(txtCurrWeight);
		
		JButton btnPreviousActivity = new JButton("Previous Activity");
		btnPreviousActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPreviousActivity.setBounds(93, 712, 125, 25);
		frame.getContentPane().add(btnPreviousActivity);
		
		JButton btnWalkingStatus = new JButton("Walking Status");
		btnWalkingStatus.setBounds(266, 712, 141, 25);
		btnWalkingStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				daList=daI.getDailyActivitiesList(currUser[0]);
				  			
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
				
				daList=daI.getDailyActivitiesList(currUser[0]);				  			
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
		
		updateData();
		
		
		JButton btnDietStatus = new JButton("Diet Status ");
		btnDietStatus.setBounds(664, 712, 97, 25);
		btnDietStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			ArrayList<Double> calList=new ArrayList<Double>();
			   calList=paI.getCaloriesConsumed(currUser[0]);				
				DefaultCategoryDataset dcd=new DefaultCategoryDataset();
				for(int i=0;i<calList.size();++i)
				{
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
		btnGoalProgress.setBounds(962, 712, 111, 25);
		btnGoalProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
            // daList=daI.getDailyActivitiesList(currUser);
				ArrayList<BodyMeasurements> bmList=new ArrayList<BodyMeasurements>();
				bmList=(ArrayList<BodyMeasurements>) bmI.getBodyDataList();
             
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
		btnNextActivity.setBounds(1115, 712, 111, 25);
		frame.getContentPane().add(btnNextActivity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 317, 438, 345);
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
		paList=paI.getProgress(currUser[0]);
		for(ProgressActivity pa:paList)
		{
			dtm.addRow(pa.getVector());
		}
		table.setModel(dtm);
		
		}
	private void updateData()
	{
		BodyMeasurementsDAOImpl bmI=new BodyMeasurementsDAOImpl();
		ArrayList<BodyMeasurements> bList=bmI.getBodyDatabyEmail(currUser[0]);
		if(bList.size()>0)
		{
		txtPlanSelected.setText(bList.get(0).getFitnessPlanType());
		txtGoalWeight.setText(bList.get(0).getUserGoalType());
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
				 txtCaloriesDifference.setText(""+3000);
			 }else if(bList.get(0).getUserGoalType().contains("5 LB"))
			 {
				 txtCaloriesDifference.setText(""+5000);
			 }
			 else if(bList.get(0).getUserGoalType().contains("7 LB"))
			 {
				 txtCaloriesDifference.setText(""+7000);
			 }else {
				 txtCaloriesDifference.setText(""+10000);
			 }
		}
		}	
		
	}
	
	private void setCalDiff(ArrayList<BodyMeasurements> bList)
	{
		 if(bList.get(0).getUserGoalType().contains("0.5 LB"))
		 {
			 txtCaloriesDifference.setText(""+300);
		 }else if(bList.get(0).getUserGoalType().contains("1 LB"))
		 {
			 txtCaloriesDifference.setText(""+500);
		 }
		 else if(bList.get(0).getUserGoalType().contains("1.5 LB"))
		 {
			 txtCaloriesDifference.setText(""+750);
		 }else {
			 txtCaloriesDifference.setText(""+1000);
		 }		
	}
	
	public double calNeeded()
	{
		BodyMeasurementsDAOImpl bmI=new BodyMeasurementsDAOImpl();
		ArrayList<BodyMeasurements> bList=bmI.getBodyDatabyEmail(currUser[0]);
	double calDiff=Double.parseDouble(txtCaloriesDifference.getText());
	double calConsumed=Double.parseDouble(txtCalConsumed.getText());
	double calBurned=Double.parseDouble(txtCalBurned.getText());
	double calNeeded=0;
	if(bList.get(0).getFitnessPlanType().equalsIgnoreCase("Stay Fit Plan")){
		calNeeded=calConsumed-calBurned;
			}
	else if(bList.get(0).getFitnessPlanType().equalsIgnoreCase("Weight Gain Plan")){
		calNeeded=calConsumed-calBurned+calDiff;
	}else {
		calNeeded=calConsumed-calBurned-calDiff;
	} 		
		return calNeeded;
	}
}
