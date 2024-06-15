package ch.fhnw.pizza.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.AccountManagement;
import ch.fhnw.pizza.data.domain.AdminActions;
import ch.fhnw.pizza.data.domain.Advertisement;
import ch.fhnw.pizza.data.domain.BuddyAssignment;
import ch.fhnw.pizza.data.domain.BuddySystem;
import ch.fhnw.pizza.data.domain.ForumPost;
import ch.fhnw.pizza.data.domain.ForumResponse;
import ch.fhnw.pizza.data.domain.IndependentProject;
import ch.fhnw.pizza.data.domain.JobAdvertisement;
import ch.fhnw.pizza.data.domain.MentoringForProjects;
import ch.fhnw.pizza.data.domain.RoomAssignment;
import ch.fhnw.pizza.data.domain.SystemLog;
import ch.fhnw.pizza.data.domain.TutoringSession;
import ch.fhnw.pizza.data.domain.User;
import ch.fhnw.pizza.data.repository.AccountManagementRepository;
import ch.fhnw.pizza.data.repository.AdminActionsRepository;
import ch.fhnw.pizza.data.repository.AdvertisementRepository;
import ch.fhnw.pizza.data.repository.BuddyAssignmentRepository;
import ch.fhnw.pizza.data.repository.BuddySystemRepository;
import ch.fhnw.pizza.data.repository.ForumPostRepository;
import ch.fhnw.pizza.data.repository.ForumResponseRepository;
import ch.fhnw.pizza.data.repository.IndependentProjectRepository;
import ch.fhnw.pizza.data.repository.JobAdvertisementRepository;
import ch.fhnw.pizza.data.repository.MentoringForProjectsRepository;
import ch.fhnw.pizza.data.repository.RoomAssignmentRepository;
import ch.fhnw.pizza.data.repository.SystemLogRepository;
import ch.fhnw.pizza.data.repository.TutoringSessionRepository;
import ch.fhnw.pizza.data.repository.UserRepository;

@Service
public class CollaborationsList {

    @Autowired
    private AccountManagementRepository accountManagementRepository;

    @Autowired
    private AdminActionsRepository adminActionsRepository;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private BuddySystemRepository buddySystemRepository;

    @Autowired
    private BuddyAssignmentRepository buddyAssignmentRepository;

    @Autowired
    private ForumPostRepository forumPostRepository;

    @Autowired
    private ForumResponseRepository forumResponseRepository;

    @Autowired
    private IndependentProjectRepository independentProjectRepository;

    @Autowired 
    private JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    private MentoringForProjectsRepository mentoringForProjectsRepository;

    @Autowired
    private RoomAssignmentRepository roomAssignmentRepository;

    @Autowired
    private SystemLogRepository systemLogRepository;

    @Autowired
    private TutoringSessionRepository tutoringSessionRepository;

    @Autowired
    private UserRepository userRepository;

    public AccountManagement updateAccountManagement(long ManagementID, AccountManagement updatedAccount) throws Exception {
        AccountManagement existingAccount = accountManagementRepository.findById(ManagementID).get();
        if(existingAccount != null){
            if(updatedAccount.getActionType() != null)
                existingAccount.setActionType(updatedAccount.getActionType());
            if(updatedAccount.getTimeStamp() != null)
                existingAccount.setTimeStamp(updatedAccount.getTimeStamp());
                return accountManagementRepository.save(existingAccount);
            }
            throw new Exception("Account not found with ID: " + ManagementID);
    }

    public void deleteAccountManagement(long ManagementID) throws Exception{
        if(accountManagementRepository.existsById(ManagementID)){
            accountManagementRepository.deleteById(ManagementID);
        } else 
            throw new Exception("Account management record " + ManagementID + " was deleted successfully.");
    }

    public AccountManagement createAccountManagement(AccountManagement accountManagement) throws Exception {
        if(accountManagement.getActionType() != null){
            if(accountManagementRepository.findByActionType(accountManagement.getActionType()) == null)
                return accountManagementRepository.save(accountManagement);
            throw new Exception("Account management record " + accountManagement.getActionType() + " already available");
        } 
        throw new Exception("Invalid action type");  
    } 

