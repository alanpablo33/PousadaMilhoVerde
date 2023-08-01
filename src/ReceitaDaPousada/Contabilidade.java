/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReceitaDaPousada;

import Classes.Cliente;
import Classes.Reserva;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Alan Pablo
 */
public class Contabilidade {

    private static List<Contabilidade> gastosCliente = new ArrayList<>();
    private static final String endArqReserva = "./src/arquivos/DADOS_CADASTRO_RESERVAS.json";

    /**
     * busca uma reserva correspondente a um código de reserva específico. Ele
     * percorre a lista de reservas, verifica cada reserva pelo código e, se
     * encontrar uma correspondência, retorna a reserva encontrada. Além disso,
     * ele imprime informações específicas da reserva encontrada para fins de
     * verificação
     *
     * @param codigoReserva
     * @return
     */
    public static Reserva lerReservaPorCodigo(int codigoReserva) {

        List<Reserva> reservas = lerReservas(); // Lê todas as reservas do arquivo JSON

        for (Reserva reserva : reservas) {
            if (reserva.getCodigoReserva() == codigoReserva) {
                // System.out.println(reserva);

                // Obter os valores desejados do objeto reserva
                double valorDiaria = reserva.getValorDiaria();
                double valorAdicional = reserva.getValorAdicional();
                int codigoCliente = reserva.getClientes().get(0).getCodigoDoCliente();
                String nome = reserva.getClientes().get(0).getNome();
                String cpf = reserva.getClientes().get(0).getCpf();

                // Imprimir os valores desejados
                System.out.println("Valor Diaria: " + valorDiaria);
                System.out.println("Valor Adicional: " + valorAdicional);
                System.out.println("Codigo do Cliente: " + codigoCliente);
                System.out.println("Nome: " + nome);
                System.out.println("CPF: " + cpf);

                return reserva;
            }
        }

        return null; // Retorna null se a reserva não for encontrada
    }

