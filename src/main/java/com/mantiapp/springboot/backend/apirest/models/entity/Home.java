package com.mantiapp.springboot.backend.apirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="homes")
public class Home implements Serializable {

    /*
    * Tipo de vivienda
    * Tipo de via
    * Localización
    * habitaciones
    * baños
    * cocinas
    * salon
    * jardin
    * patio
    * garage
    * trastero
    * Alquiler, compra ...
    * Tipo de propietario
    * Construida o en plano
    * */

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String apellido;
        private String email;

        @Column(name="create_at")
        @Temporal(TemporalType.DATE)
        private Date createAt;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Date getCreateAt() {
            return createAt;
        }

        public void setCreateAt(Date createAt) {
            this.createAt = createAt;
        }

        private static final long serialVersionUID = 1L;
    }
}
