package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class SegreteriaStudentiController {
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
    void docercaiscritti(ActionEvent event) {

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
