/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.reply.ofi.mb;


import it.reply.am.session.AmLoginFacadeLocal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author anto
 */

public class AmLoginMB {

@EJB 
AmLoginFacadeLocal amLoginFacade;

String username;
String password;

  

    /**
     * Creates a new instance of AmLoginMB
     */
    public AmLoginMB() {
    }
    
    public String getValue(){
    
    return "ok";
    }
    
     public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   public String getTestEJB(){

        return amLoginFacade.testEJB();

    }
   public String loginAction(){
   
    String  result  =  amLoginFacade.authenticate(getUsername(),getPassword() );
       
    if(!"".equals(result))
        return "success";        
    else 
        return "error";
   }
    
   
    
}
