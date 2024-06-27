package com.demoqa.qa.test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;
import com.demoqa.qa.base.BaseClass;
import com.demoqa.qa.base.DataClass;
import com.demoqa.qa.pages.FormPage;
import com.demoqa.qa.pages.VerificationPage;
import com.demoqa.qa.testReports.ExtentSpark;
import com.demoqa.qa.utils.Utilities;

public class FullFlowTest extends BaseClass {

	VerificationPage verify;
	DataClass dc;
	Map<String, String> input;
	int i;
	FormPage formPage;
	ExtentSpark exSp;
	ITestContext context;

	public FullFlowTest() {
		super();
	}

	@BeforeSuite
	public void suitSetup() {
		initialization();
		exSp = new ExtentSpark();
	}

	@BeforeTest
	public void setUp() {
		
		formPage = new FormPage();
		verify = new VerificationPage();
		dc = new DataClass();
		input = dc.userData();
		context = Reporter.getCurrentTestResult().getTestContext();

	}

	@Test(priority = 1, enabled = true)
	public void enterFormDetails() {

		List<String> hobbiesList = new ArrayList<>();
		String[] hobbiesArray = null;
		List<String> subjectsList = new ArrayList<>();
		String[] subjectsArray = null;

		formPage.enterFirstName(input.get("FirstName"));

		formPage.enterLastName(input.get("LastName"));

		formPage.enteremailId(input.get("Email"));

		formPage.selectGender(input.get("Gender"));

		formPage.enterUserMobileNumber(input.get("Mobile"));

		formPage.enterDateOfBirth(input.get("DateOfBirth"));

		for (Map.Entry<String, String> entry : input.entrySet()) {
			if (entry.getKey().startsWith("Subjects")) {
				subjectsList.add(entry.getValue());
			}
		}

		if (!subjectsList.isEmpty()) {
			subjectsArray = subjectsList.toArray(new String[0]);
			formPage.enterSubjectDetails(subjectsArray);
		}

		for (Map.Entry<String, String> entry : input.entrySet()) {
			if (entry.getKey().startsWith("Hobbies")) {
				hobbiesList.add(entry.getValue());
			}
		}

		if (!hobbiesList.isEmpty()) {
			hobbiesArray = hobbiesList.toArray(new String[0]);
			formPage.enterHobbies(hobbiesArray);
		}

		formPage.uploadPicture(input.get("Picture"));

		formPage.enterCurrentAddress(input.get("Address"));

		formPage.selectState(input.get("State"));

		formPage.selectCity(input.get("City"));

		formPage.clickOnSubmitButton();

	}

	@Test(priority = 2, enabled = true)
	public void verifyTheName() {
		verify.waitForWindow();

		String actName = verify.getStudentName();
		String expName = input.get("FirstName") + " " + input.get("LastName");

		context.setAttribute("act", actName);
		context.setAttribute("exp", expName);

		assertEquals(actName, expName);
	}

	@Test(priority = 3, enabled = true)
	public void verifyTheEmail() {
		String actEmail = verify.getStudentEmail();
		String expEmail = input.get("Email");
		context.setAttribute("act", actEmail);
		context.setAttribute("exp", expEmail);

		assertEquals(actEmail, expEmail);
	}

	@Test(priority = 4, enabled = true)
	public void verifyTheGender() {

		String actGender = verify.getStudentGender();
//		String expGender = input.get("Gender");
		String expGender = "vvv";
		context.setAttribute("act", actGender);
		context.setAttribute("exp", expGender);

		assertEquals(actGender, expGender);
	}

	@Test(priority = 5, enabled = true)
	public void verifyTheMobileNumber() {
		String actMobile = verify.getStudentMobile();
		String expMobile = input.get("Mobile");
		context.setAttribute("act", actMobile);
		context.setAttribute("exp", expMobile);

		assertEquals(actMobile, expMobile);
	}

	@Test(priority = 6, enabled = true)
	public void verifyTheBirthDate() {
		String actBirthDate = verify.getStudentBirth();
		String expBirthInput = input.get("DateOfBirth");
		context.setAttribute("act", actBirthDate);
		context.setAttribute("exp", expBirthInput);

		assertEquals(actBirthDate, expBirthInput);
	}

	@Test(priority = 7, enabled = true)
	public void verifyTheSubjects() {
		List<String> subjectsList = new ArrayList<>();
		String[] expSubjects = null;

		String[] actSubjects = verify.getStudentSubjects();
		for (Map.Entry<String, String> entry : input.entrySet()) {
			if (entry.getKey().startsWith("Subjects")) {
				subjectsList.add(entry.getValue());
			}
		}

		if (!subjectsList.isEmpty()) {
			expSubjects = subjectsList.toArray(new String[0]);
		}

		for (i = 0; i < actSubjects.length; i++) {
			context.setAttribute("act" + i, actSubjects[i]);
			context.setAttribute("exp" + i, expSubjects[i]);

			assertEquals(actSubjects[i], expSubjects[i]);
		}

	}

	@Test(priority = 8, enabled = true)
	public void verifyTheHobbies() {
		List<String> hobbiesList = new ArrayList<>();
		String[] expHobbies = null;
		String[] actHobbies = verify.getStudentHobbies();
		for (Map.Entry<String, String> entry : input.entrySet()) {
			if (entry.getKey().startsWith("Hobbies")) {
				hobbiesList.add(entry.getValue());
			}
		}

		if (!hobbiesList.isEmpty()) {
			expHobbies = hobbiesList.toArray(new String[0]);
		}

		for (i = 0; i < actHobbies.length; i++) {

			context.setAttribute("act" + i, actHobbies[i]);
			context.setAttribute("exp" + i, expHobbies[i]);

			assertEquals(actHobbies[i], expHobbies[i]);
		}

	}

	@Test(priority = 9, enabled = true)
	public void verifyTheAddress() {
		String actAddress = verify.getStudentAddress();
		String expAddress = input.get("Address");
		context.setAttribute("act", actAddress);
		context.setAttribute("exp", expAddress);

		assertEquals(actAddress, expAddress);
	}

	@Test(priority = 10, enabled = true)
	public void verifyTheLocation() {
		String actLocation = verify.getStudentLocation();
		String expLocation = input.get("State") + " " + input.get("City");
		context.setAttribute("act", actLocation);
		context.setAttribute("exp", expLocation);

		assertEquals(actLocation, expLocation);
	}

	@AfterMethod
	public void testLog(ITestResult result) {

		ITestContext context = result.getTestContext();
		String act = (String) context.getAttribute("act");
		String exp = (String) context.getAttribute("exp");

		if (result.getStatus() == ITestResult.FAILURE) {
//			String message = result.getThrowable().getMessage();
			exSp.testFailure(result, exp, act);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			exSp.testSuccess(result);
		} else {
			exSp.testSkipped(result);
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		System.out.println("Test Completed");
	}

	@AfterSuite
	public void reportGeneration() {
		exSp.extentFlush();
	}

}
