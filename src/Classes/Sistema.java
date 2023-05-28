//package Classes;
//
//import java.time.LocalDate;
//import java.util.Scanner;
//
//public class Sistema {
//
//    public void executar() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Cadastros de Cliente:(1)\n Gerenciar Reserva:(2)\nConta Do Cliente:(3)\nSair do Sistema:(9)");
//        System.out.print("\nDigite o Numero Correspondente a Opcao desejada:\n ");
//        String opc = input.next();
//
//        
//
//            if (opc.equals("1")) {
//                System.out.print("Cadastrar Digite:( 1 )\nPesquisar Cadastro:( 2 )\nEditar Cadastro:( 3 )\nExcluir Cadastro:( 4 )\nSair do Sistema:( 9 )");
//                String senhaDigitada = input.next();
//                
//                    if (senhaDigitada.equals("1")) {
//                        cadastrar();
//                    } else if (senhaDigitada.equals("2")) {
//                        pesquisaJson();
//                    } else if (senhaDigitada.equals("3")) {
//                        modificarJson();
//                    } else if (senhaDigitada.equals("4")) {
//                        excluirCadastroCliente();
//                    }
//               
//            }
//
//            if (opc.equals("2")) {
//                System.out.print("Fazer Reserva:( 1 )\nCancelar Reserva:( 2 )\nVer Status do Quarto:( 3 )\n");
//                String x = input.next();
//
//                if (x.equals("1")) {
//                    // Cria uma data de check-in e check-out
//                    //fazer input
//                    Scanner dia = new Scanner(System.in);
//                    System.out.print("Digite checkIn: ");
//                    int inicio = dia.nextInt();
//
//                    System.out.print("Digite checkOut: ");
//                    int fim = dia.nextInt();
//
//                    LocalDate checkIn = LocalDate.of(2023, 5, inicio);
//                    LocalDate checkOut = LocalDate.of(2023, 5, fim);
//
//                    // Faz uma reserva para o quarto número 1
//                    //fazer input
//                    Scanner scanner = new Scanner(System.in);
//                    System.out.print("Digite o NUMERO DO QUARTO A RESERVAR: ");
//                    int numQ = scanner.nextInt();
//
//                    ClasseGerenciarReserva gerenciarReserva = new ClasseGerenciarReserva(0, numQ, "standard", true, 0);
//                    gerenciarReserva.fazerReserva(numQ, checkIn, checkOut);
//
//                } else if (x.equals("2")) {
//                    ClasseGerenciarReserva.cancelarReserva();
//                }
//                //  verStatusDoQuarto(5);     
//
//            }
//
//            if (opc.equals("3")) {
//                System.out.print("Conta Cliente");
//
//            }
//            else{}
//
//       
//    }
//
//}
