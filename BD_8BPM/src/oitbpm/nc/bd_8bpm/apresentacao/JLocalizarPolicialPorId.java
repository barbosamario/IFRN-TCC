package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oitbpm.nc.bd_8bpm.negocio.Policial;
import oitbpm.nc.bd_8bpm.persistencia.PoliciaisDAO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class JLocalizarPolicialPorId extends JInternalFrame {
	private JTable table;
	private Policial policial;
	private PoliciaisDAO policiaisDAO;
	private DefaultTableModel modelo;
	private TextField tfInsIdPm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLocalizarPolicialPorId frame = new JLocalizarPolicialPorId();
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
	public JLocalizarPolicialPorId() {
		
		policial = new Policial();
		policiaisDAO = new PoliciaisDAO();
		
		setBounds(100, 100, 450, 252);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel panelPesqPmPorId = new Panel();
		getContentPane().add(panelPesqPmPorId, BorderLayout.NORTH);
		
		Label labelDigIdPm = new Label("Digite o Id do Policial:");
		
		tfInsIdPm = new TextField();
		tfInsIdPm.setColumns(3);
				
		Button btnPesqPmId = new Button("Pesquisar");
		btnPesqPmId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPesqPmId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesqPmIdActionPerformed(e);
			}
		});
				
		
		JButton btnCancelar = new JButton("Cancelar");
		panelPesqPmPorId.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				btnCancelarActionPerformed(evt);
			}
		});
		
		
		GroupLayout gl_panelPesqPmPorId = new GroupLayout(panelPesqPmPorId);
		gl_panelPesqPmPorId.setHorizontalGroup(
			gl_panelPesqPmPorId.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesqPmPorId.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelDigIdPm, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfInsIdPm, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPesqPmId, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(76))
		);
		gl_panelPesqPmPorId.setVerticalGroup(
			gl_panelPesqPmPorId.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesqPmPorId.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelPesqPmPorId.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPesqPmId, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, Alignment.TRAILING)
						.addComponent(tfInsIdPm, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelDigIdPm, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelPesqPmPorId.setLayout(gl_panelPesqPmPorId);
		
		Panel panelTabela = new Panel();
		getContentPane().add(panelTabela, BorderLayout.CENTER);
		panelTabela.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		panelTabela.add(scrollPane);
		
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
				JLocalizarPolicialPorId.this.doDefaultCloseAction();
		}
	}

	private void btnPesqPmIdActionPerformed(ActionEvent e) {
		modelo = (DefaultTableModel) table.getModel();
		
		while (modelo.getRowCount() > 0){
			modelo.removeRow(0);
		}
		
		policial.setId(Integer.parseInt(tfInsIdPm.getText()));
		
		policial = policiaisDAO.buscarPorCodigo(policial);
		
		Object[] linha = {
				policial.getId(), policial.getNome(), policial.getMatricula()
		};
		
		modelo.addRow(linha);
		
		tfInsIdPm.setText("");
		
		}

}
