package com.pam.periferiatest.modelo;


/**
 *
 * @author plinio
 */

import java.io.Serializable;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
	
/**
 *
 * @author plinio
 */
@Entity
@Table(name="Parametros")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Parametro implements Serializable {
    @Id
    @Column(unique = true, nullable = false)    
    private String id;
    
    private String valor;
       
}
