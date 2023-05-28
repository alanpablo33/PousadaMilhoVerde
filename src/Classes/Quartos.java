package Classes;

public class Quartos {

    private int numeroQuarto;
    private String tipoQuarto;
    private int capacidadeMaxima;
    private boolean disponibilidade;
    private double precoPorNoite;

    
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
    

    public Quartos(int numeroQuarto, String tipoQuarto, boolean disponibilidade, double precoPorNoite) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.disponibilidade = disponibilidade;
        this.precoPorNoite = precoPorNoite;
    }

    // getters e setters
    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    // Sobrescrever toString
    @Override
    public String toString() {
        return "Quarto " + numeroQuarto + " - " + "Tipo " + tipoQuarto + " - Disponibilidade: " + disponibilidade + " - Preco por noite: " + precoPorNoite;
    }

    //Armazenamento estatico dos Quartos da Pousada
    public static Quartos[] quartos = new Quartos[10];
    static {
        quartos[0] = new Quartos(1, "Comun", true, 100.0);
        quartos[1] = new Quartos(2, "Comun", true, 100.0);
        quartos[2] = new Quartos(3, "Comun", true, 100.0);
        quartos[3] = new Quartos(4, "Comun", true, 100.0);
        quartos[4] = new Quartos(5, "Comun", true, 100.0);
        quartos[5] = new Quartos(6, "Luxo", true, 200.0);
        quartos[6] = new Quartos(7, "Luxo", true, 200.0);
        quartos[7] = new Quartos(8, "Luxo", true, 200.0);
        quartos[8] = new Quartos(9, "Luxo", true, 200.0);
        quartos[9] = new Quartos(10, "Luxo", false, 200.0);

    }
    
}
