/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 * /**
 * import static Classes.Cliente.endArqCliente;
 *
 * Essa importação está importando uma variável estática endArqCliente da classe
 * Cliente localizada no pacote Classes contém o endereço do arquivo de dados
 * dos clientes
 */
import static Classes.Cliente.endArqCliente;
/**
 * Essa importação está importando a classe JsonFerramentas do pacote arquivos.
 * Essa classe contém ferramentas relacionadas à manipulação de arquivos JSON,
 * como leitura, gravação e manipulação de dados.
 */
import arquivos.JsonFerramentas;
import static arquivos.JsonFerramentas.excluirReservaPorCodigo;
/**
 * Essa classe fornece recursos para medir durações de tempo, como a diferença
 * entre duas instâncias de LocalDateTime
 */
import java.time.Duration;
/**
 * importando a classe LocalDateTime Essa classe representa uma data e hora
 * específica, sem fuso horário
 */
import java.time.LocalDateTime;
/**
 * está importando a classe ChronoUnit. Essa classe é uma enumeração que define
 * várias unidades de tempo, como dias, horas, minutos, etc., e é usada em
 * conjunto com outras classes do pacote java.time para realizar cálculos
 * temporais
 */
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
/**
 * parte do pacote java.util e está importando a classe Collections Essa classe
 * fornece métodos estáticos para operações em coleções, como ordenação,
 * embaralhamento e pesquisa
 */
import java.util.Collections;
/**
 * importando a interface Comparator Essa interface define um contrato para
 * comparar objetos e é frequentemente usada para fornecer regras de ordenação
 * personalizadas
 */
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Pablo
 */
public class Reserva implements Comparator<Reserva> {

    /**
     * protected static listaReserva = new ArrayList;: É uma lista global de
     * objetos do tipo Reserva que armazena todas as reservas feitas. Ela é
     * declarada como protected, o que significa que pode ser acessada por
     * classes que estejam no mesmo pacote ou por classes que sejam subclasses
     * de Reserva.
     *
     * protected static final String endArqReservasContador =
     * "./src/arquivos/RESERVASX.json";: É uma constante que representa o
     * caminho do arquivo onde as informações das reservas são armazenadas. Ela
     * indica o local onde os dados são lidos e gravados.
     *
     * private int codigoReserva;: É um atributo inteiro que armazena o código
     * único de identificação de uma reserva.
     *
     * private int valorDiaria;: É um atributo inteiro que armazena o valor da
     * diária para a reserva.
     *
     * private int valorAdicional;: É um atributo inteiro que armazena o valor
     * adicional (caso exista) para a reserva.
     *
     * private List clientes;: É uma lista de objetos do tipo Cliente que
     * armazena os clientes associados à reserva. Pode haver mais de um cliente
     * por reserva.
     *
     * public List quartos;: É uma lista de objetos do tipo Quarto que armazena
     * os quartos reservados.
     *
     * private LocalDateTime dataCheckIn;: É um objeto do tipo LocalDateTime que
     * representa a data e hora do check-in da reserva.
     *
     * private LocalDateTime dataCheckOut;: É um objeto do tipo LocalDateTime
     * que representa a data e hora do check-out da reserva.
     *
     * private int numeroPessoas;: É um atributo inteiro que armazena o número
     * de pessoas associadas à reserva.
     *
     * private static int contadorInstancias = 0;: É uma variável estática
     * inteira que mantém o controle do número de instâncias da classe Reserva
     * criadas. Essa variável é compartilhada por todas as instâncias da classe
     * e pode ser acessada sem a necessidade de criar um objeto da classe. É
     * incrementada sempre que uma nova instância de Reserva é criada
     */
    protected static List<Reserva> listaReserva = new ArrayList<>(); // Lista de Reserva global
    protected static final String endArqReservasContador = "./src/arquivos/RESERVASX.json";
    private int codigoReserva;
    private int valorDiaria;
    private int valorAdicional;
    private List<Cliente> clientes;
    public List<Quartos> quartos;
    private LocalDateTime dataCheckIn;
    private LocalDateTime dataCheckOut;
    private int numeroPessoas;
    /**
     * Questão 12
     *
     * Atributo para Contador de Instancias da Classe Reserva
     */
    private static int contadorInstancias = 0;

    public Reserva() {
    }

