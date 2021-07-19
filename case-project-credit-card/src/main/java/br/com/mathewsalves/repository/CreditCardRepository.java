package br.com.mathewsalves.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.mathewsalves.entity.CreditCard;

@Repository
@Transactional
public class CreditCardRepository implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
    private EntityManager manager;

    public CreditCard create(CreditCard creditCard) {
        manager.persist(creditCard);
        
        return creditCard;
    }

    public void deleteById(int id) {
    	CreditCard creditCard = findById(id);
        manager.remove(creditCard);
    }
    
    public CreditCard update(CreditCard creditCard){
        manager.merge(creditCard);
        return creditCard;
    }
    
    public List<CreditCard> findAll() {
        return manager.createQuery("Select c from CreditCard c", CreditCard.class).getResultList();
    }
    
    public CreditCard findById(int id) {
        return manager.find(CreditCard.class, id);
    }
    
    public List<CreditCard> findByCandidateId(int candidateId) {
        Query query = manager.createQuery("Select c from CreditCard c where c.candidateId = :candidateId");
        query.setParameter("candidateId", candidateId);
        
        return query.getResultList();
    }

}
