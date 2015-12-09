package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Patient;
import entities.Question;

@Remote
public interface QuestionServicesRemote {

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

	List<Question> findAllQuestionsWithResponseAndPatient(String name);

	List<Question> findAllQuestionsWithResponseAndTitle(String title);

	List<Question> findAllQuestionsNoResponseAndTitle(String title);

	List<Question> findAllQuestionsNoResponseAndPatient(String name);

	List<Question> findAllQuestionsNoResponse();

}
