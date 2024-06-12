package services.src.main.java.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

import services.src.main.java.data.repository.AccountManagementRepository;
import services.src.main.java.data.repository.AdminActionsRepository;
import services.src.main.java.data.repository.BuddySystemRepository;
import services.src.main.java.data.repository.ForumPostRepository;
import services.src.main.java.data.repository.ForumResponseRepository;
import services.src.main.java.data.repository.IndependentProjectRepository;
import services.src.main.java.data.repository.JobAdvertisementRepository;
import services.src.main.java.data.repository.MentoringForProjectsRepository;
import services.src.main.java.data.repository.RoomAssignmentRepository;
import services.src.main.java.data.repository.SystemLogRepository;
import services.src.main.java.data.repository.TutoringSessionRepository;
import services.src.main.java.data.repository.UserRepository;

@Service
public class CollaborationsList {

    @Autowired
    private AccountManagementRepository accountManagementRepository;

    @Autowired
    private AdminActionsRepository adminActionsRepository;

    @Autowired
    private BuddySystemRepository buddySystemRepository;

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

    public AccountManagement updateAccountManagement(Int ManagementID, AccountManagement updatedAccount) throws ResourceNotFoundException {
        AccountManagement existingAccount = accountManagementRepository.findById(ManagementID);
        if(existingAccount != null){
            if(updatedAccount.getActionType() != null)
                existingAccount.setActionType(updatedAccount.getActionType());
            if(updatedAccount.getTimeStamp() != null)
                existingAccount.setTimeStamp(updatedAccount.getTimeStamp());
                return accountManagementRepository.save(existingAccount);
            }
            throw new ResourceNotFoundException("Account not found with ID: " + ManagementID);
        }
    }

    public void deleteAccountManagement(Int ManagementID) throws Exception{
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

    public AdminActions updateAdminAction(Int ActionID,AdminActions adminAction) throws ResourceNotFoundException {
        AdminActions existingAction = adminActionsRepository.findById(ActionID).orElse(null);
        if(existingAction != null){
            if(adminAction.getActionType() != null)
                existingAction.setActionType(adminAction.getActionType());
            if(adminAction.getTimeStamp() != null)
                existingAction.setTimeStamp(adminAction.getTimeStamp());
                return adminActionsRepository.save(existingAction)
            }
            throw new ResourceNotFoundException("Action not found with ID: " + ActionID);
    }

    public void deleteAdminAction(Int ActionID) {
        if (adminActionsRepository.existsById(ActionID)) {
            adminActionsRepository.deleteById(ActionID);
        } else {
            throw new Exception("Admin action with ID: " + ActionID + " not found.");
        }
    }

    public void deleteForumPost(Int PostID) throws Exception{
        if(forumPostRepository.existsById(PostID)){
            forumPostRepository.deleteByPostId(PostID);
        } else
            throw new Exception("Post with id " + PostID + " not found.")
    }

    public ForumPost updateForumPost(Int PostID,ForumPost updatedPost) throws ResourceNotFoundException{
        ForumPost existingPost = forumPostRepository.findById(PostID)
        if(existingPost != null){
            if(updatedPost.getContent() != null)
                existingPost.setContent(updatedPost.getContent());
            if(updatedPost.getTopic() != null)
                existingPost.setTopic(updatedPost.getTopic());
            if(updatedPost.getCreationTime() != null)
                existingPost.setCreationTime(updatedPost.getCreationTime());
            return  forumPostRepository.save(existingPost);
        }
        throw new ResourceNotFoundException("Post not found with ID: " + PostID));
    }

    public BuddySystem createBuddySystem(BuddySystem buddySystem) throws Exception {
        if(buddySystem.getLanguages() != null) {
            if(buddySystemRepository.findByLanguages(buddySystem.getLanguages()) == null)
                return buddySystemRepository.save(buddySystem);
            throw new Exception("Buddy with " + buddySystem.getLanguages() + " language already available.")
        }
        throw new Exception("Invalid language");
    }

    public List<BuddySystem> getAllBuddySystems(String Languages) {
        List<BuddySystem> buddySystems = buddySystemRepository.findByLanguage(Languages);
        return buddySystems;
    }

    public ForumPost createForumPost(ForumPost forumPost) throws Exception {
        if(forumPost.getTopic() != null){
            if(forumPostRepository.findByTopic(forumPost.getTopic()) == null)
                return forumPostRepository.save(forumPost);
            throw new Exception("Post with " + forumPost.getTopic + " topic already available.");
        }
        throw new Exception("Invalid topic");
    }

    public ForumResponse createForumResponse(ForumResponse forumResponse) throws Exception{
        if(forumResponse.getResponseTime() != null){
            if(forumResponseRepository.findByResponseTime(forumResponse.getResponseTime()) == null)
                return forumResponseRepository.save(forumResponse);
            throw new Exception("Forum response with " + forumResponse.getResponseTime() + " response time already available.")
        }
        throw new Exception("Invalid response time");
    }  

    public IndependentProject createIndependentProject(IndependentProject independentProject) throw Exception {
        if(independentProject.getProjectName() != null){
            if(independentProjectRepository.findByProjectName(independenProject.getProjectName()) == null)
                return independentProjectRepository.save(independentProject);
            throw new Exception("Project with " + independentProject.getProjectName() + " project name already available.");
        }
        throw new Exception("Invalied project name");
    }

    public JobAdvertisement createJobAdvertisement(JobAdvertisement jobAdvertisement) throws Exception {
        if(jobAdvertisment.getTitle() != null){
            if(jobAdvertisementRepository.findByTitle(jobAdvertisment.getTitle()) == null)
                return jobAdvertisementRepository.save(jobAdvertisement);
            throw new Exception("Job advertisement with " + jobAdvertisement.getTitle() + " title already available.");
        }
        throw new Exception("Invalid title");
    } 

    public MentoringForProjects createMentoringForProjects(MentoringForProjects mentoringForProjects) throws Exception{
        if(mentoringForProjects.getSubject() != null){
            if(mentoringForProjectsRepository.findBySubject(mentoringForProjects.getSubject()) == null)
                return mentoringForProjectsRepository.save(mentoringForProjects);
            throw new Exception("Mentoring with " + mentoringForProjects.getSubjects() + " subject already available.");
        }
        throw new Exception("Invalid subject");
    }

    public List<MentoringForProjects> getAllMentoringForProjects() {
        List<MentoringForProjects> mentoringList = mentoringRepository.findAll();
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

    public List<SystemLog> getAllSystemLogs() {
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
        List<TutoringSession> tutoringSessions = tutoringSessionRepository.findByAll());
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

    public User updateUser(Int UserID,User updatedUser) throws ResourceNotFoundException{
        User existingUser = userRepository.findById(updatedUser.getId(UserID));
        if(existingUser != null){
            if(updatedUser.getUsername() != null)
                existingUser.setUsername(updatedUser.getUsername());
            if(updatedUser.getPassword() != null)
                existingUser.setPassword(updatedUser.getPassword());
            if(updatedUser.getRole() != null)
                existingUser.getRole(updatedUser.getRole());
            if(updatedUser.getEmail() != null)
                existingUser.setEmail(updatedUser.getEmail());
            if(updatedUser.getPhoneNumber() != null)
                existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepository.save(existingUser);    
        }
        throw new ResourceNotFoundException("User with id " + UserID " not available.");
    }
    
    public void deleteUser(Int UserID) throws Exception{
        if(userRepository.existsById(UserID)){
            userRepository.deleteById(UserID);
        }else{
            throw new Exception("User with id " + UserID + " does not exist.");
        }
    }
}