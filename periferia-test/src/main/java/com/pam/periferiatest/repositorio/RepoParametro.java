package com.pam.periferiatest.repositorio;

import com.pam.periferiatest.modelo.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author plinio
 */
@Repository
public interface RepoParametro extends JpaRepository<Parametro, String>{
    
}
