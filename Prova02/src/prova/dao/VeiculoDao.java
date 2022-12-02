package prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prova.model.Veiculo;

public class VeiculoDao {
	
	private Connection connection = null;

	public VeiculoDao() throws SQLException { 
		this.connection = new ConexaoDao().getConnection();
	}

	public ArrayList<Veiculo> consultar(String modeloPesquisar) throws SQLException {
		String sql = "select * from veiculosdb.veiculo where modelo like?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,  modeloPesquisar);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Veiculo> minhaLista = new ArrayList<>();
		
		while(rs.next()) {
			Veiculo veiculo = new Veiculo(rs.getInt("id"), rs.getString("modelo"), rs.getString("ano"), rs.getString("numeroSerie"), rs.getString("marca"), rs.getString("cor"), rs.getString("tipo"));
			minhaLista.add(veiculo);
		}
		rs.close();
		stmt.close();
		connection.close();
		return minhaLista;
	}

	public ArrayList<Veiculo> consultarTodos() throws SQLException {
		String sql = "select * from veiculo";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Veiculo> minhaLista = new ArrayList<>();
		
		while(rs.next()) {
			Veiculo veiculo = new Veiculo(rs.getInt("id"), rs.getString("modelo"), rs.getString("ano"), rs.getString("numeroSerie"), rs.getString("marca"), rs.getString("cor"), rs.getString("tipo"));
			minhaLista.add(veiculo);
		}
		rs.close();
		stmt.close();
		connection.close();
		return minhaLista;
	}
	
	public void inserir(Veiculo p) throws SQLException {
		String sql = "insert into veiculo(modelo, ano, numeroSerie, marca, cor, tipo)" + " values(?,?,?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, p.getModelo());
			stmt.setString(2, p.getAno());
			stmt.setString(3, p.getNumeroSerie());
			stmt.setString(4, p.getMarca());
			stmt.setString(5, p.getCor());
			stmt.setString(6, p.getTipo());
			stmt.execute();
		}
		connection.close();
	}

	public void alterar(Veiculo p) throws SQLException {
		String sql = "update veiculo set modelo=?, ano=?, numeroSerie=?, marca=?, cor=?, tipo=? where id=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, p.getModelo());
			stmt.setString(2, p.getAno());
			stmt.setString(3, p.getNumeroSerie());
			stmt.setString(4, p.getMarca());
			stmt.setString(5, p.getCor());
			stmt.setString(6, p.getTipo());
			stmt.setInt(7, p.getId());
			stmt.execute();
		}
		connection.close();
	}

	public void remover(Veiculo veiculo) throws SQLException {
		String sql = "delete from veiculo where id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, veiculo.getId());
		stmt.execute();
		stmt.close();
		connection.close();
	}
	
	public Veiculo consultarNumeroSerie(String nSerie) throws SQLException {
		String sql = "select * from veiculosdb.veiculo where numeroSerie like ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,  nSerie);
		ResultSet rs = stmt.executeQuery();
		 
		
		ArrayList<Veiculo> minhaLista = new ArrayList<>();
		
		while(rs.next()) {
			Veiculo veiculo = new Veiculo(rs.getInt("id"), rs.getString("modelo"), rs.getString("ano"), rs.getString("numeroSerie"), rs.getString("marca"), rs.getString("cor"), rs.getString("tipo"));
			minhaLista.add(veiculo);
		}
		rs.close();
		stmt.close();
		connection.close();
		if(minhaLista.size() > 0) {
			return minhaLista.get(0);
		}
		return null;
	}
}
