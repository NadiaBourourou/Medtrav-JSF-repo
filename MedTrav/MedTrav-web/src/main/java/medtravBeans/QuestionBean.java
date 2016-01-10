package medtravBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import services.interfaces.QuestionServicesLocal;
import entities.Question;
import entities.Testimony;
import entities.User;




@ManagedBean
@SessionScoped
public class QuestionBean {

	// models
		private Question question = new Question();
		private List<Question> questions;
		
		private boolean display = false;
		private String titleSearch;
		
		// injection of the proxy
		@EJB
		private QuestionServicesLocal questionServicesLocal;
		
		
		@ManagedProperty(value = "#{loginBean.found}")
		private User user;
		
		@PostConstruct
		public void init() {
			question=new Question();
			questions = questionServicesLocal.findAllQuestions();
			setDisplay(false);

		}
		public void onRowSelect(SelectEvent event) {
			setDisplay(true);
		}
		
		
		// methods
		public String doAddResponse() {
			questionServicesLocal.updateQuestion(question);
			display=false;
			question= new Question();
			return "/admin/Reponse/listQuestion";
		}
		
		public String doAddQuestion() {
			question.setDate(new Date());
			System.out.println("user id ="+user.getUserId()+" son nom="+user.getLogin());
			question.setPatient(questionServicesLocal.findPatientById(user.getUserId()));
			questionServicesLocal.addQuestion(question);
			questions=questionServicesLocal.findAllQuestions();
			return "/patient/Question/listQuestion";
		}

		public String doDeleteQuestion() {
			questionServicesLocal.deleteQuestion(question);
			questions=questionServicesLocal.findAllQuestions();
			display = false;
			
			question= new Question();
			return "";
		}

		public String doUpdateQuestion() {
			questionServicesLocal.updateQuestion(question);
			questions=questionServicesLocal.findAllQuestions();
			display = false;
			question= new Question();
			return "";
		}
		
	public String doFindQuestionByTitle(){
			
			questions = questionServicesLocal.findAllQuestionsByTitle(getTitleSearch());
			
			System.out.println("tableau contient ======"+questions.size());
			
			return "listQuestion";
			
		}
		

	

		public Question getQuestion() {
			if(question == null){
				question = new Question();
				}
			return question;
		}

		public void setQuestion(Question question) {
			this.question = question;
		}

		public List<Question> getQuestions() {
			//questions = questionServicesLocal.findAllQuestions();
			return questions;
		}

		public void setQuestions(List<Question> questions) {
			this.questions = questions;
		}

		

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public boolean isDisplay() {
			return display;
		}

		public void setDisplay(boolean display) {
			this.display = display;
		}

		public String getTitleSearch() {
			return titleSearch;
		}

		public void setTitleSearch(String titleSearch) {
			this.titleSearch = titleSearch;
		}
		
		
	
		

	

		
}
