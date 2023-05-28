package Classes;

// Usamos o EXTENDS para Herdar os atributos de 
//Cliente que pode ser usado tanto em Funcionario quanto em ADM
public class Funcionario extends Cliente {
    private String login;
    private String senha;
    
    public Funcionario(int codigoDoCliente, String nome, String cpf) {
        super(codigoDoCliente, nome, cpf);
    }

    public Funcionario(String login, String senha, int codigoDoCliente, String nome, String cpf) {
        super(codigoDoCliente, nome, cpf);
        this.login = login;
        this.senha = senha;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     @Override
    public String toString() {
        return  "CODIGO: "+getCodigoDoCliente()+" ,Nome: " + getNome() + " ,CPF: " + getCpf() + " ,LOGIN: " + getLogin() + " ,SENHA: " + getSenha();
    }
  
}



