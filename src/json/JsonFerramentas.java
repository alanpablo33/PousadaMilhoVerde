package json;

import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Classes.Cliente;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class JsonFerramentas {
    
    public static JSONArray lerJsonArray(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader fileReader = new FileReader(fileName)) {
            Object obj = parser.parse(fileReader);
            return (JSONArray) obj;
        }
    }

    public static void saveJsonArray(JSONArray jsonArray, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonArray.toJSONString());
            System.out.println("JSON file updated: " + fileName);
        }
    }

    public static void addClienteNoJSONArray(JSONArray jsonArray, Cliente cliente) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Cadastro:" + cliente.getCodigoDoCliente(), cliente.toString());
        jsonArray.add(jsonObject);
    }

    public static void save(Object objeto, String nome) {
        String fileName = "./src/arquivos/DADOS_CADASTRO_" + nome + ".json";
        
        JSONArray jsonArray;
        try {
            jsonArray = lerJsonArray(fileName);
        } catch (IOException | ParseException e) {
            jsonArray = new JSONArray();
        }
        
        addClienteNoJSONArray(jsonArray, (Cliente) objeto);
        
        try {
            saveJsonArray(jsonArray, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(jsonArray.toJSONString());
    }
    
    /////////////////////////////////////////////////////////////////////////////
    //metodo para buscar json e ler o mesmo


    
}