/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.colegio.tuliomaven.Interfaces;

import com.colegio.tuliomaven.Conexion.Conexion;
import com.colegio.tuliomaven.Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alexander
 */
public class UsuarioDAO {
     Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public int Validar(Usuario usu) {
//        String sql = "SELECT * FROM USUARIO WHERE GMAIL = ? AND CLAVE = ?";
        String sql = "SELECT * FROM USUARIO WHERE GMAIL = ? AND (aes_decrypt(CLAVE, 'AES')=?)";
//        SELECT * FROM USUARIO WHERE GMAIL = 'ADMIN' AND (aes_decrypt(CLAVE, 'AES')='ADMIN');
        int r = 0;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getEmail());
            ps.setString(2, usu.getClave());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                usu.setEmail(rs.getString("gmail"));
//                usu.setClave(DigestUtils.md5Hex(rs.getString("clave")));
                usu.setClave(rs.getString("clave"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
}
}
    
