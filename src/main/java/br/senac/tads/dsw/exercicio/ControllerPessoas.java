package br.senac.tads.dsw.exercicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lucas vinicius
 */
@Controller
public class ControllerPessoas {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    List<InformacoesPessoais> lista = new ArrayList<>();
    
    
    @GetMapping("/Cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView("CadastrarPessoas");
        InformacoesPessoais infoPessoais = new InformacoesPessoais();
        mv.addObject("InformacoesPessoais", infoPessoais);
        return mv;
        
    }
    @PostMapping("/Salvar")
    public ModelAndView salvarDados(@ModelAttribute InformacoesPessoais dados){
        InformacoesPessoais info = new InformacoesPessoais();
        info.setNome(dados.getNome());
        info.setEmail(dados.getEmail());
        info.setDataNascimento(dados.getDataNascimento());
        lista.add(info);
        
        ModelAndView mv = new ModelAndView("ListagemPessoas");
        mv.addObject("itens", lista);
        mv.addObject("Sucesso", true);
        mv.addObject("nome",dados.getNome());
        return mv;
    }
    
    @GetMapping("/Listar")
    public ModelAndView listar(@RequestParam(value="apresentacao", defaultValue="tabela") String modoApresentacao){
        ModelAndView mv = new ModelAndView("ListagemPessoas");
        mv.addObject("itens", lista);
        return mv;
    }
    
}
