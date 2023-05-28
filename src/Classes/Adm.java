/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alan Pablo
 */
public class Adm extends Funcionario {
    private int loginAdm;
    private int senhaAdm;

    public int getLoginAdm() {
        return loginAdm;
    }

    public void setLoginAdm(int loginAdm) {
        this.loginAdm = 123;
    }

    public int getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(int senhaAdm) {
        this.senhaAdm = 123;
    }

    //construtores
    public Adm(int loginAdm, int senhaAdm, int codigoDoCliente, String nome, String cpf) {
        super(codigoDoCliente, nome, cpf);
        this.loginAdm = loginAdm;
        this.senhaAdm = senhaAdm;
    }
    public Adm(int codigoDoCliente, String login, String senha, String nome, String cpf) {
        super(login, senha, codigoDoCliente, nome, cpf);
    }
    
   //metodos
    public static void cadastrarFuncionario() {
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int codigoFuncionario = random.nextInt(10000);

        System.out.print("LOGIN: ");
        String login = input.nextLine();

        System.out.print("SENHA: ");
        String senha = input.nextLine();

        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("CPF: ");
        String cpf = input.nextLine();

        Adm funcionario = new Adm(codigoFuncionario, login, senha, nome, cpf);

        listaFuncionarios.add(funcionario);
        
        json.JsonFerramentas.save(funcionario,"FUNCIONARIO");

        System.out.println("Funcionário cadastrado com sucesso.");
    }
    
    public static void cadastrarAdm() {
        List<Adm> listaAdm = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        Random random = new Random();
        int codigoAdm = random.nextInt(10000);

        System.out.print("LOGIN: ");
        String login = input.nextLine();

        System.out.print("SENHA: ");
        String senha = input.nextLine();

        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("CPF: ");
        String cpf = input.nextLine();

        Adm funcionario = new Adm(codigoAdm, login, senha, nome, cpf);

        listaAdm.add(funcionario);
        
        json.JsonFerramentas.save(funcionario,"ADM");

        System.out.println("Funcionário cadastrado com sucesso.");
    }
    
    
    public static void main(String[] args) {
        cadastrarFuncionario();
        cadastrarAdm();
    }
}