    public AdminActions updateAdminAction(long ActionID,AdminActions adminAction) throws Exception {
        AdminActions existingAction = adminActionsRepository.findById(ActionID).get();
        if(existingAction != null){
            if(adminAction.getActionType() != null)
                existingAction.setActionType(adminAction.getActionType());
            if(adminAction.getTimeStamp() != null)
                existingAction.setTimeStamp(adminAction.getTimeStamp());
                return adminActionsRepository.save(existingAction);
            }
            throw new Exception("Action not found with ID: " + ActionID);
    }

    public void deleteAdminAction(long ActionID) throws Exception {
        if (adminActionsRepository.existsById(ActionID)) {
            adminActionsRepository.deleteById(ActionID);
        } else {
            throw new Exception("Admin action with ID: " + ActionID + " not found.");
        }
    }

    public Advertisement createAdvertisement(Advertisement advertisement) throws Exception {
        if(advertisement.gettitle() != null){
            if(advertisementRepository.findBytitle(advertisement.gettitle()) == null)
                return advertisementRepository.save(advertisement);
            throw new Exception("Advertisement with the title " + advertisement.gettitle() + " already available");
        } 
        throw new Exception("Invalid action type");  
    } 

    public void deleteForumPost(long PostID) throws Exception{
        if(forumPostRepository.existsById(PostID)){
            forumPostRepository.deleteByPostId(PostID);
        } else
            throw new Exception("Post with id " + PostID + " not found.");
    }

    public ForumPost updateForumPost(long PostID,ForumPost updatedPost) throws Exception{
        ForumPost existingPost = forumPostRepository.findById(PostID).get();
        if(existingPost != null){
            if(updatedPost.getContent() != null)
                existingPost.setContent(updatedPost.getContent());
            if(updatedPost.getTopic() != null)
                existingPost.setTopic(updatedPost.getTopic());
            if(updatedPost.getCreationTime() != null)
                existingPost.setCreationTime(updatedPost.getCreationTime());
            return  forumPostRepository.save(existingPost);
        }
        throw new Exception("Post not found with ID: " + PostID);
    }

    public BuddySystem createBuddySystem(BuddySystem buddySystem) throws Exception {
        if(buddySystem.getLanguages() != null) {
            if(buddySystemRepository.findByLanguages(buddySystem.getLanguages()) == null)
                return buddySystemRepository.save(buddySystem);
            throw new Exception("Buddy with " + buddySystem.getLanguages() + " language already available.");
        }
        throw new Exception("Invalid language");
    }

    public List<BuddySystem> getAllBuddySystems(String Languages) {
        List<BuddySystem> buddySystems = buddySystemRepository.findByLanguages(Languages);
        return buddySystems;
    }

    public BuddyAssignment createBuddyAssingment(BuddyAssignment bs) throws Exception {
        if(bs.getinternationalstudentId() != null){
            if(buddyAssignmentRepository.findByinternationalstudentId(bs.getinternationalstudentId()) == null)
                return buddyAssignmentRepository.save(bs);
            throw new Exception("Post with " + bs.getinternationalstudentId() + " topic already available.");
        }
        throw new Exception("Invalid topic");
    }

    public ForumPost createForumPost(ForumPost forumPost) throws Exception {
        if(forumPost.getTopic() != null){
            if(forumPostRepository.findByTopic(forumPost.getTopic()) == null)
                return forumPostRepository.save(forumPost);
            throw new Exception("Post with " + forumPost.getTopic() + " topic already available.");
        }
        throw new Exception("Invalid topic");
    }

    public ForumResponse createForumResponse(ForumResponse forumResponse) throws Exception{
        if(forumResponse.getResponseTime() != null){
            if(forumResponseRepository.findByResponseTime(forumResponse.getResponseTime()) == null)
                return forumResponseRepository.save(forumResponse);
            throw new Exception("Forum response with " + forumResponse.getResponseTime() + " response time already available.");
        }
        throw new Exception("Invalid response time");
    }  

