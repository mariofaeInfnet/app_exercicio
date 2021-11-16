package tp1.exercicio.app_exercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tp1.exercicio.app_exercicio.model.Produto;
import tp1.exercicio.app_exercicio.repository.ProdutoRepository;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(value = "/produto/all", method = RequestMethod.GET)
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    @RequestMapping(value = "/produto/save", method = RequestMethod.GET)
    public Produto save(@RequestParam("descricao") String descricao) {
        return produtoRepository.save(descricao);
    }
    @RequestMapping(value = "produto/update", method = RequestMethod.GET)
    public Produto update(@RequestParam("codigo") Integer codigo, @RequestParam("descricao") String descricao) {
        return produtoRepository.update(codigo, descricao);
    }
    @RequestMapping(value = "produto/delete", method = RequestMethod.GET)
    public String deletar(@RequestParam("codigo") Integer codigo) {
        produtoRepository.delete(codigo);
        return "O produto " + codigo + " foi deletado com sucesso";
    }

}
