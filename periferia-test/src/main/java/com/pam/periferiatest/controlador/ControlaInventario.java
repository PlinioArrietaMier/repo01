package com.pam.periferiatest.controlador;

/**
 *
 * @author plinio
 */
import com.pam.periferiatest.modelo.Activo;
import com.pam.periferiatest.modelo.Parametro;
import com.pam.periferiatest.servicio.ServicioInventario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping( "/inventario" )
public class ControlaInventario {
    @Autowired
    private ServicioInventario servicioInventario;
    

    @GetMapping("/consultaActivo/{numeroSerial}")
    public ResponseEntity<Activo> consultaActivo( @PathVariable Long numeroSerial ){
        try{    
            Optional<Activo> datosActivo = servicioInventario.consultaActivo(numeroSerial);            
            if( datosActivo.isPresent() ){
                return new ResponseEntity<>( datosActivo.get(), HttpStatus.OK );
            }            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND );                    
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
       
    @PostMapping("/registraActivo")
    public ResponseEntity<Activo> registraActivo( @RequestBody Activo activo ){
        try{    
            Activo nuevoActivo = servicioInventario.registraActivo(activo);            
            return new ResponseEntity<>( nuevoActivo,HttpStatus.OK );
                    
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }       


    @DeleteMapping("/darDeBajaActivo/{numeroSerial}")
    public ResponseEntity<HttpStatus> darDeBajaActivo( @PathVariable Long numeroSerial ){
        try{    
            if( servicioInventario.darDeBaja(numeroSerial) ){
                return new ResponseEntity<>(HttpStatus.OK );
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND );
                }                    
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }       

    @PostMapping("/actualizaDepreciacionActivo/{numeroSerial}")
    public ResponseEntity<Activo> actualizaDepreciacionActivo( @PathVariable Long numeroSerial ){
        try{    
            if( servicioInventario.actualizaDepreciacionActivo(numeroSerial) ){                
                return new ResponseEntity<>(servicioInventario.consultaActivo(numeroSerial).get(), HttpStatus.OK );
            }else{
                return new ResponseEntity<>( servicioInventario.consultaActivo(numeroSerial).get(), HttpStatus.NOT_FOUND );
            }        
        } catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }       
}
