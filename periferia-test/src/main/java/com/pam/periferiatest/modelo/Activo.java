package com.pam.periferiatest.modelo;

/**
 *
 * @author plinio
 */

import lombok.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
	
/**
 *
 * @author plinio
 */
@Entity
@Table(name="Activos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Activo {
    @Id
    @Column(unique = true, nullable = false)
    private Long numeroSerial;
    private String descripcion;
    private String nombre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCompra;
    private Float valorCompra;
    private Float valorActual;
}
