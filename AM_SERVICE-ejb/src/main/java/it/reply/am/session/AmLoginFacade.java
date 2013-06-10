/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.reply.am.session;

import it.reply.am.AmLogin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anto
 */
@Stateless
public class AmLoginFacade extends AbstractFacade<AmLogin> implements AmLoginFacadeLocal {
    @PersistenceContext(unitName = "dal_stg_AM_SERVICE")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AmLoginFacade() {
        super(AmLogin.class);
    }
    
}
