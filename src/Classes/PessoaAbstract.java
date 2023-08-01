/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 *
 *
 * @author Alan Pablo
 */
/**
 *
 * Classe Abistrata Pessoa definida como abstrata
 * Classe Modelo
 */
public abstract class PessoaAbstract {

    /**
     * A classe abstrata PessoaAbstract serve como uma base para a criação de
     * outras classes (Adm,Funcionaio e Cliente) que representam pessoas em um
     * sistema. Ela define os atributos comuns a todas as pessoas, como nome e
     * CPF, e fornece métodos para acessar e modificar esses atributos. Por isso
     * fizemos ela como uma Classe Abstract ela serve com modelo para a criação
     * das outras Classes.
     *
     *
     * nome: Atributo privado que armazena o nome da pessoa cpf : Atributo com
     * acesso padrão que armazena o CPF da pessoa.
     *
     */
    private String nome;
    String cpf;// com acesso padrão que armazena o CPF da pessoa

    /**
     * PessoaAbstract() ,Construtor vazio da classe, que cria uma instância da
     * classe sem definir os atributos nome e cpf. PessoaAbstract(String nome,
     * String cpf), Construtor da classe que cria uma instância da classe com os
     * atributos nome e cpf definidos
     */
    public PessoaAbstract() {
    }

    public PessoaAbstract(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * getNome(), Método getter que retorna o valor do atributo nome
     *
     * setNome(String nome),Método setter que define o valor do atributo nome
     *
     * getCpf(),Método getter que retorna o valor do atributo cpf
     *
     * setCpf(String cpf)Método setter que define o valor do atributo cpf
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
