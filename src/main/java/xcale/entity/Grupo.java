package xcale.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GRUPO")
public class Grupo implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_GRUPO")
        private int idGrupo;

        @Column(name = "NOMBRE")
        private String nombre;

        @ManyToMany
        @JoinTable(name = "grupo_participante", joinColumns = @JoinColumn(name = "ID_GRUPO"), inverseJoinColumns = @JoinColumn(name = "ID_PARTICIPANTE"))
        Collection<Participante> participantes;


        @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
       private  Collection<Mensaje> mensajes;




}
