package com.gennadziy.DEMO_REST;

import com.gennadziy.DEMO_REST.model.Autoss;
import com.gennadziy.DEMO_REST.service.AutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


@Controller
public class Contr {

    @Autowired
    private AutosService autosService;

    @GetMapping("/")
    public String allAuto(Model model, @RequestParam( name="name", required = false, defaultValue = "Hello") String name) throws FileNotFoundException {
        File file=new File ( "c:/11.txt" );
        List<Autoss> auto=autosService.all ();
        model.addAttribute ( "auto",auto );
        PrintWriter pw=new PrintWriter ( file);
        pw.println ( autosService.all () );
        pw.close ();
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String deleteAuto( @PathVariable("id") int id ){
        autosService.delete ( id );
        return "redirect:/";
    }
    @GetMapping("/new")
    public String add(){
        return "new";
    }
    @PostMapping("/save")
    public String addStudent( Autoss autoss) {
        if(autoss==null ){
            return "new";
        }
        autosService.save ( autoss );
        return "redirect:/";
    }
}
