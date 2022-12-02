package prova.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SobreUI extends javax.swing.JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SobreUI dialog = new SobreUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SobreUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Sobre o sitema");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblNewLabel.setBounds(20, 11, 121, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCriadoPor = new JLabel("Criado por:");
			lblCriadoPor.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblCriadoPor.setBounds(20, 50, 103, 14);
			contentPanel.add(lblCriadoPor);
		}
		{
			JLabel lblDisciplina = new JLabel("Disciplina:");
			lblDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblDisciplina.setBounds(20, 93, 92, 14);
			contentPanel.add(lblDisciplina);
		}
		{
			JLabel lblCriadoEm = new JLabel("Criado em: ");
			lblCriadoEm.setFont(new Font("Times New Roman", Font.BOLD, 18));
			lblCriadoEm.setBounds(20, 132, 92, 14);
			contentPanel.add(lblCriadoEm);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("01-12-2022");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(133, 132, 103, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("POOI");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(133, 93, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Paulina Rehbein - 202012842");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(133, 50, 263, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
	}

}
