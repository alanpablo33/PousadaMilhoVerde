/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import arquivos.JsonFerramentas;
import static arquivos.JsonFerramentas.leituraArquivo;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JTextPane;

/**
 *
 *
 * @author Alan Pablo
 */
/**
 * E uma subclasse da classe Funcionario. A classe Adm representa um
 * administrador em um sistema e possui atributos e métodos relacionados ao
 * cadastro e gerenciamento de administradores.
 */
public class Adm extends Funcionario {

    /**
     * endArqUsuarios: Constante que armazena o caminho para o arquivo JSON que
     * contém os dados dos usuários
     *
     * endArqFuncionario: Constante que armazena o caminho para o arquivo JSON
     * que contém os dados dos funcionários
     *
     * endArqAdm: Constante que armazena o caminho para o arquivo JSON que
     * contém os dados dos administradores
     *
     * listaDeUsuarios: Lista que armazena os objetos da classe Adm,
     * representando os usuários do sistema
     *
     * listaFuncionarios: Lista que armazena os objetos da classe Funcionario,
     * representando os funcionários do sistema
     *
     * listaAdm: Lista que armazena os objetos da classe Adm, representando os
     * administradores do sistema
     *
     * idAdm: Atributo que armazena o identificador do administrador
     * ("funcionario" ou "admin")
     *
     * codigoDoUser: Atributo que armazena o código do usuár
     *
     */
    protected static final String endArqUsuarios = "./src/arquivos/DADOS_USUARIOS.json";//caminho para salvar no Arquivo USUARIOS
    private static final String endArqFuncionario = "./src/arquivos/DADOS_CADASTRO_FUNCIONARIO.json";
    private static final String endArqAdm = "./src/arquivos/DADOS_CADASTRO_ADM.json";
    protected static List<Adm> listaDeUsuarios = new ArrayList<>();
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();
    private static List<Adm> listaAdm = new ArrayList<>();
    private String idAdm;
    private int codigoDoUser;

    public int getCodigoDoUser() {
        return codigoDoUser;
    }

    public void setCodigoDoUser(int codigoDoUser) {
        this.codigoDoUser = codigoDoUser;
    }

    public String getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(String idAdm) {
        this.idAdm = idAdm;
    }

    /**
     * Adm(): Construtor vazio da classe
     *
     * Adm(int codigoDoUser, String idAdm, String loginF, String senhaF, String
     * telefone, String email, String rua, String bairro, String numeroCasa,
     * String cep, String cidade, String nome, String cpf):
     *
     * Construtor da classe que recebe os dados do administrador e os atribui
     * aos respectivos atributos
     *
     * Adm(int codigoDoUser, String idAdm, String telefone, String email, String
     * rua, String bairro, String numeroCasa, String cep, String cidade, String
     * nome, String cpf):
     *
     * Construtor da classe que recebe os dados do administrador (sem login e
     * senha) e os atribui aos respectivos atributos
     */
    //construtores
    public Adm() {

    }

    /**
     * Questão 04
     *
     * Cadastro Funcionario Utilização da Palavra reservada super para
     * implementar construtores das subclasses.
     */
    public Adm(int codigoDoUser, String idAdm, String loginF, String senhaF, String telefone, String email, String rua, String bairro, String numeroCasa, String cep, String cidade, String nome, String cpf) {

        super(loginF, senhaF, telefone, email, rua, bairro, numeroCasa, cep, cidade, nome, cpf);
        this.idAdm = idAdm;
        this.codigoDoUser = codigoDoUser;
    }

    /**
     * Questão 04
     *
     * Cadastro ADM Utilização da Palavra reservada super para implementar
     * construtores das subclasses.
     */
    public Adm(int codigoDoUser, String idAdm, String telefone, String email, String rua, String bairro, String numeroCasa, String cep, String cidade, String nome, String cpf) {

        super(telefone, email, rua, bairro, numeroCasa, cep, cidade, nome, cpf);
        this.idAdm = idAdm;
        this.codigoDoUser = codigoDoUser;
    }

