/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package TelasDoPrograma;

import Classes.Cliente;
import arquivos.JsonFerramentas;
import static arquivos.JsonFerramentas.VerListaDeClientes;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Pablo
 */
public class TelaPesquisarClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaPesquisarClientes
     */
    public TelaPesquisarClientes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        recebeCodigoCliente = new javax.swing.JTextField();
        BTNpesquisarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        verCliente = new javax.swing.JTextPane();
        verTodosClientes = new javax.swing.JLabel();
        VerTodosOsClientes = new javax.swing.JButton();
        VePeloCpf = new javax.swing.JButton();
        recebeCpfCliente1 = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Pesquisar Cliente");

        jLabel1.setText("Pesquisar Pelo Codigo Do Cliente");

        recebeCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recebeCodigoClienteActionPerformed(evt);
            }
        });

        BTNpesquisarCliente.setText("Pesquisar");
        BTNpesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNpesquisarClienteActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(verCliente);

        verTodosClientes.setText("Pesquisar Pelo CPF Do Cliente");

        VerTodosOsClientes.setText("Ver Todos");
        VerTodosOsClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerTodosOsClientesActionPerformed(evt);
            }
        });

        VePeloCpf.setText("Pesquisar");
        VePeloCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VePeloCpfActionPerformed(evt);
            }
        });

        try {
            recebeCpfCliente1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(verTodosClientes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(recebeCodigoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(recebeCpfCliente1))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTNpesquisarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(VePeloCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(VerTodosOsClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(recebeCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNpesquisarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verTodosClientes)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(VePeloCpf)
                        .addComponent(recebeCpfCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(VerTodosOsClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(300, 20, 414, 536);
    }// </editor-fold>//GEN-END:initComponents

    private void recebeCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recebeCodigoClienteActionPerformed
    }//GEN-LAST:event_recebeCodigoClienteActionPerformed

    private void BTNpesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNpesquisarClienteActionPerformed
        String codigoCliente = recebeCodigoCliente.getText();

        if (codigoCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o código do cliente");
            return;
        }

        int codigo = Integer.parseInt(codigoCliente);
        List<Cliente> listaClientes = Cliente.verClientes(codigo);

        if (listaClientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Valor inválido");
            return;
        }

        // Construir a representação em formato de texto
        StringBuilder clienteInfo = new StringBuilder();
        for (Cliente cliente : listaClientes) {
            clienteInfo.append("Código do Cliente: ").append(cliente.getCodigoDoCliente()).append("\n")
                    .append("Telefone: ").append(cliente.getTelefone()).append("\n")
                    .append("E-mail: ").append(cliente.getEmail()).append("\n")
                    .append("Rua: ").append(cliente.getRua()).append("\n")
                    .append("Bairro: ").append(cliente.getBairro()).append("\n")
                    .append("Número da Casa: ").append(cliente.getNumeroCasa()).append("\n")
                    .append("CEP: ").append(cliente.getCep()).append("\n")
                    .append("Cidade: ").append(cliente.getCidade()).append("\n")
                    .append("Nome: ").append(cliente.getNome()).append("\n")
                    .append("CPF: ").append(cliente.getCpf()).append("\n\n");
        }

        verCliente.setText(clienteInfo.toString());
    }//GEN-LAST:event_BTNpesquisarClienteActionPerformed

    private void VePeloCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VePeloCpfActionPerformed
        // TODO add your handling code here:
        String cpfCli = recebeCpfCliente1.getText();

        if (cpfCli.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o CPF do cliente");
            return;
        }

        Cliente clienteEncontrado = Cliente.buscarClientePeloCpfTela(cpfCli);

        if (clienteEncontrado != null) {
            // Construir a representação em formato de texto
            StringBuilder clienteInfo = new StringBuilder();
            clienteInfo.append("Código do Cliente: ").append(clienteEncontrado.getCodigoDoCliente()).append("\n")
                    .append("Telefone: ").append(clienteEncontrado.getTelefone()).append("\n")
                    .append("E-mail: ").append(clienteEncontrado.getEmail()).append("\n")
                    .append("Rua: ").append(clienteEncontrado.getRua()).append("\n")
                    .append("Bairro: ").append(clienteEncontrado.getBairro()).append("\n")
                    .append("Número da Casa: ").append(clienteEncontrado.getNumeroCasa()).append("\n")
                    .append("CEP: ").append(clienteEncontrado.getCep()).append("\n")
                    .append("Cidade: ").append(clienteEncontrado.getCidade()).append("\n")
                    .append("Nome: ").append(clienteEncontrado.getNome()).append("\n")
                    .append("CPF: ").append(clienteEncontrado.getCpf()).append("\n\n");

            // Atualizar um JLabel com as informações do cliente
            verCliente.setText(clienteInfo.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Valor inválido");
        }
    }//GEN-LAST:event_VePeloCpfActionPerformed

    private void VerTodosOsClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerTodosOsClientesActionPerformed
        // TODO add your handling code here:

        // Chamar o método VerListaDeClientesX() para obter a representação dos clientes
        String clientesTexto = JsonFerramentas.VerListaDeClientesX();

        // Atualizar o texto da label verCliente
        verCliente.setText(clientesTexto);
    }//GEN-LAST:event_VerTodosOsClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNpesquisarCliente;
    private javax.swing.JButton VePeloCpf;
    private javax.swing.JButton VerTodosOsClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField recebeCodigoCliente;
    private javax.swing.JFormattedTextField recebeCpfCliente1;
    private javax.swing.JTextPane verCliente;
    private javax.swing.JLabel verTodosClientes;
    // End of variables declaration//GEN-END:variables
}
