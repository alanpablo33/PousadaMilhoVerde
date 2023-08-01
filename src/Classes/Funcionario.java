/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Alan Pablo
 */

public class Funcionario extends Cliente {
    /**
 * Classe Funcionario Herda Valores da Classe Cliente
 * E tem um adicional de Atributos para fazer login no sistema
 *
 */

    private String loginF;
    private String senhaF;

    public String getLoginF() {
        return loginF;
    }

    public void setLoginF(String loginF) {
        this.loginF = loginF;
    }

    public String getSenhaF() {
        return senhaF;
    }

    public void setSenhaF(String senhaF) {
        this.senhaF = senhaF;
    }

    /**
     * Essa abordagem de utilizar super no construtor permite reutilizar o
     * código do construtor da classe pai e inicializar os atributos da classe
     * Funcionario com valores padrão
     */
    public Funcionario() {
      /**
       * Questão 04
       * 
       * Utilização da Palavra reservada super para implementar construtores das subclasses.
       * OBS: valores a baixo de exemplo
       */
        super("David", "david@example.com");
    }

    /**
     * Construtor para cadastro funcionario
     *
     */
    public Funcionario(String loginF, String senhaF, String telefone, String email, String rua, String bairro, String numeroCasa, String cep, String cidade, String nome, String cpf) {
       /**
       * Questão 04
       * 
       * Utilização da Palavra reservada super para implementar construtores das subclasses Cliente.
       */
        super(telefone, email, rua, bairro, numeroCasa, cep, cidade, nome, cpf);
        this.loginF = loginF;
        this.senhaF = senhaF;
    }

    
    
    public Funcionario(String telefone, String email, String rua, String bairro, String numeroCasa, String cep, String cidade, String nome, String cpf) {
      /**
       * Questão 04
       * 
       * Utilização da Palavra reservada super para implementar construtores das subclasses Cliente.
       */
        super(telefone, email, rua, bairro, numeroCasa, cep, cidade, nome, cpf);
    }
    /**
     * Questao 3
     * Sobreescrita da Saida
     *  
     */

    @Override
    public String toString() {
        return "Nome: " + getNome() + " ,CPF: " + getCpf() + " ,LOGIN: " + getLoginF() + " ,SENHA: " + getSenhaF();
    }

}
