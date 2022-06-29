package xcale.controller;

import xcale.entity.Participante;
import xcale.service.ParticipanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Participante")
public class ParticipanteController {

    @Autowired
    ParticipanteServiceImpl ParticipanteServiceImpl;

    /**
     * Retorna todos los Participante.
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> getAllParticipante(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ParticipanteServiceImpl.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Retorna un Participante segun el ID
     * @param id
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<?> getOneParticipante(@RequestParam Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ParticipanteServiceImpl.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Crea Participante nuevo, hardcodea los campos dateAdd y hourAdd con la fecha y hora actual del sistema, encripta la password.
     * @param entity
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createParticipante(@RequestBody Participante entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ParticipanteServiceImpl.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Modifica la entidad Participante
     * @param id
     * @param entity
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateParticipante(@PathVariable int id, @RequestBody Participante entity){ // ver de mejorar esto
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ParticipanteServiceImpl.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Desactiva el Participante
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> inactiveParticipante(@PathVariable int id){ // ver de mejorar esto
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ParticipanteServiceImpl.inactive(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

}
