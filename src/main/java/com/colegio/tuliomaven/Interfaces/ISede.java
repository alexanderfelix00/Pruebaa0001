/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.colegio.tuliomaven.Interfaces;

import com.colegio.tuliomaven.Modelo.Sede;
import java.util.List;

/**
 *
 * @author alexander
 */
public interface ISede {
        public List<Sede> ListarSede();
    
    public List<Sede> ListarSedeID(int id_sede);
    
    public int InsertarSede(Sede sede);
    
    public int ActualizarSede(Sede sede);
    
    public int EliminarSede(Sede sede);
    
}
