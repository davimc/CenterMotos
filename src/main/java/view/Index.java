package view;


import model.Servico;
import model.Venda;
import model.bean.ServicoBean;
import model.bean.VendaBean;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame{
    private JPanel panel1;
    private JTabbedPane tpNotificacoes;
    private JPanel tabClienDivida;
    private JPanel tabServPrazo;
    private JButton btnVenda;
    private JButton btnServico;
    private JButton btnClienteMoto;
    private JToolBar toolbar;
    private JTable table1;
    private JScrollPane scrollPaneCliente;
    private JTable table2;

    public Index(){
        super("Center Motos");
        setVisible(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setLocationRelativeTo(null);
        popularTabelaClienDivida();
        btnVenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                new SelecionarCliente();
            }
        });
        btnServico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                new CadastroServico();
            }
        });
        btnClienteMoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                new CadastroClienteMoto();
            }
        });
    }
    public void popularTabelaClienDivida(){

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("nome");
        modelo.addColumn("telefone");
        modelo.addColumn("divida");
        modelo.addColumn("endereco");
        pesquisarVenda(modelo);
        table2.setModel(modelo);
    }
    public static void pesquisarVenda(DefaultTableModel modelo){
        modelo.setNumRows(0);
        VendaBean vBean = new VendaBean();
        for(Venda v: vBean.listaVendasDatasPrazo(7)) {
            modelo.addRow(new Object[]{v.getCliente().getNome(), v.getDtPrevisao(), v.getCliente().getConta()});
        }
    }
    public void popularTabelaServicoPrazo(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("moto");
        modelo.addColumn("placa");
        modelo.addColumn("data entrada");
        modelo.addColumn("data previsão");
        pesquisarServico(modelo);
        table1.setModel(modelo);
    }
    public static void pesquisarServico(DefaultTableModel modelo){
        modelo.setNumRows(0);
        ServicoBean sBean = new ServicoBean();
        for(Servico s: sBean.listaServicoPrazo(7)){
            modelo.addRow(new Object[]{s.getMoto().getModelo(), s.getMoto().getPlaca(),s.getDataInicio(),s.getDataPrevisao()});
        }

    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        new Index();
    }
}
