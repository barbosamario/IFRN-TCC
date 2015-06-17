package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import oitbpm.nc.bd_8bpm.negocio.Dependente;
import oitbpm.nc.bd_8bpm.persistencia.DependentesDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInserirDependentes extends JInternalFrame {
	private JTextField tfCodigo;
	private JTextField tfConjuge;
	private JTextField tfFilhos;
	private JTextField tfFiliacao;
	private Dependente dependente;
	private DependentesDAO dependentesDAO;
	private JButton btnSalvar;
	private JButton btnCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInserirDependentes frame = new JInserirDependentes();
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
	public JInserirDependentes() {
		setClosable(true);
		
		dependente = new Dependente();
		dependentesDAO = new DependentesDAO();
		
		setBounds(100, 100, 426, 213);
		getContentPane().setLayout(null);
		
		JLabel lblCnjuge = new JLabel("C\u00F4njuge:");
		lblCnjuge.setBounds(10, 48, 46, 14);
		getContentPane().add(lblCnjuge);
		
		JLabel lblFilhos = new JLabel("Filho(s):");
		lblFilhos.setBounds(10, 80, 46, 14);
		getContentPane().add(lblFilhos);
		
		JLabel lblFiliao = new JLabel("Filia\u00E7\u00E3o:");
		lblFiliao.setBounds(10, 108, 46, 14);
		getContentPane().add(lblFiliao);
		
		JLabel lblCdigoDoPm = new JLabel("C\u00F3digo do PM:");
		lblCdigoDoPm.setBounds(10, 17, 87, 14);
		getContentPane().add(lblCdigoDoPm);
				
		tfCodigo = new JTextField();
		tfCodigo.setBounds(96, 11, 301, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfConjuge = new JTextField();
		tfConjuge.setBounds(96, 42, 301, 20);
		getContentPane().add(tfConjuge);
		tfConjuge.setColumns(10);
		
		tfFilhos = new JTextField();
		tfFilhos.setBounds(96, 74, 301, 20);
		getContentPane().add(tfFilhos);
		tfFilhos.setColumns(10);
		
		tfFiliacao = new JTextField();
		tfFiliacao.setBounds(96, 102, 301, 20);
		getContentPane().add(tfFiliacao);
		tfFiliacao.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});
		
		btnSalvar.setBounds(141, 133, 89, 23);
		getContentPane().add(btnSalvar);
				
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(262, 133, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnCancelarActionPerformed(evt);
			}
		});
		
	}

	private void btnSalvarActionPerformed(ActionEvent evt){
		
		dependente.setConjuge(tfConjuge.getText());
		dependente.setFilhos(tfFilhos.getText());
		dependente.setFiliacao(tfFiliacao.getText());
		dependente.setId(Integer.parseInt(tfCodigo.getText()));

		dependentesDAO.inserir(dependente);
		
		JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!");
		
		limparFormulario(tfConjuge,tfFilhos,tfFiliacao,tfCodigo);
		
	}
	
	private void limparFormulario(JTextField...formularios) {
		for (JTextField formulario : formularios) {
			formulario.setText("");
			
			}
	}

	private void btnCancelarActionPerformed(ActionEvent evt){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
			JInserirDependentes.this.doDefaultCloseAction();
		}
	}

}
