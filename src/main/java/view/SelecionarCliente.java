package view;

import javax.swing.*;
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
    }
}
