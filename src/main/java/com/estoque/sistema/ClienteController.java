package com.estoque.sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    @Autowired private ClienteRepository repository;

    @GetMapping("/clientes")
    public String listar(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "clientes";
    }

    @PostMapping("/clientes/salvar")
    public String salvar(Cliente cliente) {
        repository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", repository.findById(id).get());
        return "editar_cliente";
    }
}