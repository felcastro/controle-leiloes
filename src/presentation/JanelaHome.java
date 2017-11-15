package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Leilao;
import business.LeilaoException;
import business.Usuario;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class JanelaHome extends JFrame {

	private JPanel contentPane;
	private Usuario usuarioLogado;
	private LeilaoControlador controlador;
	private JTextField txtDeletaLance;
	private JTextField txtPostarLance;
	private JTextField txtValorLance;
	
	public JanelaHome(Usuario usuario) throws LeilaoException {
		controlador = new LeilaoControlador();
		this.usuarioLogado = usuario;
		this.setTitle("Bem Vindo " + usuario.getNome() + "! ID: " + usuario.getId());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCriarLeilao = new JButton("Criar Leilão");
		btnCriarLeilao.setBounds(12, 12, 140, 25);
		contentPane.add(btnCriarLeilao);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 59, 426, 2);
		contentPane.add(separator);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(437, 73, 1, 15);
		contentPane.add(textArea);
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.setBounds(12, 73, 140, 25);
		contentPane.add(btnListarTodos);
		
		JButton btnPostarLance = new JButton("Postar");
		btnPostarLance.setBounds(320, 263, 91, 25);
		contentPane.add(btnPostarLance);
		
		JLabel lblDeletarLance = new JLabel("Deletar Lance");
		lblDeletarLance.setBounds(297, 73, 122, 15);
		contentPane.add(lblDeletarLance);
		
		JLabel lblId_1 = new JLabel("ID Lote:");
		lblId_1.setBounds(238, 102, 70, 15);
		contentPane.add(lblId_1);
		
		txtDeletaLance = new JTextField();
		txtDeletaLance.setBounds(297, 100, 114, 19);
		contentPane.add(txtDeletaLance);
		txtDeletaLance.setColumns(10);
		
		JButton btnDeletarLance = new JButton("Deletar");
		btnDeletarLance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funcionalidade não implementada!", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnDeletarLance.setBounds(320, 133, 91, 25);
		contentPane.add(btnDeletarLance);
		
		JLabel lblPostarLance = new JLabel("Postar Lance");
		lblPostarLance.setBounds(309, 180, 101, 15);
		contentPane.add(lblPostarLance);
		
		txtPostarLance = new JTextField();
		txtPostarLance.setBounds(299, 211, 114, 19);
		contentPane.add(txtPostarLance);
		txtPostarLance.setColumns(10);
		
		JLabel lblIdLote = new JLabel("ID Lote:");
		lblIdLote.setBounds(238, 212, 70, 15);
		contentPane.add(lblIdLote);
		
		txtValorLance = new JTextField();
		txtValorLance.setBounds(299, 237, 114, 19);
		contentPane.add(txtValorLance);
		txtValorLance.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(247, 239, 70, 15);
		contentPane.add(lblValor);
		
		/* ~~~~~~~~~~~~~~~~~~ Events ~~~~~~~~~~~~~~~~~~ */
		
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarTodos(arg0);
			}
		});
		
		btnCriarLeilao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				criarLeilao(arg0);
			}
		});
		
		btnPostarLance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				postarLance(arg0);
			}
		});
	}
	
	private void postarLance(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "Funcionalidade não implementada!", "Erro", JOptionPane.WARNING_MESSAGE);
		String idLoteStr = txtPostarLance.getText();
		double valor = Double.parseDouble(txtValorLance.getText());
		try {
			boolean status = controlador.adicionarLance(usuarioLogado.getId(), idLoteStr, valor);
			if (status) {
				JOptionPane.showMessageDialog(null, "Lance adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao adicionar lote!\nVerifique se ele é seu!", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		} catch (LeilaoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void listarTodos(java.awt.event.ActionEvent evt){
		try {
			List<Leilao> leiloes = controlador.getTodos();
			String leiloesToStr = "";
			for (int i = 0; i < leiloes.size(); i++) {
				leiloesToStr += leiloes.get(i).toString();
				leiloesToStr += "\n~~~~~~~~~~~~~~~~//~~~~~~~~~~~~~~~~";
			}
			JanelaInfo info = new JanelaInfo("Leilões", leiloesToStr);
			info.setVisible(true);
		} catch (LeilaoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void criarLeilao(java.awt.event.ActionEvent evt){
		JanelaCriarLeilao criarLeilao = new JanelaCriarLeilao(usuarioLogado);
		criarLeilao.setVisible(true);
		JOptionPane.showMessageDialog(null, "Funcionalidade não implementada!", "Erro", JOptionPane.WARNING_MESSAGE);
	}
}
