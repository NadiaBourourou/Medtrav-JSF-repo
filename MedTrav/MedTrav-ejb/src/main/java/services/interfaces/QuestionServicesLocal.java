package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Patient;
import entities.Question;

@Local
public interface QuestionServicesLocal {



	Boolean addQuestion(Question question);

	Boolean updateQuestion(Question question);

	Boolean deleteQuestion(Question question);

	List<Question> findAllQuestions();

	Question findQuestionById(Integer idQuestion);

	Patient findPatientById(Integer idPatient);

	List<Question> findAllQuestionsByPatientId(Integer patientId);

	List<Question> findAllQuestionsByTitle(String title);

	List<Question> findAllQuestionsByPatientLastName(String name);

	List<Question> findAllQuestionsWithResponse();
	
}
