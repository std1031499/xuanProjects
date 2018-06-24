package com.xuan.bs.entities;

import java.util.HashSet;
import java.util.Set;


/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu  implements java.io.Serializable {


    // Fields    

     private Integer menuId;
     private String menuName;
     private String menuNote;
     private Set roleMenus = new HashSet(0);


    // Constructors

    /** default constructor */
    public Menu() {
    }

	/** minimal constructor */
    public Menu(String menuName) {
        this.menuName = menuName;
    }
    
    /** full constructor */
    public Menu(String menuName, String menuNote, Set roleMenus) {
        this.menuName = menuName;
        this.menuNote = menuNote;
        this.roleMenus = roleMenus;
    }

   
    // Property accessors

    public Integer getMenuId() {
        return this.menuId;
    }
    
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return this.menuName;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuNote() {
        return this.menuNote;
    }
    
    public void setMenuNote(String menuNote) {
        this.menuNote = menuNote;
    }

    public Set getRoleMenus() {
        return this.roleMenus;
    }
    
    public void setRoleMenus(Set roleMenus) {
        this.roleMenus = roleMenus;
    }
   








}