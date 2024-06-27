package com.demoqa.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.qa.base.BaseClass;
import com.demoqa.qa.utils.Utilities;

public class FormPage extends BaseClass{
	
		Utilities util = new Utilities();
	
		public FormPage() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (xpath = "//h1[text()='Practice Form']")
		WebElement formTitle;
		
		@FindBy (id = "firstName")
		WebElement firstNameTb;
		
		@FindBy (id = "lastName")
		WebElement lastNameTb;
		
		@FindBy (id = "userEmail")
		WebElement emaiIdTb;
		
		@FindBy (id = "dateOfBirthInput")
		WebElement dateOfBirthTb;
		
		@FindBy (id = "userNumber")
		WebElement mobileNumTb;
		
		@FindBy (id = "subjectsInput")
		WebElement subjectTb;
		
		@FindBy (xpath = "//div[contains(@class,'multi-value__remove')]") 
		WebElement iconCloseSub;
		
		@FindBy (id = "uploadPicture")
		WebElement uploadPhotoBtn;
		
		@FindBy (id = "currentAddress")
		WebElement currentAddressBtn;
		
		@FindBy(xpath = "//div[@id='state']") 
		WebElement clickState;
		
		@FindBy(xpath = "//div[@id='state']//input")
		WebElement stateInput;
		
		@FindBy(xpath = "//div[@id='city']") 
		WebElement clickCity;
		
		@FindBy(xpath = "//div[@id='city']//input") 
		WebElement cityInput;
		
		@FindBy (id = "submit")
		WebElement submitBtn;
		

		public void enterFirstName(String fName) {
				util.scrollUsingJs(formTitle);
				firstNameTb.sendKeys(fName);
		}
		

		public void enterLastName(String lName) {
			lastNameTb.sendKeys(lName);
		}
		
		
		public void enteremailId(String email) {
			emaiIdTb.sendKeys(email);
		}
		
		
		public void selectGender(String gender) {
			driver.findElement(By.xpath("//label[text()='"+ gender +"']")).click();
		}
		
		
		public void enterUserMobileNumber(String contact) {
			mobileNumTb.sendKeys(contact);
		}
		
		
		public void enterDateOfBirth(String birthdate) {
			util.selectAndReplaceText(dateOfBirthTb, birthdate);
		}
		
		
		public void enterSubjectDetails(String[] subjects) {
			
			for(String sub : subjects) {
				subjectTb.click();
				subjectTb.sendKeys(sub);
				subjectTb.sendKeys(Keys.ENTER);
				util.visibilityWait(iconCloseSub);
			}
		}
		
		
		public void enterHobbies(String [] hobbies) {
			
			for(String hobby : hobbies) {
				By userHob = By.xpath("//label[text()='"+ hobby +"']");
				driver.findElement(userHob).click();
			}
		}
		
		
		public void uploadPicture(String linkOfPic) {
			util.scrollUsingJs(mobileNumTb);
			uploadPhotoBtn.sendKeys(linkOfPic);
		}
		
		
		public void enterCurrentAddress(String address) {
			currentAddressBtn.sendKeys(address);
		}
		
		
		public void selectState(String state) {
			clickState.click();
			stateInput.sendKeys(state);
			stateInput.sendKeys(Keys.ENTER);
		}
		
		public void selectCity(String city) {
			clickCity.click();
			cityInput.sendKeys(city);
			cityInput.sendKeys(Keys.ENTER);
			
		}
		
		public void clickOnSubmitButton() {
			util.scrollUsingJs(dateOfBirthTb);
			submitBtn.click();
		}
}