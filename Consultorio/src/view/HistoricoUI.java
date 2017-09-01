package view;

import java.util.List;
import model.Consulta;
import repositorio.RepositorioConsultas;
import util.Console;
import util.DateUtil;
import view.menu.HistoricoMenu;
import view.menu.PacienteMenu;

public class HistoricoUI {

    private RepositorioConsultas listaConsultas;

    public HistoricoUI(RepositorioConsultas listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(HistoricoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case HistoricoMenu.OP_LISTARFINALIZADAS:
                    mostrarConsultasFinalizadas();
                    break;
                case HistoricoMenu.OP_LISTARPORPACIENTE:
                    mostrarConsultasPorPaciente();
                    break;
                case HistoricoMenu.OP_LISTARPORMESANO:
                    mostrarConsultasPorMesAno();
                    break;
                case HistoricoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != PacienteMenu.OP_VOLTAR);
    }

    public void mostrarConsultasFinalizadas() {
        List<Consulta> listaConsultasFinalizadas = listaConsultas.getListaConsultasFinalizadas();
        if (listaConsultasFinalizadas.size() <= 0) {
            System.out.println("-----------------------------");
            System.out.println("Nao ha consultas finalizadas");
            System.out.println("-----------------------------\n");
        } else {

            for (Consulta consulta : listaConsultasFinalizadas) {
                imprimir(consulta);
            }
        }
    }

    private void mostrarConsultasPorPaciente() {
        String rg = Console.scanString("Digite o RG do Paciente: ");
        List<Consulta> listaConsultasPaciente = listaConsultas.getListaConsultasPorPaciente(rg);
        if (listaConsultasPaciente.size() <= 0) {
            System.out.println("-----------------------------");
            System.out.println("Nao ha consultas para este paciente");
            System.out.println("-----------------------------\n");
        } else {
            for (Consulta consulta : listaConsultasPaciente) {
                imprimir(consulta);
            }
        }
    }

    private void mostrarConsultasPorMesAno() {
        int mes = Console.scanInt("Mes: ");
        int ano = Console.scanInt("Ano: ");
        List<Consulta> listaConsultasMes = listaConsultas.getListaConsultasPorMes(mes, ano);
        if (listaConsultasMes.size() <= 0) {
            System.out.println("-----------------------------");
            System.out.println("Nao ha consultas nesse mes");
            System.out.println("-----------------------------\n");
        } else {
            for (Consulta consulta : listaConsultasMes) {
                imprimir(consulta);
            }
        }
    }

    private void imprimir(Consulta consulta) {
        System.out.println("\nCodigo: " + consulta.getCodigo());
        System.out.println("Data/Hora: " + DateUtil.dateTimeToString(consulta.getHorario()));
        System.out.println("Paciente: " + consulta.getPaciente().getNome() + "("
                + consulta.getPaciente().getRg() + ")");
        System.out.println("Prontuario: \n" + consulta.getProntuario());
        System.out.println("Receituário: ");
        new ReceituarioUI(consulta, null).mostrarReceitas();
    }

}
