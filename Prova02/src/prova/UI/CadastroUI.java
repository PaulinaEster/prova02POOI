package prova.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prova.dao.VeiculoDao;
import prova.model.Veiculo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;

public class CadastroUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textModelo;
	private JTextField textAno;
	private JTextField textNumSerie;
	private JTextField textMarca;
	private JTextField textCor;
	
	private VeiculoDao veiculoDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroUI dialog = new CadastroUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo:");
			lblModelo.setBounds(10, 11, 46, 14);
			contentPanel.add(lblModelo);
		}
		{
			JLabel lblAno = new JLabel("Ano:");
			lblAno.setBounds(280, 11, 46, 14);
			contentPanel.add(lblAno);
		}
		{
			JLabel lblNumeroDeSerie = new JLabel("Numero de Serie:");
			lblNumeroDeSerie.setBounds(10, 102, 93, 14);
			contentPanel.add(lblNumeroDeSerie);
		}
		{
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setBounds(126, 102, 46, 14);
			contentPanel.add(lblMarca);
		}
		{
			JLabel lblCor = new JLabel("Cor:");
			lblCor.setBounds(237, 102, 46, 14);
			contentPanel.add(lblCor);
		}
		
		textModelo = new JTextField();
		textModelo.setBounds(10, 36, 245, 20);
		contentPanel.add(textModelo);
		textModelo.setColumns(10);
		
		textAno = new JTextField();
		textAno.setColumns(10);
		textAno.setBounds(290, 36, 86, 20);
		contentPanel.add(textAno);
		
		textNumSerie = new JTextField();
		textNumSerie.setColumns(10);
		textNumSerie.setBounds(10, 127, 86, 20);
		contentPanel.add(textNumSerie);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(126, 127, 86, 20);
		contentPanel.add(textMarca);
		
		textCor = new JTextField();
		textCor.setColumns(10);
		textCor.setBounds(237, 127, 86, 20);
		contentPanel.add(textCor);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Maritmo", "Terrestre", "Aquatico", "Subteraneo"}));
		comboTipo.setBounds(95, 176, 143, 22);
		contentPanel.add(comboTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(39, 180, 46, 14);
		contentPanel.add(lblTipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton okButton_1 = new JButton("SALVAR");
				okButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							veiculoDao = new VeiculoDao();
							if(veiculoDao.consultarNumeroSerie(textNumSerie.getText()) == null) {
								Veiculo veiculo = new Veiculo(
										0,
										textModelo.getText(),
										textAno.getText(),
										textNumSerie.getText(),
										textMarca.getText(),
										textCor.getText(),
										String.valueOf(comboTipo.getSelectedItem())								
										);
								veiculoDao = new VeiculoDao();
								veiculoDao.inserir(veiculo);
								
							}else {
								textModelo.setText("VEICULO JA CADASTRADO ");
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				okButton_1.setForeground(new Color(0, 64, 0));
				okButton_1.setActionCommand("OK");
				buttonPane.add(okButton_1);
			}
			{
				JButton cancelButton = new JButton("LIMPAR");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textModelo.setText("");
						textAno.setText("");
						textNumSerie.setText("");
						textMarca.setText("");
						textCor.setText(""); 	
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
