package it.polito.tdp.lab04.model;
import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
public class Model {
private CorsoDAO cd=new CorsoDAO();
private StudenteDAO sdao=new StudenteDAO();
	public List<String> gettuttinomicorsi() {
		List<String> listanomi=new ArrayList<String>();
		List<Corso> a;
		a=cd.getTuttiICorsi();
		for(Corso c:a) {
			listanomi.add(c.getNome());
		}
		return listanomi;
	}
public String getcognomematricola(String m) {
	return sdao.getStudentedamatricola(m).getCognome();
}

public String getnomematricola(String m) {
	return sdao.getStudentedamatricola(m).getNome();
}
public List<Studente> getIscrittialcorso(String nomecorso){
	Corso c=cd.getCorsoDaNome(nomecorso);
	List<Studente> s;
	s=cd.getStudentiIscrittiAlCorso(c);
	return s;
	
	
}
public List<Corso> getCorsidovestudenteiscritto(String matricola){
	List<Corso> lc=cd.getcorsidellostudente(matricola);
	return lc;
}
public Studente getstudentedamatricola(String matr) {
	return sdao.getStudentedamatricola(matr);
}
public boolean iscrivistudente(String text, String value) {
	return cd.aggiungistudente(text,value);
	
}
public Corso getcorsodanome(String value) {
	Corso c=cd.getCorsoDaNome(value);
	return c;
}

	
	
	
}
