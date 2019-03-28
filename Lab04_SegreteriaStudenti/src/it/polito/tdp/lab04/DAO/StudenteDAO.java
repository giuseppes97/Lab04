package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	
	public Studente getStudentedamatricola(String matricola) {
	final String sql = "SELECT * FROM studente WHERE matricola=?";
	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, matricola);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) { Studente s=new Studente(rs.getString("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
		
		return s;  }
	
	}catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db");
	}
	return null;
	}
}
