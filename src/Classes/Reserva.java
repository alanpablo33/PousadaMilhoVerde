/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Alan Pablo
 */
public class Reserva {

    private List<Cliente> clientes;
    private List<Quartos> quartos;
    private LocalDateTime dataCheckIn;
    private LocalDateTime dataCheckOut;
    private int numeroPessoas;
   
    public Reserva(List<Cliente> clientes, List<Quartos> quartos, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
        this.clientes = clientes;
        this.quartos = quartos;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroPessoas = numeroPessoas;
    }

    public Reserva(LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
        this.quartos = new ArrayList<>();
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroPessoas = numeroPessoas;
    }

    public LocalDateTime getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDateTime getDataCheckOut() {
        return dataCheckOut;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }
    
    public void adicionarQuarto(Quartos quarto) {
        quartos.add(quarto);
    }

    public void confirmarReserva() {
        for (Quartos quarto : quartos) {
            quarto.setDisponibilidade(false);
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Quartos quarto : quartos) {
            Duration duracao = Duration.between(dataCheckIn, dataCheckOut);
            long numeroDias = duracao.toDays();
            valorTotal += quarto.getPrecoPorNoite() * numeroDias;
        }
        return valorTotal;
    }

    //VERIFICAR OPÇ CAPACIDADE MAXIMA
    public boolean verificarDisponibilidade() {
        for (Quartos quarto : quartos) {
            if (numeroPessoas < quarto.getCapacidadeMaxima()) {
                return false;
            }
            LocalDateTime dataAtual = dataCheckIn;
            while (dataAtual.isBefore(dataCheckOut)) {
                if (!quarto.isDisponibilidade()) {
                    return false;
                }
                dataAtual = dataAtual.plusDays(1);
            }
        }
        return true;
    }

    public double cancelarReserva(LocalDateTime dataCancelamento) {
        LocalDateTime dataLimiteCancelamento = this.dataCheckIn.plusDays(7);
        if (dataCheckIn.isBefore(dataCancelamento) && dataLimiteCancelamento.isAfter(dataCancelamento)) {
            int diasReservados = (int) ChronoUnit.DAYS.between(this.dataCheckIn, this.dataCheckOut);
            double valorDiaria =  10;//quartos.get(0).getPreco(); // Supondo que só tenha um quarto
            double valorDevolvido = (diasReservados * valorDiaria) / 2;
            return valorDevolvido;
        }
        else if(dataCancelamento.isAfter(dataLimiteCancelamento)){
            return 0;
        }
        return 0;
    }

    public static Reserva criarReserva(List<Cliente> clientes, List<Quartos> quartos, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
    Reserva reserva = new Reserva(clientes, quartos, dataCheckIn, dataCheckOut, numeroPessoas);
    if (reserva.verificarDisponibilidade()) {
        // Escolher um quarto disponível com base no número do quarto
        Quartos quartoEscolhido = null;
        for (Quartos quarto : quartos) {
            if (quarto.isDisponibilidade()) {
                quartoEscolhido = quarto;
                break;
            }
        }       
        if (quartoEscolhido != null) {
            // Adicionar o quarto escolhido à reserva
            reserva.adicionarQuarto(quartoEscolhido);
            
            // Confirmar a reserva
            reserva.confirmarReserva();
            
            return reserva;
        } else {
            System.out.println("Não há quartos disponíveis para essa reserva.");
            return null;
        }
    } else {
        System.out.println("Nao ha quartos disponiveis para essa reserva.");
        return null;
    }
}
    

    public static void main(String[] args) {

        // Criar lista de clientes e quartos
        List<Cliente> clientes = new ArrayList<>();
        // Adicionar clientes à lista de clientes
        clientes.add(new Cliente("João","2222"));
        clientes.add(new Cliente("Maria","2222"));
      

        List<Quartos> quartos = new ArrayList<>();    
        // Adicionar quartos à lista de quartos
        quartos.add(new Quartos(1, "Comun", true, 1.0));
        

        // Definir as datas de check-in e check-out e o número de pessoas
        LocalDateTime dataCheckIn = LocalDateTime.of(2023, 5, 1, 12, 0);
        LocalDateTime dataCheckOut = LocalDateTime.of(2023, 5, 2, 12, 0);
        int numeroPessoas = 2;

        // Chamar o método criarReserva
        Reserva reserva = criarReserva(clientes, quartos, dataCheckIn, dataCheckOut, numeroPessoas);

        // Verificar se a reserva foi criada com sucesso
        if (reserva != null) {
            System.out.println("Reserva criada com sucesso!");
            System.err.println(clientes);
            System.out.println("Data de check-in: " + reserva.getDataCheckIn());
            System.out.println("Data de check-out: " + reserva.getDataCheckOut());
            System.out.println("Numero de pessoas: " + reserva.getNumeroPessoas());
            double valorTotal = reserva.calcularValorTotal();
            System.out.println("Valor total da reserva: " + valorTotal);
            System.err.println(quartos);
            
        } else {
            System.out.println("Nao foi possivel criar a reserva.");
        }
    }
    
    
    
    
    
    
    
    
    
    
    

  

    
}

