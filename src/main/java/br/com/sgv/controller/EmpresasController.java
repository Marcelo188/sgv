package br.com.sgv.controller;

import br.com.sgv.model.Empresas;
import br.com.sgv.repository.EmpresasRepository;
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

@Controller
public class EmpresasController {

    @Autowired
    private EmpresasRepository empresasRepository;

    @GetMapping("/empresas")
    public String listarEmpresas(Model model) {
        model.addAttribute("listaEmpresas", empresasRepository.findAll());
        return "gerenciar_empresas";
    }

    @GetMapping("/empresas/novo")
    public String novaEmpresa(Model model) {
        model.addAttribute("empresas", new Empresas());
        return "editar_empresas";
    }

    @GetMapping("/empresas/{id}")
    public String editarEmpresa(@PathVariable("id") long id, Model model) {
        Optional<Empresas> empresa = empresasRepository.findById(id);
        model.addAttribute("empresas", empresa.get());
        return "editar_empresas";
    }

    @PostMapping("/empresas")
    public String salvarEmpresa(@Valid Empresas empresa, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_empresas";
        }
        empresasRepository.save(empresa);
        return "redirect:/empresas";
    }

    @DeleteMapping("/empresas/{id}")
    public String excluirEmpresa(@PathVariable("id") long id) {
        empresasRepository.deleteById(id);
        return "redirect:/empresas";
    }
}