package api.apievent.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String local;
    private String data;
    private String horario;

    @OneToMany(mappedBy = "evento")
    private List<Convidados> convidados;

    public Evento() {
    }

    public Evento(String nome, String local, String data, String horario) {
        this.nome = nome;
        this.local = local;
        this.data = data;
        this.horario = horario;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento evento)) return false;
        return getId().equals(evento.getId()) && getNome().equals(evento.getNome()) && Objects.equals(getLocal(), evento.getLocal()) && Objects.equals(getData(), evento.getData()) && Objects.equals(getHorario(), evento.getHorario()) && convidados.equals(evento.convidados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getLocal(), getData(), getHorario(), convidados);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", convidados=" + convidados +
                '}';
    }
}
