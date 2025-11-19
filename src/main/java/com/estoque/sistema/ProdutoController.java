package com.estoque.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    // LISTAR (Página Inicial de Produtos)
    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        model.addAttribute("listaProdutos", repository.findAll());
        return "produtos"; // Vai procurar o arquivo produtos.html
    }

    // INCLUIR (Salvar novo produto)
    @PostMapping("/produtos/salvar")
    public String salvarProduto(Produto produto) {
        repository.save(produto);
        return "redirect:/produtos";
    }

    // EXCLUIR
    @GetMapping("/produtos/excluir/{id}")
    public String excluirProduto(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/produtos";
    }

    // EDITAR (Carregar dados para editar)
    @GetMapping("/produtos/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto produto = repository.findById(id).get();
        model.addAttribute("produto", produto);
        return "editar_produto"; // Vai procurar o arquivo editar_produto.html
    }
}