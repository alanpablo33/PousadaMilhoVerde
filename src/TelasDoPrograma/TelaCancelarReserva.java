/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package TelasDoPrograma;

import Classes.Cliente;
import Classes.Quartos;
import Classes.Reserva;
import static Classes.Reserva.lerReservaPorCodigoTela;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Pablo
 */
public class TelaCancelarReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCancelarReserva
     */
    public TelaCancelarReserva() {
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
        recebeCodigo = new javax.swing.JTextField();
        BotaoConfirmarCancelamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostraTexto = new javax.swing.JTextPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cancelar Reserva");

        jLabel1.setText("Cancelar Reserva");

        jLabel2.setText("Digite o Codigo da Reserva");

        BotaoConfirmarCancelamento.setText("Confirmar");
        BotaoConfirmarCancelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConfirmarCancelamentoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(mostraTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(recebeCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BotaoConfirmarCancelamento))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(recebeCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoConfirmarCancelamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 20, 358, 529);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoConfirmarCancelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConfirmarCancelamentoActionPerformed
        // TODO add your handling code here:
        String codigoReserva = recebeCodigo.getText();
        int codigo = Integer.parseInt(codigoReserva);

        Reserva reservaEncontrada = lerReservaPorCodigoTela(codigo);
        if (reservaEncontrada != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Codigo da Reserva: ").append(reservaEncontrada.getCodigoReserva()).append(System.lineSeparator());

            for (Cliente cliente : reservaEncontrada.getClientes()) {
                sb.append("Codigo Do Cliente: ").append(cliente.getCodigoDoCliente()).append(System.lineSeparator());
                sb.append("Nome: ").append(cliente.getNome()).append(System.lineSeparator());
                sb.append("CPF: ").append(cliente.getCpf()).append(System.lineSeparator());
                sb.append("-------------------------------------------------------------------");
            }

            for (Quartos quarto : reservaEncontrada.quartos) {
                sb.append("\nQuarto: ").append(quarto.getNumeroQuarto()).append(System.lineSeparator());
                sb.append("Tipo: ").append(quarto.getTipoQuarto()).append(System.lineSeparator());
                sb.append("Preco por noite: ").append(quarto.getPrecoPorNoite()).append(System.lineSeparator());
                sb.append("-------------------------------------------------------------------");
            }

            sb.append("\nData de check-in: ").append(reservaEncontrada.getDataCheckIn()).append(System.lineSeparator());
            sb.append("Data de check-out: ").append(reservaEncontrada.getDataCheckOut()).append(System.lineSeparator());
            sb.append("Numero de pessoas: ").append(reservaEncontrada.getNumeroPessoas()).append(System.lineSeparator());
            sb.append("Valor total da reserva: ").append(reservaEncontrada.getValorDiaria()).append(System.lineSeparator());
            sb.append("Valor De Despesas Adicionais: ").append(reservaEncontrada.getValorAdicional()).append(System.lineSeparator());
            sb.append("-------------------------------------------------------------------");

            Reserva reserva = new Reserva(); // Cria uma instância da classe Reserva
            double valorDevolvido = reserva.cancelarReservaDoClienteTela(codigo); // Chama o método na instância

            JOptionPane.showMessageDialog(null, "Reserva de Número: " + codigoReserva + " Cancelada!");
            JOptionPane.showMessageDialog(null, "Valor a ser Reembolsado ao Cliente: " + valorDevolvido);

            sb.append("\nValor a ser Reembolsado ao Cliente: ").append(valorDevolvido).append(System.lineSeparator());
            sb.append("-------------------------------------------------------------------");
            sb.append("\nO Calculo e feito com base na Data Atual de Hoje!");
            sb.append("\nMetodo foi comentado na Classe Reserva");

            mostraTexto.setText(sb.toString());
    }//GEN-LAST:event_BotaoConfirmarCancelamentoActionPerformed

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoConfirmarCancelamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane mostraTexto;
    private javax.swing.JTextField recebeCodigo;
    // End of variables declaration//GEN-END:variables
}