    public Reserva(int codigoReserva, int valorDiaria, int valorAdicional, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut) {
        this.codigoReserva = codigoReserva;
        this.valorDiaria = valorDiaria;
        this.valorAdicional = valorAdicional;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        contadorInstancias++;
    }

    public Reserva(int codigoReserva, int valorDiaria, int valorAdicional) {
        this.codigoReserva = codigoReserva;
        this.valorDiaria = valorDiaria;
        this.valorAdicional = valorAdicional;
        contadorInstancias++;
    }

    public Reserva(int codigoReserva, int valorDiaria, List<Cliente> clientes, List<Quartos> quartos, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
        this.codigoReserva = codigoReserva;
        this.valorDiaria = valorDiaria;
        this.clientes = clientes;
        this.quartos = quartos;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroPessoas = numeroPessoas;
        contadorInstancias++;
    }

    public Reserva(int codigoReserva, int valorDiaria, int valorAdicional, List<Cliente> clientes, List<Quartos> quartos, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
        this.codigoReserva = codigoReserva;
        this.valorDiaria = valorDiaria;
        this.valorAdicional = valorAdicional;
        this.clientes = clientes;
        this.quartos = quartos;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroPessoas = numeroPessoas;
        contadorInstancias++;

    }

    public Reserva(int codigoReserva, List<Cliente> clientes, List<Quartos> quartos, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
        this.codigoReserva = codigoReserva;
        this.clientes = clientes;
        this.quartos = quartos;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroPessoas = numeroPessoas;
        contadorInstancias++;
    }

    public Reserva(List<Cliente> clientes, List<Quartos> quartos, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
        this.clientes = clientes;
        this.quartos = quartos;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroPessoas = numeroPessoas;
        contadorInstancias++;
    }

