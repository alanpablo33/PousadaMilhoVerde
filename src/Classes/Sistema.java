/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Alan Pablo
 */
import static Classes.Reserva.lerReservaPorCPF;
import arquivos.JsonFerramentas;
import java.io.IOException;
import java.util.Scanner;

public class Sistema {

    /**
     *
     * Questao 1 todas as classes foram Implementadas com base no diagrama de
     * classes criado
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 2 O Sistema so e acessado pelo colaboradores e pelo
     * administrador, de acordo o o login e senha de cada um.
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 3 Todas as Classes foram sobrescritas usando o metodo toString().
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 4 Todos os construtores das subclasses utilizam a palavra-chave
     * super para, para serem utilizados.
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 5 Na Classe quarto foi criado de forma estatica os 10 quartos da
     * pousada, 5 normais e 5 de luxo. Se encontra na Classe Quartos
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 6 Na Classe Adm, temos os metodos para cadastrar os colaboradores
     * no sistema, alterar ou editar seus atributos. Na Classe Adm, podemos
     * Fazer tanto para Adm quanto para Funcionario
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 7 Na Classe Cliente, temos os metodos Cadastrar, alterar ou
     * excluir clientes.
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 8 Na Classe Reserva Temos o Metodo imprimir dados das reservas e
     * dos clientes de acorod com o numero da Reserva do cliente. Podemos ver a
     * Reserva , adicionar valores extras a mesma
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 9 Metodos para salvas as Reservas de forma dinâmica no sistema,
     * estão no package arquivo na Classe JsonFerramentas. Todos os Metodos para
     * salvar os dados do Sistema estão na Classe JsonFerramentas
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 10 Cada reserva efetuada gerar um extrato impresso e salvo junto
     * com a informação do cliente que fez a reserva Assim que um cliente efetua
     * sua reserva e salvo eu um arquivo json uma lista onde contem os dados do
     * cliente e da reserva.
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 11 Contador de instâncias para a Classe Cliente de tipo protect e
     * private static criador na Classe Sistema O mesmo salva esses dados em um
     * aruivo json -------------------------------------------------------
     * vantagens do Encapsulamento (private static com métodos get e set):
     * impedindo o acesso direto de outras classes e garantindo maior controle
     * sobre sua manipulação. Maior flexibilidade com os métodos get e set,
     * podemos controlar como a contagem de instâncias é acessada e modificada,
     * permitindo a implementação de lógicas adicionais se necessário.
     * Facilidade de manutenção qualquer alteração na lógica de contagem de
     * instâncias pode ser feita internamente nos métodos get e set, sem afetar
     * outras partes do código. desvantagens do Encapsulamento (private static
     * com métodos get e set): A necessidade de métodos adicionais: a
     * implementação envolve a criação de métodos get e set, o que pode aumentar
     * a quantidade de código necessário.
     * ------------------------------------------------------- vantagens do
     * Controle de Acesso 'protected': Acesso controlado dentro da hierarquia de
     * classes a palavra-chave protected permite o acesso ao atributo
     * contadorInstancias nas classes derivadas da classe Sistema, permitindo
     * seu uso em classes filhas, mas mantendo-o oculto para outras classes fora
     * dessa hierarquia Simplicidade de implementação não são necessários
     * métodos adicionais para acessar ou modificar o contador de instâncias.
     * desvantagens do Controle de Acesso 'protected': Menos controle sobre a
     * manipulação como o atributo contadorInstancias é acessível diretamente
     * por classes derivadas, pode ser mais difícil controlar ou monitorar como
     * ele é modificado. Menor encapsulamento o atributo contadorInstancias é
     * acessível por outras classes derivadas da classe Sistema, o que pode
     * levar a uma menor encapsulação e maior acoplamento entre as classes
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 12 Metodo Contador de Instancias da Classe Reserva se encontra na
     * Classe sistema, o mesmo foi feito com base no tipo protected. Opcao 5
     * depois 2
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 13 Comparator para as classes Cliente e Reserva, feitos ambos em
     * suas Classes mas chamados na main Opcao 6 do menu
     * --------------------------------------------------------------------------------------------------------------------------------------
     * Questao 14 Todos os dados estão sendo salvos pelos metodos Json criados
     * que se encontram no package arquivo Classe JsonFerramentas No Pacote
     * arquivo a Classe JsonFerramentas, possui todos os metodos para Salvar ,
     * ler e Pesquisar Json Usei Tambem a Biblioteca Gson para uma melhor
     * organização doS Dados Salvos.
     * --------------------------------------------------------------------------------------------------------------------------------------
     *
     */
    private boolean autenticado = false;

