/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.colegio.tuliomaven.Interfaces;

import static com.colegio.tuliomaven.Conexion.Conexion.getConnection;
import com.colegio.tuliomaven.Modelo.Sede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexander
 */
public class DAOSede implements ISede {

    @Override
    public List<Sede> ListarSede() {
      try {
            List<Sede> lista = new ArrayList<>();
            String sql = "SELECT * FROM SEDE";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Sede oSede = new Sede();
                oSede.setId_sede(rs.getInt(1));
                oSede.setNombre(rs.getString(2));
                oSede.setEstado(rs.getBoolean(3));
                lista.add(oSede);
            }
            rs.close();
            ps.close();
            con.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSede.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Sede> ListarSedeID(int id_sede) {
          try {
            List<Sede> lista = new ArrayList<>();
            String sql = "SELECT * FROM SEDE WHERE IDSEDE = ?";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_sede);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Sede oSede = new Sede();
                oSede.setId_sede(rs.getInt(1));
                oSede.setNombre(rs.getString(2));
                oSede.setEstado(rs.getBoolean(3));
                lista.add(oSede);
            }
            rs.close();
            ps.close();
            con.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSede.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int InsertarSede(Sede sede) {
       try {
            int fila;
            String sql = "INSERT INTO SEDE VALUES(NULL,?,?)";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sede.getNombre());
            ps.setBoolean(2, sede.isEstado());
            fila = ps.executeUpdate();
            con.close();
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSede.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int ActualizarSede(Sede sede) {
         try {
            int fila;
            String sql = "UPDATE SEDE SET NOMBRE = ? AND ESTADO = ? WHERE IDSEDE = ?";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sede.getNombre());
            ps.setBoolean(2, sede.isEstado());
            ps.setInt(3, sede.getId_sede());
            fila = ps.executeUpdate();
            con.close();
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSede.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int EliminarSede(Sede sede) {
       try {
            int fila;
            String sql = "UPDATE SEDE SET ESTADO = 1 WHERE IDSEDE = ?";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sede.getId_sede());
            fila = ps.executeUpdate();
            con.close();
            return fila;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSede.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
}
