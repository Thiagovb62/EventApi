package api.apievent.Controller;

import api.apievent.Model.Convidados;
import api.apievent.Model.Evento;
import api.apievent.Repository.ConvidadosRepository;
import api.apievent.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ConvidadosRepository convidadosRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento findEventoById(@PathVariable Long id) {
        return eventoRepository.findById(id).get();
    }

    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento saveE(@RequestBody  Evento evento){
        return eventoRepository.save(evento);
    }

    @PostMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public void  mergeConvidado_Evento(@PathVariable Long id ,@RequestBody  Evento evento, Convidados convidados){
        var eventoBuscado = eventoRepository.findById(id).get();
        convidados.setEvento(eventoBuscado);
        convidadosRepository.save(convidados);
        return;
    }
}
