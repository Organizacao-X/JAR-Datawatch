package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sptech.datawatch.Conexao;
import tabelas.Usuarios;

public class TelaLogin extends javax.swing.JFrame {

    private Timer tempo;
    private Sha2_256 hash = new Sha2_256();
    private static List<Usuarios> listaDeUsuarios = new ArrayList();

    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        inputEmail = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        inputSenha = new javax.swing.JPasswordField();
        pnlTitulo = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        pnlMensagem = new javax.swing.JPanel();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DATAWATCH - Login");
        setResizable(false);

        pnlLogin.setBackground(new java.awt.Color(51, 51, 51));
        pnlLogin.setForeground(new java.awt.Color(255, 255, 51));
        pnlLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        inputEmail.setBackground(new java.awt.Color(204, 204, 0));
        inputEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputEmail.setForeground(new java.awt.Color(0, 0, 0));
        inputEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(0, 0, 0));
        btnEntrar.setText("ENTRAR");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(204, 204, 204));
        lblEmail.setText("E-mail");

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(204, 204, 204));
        lblSenha.setText("Senha");

        inputSenha.setBackground(new java.awt.Color(204, 204, 0));
        inputSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputSenha.setForeground(new java.awt.Color(0, 0, 0));
        inputSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSenha)
                            .addComponent(lblEmail)
                            .addComponent(inputEmail)
                            .addComponent(inputSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnEntrar)
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addGap(56, 56, 56))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnEntrar)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlTitulo.setBackground(new java.awt.Color(204, 204, 0));
        pnlTitulo.setForeground(new java.awt.Color(255, 255, 51));
        pnlTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(0, 0, 0));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/LOGOcomtexto_V3.png"))); // NOI18N
        lblLogin.setToolTipText("");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMensagem.setBackground(new java.awt.Color(204, 204, 0));

        lblMensagem.setForeground(new java.awt.Color(0, 0, 0));
        lblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMensagemLayout = new javax.swing.GroupLayout(pnlMensagem);
        pnlMensagem.setLayout(pnlMensagemLayout);
        pnlMensagemLayout.setHorizontalGroup(
            pnlMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMensagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMensagemLayout.setVerticalGroup(
            pnlMensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMensagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        tempo = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SistemaDatawatch sisDat = new SistemaDatawatch();

                sisDat.setVisible(true);
                dispose();
            }
        });
        tempo.setRepeats(false);

        // TODO add your handling code here:
        String email = inputEmail.getText();
        String senha = inputSenha.getText();

        // AQUI A GENTE CRIA CONEXAO COM O BANCO DE DADOS 
        // CONFIGURADO NO CONEXAO.JAVA
        Conexao conexaoAzure = new Conexao("azure");

        // ESSE CON SEMPRE VAMOS USAR PRA DAR COMANDOS NO BANCO
        JdbcTemplate con = conexaoAzure.getConnection();

        // AQUI PEGA O ENDEREÇO DE CONEXAO E USA O TEMPLATE PRA ACESSAR
        conexaoAzure.getConnection();

        try {
            senha = hash.criarHash(senha);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        listaDeUsuarios = con.query("select * from Usuarios where email = ? and senha = ?",
                new BeanPropertyRowMapper(Usuarios.class), email, senha);

        if (!listaDeUsuarios.isEmpty()) {
            // A lista não está vazia, podemos acessar o primeiro elemento
            lblMensagem.setText("Login realizado com sucesso! Conectando...");
            System.out.println(listaDeUsuarios.get(0).getEmail());
            // Inicia o timer para fechar a janela após 3 segundos
            tempo.start();
        } else {
            // A lista está vazia, tratamento de erro aqui
            lblMensagem.setText("USUÁRIO E/OU SENHA INVÁLIDO!");
            System.out.println("A lista está vazia!");
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void inputSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSenhaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }

        });
    }

    public static String criarHash(String senhaNormal) throws NoSuchAlgorithmException {
        senhaNormal += senhaNormal;
        System.out.println(senhaNormal);
        // Obtém uma instância do algoritmo SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Converte a senha para um array de bytes e aplica o algoritmo
        byte[] hashBytes = md.digest(senhaNormal.getBytes());

        // Converte o array de bytes para uma string em formato hexadecimal
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        String hashSenha = sb.toString();
        return hashSenha;
    }

    public static List<Usuarios> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlMensagem;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables
}
