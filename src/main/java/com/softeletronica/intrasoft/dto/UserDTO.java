package com.softeletronica.intrasoft.dto;

import com.softeletronica.intrasoft.entities.User;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String commercialPhone;
    private String mobilePhone;
    private Instant created;
    private Instant updated;
    private String imgUrl;
    private Boolean active;
    private Long departmentId;
    private String departmentName;

    private String departmentImg;
    Set<RoleDTO> roles = new HashSet<>();
    public UserDTO() {
    }

    public UserDTO(Long id, String fullName, String email, String commercialPhone, String mobilePhone, Instant created,
                   Instant updated, String imgUrl, Boolean active, Long departmentId, String departmentName, String departmentImg) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.commercialPhone = commercialPhone;
        this.mobilePhone = mobilePhone;
        this.created = created;
        this.updated = updated;
        this.imgUrl = imgUrl;
        this.active = active;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentImg = departmentImg;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        fullName = entity.getFullName();
        email = entity.getEmail();
        commercialPhone = entity.getCommercialPhone();
        mobilePhone = entity.getMobilePhone();
        created = entity.getCreated();
        updated = entity.getUpdated();
        imgUrl = entity.getImgUrl();
        active = entity.getActive();
        departmentId = (entity.getDepartment() != null) ? entity.getDepartment().getId() : null;
        departmentName = (entity.getDepartment() != null) ? entity.getDepartment().getName() : null;
        departmentImg = (entity.getDepartment() != null) ? entity.getDepartment().getImgUrl() : null;
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getCommercialPhone() {
        return commercialPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public Boolean getActive() {
        return active;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentImg() {
        return departmentImg;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }
}
