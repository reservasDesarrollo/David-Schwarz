package xcale.controller;

import xcale.entity.User;
import xcale.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * Retorna todos los User.
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Retorna un User segun el ID
     * @param id
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<?> getOneUser(@RequestParam Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Crea User nuevo, hardcodea los campos dateAdd y hourAdd con la fecha y hora actual del sistema, encripta la password.
     * @param entity
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User entity){
        try {
            entity.setPassword(BCrypt.hashpw(entity.getPassword(),BCrypt.gensalt()));
            return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Modifica la entidad User
     * @param id
     * @param entity
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User entity){ // ver de mejorar esto
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

    /**
     * Desactiva el User
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> inactiveUser(@PathVariable int id){ // ver de mejorar esto
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userServiceImpl.inactive(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error: por favor intentelo mas tarde.\"}");
        }
    }

}
