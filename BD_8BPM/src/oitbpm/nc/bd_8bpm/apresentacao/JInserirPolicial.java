package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import oitbpm.nc.bd_8bpm.negocio.Policial;
import oitbpm.nc.bd_8bpm.persistencia.PoliciaisDAO;

public class JInserirPolicial extends JInternalFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfMatricula;
	private JButton btnSalvar;
	private Policial policial;
	private PoliciaisDAO policiaisDAO;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInserirPolicial frame = new JInserirPolicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JInserirPolicial() {
		
		policial = new Policial();
		policiaisDAO = new PoliciaisDAO();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 498, 167);
		setClosable(true);
		setResizable(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setBounds(10, 42, 62, 14);
		panel.add(lblMatrcula);
		
		tfNome = new JTextField();
		tfNome.setBounds(82, 11, 346, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(82, 43, 200, 20);
		panel.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(129, 89, 89, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(264, 88, 89, 23);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnCancelarActionPerformed(evt);
			}
		});
		
	}
	
	private void btnSalvarActionPerformed(ActionEvent evt){
	
		
		policial.setNome(tfNome.getText());
		policial.setMatricula(tfMatricula.getText());
		
		policiaisDAO.inserir(policial);
		
		JOptionPane.showMessageDialog(null,"Dados Salvos com Sucesso!");
		
		limparFormulario(tfNome,tfMatricula);
	}
	
	private void limparFormulario(JTextField...formularios) {
		// TODO Auto-generated method stub
		for(JTextField formulario : formularios){
			formulario.setText("");
		}
	}

	
	private void btnCancelarActionPerformed(ActionEvent evt){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
			JInserirPolicial.this.doDefaultCloseAction();
		}
	}

}

