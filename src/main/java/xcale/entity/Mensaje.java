package xcale.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MENSAJE")
public class Mensaje implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_MENSAJE")
        private int idMensaje;

        @Column(name = "MENSAJE")
        private String  mensaje;

        //participante que envio el mensaje
        @ManyToOne
        @JoinColumn(name = "ID_PARTICIPANTE", nullable = false)
        private Participante  participante;

        @ManyToOne
        @JoinColumn(name = "ID_GRUPO", nullable = false)
        private Grupo  grupo;

}
