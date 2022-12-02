package prova.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import prova.dao.VeiculoDao;
import prova.model.Veiculo;
 

public class VeiculoNegocio {
	
	public ArrayList consultarVeiculos(String modeloPesquisar) throws SQLException {
		VeiculoDao dao = new VeiculoDao();
		ArrayList<Veiculo> minhaLista = dao.consultar(modeloPesquisar);
		return minhaLista;
	}
	
	public void inserirPorduto(String modelo, String ano, String numeroSerie, String marca, String cor, String tipo) throws SQLException {
		Veiculo p = new Veiculo(0, modelo, ano, marca, numeroSerie, cor, tipo);
		
		VeiculoDao VeiculoDao = new VeiculoDao();
		
		VeiculoDao.inserir(p);
		JOptionPane.showMessageDialog(null, "Cadastro inserido com sucesso");
	}
	
	public void alterarVeiculo(String id, String modelo, String ano, String numeroSerie, String marca, String cor, String tipo) throws SQLException {
		Veiculo p = new Veiculo(Integer.parseInt(id), modelo, ano, 
								numeroSerie, marca, cor, tipo);
		
		VeiculoDao dao = new VeiculoDao();
		dao.alterar(p);
		
		JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
	}
	
	public void removerVeiculo(String id) throws SQLException {
		Veiculo veiculo = new Veiculo();
		veiculo.setId(Integer.parseInt(id));
		VeiculoDao dao = new VeiculoDao();
		dao.remover(veiculo);

		JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!"); 
	}
}
