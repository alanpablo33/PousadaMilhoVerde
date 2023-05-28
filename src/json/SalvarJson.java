/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package json;

import Classes.Cliente;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Alan Pablo
 */
public class SalvarJson {
  
   //Salva Lista
   public static void saveJsonList(List<Cliente> lista, String fileName) {
        JSONArray jsonArray = new JSONArray();

      
            JSONObject jsonCliente = new JSONObject();
            System.out.println(lista);
            jsonCliente.put("CAD", lista);

            jsonArray.add(jsonCliente);
        

        try (FileWriter fileWriter = new FileWriter(fileName,true)) {
            fileWriter.write(jsonArray.toJSONString());
            System.out.println("JSON file saved: " + fileName);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{System.out.println("FINALIZADO!");}
    }
     //Salva Objeto
        public static void saveJsonObject (Object objeto, String fileName) {
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Dados", objeto);

        jsonArray.add(jsonObject);

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(jsonArray.toJSONString());
            System.out.println("JSON file saved: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{System.out.println("FINALIZADO!");}
    }

    public static void saveJsonObject(Cliente cadastro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
