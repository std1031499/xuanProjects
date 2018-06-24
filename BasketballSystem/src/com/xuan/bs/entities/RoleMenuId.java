package com.xuan.bs.entities;



/**
 * RoleMenuId entity. @author MyEclipse Persistence Tools
 */

public class RoleMenuId  implements java.io.Serializable {


    // Fields    

     private Role role;
     private Menu menu;


    // Constructors

    /** default constructor */
    public RoleMenuId() {
    }

    
    /** full constructor */
    public RoleMenuId(Role role, Menu menu) {
        this.role = role;
        this.menu = menu;
    }

   
    // Property accessors

    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return this.menu;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RoleMenuId) ) return false;
		 RoleMenuId castOther = ( RoleMenuId ) other; 
         
		 return ( (this.getRole()==castOther.getRole()) || ( this.getRole()!=null && castOther.getRole()!=null && this.getRole().equals(castOther.getRole()) ) )
 && ( (this.getMenu()==castOther.getMenu()) || ( this.getMenu()!=null && castOther.getMenu()!=null && this.getMenu().equals(castOther.getMenu()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRole() == null ? 0 : this.getRole().hashCode() );
         result = 37 * result + ( getMenu() == null ? 0 : this.getMenu().hashCode() );
         return result;
   }   





}