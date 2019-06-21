package com.csis3275.Boundary;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1238, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		JPanel signUpPanel = new JPanel();
		signUpPanel.setVisible(false);
		
		JPanel logInpanel = new JPanel();
		logInpanel.setLayout(null);
		
		
		
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
		
		JButton liLogInbutton = new JButton("LogIn");
		liLogInbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(liTypeComboBox.getSelectedItem()=="User")
				{
				String[] currEmail=new String[1];
				currEmail[0]=litextUserName.getText();
				char[] pass=litxtpassword.getPassword();
				String currPass=String.valueOf(pass);
				boolean isMatched=uD.checkUEPass(currEmail[0],currPass);
				if(isMatched)
				{
					System.out.println("Login Successful");	
					UserGoals.main(currEmail);
				}else {
					JOptionPane.showMessageDialog(null, "Sorry,Please try Again");
				}
				}
				
				
			}
		});
		liLogInbutton.setFont(new Font("Tahoma", Font.BOLD, 20));
		liLogInbutton.setBounds(357, 340, 123, 43);
		logInpanel.add(liLogInbutton);
		logInpanel.setBounds(0, 0, 1061, 608);
		frame.getContentPane().add(logInpanel);
		signUpPanel.setBounds(0, 0, 1070, 601);
		frame.getContentPane().add(signUpPanel);
		signUpPanel.setLayout(null);
		
		JLabel splabelTitle = new JLabel("Welcome to SignUp");
		splabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		splabelTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		splabelTitle.setEnabled(true);
		splabelTitle.setBounds(295, 13, 334, 80);
		signUpPanel.add(splabelTitle);
		
		JLabel splabelFirstName = new JLabel("First Name");
		splabelFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelFirstName.setBounds(313, 122, 88, 16);
		signUpPanel.add(splabelFirstName);
		
		JLabel splabelLastName = new JLabel("Last Name");
		splabelLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelLastName.setBounds(313, 182, 99, 16);
		signUpPanel.add(splabelLastName);
		
		JLabel splabelGender = new JLabel("Gender");
		splabelGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelGender.setBounds(313, 234, 74, 16);
		signUpPanel.add(splabelGender);
		
		JLabel splabelAge = new JLabel("Age");
		splabelAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelAge.setBounds(313, 278, 68, 28);
		signUpPanel.add(splabelAge);
		
		JLabel splabelEmail = new JLabel("Email ");
		splabelEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelEmail.setBounds(313, 344, 56, 16);
		signUpPanel.add(splabelEmail);
		
		JLabel splabelPassword = new JLabel("Password ");
		splabelPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelPassword.setBounds(313, 404, 88, 16);
		signUpPanel.add(splabelPassword);
		
		JLabel splabelCPassword = new JLabel("Confirm Password");
		splabelCPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		splabelCPassword.setBounds(313, 464, 170, 16);
		signUpPanel.add(splabelCPassword);
		
		sptextPassword = new JPasswordField();
		sptextPassword.setBounds(520, 392, 245, 43);
		signUpPanel.add(sptextPassword);
		
		sptextConfPassword = new JPasswordField();
		sptextConfPassword.setBounds(520, 452, 245, 43);
		signUpPanel.add(sptextConfPassword);
		
		sptextEmail = new JTextField();
		sptextEmail.setColumns(10);
		sptextEmail.setBounds(520, 332, 245, 43);
		signUpPanel.add(sptextEmail);
		
		JRadioButton spRbMale = new JRadioButton("Male");
		spRbMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spRbMale.setBounds(520, 230, 68, 25);
		signUpPanel.add(spRbMale);
		
		JRadioButton spRbFemale = new JRadioButton("Female");
		spRbFemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spRbFemale.setBounds(596, 230, 79, 25);
		signUpPanel.add(spRbFemale);
		
		JRadioButton spRbOther = new JRadioButton("Other");
		spRbOther.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spRbOther.setBounds(696, 230, 68, 25);
		signUpPanel.add(spRbOther);
		
		sptextAge = new JTextField();
		sptextAge.setColumns(10);
		sptextAge.setBounds(520, 272, 245, 43);
		signUpPanel.add(sptextAge);
		
		sptextFirstName = new JTextField();
		sptextFirstName.setColumns(10);
		sptextFirstName.setBounds(520, 110, 245, 43);
		signUpPanel.add(sptextFirstName);
		
		sptextLastName = new JTextField();
		sptextLastName.setColumns(10);
		sptextLastName.setBounds(520, 170, 245, 43);
		signUpPanel.add(sptextLastName);
		
		JButton spbtnSignup = new JButton("SignUp");
		spbtnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInpanel.setVisible(true);
				signUpPanel.setVisible(false);
				boolean isCreated=false;
				User u=new User();
				u.setUserEmail(sptextEmail.getText());
				u.setUserFirstName(sptextFirstName.getText());
				if(spRbFemale.isSelected())
				{
					u.setUserGender("FeMale");					
				}else if(spRbOther.isSelected()){
					u.setUserGender("other");
				}else {
					u.setUserGender("Male");
				}
				u.setUserLastName(splabelLastName.getText());
				
				char[] pass=sptextPassword.getPassword();
				char[] cpass=sptextConfPassword.getPassword();
				String passT="";
//				for(int i=0;i<pass.length;i++)
//				{
//					passT+=pass[i];
//				}
				u.setUserPassword(String.valueOf(pass));
				u.setUserAge(Integer.parseInt(sptextAge.getText()));
				if(!String.valueOf(pass).equalsIgnoreCase(String.valueOf(cpass)))
				{
					JOptionPane.showMessageDialog(null, "Password and confirm Password does not match");
				}else {
					String currEmail=uD.createUserAccount(u);
					if(currEmail.equalsIgnoreCase(sptextEmail.getText()))
					{
						isCreated=true;
					}
				}
				if(isCreated)
				{
					JOptionPane.showMessageDialog(null, "Congrats,Account Created");
				}else {
					JOptionPane.showMessageDialog(null, "Sorry,Please try Again");
				}
			
			}
		});
		spbtnSignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		spbtnSignup.setBounds(324, 527, 123, 43);
		signUpPanel.add(spbtnSignup);
		
		JButton spbtnLogIn = new JButton("LogIn");
		spbtnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInpanel.setVisible(true);
				signUpPanel.setVisible(false);
				
			}
		});
		spbtnLogIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		spbtnLogIn.setBounds(528, 527, 123, 43);
		signUpPanel.add(spbtnLogIn);
	}
}
