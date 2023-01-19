package api.apievent.Controller;

import api.apievent.Model.Convidados;
import api.apievent.Repository.ConvidadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/convidados")
public class ConvidadoController {


    @Autowired
    private ConvidadosRepository convidadosRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Convidados getConvidados(@PathVariable Long id) {
        return  convidadosRepository.findById(id).get();
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Convidados> findall(){
        var result = convidadosRepository.findAll();
        return result;
    }

    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Convidados save(@RequestBody  Convidados convidados){
        var result = convidadosRepository.save(convidados);
        return result;
    }


}
