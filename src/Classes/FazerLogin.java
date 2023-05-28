//package Classes;
//
//// ler as entradas do usuário a partir do teclado
//import java.util.Scanner;
//// Herda Atributos e Metodos da Classe Funcionario
//
//public class FazerLogin extends Funcionario {
//
//    //Metodo para fazer login no Sistema
//    public static void main(String[] args) {
//        Cliente c1 = new Cliente("Joao", "");
//        //ClasseCliente c2 = new Cliente("Joao", "");
//        
//        System.out.println(Cliente.totalCliente);
//
//        Classes.Funcionario login = new Funcionario();
//
//        String usuario = login.getNomeLogin();
//        String senha = login.getNomeSenha();
//
//        Scanner input = new Scanner(System.in);
//        //As entradas para o nome de usuário e senha são obtidas
//        System.out.print("Usuário: ");
//        String usuarioDigitado = input.nextLine();
//
//        System.out.print("Senha: ");
//        String senhaDigitada = input.nextLine();
//
//        //validar se usuario e senha estão corretos
//        if (usuarioDigitado.equals(usuario) && senhaDigitada.equals(senha)) {
//            System.out.print("\nSistema Pousada Milho Verde\n\n");
//            Sistema sistema = new Sistema();
//            sistema.executar();
//        } else {
//            System.out.println("Usuário ou senha incorretos.");
//        }
//
//        input.close();
//    }
//
//}
