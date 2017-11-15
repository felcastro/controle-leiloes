package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.LeilaoException;
import business.Usuario;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class JanelaCriarLeilao extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataInicio;
	private JTextField txtDataFim;
	private JComboBox cbNatureza;
	private JComboBox cbTipoLance;

	public JanelaCriarLeilao(Usuario usuario) {
		setTitle("Criar Leilão");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataInicio = new JLabel("Data Inicio: (dd/mm/yyyy)");
		lblDataInicio.setBounds(12, 138, 192, 15);
		contentPane.add(lblDataInicio);
		
		JLabel lblNatureza = new JLabel("Natureza:");
		lblNatureza.setBounds(12, 12, 93, 15);
		contentPane.add(lblNatureza);
		
		JLabel lblTipoLance = new JLabel("Tipo Lance:");
		lblTipoLance.setBounds(12, 75, 93, 15);
		contentPane.add(lblTipoLance);
		
		JComboBox cbNatureza = new JComboBox();
		cbNatureza.setBounds(12, 39, 192, 24);
		contentPane.add(cbNatureza);
		
		JComboBox cbTipoLance = new JComboBox();
		cbTipoLance.setBounds(12, 102, 192, 24);
		contentPane.add(cbTipoLance);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setBounds(12, 165, 197, 19);
		contentPane.add(txtDataInicio);
		txtDataInicio.setColumns(10);
		
		JLabel lblDataFim = new JLabel("Data Fim: (dd/mm/yyyy)");
		lblDataFim.setBounds(12, 196, 192, 15);
		contentPane.add(lblDataFim);
		
		txtDataFim = new JTextField();
		txtDataFim.setBounds(12, 223, 197, 19);
		contentPane.add(txtDataFim);
		txtDataFim.setColumns(10);
		
		JButton btnCriarLeilao = new JButton("Criar Leilão");
		btnCriarLeilao.setBounds(87, 254, 117, 25);
		contentPane.add(btnCriarLeilao);
		
		/* ~~~~~~~~~~~~~~~~~~ Events ~~~~~~~~~~~~~~~~~~ */
		
		cbNatureza.addItem("Demanda");
		cbNatureza.addItem("Oferta");
		cbTipoLance.addItem("Aberto");
		cbTipoLance.addItem("Fechado");
		
		btnCriarLeilao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarLeilao(e);
			}
		});
	}
	
	private void criarLeilao(java.awt.event.ActionEvent evt){
		String natureza = cbNatureza.getSelectedItem().toString();
		String tipoLance = cbTipoLance.getSelectedItem().toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Date parsedDate;
		Date parsedDate2;
		try {
			parsedDate = dateFormat.parse(txtDataInicio.getText());
			parsedDate2 = dateFormat.parse(txtDataFim.getText());
			Timestamp dataInicio = new java.sql.Timestamp(parsedDate.getTime());
			Timestamp dataFim = new java.sql.Timestamp(parsedDate2.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
