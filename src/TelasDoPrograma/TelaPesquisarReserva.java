/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package TelasDoPrograma;

import Classes.Cliente;
import Classes.Quartos;
import Classes.Reserva;
import static Classes.Reserva.lerReservaPorCodigoTela;
import static ReceitaDaPousada.Contabilidade.lerReservaPorCodigo;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Pablo
 */
public class TelaPesquisarReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaPesquisarReserva
     */
    public TelaPesquisarReserva() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        verReserva = new javax.swing.JTextField();
        BotaoVerificarReservaFeita = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoTextoParaReserva = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        BotaoAdicionarValor = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        RecebeCodigoDoCliente = new javax.swing.JTextField();
        PesquisaCodigoDoCliente = new javax.swing.JButton();
        recebeValorAdicinal = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Pesquisar Reserva");

        jLabel1.setText("Pesquisar Reservas Do Cliente");

        jLabel2.setText("Pesquisar Por codigo da Reserva");

        verReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verReservaActionPerformed(evt);
            }
        });

        BotaoVerificarReservaFeita.setText("Pesquisar");
        BotaoVerificarReservaFeita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVerificarReservaFeitaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(CampoTextoParaReserva);

        jLabel3.setText("Adicionar Valor Junto a Reserva");

        BotaoAdicionarValor.setText("Adicionar");
        BotaoAdicionarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAdicionarValorActionPerformed(evt);
            }
        });

        jLabel4.setText("Pesquisar Pelo Codigo do Cliente");

        PesquisaCodigoDoCliente.setText("Pesquisar");
        PesquisaCodigoDoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisaCodigoDoClienteActionPerformed(evt);
            }
        });

        recebeValorAdicinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(RecebeCodigoDoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(recebeValorAdicinal)
                                    .addComponent(verReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotaoVerificarReservaFeita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotaoAdicionarValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PesquisaCodigoDoCliente))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(verReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoVerificarReservaFeita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(BotaoAdicionarValor)
                    .addComponent(recebeValorAdicinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PesquisaCodigoDoCliente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(RecebeCodigoDoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(300, 20, 404, 536);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoVerificarReservaFeitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVerificarReservaFeitaActionPerformed
        String codigoReserva = verReserva.getText();

        if (codigoReserva.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o Código da Reserva");
            return;
        }

        int codigo = Integer.parseInt(codigoReserva);

        Reserva reservaEncontrada = lerReservaPorCodigoTela(codigo);
        if (reservaEncontrada != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Codigo da Reserva: ").append(reservaEncontrada.getCodigoReserva()).append(System.lineSeparator());

            for (Cliente cliente : reservaEncontrada.getClientes()) {
                sb.append("Codigo Do Cliente: ").append(cliente.getCodigoDoCliente()).append(System.lineSeparator());
                sb.append("Nome: ").append(cliente.getNome()).append(System.lineSeparator());
                sb.append("CPF: ").append(cliente.getCpf()).append(System.lineSeparator());
                sb.append("Telefone: ").append(cliente.getTelefone()).append(System.lineSeparator());
                sb.append("E-mail: ").append(cliente.getEmail()).append(System.lineSeparator());
                sb.append("Rua: ").append(cliente.getRua()).append(System.lineSeparator());
                sb.append("Numero da Casa: ").append(cliente.getNumeroCasa()).append(System.lineSeparator());
                sb.append("Bairro: ").append(cliente.getBairro()).append(System.lineSeparator());
                sb.append("Cidade: ").append(cliente.getCidade()).append(System.lineSeparator());
                sb.append("CEP: ").append(cliente.getCep()).append(System.lineSeparator());
                sb.append("-------------------------------------------------------------------");
            }

            for (Quartos quarto : reservaEncontrada.quartos) {
                sb.append("\nQuarto: ").append(quarto.getNumeroQuarto()).append(System.lineSeparator());
                sb.append("Tipo: ").append(quarto.getTipoQuarto()).append(System.lineSeparator());
                sb.append("Capacidade: ").append(quarto.getCapacidadeMaxima()).append(System.lineSeparator());
                sb.append("Disponibilidade: ").append(quarto.isDisponibilidade()).append(System.lineSeparator());
                sb.append("Preco por noite: ").append(quarto.getPrecoPorNoite()).append(System.lineSeparator());
                sb.append("-------------------------------------------------------------------");
            }

            sb.append("\nData de check-in: ").append(reservaEncontrada.getDataCheckIn()).append(System.lineSeparator());
            sb.append("Data de check-out: ").append(reservaEncontrada.getDataCheckOut()).append(System.lineSeparator());
            sb.append("Numero de pessoas: ").append(reservaEncontrada.getNumeroPessoas()).append(System.lineSeparator());
            sb.append("Valor total da reserva: ").append(reservaEncontrada.getValorDiaria()).append(System.lineSeparator());
            sb.append("Valor De Despesas Adicionais: ").append(reservaEncontrada.getValorAdicional()).append(System.lineSeparator());

            CampoTextoParaReserva.setText(sb.toString());
        } else {
            CampoTextoParaReserva.setText("Reserva não encontrada.");
        }
    }//GEN-LAST:event_BotaoVerificarReservaFeitaActionPerformed

    private void BotaoAdicionarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAdicionarValorActionPerformed
        // TODO add your handling code here:
        String codigoReserva = verReserva.getText();

        if (codigoReserva.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o Código da Reserva");
            return;
        }

        int codigo = Integer.parseInt(codigoReserva);

        String valorAdd = recebeValorAdicinal.getText();
        int valadd = Integer.parseInt(valorAdd);

        Classes.Reserva.adicionarValorAdicional(codigo, valadd);
        JOptionPane.showMessageDialog(null, "Clique em Pesquisar Para Atualizar o Valor");


    }//GEN-LAST:event_BotaoAdicionarValorActionPerformed

    private void verReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verReservaActionPerformed

    private void PesquisaCodigoDoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisaCodigoDoClienteActionPerformed
        String codigoClienteStr = RecebeCodigoDoCliente.getText();

        if (codigoClienteStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insira o Código do Cliente");
            return;
        }

        int codigo = Integer.parseInt(codigoClienteStr);
        Reserva reservaEncontrada = Classes.Reserva.lerReservaPorCodigo(codigo);

        if (reservaEncontrada != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Codigo da Reserva: ").append(reservaEncontrada.getCodigoReserva()).append(System.lineSeparator());
            sb.append("-------------------------------------------------------------------");

            for (Cliente cliente : reservaEncontrada.getClientes()) {
                sb.append("\nCódigo do Cliente: ").append(cliente.getCodigoDoCliente()).append(System.lineSeparator());
                sb.append("Nome: ").append(cliente.getNome()).append(System.lineSeparator());
                sb.append("CPF: ").append(cliente.getCPF()).append(System.lineSeparator());
                sb.append("-------------------------------------------------------------------");
            }

            for (Quartos quarto : reservaEncontrada.quartos) {
                sb.append("\nQuarto: ").append(quarto.getNumeroQuarto()).append(System.lineSeparator());
                sb.append("Tipo: ").append(quarto.getTipoQuarto()).append(System.lineSeparator());
                sb.append("Capacidade: ").append(quarto.getCapacidadeMaxima()).append(System.lineSeparator());
                sb.append("Disponibilidade: ").append(quarto.isDisponibilidade()).append(System.lineSeparator());
                sb.append("Preco por noite: ").append(quarto.getPrecoPorNoite()).append(System.lineSeparator());
                sb.append("-------------------------------------------------------------------");
            }

            sb.append("\nData de check-in: ").append(reservaEncontrada.getDataCheckIn()).append(System.lineSeparator());
            sb.append("Data de check-out: ").append(reservaEncontrada.getDataCheckOut()).append(System.lineSeparator());
            sb.append("Numero de pessoas: ").append(reservaEncontrada.getNumeroPessoas()).append(System.lineSeparator());
            sb.append("Valor total da reserva: ").append(reservaEncontrada.getValorDiaria()).append(System.lineSeparator());
            sb.append("Valor De Despesas Adicionais: ").append(reservaEncontrada.getValorAdicional()).append(System.lineSeparator());

            CampoTextoParaReserva.setText(sb.toString());
        } else {
            CampoTextoParaReserva.setText("Nenhuma reserva encontrada para o código do cliente informado.");
        }
    }//GEN-LAST:event_PesquisaCodigoDoClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAdicionarValor;
    private javax.swing.JToggleButton BotaoVerificarReservaFeita;
    private javax.swing.JTextPane CampoTextoParaReserva;
    private javax.swing.JButton PesquisaCodigoDoCliente;
    private javax.swing.JTextField RecebeCodigoDoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField recebeValorAdicinal;
    private javax.swing.JTextField verReserva;
    // End of variables declaration//GEN-END:variables
}
