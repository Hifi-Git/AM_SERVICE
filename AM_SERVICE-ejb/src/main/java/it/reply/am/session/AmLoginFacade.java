/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.reply.am.session;

import it.reply.am.AmLogin;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author anto
 */


@Stateless (name = "amLoginFacade ",mappedName = "amLoginFacade")
@Local(AmLoginFacadeLocal.class)
public class AmLoginFacade extends AbstractFacade<AmLogin> implements AmLoginFacadeLocal {
    @PersistenceContext(unitName = "dal_stg_AM_SERVICE")
    private EntityManager em;
    
    Logger log = Logger.getLogger(this.getClass());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AmLoginFacade() {
        super(AmLogin.class);
    }

    public String authenticate(String username , String password) {
        
       Query query =  em.createNamedQuery("AmLogin.authenticate");
       query.setParameter(username, em);
       query.setParameter(password, em);
       String resultName = null;
       try {
         resultName=   query.getSingleResult().toString();
                  
       }catch(NoResultException nRex) {
          log.debug(nRex); 
          return null ;
       }catch(NonUniqueResultException nURex) {
          log.debug(nURex);
          return null;
       }
        return  resultName;
    }
    
    
    public String testEJB (){
    
    return this.getClass().getName();
    }
    
}
