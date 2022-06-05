package edu.curso;

import java.time.LocalDate;

public class Consulta {
	
	private String ConsID;
	private String ConsNome;
	private LocalDate consData;
	private String ConsIDPaciente;
	private String CRM;
	private String ConsIDMedicamento;
	private String ConsIDExame;
	private String ConsReceita;
	
	public String getConsID() {
		return ConsID;
	}
	public void setConsID(String consID) {
		ConsID = consID;
	}
	public String getConsNome() {
		return ConsNome;
	}
	public void setConsNome(String consNome) {
		ConsNome = consNome;
	}
	public LocalDate getConsData() {
		return consData;
	}
	public void setConsData(LocalDate consData) {
		this.consData = consData;
	}
	public String getConsIDPaciente() {
		return ConsIDPaciente;
	}
	public void setConsIDPaciente(String consIDPaciente) {
		ConsIDPaciente = consIDPaciente;
	}
	public String getCRM() {
		return CRM;
	}
	public void setCRM(String crm) {
		CRM = crm;
	}
	public String getConsIDMedicamento() {
		return ConsIDMedicamento;
	}
	public void setConsIDMedicamento(String consIDMedicamento) {
		ConsIDMedicamento = consIDMedicamento;
	}
	public String getConsIDExame() {
		return ConsIDExame;
	}
	public void setConsIDExame(String consIDExame) {
		ConsIDExame = consIDExame;
	}
	public String getConsReceita() {
		return ConsReceita;
	}
	public void setConsReceita(String consReceita) {
		ConsReceita = consReceita;
	}
	
	
}
