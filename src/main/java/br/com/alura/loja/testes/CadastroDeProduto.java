package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto p = produtoDao.buscaPeloId(1L);
		System.out.println(p.getPreco());

		List<Produto> todos = produtoDao.buscaTodos();
		todos.forEach(produto -> System.out.println(produto.getNome()));

		List<Produto> porNome = produtoDao.buscarPeloNome("Xiaomi Redmi");
		porNome.forEach(produto -> System.out.println(produto.getDataAbertura()));

		List<Produto> porCategoria = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		porCategoria.forEach(produto -> System.out.println(produto.getNome()));

		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoPeloNome("Xiaomi Redmi");
		System.out.println(precoDoProduto);

	}

	public static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);

		em.getTransaction().commit();
		em.close();
	}

}
