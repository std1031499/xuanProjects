package com.xuan.bs.entities;



/**
 * RoleMenu entity. @author MyEclipse Persistence Tools
 */

public class RoleMenu  implements java.io.Serializable {


    // Fields    

     private RoleMenuId id;
     private Integer roleMenuId;
     private Integer permiss;
     private String roleMenuNote;


    // Constructors

    /** default constructor */
    public RoleMenu() {
    }

	/** minimal constructor */
    public RoleMenu(RoleMenuId id, Integer roleMenuId, Integer permiss) {
        this.id = id;
        this.roleMenuId = roleMenuId;
        this.permiss = permiss;
    }
    
    /** full constructor */
    public RoleMenu(RoleMenuId id, Integer roleMenuId, Integer permiss, String roleMenuNote) {
        this.id = id;
        this.roleMenuId = roleMenuId;
        this.permiss = permiss;
        this.roleMenuNote = roleMenuNote;
    }

   
    // Property accessors

    public RoleMenuId getId() {
        return this.id;
    }
    
    public void setId(RoleMenuId id) {
        this.id = id;
    }

    public Integer getRoleMenuId() {
        return this.roleMenuId;
    }
    
    public void setRoleMenuId(Integer roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public Integer getPermiss() {
        return this.permiss;
    }
    
    public void setPermiss(Integer permiss) {
        this.permiss = permiss;
    }

    public String getRoleMenuNote() {
        return this.roleMenuNote;
    }
    
    public void setRoleMenuNote(String roleMenuNote) {
        this.roleMenuNote = roleMenuNote;
    }
   








}