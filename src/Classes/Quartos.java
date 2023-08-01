/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Alan Pablo
 */
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

    public Quartos(int numeroQuarto, String tipoQuarto, int capacidadeMaxima, boolean disponibilidade, double precoPorNoite) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.capacidadeMaxima = capacidadeMaxima;
        this.disponibilidade = disponibilidade;
        this.precoPorNoite = precoPorNoite;
    }

    public Quartos(int numeroQuarto, String tipoQuarto, boolean disponibilidade, double precoPorNoite) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.disponibilidade = disponibilidade;
        this.precoPorNoite = precoPorNoite;
    }

    /**
     * Metodos getters e setters
     *
     *
     */
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

    /**
     * esse método busca um quarto específico pelo seu código no array de
     * quartos disponíveis e retorna o objeto Quartos correspondente se
     * encontrado, ou null se o quarto não for encontrado.
     *
     *
     */
    public static Quartos buscarQuartoPorCodigo(int codigoQuarto) {
        for (Quartos quarto : quartos) {
            if (quarto.getNumeroQuarto() == codigoQuarto) {
                System.out.println(quarto);
                return quarto;
            }
        }
        System.out.println("Quarto Nao Encontrado!");
        return null; // Retorna null se o quarto não for encontrado
    }

    /**
     * Questao 3 Sobreescrita da Saida
     *
     *
     */
    @Override
    public String toString() {
        return "\nQuarto " + numeroQuarto + "\nTipo " + tipoQuarto + "\nCapacidade " + capacidadeMaxima + "\nDisponibilidade: " + disponibilidade + "\nPreco por noite: " + precoPorNoite + "\n";
    }

    /**
     * Questao 5
     *
     * Armazenamento estatico dos Quartos da Pousada Esses objetos podem então
     * ser acessados e manipulados posteriormente no programa, por exemplo, para
     * exibir informações sobre os quartos disponíveis, reservá-los ou calcular
     * o preço total da estadia, dependendo do objetivo do programa em que esse
     * código é utilizado.
     */
    /**
     * significa que o array quartos pertence à classe Quartos em si e não a
     * qualquer objeto específico da classe. Isso permite que você acesse o
     * array diretamente através da classe Quartos sem precisar criar uma
     * instância da classe. se você tiver um código em outra classe que queira
     * acessar o array quartos, poderá fazê-lo diretamente através da classe
     * Quartos, sem precisar criar um objeto
     */
    
    //bloco de inicialização estático que cria e inicializa um array de objetos da classe Quartos
    public static Quartos[] quartos = new Quartos[10];

    static {
        quartos[0] = new Quartos(1, "Comun", 4, true, 100.0);
        quartos[1] = new Quartos(2, "Comun", 4, true, 100.0);
        quartos[2] = new Quartos(3, "Comun", 4, true, 100.0);
        quartos[3] = new Quartos(4, "Comun", 4, true, 150.0);
        quartos[4] = new Quartos(5, "Comun", 4, true, 150.0);
        quartos[5] = new Quartos(6, "Luxo", 6, true, 200.0);
        quartos[6] = new Quartos(7, "Luxo", 6, true, 300.0);
        quartos[7] = new Quartos(8, "Luxo", 6, true, 300.0);
        quartos[8] = new Quartos(9, "Luxo", 8, true, 500.0);
        quartos[9] = new Quartos(10, "Luxo", 8, true, 500.0);
    }
}
