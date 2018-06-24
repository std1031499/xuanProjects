package com.xuan.bs.entities;



/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole  implements java.io.Serializable {


    // Fields    

     private UserRoleId id;
     private Integer userRoleId;


    // Constructors

    /** default constructor */
    public UserRole() {
    }

    
    /** full constructor */
    public UserRole(UserRoleId id, Integer userRoleId) {
        this.id = id;
        this.userRoleId = userRoleId;
    }

   
    // Property accessors

    public UserRoleId getId() {
        return this.id;
    }
    
    public void setId(UserRoleId id) {
        this.id = id;
    }

    public Integer getUserRoleId() {
        return this.userRoleId;
    }
    
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }


	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userRoleId=" + userRoleId + "]";
	}
   
    







}