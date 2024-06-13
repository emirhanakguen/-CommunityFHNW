package services.src.main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.AccountManagement;
import services.src.main.java.data.domain.AdminActions;
import services.src.main.java.data.domain.BuddySystem;
import services.src.main.java.data.domain.ForumPost;
import services.src.main.java.data.domain.ForumResponse;
import services.src.main.java.data.domain.IndependentProject;
import services.src.main.java.data.domain.JobAdvertisement;
import services.src.main.java.data.domain.MentoringForProjects;
import services.src.main.java.data.domain.RoomAssignment;
import services.src.main.java.data.domain.SystemLog;
import services.src.main.java.data.domain.TutoringSession;
import services.src.main.java.data.domain.User;
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
		AccountManagement am = new AccountManagement();
		am.setActionType(ActionType.CREATE);
		am.setTimeStamp(2024-03-04-19.09);
		collaborationsList.createAccountManagement(am);

		AdminActions aa = new AdminActions();
		aa.setActionType(ActionType.DELETE);
		aa.setTimeStamp(2024-11-09-14.32);
		collaborationsList.updateAdminAction(aa);

		BuddySystem bs = new BuddySystem();
		bs.setLanguages("English, Italian");
		bs.setStatus(BuddyStatus.ACTIVE);
		collaborationsList.createBuddySystem(bs);

		ForumPost fp = new ForumPost();
		fp.setContent("Exam dates are going to be published in one week");
		fp.setTopic("Exam dates");
		fp.setCreationTime(2023-12-23-10.56);
		collaborationsList.createForumPost(fp);

		ForumResponse fr = new ForumResponse();
		fr.setContent("At what time are we going to receive the time schedule for the exams?");
		fr.setResponseTime(2023-12-26-14.34);
		collaborationsList.createForumResponse(fr);

		IndependentProject ip = new IndependentProject();
		ip.setProjectName("Assignment 1 for Programming 1");
		ip.setDescription("Peter Kranz from the class BITPT1b needs a partner. The project focuses on the simple application of GUI objects.");
		ip.setReccuring(true);
		ip.setStartTime(2022-09-20-08.15);
		ip.setEndTime(2022-12-05-12.00);
		collaborationsList.createIndependentProject(ip);

		JobAdvertisement ja = new JobAdvertisement();
		ja.setTitle("Data security assistant");
		ja.setDescription("It requires a degree in the field of BIT. It involves activities in relation to data security.");
		ja.setApplicationDeadline(2020-10-10-15.30);
		ja.setContactInfo("Mr. Jaeger/No. 079 321 53 12");
		collaborationsList.createJobAdvertisement(ja);

		MentoringForProjects mfp = new MentoringForProjects();
		mfp.setSubject("Corporate Finance and Controlling");
		mfp.setDescription("Explanation of basic concepts/theory and calculations.");
		mfp.setReccuring(false));
		mfp.setProjectName("Additional support for basic lectures");
		mfp.setStartTime(2019-05-20-21.00);
		mfp.setEndTime(2019-02-20-17.15);
		collaborationsList.createMentoringForProjects(mfp);

		RoomAssignment ra = new RoomAssignment();
		ra.setBuilding("FHNW Northwestern Switzerland");
		ra.setCapacity(300);
		ra.setResources("350 chairs and 200 tables");
		ra.setStartTime(2019-03-30-08.15);
		ra.setEndTime(2019-05-30-17.00);
		collaborationsList.createRoomAssignment(ra);

		SystemLog sl = new SystemLog();
		sl.setTimeStamp(2018-11-12-18.26);
		sl.setDescription("Login attempt of user 1 unsuccesful");
		collaborationsList.getAllSystemLogs(sl);

		TutoringSession ts = new TutoringSession();
		ts.setSubject("Introduction to BIT");
		ts.setDescription("Explanation of basic information regarding BIT");
		ts.setReccuring(true);
		ts.setStartTime(2017-10-01-18.00);
		ts.setEndTime(2017-10-01-20.00);
		ts.setStatus(SessionStatus.COMPLETED);
		collaborationsList.createTutoringSession(ts);

		User u = new User();
		u.setUsername("Emirhan Akguen");
		u.setPassword("T20fn2");
		u.setRole(UserRole.ADMIN);
		u.setEmail("emirhan.akguen@students.fhnw.ch");
		u.setPhoneNumber("061 231 79 64");
		collaborationsList.createUser(u);
		
	}

}