    /**
     * método lê as reservas de um arquivo JSON, converte os dados em objetos
     * Reserva e retorna uma lista contendo esses objetos. O código faz uso de
     * classes e métodos relacionados a parsing e manipulação de JSON, como
     * JSONParser, JSONArray e JSONObject.
     *
     * @return
     */
    public static List<Reserva> lerReservas() {
        List<Reserva> reservas = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(endArqReserva)) {
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            for (Object json : jsonArray) {
                JSONObject jsonObject = (JSONObject) json;
                Reserva reserva = buscarValoresJson(jsonObject);
                reservas.add(reserva);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return reservas;
    }

    /**
     * extrair os valores de um objeto JSON e criar um objeto Reserva com base
     * nesses valores. Ela desempenha um papel importante na leitura e conversão
     * dos dados armazenados em formato JSON em um objeto Reserva, permitindo
     * assim a manipulação e utilização desses dados no sistema função é útil
     * quando se trabalha com dados armazenados em formato JSON e é necessário
     * converter esses dados em objetos do tipo Reserva para utilizá-los em um
     * sistema
     *
     * @param jsonObject
     * @return
     */
    private static Reserva buscarValoresJson(JSONObject jsonObject) {
        // Crie a lógica necessária para criar um objeto Reserva a partir do objeto JSON
        // Aqui está um exemplo básico:

        int codigoReserva = ((Long) jsonObject.get("codigoReserva")).intValue();
        double valorDiaria = ((Long) jsonObject.get("valorDiaria")).doubleValue();
        double valorAdicional = ((Long) jsonObject.get("valorAdicional")).doubleValue();

        JSONArray clientesJsonArray = (JSONArray) jsonObject.get("clientes");
        JSONObject clienteJsonObject = (JSONObject) clientesJsonArray.get(0);
        int codigoCliente = ((Long) clienteJsonObject.get("codigoDoCliente")).intValue();
        String nomeCliente = (String) clienteJsonObject.get("nome");
        String cpfCliente = (String) clienteJsonObject.get("cpf");

        // Crie objetos Cliente e Quarto, se necessário, e adicione-os à reserva
        Reserva reserva = new Reserva(codigoReserva, (int) valorDiaria, (int) valorAdicional);
        reserva.setClientes(new ArrayList<>()); // Inicializa a lista de clientes
        reserva.getClientes().add(new Cliente(codigoCliente, nomeCliente, cpfCliente));

        return reserva;
    }

    /**
     * método busca as datas de check-in e check-out de uma reserva com base no
     * código da reserva fornecido. Ele percorre o arquivo JSON, busca a reserva
     * com o código correspondente e retorna um array de strings contendo as
     * datas de check-in e check-out, ou retorna null se a reserva não for
     * encontrada
     *
     * @param codigoReserva
     * @return
     */
    public static String[] buscarDatasPorCodigo(int codigoReserva) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(endArqReserva)) {
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            for (Object json : jsonArray) {
                JSONObject jsonObject = (JSONObject) json;
                int codigo = ((Long) jsonObject.get("codigoReserva")).intValue();

                if (codigo == codigoReserva) {
                    String dataCheckIn = (String) jsonObject.get("dataCheckIn");
                    String dataCheckOut = (String) jsonObject.get("dataCheckOut");
                    return new String[]{dataCheckIn, dataCheckOut};
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null; // Retorna null se a reserva não for encontrada
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * método permite que o usuário insira o código da reserva que deseja
     * pesquisar. Ele busca a reserva correspondente e, se encontrada tras os
     * valores da Conta do Cliente
     */
    public static void pesquisarDebitosDoCliente() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o Codigo da Reserva que deseja Procurar: ");
        int codigoReservax = input.nextInt();

        Reserva reservaEncontrada = Contabilidade.lerReservaPorCodigo(codigoReservax);

        if (reservaEncontrada != null) {
            // A reserva foi encontrada, você pode realizar as operações desejadas com ela
        } else {
            System.out.println("Reserva não encontrada!");
        }

        int codigoReserva = codigoReservax; // Código da reserva a ser buscada
        String[] datas = buscarDatasPorCodigo(codigoReserva);
        if (datas != null && datas.length == 2) {
            String dataCheckIn = datas[0];
            String dataCheckOut = datas[1];
            System.out.println("Data de Check-in: " + dataCheckIn);
            System.out.println("Data de Check-out: " + dataCheckOut);
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    //pesquisar pela tela debito do cliente
    public static void pesquisarDebitosDoClienteTela(int codigoReservax, StringBuilder sb) {
        Reserva reservaEncontrada = Contabilidade.lerReservaPorCodigo(codigoReservax);

        if (reservaEncontrada != null) {
            sb.append("Valor Total da Diaria: ").append(reservaEncontrada.getValorDiaria()).append(System.lineSeparator());
            sb.append("Valor Despesas Adicionais: ").append(reservaEncontrada.getValorAdicional()).append(System.lineSeparator());
            sb.append("Codigo do Cliente: ").append(reservaEncontrada.getClientes().get(0).getCodigoDoCliente()).append(System.lineSeparator());
            sb.append("Nome: ").append(reservaEncontrada.getClientes().get(0).getNome()).append(System.lineSeparator());
            sb.append("CPF: ").append(reservaEncontrada.getClientes().get(0).getCpf()).append(System.lineSeparator());
        } else {
            sb.append("Reserva não encontrada!");
        }

        int codigoReserva = codigoReservax;
        String[] datas = buscarDatasPorCodigo(codigoReserva);
        if (datas != null && datas.length == 2) {
            String dataCheckIn = datas[0];
            String dataCheckOut = datas[1];
            sb.append("Data de Check-in: ").append(dataCheckIn).append(System.lineSeparator());
            sb.append("Data de Check-out: ").append(dataCheckOut).append(System.lineSeparator());
            sb.append("-----------------------------------------------------").append(System.lineSeparator());

        } else {
            sb.append("Reserva não encontrada.");
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Metodo para fazer busca de receita mensal pelo ano e mes
     * 
     * método calcula a receita mensal somando os valores adicionais e os
     * valores diários das reservas que correspondem a um determinado mês
     * fornecido como argumento. Ele percorre a lista de reservas, verifica se a
     * data de check-out corresponde ao mês fornecido e acumula os valores na
     * variável receitaMensal. No final, exibe o valor total da receita mensal
     * no console
     *
     * @param data
     */
    public static void receitaMesal(String data) {
        // Criação das variáveis
        List<Reserva> reservas = new ArrayList<>();
        List<Reserva> reservaAux = new ArrayList<>();
        double receitaMensal = 0;
        // Leitura das reservas do arquivo JSON
        reservas = arquivos.JsonFerramentas.lerReservas();
// Iteração sobre as reservas pelo forit
        for (Reserva ress : reservas) {
            if (ress.getDataCheckOut() != null) {// Verifica se a data de check-out não é nula
                // Obtenção da data de check-out e formatação para "yyyy-MM"
                LocalDateTime checkOutDate = ress.getDataCheckOut();
                String checkOutYearMonth = checkOutDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                // Verifica se a data de check-out corresponde à data fornecida
                if (checkOutYearMonth.equals(data)) {
                    reservaAux.add(ress); // Adiciona a reserva à lista auxiliar
                    System.out.println(reservaAux);
                    receitaMensal += ress.getValorAdicional() + ress.getValorDiaria();
                }
            }
        }
        // Exibição da receita total
        System.out.println("\n\nValor da Receita total: R$" + receitaMensal);

    }

    public static void receitaMesalTela(String ano, String mes, StringBuilder sb) {
        // Criação das variáveis
        List<Reserva> reservas = new ArrayList<>();
        List<Reserva> reservaAux = new ArrayList<>();
        double receitaMensal = 0;

        // Leitura das reservas do arquivo JSON
        reservas = arquivos.JsonFerramentas.lerReservas();

        // Iteração sobre as reservas pelo for-each
        for (Reserva ress : reservas) {
            if (ress.getDataCheckOut() != null) {
                // Verifica se a data de check-out corresponde à data fornecida
                LocalDateTime checkOutDate = ress.getDataCheckOut();
                String checkOutYearMonth = checkOutDate.format(DateTimeFormatter.ofPattern("yyyy" + "MM"));
                if (checkOutYearMonth.equals(ano + mes)) {
                    reservaAux.add(ress); // Adiciona a reserva à lista auxiliar
                    receitaMensal += ress.getValorAdicional() + ress.getValorDiaria();
                }
            }
        }

        // Exibição das reservas na StringBuilder
        sb.append("\n-----------------------------------------------------------------------------------------\n");
        for (Reserva reserva : reservaAux) {
            sb.append(reserva.toString()).append("\n-----------------------------------------------------------------------------------------\n"); // Adiciona o conteúdo formatado da reserva à StringBuilder
        }
        sb.append("\n-----------------------------------------------------------------------------------------\n");
        // Exibição da receita total na StringBuilder
        sb.append("Valor da Receita total: R$").append(receitaMensal);
        sb.append("\n-----------------------------------------------------------------------------------------\n");

    }

}
