package tp1.exercicio.app_exercicio.repository;

import org.springframework.stereotype.Component;
import tp1.exercicio.app_exercicio.model.Produto;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoRepository {

    private static List<Produto> produtoList;

    static {
        produtoList = new ArrayList<>();
    }

    public Produto save(String descricao){
        Integer codigo = produtoList.size();
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao(descricao);
        produtoList.add(produto);
        return produto;
    }

    public Produto findById(Integer codigo) {
        if(codigo == null) {
            return null;
        }
        for(Produto p : produtoList){
            if(p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
    public Produto update(Integer codigo, String descricao) {
        Produto produto = findById(codigo);
        if(produto != null) {
            produto.setDescricao(descricao);
        }
        return produto;
    }
    public List<Produto> findAll() {
        return produtoList;
    }
    public void delete(Integer codigo) {
        Produto produto = findById(codigo);
        if(produto != null) {
            produtoList.remove(produto);
        }
    }
}
