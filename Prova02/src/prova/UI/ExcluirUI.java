package prova.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.x.Ok;

import prova.dao.VeiculoDao;
import prova.model.Veiculo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;

public class ExcluirUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nSerie;
	private VeiculoDao veiculoDao;
	private JTextField textUm;
	private JTextField textDois;
	private Veiculo veiculo = null;
	private JTextField avisos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ExcluirUI dialog = new ExcluirUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExcluirUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Numero de serie:");
			lblNewLabel.setBounds(30, 13, 82, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			nSerie = new JTextField();
			nSerie.setBounds(134, 10, 86, 20);
			contentPanel.add(nSerie);
			nSerie.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Veiculo:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(26, 66, 86, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		textUm = new JTextField();
		textUm.setEditable(false);
		textUm.setBounds(30, 106, 394, 20);
		contentPanel.add(textUm);
		textUm.setColumns(10);
		
		textDois = new JTextField();
		textDois.setEditable(false);
		textDois.setColumns(10);
		textDois.setBounds(30, 135, 394, 20);
		contentPanel.add(textDois);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				veiculo = new Veiculo();
				
				try {
					veiculoDao = new VeiculoDao();
					veiculo = veiculoDao.consultarNumeroSerie(nSerie.getText());
					
					if(veiculo != null) {
						textUm.setText(veiculo.getModelo() + " " + veiculo.getAno() + " " + veiculo.getCor());
						textDois.setText(veiculo.getMarca() + " " + veiculo.getNumeroSerie() + " " + veiculo.getTipo());
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(250, 9, 89, 23);
		contentPanel.add(btnNewButton);
		{
			avisos = new JTextField();
			avisos.setEnabled(false);
			avisos.setForeground(new Color(255, 0, 0));
			avisos.setFont(new Font("Tahoma", Font.BOLD, 14));
			avisos.setBounds(30, 188, 212, 20);
			contentPanel.add(avisos);
			avisos.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nSerie.setText("");
						textUm.setText("");
						textDois.setText("");
					}
				});
				{
					JButton btnExcluir = new JButton("EXCLUIR");
					buttonPane.add(btnExcluir);
					btnExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								veiculoDao = new VeiculoDao();
								
								if(veiculo != null) {
									veiculoDao.remover(veiculo);
									avisos.setText("VEICULO EXCLUIDO COM SUCESSO!");
									nSerie.setText("");
									textUm.setText("");
									textDois.setText("");
								}else {
									textUm.setText("Consulte o veiculo antes..."); 
								}
								
								
							} catch (SQLException e1) {
								avisos.setText("ERRO: " + e1.getMessage());
								e1.printStackTrace();
							}
							
						}
					});
					btnExcluir.setActionCommand("OK");
					getRootPane().setDefaultButton(btnExcluir);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
