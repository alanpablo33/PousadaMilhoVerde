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
import arquivos.JsonFerramentas;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Pablo
 */
public class TelaFazerReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaFazerReserva
     */
    public TelaFazerReserva() {
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        recebeCodigoDoCliente = new javax.swing.JTextField();
        codigoDoCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaDeQuartos = new javax.swing.JList<>();
        texQuarto = new javax.swing.JLabel();
        CalendaroInicio = new com.toedter.calendar.JCalendar();
        CalendarioFim = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        BotaoConfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BotaoVerificarReservaFeita = new javax.swing.JButton();
        verReserva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CampoTextoParaReserva = new javax.swing.JTextPane();
        VagasAdd = new javax.swing.JFormattedTextField();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Fazer Reserva Para o Cliente");

        codigoDoCliente.setText("Digite o codigo do Cliente");

        ListaDeQuartos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "         Quartos", "Quarto Normal - 00", "Quarto Normal - 01", "Quarto Normal - 02", "Quarto Normal - 03", "Quarto Normal - 04", "Quarto Luxo--- - 05", "Quarto Luxo  --- 06", "Quarto Luxo  --- 07", "Quarto Luxo  --- 08", "Quarto Luxo  --- 09", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListaDeQuartos);

        texQuarto.setText("Selecione o Quarto          Data check-in                                                 Data check-out");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel1.setText("Faça a Reserva na Pousada Milho Verde");

        BotaoConfirmar.setText("Confirmar Reserva");
        BotaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConfirmarActionPerformed(evt);
            }
        });

        jLabel2.setText("Vagas");

        BotaoVerificarReservaFeita.setText("Verificar Reserva");
        BotaoVerificarReservaFeita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVerificarReservaFeitaActionPerformed(evt);
            }
        });

        jLabel3.setText("Ver Reserva");

        jScrollPane2.setViewportView(CampoTextoParaReserva);

        try {
            VagasAdd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texQuarto, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codigoDoCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(recebeCodigoDoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CalendaroInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalendarioFim, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(BotaoConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotaoVerificarReservaFeita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VagasAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verReserva)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoDoCliente)
                    .addComponent(recebeCodigoDoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texQuarto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(CalendaroInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(CalendarioFim, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(VagasAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoVerificarReservaFeita, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        setBounds(300, 20, 972, 555);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConfirmarActionPerformed
   String codigoCliente = recebeCodigoDoCliente.getText();

    if (codigoCliente.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Insira o Código do cliente");
        return;
    }

    int codigoDoCliente = Integer.parseInt(codigoCliente);

    int numeroDoQuarto = ListaDeQuartos.getSelectedIndex();
    if (numeroDoQuarto < 0) {
        JOptionPane.showMessageDialog(null, "Selecione um quarto");
        return;
    }

    String vagas = VagasAdd.getText();
    if (vagas.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Insira a quantidade de vagas");
        return;
    }
    int quantasVagas = Integer.parseInt(vagas);

    if (CalendaroInicio.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Selecione a data de check-in");
        return;
    }
    SimpleDateFormat formatarSimplesDataInicio = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatada = formatarSimplesDataInicio.format(this.CalendaroInicio.getDate());
    int diaI = CalendaroInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
    int mesI = CalendaroInicio.getCalendar().get(Calendar.MONTH) + 1; // Adiciona 1 ao mês retornado
    int anoI = CalendaroInicio.getCalendar().get(Calendar.YEAR);

    if (CalendarioFim.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Selecione a data de check-out");
        return;
    }
    SimpleDateFormat formatarSimplesDataFim = new SimpleDateFormat("dd/MM/yyyy");
    String dataFormatadaFim = formatarSimplesDataFim.format(this.CalendarioFim.getDate());
    int diaF = CalendarioFim.getCalendar().get(Calendar.DAY_OF_MONTH);
    int mesF = CalendarioFim.getCalendar().get(Calendar.MONTH) + 1; // Adiciona 1 ao mês retornado
    int anoF = CalendarioFim.getCalendar().get(Calendar.YEAR);

    Classes.Reserva.criarSalvarReservaTela(codigoDoCliente, numeroDoQuarto, anoI, mesI, diaI, anoF, mesF, diaF, quantasVagas, dataFormatada, dataFormatadaFim);

    JOptionPane.showMessageDialog(null, "Cadastro Feito");
    }//GEN-LAST:event_BotaoConfirmarActionPerformed

    private void BotaoVerificarReservaFeitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoVerificarReservaFeitaActionPerformed
       String codigoReserva = verReserva.getText();

    if (codigoReserva.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Insira o Código da reserva");
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

        CampoTextoParaReserva.setText(sb.toString());
    } else {
        CampoTextoParaReserva.setText("Reserva não encontrada.");
    }
    }//GEN-LAST:event_BotaoVerificarReservaFeitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoConfirmar;
    private javax.swing.JButton BotaoVerificarReservaFeita;
    private com.toedter.calendar.JCalendar CalendarioFim;
    private com.toedter.calendar.JCalendar CalendaroInicio;
    private javax.swing.JTextPane CampoTextoParaReserva;
    private javax.swing.JList<String> ListaDeQuartos;
    private javax.swing.JFormattedTextField VagasAdd;
    private javax.swing.JLabel codigoDoCliente;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField recebeCodigoDoCliente;
    private javax.swing.JLabel texQuarto;
    private javax.swing.JTextField verReserva;
    // End of variables declaration//GEN-END:variables
}