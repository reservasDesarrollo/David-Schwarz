package xcale.controller;

import xcale.entity.Grupo;
import xcale.entity.Mensaje;
import xcale.entity.Notificacion;
import xcale.entity.Participante;
import xcale.service.GrupoServiceImpl;
import xcale.service.MensajeServiceImpl;
import xcale.service.NotificacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/Mensaje")
public class MensajeController {

    @Autowired
    MensajeServiceImpl MensajeService;

    @Autowired
    NotificacionServiceImpl NotificacionService;


    @Autowired
    GrupoServiceImpl GrupoService;

    /**
     * Retorna todos los Mensaje.
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> getAllMensaje(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(MensajeService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Retorna un Mensaje segun el ID
     * @param id
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<?> getOneMensaje(@RequestParam Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(MensajeService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Crea Mensaje nuevo, hardcodea los campos dateAdd y hourAdd con la fecha y hora actual del sistema, encripta la password.
     * @param mensaje
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createMensaje(@RequestBody Mensaje mensaje){
        try {

            mensaje= MensajeService.save(mensaje);

             Grupo grupo  =   GrupoService.findById(mensaje.getGrupo().getIdGrupo());

            Collection<Participante> participantes = grupo.getParticipantes();

            for (Participante participanteTmp : participantes ) {

                Notificacion notificacion = new Notificacion();
                notificacion.setMensaje(mensaje);
                notificacion.setParticipante(participanteTmp);

                NotificacionService.save(notificacion);
            }

            return ResponseEntity.status(HttpStatus.OK).body(mensaje);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Modifica la entidad Mensaje
     * @param id
     * @param entity
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMensaje(@PathVariable int id, @RequestBody Mensaje entity){ // ver de mejorar esto
        try {
            return ResponseEntity.status(HttpStatus.OK).body(MensajeService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Desactiva el Mensaje
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> inactiveMensaje(@PathVariable int id){ // ver de mejorar esto
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MensajeService.inactive(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

}
