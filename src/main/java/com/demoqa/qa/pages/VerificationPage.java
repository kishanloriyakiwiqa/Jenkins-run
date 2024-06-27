package com.demoqa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.qa.base.BaseClass;
import com.demoqa.qa.utils.Utilities;

public class VerificationPage extends BaseClass {

	Utilities util = new Utilities();
	
	public VerificationPage() {
		
		PageFactory.initElements(driver, this);
	}
	
		@FindBy (xpath = "//div[@class='modal-content']//div[text()='Thanks for submitting the form']")
		WebElement confPopup;
		
		@FindBy (xpath = "//td[text()='Student Name']/../td[2]")
		WebElement studentName;
		
		@FindBy (xpath = "//td[text()='Student Email']/../td[2]")
		WebElement studentEmail;
		
		@FindBy (xpath = "//td[text()='Gender']/../td[2]")
		WebElement studentGender;
		
		@FindBy (xpath = "//td[text()='Mobile']/../td[2]")
		WebElement studentMobile;
		
		@FindBy (xpath = "//td[text()='Date of Birth']/../td[2]")
		WebElement studentBirth;
		
		@FindBy (xpath = "//td[text()='Subjects']/../td[2]")
		WebElement studentSubjects;
		
		@FindBy (xpath = "//td[text()='Hobbies']/../td[2]")
		WebElement studentHobbies;
		
		@FindBy (xpath = "//td[text()='Address']/../td[2]")
		WebElement studentAddress;
		
		@FindBy (xpath = "//td[text()='State and City']/../td[2]")
		WebElement studentLocation;
		
		@FindBy (id = "closeLargeModal")
		WebElement closeBtn;
		
	
		public void waitForWindow() {
			util.visibilityWait(confPopup);
		}
		
		
		public String getStudentName() {
			String nameText = util.getTextFromElement(studentName);
			return nameText;
		}
		
		public String getStudentEmail() {
			String emailText = util.getTextFromElement(studentEmail);
			return emailText;
		}
		
		public String getStudentGender() {
			String genderText = util.getTextFromElement(studentGender);
			return genderText;
		}
		
		public String getStudentMobile() {
			String MobileText = util.getTextFromElement(studentMobile);
			return MobileText;
		}
		
		public String getStudentBirth() {
			String birthText = util.getTextFromElement(studentBirth);
			return birthText;
		}
		
		public String[] getStudentSubjects() {
			String subjectsText = util.getTextFromElement(studentSubjects);
			String[] subject = subjectsText.split(", ");
			return subject;
			
		}
		
		public String[] getStudentHobbies() {
			String hobbiesText = util.getTextFromElement(studentHobbies);
			String[] hobby = hobbiesText.split(", ");
			return hobby;
		}
		
		public String getStudentAddress() {
			String addressText = util.getTextFromElement(studentAddress);
			return addressText;
		}
		
		public String getStudentLocation() {
			String locationText = util.getTextFromElement(studentLocation);
			return locationText;
		}
		
		public void closeWindow() {
			closeBtn.click();
		}
		
}
