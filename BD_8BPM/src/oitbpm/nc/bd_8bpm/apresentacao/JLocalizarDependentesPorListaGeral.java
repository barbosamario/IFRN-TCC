package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import java.awt.Component;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oitbpm.nc.bd_8bpm.negocio.Dependente;
import oitbpm.nc.bd_8bpm.negocio.Policial;
import oitbpm.nc.bd_8bpm.persistencia.DependentesDAO;

public class JLocalizarDependentesPorListaGeral extends JInternalFrame {
	private JTable table;
	private DependentesDAO dependentesDAO;
	private Dependente dependente;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLocalizarDependentesPorListaGeral frame = new JLocalizarDependentesPorListaGeral();
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
	public JLocalizarDependentesPorListaGeral() {
		
		dependente = new Dependente();
		dependentesDAO = new DependentesDAO();
		
		setBounds(100, 100, 450, 300);
		setTitle("Localizar Dependentes por Lista Geral");
		
		JPanel panelBotaoDePesquisa = new JPanel();
		getContentPane().add(panelBotaoDePesquisa, BorderLayout.NORTH);
		
		JButton btnPesquisarDependentes = new JButton("Pesquisar Dependentes");
		panelBotaoDePesquisa.add(btnPesquisarDependentes);
		btnPesquisarDependentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnPesquisarDependentesActionPermormed(evt);
			}
		});
				
		JButton btnCancelar = new JButton("Cancelar");
		panelBotaoDePesquisa.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCancelarActionPermormed(evt);
				
			}
		});
		
		JPanel panelTabela = new JPanel();
		getContentPane().add(panelTabela, BorderLayout.CENTER);
		panelTabela.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		panelTabela.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id do Policial", "C\u00F4njuge", "Filhos", "Filia\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);

	}
	
	private void btnCancelarActionPermormed(ActionEvent evt){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
				JLocalizarDependentesPorListaGeral.this.doDefaultCloseAction();
		}
	}

	private void btnPesquisarDependentesActionPermormed(ActionEvent evt) {
		modelo = (DefaultTableModel) table.getModel();
		
		while(table.getRowCount() > 0) {	
			modelo.removeRow(0);
		}
		
		
		List<Dependente> dependente = dependentesDAO.buscarTodos();
		
		for(Dependente e : dependente){
			Object [] linha = {e.getResponsavel().getId(), e.getConjuge(), e.getFilhos(), e.getFiliacao()};
			modelo.addRow(linha);
		}
	
		
	}

}
