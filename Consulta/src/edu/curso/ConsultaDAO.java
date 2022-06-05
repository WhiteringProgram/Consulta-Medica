package edu.curso;

import java.util.List;

public interface ConsultaDAO {

		void cadastrar(Consulta c);
		List<Consulta> consultar(String ConsNome);
		
}
