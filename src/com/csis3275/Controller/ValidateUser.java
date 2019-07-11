package com.csis3275.Controller;

import javax.swing.JOptionPane;

import com.csis3275.Boundary.LoginRegisterGUI;
import com.csis3275.Entities.User;

/**
 * 
 * @author harpreet kaur
 * student id 300288768
 *
 */

public class ValidateUser {
	User u=new User();
	boolean isValidUser;

	public User validate(String email, String fName, String lname, char[] password, char[] Confirmpassword, String age) {

		isValidUser=true;
		if(fName.isEmpty() || lname.isEmpty() || email.isEmpty() || age.isEmpty() || password.length==0 || Confirmpassword.length==0)
		{
			 JOptionPane.showMessageDialog(null, "One of the required field is empty!", "Error", JOptionPane.ERROR_MESSAGE);
			 isValidUser= false;
		}else if(password.length<7)
		{
			 JOptionPane.showMessageDialog(null, "Password must be greater than 6 charaters", "Error", JOptionPane.ERROR_MESSAGE);
			isValidUser=false;
		}else if(!String.valueOf(password).equalsIgnoreCase(String.valueOf(Confirmpassword)))
			{
				JOptionPane.showMessageDialog(null, "Password and confirm Password does not match");
				isValidUser=false;
			}
		
		if(isValidUser)
		{
			u.setUserFirstName(fName);
			u.setUserLastName(lname);
			u.setUserEmail(email);
			u.setUserAge(Integer.parseInt(age));
			u.setUserPassword(String.valueOf(password));
			return u;
		}
		
		
		return null;
	}
	
	
	

	

}
