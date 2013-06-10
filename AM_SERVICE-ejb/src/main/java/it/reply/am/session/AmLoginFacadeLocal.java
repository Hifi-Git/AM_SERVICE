/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.reply.am.session;

import it.reply.am.AmLogin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anto
 */
@Local
public interface AmLoginFacadeLocal {

    void create(AmLogin amLogin);

    void edit(AmLogin amLogin);

    void remove(AmLogin amLogin);

    AmLogin find(Object id);

    List<AmLogin> findAll();

    List<AmLogin> findRange(int[] range);

    int count();
    
}
