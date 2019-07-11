package com.csis3275.Boundary;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.csis3275.Controller.ValidateUser;
import com.csis3275.Entities.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;

/**
 * 
 * @author harpreet kaur
 * student id 300288768
 */

public class LoginRegisterGUI {

	private JFrame frame;
	private JTextField litextUserName;
	private JPasswordField sptextPassword;
	private JPasswordField sptextConfPassword;
	private JTextField sptextEmail;
	private JTextField sptextAge;
	private JTextField sptextFirstName;
	private JTextField sptextLastName;
	private JPasswordField litxtpassword;
	UserDAOImpl uD=new UserDAOImpl();
	
	ValidateUser vu=new ValidateUser();

	/**
	 * Launch the application.
	 * @param args return email at 0 index.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginRegisterGUI window = new LoginRegisterGUI();
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
	public LoginRegisterGUI() {
		initialize();
		//Manually 
		//uD.admin();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1372, 830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel logInpanel = new JPanel();
		logInpanel.setLayout(null);
		
		JPanel signUpPanel = new JPanel();
		signUpPanel.setVisible(false);
		signUpPanel.setBounds(116, 93, 1070, 665);
		frame.getContentPane().add(signUpPanel);
		signUpPanel.setLayout(null);
		
		JLabel suTypelabel = new JLabel("Type :");
		suTypelabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		suTypelabel.setBounds(305, 88, 129, 43);
		signUpPanel.add(suTypelabel);
		
		JComboBox suTypeComboBox = new JComboBox();
		suTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"User", "Instructor"}));
		suTypeComboBox.setBounds(521, 88, 245, 43);
		signUpPanel.add(suTypeComboBox);
		
		
		
		JLabel lilabelTitle = new JLabel("Welcome to LogIn");
		lilabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lilabelTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lilabelTitle.setBounds(353, 32, 221, 29);
		logInpanel.add(lilabelTitle);
		
		JLabel lilabelType = new JLabel("Type :");
		lilabelType.setFont(new Font("Tahoma", Font.BOLD, 20));
		lilabelType.setBounds(300, 140, 129, 43);
		logInpanel.add(lilabelType);
		
		JLabel lilabelPassword = new JLabel("Password :");
		lilabelPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lilabelPassword.setBounds(302, 260, 129, 43);
		logInpanel.add(lilabelPassword);
		
		litextUserName = new JTextField();
		litextUserName.setColumns(10);
		litextUserName.setBounds(516, 200, 245, 43);
		logInpanel.add(litextUserName);
		
		JLabel label_3 = new JLabel("UserName :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(300, 200, 129, 43);
		logInpanel.add(label_3);
		

		
		litxtpassword = new JPasswordField();
		litxtpassword.setBounds(516, 260, 245, 43);
		logInpanel.add(litxtpassword);
		
		JComboBox liTypeComboBox = new JComboBox();
		liTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"User", "Instructor", "Admin"}));
		liTypeComboBox.setBounds(516, 140, 245, 43);
		logInpanel.add(liTypeComboBox);
		
		/**
		 * when signup button is clicked the Login panel hides and signup panel showup.
		 */
		
