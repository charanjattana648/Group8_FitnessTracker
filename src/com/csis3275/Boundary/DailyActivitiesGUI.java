package com.csis3275.Boundary;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.transaction.Transactional.TxType;

import com.csis3275.Entities.DailyActivity;
import com.csis3275.Entities.ProgressActivity;

import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.persistence.Column;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class DailyActivitiesGUI {

	private JFrame frame;
	private JTextField sleepHrstext;
	private JTextField sleepMinttext;
	private JTextField waterGlasstext;
	private JTextField walkingHrstext;
	private JTextField walkingMinttext;
	private JTextField excersiseHrstext;
	private JTextField ExcersiseMinttext;
	private JTextField meditationHrstext;
	private JTextField meditationMinttext;
	private JTextField eatCaltext;
	private JTextField eatProteintext;
	private JTextField eatFatstext;
	private JTextField workHrstext;
	private JTextField workMinttext;
	private JProgressBar sleepHorsprogressBar;
	private JProgressBar waterprogressBar;
	private JProgressBar WalkingprogressBar;
	private JProgressBar ExcersiseprogressBar;
	private JProgressBar MeditationprogressBar;
	private DailyActivity da=new DailyActivity();
	private DailyActivityDAOImpl daI=new DailyActivityDAOImpl();
	private static String userEmail="";
	private int walkingRed=30,walkingGreen=120,walkingYellow=150;
	private int exerciseRed=30,exerciseGreen=240,exerciseYellow=300;
	private int meditationRed=5,meditationGreen=90,meditationYellow=120;
	private int sleepRed=330,sleepGreen=540,sleepYellow=600;
	private int waterRed=5,waterGreen=15,waterYellow=20;
	private final int MIN_PER_HOUR=60;
	static String[] currUser=new String[2];
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(args.length>0)
					{
						currUser=args;
					userEmail=args[0];
					}
					DailyActivitiesGUI window = new DailyActivitiesGUI();
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
	public DailyActivitiesGUI() {
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
		
		JLabel lblWhatYouDid = new JLabel("What you did today?");
		lblWhatYouDid.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblWhatYouDid.setBounds(575, 44, 306, 51);
		frame.getContentPane().add(lblWhatYouDid);
		
		JLabel lblSleeoHours = new JLabel("Sleep Hours");
		lblSleeoHours.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSleeoHours.setBounds(38, 123, 171, 38);
		frame.getContentPane().add(lblSleeoHours);
		
		sleepHrstext = new JTextField();
		sleepHrstext.setText("00");
		sleepHrstext.setBounds(310, 132, 82, 26);
		frame.getContentPane().add(sleepHrstext);
		sleepHrstext.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(407, 135, 69, 20);
		frame.getContentPane().add(lblHours);
		
		sleepMinttext = new JTextField();
		sleepMinttext.setText("00");
		sleepMinttext.setBounds(468, 132, 82, 26);
		frame.getContentPane().add(sleepMinttext);
		sleepMinttext.setColumns(10);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(571, 135, 69, 20);
		frame.getContentPane().add(lblMinutes);
		
		sleepHorsprogressBar = new JProgressBar();
		sleepHorsprogressBar.setMaximum(12);
		sleepHorsprogressBar.setBounds(719, 132, 427, 14);
		frame.getContentPane().add(sleepHorsprogressBar);
		
		JLabel lblDrinkWater = new JLabel("Drink Water");
		lblDrinkWater.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDrinkWater.setBounds(38, 200, 153, 20);
		frame.getContentPane().add(lblDrinkWater);
		
		waterGlasstext = new JTextField();
		waterGlasstext.setText("0");
		waterGlasstext.setColumns(10);
		waterGlasstext.setBounds(310, 200, 82, 26);
		frame.getContentPane().add(waterGlasstext);
		
		JLabel lblGlass = new JLabel("Glass");
		lblGlass.setBounds(407, 203, 69, 20);
		frame.getContentPane().add(lblGlass);
		
		waterprogressBar = new JProgressBar();
		waterprogressBar.setMaximum(20);
		waterprogressBar.setBounds(719, 200, 427, 14);
		frame.getContentPane().add(waterprogressBar);
		
		JLabel lblWalking = new JLabel("Walking");
		lblWalking.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWalking.setBounds(38, 261, 153, 29);
		frame.getContentPane().add(lblWalking);
		
		walkingHrstext = new JTextField();
		walkingHrstext.setText("00");
		walkingHrstext.setColumns(10);
		walkingHrstext.setBounds(310, 265, 82, 26);
		frame.getContentPane().add(walkingHrstext);
		
		JLabel label = new JLabel("Hours");
		label.setBounds(407, 268, 69, 20);
		frame.getContentPane().add(label);
		
		walkingMinttext = new JTextField();
		walkingMinttext.setText("00");
		walkingMinttext.setColumns(10);
		walkingMinttext.setBounds(468, 265, 82, 26);
		frame.getContentPane().add(walkingMinttext);
		
		JLabel label_1 = new JLabel("Minutes");
		label_1.setBounds(571, 268, 69, 20);
		frame.getContentPane().add(label_1);
		
		WalkingprogressBar = new JProgressBar();
		WalkingprogressBar.setMaximum(180);
		WalkingprogressBar.setBounds(719, 276, 427, 14);
		frame.getContentPane().add(WalkingprogressBar);
		
		JLabel lblExcersise = new JLabel("Excersise");
		lblExcersise.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblExcersise.setBounds(38, 331, 153, 26);
		frame.getContentPane().add(lblExcersise);
		
		excersiseHrstext = new JTextField();
		excersiseHrstext.setText("00");
		excersiseHrstext.setColumns(10);
		excersiseHrstext.setBounds(310, 334, 82, 26);
		frame.getContentPane().add(excersiseHrstext);
		
		JLabel label_2 = new JLabel("Hours");
		label_2.setBounds(407, 337, 69, 20);
		frame.getContentPane().add(label_2);
		
		ExcersiseMinttext = new JTextField();
		ExcersiseMinttext.setText("00");
		ExcersiseMinttext.setColumns(10);
		ExcersiseMinttext.setBounds(468, 334, 82, 26);
		frame.getContentPane().add(ExcersiseMinttext);
		
		JLabel label_3 = new JLabel("Minutes");
		label_3.setBounds(571, 337, 69, 20);
		frame.getContentPane().add(label_3);
		
		ExcersiseprogressBar = new JProgressBar();
		ExcersiseprogressBar.setMaximum(360);
		ExcersiseprogressBar.setBounds(719, 343, 427, 14);
		frame.getContentPane().add(ExcersiseprogressBar);
		
		JLabel lblMeditation = new JLabel("Meditation");
		lblMeditation.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMeditation.setBounds(38, 396, 153, 26);
		frame.getContentPane().add(lblMeditation);
		
		meditationHrstext = new JTextField();
		meditationHrstext.setText("00");
		meditationHrstext.setColumns(10);
		meditationHrstext.setBounds(310, 399, 82, 26);
		frame.getContentPane().add(meditationHrstext);
		
		JLabel label_4 = new JLabel("Hours");
		label_4.setBounds(407, 402, 69, 20);
		frame.getContentPane().add(label_4);
		
		meditationMinttext = new JTextField();
		meditationMinttext.setText("00");
		meditationMinttext.setColumns(10);
		meditationMinttext.setBounds(468, 399, 82, 26);
		frame.getContentPane().add(meditationMinttext);
		
		JLabel label_5 = new JLabel("Minutes");
		label_5.setBounds(571, 402, 69, 20);
		frame.getContentPane().add(label_5);
		
	    MeditationprogressBar = new JProgressBar();
		MeditationprogressBar.setMaximum(150);
		MeditationprogressBar.setBounds(719, 408, 427, 14);
		frame.getContentPane().add(MeditationprogressBar);
		
		JLabel lblEating = new JLabel("Eating");
		lblEating.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEating.setBounds(38, 457, 153, 26);
		frame.getContentPane().add(lblEating);
		
		JLabel lblDidYouConsume = new JLabel("Did you consume extra food excluding your diet plan?");
		lblDidYouConsume.setBounds(287, 463, 401, 20);
		frame.getContentPane().add(lblDidYouConsume);
		
		JRadioButton eatingRdbtnYes = new JRadioButton("Yes");
		eatingRdbtnYes.setBounds(287, 495, 69, 29);
		frame.getContentPane().add(eatingRdbtnYes);
		
		JRadioButton eatingRdbtnNo = new JRadioButton("No");
		eatingRdbtnNo.setBounds(470, 495, 155, 29);
		frame.getContentPane().add(eatingRdbtnNo);
		
		JPanel eatingPanel = new JPanel();
		eatingPanel.setBounds(702, 449, 608, 94);
		frame.getContentPane().add(eatingPanel);
		eatingPanel.setLayout(null);
		
		JLabel lblIfYesHow = new JLabel("If Yes, How much you consume?");
		lblIfYesHow.setBounds(15, 16, 312, 20);
		eatingPanel.add(lblIfYesHow);
		
		eatCaltext = new JTextField();
		eatCaltext.setText("0.0");
		eatCaltext.setBounds(15, 52, 76, 26);
		eatingPanel.add(eatCaltext);
		eatCaltext.setColumns(10);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setBounds(106, 55, 69, 20);
		eatingPanel.add(lblCalories);
		
		eatProteintext = new JTextField();
		eatProteintext.setText("0.0");
		eatProteintext.setColumns(10);
		eatProteintext.setBounds(183, 52, 76, 26);
		eatingPanel.add(eatProteintext);
		
		JLabel lblProtein = new JLabel("Proteins");
		lblProtein.setBounds(279, 55, 69, 20);
		eatingPanel.add(lblProtein);
		
		eatFatstext = new JTextField();
		eatFatstext.setText("0.0");
		eatFatstext.setColumns(10);
		eatFatstext.setBounds(366, 52, 76, 26);
		eatingPanel.add(eatFatstext);
		
		JLabel lblFats = new JLabel("Fats");
		lblFats.setBounds(473, 55, 69, 20);
		eatingPanel.add(lblFats);
		
		JLabel lblWork = new JLabel("Work");
		lblWork.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWork.setBounds(38, 561, 153, 26);
		frame.getContentPane().add(lblWork);
		
		JLabel lblWhichTypeOf = new JLabel("Which type of work you did today?");
		lblWhichTypeOf.setBounds(287, 567, 313, 29);
		frame.getContentPane().add(lblWhichTypeOf);
		
		JRadioButton rdbtnActiveWork = new JRadioButton("Active work");
		rdbtnActiveWork.setBounds(287, 618, 122, 29);
		frame.getContentPane().add(rdbtnActiveWork);
		
		JRadioButton rdbtnOfficeWork = new JRadioButton("Office work");
		rdbtnOfficeWork.setBounds(439, 618, 113, 29);
		frame.getContentPane().add(rdbtnOfficeWork);
		
		JRadioButton rdbtnHeavy = new JRadioButton("Heavy");
		rdbtnHeavy.setBounds(592, 618, 87, 29);
		frame.getContentPane().add(rdbtnHeavy);
		
		JLabel lblHowLongYou = new JLabel("How long you did it?");
		lblHowLongYou.setBounds(735, 571, 237, 20);
		frame.getContentPane().add(lblHowLongYou);
		
		workHrstext = new JTextField();
		workHrstext.setText("00");
		workHrstext.setColumns(10);
		workHrstext.setBounds(719, 618, 82, 26);
		frame.getContentPane().add(workHrstext);
		
		JLabel label_6 = new JLabel("Hours");
		label_6.setBounds(822, 622, 69, 20);
		frame.getContentPane().add(label_6);
		
		workMinttext = new JTextField();
		workMinttext.setText("00");
		workMinttext.setColumns(10);
		workMinttext.setBounds(890, 619, 82, 26);
		frame.getContentPane().add(workMinttext);
		
		JLabel label_7 = new JLabel("Minutes");
		label_7.setBounds(998, 622, 69, 20);
		frame.getContentPane().add(label_7);
		
		JButton btnPreviousPage = new JButton("Exercise Activity");
		btnPreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnPreviousPage.setBounds(294, 703, 153, 29);
		frame.getContentPane().add(btnPreviousPage);
		
		JButton btnAddRecord = new JButton("Add Record");
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 setProgress();
				String workTyp="";
				if(rdbtnActiveWork.isSelected()) {
					workTyp="Active Work";
				}else if(rdbtnOfficeWork.isSelected()) {
					workTyp="Office Work";
				}else {
					workTyp="Heavy Work";
				}
				DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
				Date currDate=new Date();
				da=new DailyActivity();
				
				da.setDate(df.format(currDate));
				da.setUserEmail(currUser[0]);
				da.setSleepHour(Integer.parseInt(sleepHrstext.getText()));
				da.setSleepMinute(Integer.parseInt(sleepMinttext.getText()));
				da.setWaterGlass(Integer.parseInt(waterGlasstext.getText()));
				da.setExerciseHour(Integer.parseInt(excersiseHrstext.getText()));
				da.setExerciseMinute(Integer.parseInt(ExcersiseMinttext.getText()));
				da.setMeditationHour(Integer.parseInt(meditationHrstext.getText()));
				da.setMeditationMinute(Integer.parseInt(meditationMinttext.getText()));
				da.setWalkingHour(Integer.parseInt(walkingHrstext.getText()));
				da.setWalkingMinute(Integer.parseInt(walkingMinttext.getText()));
				da.setExtraCalories(Double.parseDouble(eatCaltext.getText()));
				da.setExtraProtein(Double.parseDouble(eatProteintext.getText()));
				da.setExtraFat(Double.parseDouble(eatFatstext.getText()));
				da.setWorkType(workTyp);
				da.setWorkHour(Integer.parseInt(workHrstext.getText()));
				da.setWorkMinute(Integer.parseInt(workMinttext.getText()));
				//daI=new DailyActivityDAOImpl();
				daI.addDailyActivities(da);
				
			}
		});
		btnAddRecord.setBounds(468, 703, 115, 29);
		frame.getContentPane().add(btnAddRecord);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WalkingprogressBar.setValue(0);
				sleepHorsprogressBar.setValue(0);
				waterprogressBar.setValue(0);
				ExcersiseprogressBar.setValue(0);
				MeditationprogressBar.setValue(0);
				sleepHrstext.setText("00");
				sleepMinttext.setText("00");
				waterGlasstext.setText("0");
				walkingHrstext.setText("00");
				walkingMinttext.setText("00");
				excersiseHrstext.setText("00");
				ExcersiseMinttext.setText("00");
				meditationHrstext.setText("00");
				meditationMinttext.setText("00");
				eatCaltext.setText("0.0");
				eatProteintext.setText("0.0");
				eatFatstext.setText("0.0");
				workHrstext.setText("00");
				workMinttext.setText("00");
				
			}
		});
		btnRefresh.setBounds(614, 703, 115, 29);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnNextPage = new JButton("Progress Activity");
		btnNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgressActivityGUI.main(currUser);
			}
		});
		btnNextPage.setBounds(766, 703, 115, 29);
		frame.getContentPane().add(btnNextPage);
		
		textField = new JTextField();
		textField.setBackground(Color.RED);
		textField.setBounds(1215, 123, 36, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblLow = new JLabel("Low");
		lblLow.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLow.setBounds(1266, 123, 69, 20);
		frame.getContentPane().add(lblLow);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.GREEN);
		textField_1.setBounds(1215, 165, 36, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGood = new JLabel("Normal");
		lblGood.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGood.setBounds(1266, 167, 69, 20);
		frame.getContentPane().add(lblGood);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.YELLOW);
		textField_2.setBounds(1215, 211, 36, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblExcess = new JLabel("Excess");
		lblExcess.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExcess.setBounds(1266, 213, 69, 20);
		frame.getContentPane().add(lblExcess);
	}
	
	private void setProgress()
	{
		
		int walkingMin=(Integer.parseInt(walkingHrstext.getText())*MIN_PER_HOUR)+Integer.parseInt(walkingMinttext.getText());
		int sleepMin=(Integer.parseInt(sleepHrstext.getText())*MIN_PER_HOUR)+Integer.parseInt(sleepMinttext.getText());
		int exerciseMin=(Integer.parseInt(excersiseHrstext.getText())*MIN_PER_HOUR)+Integer.parseInt(ExcersiseMinttext.getText());
		int meditationMin=(Integer.parseInt(meditationHrstext.getText())*MIN_PER_HOUR)+Integer.parseInt(meditationMinttext.getText());
		int waterGlass=Integer.parseInt(waterGlasstext.getText());
		int workMin=(Integer.parseInt(workHrstext.getText())*MIN_PER_HOUR)+Integer.parseInt(workMinttext.getText());
		WalkingprogressBar.setValue(walkingMin);
		sleepHorsprogressBar.setValue(sleepMin);
		waterprogressBar.setValue(waterGlass);
		ExcersiseprogressBar.setValue(exerciseMin);
		MeditationprogressBar.setValue(meditationMin);
	
		if(meditationMin<=meditationRed)
		{
			MeditationprogressBar.setForeground(Color.RED);
		}else if(meditationMin>meditationRed && meditationMin<=meditationGreen)
		{
			MeditationprogressBar.setForeground(Color.GREEN);
		}else {
			MeditationprogressBar.setForeground(Color.YELLOW);
		}
		
		if(exerciseMin<=exerciseRed)
		{
			ExcersiseprogressBar.setForeground(Color.RED);
		}else if(exerciseMin>exerciseRed && exerciseMin<=exerciseGreen)
		{
			ExcersiseprogressBar.setForeground(Color.GREEN);
		}else {
			ExcersiseprogressBar.setForeground(Color.YELLOW);
		}
		
		if(waterGlass<=waterRed)
		{
			waterprogressBar.setForeground(Color.RED);
		}else if(waterGlass>waterRed && waterGlass<=waterGreen)
		{
			waterprogressBar.setForeground(Color.GREEN);
		}else {
			waterprogressBar.setForeground(Color.YELLOW);
		}
		
		if(walkingMin<=walkingRed)
		{
			WalkingprogressBar.setForeground(Color.RED);
		}else if(walkingMin>walkingRed && walkingMin<=walkingGreen)
		{
			WalkingprogressBar.setForeground(Color.GREEN);
		}else {
			WalkingprogressBar.setForeground(Color.YELLOW);
		}
		
		if(sleepMin<=sleepRed)
		{
			sleepHorsprogressBar.setForeground(Color.RED);
		}else if(sleepMin>sleepRed && sleepMin<=sleepGreen)
		{
			sleepHorsprogressBar.setForeground(Color.GREEN);
		}else {
			sleepHorsprogressBar.setForeground(Color.YELLOW);
		}
	}
}
