package caminhaodelixo;

import java.util.ArrayList;
import java.util.Map;

public class TelaAssociacaoCircuito extends javax.swing.JInternalFrame {
    public TelaAssociacaoCircuito() {
        super("Tela do Gestor (Associação de Circuito)");
        initComponents();
        for (String item : Circuito.exibir()){
            cmbCircuito.addItem(item);
        }
        for (Object item2 : Frota.retornoFrota()){
            cmbCaminhao.addItem(item2.toString());
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAssociar = new javax.swing.JButton();
        cmbCircuito = new javax.swing.JComboBox<>();
        cmbCaminhao = new javax.swing.JComboBox<>();
        lblResposta = new javax.swing.JLabel();
        lblTexto2 = new javax.swing.JLabel();

        jLabel1.setText("Caminhão (seu ID)");

        jLabel2.setText("Circuito");

        btnAssociar.setText("Associar");
        btnAssociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssociarActionPerformed(evt);
            }
        });

        lblResposta.setText("Resultado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTexto2)
                    .addComponent(lblResposta)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCaminhao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCircuito, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAssociar))))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jLabel2)
                    .addContainerGap(322, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(cmbCircuito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCaminhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnAssociar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lblResposta)
                .addGap(18, 18, 18)
                .addComponent(lblTexto2)
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jLabel2)
                    .addContainerGap(207, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssociarActionPerformed
        String caminhaoSelecionado = (String) cmbCaminhao.getSelectedItem();
        String circuitoPercorrer = (String) cmbCircuito.getSelectedItem();
        int tik = Integer.parseInt(caminhaoSelecionado) - 1;
        float vaiz = 0;
        String muniz = "";
        ArrayList<Map.Entry<Integer, Float>> caminhao = new ArrayList<Map.Entry<Integer, Float>>();
        ArrayList<Map.Entry<String, Float>> objetos = new ArrayList<Map.Entry<String, Float>>();
        for (int i=0; i<PontosColeta.retornarLixo().size(); i++){
                muniz = Circuito.exibir().get(i);
                vaiz = (Float) PontosColeta.retornarLixo().get(i);
                objetos.add(Map.entry(muniz, vaiz));
        }
        String first;
        float tot = 0;
        float res=0;
        for (int j=0; j<Frota.capacidadeTotal().size(); j++){ 
            if (tik == j){
                first = (String) Frota.capacidadeTotal().get(j);
                tot = Float.parseFloat(first);
            }
        }
        float valorGlobal = 0;
        for (Map.Entry<String, Float> entrada : objetos) {
            String chave = entrada.getKey();
            float valor = entrada.getValue();
            valorGlobal = valor;
            if (circuitoPercorrer.equals(chave)){
                res = tot - valor;
            }
        } 
        if (valorGlobal > tot){
            lblResposta.setText("Não é possível carregar todo esse lixo no caminhão!");
            lblTexto2.setText("Por favor, reduza a carga de lixo ou aumente o número de caminhões");
        } else {
            lblResposta.setText("O lixo coletado foi de :  " + valorGlobal + " KG");
            lblTexto2.setText("Onde a capacidade restante suportada pela frota é de: " + res + " KG");
        }
        
    }//GEN-LAST:event_btnAssociarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssociar;
    private javax.swing.JComboBox<String> cmbCaminhao;
    private javax.swing.JComboBox<String> cmbCircuito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblResposta;
    private javax.swing.JLabel lblTexto2;
    // End of variables declaration//GEN-END:variables
}
