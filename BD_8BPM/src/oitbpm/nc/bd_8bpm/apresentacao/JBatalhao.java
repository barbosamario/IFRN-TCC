package oitbpm.nc.bd_8bpm.apresentacao;

import java.awt.AWTPermission;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;

import oitbpm.nc.bd_8bpm.negocio.Policial;
import oitbpm.nc.bd_8bpm.persistencia.PoliciaisDAO;
import oitbpm.nc.bd_8ºbpm.backgroundDP.JBackground;

public class JBatalhao {
	
	private JFrame frame;
	private JBackground desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JBatalhao janela = new JBatalhao();
					janela.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JBatalhao() {
		initialize();
	}
		
		private  void initialize(){
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setTitle("Banco de Dados do 8º BPM");
		frame.setBounds(100,100,900,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0,0));
		
		desktopPane = new JBackground();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);
			
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar,BorderLayout.NORTH);
		
		JMenu mnInserir = new JMenu("Inserir");
		menuBar.add(mnInserir);
		
		JMenuItem mntmPolicial_1 = new JMenuItem("Policial");
		mntmPolicial_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPolicial_1ActionPerformed(e);
			}
		});
		mnInserir.add(mntmPolicial_1);
		
		JMenuItem mntmDependentes_1 = new JMenuItem("Dependentes");
		mntmDependentes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmDependentes_1ActionPerformed(e);
			}
		});
		mnInserir.add(mntmDependentes_1);
		
		JMenu mnLocalizar = new JMenu("Localizar");
		menuBar.add(mnLocalizar);
		
		JMenu mnPolicial_1 = new JMenu("Policiais");
		mnLocalizar.add(mnPolicial_1);
		
		JMenuItem mntmPorId = new JMenuItem("Por Id");
		mntmPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPorIdActionPerformed(e);
			}
		});
		mnPolicial_1.add(mntmPorId);
		
		JMenuItem mntmPorListaGeral = new JMenuItem("Por Lista Geral");
		mntmPorListaGeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPorListaGeralActionPerformed(e);
			}
		});
		mnPolicial_1.add(mntmPorListaGeral);
		
		JMenu mnDependentes_1 = new JMenu("Dependentes");
		mnLocalizar.add(mnDependentes_1);
		
		JMenuItem mntmPorId_1 = new JMenuItem("Por Id");
		mntmPorId_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPorId_1ActionPerformed(e);
			}
		});
		mnDependentes_1.add(mntmPorId_1);
		
		JMenuItem mntmGeral_1 = new JMenuItem("Por Lista Geral");
		mntmGeral_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmGeral_1ActionPerformed(e);
				
			}
		});
		mnDependentes_1.add(mntmGeral_1);
		
		JMenu mnAtualizar = new JMenu("Atualizar");
		menuBar.add(mnAtualizar);
		
		JMenuItem mnPolicial_2 = new JMenuItem("Policial");
		mnPolicial_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnPolicial_2ActionPerformed(e);
			}
		});
		mnAtualizar.add(mnPolicial_2);
		
		JMenuItem mnDependentes_2 = new JMenuItem("Dependentes");
		mnDependentes_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnDependentes_2ActionPerformed(e);
			}
		});
		
		mnAtualizar.add(mnDependentes_2);
		
		JMenu mnExcluir = new JMenu("Excluir");
		menuBar.add(mnExcluir);
		
		JMenuItem mntmPolicial = new JMenuItem("Policial");
		mntmPolicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPolicialActionPerformed(e);
				
			}
		});
		mnExcluir.add(mntmPolicial);
		
		JMenuItem mntmDependentes = new JMenuItem("Dependentes");
		mntmDependentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmDependentesActionPerformed(e);
				
			}
		});
		mnExcluir.add(mntmDependentes);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		JMenuItem mntmImprimir = new JMenuItem("Imprimir");
		mnOpes.add(mntmImprimir);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Deseja sair da aplicação?");
			
				System.exit(0);
			}
		});
		mnOpes.add(mntmSair);
	}

	private void mntmDependentesActionPerformed(ActionEvent e) {
		JExcluirDependentes ed = new JExcluirDependentes();
		desktopPane.add(ed);
		ed.setVisible(true);
			
	}

	private void mntmPolicialActionPerformed(ActionEvent e) {
		JExcluirPolicial ep = new JExcluirPolicial();
		desktopPane.add(ep);
		ep.setVisible(true);
	}

	private void mnDependentes_2ActionPerformed(ActionEvent e) {
		JAtualizarDadosDosDependentes addep = new JAtualizarDadosDosDependentes();
		desktopPane.add(addep);
		addep.setVisible(true);
	}

	private void mnPolicial_2ActionPerformed(ActionEvent e) {
		JAtualizarDadosDoPM adpm = new JAtualizarDadosDoPM();
		desktopPane.add(adpm);
		adpm.setVisible(true);
	}

	private void mntmPorId_1ActionPerformed(ActionEvent e) {
		JLocalizarDependentesPorId ldpid = new JLocalizarDependentesPorId();
		desktopPane.add(ldpid);
		ldpid.setVisible(true);
	}

	private void mntmGeral_1ActionPerformed(ActionEvent e) {
		JLocalizarDependentesPorListaGeral ldplg = new JLocalizarDependentesPorListaGeral();
		desktopPane.add(ldplg);
		ldplg.setVisible(true);
	}

	private void mntmPorIdActionPerformed(ActionEvent e) {
		JLocalizarPolicialPorId lppid = new JLocalizarPolicialPorId();
		desktopPane.add(lppid);
		lppid.setVisible(true);
	}

	private void mntmPorListaGeralActionPerformed(ActionEvent e) {
		JLocalizarPolicialPorListaGeral lpplg = new JLocalizarPolicialPorListaGeral();
		desktopPane.add(lpplg);
		lpplg.setVisible(true);
	}

	private void mntmDependentes_1ActionPerformed(ActionEvent e) {
		JInserirDependentes insdep = new JInserirDependentes();
		desktopPane.add(insdep);
		insdep.setVisible(true);
	}

	private void mntmPolicial_1ActionPerformed(ActionEvent e){
		JInserirPolicial inspol = new JInserirPolicial();
		desktopPane.add(inspol);
		inspol.setVisible(true);
	}
	
}
