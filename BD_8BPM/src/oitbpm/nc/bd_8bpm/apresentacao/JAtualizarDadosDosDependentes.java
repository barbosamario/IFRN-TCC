package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import oitbpm.nc.bd_8bpm.negocio.Dependente;
import oitbpm.nc.bd_8bpm.persistencia.DependentesDAO;

public class JAtualizarDadosDosDependentes extends JInternalFrame {
	private JTextField tfIdDep;
	private JTextField tfConjuge;
	private JTextField tfFilhos;
	private JTextField tfFiliacao;
	private DependentesDAO dependentesDAO;
	private Dependente dependente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAtualizarDadosDosDependentes frame = new JAtualizarDadosDosDependentes();
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
	public JAtualizarDadosDosDependentes() {
		
		dependente = new Dependente();
		dependentesDAO = new DependentesDAO();
		
		setBounds(100, 100, 422, 273);
		
		JPanel panelAtualizarDadosDosDependentes = new JPanel();
		getContentPane().add(panelAtualizarDadosDosDependentes, BorderLayout.CENTER);
		panelAtualizarDadosDosDependentes.setLayout(null);
		
		JLabel lblDigiteOId = new JLabel("Digite o Id dos Dependentes:");
		lblDigiteOId.setBounds(10, 20, 213, 14);
		panelAtualizarDadosDosDependentes.add(lblDigiteOId);
		
		JLabel lblDigiteOsDados = new JLabel("Digite os Dados Corretos dos Dependentes");
		lblDigiteOsDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDigiteOsDados.setBounds(87, 60, 314, 14);
		panelAtualizarDadosDosDependentes.add(lblDigiteOsDados);
		
		JLabel labelFilhos = new JLabel("Filhos:");
		labelFilhos.setBounds(10, 125, 46, 14);
		panelAtualizarDadosDosDependentes.add(labelFilhos);
		
		JLabel labelConjuge = new JLabel("C\u00F4njuge:");
		labelConjuge.setBounds(10, 99, 58, 14);
		panelAtualizarDadosDosDependentes.add(labelConjuge);
		
		tfIdDep = new JTextField();
		tfIdDep.setColumns(10);
		tfIdDep.setBounds(183, 18, 40, 17);
		panelAtualizarDadosDosDependentes.add(tfIdDep);
		
		tfConjuge = new JTextField();
		tfConjuge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfConjuge.setColumns(10);
		tfConjuge.setBounds(78, 97, 297, 17);
		panelAtualizarDadosDosDependentes.add(tfConjuge);
		
		tfFilhos = new JTextField();
		tfFilhos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfFilhos.setColumns(10);
		tfFilhos.setBounds(78, 123, 297, 17);
		panelAtualizarDadosDosDependentes.add(tfFilhos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(249, 193, 89, 23);
		panelAtualizarDadosDosDependentes.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
				
			}
		});
		
						
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(120, 193, 89, 23);
		panelAtualizarDadosDosDependentes.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvarActionPerformed(e);
				
			}
		});
		
		JLabel labelFiliacao = new JLabel("Filia\u00E7\u00E3o:");
		labelFiliacao.setBounds(10, 152, 46, 14);
		panelAtualizarDadosDosDependentes.add(labelFiliacao);
		
		tfFiliacao = new JTextField();
		tfFiliacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfFiliacao.setColumns(10);
		tfFiliacao.setBounds(78, 150, 297, 17);
		panelAtualizarDadosDosDependentes.add(tfFiliacao);

	}

	private void btnSalvarActionPerformed(ActionEvent e) {
		
		dependente.setId(Integer.parseInt(tfIdDep.getText()));
		dependente.setConjuge(tfConjuge.getText());
		dependente.setFilhos(tfFilhos.getText());
		dependente.setFiliacao(tfFiliacao.getText());
		
		dependentesDAO.atualizarDadosPorId(dependente);
		
		JOptionPane.showMessageDialog(null, "Cadastro Atualizado com Sucesso!");
		
		limparFormulario(tfIdDep,tfConjuge,tfFilhos,tfFiliacao);
		
	}
	
	private void btnCancelarActionPerformed(ActionEvent evt){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
			JAtualizarDadosDosDependentes.this.doDefaultCloseAction();
		}
	}

	private void limparFormulario(JTextField...formularios) {
		for (JTextField formulario : formularios) {
			formulario.setText("");
			
			}
	}

}
