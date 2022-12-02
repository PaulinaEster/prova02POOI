package prova.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import prova.dao.VeiculoDao;
import prova.model.Veiculo;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisualizarUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tabela;

	private VeiculoDao veiculoDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualizarUI dialog = new VisualizarUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualizarUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				ArrayList<Veiculo> dados = new ArrayList<>() ;
				try {
					veiculoDao = new VeiculoDao();
					dados = veiculoDao.consultarTodos();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		        
		        String[] nomeColunas={"Modelo", "Ano", "N Serie", "Marca", "Cor", "Tipo" };
		        String[][] valorLinhas = new String[dados.size()][6];
		        
		        for(int i = 0; i < dados.size(); i++) {
		            valorLinhas[i][0] = dados.get(i).getModelo();
		            valorLinhas[i][1] = dados.get(i).getAno();
		            valorLinhas[i][2] = dados.get(i).getNumeroSerie();
		            valorLinhas[i][3] = dados.get(i).getMarca();
		            valorLinhas[i][4] = dados.get(i).getCor();
		            valorLinhas[i][5] = dados.get(i).getTipo();
		        }
		        
		        DefaultTableModel tabelaDados = new DefaultTableModel(valorLinhas, nomeColunas);
		        
		        tabela.setModel(tabelaDados);
				
			}
		});
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			tabela = new JTable();
			contentPanel.add(tabela);
		}
	}

}
