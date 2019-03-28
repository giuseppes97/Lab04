package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				Corso c=new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsi.add(c);
			}
            
			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	public Corso getCorsoDaNome(String nome) {
		final String sql = "SELECT * FROM corso WHERE nome=?";

		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nomea = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

			
				Corso c=new Corso(codins,numeroCrediti,nomea,periodoDidattico);
				
				return c;
			}
            
		

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return null;
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
   final String sql = "SELECT s.matricola,s.cognome,s.nome,s.CDS FROM iscrizione i,studente s WHERE codins=? AND i.matricola=s.matricola";
   List<Studente> listastu=new ArrayList<Studente>();
		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, corso.getCodins());
			ResultSet rs = st.executeQuery();
            
			while (rs.next()) {

				String matricola = rs.getString("matricola");
				String cognome = rs.getString("cognome");
				String nomea = rs.getString("nome");
				String cds = rs.getString("CDS");

			
				Studente s=new Studente(matricola,cognome,nomea,cds);
				listastu.add(s);
			}
			
			return listastu;
            
		

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
	
	public List<Corso> getcorsidellostudente(String matr){
		 final String sql = "SELECT c.codins,c.crediti,c.nome,c.pd FROM iscrizione AS i,corso AS c WHERE matricola=? AND c.codins=i.codins";
		   List<Corso> listaco=new ArrayList<Corso>();
				

				try {
					Connection conn = ConnectDB.getConnection();
					PreparedStatement st = conn.prepareStatement(sql);
		            st.setString(1, matr);
					ResultSet rs = st.executeQuery();
		            
					while (rs.next()) {

						String codins = rs.getString("codins");
						int crediti = rs.getInt("crediti");
						String nomea = rs.getString("nome");
						int pd = rs.getInt("pd");

					
						Corso c=new Corso(codins,crediti,nomea,pd);
						listaco.add(c);
					}
					
					return listaco;
		            
				

				} catch (SQLException e) {
					// e.printStackTrace();
					throw new RuntimeException("Errore Db");
				}
				
		
	}
	public boolean aggiungistudente(String text, String value) {
		final String sql = "INSERT INTO iscrizione VALUES ?,?";
		   
				

				try {
					Connection conn = ConnectDB.getConnection();
					PreparedStatement st = conn.prepareStatement(sql);
					int a=Integer.parseInt(text);
		            st.setInt(1, a);
		            st.setString(2, value);
					ResultSet rs = st.executeQuery();
		            
					
					
					return true;
		            
				

				} catch (SQLException e) {
					// e.printStackTrace();
					throw new RuntimeException("Errore Db");
				}
				
		
	}
	
}
