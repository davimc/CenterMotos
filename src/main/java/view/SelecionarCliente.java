package view;

import model.Cliente;
import model.bean.ClienteBean;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelecionarCliente extends JFrame {
    private JTextField tfNomeComprador;
    private JButton btnBuscarComprador;
    private JPanel panel;
    private JList listMoto;
    private JButton btnContinuar;
    private JButton btnCancelar;

    public SelecionarCliente(){

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                new SelecionarPeca();
            }
        });
        btnBuscarComprador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("nome");
                modelo.addColumn("telefone");
                modelo.addColumn("endereco");
                pesquisaCliente(modelo, tfNomeComprador.getText()):
            }
        });

    }
    public static void pesquisaCliente(DefaultTableModel modelo, String nome{
        modelo.setNumRows(0);
        ClienteBean cBean = new ClienteBean();
        for(Cliente c: cBean.ListaClientesNome(nome)){
            modelo.addRow(new Object[]{c.getNome()})
        }
    }
}
