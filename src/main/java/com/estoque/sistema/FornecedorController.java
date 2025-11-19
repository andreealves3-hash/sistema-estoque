package com.estoque.sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FornecedorController {
    @Autowired private FornecedorRepository repository;

    @GetMapping("/fornecedores")
    public String listar(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "fornecedores";
    }

    @PostMapping("/fornecedores/salvar")
    public String salvar(Fornecedor fornecedor) {
        repository.save(fornecedor);
        return "redirect:/fornecedores";
    }

    @GetMapping("/fornecedores/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/fornecedores";
    }

    @GetMapping("/fornecedores/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("fornecedor", repository.findById(id).get());
        return "editar_fornecedor";
    }
}