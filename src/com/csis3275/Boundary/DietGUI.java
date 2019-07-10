package com.csis3275.Boundary;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Utilities;

import com.csis3275.Entities.Diet;
import com.csis3275.Entities.UserDiet;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DietGUI {

	private JFrame frame;
	private JTable table;
	private Diet d = new Diet();
	private DefaultTableModel dtm = new DefaultTableModel();
	private ListSelectionListener lsl = null;
	private ListSelectionListener lsl_userT = null;
	private DietDAOImpl dI = new DietDAOImpl();
	//private UserDietDAOImpl udI=new UserDietDAOImpl();
	private JTextField txtId;
	private JTextField txtMealId;
	private JTextField txtMealType;
	private JTextField txtFoodType;
	private JTextField txtReadyTime;
	private JTextField txtCalories;
	private JTextField txtFat;
	private JTextField txtProtein;
	private JTextField txtCarbohydrates;
	private JTextField txtFoodName;
	private JTextField txtFoodCategory;
	private JTextField txtVitaminA;
	private JTextField txtVitaminC;
	private JTextField txtCalcium;
	private JTextField txtIron;
	private JTextField txtAuthor;
	private JTable UserSelDietTable;
	private JComboBox comboBoxDate;
	private JPanel UserPanel;
	private JPanel DietPanel;	
	private boolean isOrder=false;
	private String orderType="";
	private boolean isFiltered=false;
	private String filteredClause="";
	private static String[] currentUEmail=new String[2];
	private UserDietDAOImpl udI=new UserDietDAOImpl();
	private String mealtypeSel="",authorSel="",foodCategorySel="",foodtypeSel="",orderby="";
	private static String usertype="";
	private JTextField txtCaloriesN;
	private JTable tableCreatedDiet;
	/**
	 * Launch the application.
	 * @param args return email at 0 index.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(args.length>0)
					{
					currentUEmail[0]=args[0];
					currentUEmail[1]=args[1];
					usertype=args[1];
					}
					
					System.out.println("DG Email : "+currentUEmail[0]);
					System.out.println("DG Type : "+currentUEmail[1]);
					DietGUI window = new DietGUI();
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
	public DietGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1372, 830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lsl = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int currId = (int) table.getValueAt(table.getSelectedRow(), 0);
				Diet d = dI.getDiet(currId);
				txtId.setText("" + d.getId());
				txtMealId.setText("" + d.getMealId());
				txtMealType.setText("" + d.getMealType());
				txtFoodType.setText("" + d.getFoodType());
				txtFoodName.setText("" + d.getFoodName());
				txtFoodCategory.setText("" + d.getFoodCategory());
				txtCalories.setText("" + d.getCalories());
				txtFat.setText("" + d.getProtein());
				txtProtein.setText("" + d.getFat());
				txtCarbohydrates.setText("" + d.getCarbohydrates());				
				txtReadyTime.setText(""+d.getReadyTime());
				txtVitaminA.setText(""+d.getVitaminA());
				txtVitaminC.setText(""+d.getVitaminC());
				txtCalcium.setText(""+d.getCalcium());
				txtIron.setText(""+d.getIron());
				txtAuthor.setText(""+d.getAuthor());


			}
		};
		
		
		
		DietPanel = new JPanel();
		DietPanel.setBounds(12, 337, 515, 366);
		DietPanel.setVisible(false);
		
		UserPanel = new JPanel();
		UserPanel.setBounds(12, 322, 469, 372);
		UserPanel.setVisible(false);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPaneUserT = new JScrollPane();
		scrollPaneUserT.setBounds(578, 369, 626, 348);
		frame.getContentPane().add(scrollPaneUserT);
		
		UserSelDietTable = new JTable();
		scrollPaneUserT.setViewportView(UserSelDietTable);
		
		JScrollPane scrollPaneUserDietCT = new JScrollPane();
		scrollPaneUserDietCT.setVisible(false);
		scrollPaneUserDietCT.setBounds(574, 369, 630, 348);
		frame.getContentPane().add(scrollPaneUserDietCT);
		
		tableCreatedDiet = new JTable();
		scrollPaneUserDietCT.setViewportView(tableCreatedDiet);
		frame.getContentPane().add(UserPanel);
		UserPanel.setLayout(null);
		
		
		
		JLabel lblFilter = new JLabel("Filter :");
		lblFilter.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFilter.setBounds(12, 37, 64, 27);
		UserPanel.add(lblFilter);
		
		ArrayList<String> mealTypeListCB=dI.getMealTypeList();		
		ArrayList<String> foodTypeListCB=dI.getFoodTypeList();		
		ArrayList<String> foodCategoryListCB=dI.getFoodCategoryList();		
		ArrayList<String> authorListCB=dI.getAuthorList();
			
		JComboBox comboBoxMealType = new JComboBox(mealTypeListCB.toArray());
		comboBoxMealType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxMealType.getSelectedIndex()!=0)
				{
				dI.getFilteredMealTypeList(comboBoxMealType.getSelectedItem().toString());
				}
				//updateTable();
			}
		});
		comboBoxMealType.setBounds(80, 40, 114, 22);
		UserPanel.add(comboBoxMealType);
	  

		JComboBox comboBoxFoodType = new JComboBox(foodTypeListCB.toArray());
		comboBoxFoodType.setBounds(216, 40, 114, 22);
		UserPanel.add(comboBoxFoodType);
		JComboBox comboBoxFoodCategory = new JComboBox(foodCategoryListCB.toArray());
		comboBoxFoodCategory.setBounds(216, 75, 114, 22);
		UserPanel.add(comboBoxFoodCategory);
		JComboBox comboBoxAuthor = new JComboBox(authorListCB.toArray());
		comboBoxAuthor.setBounds(80, 77, 114, 22);
		UserPanel.add(comboBoxAuthor);
		
		JLabel lblSort = new JLabel("Sort : ");
		lblSort.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSort.setBounds(12, 138, 64, 27);
		UserPanel.add(lblSort);
		
		JComboBox comboBoxAscDesc = new JComboBox();
		comboBoxAscDesc.setModel(new DefaultComboBoxModel(new String[] {"None", "Highest", "Lowest"}));
		comboBoxAscDesc.setBounds(80, 141, 114, 22);
		UserPanel.add(comboBoxAscDesc);
		
		JComboBox comboBoxNutrients = new JComboBox();
		comboBoxNutrients.setModel(new DefaultComboBoxModel(new String[] {"None", "Calories", "Fat", "Protein", "Carbohydrates", "VitaminA", "VitaminC", "Iron", "Calcium"}));
		comboBoxNutrients.setBounds(216, 141, 114, 22);
		UserPanel.add(comboBoxNutrients);
		
		JButton btnAddUserMeal = new JButton("Add to Meal List");
		btnAddUserMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
				Date currDate=new Date();
				int currId=(int) table.getValueAt(table.getSelectedRow(), 0);
				Diet d=dI.getDiet(currId);
				
				UserDiet ud=new UserDiet();
				ud.setAuthor(d.getAuthor());
				ud.setCalories(d.getCalories());
				ud.setDate(df.format(currDate));
				ud.setDietId(d.getId());
				ud.setFoodName(d.getFoodName());
				ud.setMealType(d.getMealType());
				ud.setReadyTime(d.getReadyTime());
				ud.setUserEmail(currentUEmail[0]);
				udI.addUserDiet(ud);
				updateDateCb();
				updateUserSelTable();
				
			}
		});
		btnAddUserMeal.setBounds(41, 256, 153, 40);
		UserPanel.add(btnAddUserMeal);
		
		JButton btnDeleteFromMeal = new JButton("Delete from Meal List");
		btnDeleteFromMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int currId=(int) UserSelDietTable.getValueAt(UserSelDietTable.getSelectedRow(), 0);
				UserDiet ud=udI.getUserDiet(currId);
				udI.deleteUserDiet(ud);
				updateDateCb();
				updateUserSelTable();
			}
		});
		btnDeleteFromMeal.setBounds(216, 256, 153, 40);
		UserPanel.add(btnDeleteFromMeal);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isFiltered=false;
				isOrder=false;
				int count=0;
				
				if(comboBoxAscDesc.getSelectedIndex()==1)
				{	
					isOrder=true;
					if(comboBoxNutrients.getSelectedItem()!="None")	
					{
					orderby=comboBoxNutrients.getSelectedItem().toString();//+" DESC";
					}
				}else if(comboBoxAscDesc.getSelectedIndex()==2)
				{
					isOrder=true;									
					if(comboBoxNutrients.getSelectedItem()!="None")	
					{
					orderby=(String) comboBoxNutrients.getSelectedItem().toString();//+" ASC";
					}
				}
				if(comboBoxAuthor.getSelectedItem()!="None")
				{
					authorSel=comboBoxAuthor.getSelectedItem().toString();
					isFiltered=true;
				}
				if(comboBoxFoodCategory.getSelectedItem()!="None")
				{
					isFiltered=true;
					foodCategorySel=comboBoxFoodCategory.getSelectedItem().toString();
					
				}
				if(comboBoxFoodType.getSelectedItem()!="None")
				{
					isFiltered=true;
					foodtypeSel=comboBoxFoodType.getSelectedItem().toString();
					System.out.println("c----"+mealtypeSel);
					
				}
				if(comboBoxMealType.getSelectedItem()!="None")
				{
					isFiltered=true;
					mealtypeSel=comboBoxMealType.getSelectedItem().toString();
				}
				
				updateTable();
			}
		});
		btnSearch.setBounds(41, 319, 153, 40);
		UserPanel.add(btnSearch);
		
		JButton btnRefresh_1 = new JButton("Refresh");
		btnRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateDateCb();
				updateUserSelTable();
//				SwingUtilities.updateComponentTreeUI(comboBoxDate);
//				comboBoxDate.invalidate();
//				comboBoxDate.validate();
//				comboBoxDate.repaint();
				
			}
		});
		btnRefresh_1.setBounds(216, 319, 153, 40);
		UserPanel.add(btnRefresh_1);
		
		JLabel lblCaloriesNeeded = new JLabel("Calories Needed : ");
		lblCaloriesNeeded.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCaloriesNeeded.setBounds(41, 178, 153, 16);
		UserPanel.add(lblCaloriesNeeded);
		
		txtCaloriesN = new JTextField();
		txtCaloriesN.setBounds(41, 207, 153, 30);
		UserPanel.add(txtCaloriesN);
		txtCaloriesN.setColumns(10);
		
		JButton btnCreateMeal = new JButton("Create Meal");
		btnCreateMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtCalories.getText().isEmpty() || Double.isNaN(Double.parseDouble(txtCalories.getText())))
				{
					JOptionPane.showMessageDialog(null, "Enter Calories needed to consume.");
				}else {
					
				}
			}
		});
		btnCreateMeal.setBounds(216, 201, 153, 40);
		UserPanel.add(btnCreateMeal);
		frame.getContentPane().add(DietPanel);
		DietPanel.setLayout(null);
		
			
			JLabel lblId = new JLabel("Id :");
			lblId.setBounds(12, 16, 25, 16);
			DietPanel.add(lblId);
			
			JLabel lblMealId = new JLabel("Meal Id :");
			lblMealId.setBounds(119, 16, 56, 16);
			DietPanel.add(lblMealId);
			
			JLabel lblMealType = new JLabel("Meal Type :");
			lblMealType.setBounds(249, 16, 77, 16);
			DietPanel.add(lblMealType);
			
			JLabel lblFoodType = new JLabel("Food Type :");
			lblFoodType.setBounds(267, 58, 77, 16);
			DietPanel.add(lblFoodType);
			
			JLabel lblReadyTime = new JLabel("Ready Time :");
			lblReadyTime.setBounds(277, 96, 77, 16);
			DietPanel.add(lblReadyTime);
			
			JLabel lblCalories = new JLabel("Calories :");
			lblCalories.setBounds(12, 139, 56, 16);
			DietPanel.add(lblCalories);
			
			JLabel lblProtein = new JLabel("Protein :");
			lblProtein.setBounds(234, 139, 56, 16);
			DietPanel.add(lblProtein);
			
			JLabel lblFat = new JLabel("Fat :");
			lblFat.setBounds(136, 139, 30, 16);
			DietPanel.add(lblFat);
			
			JLabel lblCarbohydrates = new JLabel("Carbohydrates :");
			lblCarbohydrates.setBounds(348, 139, 99, 16);
			DietPanel.add(lblCarbohydrates);
			
			txtId = new JTextField();
			txtId.setEditable(false);
			txtId.setColumns(10);
			txtId.setBounds(45, 13, 44, 22);
			DietPanel.add(txtId);
			
			txtMealId = new JTextField();
			txtMealId.setColumns(10);
			txtMealId.setBounds(187, 13, 44, 22);
			DietPanel.add(txtMealId);
			
			txtMealType = new JTextField();
			txtMealType.setColumns(10);
			txtMealType.setBounds(338, 13, 154, 22);
			DietPanel.add(txtMealType);
			
			txtFoodType = new JTextField();
			txtFoodType.setColumns(10);
			txtFoodType.setBounds(348, 55, 144, 22);
			DietPanel.add(txtFoodType);
			
			txtReadyTime = new JTextField();
			txtReadyTime.setColumns(10);
			txtReadyTime.setBounds(366, 93, 44, 22);
			DietPanel.add(txtReadyTime);
			
			txtCalories = new JTextField();
			txtCalories.setColumns(10);
			txtCalories.setBounds(80, 136, 44, 22);
			DietPanel.add(txtCalories);
			
			txtFat = new JTextField();
			txtFat.setColumns(10);
			txtFat.setBounds(178, 136, 44, 22);
			DietPanel.add(txtFat);
			
			txtProtein = new JTextField();
			txtProtein.setColumns(10);
			txtProtein.setBounds(287, 136, 44, 22);
			DietPanel.add(txtProtein);
			
			txtCarbohydrates = new JTextField();
			txtCarbohydrates.setColumns(10);
			txtCarbohydrates.setBounds(459, 136, 44, 22);
			DietPanel.add(txtCarbohydrates);
			
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Diet d=getData();
					dI.addMeal(d);
					updateTable();

					
				}
			});
			btnAdd.setBounds(27, 324, 97, 25);
			DietPanel.add(btnAdd);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int curId=(int) table.getValueAt(table.getSelectedRow(), 0);
					Diet d=getData();
					d.setId(curId);
					dI.updateDiet(d);
					updateTable();

					
				}
			});
			btnUpdate.setBounds(273, 324, 97, 25);
			DietPanel.add(btnUpdate);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int curId=(int) table.getValueAt(table.getSelectedRow(), 0);
					Diet d=dI.getDiet(curId);
					dI.deleteDiet(d);
					updateTable();
				}
			});
			btnDelete.setBounds(152, 324, 97, 25);
			DietPanel.add(btnDelete);
			
			JButton btnRefresh = new JButton("Refresh");
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {						
					
					txtId.setText("");
					txtMealId.setText("");
					txtMealType.setText("");
					txtFoodType.setText("");
					txtReadyTime.setText("");
					txtCalories.setText("");
					txtFat.setText("");
					txtProtein.setText("");
					txtCarbohydrates.setText("");
					txtFoodName.setText("");
					txtFoodCategory.setText("");
					txtVitaminA.setText("");
					txtVitaminC.setText("");
					txtCalcium.setText("");
					txtIron.setText("");
                txtAuthor.setText("");				
					updateTable();
				
				}
			});
			btnRefresh.setBounds(382, 324, 97, 25);
			DietPanel.add(btnRefresh);
			
			JLabel lblFoodName = new JLabel("Food name :");
			lblFoodName.setBounds(12, 58, 77, 16);
			DietPanel.add(lblFoodName);
			
			txtFoodName = new JTextField();
			txtFoodName.setColumns(10);
			txtFoodName.setBounds(101, 55, 154, 22);
			DietPanel.add(txtFoodName);
			
			JLabel lblFoodCategory = new JLabel("Food Category :");
			lblFoodCategory.setBounds(12, 96, 99, 16);
			DietPanel.add(lblFoodCategory);
			
			txtFoodCategory = new JTextField();
			txtFoodCategory.setColumns(10);
			txtFoodCategory.setBounds(123, 93, 144, 22);
			DietPanel.add(txtFoodCategory);
			
			JLabel lblVitamina = new JLabel("VitaminA :");
			lblVitamina.setBounds(12, 179, 77, 16);
			DietPanel.add(lblVitamina);
			
			txtVitaminA = new JTextField();
			txtVitaminA.setColumns(10);
			txtVitaminA.setBounds(103, 176, 44, 22);
			DietPanel.add(txtVitaminA);
			
			JLabel lblVitaminc = new JLabel("VitaminC :");
			lblVitaminc.setBounds(175, 179, 74, 16);
			DietPanel.add(lblVitaminc);
			
			txtVitaminC = new JTextField();
			txtVitaminC.setColumns(10);
			txtVitaminC.setBounds(264, 176, 44, 22);
			DietPanel.add(txtVitaminC);
			
			JLabel lblCalcium = new JLabel("Calcium :");
			lblCalcium.setBounds(343, 179, 56, 16);
			DietPanel.add(lblCalcium);
			
			txtCalcium = new JTextField();
			txtCalcium.setColumns(10);
			txtCalcium.setBounds(435, 176, 44, 22);
			DietPanel.add(txtCalcium);
			
			JLabel lblIron = new JLabel("Iron :");
			lblIron.setBounds(12, 218, 56, 16);
			DietPanel.add(lblIron);
			
			txtIron = new JTextField();
			txtIron.setColumns(10);
			txtIron.setBounds(80, 215, 44, 22);
			DietPanel.add(txtIron);
			
			JLabel lblAuthor = new JLabel("Author :");
			lblAuthor.setBounds(136, 218, 56, 16);
			DietPanel.add(lblAuthor);
			
			txtAuthor = new JTextField();
			txtAuthor.setText("Admin");
			txtAuthor.setColumns(10);
			txtAuthor.setBounds(204, 215, 144, 22);
			DietPanel.add(txtAuthor);
		
		System.out.println("first");
		
		if(usertype.equalsIgnoreCase("User"))
		{
			UserPanel.setVisible(true);
		}else {
			DietPanel.setVisible(true);
		}
		
	
		JScrollPane scrollPaneData = new JScrollPane();
		scrollPaneData.setBounds(12, 68, 1293, 227);
		frame.getContentPane().add(scrollPaneData);

		table = new JTable();
		scrollPaneData.setViewportView(table);
	
		comboBoxDate = new JComboBox();
		comboBoxDate.setBounds(828, 322, 114, 22);
		frame.getContentPane().add(comboBoxDate);
		updateDateCb();
		comboBoxDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("entering---"+comboBoxDate.getSelectedItem());
				//updateDateCb();
				updateUserSelTable();
				
			}
		});
		
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(750, 322, 64, 27);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(lblDate);
		
		JLabel lblDietPlan = new JLabel("Diet Plan");
		lblDietPlan.setBounds(646, 25, 116, 24);
		lblDietPlan.setFont(new Font("Tahoma", Font.BOLD, 24));
		frame.getContentPane().add(lblDietPlan);
		
		JButton btnExercise = new JButton("Exercise Activity");
		btnExercise.setBounds(49, 707, 153, 40);
		btnExercise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnExercise);
		
		JButton btnCheckProgress = new JButton("Daily Activities");
		btnCheckProgress.setBounds(227, 707, 153, 40);
		frame.getContentPane().add(btnCheckProgress);
		btnCheckProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DailyActivitiesGUI.main(currentUEmail);
			}
		});
		updateTable();
		updateUserSelTable();
	}

	/**
	 * updateTable() to update the Diet table after each operation.
	 */
	public void updateTable() {
		table.getSelectionModel().removeListSelectionListener(lsl);
		dtm = new DefaultTableModel();
		d = new Diet();
		dtm.addColumn("Id");
		dtm.addColumn("Meal Id");
		dtm.addColumn("Meal Type");
		dtm.addColumn("Food Name");
		dtm.addColumn("Food Type");
		dtm.addColumn("Food Category");
		dtm.addColumn("Ready Time");
		dtm.addColumn("Calories (g)");
		dtm.addColumn("Fat (g)");
		dtm.addColumn("Protein (g)");		
		dtm.addColumn("Carbohydrates");
		dtm.addColumn("VitaminA");
		dtm.addColumn("VitaminC");
		dtm.addColumn("Calcium");
		dtm.addColumn("Iron");
		dtm.addColumn("Author");
		ArrayList<Diet> dietList = dI.getDietList();
		if(isOrder && orderby!="")
		{			
			System.out.println("entering ----------------"+orderby);
			dietList=dI.getDietOrderedList(orderby);
			for (Diet d : dietList) {	
				System.out.println(d.getId()+" ------ "+d.getCalories());
			}
		}
		if(isFiltered)
		{
			if(mealtypeSel!="")
			dietList=dI.getFilteredMealTypeList(mealtypeSel);
			if(foodtypeSel!="")
				dietList=dI.getFilteredFoodTypeList(foodtypeSel);
			if(authorSel!="")
				dietList=dI.getFilteredauthorList(authorSel);
			if(foodCategorySel!="")
				dietList=dI.getFilterFoodCategoryList(foodCategorySel);
			
		}
//		{
//			if(isOrder && orderType!="")
//			{			
//				dietList=dI.getFilteredList(filteredClause+" Order by "+orderType);
//			}
//			else {
//				dietList=dI.getFilteredList(filteredClause);
//			}
//		}
		
		
		
		for (Diet d : dietList) {	
			dtm.addRow(d.getVector());
		}
		table.setModel(dtm);

		table.getSelectionModel().addListSelectionListener(lsl);

	}
	
	public void updateDateCb()
	{
		if(currentUEmail.length>0 )
		{
			ArrayList<String> dateListCB=udI.getLastDPDates(currentUEmail[0]);
			comboBoxDate.removeAllItems();
			for(String item:dateListCB)
			{
			comboBoxDate.addItem(item);
			}			
			updateUserSelTable();
		}        
		
	}
	/**
	 * updateUserSelTable() to update the selected UserDiet table after each operation.
	 *
	 */
	public void updateUserSelTable() {
	
		UserSelDietTable.getSelectionModel().removeListSelectionListener(lsl_userT);
		dtm = new DefaultTableModel();
		udI=new UserDietDAOImpl();
		//ud = new UserDiet();
		dtm.addColumn("Id");		
		dtm.addColumn("Diet Id");
		dtm.addColumn("Meal Type");
		dtm.addColumn("Food Name");
		dtm.addColumn("Calories (g)");
		dtm.addColumn("Date");
		dtm.addColumn("Author");
		ArrayList<UserDiet> dietList=new ArrayList<UserDiet>();
		if(currentUEmail.length>0)
		{
		//	ArrayList<String> dateListCB=udI.getLastDPDates(currentUEmail[0]);			
		//String currDate=udI.getLastDPDates(currentUEmail[0]).get(0);
			
			String currDate=(String) comboBoxDate.getSelectedItem();			
			System.out.println(currDate+" item count "+comboBoxDate.getItemCount());
		dietList =udI.getUserDietList(currentUEmail[0],currDate);
		}
		for (UserDiet ud : dietList) {	
			//System.out.println("entering ----  : " + ud.getFoodName());
			dtm.addRow(ud.getVector());
		}
		System.out.println("data --------------------------------------------------------------------------------");
		UserSelDietTable.setModel(dtm);

		UserSelDietTable.getSelectionModel().addListSelectionListener(lsl_userT);


	}
	
	/**
	 * Used by Different operations Insertion,etc.
	 * @return Diet Object
	 */
	
	public Diet getData()
	{
		int mealId=Integer.parseInt(txtMealId.getText());
		String foodName=txtFoodName.getText();
		String foodType=txtFoodType.getText();
		int readyTime=Integer.parseInt(txtReadyTime.getText());
		double calories=Double.parseDouble(txtCalories.getText());
		double protein=Double.parseDouble(txtProtein.getText());
		double fat=Double.parseDouble(txtFat.getText());
		double carbohydrates=Double.parseDouble(txtCarbohydrates.getText());
		String foodCategory=txtFoodCategory.getText();
		String mealType=txtMealType.getText();
		double vitaminA=Double.parseDouble(txtVitaminA.getText());
		double vitaminC=Double.parseDouble(txtVitaminC.getText());
		double calcium=Double.parseDouble(txtCalcium.getText());
		double iron=Double.parseDouble(txtIron.getText());
		String author=txtAuthor.getText();
		Diet d=new Diet();
		d.setCalories(calories);
		d.setCarbohydrates(carbohydrates);
		d.setFat(fat);
		d.setFoodName(foodName);
		d.setFoodType(foodType);
		d.setMealId(mealId);
		d.setProtein(protein);
		d.setReadyTime(readyTime);
		d.setFoodCategory(foodCategory);
		d.setMealType(mealType);
		d.setVitaminA(vitaminA);
		d.setVitaminC(vitaminC);
		d.setCalcium(calcium);
		d.setIron(iron);
		d.setAuthor(author);
		return d;
	}
}
