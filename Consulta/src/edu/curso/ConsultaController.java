package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConsultaController {

	 private ObservableList<Consulta> consultas = FXCollections.observableArrayList();
	 private ConsultaDAO dao = new ConsultaDAOImpl();
	 private StringProperty ConsID = new SimpleStringProperty();
	 private StringProperty ConsNome = new SimpleStringProperty();
	 private StringProperty consData = new SimpleStringProperty();
	 private StringProperty ConsIDPaciente = new SimpleStringProperty();
	 private StringProperty CRM = new SimpleStringProperty();
	 private StringProperty ConsIDMedicamento = new SimpleStringProperty();
	 private StringProperty ConsIDExame = new SimpleStringProperty();
	 private StringProperty Receita = new SimpleStringProperty();
	 private DateTimeFormatter formatter =
	         DateTimeFormatter.ofPattern("d/MM/yyyy");
	 
	    public StringProperty ConsID() {
			return ConsID;
		}
		
		public StringProperty ConsNome() {
			return ConsNome;
		}
		
		public StringProperty ConsData() {
			return consData;
		}
		
		public StringProperty ConsIDPaciente() {
			return ConsIDPaciente;
		}
		
		public StringProperty CRM() {
			return CRM;
		}
	
		public StringProperty ConsIDMedicamento() {
			return ConsIDMedicamento;
		}
		
		public StringProperty ConsIDExame() {
			return ConsIDExame;
		}
		
		public StringProperty Receita() {
			return Receita;
		}
		
		public void adicionar() {
		        System.out.println("ID: " + ConsID.get());
		        System.out.println("Nome: " + ConsNome.get());
		        System.out.println("Data: " + consData.get());
		        System.out.println("ID Paciente: " + ConsIDPaciente.get());
		        System.out.println("CRM: " + CRM.get());
		        System.out.println("ID Medicamento: " + ConsIDMedicamento.get());
		        System.out.println("ID Exame: " + ConsIDExame.get());
		        System.out.println("Receita: " + Receita.get());
		        
		 String dataConsulta = consData.get();
		 LocalDate dataCon = LocalDate.parse(dataConsulta,formatter);
		 Consulta c = new Consulta();
		 c.setConsID(ConsID.get());
		 c.setConsNome(ConsNome.get());
		 c.setConsData(dataCon);
		 c.setConsIDExame(ConsIDPaciente.get());
		 c.setCRM(CRM.get());
		 c.setConsIDMedicamento(ConsIDMedicamento.get());
		 c.setConsIDExame(ConsIDExame.get());
		 c.setConsReceita(Receita.get());
		 dao.cadastrar(c);
		 consultas.add(c);
		 }
		
		public void buscar () {
			
			List<Consulta> encontrados = dao.consultar(ConsNome.get());
	        consultas.clear();
	        consultas.addAll(encontrados);

		}
		
		public ObservableList<Consulta> getConsultas() {
		        return consultas;
		}
}
