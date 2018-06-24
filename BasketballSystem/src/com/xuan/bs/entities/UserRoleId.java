package com.xuan.bs.entities;



/**
 * UserRoleId entity. @author MyEclipse Persistence Tools
 */

public class UserRoleId  implements java.io.Serializable {


    // Fields    

     private Users users;
     private Role role;


    // Constructors

    /** default constructor */
    public UserRoleId() {
    }

    
    /** full constructor */
    public UserRoleId(Users users, Role role) {
        this.users = users;
        this.role = role;
    }

   
    // Property accessors

    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }

    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserRoleId) ) return false;
		 UserRoleId castOther = ( UserRoleId ) other; 
         
		 return ( (this.getUsers()==castOther.getUsers()) || ( this.getUsers()!=null && castOther.getUsers()!=null && this.getUsers().equals(castOther.getUsers()) ) )
 && ( (this.getRole()==castOther.getRole()) || ( this.getRole()!=null && castOther.getRole()!=null && this.getRole().equals(castOther.getRole()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUsers() == null ? 0 : this.getUsers().hashCode() );
         result = 37 * result + ( getRole() == null ? 0 : this.getRole().hashCode() );
         return result;
   }   





}