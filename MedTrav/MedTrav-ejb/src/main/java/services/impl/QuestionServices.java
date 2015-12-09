package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Patient;
import entities.Question;
import entities.Testimony;
import services.interfaces.QuestionServicesLocal;
import services.interfaces.QuestionServicesRemote;

/**
 * Session Bean implementation class QuestionServices
 */
@Stateless
public class QuestionServices implements QuestionServicesRemote, QuestionServicesLocal {

	@PersistenceContext
	EntityManager entitymanager;
	
    /**
     * Default constructor. 
     */
    public QuestionServices() {
        // TODO Auto-generated constructor stub
    }

    

	@Override
	public Boolean addQuestion(Question question) {
		Boolean b = false;
		try {
			entitymanager.merge(question);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}


	@Override
	public Boolean updateQuestion(Question question) {
		Boolean b = false;
		try {
			entitymanager.merge(question);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}


	@Override
	public Boolean deleteQuestion(Question question) {
		Boolean b = false;
		try {
			Question testimonyFound=entitymanager.find(Question.class, question.getQuestionId());
			entitymanager.remove(testimonyFound);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
		
	}	
	


	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsByTitle(String title) {
		String jpql="select t from Question t where t.title LIKE :param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",  "%" + title + "%");
		return query.getResultList();
	
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsByPatientLastName(String name) {
		String jpql="select t from Question t where t.patient.lastName LIKE :param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",  "%" + name + "%");
		return query.getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsWithResponse() {
		//String chaine=null;
		String jpql="select t from Question t where t.response IS NOT NULL";
		Query query=entitymanager.createQuery(jpql);
		//query.setParameter("param",chaine);
		return query.getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsNoResponse() {
		//String chaine=null;
		String jpql="select t from Question t where t.response IS NULL";
		Query query=entitymanager.createQuery(jpql);
		//query.setParameter("param",chaine);
		return query.getResultList();
	
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsWithResponseAndPatient(String name) {
		//String chaine=null;
		String jpql="select t from Question t where t.response IS NOT NULL AND t.patient.lastName LIKE :param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",  "%" + name + "%");
		//query.setParameter("param",chaine);
		return query.getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsWithResponseAndTitle(String title) {
		//String chaine=null;
		String jpql="select t from Question t where t.response IS NOT NULL AND  t.title LIKE :param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",  "%" + title + "%");
		//query.setParameter("param",chaine);
		return query.getResultList();
	
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsNoResponseAndPatient(String name) {
		//String chaine=null;
		String jpql="select t from Question t where t.response IS NULL  AND t.patient.lastName LIKE :param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",  "%" + name + "%");
		//query.setParameter("param",chaine);
		return query.getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsNoResponseAndTitle(String title) {
		//String chaine=null;
		String jpql="select t from Question t where t.response IS NULL AND  t.title LIKE :param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",  "%" + title + "%");
		//query.setParameter("param",chaine);
		return query.getResultList();
	
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestionsByPatientId(Integer patientId) {
		String jpql="select t from Question t where t.patient.id =: param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param", patientId);
		return query.getResultList();
	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestions() {
		String jpql="select t from Question t ";
		Query query=entitymanager.createQuery(jpql);
		return query.getResultList();
	
	}

	@Override
	public Question findQuestionById(Integer idQuestion) {
		// TODO Auto-generated method stub
		return entitymanager.find(Question.class, idQuestion);
	}

	@Override
	public Patient findPatientById(Integer idPatient) {
		// TODO Auto-generated method stub
		return entitymanager.find(Patient.class, idPatient);
	}
	
	
    
}
