package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Usuario;
import business.UsuarioException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private UsuarioControlador controlador;

	public JanelaLogin() throws UsuarioException {
		controlador = new UsuarioControlador();
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(126, 102, 216, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(126, 141, 216, 19);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(68, 104, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(68, 143, 70, 15);
		contentPane.add(lblSenha);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setBounds(267, 172, 75, 25);
		contentPane.add(btnLogar);
		
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setBounds(126, 172, 114, 25);
		contentPane.add(btnCriarConta);
		
		/* ~~~~~~~~~~~~~~~~~~ Events ~~~~~~~~~~~~~~~~~~ */
		
		txtEmail.setText("fpocastro@gmail.com");
		txtSenha.setText("12345");
		
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logar(arg0);
			}
		});
		
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarConta(e);
			}
		});
	}
	
	private void logar(java.awt.event.ActionEvent evt) {
		try {
			String email = txtEmail.getText();
			String senha = txtSenha.getText();
			Usuario usuario = controlador.getLogin(email, senha);
			if (usuario != null) {
				JOptionPane.showMessageDialog(null, "Usuario encontrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos!", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		} catch (UsuarioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void criarConta(java.awt.event.ActionEvent evt){
		JanelaCadastroUsuario cadastro = new JanelaCadastroUsuario(controlador);
		cadastro.setVisible(true);
	}
}
