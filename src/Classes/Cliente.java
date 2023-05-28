package Classes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;


public class Cliente extends PessoaAbstract  {

    //Atributos para Cliente
    private int codigoDoCliente;
    private String telefone;
    private String email;
    private String rua;
    private String bairro;
    private String numeroCasa;
    private String cep;
    private String cidade;
    protected static int totalCliente = 0;

    //costrutores 
    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        Cliente.totalCliente = Cliente.totalCliente + 1;
    }

    public Cliente(int codigoDoCliente, String nome, String cpf) {
        super(nome, cpf);
        this.codigoDoCliente = codigoDoCliente;
    }
    
    
    public Cliente(int codigoDoCliente, String nome, String telefone, String email, String cpf, String rua, String bairro, String numeroCasa, String cep, String cidade) {
        super(nome, cpf); // pegando informações da ClassePessoa
        Cliente.totalCliente = Cliente.totalCliente + 1;
        this.codigoDoCliente = codigoDoCliente;
        this.telefone = telefone;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.numeroCasa = numeroCasa;
        this.cep = cep;
        this.cidade = cidade;
    }

//Metodos Get e Set Criados para a manipulação dos Atributos Que estão em Private
    public int getCodigoDoCliente() {
        return codigoDoCliente;
    }
    public void setCodigoDoCliente(int codigoDoCliente) {
        this.codigoDoCliente = codigoDoCliente;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
  
    public static void cadastroCliente() {
    List<Cliente> listaClientes = new ArrayList<>();
    
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    int codigoDoCliente = random.nextInt(10000);

    // Set's para cadastro
    System.out.print("Nome: ");
    String nome = input.nextLine();

    System.out.print("CPF: ");
    String cpf = input.nextLine();

    System.out.print("Telefone: ");
    String telefone = input.nextLine();

    System.out.print("E-mail: ");
    String email = input.nextLine();

    System.out.print("Rua: ");
    String rua = input.nextLine();

    System.out.print("Numero da Casa: ");
    String numeroCasa = input.nextLine();

    System.out.print("Bairro: ");
    String bairro = input.nextLine();

    System.out.print("Cidade: ");
    String cidade = input.nextLine();

    System.out.print("CEP: ");
    String cep = input.nextLine();

    Cliente cadastro = new Cliente(codigoDoCliente, nome, telefone, email, cpf, rua, bairro, numeroCasa, cep, cidade);
    
    //metodo para Salvar Cadastro
    json.JsonFerramentas.save(cadastro,"CLIENTE");
}
    
    
    
    //metodo para alterar dados json








    
    
    
    
    
    
    
    
    
    
   //testa metodos
//    public static void main(String[] args) {
//        cadastroCliente();
//    }

    
    
  

    
//    public static void excluirCadastroCliente() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Digite: ");
//        String nNome = scanner.nextLine();
//        String nomeArquivo = "dados_cadastro_cliente_" + nNome + ".json";
//
//        Path path = Paths.get(nomeArquivo);
//
//        try {
//            Files.deleteIfExists(path);
//            System.out.println("Arquivo JSON excluído com sucesso.");
//        } catch (IOException e) {
//            System.out.println("Erro ao excluir o arquivo JSON: " + e.getMessage());
//        }
//    } 

     
    //sobre escrever o toString 
    @Override
    public String toString() {
        return  "Codigo: " + codigoDoCliente + ",Nome: " + getNome() + ",CPF: " + getCpf()
                + ",Telefone: " + telefone + ",E-mail: " + email + ",Rua: " + rua
                + ", Numero da Casa:" + numeroCasa + ",Bairro: " + bairro + ", Cidade: " + cidade
                + ",CEP: " + cep ;
    }

}
