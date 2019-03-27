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
	
	
	
	
}
