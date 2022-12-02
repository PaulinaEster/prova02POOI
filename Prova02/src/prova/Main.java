package prova;

import java.sql.SQLException;
import java.util.ArrayList;

import prova.dao.VeiculoDao;
import prova.model.Veiculo;

public class Main {

	public static void main(String[] args) throws SQLException {
		VeiculoDao dao =  new VeiculoDao();
		
		ArrayList<Veiculo>  veiculos= dao.consultarTodos();
		System.out.println("teste");
		for(int i = 0; i< veiculos.size(); i++) {
			System.out.println(veiculos.get(i).getMarca() + " " + veiculos.get(i).getModelo());
			
		}
		dao =  new VeiculoDao();
		Veiculo v = new Veiculo(0, "teste", "1234", "123945", "apagar", "preto", "terrestre");
		dao.inserir(v);
		
		dao =  new VeiculoDao();
		System.out.println("Consulta ====================== ");
		veiculos= dao.consultarTodos(); 
		for(int i = 0; i< veiculos.size(); i++) {
			System.out.println(veiculos.get(i).getMarca() + " " + veiculos.get(i).getModelo());
		}
	}

}
