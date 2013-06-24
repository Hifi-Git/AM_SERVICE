/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.reply.am;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anto
 */
@Entity
@Table(name = "AM_LOGIN")
@XmlRootElement
@NamedQueries({
    //@NamedQuery(name = "AmLogin.findAll", query = "SELECT a FROM AmLogin a"),
    //@NamedQuery(name = "AmLogin.findById", query = "SELECT a FROM AmLogin a WHERE a.id = :id"),
    //@NamedQuery(name = "AmLogin.findByUserName", query = "SELECT a FROM AmLogin a WHERE a.userName = :userName"),
    @NamedQuery(name = "AmLogin.authenticate", query = "SELECT a FROM AmLogin a WHERE a.password = :password and a.userName = :userName")})
public class AmLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;

    public AmLogin() {
    }

    public AmLogin(BigDecimal id) {
        this.id = id;
    }

    public AmLogin(BigDecimal id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmLogin)) {
            return false;
        }
        AmLogin other = (AmLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.reply.am.AmLogin[ id=" + id + " ]";
    }
    
}
