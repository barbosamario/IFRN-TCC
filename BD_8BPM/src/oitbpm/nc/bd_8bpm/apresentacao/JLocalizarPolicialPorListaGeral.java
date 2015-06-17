package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import oitbpm.nc.bd_8bpm.negocio.Policial;
import oitbpm.nc.bd_8bpm.persistencia.PoliciaisDAO;

import java.awt.Color;
import java.util.List;

public class JLocalizarPolicialPorListaGeral extends JInternalFrame {
	private final Panel panelBotaodePesquisa = new Panel();
	private JTable table;
	private DefaultTableModel modelo;
	private PoliciaisDAO policiaisDAO;
	private Policial policial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLocalizarPolicialPorListaGeral frame = new JLocalizarPolicialPorListaGeral();
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
	public JLocalizarPolicialPorListaGeral() {
		
		policial = new Policial();
		policiaisDAO = new PoliciaisDAO();
		
		setBounds(100, 100, 376, 306);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		getContentPane().add(panelBotaodePesquisa, BorderLayout.NORTH);
		
		JButton btnPesquisarPoliciais = new JButton("Pesquisar Policiais");
		panelBotaodePesquisa.add(btnPesquisarPoliciais);
		btnPesquisarPoliciais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnPesquisarPoliciais(evt);
			}
		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		panelBotaodePesquisa.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnCancelarActionPerformed(evt);
			}
		});
		
			
		Panel panelTabela = new Panel();
		getContentPane().add(panelTabela, BorderLayout.CENTER);
		panelTabela.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		panelTabela.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Matr\u00EDcula"
			}
		));
		table.setEnabled(false);
		scrollPane.setViewportView(table);

	}
	
	private void btnCancelarActionPerformed(ActionEvent evt){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
				JLocalizarPolicialPorListaGeral.this.doDefaultCloseAction();
		}
	}

	private void btnPesquisarPoliciais(ActionEvent evt){
		
		modelo = (DefaultTableModel) table.getModel();
			
		while(table.getRowCount() > 0) {	
			modelo.removeRow(0);
		}
		
		
		List<Policial> policiais1 = policiaisDAO.buscarTodos();
		
		for(Policial e : policiais1){
			Object [] linha = {e.getId(), e.getNome(), e.getMatricula()};
			modelo.addRow(linha);
		}
					
	}
}
