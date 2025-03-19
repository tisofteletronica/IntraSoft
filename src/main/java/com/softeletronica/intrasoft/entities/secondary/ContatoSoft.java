package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;


import java.time.Instant;
import java.util.Objects;



    @Entity
    @Table(name = "tb_contato_soft")
    public class ContatoSoft {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
        private String setor;
        private String whatsapp;
        private String phone1;
        private String phone2;
        private String phone3;
        @Column(name = "create_at") // Mapeia para a coluna "create_at" no banco de dados
        private Instant createAt;
        @Column(name = "update_at") // Mapear também outras colunas caso necessário
        private Instant updateAt;
        private String email;
        private Boolean active;

        public ContatoSoft(){

        }

        public ContatoSoft(Long id, String setor, String whatsapp, String phone1, String phone2,
                           Instant createAt, Instant updateAt, String phone3, String email, Boolean active) {
            Id = id;
            this.setor = setor;
            this.whatsapp = whatsapp;
            this.phone1 = phone1;
            this.phone2 = phone2;
            this.phone3 = phone3;
            this.createAt = createAt;
            this.updateAt = updateAt;
            this.email = email;
            this.active = active;
        }

        public Long getId() {
            return Id;
        }

        public void setId(Long id) {
            Id = id;
        }

        public String getSetor() {
            return setor;
        }

        public void setSetor(String setor) {
            this.setor = setor;
        }

        public String getWhatsapp() {
            return whatsapp;
        }

        public void setWhatsapp(String whatsapp) {
            this.whatsapp = whatsapp;
        }

        public String getPhone1() {
            return phone1;
        }

        public void setPhone1(String phone1) {
            this.phone1 = phone1;
        }

        public String getPhone2() {
            return phone2;
        }

        public void setPhone2(String phone2) {
            this.phone2 = phone2;
        }

        public String getPhone3() {
            return phone3;
        }

        public void setPhone3(String phone3) {
            this.phone3 = phone3;
        }

        public Instant getCreateAt() {
            return createAt;
        }

        public void setCreateAt(Instant createAt) {
            this.createAt = createAt;
        }

        public Instant getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(Instant updateAt) {
            this.updateAt = updateAt;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ContatoSoft that = (ContatoSoft) o;
            return Objects.equals(Id, that.Id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Id);
        }
}
