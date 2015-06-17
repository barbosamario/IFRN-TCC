package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import oitbpm.nc.bd_8bpm.negocio.Dependente;
import oitbpm.nc.bd_8bpm.persistencia.DependentesDAO;


public class JLocalizarDependentesPorId extends JInternalFrame {
	private JTextField tfInsDepPM;
	private JTable table;
	private Dependente dependente;
	private DependentesDAO dependentesDAO;
	private DefaultTableModel modelo;
	private TextField tfInsIdPm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLocalizarDependentesPorId frame = new JLocalizarDependentesPorId();
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
	public JLocalizarDependentesPorId() {
		
		dependente = new Dependente();
		dependentesDAO = new DependentesDAO();
		
		setBounds(100, 100, 450, 300);
		
		JPanel panelPesqDepPorId = new JPanel();
		getContentPane().add(panelPesqDepPorId, BorderLayout.NORTH);
		
		JLabel labelDigIdPm = new JLabel("Digite o ID do Policial:");
		
		tfInsDepPM = new JTextField();
		tfInsDepPM.setColumns(4);
		
				
		Button btnPesqDepId = new Button("Pesquisar");
		btnPesqDepId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPesqDepId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesqDepIdActionPerformed(e);
			}
		});
				
				
		JButton btnCancelar = new JButton("Cancelar");
		panelPesqDepPorId.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnCancelarActionPerformed(evt);
			}
		});
		
		
		
		GroupLayout gl_panelPesqDepPorId = new GroupLayout(panelPesqDepPorId);
		gl_panelPesqDepPorId.setHorizontalGroup(
			gl_panelPesqDepPorId.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesqDepPorId.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelDigIdPm, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfInsDepPM, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesqDepId, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnCancelar)
					.addGap(23))
		);
		gl_panelPesqDepPorId.setVerticalGroup(
			gl_panelPesqDepPorId.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesqDepPorId.createSequentialGroup()
					.addGroup(gl_panelPesqDepPorId.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesqDepPorId.createSequentialGroup()
							.addGap(9)
							.addComponent(labelDigIdPm))
						.addGroup(gl_panelPesqDepPorId.createSequentialGroup()
							.addGap(6)
							.addComponent(tfInsDepPM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelPesqDepPorId.createSequentialGroup()
							.addGap(5)
							.addComponent(btnCancelar))
						.addGroup(gl_panelPesqDepPorId.createSequentialGroup()
							.addGap(5)
							.addComponent(btnPesqDepId)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelPesqDepPorId.setLayout(gl_panelPesqDepPorId);
		
		JPanel panelTabela = new JPanel();
		getContentPane().add(panelTabela, BorderLayout.CENTER);
		panelTabela.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(0, 0, 434, 231);
		panelTabela.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "C\u00F4njuge", "Filhos", "Filia\u00E7\u00E3o"
			}
		));
		table.setBackground(Color.WHITE);
		table.setEnabled(false);
		scrollPane.setViewportView(table);

	}

	private void btnCancelarActionPerformed(ActionEvent evt){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
				JLocalizarDependentesPorId.this.doDefaultCloseAction();
		}
	}


	private void btnPesqDepIdActionPerformed(ActionEvent e) {
			modelo = (DefaultTableModel) table.getModel();
			
			while (modelo.getRowCount() > 0){
				modelo.removeRow(0);
			}
			
			dependente.setId(Integer.parseInt(tfInsDepPM.getText()));
			
			dependente = dependentesDAO.buscarPorCodigo(dependente);
			
			Object[] linha = {
					dependente.getId(), dependente.getConjuge(), dependente.getFilhos(), dependente.getFiliacao()
			};
			
			modelo.addRow(linha);
			
			tfInsDepPM.setText("");
			
			}

}
