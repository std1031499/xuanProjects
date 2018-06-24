package com.xuan.bs.entities;

import java.util.HashSet;
import java.util.Set;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable {


    // Fields    

     private Integer roleId;
     private String roleName;
     private String roleNote;
     private Set roleMenus = new HashSet(0);
     private Set userRoles = new HashSet(0);


    // Constructors

    /** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(String roleName) {
        this.roleName = roleName;
    }
    
    /** full constructor */
    public Role(String roleName, String roleNote, Set roleMenus, Set userRoles) {
        this.roleName = roleName;
        this.roleNote = roleNote;
        this.roleMenus = roleMenus;
        this.userRoles = userRoles;
    }

   
    // Property accessors

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNote() {
        return this.roleNote;
    }
    
    public void setRoleNote(String roleNote) {
        this.roleNote = roleNote;
    }

    public Set getRoleMenus() {
        return this.roleMenus;
    }
    
    public void setRoleMenus(Set roleMenus) {
        this.roleMenus = roleMenus;
    }

    public Set getUserRoles() {
        return this.userRoles;
    }
    
    public void setUserRoles(Set userRoles) {
        this.userRoles = userRoles;
    }
   








}