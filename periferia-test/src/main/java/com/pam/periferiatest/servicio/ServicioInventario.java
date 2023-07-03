package com.pam.periferiatest.servicio;

import com.pam.periferiatest.modelo.Activo;
import com.pam.periferiatest.modelo.Parametro;
import com.pam.periferiatest.repositorio.RepoActivo;
import com.pam.periferiatest.repositorio.RepoParametro;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author plinio
 */

@Service
public class ServicioInventario {
    @Autowired
    
    private RepoActivo repoActivo;
    private RepoParametro repoParametro;    
    
    public Activo registraActivo( Activo activo ){
        return repoActivo.save( activo );
    }

    public Optional<Activo> consultaActivo( Long numeroSerial ){
        return repoActivo.findById( numeroSerial );
    }

    public boolean darDeBaja( Long numeroSerial ){
        try{
            repoActivo.deleteById(numeroSerial);
            return true;
        }catch(Exception err){
            return false;
        }        
    }

    public boolean actualizaDepreciacionActivo( Long numeroSerial ){
        Float valorCompra;
        Optional<Activo> datosActivo = repoActivo.findById(numeroSerial);        
        if( datosActivo.isPresent() ) {
            Activo activo = datosActivo.get();
            valorCompra = datosActivo.get().getValorCompra();
            activo.setValorActual( valorCompra - ( valorCompra * 14/100) );
            repoActivo.save(activo);
            return( true );
        }else{
            return( false );
        }
    }
}