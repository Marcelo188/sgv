package br.com.sgv.controller;

import br.com.sgv.model.Funcionarios;
import br.com.sgv.model.Item;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.sgv.repository.FuncionariosRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class PessoaFisicaController
 */
@Controller
public class FuncionariosController {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @GetMapping("/funcionarios")
    public String listarFuncionarios(Model model) {
        model.addAttribute("listaFuncionarios", funcionariosRepository.findAll());
        return "gerenciar_funcionarios";
    }

    @GetMapping("/funcionarios/novo")
    public String novo(Model model) {
        model.addAttribute("funcionarios", new Funcionarios());
        return "editar_funcionarios";
    }

    @GetMapping("/funcionarios/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Funcionarios> pessoaFisica = funcionariosRepository.findById(id);
        model.addAttribute("funcionarios", pessoaFisica.get());
        return "editar_funcionarios";
    }

    @PostMapping("/funcionarios")
    public String salvar(@Valid Funcionarios funcionarios, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_funcionarios";
        }
        funcionariosRepository.save(funcionarios);
        return "redirect:/funcionarios";
    }

    @DeleteMapping("/funcionarios/{id}")
    public String excluir(@PathVariable("id") long id) {
        funcionariosRepository.deleteById(id);
        return "redirect:/funcionarios";
    }
}
