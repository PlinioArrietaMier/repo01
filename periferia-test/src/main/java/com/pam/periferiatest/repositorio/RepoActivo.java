package com.pam.periferiatest.repositorio;

import com.pam.periferiatest.modelo.Activo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author plinio
 */
@Repository
public interface RepoActivo extends JpaRepository<Activo, Long>{
    
}
