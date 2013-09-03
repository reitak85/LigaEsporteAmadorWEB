package br.com.ligaesporteamador.bd;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;


public abstract class DataAccessService<T> {

    private EntityManager em;
	
    private Class<T> type;

    public DataAccessService() {
    	setEntityManager();
    }

    public DataAccessService(Class<T> type) {
        this.type = type;
    }
    

	public void setEntityManager() {
		try {
			em = Persistence.createEntityManagerFactory("ligaesporteamador").createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
    public T create(T t) {
		this.em.getTransaction().begin();
    	this.em.merge(t);
        this.em.flush();
        this.em.getTransaction().commit();
        this.em.refresh(t);
        return t;
    }

    public T find(Object id) {
        return this.em.find(this.type, id);
    }


    public void delete(Object id) {
        Object ref = this.em.getReference(this.type, id);
        this.em.remove(ref);
    }

    
    public T update(T item) {
        return (T) this.em.merge(item);
    }
    
    @SuppressWarnings("unchecked")
	public List<T> createQuery(String query){
    	
    	List<T> valores = new ArrayList<T>();
    	Query q = this.em.createQuery(query);
    	valores =  q.getResultList();
    	
    	return valores;
    }
    
    @SuppressWarnings("unchecked")
	public List<T> createQueryById(String query, Map<String, Object> params){
    	
    	List<T> valores = new ArrayList<T>();
    	Query q = this.em.createQuery(query);
    	
    	for (Map.Entry<String, Object> entry : params.entrySet()) {
			q.setParameter(entry.getKey(), Long.valueOf(entry.getValue().toString()));
		}
    	
    	valores =  q.getResultList();
    	
    	return valores;
    }
    
    @SuppressWarnings("unchecked")
	public T createQueryUniqueResult(String query, Map<String, Object> params){
    	
		Query q = this.em.createQuery(query);

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			q.setParameter(entry.getKey(), entry.getValue().toString());
		}

		List<T> tList = (List<T>) q.getResultList();

		for (T t : tList) {
			
			return t;
		}
		
		return null;
    }
   
}