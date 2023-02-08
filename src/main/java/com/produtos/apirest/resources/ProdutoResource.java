package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    @ApiOperation(value = "Lista os produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Lista um unico produto")
    public Produto listaProdutoUnico(@PathVariable long id){
        return produtoRepository.findById(id);
    }

    @PostMapping(value = "/produto")
    @ApiOperation(value = "Cria novos produtos")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping(value = "/produto")
    @ApiOperation(value = "Deleta Produtos")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }
}
