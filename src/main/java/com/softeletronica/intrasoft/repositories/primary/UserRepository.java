package com.softeletronica.intrasoft.repositories.primary;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.entities.primary.User;
import com.softeletronica.intrasoft.projections.UserDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = """
            	SELECT tb_user.email AS username, tb_user.password, tb_role.id AS roleId, tb_role.authority
            	FROM tb_user
            	INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id
            	INNER JOIN tb_role ON tb_role.id = tb_user_role.role_id
            	WHERE tb_user.email = :email and active = true
            """)
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

    @Query(nativeQuery = true, value = """
                SELECT 
                    u.id,
                    u.full_name,
                    u.email,
                    u.email_alternativo,
                    u.department_id,
                    u.password,
                    u.commercial_phone,
                    u.mobile_phone,
                    u.img_url,
                    u.active,
                    u.created,
                    u.updated,
                    json_agg(json_build_object('id', r.id, 'authority', r.authority)) AS roles
                FROM 
                    tb_user u
                LEFT JOIN 
                    tb_user_role ur ON u.id = ur.user_id
                LEFT JOIN 
                    tb_role r ON ur.role_id = r.id
                WHERE 
                    (:email IS NULL OR :email = '' OR u.email = :email)
                    
                GROUP BY 
                    u.id, u.full_name, u.email, u.email_alternativo, u.department_id, u.password,
                    u.commercial_phone, u.mobile_phone, u.img_url, u.active, u.created, u.updated
                ORDER BY
                     u.full_name ASC
            """)


    Page<User> searchByEmail(String email, Pageable pageable);

    @Query(nativeQuery = true, value = """
        SELECT 
            u.id,
            u.full_name,
            u.email,
            u.email_alternativo,
            u.department_id,
            u.password,
            u.commercial_phone,
            u.mobile_phone,
            u.img_url,
            u.active,
            u.created,
            u.updated,
            json_agg(json_build_object('id', r.id, 'authority', r.authority)) AS roles
        FROM 
            tb_user u
        LEFT JOIN 
            tb_user_role ur ON u.id = ur.user_id
        LEFT JOIN 
            tb_role r ON ur.role_id = r.id
        WHERE 
            (:email IS NULL OR :email = '' OR u.email = :email)
            AND (:active IS NULL OR u.active = :active)
        GROUP BY 
            u.id, u.full_name, u.email, u.email_alternativo, u.department_id, u.password,
            u.commercial_phone, u.mobile_phone, u.img_url, u.active, u.created, u.updated
        ORDER BY
            u.full_name ASC
    """)
    Page<User> searchByEmailAndActive(
            @Param("email") String email,
            @Param("active") Boolean active,
            Pageable pageable);

    Optional<User> findByEmail(String email);
}
