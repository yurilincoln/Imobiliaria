import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.senai.sc.tinfo20132n1.imobiliaria.entity.CadastroImobiliaria;
import br.senai.sc.tinfo20132n1.imobiliaria.entity.TipoDeImovel;
public class Main {

	public static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
	entityManagerFactory = Persistence.createEntityManagerFactory("imobiliariaPu");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
//		inserirImovel(entityManager);
//		inserir(entityManager);
//		buscarPorId(entityManager);
//		listar(entityManager);
//		atualizar(entityManager);
		excluir(entityManager);

		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		entityManagerFactory.close();
		
	}

	private static void inserirImovel(EntityManager entityManager) {
		TipoDeImovel tipoDeImovel = entityManager.getReference(TipoDeImovel.class, 1L);
		CadastroImobiliaria cadastroimobiliaria;
		cadastroimobiliaria = new CadastroImobiliaria();
		cadastroimobiliaria.setEndereco("Rod. SC-403");
		cadastroimobiliaria.setNumero(5605);
		cadastroimobiliaria.setTipo("Área Industrial");
		cadastroimobiliaria.setValor(1200.000);
		entityManager.persist(cadastroimobiliaria);
		
	}
	
	private static void inserir(EntityManager entityManager) {
		
		TipoDeImovel tipoDeImovel = new TipoDeImovel();
		tipoDeImovel.setTipo("Área Industrial");
		
		CadastroImobiliaria cadastroimobiliaria;
		cadastroimobiliaria = new CadastroImobiliaria();
		cadastroimobiliaria.setEndereco("Rod. SC-403");
		cadastroimobiliaria.setNumero(5605);
		cadastroimobiliaria.setTipo("Área Industrial");
		cadastroimobiliaria.setValor(1200.000);
		cadastroimobiliaria.setTipoDeImovel(tipoDeImovel);
		entityManager.persist(cadastroimobiliaria);
	}
	
	private static void buscarPorId(EntityManager entityManager) {
		CadastroImobiliaria cadastroimobiliaria = entityManager.find(CadastroImobiliaria.class, 2L);
		System.out.println("Endereço: " + cadastroimobiliaria.getEndereco());
		System.out.println("Número da Casa: " + cadastroimobiliaria.getNumero());
	}
	
	private static void listar(EntityManager entityManager) {
		Query query = entityManager.createQuery("From CadastroImobiliaria", CadastroImobiliaria.class);
		List<CadastroImobiliaria> cadastros = query.getResultList();
		
		System.out.println("Lista de Imóveis Cadastrados:");
		for (CadastroImobiliaria cadastroimobiliaria : cadastros) {
			System.out.println("Endereço: " + cadastroimobiliaria.getEndereco());
			System.out.println("Número: " + cadastroimobiliaria.getNumero());
			System.out.println("Valor do Imóvel: " + cadastroimobiliaria.getValor() + " reais.");
			System.out.println("=-=-=-==-=-=-==-=-=-==-=-=-==-=-=-==-=-=-=");
		}
	}

	private static void atualizar(EntityManager entityManager) {
		CadastroImobiliaria cadastroimobiliaria;
		cadastroimobiliaria = new CadastroImobiliaria();
		cadastroimobiliaria.setId(1L);
		cadastroimobiliaria.setEndereco("Av. Pedro Junior");
		cadastroimobiliaria.setNumero(656);
		cadastroimobiliaria.setTipo("Prédio Residêncial");
		cadastroimobiliaria.setValor(190.000);	
		entityManager.merge(cadastroimobiliaria);
	}

	private static void excluir(EntityManager entityManager) {
		CadastroImobiliaria cadastroimobiliaria = entityManager.getReference(CadastroImobiliaria.class, 2L);
		entityManager.remove(cadastroimobiliaria);
	}

}
