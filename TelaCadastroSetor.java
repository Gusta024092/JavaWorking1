package caminhaodelixo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TelaCadastroSetor extends javax.swing.JInternalFrame {
    
    public TelaCadastroSetor() {
        super("Cadastro de Setores");
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCadastrarSetor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNumPontosColeta = new javax.swing.JTextField();
        cmbMunicipios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNomeSetor1 = new javax.swing.JTextField();

        jLabel1.setText("Municípios");

        btnCadastrarSetor.setText("Cadastrar Setor");
        btnCadastrarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarSetorActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome do Setor");

        cmbMunicipios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Queimados", "Japeri", "Nilópolis" }));

        jLabel3.setText("Nº de Pontos Coleta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnCadastrarSetor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumPontosColeta, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(cmbMunicipios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNomeSetor1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbMunicipios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeSetor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumPontosColeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnCadastrarSetor)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarSetorActionPerformed
    try{
    String nomeSetor = txtNomeSetor1.getText();
    String municipios = (String) cmbMunicipios.getSelectedItem();
    int qtdeSetores = Integer.parseInt(txtNumPontosColeta.getText());
            
    Setor st = new Setor(nomeSetor, municipios);
    cts.adicao(st);
    listamunicipios.add(st);
    
    if (qtdeSetores > 0){
        int c = 0;
        for (int i=0; i < qtdeSetores; i++){
            c = i;
            c+=1;
            capacidadeMaxima.add(Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade máxima do ponto " + c)));
        }
    } else {
        JOptionPane.showMessageDialog(null, "Não é possivel inserir esse tipo de valor!");
    }
    
    int acum = 0;
    for (int i=0; i<capacidadeMaxima.size(); i++){
        acum += capacidadeMaxima.get(i);
    }
    JOptionPane.showMessageDialog(null, "O setor " + nomeSetor + ", tem total de lixo acumulado nos pontos de coleta = " + acum);
    PontosColeta pc = new PontosColeta(acum);
    pc.retornar(pc);
    JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
    } catch (Exception ex){
        //System.out.println(ex.toString());
        JOptionPane.showMessageDialog(null, "Procedimento cancelado!");
    }
        
    }//GEN-LAST:event_btnCadastrarSetorActionPerformed
    Circuito cts = new Circuito();
    ArrayList<Integer> capacidadeMaxima = new ArrayList();
    ArrayList<Setor> listamunicipios = new ArrayList();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarSetor;
    private javax.swing.JComboBox<String> cmbMunicipios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNomeSetor1;
    private javax.swing.JTextField txtNumPontosColeta;
    // End of variables declaration//GEN-END:variables
}
