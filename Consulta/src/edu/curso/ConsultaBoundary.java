package edu.curso;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConsultaBoundary extends Application {
	
	 private TextField txtConsID = new TextField();
	 private TextField txtConsNome = new TextField();
	 private TextField txtConsData = new TextField();
	 private TextField txtCRM = new TextField();
	 private TextField txtConsIDMedicamento = new TextField();
	 private TextField txtConsIDExame = new TextField();
	 private TextField txtConsReceita = new TextField();
	 private Button btnAdicionar = new Button("Adicionar");
	 private Button btnPesquisar = new Button("Pesquisar");
	 private ConsultaController controller = new ConsultaController();
	 private TableView<Consulta> tabela = new TableView<>();
	 
	 @Override
	 public void start (Stage stage) throws Exception {
		  BorderPane principal = new BorderPane();
	      GridPane grid = new GridPane();
	      principal.setTop(grid);
	      principal.setCenter(tabela);
	      Scene scn = new Scene(principal, 600, 300);
	      
	      grid.add(new Label("ID: "), 0, 0);
	      grid.add(txtConsID, 1,0);
	      grid.add(new Label("Nome: "), 0, 1);
	      grid.add(txtConsNome, 1, 1);
	      grid.add(new Label("Data: "), 0, 1);
	      grid.add(txtConsData, 1, 1);
	      grid.add(new Label("CRM: "), 0, 1);
	      grid.add(txtCRM, 1, 1);
	      grid.add(new Label("Medicamento: "), 0, 1);
	      grid.add(txtConsIDMedicamento, 1, 1);
	      grid.add(new Label("Exame: "), 0, 1);
	      grid.add(txtConsIDExame, 1, 1);
	      grid.add(new Label("Receita: "), 0, 1);
	      grid.add(txtConsReceita, 1, 1);
	      grid.add(btnAdicionar, 0, 2);
	      grid.add(btnPesquisar, 1, 2);
	      
	      Bindings.bindBidirectional(controller.ConsID(), txtConsID.textProperty());
	      Bindings.bindBidirectional(controller.ConsNome(), txtConsNome.textProperty());
	      Bindings.bindBidirectional(controller.ConsData(), txtConsData.textProperty());
	      Bindings.bindBidirectional(controller.CRM(), txtCRM.textProperty());
	      Bindings.bindBidirectional(controller.ConsIDMedicamento(), txtConsIDMedicamento.textProperty());
	      Bindings.bindBidirectional(controller.ConsIDExame(), txtConsData.textProperty());
	      Bindings.bindBidirectional(controller.Receita(), txtConsReceita.textProperty());

	      TableColumn<Consulta, String> col1 = new TableColumn<>("ID");
	      col1.setCellValueFactory(new PropertyValueFactory<>("id"));

	      TableColumn<Consulta, String> col2 = new TableColumn<>("Nome");
	      col2.setCellValueFactory(new PropertyValueFactory<>("nome"));
	      
	      TableColumn<Consulta, String> col3 = new TableColumn<>("Data");
	      col3.setCellValueFactory(new PropertyValueFactory<>("data"));
	      
	      TableColumn<Consulta, String> col4 = new TableColumn<>("CRM");
	      col4.setCellValueFactory(new PropertyValueFactory<>("crm"));
	      
	      TableColumn<Consulta, String> col5 = new TableColumn<>("Medicamento");
	      col5.setCellValueFactory(new PropertyValueFactory<>("medicamento"));
	      
	      TableColumn<Consulta, String> col6 = new TableColumn<>("Exame");
	      col6.setCellValueFactory(new PropertyValueFactory<>("exame"));
	      
	      TableColumn<Consulta, String> col7 = new TableColumn<>("Receita");
	      col7.setCellValueFactory(new PropertyValueFactory<>("receita"));
	      
	      tabela.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);

		 	tabela.setItems(controller.getConsultas());

		 	btnAdicionar.setOnAction((e) -> {
	      controller.adicionar();
		 	});

		 	btnPesquisar.setOnAction( (e) -> {
	      controller.buscar();
		 	});

		 	stage.setScene(scn);
		 	stage.setTitle("Gestão de Consultas");
		 	stage.show();
	 }
	 
	 	public static void main(String[] args) {
	        Application.launch(ConsultaBoundary.class, args);
	 }
	 
} 
	 
