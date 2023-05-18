/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;
import inserts.Inserts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.Timer;
import org.springframework.jdbc.core.JdbcTemplate;
import sptech.datawatch.Conexao;
import sptech.datawatch.Ip;
import tabelas.Maquinas;
import selects.Selects;
import login.TelaLogin;
import tabelas.Empresas;

/**
 *
 * @author leone
 */
public class SistemaDatawatch extends javax.swing.JFrame {

    private Timer timer;

    /**
     * Creates new form SistemaDatawatch
     */
    public SistemaDatawatch() {
        initComponents();

        // instânciando as conexões do JDBC para Azure e Mysql local (container)
        Looca looca = new Looca();
        Conexao conexaoAzure = new Conexao("azure");
        Conexao conexaoMysql = new Conexao("mysql");
        JdbcTemplate jdbcAzure = conexaoAzure.getConnection();
        JdbcTemplate jdbcMysql = conexaoMysql.getConnection();

        // inserindo empresa no banco de dados docker
        Integer fkEmpresa = TelaLogin.getListaDeUsuarios().get(0).getFkEmpresa();
        List<Empresas> empresa = Selects.pegarEmpresa(jdbcAzure, fkEmpresa);
        if (empresa != null) {
            inserts.Inserts.inserirEmpresaContainer(jdbcMysql, empresa.get(0));
        }

        // verificando se a máquina já existe no banco de dados através do endereço MAC
        Maquinas maquina = Selects.pegarMaquinaCorrespondente(jdbcAzure);

        if (maquina == null) {
            System.out.println("Máquina não existe. Inserindo dados no banco de dados");
            fkEmpresa = TelaLogin.getListaDeUsuarios().get(0).getFkEmpresa();
            inserts.Inserts.inserirDadosMaquinaEstatico(jdbcAzure, jdbcMysql, looca, fkEmpresa, null, false);
        } else {
            System.out.println("Máquina já existe\n");
            Integer idMaquina = maquina.getIdMaquina();
            inserts.Inserts.inserirDadosMaquinaEstatico(jdbcAzure, jdbcMysql, looca, null, idMaquina, true);
        }

        setTitle("DATAWATCH - Sistema");

        lblCapRamTotal.setText(String.format("%s", Conversor.formatarBytes(looca.getMemoria().getTotal())));

        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        labels.add(lblCapQtdDisco1);
        labels.add(lblCapQtdDisco2);
        labels.add(lblCapQtdDisco3);
        for (int i = 0; i < looca.getGrupoDeDiscos().getQuantidadeDeDiscos(); i++) {
            labels.get(i).setText(String.format(
                    "Total: %s Livre: %s",
                    Conversor.formatarBytes(looca.getGrupoDeDiscos().getDiscos().get(i).getTamanho()),
                    Conversor.formatarBytes(looca.getGrupoDeDiscos().getVolumes().get(i).getDisponivel())));
        }

        lblInfo.setText("Capturando dados!");

        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capturar:
                // cpuUso, temperatura ?, ramUso, redeUpload, redeDownload, LivreDisco1, LivreDisco2, LivreDisco3
                Maquinas maquina = Selects.pegarMaquinaCorrespondente(jdbcAzure);
                inserts.Inserts.capturarInserirDados(maquina.getIdMaquina(), maquina.getFkEmpresa(), jdbcAzure, jdbcMysql);
                Ip ip = new Ip();
                lblCapMemoriaRam.setText(Conversor.formatarBytes(looca.getMemoria().getEmUso()));
                lblCapIp.setText(ip.getIp());
                lblCapCpu.setText(String.format("%.2f%% de uso", looca.getProcessador().getUso()));

            }
        });

        timer.setRepeats(true);

        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsoMemoriaRam4 = new javax.swing.JLabel();
        lblCapMemoriaRam4 = new javax.swing.JLabel();
        lblUsoMemoriaRam5 = new javax.swing.JLabel();
        lblCapMemoriaRam5 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTituloCapturas = new javax.swing.JLabel();
        lblUsoMemoriaRam = new javax.swing.JLabel();
        lblCapMemoriaRam = new javax.swing.JLabel();
        lblQtdDisco1 = new javax.swing.JLabel();
        lblCapQtdDisco1 = new javax.swing.JLabel();
        lblUsoCpu = new javax.swing.JLabel();
        lblCapCpu = new javax.swing.JLabel();
        lblIp = new javax.swing.JLabel();
        lblCapIp = new javax.swing.JLabel();
        lblRamTotal = new javax.swing.JLabel();
        lblCapRamTotal = new javax.swing.JLabel();
        lblQtdDisco2 = new javax.swing.JLabel();
        lblQtdDisco3 = new javax.swing.JLabel();
        lblCapQtdDisco2 = new javax.swing.JLabel();
        lblCapQtdDisco3 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();

        lblUsoMemoriaRam4.setForeground(new java.awt.Color(255, 255, 255));
        lblUsoMemoriaRam4.setText("Uso memória RAM:");

        lblCapMemoriaRam4.setForeground(new java.awt.Color(255, 255, 255));
        lblCapMemoriaRam4.setText("-------------");

        lblUsoMemoriaRam5.setForeground(new java.awt.Color(255, 255, 255));
        lblUsoMemoriaRam5.setText("Uso memória RAM:");

        lblCapMemoriaRam5.setForeground(new java.awt.Color(255, 255, 255));
        lblCapMemoriaRam5.setText("-------------");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 153, 0));

        jPanel1.setBackground(new java.awt.Color(24, 24, 24));

        lblTituloCapturas.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblTituloCapturas.setForeground(new java.awt.Color(255, 255, 0));
        lblTituloCapturas.setText("CAPTURAS");

        lblUsoMemoriaRam.setForeground(new java.awt.Color(255, 255, 255));
        lblUsoMemoriaRam.setText("Uso memória RAM");

        lblCapMemoriaRam.setForeground(new java.awt.Color(255, 255, 255));
        lblCapMemoriaRam.setText("-------------");

        lblQtdDisco1.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdDisco1.setText("Disco 1");

        lblCapQtdDisco1.setForeground(new java.awt.Color(255, 255, 255));
        lblCapQtdDisco1.setText("------------");

        lblUsoCpu.setForeground(new java.awt.Color(255, 255, 255));
        lblUsoCpu.setText("Uso de Processador");

        lblCapCpu.setForeground(new java.awt.Color(255, 255, 255));
        lblCapCpu.setText("-------------");

        lblIp.setForeground(new java.awt.Color(255, 255, 255));
        lblIp.setText("IP:");

        lblCapIp.setForeground(new java.awt.Color(255, 255, 255));
        lblCapIp.setText("-------------");

        lblRamTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblRamTotal.setText("RAM Total");

        lblCapRamTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblCapRamTotal.setText("-------------");

        lblQtdDisco2.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdDisco2.setText("Disco 2");

        lblQtdDisco3.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdDisco3.setText("Disco 3");

        lblCapQtdDisco2.setForeground(new java.awt.Color(255, 255, 255));
        lblCapQtdDisco2.setText("------------");

        lblCapQtdDisco3.setForeground(new java.awt.Color(255, 255, 255));
        lblCapQtdDisco3.setText("------------");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIp)
                        .addGap(42, 42, 42)
                        .addComponent(lblCapIp, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblTituloCapturas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCapRamTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblUsoMemoriaRam)
                                    .addGap(42, 42, 42)
                                    .addComponent(lblCapMemoriaRam, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblRamTotal)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblUsoCpu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCapCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQtdDisco3)
                            .addComponent(lblQtdDisco2)
                            .addComponent(lblQtdDisco1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCapQtdDisco2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(lblCapQtdDisco3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCapQtdDisco1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTituloCapturas)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtdDisco1)
                    .addComponent(lblCapQtdDisco1)
                    .addComponent(lblRamTotal)
                    .addComponent(lblCapRamTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsoMemoriaRam)
                    .addComponent(lblCapMemoriaRam)
                    .addComponent(lblQtdDisco2)
                    .addComponent(lblCapQtdDisco2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtdDisco3)
                    .addComponent(lblCapQtdDisco3))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsoCpu)
                    .addComponent(lblCapCpu)
                    .addComponent(lblIp)
                    .addComponent(lblCapIp))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        lblInfo.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(0, 0, 0));
        lblInfo.setText("---------------");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SistemaDatawatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaDatawatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaDatawatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaDatawatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaDatawatch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCapCpu;
    private javax.swing.JLabel lblCapIp;
    private javax.swing.JLabel lblCapMemoriaRam;
    private javax.swing.JLabel lblCapMemoriaRam4;
    private javax.swing.JLabel lblCapMemoriaRam5;
    private javax.swing.JLabel lblCapQtdDisco1;
    private javax.swing.JLabel lblCapQtdDisco2;
    private javax.swing.JLabel lblCapQtdDisco3;
    private javax.swing.JLabel lblCapRamTotal;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblIp;
    private javax.swing.JLabel lblQtdDisco1;
    private javax.swing.JLabel lblQtdDisco2;
    private javax.swing.JLabel lblQtdDisco3;
    private javax.swing.JLabel lblRamTotal;
    private javax.swing.JLabel lblTituloCapturas;
    private javax.swing.JLabel lblUsoCpu;
    private javax.swing.JLabel lblUsoMemoriaRam;
    private javax.swing.JLabel lblUsoMemoriaRam4;
    private javax.swing.JLabel lblUsoMemoriaRam5;
    // End of variables declaration//GEN-END:variables
}
