package oitbpm.nc.bd_8bpm;

import java.util.List;
import java.util.Scanner;

import oitbpm.nc.bd_8bpm.negocio.Dependente;
import oitbpm.nc.bd_8bpm.negocio.Policial;
import oitbpm.nc.bd_8bpm.persistencia.DependentesDAO;
import oitbpm.nc.bd_8bpm.persistencia.PoliciaisDAO;

/**
 * 
 * @author MARIO
 *
 */
public class Teste {

	public static void main(String[] args) {
		
		PoliciaisDAO policiaisDAO = new PoliciaisDAO();

		Scanner leitor = new Scanner(System.in);
		int opcao = 0;
		do {

			System.out.println("DIGITE A OP��O QUE DESEJAR:\n");
			System.out.println("0 - Sair;");
			System.out.println("1 - Inserir Policial;");
			System.out.println("2 - Listar Policiais;");
			System.out.println("3 - Excluir Policial;");
			System.out.println("4 - Atualizar Dados do Policial;");
			System.out.println("5 - Verificar Policial por Id;");
			System.out.println("6 - Inserir Dependentes;");
			System.out.println("7 - Excluir Dependentes;");
			System.out.println("8 - Listar Dependentes;");
			System.out.println("9 - Listar Dependentes por Id;");
			System.out.println("10 - Atualizar Dados dos Dependentes.");
			

			opcao = leitor.nextInt();
			leitor.nextLine();

			switch (opcao) {
			
			case 1:
				
				System.out.println("******************************************");
				System.out.println("Digite o Nome e a Matr�cula do Policial:");
				
				String nome = leitor.nextLine();
				String matricula = leitor.nextLine();
				
				Policial policiais = new Policial();
				policiais.setNome(nome);
				policiais.setMatricula(matricula);
								
				policiaisDAO.inserir(policiais);
				
				System.out.println("******************************************");
				break;
			
			case 2:
			
				System.out.println("******************************************");
				System.out.println("Lista de Policiais j� Cadastrados:\n");
			
				List<Policial> policiais1 = policiaisDAO.buscarTodos();
				for(Policial e : policiais1){
					System.out.println("Id : " + e.getId()
							+ " - Policial : " + e.getNome()
							+ " - Matr�cula : " +e.getMatricula());
				}
				
				System.out.println("******************************************");				
				break;
			
			case 3:
			
				System.out.println("******************************************");
				System.out.println("Deseja Excluir Algum Policial? 1 para SIM ou qualquer outro para N�O.");
			
				int escolha = leitor.nextInt();
				if(escolha == 1){
					System.out.println("Digite o ID do Policial a ser exclu�do: ");
					int id = leitor.nextInt();
					
					Policial policiaisExcluidos = new Policial();
					policiaisExcluidos.setId(id);
				
					policiaisDAO.excluirPorId(policiaisExcluidos);
				}
				
				System.out.println("******************************************");
				break;
			
			case 4:
			
				System.out.println("******************************************");
				System.out.println("Digite o Nome, a Matr�cula e o Id Corretos do Policial:");
				
				String nome1 = leitor.nextLine();
				String matricula1 = leitor.nextLine();
				int id1 = leitor.nextInt();
				
				Policial policiais11 = new Policial();
				
				policiais11.setNome(nome1);
				policiais11.setMatricula(matricula1);
				policiais11.setId(id1);
				policiaisDAO.atualizarDadosPorId(policiais11);
				
				System.out.println("******************************************");
				break;
			
			case 5:
			
				System.out.println("******************************************");
				System.out.println("Digite o Id do Policial: ");
				
				policiais = new Policial();
				policiais.setId(leitor.nextInt());
				
				policiais = policiaisDAO.buscarPorCodigo(policiais);
				
				System.out.println("ID: "+ policiais.getId() 
						+ " - Nome: " + policiais.getNome()
						+ " - Matr�cula: " + policiais.getMatricula());
				
				System.out.println("******************************************");
				break;
			
			case 6:
			
				System.out.println("******************************************");
				System.out.println("Digite o Nome do Conjuge(a) do Policial: ");
				String conjuge = leitor.nextLine();
				
				System.out.println("Digite o Nome dos Filhos do Policial: ");
				String filhos = leitor.nextLine();
				
				System.out.println("Digite o nome dos Pais do Policial: ");
				String filiacao = leitor.nextLine();
				
				System.out.println("Digite o C�digo do Policial: ");
				int codigo = leitor.nextInt();
				
				Policial responsavel = new Policial();
				responsavel.setId(codigo);
				leitor.nextLine();
								
				Dependente dependente = new Dependente();
				dependente.setConjuge(conjuge);
				dependente.setFilhos(filhos);
				dependente.setFiliacao(filiacao);
				
				dependente.setResponsavel(responsavel);
				
				DependentesDAO dependentesDAO1 = new DependentesDAO();
				dependentesDAO1.inserir(dependente);
				
				System.out.println("******************************************");
				break;
				
			case 7:
				
				DependentesDAO dependentesDAO2 = new DependentesDAO();
				System.out.println("******************************************");
				System.out.println("Deseja Excluir Algum Dependente(s)? 1 para SIM ou qualquer outro para N�O.");
				int escolha2 = leitor.nextInt();
				 	leitor.nextLine();
				if(escolha2 == 1){
					System.out.println("Digite o ID do Policial a qual deseja excluir seus dependentes: ");
				
					Dependente dep = new Dependente();
					Policial pol = new Policial();
					pol.setId(leitor.nextInt());
					leitor.nextLine();
					dep.setResponsavel(pol);
					
					dependentesDAO2.excluirPorId(dep);
				}
					
				break;
				
			case 8:
				
				DependentesDAO dependentesDAO = new DependentesDAO();
				
				System.out.println("******************************************");
				System.out.println("Lista de Dependentes j� Cadastrados:\n");
				
				List<Dependente> dependentes1 = dependentesDAO.buscarTodos();
				for(Dependente e : dependentes1){
						System.out.println("C�digo: " + e.getResponsavel().getId() 
								+ " - C�njuge: " + e.getConjuge()
								+ " - Filho(s): " + e.getFilhos() 
								+ " - Filia��o: " + e.getFiliacao());
					}
				
				System.out.println("******************************************");				
				break;
			
			case 9:
			
				System.out.println("******************************************");
				
				dependente = new Dependente();
				dependentesDAO = new DependentesDAO();
				
				System.out.println("Digite o Id do Policial: ");
				dependente.setId(leitor.nextInt());
				leitor.nextLine();
				
				dependente = dependentesDAO.buscarPorCodigo(dependente);
														
				System.out.println("ID: "+ dependente.getId()
						+ " - C�njuge: " + dependente.getConjuge()
						+ " - Filho(s): " + dependente.getFilhos()
						+ " - Filia��o: " + dependente.getFiliacao());
				
				System.out.println("******************************************");
				break;
			
			case 10:
			
				System.out.println("******************************************");
				dependente = new Dependente();
				
				dependentesDAO = new DependentesDAO();
			
				System.out.println("Digite o Id do Policial:");
				dependente.setId(leitor.nextInt());
				leitor.nextLine();
				
				System.out.println("Digite corretamente o nome do C�njuge, do(s) filho(s) e a Filia��o: ");
				
				dependente.setConjuge(leitor.nextLine());
				dependente.setFilhos(leitor.nextLine());
				dependente.setFiliacao(leitor.nextLine());
				dependentesDAO.atualizarDadosPorId(dependente);
				break;
			default:
			}
			
		} while (opcao != 0);
		leitor.close();

	}
}