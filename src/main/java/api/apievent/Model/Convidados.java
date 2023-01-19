package api.apievent.Model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "convidados")
public class Convidados {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;


    public Convidados() {
    }

    public Convidados(String nome) {
        this.nome = nome;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}
