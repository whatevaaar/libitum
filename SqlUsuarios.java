package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUsuarios extends Conexion {
    public boolean registrar(usuarios usr){
        PreparedStatement ps=null;
        Connection con=getConexion();
        
        String sql="INSERT INTO jugador(nombreUsuario, nombre, apPaterno, apMaterno, password) VALUES(?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, usr.getNomUsuario());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApPat());
            ps.setString(4, usr.getApMat());
            ps.setString(5, usr.getPassword());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

        public boolean login(usuarios usr){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=getConexion();
        
        String sql="SELECT nombreUsuario, nombre, apPaterno, apMaterno, password FROM jugador WHERE nombreUsuario=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, usr.getNomUsuario());
            rs=ps.executeQuery();
            if(rs.next()){
                
                if(usr.getPassword().equals(rs.getString(5))){
                    usr.setNombre(rs.getString(2));
                    usr.setApPat(rs.getString(3));
                    usr.setApMat(rs.getString(4));
                    return true;
                } else{ return false; }
            } 
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
        public int existeUsuario(String usuario){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=getConexion();
        
        String sql="SELECT count(nombreUsuario) FROM jugador WHERE nombreUsuario=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            } 
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
}
