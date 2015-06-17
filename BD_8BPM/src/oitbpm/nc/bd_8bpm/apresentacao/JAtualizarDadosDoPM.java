package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import oitbpm.nc.bd_8bpm.negocio.Policial;
import oitbpm.nc.bd_8bpm.persistencia.PoliciaisDAO;

public class JAtualizarDadosDoPM extends JInternalFrame {
	private JTextField tfIdPM;
	private JTextField tfNomeDoPm;
	private JTextField tfMatriculaDoPM;
	private Policial policial;
	private PoliciaisDAO policiaisDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAtualizarDadosDoPM frame = new JAtualizarDadosDoPM();
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
	public JAtualizarDadosDoPM() {
		
		policial = new Policial();
		policiaisDAO = new PoliciaisDAO();
		
		setBounds(100, 100, 412, 230);
		setTitle("Atualizar Dados do Policial");
		getContentPane().setLayout(null);
		
		JPanel panelAtualizarDadosdoPM = new JPanel();
		panelAtualizarDadosdoPM.setBounds(0, 0, 396, 200);
		getContentPane().add(panelAtualizarDadosdoPM, BorderLayout.CENTER);
		panelAtualizarDadosdoPM.setLayout(null);
		
		JLabel labelIdDoPM = new JLabel("Digite o Id do Policial:");
		labelIdDoPM.setBounds(10, 11, 177, 14);
		panelAtualizarDadosdoPM.add(labelIdDoPM);
		
		JLabel labelNomeDoPM = new JLabel("Digite os Dados Corretos do Policial");
		labelNomeDoPM.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNomeDoPM.setBounds(96, 49, 251, 14);
		panelAtualizarDadosdoPM.add(labelNomeDoPM);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 89, 46, 14);
		panelAtualizarDadosdoPM.add(labelNome);
		
		JLabel labelMatricula = new JLabel("Matr\u00EDcula:");
		labelMatricula.setBounds(10, 114, 58, 14);
		panelAtualizarDadosdoPM.add(labelMatricula);
		
		tfIdPM = new JTextField();
		tfIdPM.setBounds(138, 11, 38, 17);
		panelAtualizarDadosdoPM.add(tfIdPM);
		tfIdPM.setColumns(10);
		
		tfNomeDoPm = new JTextField();
		tfNomeDoPm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfNomeDoPm.setBounds(76, 87, 297, 17);
		panelAtualizarDadosdoPM.add(tfNomeDoPm);
		tfNomeDoPm.setColumns(10);
		
		tfMatriculaDoPM = new JTextField();
		tfMatriculaDoPM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfMatriculaDoPM.setBounds(76, 112, 297, 17);
		panelAtualizarDadosdoPM.add(tfMatriculaDoPM);
		tfMatriculaDoPM.setColumns(10);
				
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(215, 152, 89, 23);
		panelAtualizarDadosdoPM.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(116, 152, 89, 23);
		panelAtualizarDadosdoPM.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvarActionPerformed(e);
			}
		});
		
	}

	private void btnSalvarActionPerformed(ActionEvent e) {
		
		policial.setId(Integer.parseInt(tfIdPM.getText()));
		policial.setNome(tfNomeDoPm.getText());
		policial.setMatricula(tfMatriculaDoPM.getText());
		
		policiaisDAO.atualizarDadosPorId(policial);
		
		JOptionPane.showMessageDialog(null, "Cadastro Atualizado com Sucesso!");
		
		limparFormulario(tfIdPM,tfNomeDoPm,tfMatriculaDoPM);
		
	}
	
	private void btnCancelarActionPerformed(ActionEvent evt){
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Cancelar a Operação?", "Aviso!", JOptionPane.YES_NO_OPTION) == 0){
			JAtualizarDadosDoPM.this.doDefaultCloseAction();
		}
	}

	private void limparFormulario(JTextField...formularios) {
		for (JTextField formulario : formularios) {
			formulario.setText("");
			
			}
	}
}