		JButton liSignUpButton = new JButton("SignUp");
		liSignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInpanel.setVisible(false);
				signUpPanel.setVisible(true);
			}
		});
		liSignUpButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		liSignUpButton.setBounds(549, 340, 123, 43);
		logInpanel.add(liSignUpButton);
		
		
		/**
		 * when login button is clicked ,it checks whether user,Instructor or Admin is loging in
		 * checks the EmailAddress and password 
		 */
		
		JButton liLogInbutton = new JButton("LogIn");
		liLogInbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] currEmail=new String[2];
				currEmail[0]=litextUserName.getText();
				currEmail[1]=liTypeComboBox.getSelectedItem().toString();
				char[] pass=litxtpassword.getPassword();
				String currPass=String.valueOf(pass);
				
				if(liTypeComboBox.getSelectedItem()=="User")
				{
				boolean isMatched=uD.checkUEPass(currEmail[0],currPass);
				if(isMatched)
				{
					System.out.println("User Login Successful");	
					UserGoals.main(currEmail);
				}else {
					JOptionPane.showMessageDialog(null, "Sorry,Please try Again");
				}
				}else if(liTypeComboBox.getSelectedItem()=="Instructor") {
					boolean isMatched=uD.checkInstrucorEPass(currEmail[0],currPass);
					if(isMatched)
					{
						System.out.println("Instructor Login Successful");	
						UserGoals.main(currEmail);
					}else {
						JOptionPane.showMessageDialog(null, "Sorry,Please try Again");
					}
				}else {
					boolean isMatched=uD.checkAdminEPass(currEmail[0],currPass);
					if(isMatched)
					{
						System.out.println("Admin Login Successful");	
						UserGoals.main(currEmail);
					}else {
						JOptionPane.showMessageDialog(null, "Sorry,Please try Again");
					}
				}
				
				
			}
		});
		

		
	
		
		JLabel splabelTitle = new JLabel("Welcome to SignUp");
		splabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		splabelTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		splabelTitle.setEnabled(true);
		splabelTitle.setBounds(295, 13, 334, 80);
		signUpPanel.add(splabelTitle);
		
		JLabel splabelFirstName = new JLabel("First Name");
		splabelFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelFirstName.setBounds(313, 171, 88, 16);
		signUpPanel.add(splabelFirstName);
		
		JLabel splabelLastName = new JLabel("Last Name");
		splabelLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelLastName.setBounds(313, 231, 99, 16);
		signUpPanel.add(splabelLastName);
		
		JLabel splabelGender = new JLabel("Gender");
		splabelGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelGender.setBounds(313, 283, 74, 16);
		signUpPanel.add(splabelGender);
		
		JLabel splabelAge = new JLabel("Age");
		splabelAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelAge.setBounds(313, 327, 68, 28);
		signUpPanel.add(splabelAge);
		
		JLabel splabelEmail = new JLabel("Email ");
		splabelEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelEmail.setBounds(313, 393, 56, 16);
		signUpPanel.add(splabelEmail);
		
		JLabel splabelPassword = new JLabel("Password ");
		splabelPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelPassword.setBounds(313, 453, 88, 16);
		signUpPanel.add(splabelPassword);
		
		JLabel splabelCPassword = new JLabel("Confirm Password");
		splabelCPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelCPassword.setBounds(313, 513, 170, 16);
		signUpPanel.add(splabelCPassword);
		
		sptextPassword = new JPasswordField();
		sptextPassword.setBounds(520, 441, 245, 43);
		signUpPanel.add(sptextPassword);
		
		sptextConfPassword = new JPasswordField();
		sptextConfPassword.setBounds(520, 501, 245, 43);
		signUpPanel.add(sptextConfPassword);
		
		sptextEmail = new JTextField();
		sptextEmail.setColumns(10);
		sptextEmail.setBounds(520, 381, 245, 43);
		signUpPanel.add(sptextEmail);
		
		JRadioButton spRbMale = new JRadioButton("Male");
		spRbMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spRbMale.setBounds(520, 279, 68, 25);
		signUpPanel.add(spRbMale);
		
		JRadioButton spRbFemale = new JRadioButton("Female");
		spRbFemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spRbFemale.setBounds(596, 279, 79, 25);
		signUpPanel.add(spRbFemale);
		
		JRadioButton spRbOther = new JRadioButton("Other");
		spRbOther.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spRbOther.setBounds(696, 279, 68, 25);
		signUpPanel.add(spRbOther);
		
		sptextAge = new JTextField();
		sptextAge.setColumns(10);
		sptextAge.setBounds(520, 321, 245, 43);
		signUpPanel.add(sptextAge);
		
		sptextFirstName = new JTextField();
		sptextFirstName.setColumns(10);
		sptextFirstName.setBounds(520, 159, 245, 43);
		signUpPanel.add(sptextFirstName);
		
		sptextLastName = new JTextField();
		sptextLastName.setColumns(10);
		sptextLastName.setBounds(520, 219, 245, 43);
		signUpPanel.add(sptextLastName);
		
		/**
		 * create new account
		 * before signing up for the new account ,validation on the information is also performed
		 * only user or Instructor can signup for new account
		 */
		
		JButton spbtnSignup = new JButton("SignUp");
		spbtnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				boolean isCreated=false;
				
				User u=new User();
				u=vu.validate(sptextEmail.getText(),sptextFirstName.getText(),sptextLastName.getText(),sptextPassword.getPassword(),
						sptextConfPassword.getPassword(),sptextAge.getText());

				if(u!=null)
				{
					if(spRbFemale.isSelected())
					{
						u.setUserGender("FeMale");					
					}else if(spRbOther.isSelected()){
						u.setUserGender("other");
					}else {
						u.setUserGender("Male");
					}
					String currentEmail="";
					u.setInstructor(suTypeComboBox.getSelectedItem().toString());
					if(suTypeComboBox.getSelectedIndex()==0)
					{						
						currentEmail=uD.createUserAccount(u);
						System.out.println("entering");
					}else {
						currentEmail=uD.createInstructorAccount(u);
					}
										
					if(currentEmail.equalsIgnoreCase(sptextEmail.getText()))
					{
						isCreated=true;
					}
					logInpanel.setVisible(true);
					signUpPanel.setVisible(false);
				}
				if(isCreated)
				{
					JOptionPane.showMessageDialog(null, "Congrats,"+suTypeComboBox.getSelectedItem()+" Account Created");
				}else {
					JOptionPane.showMessageDialog(null, "Sorry,Please try Again");
				}
			
			}
		});
		spbtnSignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		spbtnSignup.setBounds(324, 576, 123, 43);
		signUpPanel.add(spbtnSignup);
		
		JButton spbtnLogIn = new JButton("LogIn");
		spbtnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInpanel.setVisible(true);
				signUpPanel.setVisible(false);
				
			}
		});
		spbtnLogIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		spbtnLogIn.setBounds(528, 576, 123, 43);
		signUpPanel.add(spbtnLogIn);
		
	
		liLogInbutton.setFont(new Font("Tahoma", Font.BOLD, 20));
		liLogInbutton.setBounds(357, 340, 123, 43);
		logInpanel.add(liLogInbutton);
		logInpanel.setBounds(125, 86, 1061, 672);
		frame.getContentPane().add(logInpanel);
	}
}
