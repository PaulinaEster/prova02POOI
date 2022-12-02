package prova.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SobreUI sobre = new SobreUI();
	private CadastroUI cadastroUI = new CadastroUI();
	private VisualizarUI visualizarUI = new VisualizarUI();
	private ExcluirUI excluirUI = new ExcluirUI();
	private EditarUI editarUI = new EditarUI();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Principal() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JButton btnSobre = new JButton("Sobre");
				btnSobre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sobre.setVisible(true);
						
					}
				});
				menuBar.add(btnSobre);
			}
			{
				JButton btnCadastro = new JButton("Cadastro");
				btnCadastro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cadastroUI.setVisible(true);
					}
				});
				menuBar.add(btnCadastro);
			}
			{
				JButton btnVisualizar = new JButton("Visualizar");
				btnVisualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						visualizarUI.setVisible(true);
					}
				});
				menuBar.add(btnVisualizar);
			}
			{
				JButton btnExcluir = new JButton("Excluir Veiculo");
				btnExcluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						excluirUI.setVisible(true);
					}
				});
				menuBar.add(btnExcluir);
			}
			{
				JButton btnNewButton = new JButton("Editar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						editarUI.setVisible(true);
					}
				});
				menuBar.add(btnNewButton);
			}
		}
	}

}
