package Classes;

import TelasDoPrograma.TelaSistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Pablo
 */
public class FazerLogin {

    /**
     * realizar o login no sistema
     */
    protected static List<Adm> usuarios = new ArrayList<>();
    protected static final String endArqUsuarios = "./src/arquivos/DADOS_USUARIOS.json";

    public boolean logarNoSistema(String loginN, String senhaN){

        // Carregar os usuários do arquivo JSON
        usuarios = arquivos.JsonFerramentas.leituraArquivoS(endArqUsuarios, Adm[].class);
        /**
         * realiza a autenticação do usuário no sistema, verificando o login e a
         * senha informados e redirecionando para a tela correta de acordo com o
         * tipo de usuário (administrador ou funcionário) A classe possui uma
         * lista de usuários (usuarios) e um caminho para o arquivo JSON onde os
         * usuários estão armazenados (endArqUsuarios). O método logarNoSistema
         * recebe como parâmetros o login e a senha informados pelo usuário.
         * Dentro do método, os usuários são carregados a partir do arquivo JSON
         * usando o método leituraArquivoS da classe JsonFerramentas. Em
         * seguida, é feita a verificação do login percorrendo a lista de
         * usuários. Para cada usuário, o método verifica se o login e a senha
         * informados coincidem com os valores armazenados no objeto Adm. Se
         * houver correspondência, o login é considerado bem-sucedido e uma
         * variável isAdm é definida como true se o usuário for um
         * administrador.
         */
        // Verificar o login
        boolean loginSucesso = false; //usada para indicar se o login foi bem-sucedido ou não
        boolean isAdm = false;
        //iterador para percorrer uma lista de usuarios, essa lista contém 
        //objetos  que representam os usuários do sistema.
        Iterator<Adm> iterator = usuarios.iterator();
        //percorre todos os elementos da lista usuarios usando o iterado
        while (iterator.hasNext()) {
            //o próximo elemento (usuário administrador) da lista usando o iterador
            Adm adm = iterator.next();
            //base comum para todas as classes
            //São criadas variáveis login e senha, do tipo Object, 
            //que recebem o valor retornado pelos métodos getLoginF() e getSenhaF(), respectivamente
            Object login = adm.getLoginF();
            Object senha = adm.getSenhaF();
            String idAdm = adm.getIdAdm();
            //verifica se tanto o login quanto a senha são diferentes de null, ou seja, se ambos existem.
            if (login != null && senha != null) {
                //são feitas duas verificações usando os valores de login e senha:

                boolean isLoginMatch = login.toString().equals(loginN.toString()) || (login instanceof Integer && Integer.parseInt(login.toString()) == Integer.parseInt(loginN.toString()));
                boolean isSenhaMatch = senha.toString().equals(senhaN.toString()) || (senha instanceof Integer && Integer.parseInt(senha.toString()) == Integer.parseInt(senhaN.toString()));
                if (isLoginMatch && isSenhaMatch) {
                    loginSucesso = true;
                    if (idAdm != null && idAdm.equals("admin")) {
                        isAdm = true;
                    }
                    break;
                }
            }
        }

        if (loginSucesso) {
            if (isAdm) {

                // System.out.println("Login de ADM bem-sucedido!");
                // Sistema.EX();
                // Faça algo relacionado ao login do ADM
                JOptionPane.showMessageDialog(null, "Logado com ADM " + loginN);
                /**
                 * cria uma nova instância da classe TelaSistema e torna a
                 * janela visível para o usuário
                 */
                new TelaSistema().setVisible(true);

            } else {
                System.out.println("Login de funcionario bem-sucedido!");
                // Faça algo relacionado ao login do funcionário
                JOptionPane.showMessageDialog(null, "Logado com Funcionario " + loginN);
                new TelaSistema().setVisible(true);

            }
        } else {
            System.out.println("Login falhou!");
            JOptionPane.showMessageDialog(null, "O Login " + loginN + "Não Existe!");

        }
        return false;
    }

}
