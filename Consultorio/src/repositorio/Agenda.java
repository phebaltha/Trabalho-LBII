package repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.HorarioAgenda;

public class Agenda {

    private List<HorarioAgenda> listaHorarios;

    public Agenda() {
        listaHorarios = new ArrayList<HorarioAgenda>();
    }

    public boolean addHorario(HorarioAgenda horario) {
        if(consultaExiste(horario.getHorario()))
            return false;
        return (listaHorarios.add(horario));
    }     

    public List<HorarioAgenda> getListaHorarios() {
        Collections.sort(listaHorarios);
        return listaHorarios;
    }

    public boolean consultaExiste(LocalDateTime horario) {
        for (HorarioAgenda hor : listaHorarios) {
            if (hor.getHorario().equals(horario)) {
                return true;
            }
        }
        return false;
    }

    public HorarioAgenda buscarHorarioAgenda(LocalDateTime horario) {
        for (HorarioAgenda hora : listaHorarios) {
            if (hora.getHorario().equals(horario)) {
                return hora;
            }
        }
        return null;
    }

}