    public IndependentProject createIndependentProject(IndependentProject independentProject) throws Exception {
        if(independentProject.getProjectName() != null){
            if(independentProjectRepository.findByProjectName(independentProject.getProjectName()) == null)
                return independentProjectRepository.save(independentProject);
            throw new Exception("Project with " + independentProject.getProjectName() + " project name already available.");
        }
        throw new Exception("Invalied project name");
    }

    public JobAdvertisement createJobAdvertisement(JobAdvertisement jobAdvertisement) throws Exception {
        if(jobAdvertisement.getTitle() != null){
            if(jobAdvertisementRepository.findByTitle(jobAdvertisement.getTitle()) == null)
                return jobAdvertisementRepository.save(jobAdvertisement);
            throw new Exception("Job advertisement with " + jobAdvertisement.getTitle() + " title already available.");
        }
        throw new Exception("Invalid title");
    } 

    public MentoringForProjects createMentoringForProjects(MentoringForProjects mentoringForProjects) throws Exception{
        if(mentoringForProjects.getSubject() != null){
            if(mentoringForProjectsRepository.findBySubject(mentoringForProjects.getSubject()) == null)
                return mentoringForProjectsRepository.save(mentoringForProjects);
            throw new Exception("Mentoring with " + mentoringForProjects.getSubject() + " subject already available.");
        }
        throw new Exception("Invalid subject");
    }

    public List<MentoringForProjects> getAllMentoringForProjects() {
        List<MentoringForProjects> mentoringList = mentoringForProjectsRepository.findAll();
        return mentoringList;
    }

    public RoomAssignment createRoomAssignment(RoomAssignment roomAssignment) throws Exception{
        if(roomAssignment.getBuilding() != null){
            if(roomAssignmentRepository.findByBuilding(roomAssignment.getBuilding()) == null)
                return roomAssignmentRepository.save(roomAssignment);
            throw new Exception("Room assignment with " + roomAssignment.getBuilding() + " building already available.");
        }
        throw new Exception("Invalid building");
    }

    public List<SystemLog> getAllSystemLogs(SystemLog sl) {
        List<SystemLog> systemLogs = systemLogRepository.findAll();
        return systemLogs;
    }

    public TutoringSession createTutoringSession(TutoringSession tutoringSession) throws Exception{
            if(tutoringSession.getSubject() != null){
                if(tutoringSessionRepository.findBySubject(tutoringSession.getSubject()) == null)
                    return tutoringSessionRepository.save(tutoringSession);
                throw new Exception("Tutoring with " + tutoringSession.getSubject() + " subject already available.");
            }
            throw new Exception("Invalid subject");
    }

    public List<TutoringSession> getAllTutoringSession() {
        List<TutoringSession> tutoringSessions = tutoringSessionRepository.findAll();
        return tutoringSessions;
    }
    
    public User createUser(User user) throws Exception {
            if(user.getUsername() != null){
                if(userRepository.findByUsername(user.getUsername()) == null)
                    return userRepository.save(user);
                throw new Exception("User with " + user.getUsername() + " name already available.");
            }
            throw new Exception("Invalid user name");
    }

    public User updateUser(long UserID,User updatedUser) throws Exception{
        User existingUser = userRepository.findById(UserID).get();
        if(existingUser != null){
            if(updatedUser.getUsername() != null)
                existingUser.setUsername(updatedUser.getUsername());
            if(updatedUser.getPassword() != null)
                existingUser.setPassword(updatedUser.getPassword());
            if(updatedUser.getRole() != null)
                existingUser.setRole(updatedUser.getRole());
            if(updatedUser.getEmail() != null)
                existingUser.setEmail(updatedUser.getEmail());
            if(updatedUser.getPhoneNumber() != null)
                existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepository.save(existingUser);    
        }
        throw new Exception("User with id " + UserID + " not available.");
    }
    
    public void deleteUser(long UserID) throws Exception{
        if(userRepository.existsById(UserID)){
            userRepository.deleteById(UserID);
        }else{
            throw new Exception("User with id " + UserID + " does not exist.");
        }
    }
}