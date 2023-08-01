/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import java.util.Random; // Gera valores aleatorios
import java.util.Scanner; // escreve
import java.util.List; // fazer lista
import arquivos.JsonFerramentas; // import da classe arquivo para salvar dados clientes
import static arquivos.JsonFerramentas.leituraArquivo;
import com.google.gson.reflect.TypeToken; // quebra de linha
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator; // biblioteca para fazer comparação
import javax.swing.JOptionPane; // mostrar mgs na tela

/**
 *
 * @author Alan Pablo
 */
/**
 *
 * A Classe Cliente e uma subclasse da Classe PessoaAdstract e implementa o
 * comparador na Classe Cliente
 */
public class Cliente extends PessoaAbstract implements Comparator<Cliente> {

    //Atributos para Cliente
    /**
     * public static listaClientes: É uma lista estática de objetos da classe
     * Cliente. Essa lista armazena todos os clientes cadastrados e é acessível
     * globalmente, ou seja, pode ser acessada por outras partes do programa.
     *
     * protected static listaContador: É uma lista estática de valores inteiros.
     * Essa lista é utilizada para armazenar contadores relacionados aos
     * clientes e também é acessível globalmente.
     *
     * private static final String endArqContador =
     * "./src/arquivos/DADOS_CONTADOR-CLIENTE.json";: É uma constante que
     * armazena o caminho do arquivo onde os dados do contador relacionados aos
     * clientes são armazenados.
     *
     * protected static final String endArqCliente =
     * "./src/arquivos/DADOS_CADASTRO_CLIENTE.json";: É uma constante que
     * armazena o caminho do arquivo onde os dados dos clientes cadastrados são
     * armazenados.
     *
     * protected static final String endArqClienteContador =
     * "./src/arquivos/CLIENTES.json";: É uma constante que armazena o caminho
     * do arquivo onde são armazenados os dados dos clientes e seus respectivos
     * contadores.
     *
     * private int codigoDoCliente: É um atributo inteiro que representa o
     * código do cliente.
     *
     * private String telefone: É um atributo do tipo String que representa o
     * telefone do cliente.
     *
     * private String email: É um atributo do tipo String que representa o email
     * do cliente.
     *
     * private String rua: É um atributo do tipo String que representa a rua
     * onde o cliente reside.
     *
     * private String bairro: É um atributo do tipo String que representa o
     * bairro onde o cliente reside.
     *
     * private String numeroCasa: É um atributo do tipo String que representa o
     * número da casa onde o cliente reside.
     *
     * private String cep: É um atributo do tipo String que representa o CEP
     * (Código de Endereçamento Postal) da residência do cliente.
     *
     * private String cidade: É um atributo do tipo String que representa a
     * cidade onde o cliente reside
     */
    public static List<Cliente> listaClientes = new ArrayList<>(); // Lista de clientes global
    protected static List<Integer> listaContador = new ArrayList<>(); // Lista de Contador global
    private static final String endArqContador = "./src/arquivos/DADOS_CONTADOR-CLIENTE.json";
    protected static final String endArqCliente = "./src/arquivos/DADOS_CADASTRO_CLIENTE.json";
    protected static final String endArqClienteContador = "./src/arquivos/CLIENTES.json";
    private int codigoDoCliente;
    private String telefone;
    private String email;
    private String rua;
    private String bairro;
    private String numeroCasa;
    private String cep;
    private String cidade;

    public Cliente() {
    }

    public String getCPF() {
        return cpf;
    }

    public Cliente(String david, String davidexamplecom) {

    }

