package edu.curso;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.*;

public class ConsultaDAOImpl implements ConsultaDAO {

    private static final String JDBC_URL = 
    		"jdbc:sqlserver://127.0.0.1;dataBaseName=Clinica;"
    		+ "user=root"
    		+ "password=alunofatec"+
    		"encrypt=true;trustServerCertificate=true";
    private Connection con = null;
    private DateTimeFormatter formatter =
	        DateTimeFormatter.ofPattern("d/MM/yyyy");

    ConsultaDAOImpl() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            con = DriverManager.getConnection(JDBC_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(Consulta c) {
        String sql = "INSERT INTO consulta (ConsID, ConsNome, ConsData, ConsIDPaciente, CRM, ConsIDMedicamento"
        									+ "ConsIDExame, ConsReceita) ";
        sql += " VALUES ('" + c.getConsID() + "', ";
        sql += " '" + c.getConsNome() + "')";
        sql += " '" + c.getConsData() + "')";
        sql += " '" + c.getConsIDPaciente() + "')";
        sql += " '" + c.getCRM() + "')";
        sql += " '" + c.getConsIDMedicamento() + "')";
        sql += " '" + c.getConsIDExame() + "')";
        sql += " '" + c.getConsReceita() + "')";
        System.out.println("Query preparada: " + sql);
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> consultar(String nome) {
        String sql = "SELECT * FROM clinica WHERE consNome LIKE '%" + nome + "%'";
        List<Consulta> consultas = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Consulta c = new Consulta();
                c.setConsNome(rs.getString("Nome"));
                c.setConsID(rs.getString("ID"));
                c.setConsIDExame(rs.getString("ID EXAME:"));
                c.setConsData(null);
                c.setConsIDMedicamento(rs.getString("ID Medicamento"));
                c.setConsIDPaciente(rs.getString("ID Paciente"));
                c.setConsReceita(rs.getString("Receita"));
                c.setCRM(rs.getString("CRM"));
                consultas.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }
}