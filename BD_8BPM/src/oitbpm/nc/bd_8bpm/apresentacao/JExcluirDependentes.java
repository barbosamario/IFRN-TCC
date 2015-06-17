package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import oitbpm.nc.bd_8bpm.negocio.Dependente;
import oitbpm.nc.bd_8bpm.persistencia.DependentesDAO;

public class JExcluirDependentes extends JInternalFrame {
	private JTextField tfExcluirDependentes;
	private DependentesDAO dependentesDAO;
	private Dependente dependente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JExcluirDependentes frame = new JExcluirDependentes();
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
	public JExcluirDependentes() {
		
		dependente = new Dependente();
		dependentesDAO = new DependentesDAO();
		
		setBounds(100, 100, 359, 138);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelExcluirDependentes = new JPanel();
		getContentPane().add(panelExcluirDependentes);
		panelExcluirDependentes.setLayout(null);
		
		JLabel labelExcluirDependentes = new JLabel("Digite o Id dos Dependentes que Deseja Excluir:");
		labelExcluirDependentes.setBounds(10, 14, 317, 14);
		panelExcluirDependentes.add(labelExcluirDependentes);
		
		tfExcluirDependentes = new JTextField();
		tfExcluirDependentes.setBounds(283, 11, 50, 20);
		tfExcluirDependentes.setColumns(10);
		panelExcluirDependentes.add(tfExcluirDependentes);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(181, 58, 89, 23);
		panelExcluirDependentes.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
				
			}
		});
		
				
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(82, 58, 89, 23);
		panelExcluirDependentes.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvarActionPerformed(e);
			}
		});

}

private void btnSalvarActionPerformed(ActionEvent e) {
		
		dependente.setId(Integer.parseInt(tfExcluirDependentes.getText()));
		
		dependentesDAO.excluirPorId(dependente);
		
		JOptionPane.showMessageDialog(null, "Tem Certeza que Deseja Excluir os Dependentes?");
		
		limparFormulario(tfExcluirDependentes);
		
	}

	private void limparFormulario(JTextField...formularios) {
		for (JTextField formulario : formularios) {
			formulario.setText("");
			
			}
	}

	
	private void btnCancelarActionPerformed(ActionEvent e){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
			JExcluirDependentes.this.doDefaultCloseAction();
		}
	}

}