    public Reserva(LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
        this.quartos = new ArrayList<>();
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroPessoas = numeroPessoas;
        contadorInstancias++;
    }

    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    public int getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(int valorAdicional) {
        this.valorAdicional = 0;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(int valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public LocalDateTime getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDateTime getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckIn(LocalDateTime dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public void setDataCheckOut(LocalDateTime dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    /**
     * adicionar um objeto Quartos à lista de quartos da reserva
     *
     *
     */
    public void adicionarQuarto(Quartos quarto) {
        quartos.add(quarto);
    }

    /**
     * confirmar a reserva dos quartos, atualizando a disponibilidade dos
     * quartos para "false", indicando que estão ocupado
     */
    public void confirmarReserva() {
        // loop que itera sobre cada objeto Quarto presente na lista quartos da reserva. Para cada quarto, o código dentro do loop será executado.
        for (Quartos quarto : quartos) {
            quarto.setDisponibilidade(false);
        }
    }

    /**
     * calcular o valor total da reserva com base nos quartos reservados, na
     * duração da estadia e no preço por noite de cada quarto
     *
     *
     */
    public double calcularValorTotal() {
        double valorTotal = 0;
        //loop que itera sobre cada objeto Quarto presente na lista quartos da reserva. Para cada quarto, o código dentro do loop será executado
        for (Quartos quarto : quartos) {
            //Cria um objeto Duration que representa a diferença de tempo entre a data de check-in (dataCheckIn) e a data de check-out (dataCheckOut)
            Duration duracao = Duration.between(dataCheckIn, dataCheckOut);
            //Obtém o número de dias da duração da estadia ao converter a duração para o formato de dias
            long numeroDias = duracao.toDays();
            //Atualiza o valor total da reserva somando o preço por noite do quarto
            valorTotal += quarto.getPrecoPorNoite() * numeroDias;
        }
        return valorTotal;
    }

    /**
     * verificar se os quartos associados à reserva estão disponíveis para a
     * quantidade de pessoas e período de tempo especificados
     *
     *
     */
    public boolean verificarDisponibilidade() {
        for (Quartos quarto : quartos) {
            if (numeroPessoas > quarto.getCapacidadeMaxima() || !quarto.isDisponibilidade()) {
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
        System.out.println("Disponivel, Limite OK!");
        return true;
    }

    /**
     * responsável por calcular o valor a ser devolvido ao cliente em caso de
     * cancelamento da reserva o método verifica se a data de cancelamento está
     * dentro do período permitido para cancelamento sem penalidade Se estiver,
     * calcula o valor a ser devolvido ao cliente com base no número de dias
     * reservados e no valor da diária Caso contrário, retorna 0 para indicar
     * que nenhuma devolução será feita.
     *
     *
     */
    public double cancelarReserva(LocalDateTime dataCancelamento) {
        /**
         * O método começa calculando a data limite de cancelamento, que é
         * definida adicionando 7 dias à data de check-in da reserva
         *
         */
        LocalDateTime dataLimiteCancelamento = this.dataCheckIn.plusDays(7);
        /**
         * verifica se a data de cancelamento fornecida está entre a data de
         * check-in e a data limite de cancelamento Isso garante que o cliente
         * esteja cancelando a reserva dentro do prazo permitido.
         */
        if (dataCheckIn.isBefore(dataCancelamento) && dataLimiteCancelamento.isAfter(dataCancelamento)) {
            /**
             * Se o cancelamento estiver dentro do prazo, o método calcula o
             * número de dias reservados, subtraindo a data de check-in da data
             * de check-out
             *
             */
            int diasReservados = (int) ChronoUnit.DAYS.between(this.dataCheckIn, this.dataCheckOut);
            double valorDiaria = 10;//quartos.get(0).getPreco(); // Supondo que só tenha um quarto
            /**
             * O valor a ser devolvido ao cliente é calculado multiplicando o
             * número de dias reservados pelo valor da diária e, em seguida,
             * dividindo-o por 2
             *
             */
            double valorDevolvido = (diasReservados * valorDiaria) / 2;
            /**
             * O valor calculado é retornado como resultado do método
             *
             */
            return valorDevolvido;
            /**
             * Se a data de cancelamento fornecida estiver após a data limite de
             * cancelamento, isso significa que o cliente está cancelando fora
             * do prazo permitido. Nesse caso, o valor a ser devolvido é 0,
             * indicando que nenhum reembolso será feito
             */
        } else if (dataCancelamento.isAfter(dataLimiteCancelamento)) {
            return 0;
        }
        return 0;
    }

    /**
     * gerar um código aleatório para uma reserva
     *
     *
     */
    public static int gerarCodigoReserva() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int codigoReserva = random.nextInt(10000);
        System.out.println("Codigo da Reserva: " + codigoReserva);
        return codigoReserva;
    }

    /**
     * criar uma nova reserva com base nos parâmetros fornecidos
     *
     *
     *
     * O método realiza as etapas necessárias para criar uma reserva,
     * verificando a disponibilidade dos quartos, selecionando um quarto
     * disponível, calculando o valor total e confirmando a reserva. Se não
     * houver quartos disponíveis, a função retorna null
     */
    public static Reserva criarReserva(int codigoReserva, List<Cliente> clientes, List<Quartos> quartos, LocalDateTime dataCheckIn, LocalDateTime dataCheckOut, int numeroPessoas) {
        Reserva reserva = new Reserva(codigoReserva, clientes, quartos, dataCheckIn, dataCheckOut, numeroPessoas);
        if (reserva.verificarDisponibilidade()) {
            /**
             * Escolher um quarto disponível com base no número do quarto
             *
             */
            Quartos quartoEscolhido = null;
            for (Quartos quarto : quartos) {
                if (quarto.isDisponibilidade()) {
                    quartoEscolhido = quarto;
                    break;
                }
            }
            if (quartoEscolhido != null) {
                // Adicionar o quarto escolhido à reserva
                // reserva.adicionarQuarto(quartoEscolhido);

                /**
                 * Adicionar valor total a pagar dia*Diaria do quarto
                 *
                 */
                double valorTotal = reserva.calcularValorTotal();
                // Adicionar o valor total à reserva
                reserva.setValorDiaria((int) valorTotal);
                reserva.setValorAdicional(0);

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

    /**
     * buscar um cliente pelo seu código na lista de clientes existentes
     *
     *
     */
    public static Cliente buscarClientePorCodigo(int codigoCliente) {
        // Carrega os clientes existentes no arquivo
        List<Cliente> clientesExistentes = JsonFerramentas.leituraArquivoJson(endArqCliente, Cliente.class, codigoCliente);
        // Procura o cliente pelo código e retorna o cliente se encontrado
        for (Cliente cliente : clientesExistentes) {
            if (cliente.getCodigoDoCliente() == codigoCliente) {
                System.out.println(cliente);
                return cliente;
            }
        }
        // Retorna null se o cliente não for encontrado
        return null;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Questao 10 Terminal
     *
     *
     * criar e salvar uma reserva a partir das informações fornecidas pelo
     * usuário no terminal.
     */
    public static void criarSalvarReservaTerminal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o codigo do Cliente: ");
        int codig = input.nextInt();

        System.out.print("Digite o Numero do Quarto: ");
        int nquarto = input.nextInt();

        // Criar lista de clientes 
        List<Cliente> clientes = new ArrayList<>();
        Cliente clienteEncontrado = Reserva.buscarClientePorCodigo(codig);
        // Adicionar clientes à lista de clientes
        clientes.add(clienteEncontrado);

        // Criar lista de quartos
        List<Quartos> quartos = new ArrayList<>();
        Quartos quartoEncontrado = Quartos.buscarQuartoPorCodigo(nquarto);
        // Adicionar quartos à lista de quartos
        quartos.add(quartoEncontrado);

        // Definir as datas de check-in
        System.out.print("Digite o inicial Ano: ");
        int anoI = input.nextInt();
        System.out.print("Digite o inicial Mes: ");
        int mesI = input.nextInt();
        System.out.print("Digite o inicial Dia: ");
        int diaI = input.nextInt();

        LocalDateTime dataCheckIn = LocalDateTime.of(anoI, mesI, diaI, 00, 0);

        // Definir as datas de check-out
        System.out.print("Digite o final Ano: ");
        int anoF = input.nextInt();
        System.out.print("Digite o final Mes: ");
        int mesF = input.nextInt();
        System.out.print("Digite o final Dia: ");
        int diaF = input.nextInt();

        LocalDateTime dataCheckOut = LocalDateTime.of(anoF, mesF, diaF, 23, 59);

        // Verificar se a data inicial é menor do que a data final
        if (dataCheckIn.isAfter(dataCheckOut)) {
            System.out.println("A data inicial nao pode ser maior do que a data final.");
            return; // Encerra o método sem criar a reserva
        }
        //funciona
        System.out.print("Digite o Numero de Vagas: ");
        int nvagas = input.nextInt();
        int numeroPessoas = nvagas;

        //gerador de codigo para Reserva
        int x = gerarCodigoReserva();

        // Chamar o método criarReserva
        Reserva reserva = criarReserva(x, clientes, quartos, dataCheckIn, dataCheckOut, numeroPessoas);
        listaReserva.add(reserva);
        /**
         * A reserva é adicionada à lista de reservas listaReserva e é chamado o
         * método salvarReservas da classe JsonFerramentas para salvar a lista
         * de reservas no arquivo JSON. Em seguida, são exibidas informações
         * sobre a reserva, como código, datas, número de pessoas e valor total.
         * O contador de instâncias de reserva é atualizado e os dados são
         * salvos no arquivo JSON usando o método
         * atualizarContadorInstanciasReserva da classe JsonFerramentas
         */
        arquivos.JsonFerramentas.salvarReservas(listaReserva);

        System.out.println("\n\n" + reserva);
        System.out.println(listaReserva + "\n\n");

        // Verificar se a reserva foi criada com sucesso
        if (reserva != null) {
            System.out.println("Reserva criada com sucesso!");
            System.out.println("Data de check-in: " + reserva.getDataCheckIn());
            System.out.println("Data de check-out: " + reserva.getDataCheckOut());
            System.out.println("Numero de pessoas: " + reserva.getNumeroPessoas());
            double valorTotal = reserva.calcularValorTotal();
            System.out.println("Valor total da reserva: " + valorTotal + "\n\n");

            /**
             * Questão 12
             *
             * esse trecho de código obtém a quantidade atual de instâncias de
             * reservas, incrementa o contador em 1, atualiza o contador no
             * arquivo ou fonte de dados correspondente e, em seguida, imprime a
             * quantidade atualizada no console. O objetivo exato dessas
             * operações depende da implementação dos métodos
             * getContadorInstancias() e atualizarContadorInstanciasReserva()
             * nas respectivas classes
             */
            int quantidadeInstancias = Reserva.getContadorInstancias();
            // Atualizar o valor do contador de instâncias de reserva
            quantidadeInstancias++;
            // Salvar dados da Reserva no Json
            arquivos.JsonFerramentas.atualizarContadorInstanciasReserva(endArqReservasContador);
            System.out.println("Numero de instuncias de Reserva: " + quantidadeInstancias);

        } else {
            System.out.println("Nao foi possivel criar a reserva.");
        }
    }

    /**
     * Questão 10
     *
     * criar e salvar uma reserva a partir das informações fornecidas pela tela
     *
     *
     */
    public static void criarSalvarReservaTela(int codig, int nquarto, int anoI, int mesI, int diaI, int anoF, int mesF, int diaF, int nvagas, String dataFormatada, String dataFormatadaFim) {
        // Criar lista de clientes 
        List<Cliente> clientes = new ArrayList<>();
        Cliente clienteEncontrado = Reserva.buscarClientePorCodigo(codig);
        // Adicionar clientes à lista de clientes
        clientes.add(clienteEncontrado);

        // Criar lista de quartos
        List<Quartos> quartos = new ArrayList<>();
        Quartos quartoEncontrado = Quartos.buscarQuartoPorCodigo(nquarto);
        // Adicionar quartos à lista de quartos
        quartos.add(quartoEncontrado);
        /**
         * As datas de check-in e check-out são definidas usando a classe
         * LocalDateTime, com base nas informações fornecidas. É feita uma
         * verificação para garantir que a data de check-in seja anterior à data
         * de check-out. Caso contrário, é exibida uma mensagem de erro e o
         * método é encerrado sem criar a reserva.
         */
        // Definir as datas de check-in
        LocalDateTime dataCheckIn = LocalDateTime.of(anoI, mesI, diaI, 00, 0);

        // Definir as datas de check-out
        LocalDateTime dataCheckOut = LocalDateTime.of(anoF, mesF, diaF, 23, 59);

        // Verificar se a data inicial é menor do que a data final
        if (dataCheckIn.isAfter(dataCheckOut)) {
            System.out.println("A data inicial nao pode ser maior do que a data final.");
            return; // Encerra o método sem criar a reserva
        }

        int numeroPessoas = nvagas;

        // Gerar código para Reserva
        int x = gerarCodigoReserva();

        // Chamar o método criarReserva
        Reserva reserva = criarReserva(x, clientes, quartos, dataCheckIn, dataCheckOut, numeroPessoas);

        // Criar uma nova lista de reservas contendo apenas a nova reserva
        List<Reserva> listaReserva = new ArrayList<>();
        listaReserva.add(reserva);

        // Salvar a lista de reservas no arquivo JSON, substituindo o conteúdo existente
        arquivos.JsonFerramentas.salvarReservas(listaReserva);

        // Atualizar o valor do contador de instâncias de reserva
        /**
         * O contador de instâncias de reserva é atualizado, incrementando seu
         * valor em 1, e os dados são salvos no arquivo JSON usando o método
         * atualizarContadorInstanciasReserva
         */
        int quantidadeInstancias = Reserva.getContadorInstancias();
        quantidadeInstancias++;
        arquivos.JsonFerramentas.atualizarContadorInstanciasReserva(endArqReservasContador);
        System.out.println("Numero de instancias de Reserva: " + quantidadeInstancias);

        /**
         * Exibir a mensagem de confirmação com o código da reserva É exibida
         * uma mensagem de confirmação na tela, contendo o código da reserva,
         * utilizando o JOptionPane
         */
        JOptionPane.showMessageDialog(null, "Reserva Feita\n" + "Cliente: " + codig + "\nNumero do Quarto: " + nquarto + "\nCódigo da Reserva: " + x);
    }

    /**
     * Questao 10
     *
     * Terminal
     *
     * ler e retornar uma reserva com base no código fornecido permite buscar
     * uma reserva específica com base no código e exibi-la na tela. Caso a
     * reserva seja encontrada, o método retorna a reserva encontrada. Caso
     * contrário, retorna null.
     *
     *
     */
    public static Reserva lerReservaPorCodigo() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nDigite o Codigo da Reserva que deseja Procurar: ");
        int codigoReserva = input.nextInt();
        List<Reserva> reservas = JsonFerramentas.lerReservas(); // Lê todas as reservas do arquivo JSON
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoReserva() == codigoReserva) {
                System.out.println("\n" + reserva);
                return reserva;
            }
        }
        return null; // Retorna null se a reserva não for encontrada
    }

    /**
     * Questao 10
     *
     * Terminal
     *
     * ler e retornar uma reserva com base no código fornecido permite buscar
     * uma reserva específica com base no código fornecido. Se a reserva for
     * encontrada, ela é retornada. Caso contrário, o método retorna null. Essa
     * implementação é útil para ser utilizada em uma interface de usuário, em
     * que o código da reserva é passado como entrada para buscar a reserva
     * correspondente e exibi-la na tela.
     *
     */
    public static Reserva lerReservaPorCodigoTela(int codigoReserva) {
        List<Reserva> reservas = JsonFerramentas.lerReservas();

        if (reservas != null && !reservas.isEmpty()) {
            for (Reserva reserva : reservas) {
                if (reserva != null && reserva.getCodigoReserva() == codigoReserva) {
                    return reserva;
                }
            }
        }

        return null; // Retorna null caso a reserva não seja encontrada
    }

    /**
     * Questao 10
     *
     * Terminal buscar uma reserva com base no CPF do cliente buscar uma reserva
     * com base no CPF do cliente. Se for encontrada uma reserva correspondente,
     * as informações relevantes são exibidas. Caso contrário, é exibida uma
     * mensagem informando que a reserva não foi encontrada. Essa implementação
     * é útil para obter informações específicas de uma reserva com base no CPF
     * do cliente
     */
    public static void lerReservaPorCPF() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o CPF do Cliente que deseja procurar: ");
        String cpfCliente = input.next();

        List<Reserva> reservas = JsonFerramentas.lerReservas();

        for (Reserva reserva : reservas) {
            for (Cliente cliente : reserva.getClientes()) {
                if (cliente.getCPF().equals(cpfCliente)) {
                    System.out.println("Valor Diaria: " + reserva.getValorDiaria());
                    System.out.println("Valor Adicional: " + reserva.getValorAdicional());
                    System.out.println("Codigo do Cliente: " + cliente.getCodigoDoCliente());
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCPF());
                    System.out.println("Data de Check-in: " + reserva.getDataCheckIn());
                    System.out.println("Data de Check-out: " + reserva.getDataCheckOut());
                    return;
                }
            }
        }

        System.out.println("Reserva não encontrada.");
    }

    /**
     * Questao 10
     *
     * Tela
     *
     * método busca uma reserva correspondente a um código de cliente
     * específico. Ele percorre a lista de reservas, verifica cada cliente
     * associado a cada reserva e retorna a reserva correspondente ao código do
     * cliente, ou null se a reserva não for encontrada
     *
     *
     */
    public static Reserva lerReservaPorCodigo(int codigoCliente) {
        List<Reserva> reservas = JsonFerramentas.lerReservas();

        if (reservas != null && !reservas.isEmpty()) {
            for (Reserva reserva : reservas) {
                if (reserva != null && reserva.getClientes() != null) {
                    for (Cliente cliente : reserva.getClientes()) {
                        if (cliente.getCodigoDoCliente() == codigoCliente) {
                            return reserva;
                        }
                    }
                }
            }
        }

        return null; // Retorna null caso a reserva não seja encontrada
    }

    /**
     * Questao 10
     *
     * Tela
     *
     * adicionar um valor adicional a uma reserva específica método permite
     * adicionar um valor adicional a uma reserva específica, atualizando o
     * arquivo JSON correspondente. Isso pode ser útil para registrar gastos
     * extras ou taxas adicionais associadas a uma reserva
     */
    public static void adicionarValorAdicional() {
        Scanner input = new Scanner(System.in);
        System.out.print("CODIGO DA RESERVA: ");
        int cadgi = input.nextInt();

        int codigoReserva = cadgi;
        System.out.print("VALOR ADICIONAL: ");
        int valur = input.nextInt();

        int valorAdicional = valur;

        arquivos.JsonFerramentas.valorAdicionalGastos(codigoReserva, valorAdicional);

    }

    /**
     * Questao 10
     *
     * Tela
     *
     */
    public static void adicionarValorAdicional(int codigoReserva, int valorAdicional) {
        arquivos.JsonFerramentas.valorAdicionalGastos(codigoReserva, valorAdicional);
    }

    /**
     * Questao 10
     *
     * Tela
     *
     * cancelar uma reserva feita pelo cliente cancelar uma reserva, calculando
     * o valor a ser devolvido ao cliente com base nas regras de cancelamento
     * estabelecidas.
     */
    public static void cancelarReservaDoCliente() {
        // Localize a reserva que deseja cancelar (por exemplo, por código de reserva)
        Reserva reservaParaCancelar = Reserva.lerReservaPorCodigo();

        // Verifique se a reserva foi encontrada
        if (reservaParaCancelar != null) {
            // Obtenha a data de cancelamento
            LocalDateTime dataCancelamento = LocalDateTime.now(); // Use a data atual ou defina a data de cancelamento desejada

            // Chame o método cancelarReserva e obtenha o valor a ser devolvido
            double valorDevolvido = reservaParaCancelar.cancelarReserva(dataCancelamento);

            // Imprima o valor a ser devolvido
            System.out.println("Valor a ser devolvido ao cliente: " + valorDevolvido);

        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    /**
     * Questao 10
     *
     * Tela
     *
     */
    public static double cancelarReservaDoClienteTela(int codigoDaReservaDoCliente) {
        // Localize a reserva que deseja cancelar com base no código do cliente
        Reserva reservaParaCancelar = Reserva.lerReservaPorCodigoTela(codigoDaReservaDoCliente);

        // Verifique se a reserva foi encontrada
        if (reservaParaCancelar != null) {
            // Obtenha a data de cancelamento
            LocalDateTime dataCancelamento = LocalDateTime.now(); // Use a data atual ou defina a data de cancelamento desejada

            // Chame o método cancelarReserva e obtenha o valor a ser devolvido
            double valorDevolvido = reservaParaCancelar.cancelarReserva(dataCancelamento);

            // Imprima o valor a ser devolvido
            System.out.println("Valor a ser devolvido ao cliente: " + valorDevolvido);
            excluirReservaPorCodigo(codigoDaReservaDoCliente);
            // Retorne o valor a ser pago
            return valorDevolvido;
        } else {
            System.out.println("Reserva não encontrada.");
            return 0.0; // ou outro valor padrão, caso a reserva não seja encontrada
        }
    }

    /**
     * Questao 13
     *
     *
     * método realiza a ordenação de uma lista de objetos Reserva com base no
     * valor da diária. Ele exibe os valores da diária antes e depois da
     * ordenação para verificar o resultado da operação. O método compareTo da
     * classe Reserva é usado para definir a ordem de classificação durante a
     * ordenação
     */
    public static void ordenarReserva() {
        // Comparador para a Classe Reserva
        List<Reserva> listaReserva = new ArrayList<>();

        listaReserva = arquivos.JsonFerramentas.lerReservas();

        // Antes da ordenação
        System.out.println("Antes da Ordenacao:");
        for (Reserva r : listaReserva) {
            System.out.println(r.getValorDiaria());
        }

        // Ordenação da lista de reservas
        Collections.sort(listaReserva, new Reserva());

        // Após a ordenação
        System.out.println("------------------------------------------------------------");
        System.out.println("Apos a Ordenacao:");
        for (Reserva r : listaReserva) {
            System.out.println(r.getValorDiaria());
        }
    }

    /**
     * Questao 3 Sobreescrita da Saida
     *
     *
     */
    @Override
    public String toString() {
        // Retorne uma representação em string adequada aos atributos e estado do objeto
        // por exemplo, retorne uma concatenação de informações relevantes da reserva
        return "\nCodigo Da Reserva: " + codigoReserva + clientes + "\nQuarto: " + quartos + "\ncheck-in: " + dataCheckIn + "\ncheck-out: " + dataCheckOut + "\nnumero de pessoas: " + numeroPessoas + "\nValor Diaria a Pagar: " + valorDiaria + "\nValor Adicional: " + valorAdicional + "\n";
    }

    /**
     *
     * A função desse método é comparar duas instâncias da classe Reserva com
     * base em seus valores de diária (valorDiaria).
     */
    @Override //sobrescrevendo um método da superclasse ou implementando um método de uma interface
    public int compare(Reserva reserva1, Reserva reserva2) {
        // Comparação com base nos códigos das reservas
        if (reserva1.getValorDiaria() < reserva2.getValorDiaria()) {
            return -1;
        } else if (reserva1.getValorDiaria() > reserva2.getValorDiaria()) {
            return 1;
        } else {
            return 0;
        }

    }

}