    public Cliente(String telefone, String email, String rua, String bairro, String numeroCasa, String cep, String cidade, String nome, String cpf) {
        /**
         * Questão 04
         *
         * Utilização da Palavra reservada super para implementar construtores
         * das subclasses.
         */
        super(nome, cpf);
        this.telefone = telefone;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.numeroCasa = numeroCasa;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Cliente(int codigoDoCliente, String nome, String cpf) {
        /**
         * Questão 04
         *
         * Utilização da Palavra reservada super para implementar construtores
         * das subclasses.
         */
        super(nome, cpf);
        this.codigoDoCliente = codigoDoCliente;
    }
    
    

    public Cliente(int codigoDoCliente, String nome, String telefone, String email, String cpf, String rua, String bairro, String numeroCasa, String cep, String cidade) {
        /**
         * Questão 04
         *
         * Utilização da Palavra reservada super para implementar construtores
         * das subclasses.
         */
        super(nome, cpf); // pegando informações da ClassePessoa
        this.codigoDoCliente = codigoDoCliente;
        this.telefone = telefone;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.numeroCasa = numeroCasa;
        this.cep = cep;
        this.cidade = cidade;
    }

//Metodos Get e Set Criados para a manipulação dos Atributos Que estão em Private
    public int getCodigoDoCliente() {
        return codigoDoCliente;
    }

    public void setCodigoDoCliente(int codigoDoCliente) {
        this.codigoDoCliente = codigoDoCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Questao 7
     *
     * permite cadastrar um novo cliente por meio da entrada de dados no
     * terminal
    */
    
    
    
    public static void cadastroClienteTerminal() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int codigoDoCliente = random.nextInt(10000);

        // Set's para cadastro
        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("CPF: ");
        String cpf = input.nextLine();

        System.out.print("Telefone: ");
        String telefone = input.nextLine();

        System.out.print("E-mail: ");
        String email = input.nextLine();

        System.out.print("Rua: ");
        String rua = input.nextLine();

        System.out.print("Numero da Casa: ");
        String numeroCasa = input.nextLine();

        System.out.print("Bairro: ");
        String bairro = input.nextLine();

        System.out.print("Cidade: ");
        String cidade = input.nextLine();

        System.out.print("CEP: ");
        String cep = input.nextLine();

        Cliente cadastro = new Cliente(codigoDoCliente, nome, telefone, email, cpf, rua, bairro, numeroCasa, cep, cidade);

        listaClientes.add(cadastro);
        //Metodo que Salva dados em Lista de array
        arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(listaClientes, endArqCliente);

        // Obtém a quantidade de novos clientes a serem adicionados
        /**
         * Atualização do contador de clientes: O método realiza a atualização
         * do contador de clientes, que controla o número total de clientes
         * cadastrados. Há duas soluções diferentes implementadas
         */
        int quantidadeNovosCont = 1;

        // Acessando a solução 1 (encapsulamento)
        /**
         * Solução 1 - Encapsulamento: O contador é acessado usando os métodos
         * getContadorClientesEncapsulamento e setContadorClientesEncapsulamento
         * da classe Sistema. O valor atual do contador é exibido e, em seguida,
         * é incrementado com a quantidade de novos clientes cadastrados
         */
        int contadorEncapsulamento = Sistema.getContadorClientesEncapsulamento();
        System.out.println("Contador de Clientes (Encapsulamento): " + contadorEncapsulamento);
        Sistema.setContadorClientesEncapsulamento(contadorEncapsulamento + quantidadeNovosCont);
        contadorEncapsulamento = Sistema.getContadorClientesEncapsulamento();
        System.out.println("Novo valor do contador de clientes (Encapsulamento): " + contadorEncapsulamento);

        // Acessando a solução 2 (controle de acesso protected)
        /**
         * Solução 2 - Controle de acesso protegido: O contador é acessado
         * diretamente usando a variável contadorClientesProtegido da classe
         * Sistema. O valor atual do contador é exibido e, em seguida, é
         * incrementado com a quantidade de novos clientes cadastrados
         */
        int contadorProtegido = Sistema.contadorClientesProtegido;
        System.out.println("Contador de Clientes (Protegido): " + contadorProtegido);
        Sistema.contadorClientesProtegido += quantidadeNovosCont;
        contadorProtegido = Sistema.contadorClientesProtegido;
        System.out.println("Novo valor do contador de clientes (Protegido): " + contadorProtegido);

        // Atualiza o arquivo JSON com a quantidade de novos clientes
        /**
         * Atualização do arquivo JSON do contador: O arquivo JSON que armazena
         * a quantidade de novos clientes cadastrados é atualizado usando o
         * método salvarDadosContador da classe JsonFerramentas. O valor da
         * quantidade de novos clientes é fornecido como argumento juntamente
         * com o caminho do arquivo JSON
         */
        arquivos.JsonFerramentas.salvarDadosContador(quantidadeNovosCont, "./src/arquivos/CLIENTESX.json");

    }

    //metodo cadastrar Cliente para Tela
    //Questao 7
    //esse metodo verifica se já existe um cliente cpf não pode se repetir
    /**
     * método percorre a lista de clientes e verifica se algum deles possui o
     * mesmo CPF fornecido. Ele retorna true se encontrar um cliente com o CPF
     * correspondente e false caso contrário. Esse método é útil para evitar o
     * cadastro duplicado de clientes com o mesmo CPF
     *
     *
     */
    public static boolean clienteJaCadastrado(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCPF().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    /**
     * responsável por realizar o cadastro de um novo cliente
     *
     */
    public static void cadastroCliente(String nome, String cpf, String telefone, String email, String rua, String numeroCasa, String bairro, String cidade, String cep) {
        // Verificar se o cliente já está cadastrado
        /**
         * chama a função clienteJaCadastrado(cpf) para verificar se o cliente
         * já está cadastrado com o mesmo CPF. Se a verificação retornar true, é
         * exibida uma mensagem de erro informando que o cliente já está
         * cadastrado, e o método é encerrado sem adicionar o cliente duplicado
         */
        if (clienteJaCadastrado(cpf)) {
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado");
            return; // Retorna sem adicionar o cliente duplicado
        }

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int codigoDoCliente = random.nextInt(10000);

        Cliente cadastro = new Cliente(codigoDoCliente, nome, telefone, email, cpf, rua, bairro, numeroCasa, cep, cidade);

        // Limpar a lista de clientes
        listaClientes.clear();

        // Adicionar o novo cliente à lista
        listaClientes.add(cadastro);

        // Salvar a lista de clientes no arquivo JSON
        arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(listaClientes, endArqCliente);

        /**
         * Atualização do contador de clientes: São feitas atualizações no
         * contador de clientes, tanto na solução 1 (encapsulamento) quanto na
         * solução 2 (controle de acesso protected). O valor do contador é
         * incrementado com a quantidade de novos clientes a serem adicionados.
         *
         * Atualização do arquivo JSON de contador: O arquivo JSON que armazena
         * a quantidade de novos clientes é atualizado com o valor atualizado do
         * contador.
         */
        // Obtém a quantidade de novos clientes a serem adicionados
        int quantidadeNovosCont = 1;

        // Acessando a solução 1 (encapsulamento)
        int contadorEncapsulamento = Sistema.getContadorClientesEncapsulamento();
        System.out.println("Contador de Clientes (Encapsulamento): " + contadorEncapsulamento);
        Sistema.setContadorClientesEncapsulamento(contadorEncapsulamento + quantidadeNovosCont);
        contadorEncapsulamento = Sistema.getContadorClientesEncapsulamento();
        System.out.println("Novo valor do contador de clientes (Encapsulamento): " + contadorEncapsulamento);

        // Acessando a solução 2 (controle de acesso protected)
        int contadorProtegido = Sistema.contadorClientesProtegido;
        System.out.println("Contador de Clientes (Protegido): " + contadorProtegido);
        Sistema.contadorClientesProtegido += quantidadeNovosCont;
        contadorProtegido = Sistema.contadorClientesProtegido;
        System.out.println("Novo valor do contador de clientes (Protegido): " + contadorProtegido);

        // Atualiza o arquivo JSON com a quantidade de novos clientes
        arquivos.JsonFerramentas.salvarDadosContador(quantidadeNovosCont, "./src/arquivos/CLIENTESX.json");
    }

    /**
     * //Questao 7 e 8 exibir as informações de um cliente específico no
     * terminal
     */
   
    public static void verClientesTerminal() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nDIGITE O GODIGO DO CLIENTE: ");
        int codg = input.nextInt();
        /**
         * Leitura do arquivo JSON: O método leituraArquivoJson da classe
         * JsonFerramentas é chamado para ler o arquivo JSON que contém os
         * clientes. O arquivo lido é o especificado pela variável
         * endArqCliente. O código do cliente fornecido pelo usuário é passado
         * como argumento para que apenas o cliente correspondente seja
         * retornado
         */
        List<Cliente> listaClientes = JsonFerramentas.leituraArquivoJson(endArqCliente, Cliente.class, codg);
        System.out.println(listaClientes.toString());
    }

    /**
     * Questao 7 e 8 Terminal
     *
     * método solicita ao usuário o CPF de um cliente, busca o cliente
     * correspondente no arquivo JSON e exibe suas informações caso ele seja
     * encontrado. Caso contrário, uma mensagem de erro é exibida
     */
    public static void buscarClientePeloCpf() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nDIGITE O CPF DO CLIENTE: ");
        String cpf = input.next();
        //Json de Busca no Arquivo
        Cliente clienteEncontrado = arquivos.JsonFerramentas.buscarClientePorCPF(cpf);

        if (clienteEncontrado != null) {
            System.out.println("\nCliente encontrado: " + clienteEncontrado);
        } else {
            System.err.println("\nCliente não encontrado.");
        }
    }

