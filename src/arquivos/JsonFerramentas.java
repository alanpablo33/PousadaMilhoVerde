/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivos;

/**
 *
 * @author Alan Pablo
 *
 * classe chamada JsonFerramentas, que possui uma série de métodos relacionados
 * à leitura, escrita e manipulação de arquivos JSON
 */
import Classes.Adm;
import java.io.*;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Classes.Cliente;
import Classes.Reserva;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONObject;

public class JsonFerramentas {

    /**
     * classe chamada JsonFerramentas, que possui uma série de métodos
     * relacionados à leitura, escrita e manipulação de arquivos JSON Aqui se
     * encontra a nossa manipulação e gerencia de dados
     */
    private static final String endArqReserva = "./src/arquivos/DADOS_CADASTRO_RESERVAS.json";
    private static JSONArray array = new JSONArray();
    private static JSONParser parser = new JSONParser();
    private static StringBuilder clienteInfo = new StringBuilder();

    public static void lerArquivo(String caminho) {
        try (FileReader leitura = new FileReader(caminho)) {
            try {
                array = (JSONArray) parser.parse(leitura);
            } catch (ParseException ex) {
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    //metodo para ler JSON
    /**
     *
     * função genérica que serve para ler um arquivo JSON, converter os dados do
     * JSON em objetos do tipo especificado (classe) e retornar uma lista
     * contendo os objetos cujo código corresponde ao valor especificado
     * (codigo)
     */
    
    // Class<T> classe parâmetro de tipo (generic type) que representa a classe do tipo dos 
    //objetos que serão criados a partir do JSON
    public static <T> List<T> leituraArquivoJson(String caminho, Class<T> classe, int codigo) {
        lerArquivo(caminho);
        //criação de uma lista chamada listaObjetos, que é uma lista de objetos do tipo genérico
        //criando uma nova lista chamada listaObjetos
        List<T> listaObjetos = new ArrayList<>();
        //percorre o array array, que contém os elementos em formato JSON
        for (int i = 0; i < array.size(); i++) {
            String stringJSON = array.get(i).toString();
            T novoObjeto = new Gson().fromJson(stringJSON, classe);

            if (novoObjeto instanceof Cliente) {
                Cliente cliente = (Cliente) novoObjeto;
                if (cliente.getCodigoDoCliente() == codigo) {
                    listaObjetos.add(novoObjeto);
                }
            }
            if (novoObjeto instanceof Adm) {
                Adm membro = (Adm) novoObjeto;
                if (membro.getCodigoDoUser() == codigo) {
                    listaObjetos.add(novoObjeto);
                }
            }
        }
        return listaObjetos;
    }

    public static <T> List<T> leituraArquivo(String caminho, Type tipo) {
        Gson gson = new Gson();
        // ler dados de um arquivo de texto
        try (Reader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, tipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //metodo para Salvar Json 
    public static <T> void salvarEmArquivoJsonTodos(List<T> listaObjetos, String caminho) {
        // Carrega os objetos existentes no arquivo
        Type tipoObjeto = new TypeToken<List<T>>() {
        }.getType();
        List<T> objetosExistentes = leituraArquivo(caminho, tipoObjeto);

        // Verifica se cada objeto da lista a ser adicionada já existe na lista existente
        for (T objeto : listaObjetos) {
            boolean objetoExistente = objetosExistentes.stream().anyMatch(o -> o.equals(objeto));
            if (!objetoExistente) {
                objetosExistentes.add(objeto);
            }
        }

        // Salva a lista atualizada de objetos no arquivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(objetosExistentes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para remover 
    public static <T> void removerObjeto(int codigo, String caminho, Type listaType) {
        // Carrega os objetos existentes no arquivo
        List<T> objetosExistentes = leituraArquivo(caminho, listaType);

        // Procura o objeto pelo código e remove se encontrado
        for (Iterator<T> iterator = objetosExistentes.iterator(); iterator.hasNext();) {
            T objeto = iterator.next();
            if (objeto instanceof Cliente) {
                Cliente cliente = (Cliente) objeto;
                if (cliente.getCodigoDoCliente() == codigo) {
                    iterator.remove();
                    System.out.println("Objeto " + codigo + " removido com sucesso");
                    break;
                }
            }
            if (objeto instanceof Adm) {
                Adm membro = (Adm) objeto;
                if (membro.getCodigoDoUser() == codigo) {
                    iterator.remove();
                    System.out.println("Objeto " + codigo + " removido com sucesso");
                    break;
                }
            }
        }

        // Salva a lista atualizada de objetos no arquivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(objetosExistentes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para Editar dados Cliente
    public static <T> void editarArquivoJson(List<T> lista, int codigo, String novoTel, String novoEmail, String novoRua, String novoNumeroCasa, String novoBairro, String novoCidade, String novoCep, String novoLogin, String novoSenha, String caminhoDoArquivo) {
        // Procura o objeto na lista pelo código e atualiza o nome
        for (T objeto : lista) {
            if (objeto instanceof Cliente) {
                Cliente cliente = (Cliente) objeto;
                if (cliente.getCodigoDoCliente() == codigo) {

                    cliente.setTelefone(novoTel);
                    cliente.setEmail(novoEmail);
                    cliente.setRua(novoRua);
                    cliente.setNumeroCasa(novoNumeroCasa);
                    cliente.setBairro(novoBairro);
                    cliente.setCidade(novoCidade);
                    cliente.setCep(novoCep);

                    System.out.println("Cliente " + codigo + " atualizado com sucesso");
                    break;
                }

            }
            if (objeto instanceof Adm) {
                Adm membro = (Adm) objeto;
                if (membro.getCodigoDoUser() == codigo) {

                    membro.setTelefone(novoTel);
                    membro.setEmail(novoEmail);
                    membro.setRua(novoRua);
                    membro.setNumeroCasa(novoNumeroCasa);
                    membro.setBairro(novoBairro);
                    membro.setCidade(novoCidade);
                    membro.setCep(novoCep);
                    membro.setLoginF(novoLogin);
                    membro.setSenhaF(novoSenha);

                    System.out.println("Cliente " + codigo + " atualizado com sucesso");
                    break;
                }

            }
        }

        // Salva a lista atualizada de objetos no arquivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(caminhoDoArquivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * essa função é responsável por ler um arquivo JSON, fazer o parse do
     * conteúdo, criar objetos da classe Cliente com base nas informações do
     * JSON e retornar uma lista contendo esses objetos. Essa lista pode ser
     * utilizada em outras partes do código para manipular as informações dos
     * clientes.
     */
    public static List<Cliente> leituraArquivoClientee() throws IOException {
        try (FileReader leitura = new FileReader("./src/arquivos/DADOS_CADASTRO_CLIENTE.json")) {
            try {
                JSONParser parser = new JSONParser();
                array = (JSONArray) parser.parse(leitura);
                //Caso ocorra alguma exceção de parse (ParseException
            } catch (ParseException ex) {

            }
        }
        //o código inicializa uma lista vazia chamada listaCliente que irá conter os objetos da classe Cliente
        List<Cliente> listaCliente = new ArrayList<>();

        //o loop será executado enquanto i for menor que o tamanho do array array
        for (int i = 0; i < array.size(); i++) {
            String stringJSON = array.get(i).toString();
            Cliente novoCliente = new Gson().fromJson(stringJSON, Cliente.class);
            //novoCliente, que foi criado a partir do JSON na posição i do array array, 
            //é adicionado à lista listaCliente usando o método add()
            listaCliente.add(novoCliente);
        }

        return listaCliente;
    }

    //Metodo para buscar cliente pelo CPF
    public static Cliente buscarClientePorCPF(String cpf) {
        try (FileReader reader = new FileReader("./src/arquivos/DADOS_CADASTRO_CLIENTE.json")) {
            Gson gson = new Gson();
            Type tipoListaClientes = new TypeToken<List<Cliente>>() {
            }.getType();
            List<Cliente> clientes = gson.fromJson(reader, tipoListaClientes);

            for (Cliente cliente : clientes) {
                if (cliente.getCpf().equals(cpf)) {
                    return cliente;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Retorna null se o cliente não for encontrado
    }

    public static void VerListaDeClientes() {
        JSONParser parser = new JSONParser();

        try {
            // Ler o arquivo JSON
            Object obj = parser.parse(new FileReader("./src/arquivos/DADOS_CADASTRO_CLIENTE.json"));

            // Converter o objeto lido em um JSONArray
            JSONArray jsonArray = (JSONArray) obj;

            // Iterar sobre cada objeto do JSONArray
            for (Object jsonObj : jsonArray) {
                JSONObject cliente = (JSONObject) jsonObj;

                // Obter os valores desejados do cliente
                Object codigoClienteObj = cliente.get("codigoDoCliente");
                Long codigoCliente;
                if (codigoClienteObj instanceof Long) {
                    codigoCliente = (Long) codigoClienteObj;
                } else if (codigoClienteObj instanceof Double) {
                    codigoCliente = ((Double) codigoClienteObj).longValue();
                } else {
                    throw new ClassCastException("Tipo inválido para o campo 'codigoDoCliente'");
                }

                String nome = (String) cliente.get("nome");
                String cpf = (String) cliente.get("cpf");

                // Imprimir os valores
                System.out.println("______________________________");
                System.out.println("codigoDoCliente: " + codigoCliente);
                System.out.println("nome: " + nome);
                System.out.println("cpf: " + cpf);
                System.out.println("______________________________");

            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    //Ver Todos para Tela 
    public static String VerListaDeClientesX() {
        JSONParser parser = new JSONParser();
        StringBuilder clienteInfo = new StringBuilder();

        try {
            // Ler o arquivo JSON
            Object obj = parser.parse(new FileReader("./src/arquivos/DADOS_CADASTRO_CLIENTE.json"));

            // Converter o objeto lido em um JSONArray
            JSONArray jsonArray = (JSONArray) obj;

            // Iterar sobre cada objeto do JSONArray
            for (Object jsonObj : jsonArray) {
                JSONObject cliente = (JSONObject) jsonObj;

                // Obter os valores desejados do cliente
                Object codigoClienteObj = cliente.get("codigoDoCliente");
                Long codigoCliente;
                if (codigoClienteObj instanceof Long) {
                    codigoCliente = (Long) codigoClienteObj;
                } else if (codigoClienteObj instanceof Double) {
                    codigoCliente = ((Double) codigoClienteObj).longValue();
                } else {
                    throw new ClassCastException("Tipo inválido para o campo 'codigoDoCliente'");
                }

                String nome = (String) cliente.get("nome");
                String cpf = (String) cliente.get("cpf");

                // Adicionar os valores ao clienteInfo
                clienteInfo.append("______________________________\n");
                clienteInfo.append("codigoDoCliente: ").append(codigoCliente).append("\n");
                clienteInfo.append("nome: ").append(nome).append("\n");
                clienteInfo.append("cpf: ").append(cpf).append("\n");
                clienteInfo.append("______________________________\n");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return clienteInfo.toString();
    }

////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * Questao 9
     *
     * metodo para salvar reservas feitas As reservas e os clientes devem ser
     * salvas de forma dinâmica no sistema
     *
     */
    public static void salvarReservas(List<Reserva> listaReserva) {
        List<Reserva> reservasExistentes = carregarReservas(endArqReserva);
        reservasExistentes.addAll(listaReserva);

        try (FileWriter writer = new FileWriter(endArqReserva)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context)
                            -> context.serialize(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                    .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context)
                            -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                    .setPrettyPrinting()
                    .create();
            Type reservaListType = new TypeToken<List<Reserva>>() {
            }.getType();
            gson.toJson(reservasExistentes, reservaListType, writer);
            System.out.println("Reservas adicionadas com sucesso em " + endArqReserva);
        } catch (IOException e) {
            System.out.println("Erro ao adicionar as reservas em " + endArqReserva);
            e.printStackTrace();
        }
    }
//Questao 9

    private static List<Reserva> carregarReservas(String arquivoJson) {
        List<Reserva> reservas = new ArrayList<>();
        try (FileReader reader = new FileReader(arquivoJson)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context)
                            -> context.serialize(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                    .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context)
                            -> LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                    .create();
            Type reservaListType = new TypeToken<List<Reserva>>() {
            }.getType();
            reservas = gson.fromJson(reader, reservaListType);
        } catch (IOException | JsonSyntaxException e) {
            System.out.println("Erro ao carregar as reservas do arquivo " + endArqReserva);
            e.printStackTrace();
        }
        return reservas;
    }
//Questao 9

    public static List<Reserva> lerReservas() {
        List<Reserva> reservas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(endArqReserva))) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext)
                            -> LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                    .create();

            Type reservaListType = new TypeToken<List<Reserva>>() {
            }.getType();
            reservas = gson.fromJson(reader, reservaListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reservas;
    }

    //metodo para colocar valor adicional a gastos de cliente.
    public static void valorAdicionalGastos(int codigoReserva, int valorAdicional) {
        // Ler o arquivo JSON das reservas
        JsonArray reservasArray = lerArquivoJSON(endArqReserva);

        // Percorrer as reservas para encontrar a reserva pelo código
        for (JsonElement reservaElement : reservasArray) {
            JsonObject reservaObj = reservaElement.getAsJsonObject();
            int codigo = reservaObj.get("codigoReserva").getAsInt();

            // Verificar se o código da reserva corresponde ao código buscado
            if (codigo == codigoReserva) {
                // Atualizar o valor da valorDiaria
                int valorAtual = reservaObj.get("valorAdicional").getAsInt();
                int novoValor = valorAtual + valorAdicional;
                reservaObj.addProperty("valorAdicional", novoValor);

                // Salvar as alterações no arquivo JSON
                salvarArquivoJSON(reservasArray, endArqReserva);
                System.out.println("Valor da valorDiaria atualizado com sucesso!");
                return;
            }
        }

        // Caso a reserva não seja encontrada, exibir uma mensagem de erro
        System.out.println("Reserva não encontrada!");
    }

    private static JsonArray lerArquivoJSON(String caminhoArquivo) {
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader(caminhoArquivo)) {
            JsonElement element = parser.parse(reader);
            if (element.isJsonArray()) {
                return element.getAsJsonArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonArray();
    }

    private static void salvarArquivoJSON(JsonArray jsonArray, String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonArray, writer);
            System.out.println("Arquivo JSON atualizado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void excluirReservaPorCodigo(int codigoReserva) {
        // Ler o arquivo JSON das reservas
        JsonArray reservasArray = lerArquivoJSON(endArqReserva);

        // Percorrer as reservas para encontrar a reserva pelo código
        for (JsonElement reservaElement : reservasArray) {
            JsonObject reservaObj = reservaElement.getAsJsonObject();
            int codigo = reservaObj.get("codigoReserva").getAsInt();

            // Verificar se o código da reserva corresponde ao código buscado
            if (codigo == codigoReserva) {
                // Remover a reserva do array
                reservasArray.remove(reservaElement);

                // Salvar as alterações no arquivo JSON
                salvarArquivoJSON(reservasArray, endArqReserva);
                System.out.println("Reserva removida com sucesso!");
                return;
            }
        }

        // Caso a reserva não seja encontrada, exibir uma mensagem de erro
        System.out.println("Reserva não encontrada!");
    }

//////////////////////////////////////////////////////////////////////////////////////////////////// 
    // Ler Json
    public static <T> List<T> leituraArquivoS(String arquivo, Class<T[]> classe) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            Gson gson = new GsonBuilder().create();
            return List.of(gson.fromJson(br, classe));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
//Json Para Salvar dados do Contador de Clientes
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvarDadosContador(int quantidadeNovosContadores, String caminho) {
        try {
            File file = new File(caminho);

            // Verificar se o arquivo existe, caso contrário, criar um novo arquivo
            if (!file.exists()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("contadorEncapsulamento", 0);
                jsonObject.addProperty("contadorProtegido", 0);
                try (FileWriter writer = new FileWriter(file)) {
                    gson.toJson(jsonObject, writer);
                }
            }

            try (FileReader reader = new FileReader(file)) {
                JsonParser jsonParser = new JsonParser();
                JsonElement jsonElement = jsonParser.parse(reader);
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                int contadorEncapsulamento = jsonObject.get("contadorEncapsulamento").getAsInt();
                int contadorProtegido = jsonObject.get("contadorProtegido").getAsInt();

                contadorEncapsulamento += quantidadeNovosContadores;
                contadorProtegido += quantidadeNovosContadores;

                jsonObject.addProperty("contadorEncapsulamento", contadorEncapsulamento);
                jsonObject.addProperty("contadorProtegido", contadorProtegido);

                try (FileWriter writer = new FileWriter(file)) {
                    gson.toJson(jsonObject, writer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerInstanciasCliente() {
        try (FileReader reader = new FileReader("./src/arquivos/CLIENTESX.json")) {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(reader).getAsJsonObject();

            int contadorEncapsulamento = jsonObject.get("contadorEncapsulamento").getAsInt();
            int contadorProtegido = jsonObject.get("contadorProtegido").getAsInt();

            System.out.println("Instancias de Cliente Encapsulamento: " + contadorEncapsulamento);
            System.out.println("Instancias de Cliente Protegido: " + contadorProtegido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

///////////////////////////////////////////////////////////////////////////////
    private static JsonObject lerArquivoJSONContador(String caminhoArquivo) {
        try (FileReader reader = new FileReader(caminhoArquivo)) {
            JsonParser jsonParser = new JsonParser();
            return jsonParser.parse(reader).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void salvarJsonR(JsonObject jsonObject, String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarContadorInstanciasReserva(String caminhoArquivo) {
        JsonObject jsonObject = lerArquivoJSONContador(caminhoArquivo);

        if (jsonObject == null) {
            jsonObject = new JsonObject();
            jsonObject.addProperty("instanciaReserva", 0);
        }

        int instanciaReserva = jsonObject.get("instanciaReserva").getAsInt();
        instanciaReserva++;

        jsonObject.addProperty("instanciaReserva", instanciaReserva);

        salvarJsonR(jsonObject, caminhoArquivo);
    }

    public static int lerInstanciaReserva() {
        JsonObject jsonObject = lerArquivoJSONContador("./src/arquivos/RESERVASX.json");

        if (jsonObject != null && jsonObject.has("instanciaReserva")) {
            return jsonObject.get("instanciaReserva").getAsInt();
        }

        return 0;
    }
    ////////////////////////////////////////////////////////////////////////////
    //ler toda a lista de user para o adm

    public static <T> List<T> leituraArquivoJson(String caminho, Class<T> classe) {
        lerArquivo(caminho);
        List<T> listaObjetos = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            String stringJSON = array.get(i).toString();
            T novoObjeto = new Gson().fromJson(stringJSON, classe);
            listaObjetos.add(novoObjeto);
        }
        return listaObjetos;
    }

}
