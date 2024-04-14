
    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;

    create table tb_department (
        active boolean,
        id bigserial not null,
        img_url varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_role (
        id bigserial not null,
        authority varchar(255),
        primary key (id)
    );

    create table tb_unidadesoft (
        id bigserial not null,
        address varchar(255),
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        phone1 varchar(255),
        phone2 varchar(255),
        uf varchar(255),
        primary key (id)
    );

    create table tb_user (
        active boolean,
        created timestamp(6) with time zone,
        department_id bigint,
        id bigserial not null,
        updated timestamp(6) with time zone,
        commercial_phone varchar(255),
        email varchar(255),
        full_name varchar(255),
        img_url varchar(255),
        mobile_phone varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table tb_user_role (
        role_id bigint not null,
        user_id bigint not null,
        primary key (role_id, user_id)
    );

    alter table if exists tb_user 
       add constraint FKk05pfkuxp9jsie8074d304v7m 
       foreign key (department_id) 
       references tb_department;

    alter table if exists tb_user_role 
       add constraint FKea2ootw6b6bb0xt3ptl28bymv 
       foreign key (role_id) 
       references tb_role;

    alter table if exists tb_user_role 
       add constraint FK7vn3h53d0tqdimm8cp45gc0kl 
       foreign key (user_id) 
       references tb_user;
