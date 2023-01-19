package api.apievent.Repository;

import api.apievent.Model.Convidados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadosRepository extends JpaRepository<Convidados, Long> {
}

