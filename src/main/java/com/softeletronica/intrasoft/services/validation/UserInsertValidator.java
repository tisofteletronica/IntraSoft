package com.softeletronica.intrasoft.services.validation;


import com.softeletronica.intrasoft.controllers.handlers.FieldMessage;
import com.softeletronica.intrasoft.entities.User;
import com.softeletronica.intrasoft.repositories.UserRepository;
import com.softeletronica.intrasoft.dto.UserInsertDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserInsertValid ann) {
    }

    @Override
    public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à
        // lista

        Optional<User> user = repository.findByEmail(dto.getEmail());
        if (user != null) {
            list.add(new FieldMessage("email", "Este email já existe"));
        }


        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
