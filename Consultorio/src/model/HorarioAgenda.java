package model;

import java.time.LocalDateTime;
import java.util.Date;

public class HorarioAgenda implements Comparable<HorarioAgenda> {
    private LocalDateTime horario;
    private Paciente paciente;
    
    public HorarioAgenda(LocalDateTime horario, Paciente paciente)
    {
        this.horario = horario;
        this.paciente = paciente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int compareTo(HorarioAgenda o) {
        return(this.getHorario().compareTo(o.getHorario()));
    }
    
    
}
