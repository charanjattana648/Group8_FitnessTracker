package com.csis3275.Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JButton;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		sleepHrstext.setBounds(310, 132, 82, 26);
		frame.getContentPane().add(sleepHrstext);
		sleepHrstext.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(407, 135, 69, 20);
		frame.getContentPane().add(lblHours);
		
		sleepMinttext = new JTextField();
		sleepMinttext.setBounds(468, 132, 82, 26);
		frame.getContentPane().add(sleepMinttext);
		sleepMinttext.setColumns(10);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(571, 135, 69, 20);
		frame.getContentPane().add(lblMinutes);
		
		JProgressBar sleepHorsprogressBar = new JProgressBar();
		sleepHorsprogressBar.setBounds(719, 132, 427, 14);
		frame.getContentPane().add(sleepHorsprogressBar);
		
		JLabel lblDrinkWater = new JLabel("Drink Water");
		lblDrinkWater.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDrinkWater.setBounds(38, 200, 153, 20);
		frame.getContentPane().add(lblDrinkWater);
		
		waterGlasstext = new JTextField();
		waterGlasstext.setColumns(10);
		waterGlasstext.setBounds(310, 200, 82, 26);
		frame.getContentPane().add(waterGlasstext);
		
		JLabel lblGlass = new JLabel("Glass");
		lblGlass.setBounds(407, 203, 69, 20);
		frame.getContentPane().add(lblGlass);
		
		JProgressBar waterprogressBar = new JProgressBar();
		waterprogressBar.setBounds(719, 200, 427, 14);
		frame.getContentPane().add(waterprogressBar);
		
		JLabel lblWalking = new JLabel("Walking");
		lblWalking.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWalking.setBounds(38, 261, 153, 29);
		frame.getContentPane().add(lblWalking);
		
		walkingHrstext = new JTextField();
		walkingHrstext.setColumns(10);
		walkingHrstext.setBounds(310, 265, 82, 26);
		frame.getContentPane().add(walkingHrstext);
		
		JLabel label = new JLabel("Hours");
		label.setBounds(407, 268, 69, 20);
		frame.getContentPane().add(label);
		
		walkingMinttext = new JTextField();
		walkingMinttext.setColumns(10);
		walkingMinttext.setBounds(468, 265, 82, 26);
		frame.getContentPane().add(walkingMinttext);
		
		JLabel label_1 = new JLabel("Minutes");
		label_1.setBounds(571, 268, 69, 20);
		frame.getContentPane().add(label_1);
		
		JProgressBar WalkingprogressBar = new JProgressBar();
		WalkingprogressBar.setBounds(719, 276, 427, 14);
		frame.getContentPane().add(WalkingprogressBar);
		
		JLabel lblExcersise = new JLabel("Excersise");
		lblExcersise.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblExcersise.setBounds(38, 331, 153, 26);
		frame.getContentPane().add(lblExcersise);
		
		excersiseHrstext = new JTextField();
		excersiseHrstext.setColumns(10);
		excersiseHrstext.setBounds(310, 334, 82, 26);
		frame.getContentPane().add(excersiseHrstext);
		
		JLabel label_2 = new JLabel("Hours");
		label_2.setBounds(407, 337, 69, 20);
		frame.getContentPane().add(label_2);
		
		ExcersiseMinttext = new JTextField();
		ExcersiseMinttext.setColumns(10);
		ExcersiseMinttext.setBounds(468, 334, 82, 26);
		frame.getContentPane().add(ExcersiseMinttext);
		
		JLabel label_3 = new JLabel("Minutes");
		label_3.setBounds(571, 337, 69, 20);
		frame.getContentPane().add(label_3);
		
		JProgressBar ExcersiseprogressBar = new JProgressBar();
		ExcersiseprogressBar.setBounds(719, 343, 427, 14);
		frame.getContentPane().add(ExcersiseprogressBar);
		
		JLabel lblMeditation = new JLabel("Meditation");
		lblMeditation.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMeditation.setBounds(38, 396, 153, 26);
		frame.getContentPane().add(lblMeditation);
		
		meditationHrstext = new JTextField();
		meditationHrstext.setColumns(10);
		meditationHrstext.setBounds(310, 399, 82, 26);
		frame.getContentPane().add(meditationHrstext);
		
		JLabel label_4 = new JLabel("Hours");
		label_4.setBounds(407, 402, 69, 20);
		frame.getContentPane().add(label_4);
		
		meditationMinttext = new JTextField();
		meditationMinttext.setColumns(10);
		meditationMinttext.setBounds(468, 399, 82, 26);
		frame.getContentPane().add(meditationMinttext);
		
		JLabel label_5 = new JLabel("Minutes");
		label_5.setBounds(571, 402, 69, 20);
		frame.getContentPane().add(label_5);
		
		JProgressBar MeditationprogressBar = new JProgressBar();
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
		eatCaltext.setBounds(15, 52, 76, 26);
		eatingPanel.add(eatCaltext);
		eatCaltext.setColumns(10);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setBounds(106, 55, 69, 20);
		eatingPanel.add(lblCalories);
		
		eatProteintext = new JTextField();
		eatProteintext.setColumns(10);
		eatProteintext.setBounds(183, 52, 76, 26);
		eatingPanel.add(eatProteintext);
		
		JLabel lblProtein = new JLabel("Proteins");
		lblProtein.setBounds(279, 55, 69, 20);
		eatingPanel.add(lblProtein);
		
		eatFatstext = new JTextField();
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
		workHrstext.setColumns(10);
		workHrstext.setBounds(719, 618, 82, 26);
		frame.getContentPane().add(workHrstext);
		
		JLabel label_6 = new JLabel("Hours");
		label_6.setBounds(822, 622, 69, 20);
		frame.getContentPane().add(label_6);
		
		workMinttext = new JTextField();
		workMinttext.setColumns(10);
		workMinttext.setBounds(890, 619, 82, 26);
		frame.getContentPane().add(workMinttext);
		
		JLabel label_7 = new JLabel("Minutes");
		label_7.setBounds(998, 622, 69, 20);
		frame.getContentPane().add(label_7);
		
		JButton btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.setBounds(294, 703, 153, 29);
		frame.getContentPane().add(btnPreviousPage);
		
		JButton btnAddRecord = new JButton("Add Record");
		btnAddRecord.setBounds(468, 703, 115, 29);
		frame.getContentPane().add(btnAddRecord);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(614, 703, 115, 29);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.setBounds(766, 703, 115, 29);
		frame.getContentPane().add(btnNextPage);
	}
}
