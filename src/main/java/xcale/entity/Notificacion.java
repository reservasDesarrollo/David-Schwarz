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
@Table(name = "MOTIFICACIONES")
public class Notificacion implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_NOTIFICACION")
        private int idnotificación;

        @ManyToOne
        @JoinColumn(name = "ID_MENSAJE", nullable = false)
        private Mensaje mensaje;

        @ManyToOne
        @JoinColumn(name = "ID_PARTICIPANTE", nullable = false)
        private Participante participante;

}
