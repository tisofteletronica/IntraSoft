package com.softeletronica.intrasoft.dto;


import com.softeletronica.intrasoft.services.validation.UserUpdateValid;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO {

    private String password;

    public UserUpdateDTO(){

    }

    public UserUpdateDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