    /**
     * Questão 6
     *
     * Cadastrar Cliente ou funcionario terminal e responsável por cadastrar um
     * funcionário ou administrador (ADM) por meio do terminal/console Gera um
     * código de identificação aleatório para o funcionário ou ADM. Solicita ao
     * usuário que escolha entre cadastrar um funcionário ou um ADM digitando 1
     * ou 2, respectivamente. Coleta os dados pessoais do indivíduo, como nome,
     * CPF, telefone, e-mail, endereço (rua, bairro, número da casa, CEP e
     * cidade), login e senha. Com base na opção escolhida pelo usuário, o
     * método cria um objeto Adm (funcionário ou ADM) com os dados fornecidos.
     * Adiciona o objeto criado à lista de funcionários ou ADMs, dependendo da
     * opção escolhida. Salva as listas atualizadas de funcionários e usuários
     * em arquivos JSON. Exibe uma mensagem informando que o funcionário ou ADM
     * foi cadastrado com sucesso
     */
    public static void cadastrarAeFnoTerminal() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int codigo = random.nextInt(10000);

        System.out.print("\nDigite 1 para cadastrar um funcionario ou 2 para cadastrar um ADM: ");
        int opcao = input.nextInt();
        input.nextLine(); // Limpa o buffer do Scanner

        System.out.print("Nome: ");
        String nom = input.nextLine();

        System.out.print("CPF: ");
        String cpff = input.nextLine();

        System.out.print("TEL: ");
        String tel = input.nextLine();

        System.out.print("E-MAIL: ");
        String emaill = input.nextLine();

        System.out.print("RUA: ");
        String ruaa = input.nextLine();

        System.out.print("BAIRRO: ");
        String bairroo = input.nextLine();

        System.out.print("NUMERO CASA: ");
        String numerocasa = input.nextLine();

        System.out.print("CEP:");
        String ce = input.nextLine();

        System.out.print("CIDADE:");
        String cidad = input.nextLine();

        System.out.print("LOGIN: ");
        String login = input.nextLine();

        System.out.print("SENHA: ");
        String senha = input.nextLine();