    /**
     * Questão 8
     *
     */
    public static Cliente buscarClientePeloCpfTela(String cpf) {
        Cliente clienteEncontrado = arquivos.JsonFerramentas.buscarClientePorCPF(cpf);

        if (clienteEncontrado != null) {
            System.out.println("\nCliente encontrado: " + clienteEncontrado);
        } else {
            System.err.println("\nCliente não encontrado.");
        }

        return clienteEncontrado;
    }

    /**
     * Questão 8
     *
     * metodo verCliente Cliente para Tela
     *
     */
    public static List<Cliente> verClientes(int codigoCliente) {
        List<Cliente> listaClientes = JsonFerramentas.leituraArquivoJson(endArqCliente, Cliente.class, codigoCliente);
        return listaClientes;
    }

    /**
     * Questão 7
     */
    public static void editarClienteTerminal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o codigo: ");
        int cadCliente = input.nextInt();

        System.out.print("");
        String novoTella = input.nextLine();

        System.out.print("Digite o Novo TEL: ");
        String novoTell = input.nextLine();

        System.out.print("Digite o Novo E-MAIL: ");
        String novoEmaill = input.nextLine();

        System.out.print("Digite o Novo BAIRRO: ");
        String novoBairroo = input.nextLine();

        System.out.print("Digite o Novo RUA: ");
        String novoRua = input.nextLine();

