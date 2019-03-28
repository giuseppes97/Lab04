package it.polito.tdp.lab04.controller;
import it.polito.tdp.lab04.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class SegreteriaStudentiController {
	private List<Studente> listastud = new ArrayList<Studente>();
    private Model modello;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> finestrasceltecorsi;

    @FXML
    private Button bottonecercaiscr;

    @FXML
    private TextField testomatricola;

    @FXML
    private Button bottonecompleta;

    @FXML
    private TextField testonome;

    @FXML
    private TextField testocognome;

    @FXML
    private TextArea testorisultati;
    @FXML
    private Button bottonecercacorsi;

    @FXML
    private Button bottoneiscrivi;

    @FXML
    private Button bottonereset;

    @FXML
    void docercaiscritti(ActionEvent event) {
    	testorisultati.clear();
    	
  String corso=finestrasceltecorsi.getValue();
  if(corso.equals("")) {testorisultati.appendText("Devi scegliere un corso!\n");}
 List<Studente> s= modello.getIscrittialcorso(corso);
 for(Studente stu:s) {
	 testorisultati.appendText(""+stu.getMatricola()+" "+stu.getCognome()+" "+stu.getNome()+" "+stu.getCds()+"\n");
 }
    }
    @FXML
    void doiscrivistudente(ActionEvent event) {
   testorisultati.clear();
   int flag=0;
    List<Corso> lc=modello.getCorsidovestudenteiscritto(testomatricola.getText());
    for(Corso c:lc) {
    	if(c.getNome().equals(finestrasceltecorsi.getValue())) {testorisultati.appendText("Studente già iscritto a questo corso!"); flag=1;}
    }
    if(flag==0) {
    	Corso c=modello.getcorsodanome(finestrasceltecorsi.getValue());
    	boolean a=modello.iscrivistudente(testomatricola.getText(),c.getCodins());
    	if(a==true) {testorisultati.appendText("Studente iscritto correttamente!\n");}
    }
    }

    @FXML
    void doreset(ActionEvent event) {

    }
    @FXML
    void cercacorsi(ActionEvent event) {
    	testorisultati.clear();
    	String matricola=testomatricola.getText();
    	if(modello.getstudentedamatricola(matricola)==null) {testorisultati.appendText("Errore,studente non esiste!\n"); return;}
        List<Corso> c=modello.getCorsidovestudenteiscritto(matricola);
        
        for(Corso co:c) {
        	testorisultati.appendText(""+co.getCodins()+" "+co.getCrediti()+" "+co.getNome()+" "+co.getPd()+"\n");
        }
    }

    @FXML
    void docompletastudente(ActionEvent event) {
    String matricola=testomatricola.getText();
    testonome.setText(modello.getnomematricola(matricola));
    testocognome.setText(modello.getcognomematricola(matricola));
    }

    @FXML
    void initialize() {
        assert finestrasceltecorsi != null : "fx:id=\"finestrasceltecorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert bottonecercaiscr != null : "fx:id=\"bottonecercaiscr\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert testomatricola != null : "fx:id=\"testomatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert bottonecompleta != null : "fx:id=\"bottonecompleta\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert testonome != null : "fx:id=\"testonome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert testocognome != null : "fx:id=\"testocognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert testorisultati != null : "fx:id=\"testorisultati\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }

	public void setModel(Model m) {
		this.modello=m;
		finestrasceltecorsi.getItems().add("");
		finestrasceltecorsi.getItems().addAll(modello.gettuttinomicorsi());
		
	}
}
