package ch.fhnw.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.pizza.business.service.CollaborationsList;
import ch.fhnw.pizza.data.domain.AccountManagement;
import ch.fhnw.pizza.data.domain.AccountManagement.Actiontype;
import ch.fhnw.pizza.data.domain.AdminActions;
import ch.fhnw.pizza.data.domain.AdminActions.Actiontypes;
import ch.fhnw.pizza.data.domain.Advertisement;
import ch.fhnw.pizza.data.domain.BuddyAssignment;
import ch.fhnw.pizza.data.domain.BuddySystem;
import ch.fhnw.pizza.data.domain.BuddySystem.BuddyStatus;
import ch.fhnw.pizza.data.domain.ForumPost;
import ch.fhnw.pizza.data.domain.ForumResponse;
import ch.fhnw.pizza.data.domain.IndependentProject;
import ch.fhnw.pizza.data.domain.JobAdvertisement;
import ch.fhnw.pizza.data.domain.MentoringForProjects;
import ch.fhnw.pizza.data.domain.RoomAssignment;
import ch.fhnw.pizza.data.domain.SystemLog;
import ch.fhnw.pizza.data.domain.TutoringSession;
import ch.fhnw.pizza.data.domain.TutoringSession.SessionStatus;
import ch.fhnw.pizza.data.domain.User;
import ch.fhnw.pizza.data.domain.User.UserRole;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class CollaborationApplication {

	@Autowired
	private CollaborationsList collaborationsList;

	public static void main(String[] args) {
		SpringApplication.run(CollaborationApplication.class, args);
	}

	// Use this method to initialize placeholder data without using Postman
	// If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
	// To resolve the error, delete the file and restart the application
	@PostConstruct
	private void initPlaceholderData() throws Exception {
		AccountManagement am = new AccountManagement(0, null, null);
		am.setActionType(Actiontype.CREATE);
		am.setTimeStamp("2024-03-04-19.09");
		collaborationsList.createAccountManagement(am);

		AdminActions aa = new AdminActions(0, null, null);
		aa.setActionType(Actiontypes.DELETE);
		aa.setTimeStamp("2024-11-07-14.32");
		collaborationsList.updateAdminAction(0, aa);

		Advertisement a = new Advertisement(0, null, null);
		a.settitle("Project support for BI");
		a.setcontent("Base knowledge and support for BI");
		collaborationsList.createAdvertisement(a);

		BuddySystem bs = new BuddySystem(0, null, null);
		bs.setLanguages("English, Italian");
		bs.setStatus(BuddyStatus.ACTIVE);
		collaborationsList.createBuddySystem(bs);

		BuddyAssignment ba = new BuddyAssignment(0, null, 0);
		ba.setinternationalstudentId("3Tewr");
		ba.setbuddyId(23);
		collaborationsList.createBuddyAssingment(ba);

		ForumPost fp = new ForumPost(0, null, null, null);
		fp.setContent("Exam dates are going to be published in one week");
		fp.setTopic("Exam dates");
		fp.setCreationTime("2023-12-23-10.56");
		collaborationsList.createForumPost(fp);

		ForumResponse fr = new ForumResponse(0, null, null);
		fr.setContent("At what time are we going to receive the time schedule for the exams?");
		fr.setResponseTime("2023-12-26-14.34");
		collaborationsList.createForumResponse(fr);

		IndependentProject ip = new IndependentProject(0, null, null, null, null, null);
		ip.setProjectName("Assignment 1 for Programming 1");
		ip.setDescription("Peter Kranz from the class BITPT1b needs a partner. The project focuses on the simple application of GUI objects.");
		ip.setReccuring(true);
		ip.setStartTime("2022-01-20-08.15");
		ip.setEndTime("2022-12-05-12.00");
		collaborationsList.createIndependentProject(ip);

		JobAdvertisement ja = new JobAdvertisement(0, null, null, null, null);
		ja.setTitle("Data security assistant");
		ja.setDescripton("It requires a degree in the field of BIT. It involves activities in relation to data security.");
		ja.setApplicationDeadline("2020-10-10-15.30");
		ja.setContactInfo("Mr. Jaeger/No. 079 321 53 12");
		collaborationsList.createJobAdvertisement(ja);

		MentoringForProjects mfp = new MentoringForProjects(0, null, null, null, null, null, null);
		mfp.setSubject("Corporate Finance and Controlling");
		mfp.setDescription("Explanation of basic concepts/theory and calculations.");
		mfp.setRecurring(false);
		mfp.setProjectName("Additional support for basic lectures");
		mfp.setStartTime("2019-05-20-21.00");
		mfp.setEndTime("2019-02-20-17.15");
		collaborationsList.createMentoringForProjects(mfp);

		RoomAssignment ra = new RoomAssignment(0, null, 0, null, null, null);
		ra.setBuilding("FHNW Northwestern Switzerland");
		ra.setCapacity(300);
		ra.setResources("350 chairs and 200 tables");
		ra.setStartTime("2019-03-30-08.15");
		ra.setEndTime("2019-05-30-17.00");
		collaborationsList.createRoomAssignment(ra);

		SystemLog sl = new SystemLog(0, null, null);
		sl.setTimeStamp("2018-11-12-18.26");
		sl.setDescription("Login attempt of user 1 unsuccesful");
		collaborationsList.getAllSystemLogs(sl);

		TutoringSession ts = new TutoringSession(0, null, null, null, null, null, null);
		ts.setSubject("Introduction to BIT");
		ts.setDescription("Explanation of basic information regarding BIT");
		ts.setRecurring(true);
		ts.setStartTime("2017-10-01-18.00");
		ts.setEndTime("2017-10-01-20.00");
		ts.setStatus(SessionStatus.COMPLETED);
		collaborationsList.createTutoringSession(ts);

		User u = new User(0, null, null, null, null, null);
		u.setUsername("Emirhan Akguen");
		u.setPassword("T20fn2");
		u.setRole(UserRole.ADMIN);
		u.setEmail("emirhan.akguen@students.fhnw.ch");
		u.setPhoneNumber("061 231 79 64");
		collaborationsList.createUser(u);
	}
}