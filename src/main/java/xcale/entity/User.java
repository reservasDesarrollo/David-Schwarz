package xcale.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_USUARIOS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TU_USER_ID")
    private int userId;

    @Column(name = "TU_APELLIDO")
    private String lastName;

    @Column(name = "TU_NOMBRE")
    private String name;

    @Column(name = "TU_MAIL")
    private String mail;

    @Column(name = "TU_CELULAR")
    private int cellPhone;

    @Column(name = "TU_LOGIN")
    private String login;

    @Column(name = "TU_PASSWORD")
    private String password;

    @Column(name = "TU_LEGAJO")
    private int legajo;


}
