package com.softeletronica.intrasoft.services;


import com.softeletronica.intrasoft.dto.RoleDTO;
import com.softeletronica.intrasoft.dto.UserDTO;
import com.softeletronica.intrasoft.dto.UserInsertDTO;
import com.softeletronica.intrasoft.dto.UserUpdateDTO;
import com.softeletronica.intrasoft.entities.Department;
import com.softeletronica.intrasoft.entities.Role;
import com.softeletronica.intrasoft.entities.User;
import com.softeletronica.intrasoft.projections.UserDetailsProjection;
import com.softeletronica.intrasoft.repositories.DepartmentRepository;
import com.softeletronica.intrasoft.repositories.RoleRepository;
import com.softeletronica.intrasoft.repositories.UserRepository;
import com.softeletronica.intrasoft.services.exceptions.DatabaseException;
import com.softeletronica.intrasoft.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if (result.size() == 0) {
            throw new UsernameNotFoundException("Email not found");
        }

        User user = new User();
        user.setEmail(result.get(0).getUsername());
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection projection : result) {
            user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return user;
    }

    public User authenticated() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
            return repository.findByEmail(username).get();
        } catch (Exception e) {
            throw new UsernameNotFoundException("Invalid user");
        }
    }

    @Transactional(readOnly = true)
    public UserDTO getMe() {
        User entity = authenticated();
        return new UserDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        return list.map(x -> new UserDTO(x));
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insert(UserInsertDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO update(Long id, UserUpdateDTO dto) {
        try {
            User entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
            entity = repository.save(entity);
            return new UserDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setCreated(dto.getCreated());
        entity.setUpdated(dto.getUpdated());
        entity.setCommercialPhone(dto.getCommercialPhone());
        entity.setMobilePhone(dto.getMobilePhone());
        entity.setActive(dto.getActive());
        entity.setImgUrl(dto.getImgUrl());

        if (dto.getDepartmentId() != null) {
            Department depto = departmentRepository.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + dto.getDepartmentId()));
            entity.setDepartment(depto);
        }

        entity.setActive(dto.getActive());

        entity.getRoles().clear();
        for (RoleDTO roleDTO : dto.getRoles()) {
            Role role = roleRepository.findById(roleDTO.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + roleDTO.getId()));
            entity.getRoles().add(role);
        }
    }

}





