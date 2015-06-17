package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import oitbpm.nc.bd_8bpm.negocio.Policial;
import oitbpm.nc.bd_8bpm.persistencia.PoliciaisDAO;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JExcluirPolicial extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JExcluirPolicial frame = new JExcluirPolicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private PoliciaisDAO policiaisDAO;
	private Policial policial;
	private JTextField tfExcluirPolicial;

	/**
	 * Create the frame.
	 */
	public JExcluirPolicial() {
		
		policial = new Policial();
		policiaisDAO = new PoliciaisDAO();
		
		setBounds(100, 100, 330, 122);
		
		JPanel panelExcluirPolicial = new JPanel();
		getContentPane().add(panelExcluirPolicial, BorderLayout.CENTER);
		panelExcluirPolicial.setLayout(null);
		
		JLabel lblDigiteOId = new JLabel("Digite o Id do Policial que Deseja Excluir:");
		lblDigiteOId.setBounds(10, 14, 317, 14);
		panelExcluirPolicial.add(lblDigiteOId);
		
		tfExcluirPolicial = new JTextField();
		tfExcluirPolicial.setBounds(254, 11, 50, 20);
		panelExcluirPolicial.add(tfExcluirPolicial);
		tfExcluirPolicial.setColumns(10);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(169, 58, 89, 23);
		panelExcluirPolicial.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(70, 58, 89, 23);
		panelExcluirPolicial.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvarActionPerformed(e);
				
			}
		});
		
						
	}

	private void btnSalvarActionPerformed(ActionEvent e) {
		
		policial.setId(Integer.parseInt(tfExcluirPolicial.getText()));
		
		policiaisDAO.excluirPorId(policial);
		
		JOptionPane.showMessageDialog(null, "Tem Certeza que Deseja Excluir o Policial?");
		
		limparFormulario(tfExcluirPolicial);
		
	}

	private void limparFormulario(JTextField...formularios) {
		for (JTextField formulario : formularios) {
			formulario.setText("");
			
			}
	}

	private void btnCancelarActionPerformed(ActionEvent e){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
			JExcluirPolicial.this.doDefaultCloseAction();
		}
	}
}