        if (opcao == 1) {
            String idAdm = "funcionario";
            /**
             * Instancia da classe ADM
             */
            Adm funcionario = new Adm(codigo, idAdm, login, senha, tel, emaill, ruaa, bairroo, numerocasa, ce, cidad, nom, cpff);
            listaFuncionarios.add(funcionario);
            listaDeUsuarios.add(funcionario);
            /**
             * Chamada do Metodo salvarEmArquivoJsonTodos para salvar os dados
             * Funcionario em uma lista e depois no Arquivo Json de Funcionario
             */
            arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(listaFuncionarios, endArqFuncionario);
            arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(listaDeUsuarios, endArqUsuarios);
            System.out.println("\nFuncionario cadastrado com sucesso.");

        } else if (opcao == 2) {
            String idAdm = "admin";
            /**
             * Instancia da classe ADM
             */
            Adm adm = new Adm(codigo, idAdm, login, senha, tel, emaill, ruaa, bairroo, numerocasa, ce, cidad, nom, cpff);
            listaAdm.add(adm);
            listaDeUsuarios.add(adm);
            /**
             * Chamada do Metodo salvarEmArquivoJsonTodos para salvar os dados
             * Adm em uma lista e depois no Arquivo Json de ADM
             */
            arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(listaAdm, endArqAdm);
            arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(listaDeUsuarios, endArqUsuarios);

            System.out.println("\nADM cadastrado com sucesso.");

        } else {
            System.err.println("\nOpcao invalida.");
        }
    }

    /**
     * Questão 6
     *
     * Tive que usar o metodo Collections.singletonList, é um método estático da
     * classe java.util.Collections que retorna uma lista imutável (não
     * modificável) contendo apenas um único elemento especificado. O Metodo
     * cadastrarF faz a Mesma função do Metodo cadastrarAeFnoTerminal a
     * diferença e que um metodo esta construido para ser usado no terminal e o
     * outro foi construido para ser chamado na Tela de interação
     */
    public static void cadastrarF(String nome, String cpf, String telefone, String email, String rua, String bairro, String numeroCasa, String cep, String cidade, String login, String senha) {
        Random random = new Random();
        int codigo = random.nextInt(10000);
        String idAdm = "funcionario";
        Adm funcionario = new Adm(codigo, idAdm, login, senha, telefone, email, rua, bairro, numeroCasa, cep, cidade, nome, cpf);

        // Carrega a lista existente de funcionários do arquivo JSON
        List<Adm> listaFuncionarios = arquivos.JsonFerramentas.leituraArquivoJson(endArqFuncionario, Adm.class);

        // Adiciona o novo funcionário à lista existente
        listaFuncionarios.add(funcionario);

        // Salva apenas o novo funcionário no arquivo JSON
        arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(Collections.singletonList(funcionario), endArqFuncionario);
        arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(Collections.singletonList(funcionario), endArqUsuarios);

        System.out.println("\nFuncionário cadastrado com sucesso.");
    }

    /**
     * Questao 6
     *
     * O Metodo cadastrarA faz a Mesma função do Metodo cadastrarAeFnoTerminal a
     * diferença e que um metodo esta construido para ser usado no terminal e o
     * outro foi construido para ser chamado na Tela de interação
     */
    public static void cadastrarA(int opcao, String nome, String cpf, String telefone, String email, String rua, String bairro, String numeroCasa, String cep, String cidade, String login, String senha) {
        Random random = new Random();
        int codigo = random.nextInt(10000);
        String idAdm = "admin";
        Adm adm = new Adm(codigo, idAdm, login, senha, telefone, email, rua, bairro, numeroCasa, cep, cidade, nome, cpf);

        // Carrega a lista existente de administradores do arquivo JSON
        List<Adm> listaAdm = arquivos.JsonFerramentas.leituraArquivoJson(endArqAdm, Adm.class);

        // Adiciona o novo administrador à lista existente
        listaAdm.add(adm);

        // Salva apenas o novo administrador no arquivo JSON
        arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(Collections.singletonList(adm), endArqAdm);
        arquivos.JsonFerramentas.salvarEmArquivoJsonTodos(Collections.singletonList(adm), endArqUsuarios);

        System.out.println("\nADM cadastrado com sucesso.");
    }

    /**
     * Ver membro Terminal
     *
     * O Metodo verMembroTerminal e responsável por exibir as informações de um
     * membro (funcionário ou ADM) com base no código de membro fornecido O
     * método inicia a leitura de entrada do usuário a partir do terminal usando
     * o objeto Scanner. Solicita ao usuário que digite o código do membro que
     * deseja visualizar. Coleta o código digitado pelo usuário. Realiza a
     * leitura do arquivo JSON que contém a lista de membros (funcionários e
     * ADMs) usando o método leituraArquivoJson() da classe JsonFerramentas.
     * Passa o caminho do arquivo JSON, o tipo de classe (Adm.class) e o código
     * do membro como argumentos para o método leituraArquivoJson(). O método
     * leituraArquivoJson() retorna uma lista de membros que correspondem ao
     * código fornecido. Exibe as informações dos membros encontrados usando o
     * método toString() da lista de membros
     */
    public static void verMembroTerminal() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nDIGITE O GODIGO DO MEMBRO: ");
        int codg = input.nextInt();

        List<Adm> listaDeUsuarios = JsonFerramentas.leituraArquivoJson(endArqUsuarios, Adm.class, codg);
        System.out.println(listaDeUsuarios.toString());
    }

    //Ver Membro na Tela
    /**
     *
     * O método verMembroTela(int codigo, StringBuilder sb) é responsável por
     * buscar e formatar as informações de um membro (funcionário ou ADM) com
     * base no código de membro fornecido. Ele tem a mesma função do metodo
     * verMembroTerminal porem foi feito para ser usado em uma janela de
     * interção com o usuario Ele funciona assim: O método recebe o código do
     * membro como parâmetro, bem como um objeto StringBuilder chamado sb, que
     * será usado para construir uma representação formatada das informações do
     * membro. Realiza a leitura do arquivo JSON que contém a lista de membros
     * (funcionários e ADMs) usando o método leituraArquivoJson() da classe
     * JsonFerramentas. Passa o caminho do arquivo JSON, o tipo de classe
     * (Adm.class) e o código do membro como argumentos para o método
     * leituraArquivoJson(). O método leituraArquivoJson() retorna uma lista de
     * membros que correspondem ao código fornecido. Utiliza um loop for-each
     * para percorrer cada membro da lista de membros encontrados. Dentro do
     * loop, extrai as informações do membro (como ID do ADM, código do usuário,
     * login, senha, etc.) usando os métodos getter da classe Adm. Adiciona as
     * informações formatadas ao objeto StringBuilder sb, usando o método
     * append(). Insere quebras de linha (System.lineSeparator()) para separar
     * cada informação do membro. Repete o processo para todos os membros
     * encontrados na lista. Ao final do método, sb conterá a representação
     * formatada das informações dos membros correspondentes ao código fornecido
     */
    public static void verMembroTela(int codigo, StringBuilder sb) {
        List<Adm> listaDeUsuarios = JsonFerramentas.leituraArquivoJson(endArqUsuarios, Adm.class, codigo);

        for (Adm adm : listaDeUsuarios) {
            sb.append("ID do ADM: ").append(adm.getIdAdm()).append(System.lineSeparator());
            sb.append("Código do Usuário: ").append(adm.getCodigoDoUser()).append(System.lineSeparator());
            sb.append("Login: ").append(adm.getLoginF()).append(System.lineSeparator());
            sb.append("Senha: ").append(adm.getSenhaF()).append(System.lineSeparator());
            sb.append("Código do Cliente: ").append(adm.getCodigoDoCliente()).append(System.lineSeparator());
            sb.append("Telefone: ").append(adm.getTelefone()).append(System.lineSeparator());
            sb.append("E-mail: ").append(adm.getEmail()).append(System.lineSeparator());
            sb.append("Rua: ").append(adm.getRua()).append(System.lineSeparator());
            sb.append("Bairro: ").append(adm.getBairro()).append(System.lineSeparator());
            sb.append("Número da Casa: ").append(adm.getNumeroCasa()).append(System.lineSeparator());
            sb.append("CEP: ").append(adm.getCep()).append(System.lineSeparator());
            sb.append("Cidade: ").append(adm.getCidade()).append(System.lineSeparator());
            sb.append("Nome: ").append(adm.getNome()).append(System.lineSeparator());
            sb.append("CPF: ").append(adm.getCpf()).append(System.lineSeparator());
            sb.append("-----------------------------------").append(System.lineSeparator());
        }
    }

    /**
     *
     * Criei esse metodo caso queira verificar toda a lista de reserva da
     * Pousada responsável por buscar e formatar as informações de todos os
     * membros (funcionários e ADMs) e exibi-las em uma interface gráfica o
     * método busca as informações de todos os membros (funcionários e ADMs),
     * formata essas informações em uma representação legível e as exibe na
     * interface gráfica, no objeto JTextPane telaMostrarMembros. Isso permite
     * que o usuário visualize todas as informações dos membros em um formato
     * estruturado na interface
     */
    public static void verTodosMembrosTela(JTextPane telaMostrarMembros) {
        List<Adm> listaDeUsuarios = JsonFerramentas.leituraArquivoJson(endArqUsuarios, Adm.class);
        StringBuilder sb = new StringBuilder();

        for (Adm adm : listaDeUsuarios) {
            sb.append("ID do ADM: ").append(adm.getIdAdm()).append(System.lineSeparator());
            sb.append("Código do Usuário: ").append(adm.getCodigoDoUser()).append(System.lineSeparator());
            sb.append("Login: ").append(adm.getLoginF()).append(System.lineSeparator());
            sb.append("Senha: ").append(adm.getSenhaF()).append(System.lineSeparator());
            sb.append("Código do Cliente: ").append(adm.getCodigoDoCliente()).append(System.lineSeparator());
            sb.append("Telefone: ").append(adm.getTelefone()).append(System.lineSeparator());
            sb.append("E-mail: ").append(adm.getEmail()).append(System.lineSeparator());
            sb.append("Rua: ").append(adm.getRua()).append(System.lineSeparator());
            sb.append("Bairro: ").append(adm.getBairro()).append(System.lineSeparator());
            sb.append("Número da Casa: ").append(adm.getNumeroCasa()).append(System.lineSeparator());
            sb.append("CEP: ").append(adm.getCep()).append(System.lineSeparator());
            sb.append("Cidade: ").append(adm.getCidade()).append(System.lineSeparator());
            sb.append("Nome: ").append(adm.getNome()).append(System.lineSeparator());
            sb.append("CPF: ").append(adm.getCpf()).append(System.lineSeparator());
            sb.append("-----------------------------------").append(System.lineSeparator());
        }

        // Exibir resultado na interface
        telaMostrarMembros.setText(sb.toString());
    }