        System.out.print("Digite o Novo NUMERO: ");
        String novoNumCasa = input.nextLine();

        System.out.print("Digite o Novo CIDADE: ");
        String novoCidadee = input.nextLine();

        System.out.print("Digite o Novo CEP: ");
        String novoCepp = input.nextLine();

        List<Cliente> clientes = leituraArquivo(endArqCliente, new TypeToken<List<Cliente>>() {
        }.getType());
        arquivos.JsonFerramentas.editarArquivoJson(clientes, cadCliente, novoTell, novoEmaill, novoRua, novoNumCasa, novoBairroo, novoCidadee, novoCepp, null, null, endArqCliente);
    }

    /**
     * Questão 7
     *
     * metodo editarCliente para Tela
     *
     */
    public static void editarCliente(int cadCliente, String novoTell, String novoEmaill, String novoBairroo, String novoRua, String novoNumCasa, String novoCidadee, String novoCepp) {
        List<Cliente> clientes = leituraArquivo(endArqCliente, new TypeToken<List<Cliente>>() {
        }.getType());
        arquivos.JsonFerramentas.editarArquivoJson(clientes, cadCliente, novoTell, novoEmaill, novoRua, novoNumCasa, novoBairroo, novoCidadee, novoCepp, null, null, endArqCliente);
    }

    /**
     * Questão 7
     *
     * excluir um cliente do sistema a partir do código fornecido pelo usuário
     */
    public static void excluirClienteTerminal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o codigo: ");
        int cadCliente = input.nextInt();
        Type clienteListType = new TypeToken<List<Cliente>>() {
        }.getType();
        arquivos.JsonFerramentas.removerObjeto(cadCliente, endArqCliente, clienteListType);
    }

    /**
     * Questão 7
     *
     * metodo Excluir Cliente para Tela
     *
     * excluir um cliente do sistema a partir do código fornecido pelo usuário
     */
    public static void excluirCliente(int cadCliente) {
        Type clienteListType = new TypeToken<List<Cliente>>() {
        }.getType();
        arquivos.JsonFerramentas.removerObjeto(cadCliente, endArqCliente, clienteListType);
    }

    /**
     * Questão 13
     *
     * Metodo para ordenar lista de Clientes com base no nome
     *
     *
     * o método lê os dados dos clientes de um arquivo JSON, os armazena em uma
     * lista, ordena a lista com base no critério de comparação definido na
     * classe Cliente e exibe a lista antes e depois da ordenação. Isso permite
     * visualizar os clientes em ordem alfabética pelo nome.
     *
     *
     */
    public static void ordenarCliente() throws IOException {
        // Comparador para a Classe Cliente
        //criada uma lista chamada listaClientes
        List<Cliente> listaClientes = new ArrayList<>();
        //é preenchida com os objetos de clientes lidos do arquivo JSON usando o método leituraArquivoClientee()
        //faz a leitura do arquivo JSON contendo os dados dos clientes e retorna uma lista de objetos Cliente
        listaClientes = arquivos.JsonFerramentas.leituraArquivoClientee();

        // Antes da ordenação
        System.out.println("Antes da Ordenacao:");
        //Cliente o é uma declaração de variável que representa cada elemento da lista listaClientes
        //o recebe um dos objetos da lista listaClientes.
        for (Cliente o : listaClientes) {
            //getNome() do objeto o, que retorna o nome do cliente
            System.out.println(o.getNome());
        }
        System.out.println("-----------------------------------");

        // Ordenação da lista de clientes
        //usa o metodo SORT da coleção COLLECTIONS para fazer a ordenação
        Collections.sort(listaClientes, new Cliente());

        // Após a ordenação
        System.out.println("Apos a Ordenacao:");
        for (Cliente o : listaClientes) {
            System.out.println(o.getNome());
        }
    }

    /**
     * Questao 3 Sobreescrita da Saida
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nCodigo: " + codigoDoCliente + "\nNome: " + getNome() + "\nCPF: " + getCpf()
                + "\nTelefone: " + telefone + "\nE-mail: " + email + "\nRua: " + rua
                + "\nNumero da Casa:" + numeroCasa + "\nBairro: " + bairro + "\nCidade: " + cidade
                + "\nCEP: " + cep + "\n";
    }

    /**
     * Questão 13
     *
     * Se o nome do cliente1 for lexicograficamente menor (anterior) ao nome do
     * cliente2, o valor de retorno será negativo. Se o nome do cliente1 for
     * lexicograficamente maior (posterior) ao nome do cliente2, o valor de
     * retorno será positivo. Se os nomes dos dois clientes forem iguais, o
     * valor de retorno será zero durante a ordenação da lista de clientes, o
     * método compare será invocado para comparar pares de objetos Cliente e
     * determinar a ordem correta com base nos nomes. Isso resultará na
     * ordenação da lista de clientes em ordem alfabética crescente pelo nome.
     *
     *
     */
    @Override
    public int compare(Cliente cliente1, Cliente cliente2) {
        return cliente1.getNome().compareTo(cliente2.getNome());
    }

}