    /**
     * Questao 11 Solução 1 (encapsulamento)
     */
    private static int contadorClientes = 0;
    /**
     * Questao 11 Solução 2 (controle de acesso protected)
     */
    protected static int contadorClientesProtegido = 0;

    /**
     * Questao 12
     */
    protected static int contadorReservas = 0;

    /**
     * Questao 11 Métodos getters e setters para a solução 1 (encapsulamento)
     */
    public static int getContadorClientesEncapsulamento() {
        return contadorClientes;
    }

    public static void setContadorClientesEncapsulamento(int contador) {
        contadorClientes = contador;
    }

    /**
     *
     * O Metodo EX() foi o metodo que eu usava para testar todos os metodos na
     * criação do sistema da Pousada, ele e todo feito para ser usado no
     * terminal, não apaguei os metodos feitos no terminal caso queira usar.
     */
    public static void EX() throws IOException {

        System.out.println("Sistema Da Pusada Milho Verde");
        Scanner input = new Scanner(System.in);
        System.out.print("\nOpcoes Cliente:-----------(1)\nFazer Reserva:------------(2)\nConta Do Cliente:---------(3)\nVer Quartos:--------------(4)\nOpcoes ADM:---------------(5)\nMetodos de Ordenacao:-----(6)\nSair do Sistema:----------(9)\n");
        System.out.print("\nDigite o Numero Correspondente a Opcao desejada:  ");
        String opc = input.next();
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /**
         * Menu Cliente
         */
        if (opc.equals("1")) {
            System.out.print("\nCadastrar Digite:---------(1)\nPesquisar Cadastro:-------(2)\nEditar Cadastro:----------(3)\nExcluir Cadastro:---------(4)\nSair do Sistema:----------(9)\n");
            String senhaDigitada = input.next();

            if (senhaDigitada.equals("1")) {
                Cliente.cadastroClienteTerminal();

            } else if (senhaDigitada.equals("2")) {
                System.out.print("\nPesquisar Pelo CODIGO:------------(1)\nPesquisar Pelo CPF:---------------(2)\nVer Todos:------------------------(3)\n");
                String x = input.next();

                if (x.equals("1")) {
                    Cliente.verClientesTerminal();

                } else if (x.equals("2")) {
                    Cliente.buscarClientePeloCpf();

                } else if (x.equals("3")) {
                    arquivos.JsonFerramentas.VerListaDeClientes();

                } else {
                    System.err.println("SISTEMA ENCERRADO!");
                }

            } else if (senhaDigitada.equals("3")) {
                Cliente.editarClienteTerminal();

            } else if (senhaDigitada.equals("4")) {
                Cliente.excluirClienteTerminal();

            } else {
                System.err.println("SISTEMA ENCERRADO!");
            }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            /**
             * Menu Reserva
             */
        } else if (opc.equals("2")) {
            System.out.print("Fazer Reserva:----------------------------(1)\nCancelar Reserva:-------------------------(2)\nVer Status do Reserva:--------------------(3)\nAdicionar Valor Adicional a Reserva:------(4)\n");
            String x = input.next();

            if (x.equals("1")) {
                Reserva.criarSalvarReservaTerminal();

            } else if (x.equals("2")) {
                Reserva.cancelarReservaDoCliente();

            } else if (x.equals("3")) {
                Reserva.lerReservaPorCodigo();

            } else if (x.equals("4")) {
                Reserva.adicionarValorAdicional();

            } else {
                System.err.println("SISTEMA ENCERRADO!");
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            /**
             * Menu Conta do Cliente
             */
        } else if (opc.equals("3")) {
            System.out.println("\n");
            System.out.print("\n\nPesquisar Pelo CODIGO:----------------(1)\nPesquisar Pelo CPF:-------------------(2)\n\n");
            String t = input.next();

            if (t.equals("1")) {
                ReceitaDaPousada.Contabilidade.pesquisarDebitosDoCliente();

            } else if (t.equals("2")) {
                lerReservaPorCPF();
            } else {
                System.err.println("SISTEMA ENCERRADO!");
            }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            /**
             * Menu Quartos
             */
        } else if (opc.equals("4")) {
            System.out.println("Quartos de 1 a 5 Normais de 6 a 10 de Luxo");
            System.out.println("\nVeja a Disponibilidade dos Quartos \nDigite o Numero do quarto: ");
            int y = input.nextInt();
            Quartos.buscarQuartoPorCodigo(y);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            /**
             * Menu ADM
             */
        } else if (opc.equals("5")) {

            System.out.print("\n\nVer Instancias de Clientes protect e private:------------------(1)\nVer Instancias Quantas de Clientes e Reservas:-----------------(2)\nReceita Mensal da Pousada Milho Verde:-------------------------(3)\nCadastrar Membro:----------------------------------------------(4)\nVer dados de um Membro:----------------------------------------(5)\nEditar Membro:-------------------------------------------------(6)\nExcluir Membro:------------------------------------------------(7)\n\n");
            String x = input.next();

            if (x.equals("1")) {
                /**
                 * Questao 11 Ver Quantas instancias já foram criadas
                 */
                JsonFerramentas.lerInstanciasCliente();

            } else if (x.equals("2")) {
                /**
                 * Questao 12
                 *
                 * E chamado o número de instâncias de reservas que foi salvo em
                 * um arquivo Json de dados. O valor retornado é atribuído à
                 * variável instanciaReserva do tipo int,na Classe Reserva
                 */
                int instanciaReserva = arquivos.JsonFerramentas.lerInstanciaReserva();
                System.out.println("\nNumero de instancias de Reserva: " + instanciaReserva);
                JsonFerramentas.lerInstanciasCliente();

            } else if (x.equals("3")) {
                System.out.println("\nFazer Pesquisa de Receita Mensal da Pousada Milho Verde \nDigite no Formato Ano-Mes, para fazer a busca: ");
                Scanner k = new Scanner(System.in);
                String codg = k.next();
                ReceitaDaPousada.Contabilidade.receitaMesal(codg);

            } else if (x.equals("4")) {
                //Criar Cadastro para Adm ou Funcionario
                Adm.cadastrarAeFnoTerminal();

            } else if (x.equals("5")) {
                //ver Adm ou Funcionario
                Adm.verMembroTerminal();

            } else if (x.equals("6")) {
                //Editar Adm ou Funcionario
                Adm.editarMembroTerminal();

            } else if (x.equals("7")) {
                //Excluir Adm ou Funcionario
                Adm.excluirMembroTerminal();

            } else {
                System.err.println("SISTEMA ENCERRADO!");
            }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            /**
             * Menu Ordenacao Questao 13
             */
        } else if (opc.equals("6")) {
            System.out.print("\n\nOrdenacao Para Classe Cliente:---(1)\nOrdenacao Para Classe Reserva:---(2)\n\n");
            String r = input.next();
            System.err.println("\n");

            if (r.equals("1")) {
                //Ordenacao Para Classe Cliente
                System.out.println("\nOrdenacao Por Nome\n");
                Cliente.ordenarCliente();

            } else if (r.equals("2")) {
                //Ordenação Para Classe Reserva
                System.out.println("\nOrdenacao Por Valor da Despeza\n");
                Reserva.ordenarReserva();

            } else {
                System.err.println("SISTEMA ENCERRADO!");
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        }

    }
}