//Ver membro Terminal
    /**
     * responsável por remover um membro (funcionário ou ADM) com base no código
     * informado pelo usuário no terminal
     */
    public static void excluirMembroTerminal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o codigo: ");
        int cadMembro = input.nextInt();
        Type membroListType = new TypeToken<List<Adm>>() {
        }.getType();
        arquivos.JsonFerramentas.removerObjeto(cadMembro, endArqUsuarios, membroListType);
    }

    /**
     * Excluir Membro Tela
     *
     * o método permite excluir um membro (funcionário ou ADM) com base no
     * código fornecido. O membro correspondente é removido da lista de membros
     * e o arquivo JSON é atualizado com a lista atualizada. Isso permite a
     * exclusão de membros do sistema.
     */
    public static void excluirMembroTela(int codigo) {
        Type membroListType = new TypeToken<List<Adm>>() {
        }.getType();
        arquivos.JsonFerramentas.removerObjeto(codigo, endArqUsuarios, membroListType);
    }

    //Questao 6
    /**
     * Ver membro Terminal
     *
     * editar as informações de um membro (funcionário ou ADM) com base no
     * código fornecido. As novas informações fornecidas pelo usuário substituem
     * as informações existentes do membro correspondente na lista de membros. O
     * arquivo JSON é atualizado com a lista atualizada, refletindo as
     * alterações feitas no membro
     */
    public static void editarMembroTerminal() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nDigite o codigo: ");
        int cadMembro = input.nextInt();

        System.out.print("");
        String novoTellw = input.nextLine();

        System.out.print("\nDigite o Novo TEL: ");
        String novoTell = input.nextLine();

        System.out.print("\nDigite o Novo E-MAIL: ");
        String novoEmaill = input.nextLine();

        System.out.print("\nDigite o Novo BAIRRO: ");
        String novoBairroo = input.nextLine();

        System.out.print("\nDigite o Novo RUA: ");
        String novoRua = input.nextLine();

        System.out.print("\nDigite o Novo NUMERO: ");
        String novoNumCasa = input.nextLine();

        System.out.print("\nDigite o Novo CIDADE: ");
        String novoCidadee = input.nextLine();

        System.out.print("\nDigite o Novo CEP: ");
        String novoCepp = input.nextLine();

        System.out.print("\nDigite o Novo LOGIN: ");
        String novologin = input.nextLine();

        System.out.print("\nDigite a Nova SENHA: ");
        String novosenha = input.nextLine();

        List<Adm> membro = leituraArquivo(endArqUsuarios, new TypeToken<List<Adm>>() {
        }.getType());
        /**
         * Buscar no arquivo Json com o metodo editarArquivoJson, para ser
         * editado
         */
        arquivos.JsonFerramentas.editarArquivoJson(membro, cadMembro, novoTell, novoEmaill, novoRua, novoNumCasa, novoBairroo, novoCidadee, novoCepp, novologin, novosenha, endArqUsuarios);
    }

    /**
     * editar membros na tela responsável por editar as informações de um membro
     * (funcionário ou administrador) na interface do usuário. Ele recebe os
     * novos valores para as informações do membro, como telefone, e-mail,
     * bairro, rua, número da casa, cidade, CEP, login e senha.
     *
     */
    public static void editarMembroTela(int codigo, String novoTell, String novoEmaill, String novoBairroo, String novoRua, String novoNumCasa, String novoCidadee, String novoCepp, String novologin, String novosenha) {
        List<Adm> membros = leituraArquivo(endArqUsuarios, new TypeToken<List<Adm>>() {
        }.getType());
        arquivos.JsonFerramentas.editarArquivoJson(membros, codigo, novoTell, novoEmaill, novoRua, novoNumCasa, novoBairroo, novoCidadee, novoCepp, novologin, novosenha, endArqUsuarios);
    }

    /**
     * Questao 3 Sobreescrita da Saida
     *
     */
    @Override
    public String toString() {
        return "\nCODIGO: " + getCodigoDoUser() + "\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nLOGIN: " + getLoginF() + "\nSENHA: " + getSenhaF() + "\nTEL: " + getTelefone() + "\nE-MAIL: " + getEmail() + "\nRUA: " + getRua() + "\nBAIRRO: " + getBairro() + "\nNUMERO CASA: " + getNumeroCasa() + "\nCEP:" + getCep() + "\nCIDADE:" + getCidade();
    }

}
