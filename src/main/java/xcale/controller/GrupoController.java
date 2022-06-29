package xcale.controller;

import xcale.entity.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Grupo")
public class GrupoController {

    @Autowired
    xcale.service.GrupoServiceImpl GrupoServiceImpl;

    /**
     * Retorna todos los Grupo.
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> getAllGrupo(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(GrupoServiceImpl.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Retorna un Grupo segun el ID
     * @param id
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<?> getOneGrupo(@RequestParam Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(GrupoServiceImpl.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Crea Grupo nuevo, hardcodea los campos dateAdd y hourAdd con la fecha y hora actual del sistema, encripta la password.
     * @param grupo
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createGrupo(@RequestBody Grupo grupo ){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(GrupoServiceImpl.save(grupo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Modifica la entidad Grupo
     * @param id
     * @param entity
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGrupo(@PathVariable int id, @RequestBody Grupo entity){ // ver de mejorar esto
        try {
            return ResponseEntity.status(HttpStatus.OK).body(GrupoServiceImpl.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Desactiva el Grupo
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> inactiveGrupo(@PathVariable int id){ // ver de mejorar esto
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(GrupoServiceImpl.inactive(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

}
