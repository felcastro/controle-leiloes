package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Usuario;
import business.UsuarioException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCp;
	private JTextField txtSenhaA;
	private JTextField txtSenhaB;
	private UsuarioControlador controlador;

	public JanelaCadastroUsuario(UsuarioControlador controlador) {
		this.controlador = controlador;
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 70, 15);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(12, 39, 290, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(12, 70, 70, 15);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(12, 97, 290, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCpfcnpjapenasNumeros = new JLabel("Cpf/Cnpj (APENAS NUMEROS)");
		lblCpfcnpjapenasNumeros.setBounds(12, 128, 215, 15);
		contentPane.add(lblCpfcnpjapenasNumeros);
		
		txtCp = new JTextField();
		txtCp.setBounds(12, 155, 290, 19);
		contentPane.add(txtCp);
		txtCp.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(12, 186, 70, 15);
		contentPane.add(lblSenha);
		
		txtSenhaA = new JTextField();
		txtSenhaA.setBounds(12, 213, 290, 19);
		contentPane.add(txtSenhaA);
		txtSenhaA.setColumns(10);
		
		JLabel lblRepitaASenha = new JLabel("Repita a senha:");
		lblRepitaASenha.setBounds(12, 244, 112, 15);
		contentPane.add(lblRepitaASenha);
		
		txtSenhaB = new JTextField();
		txtSenhaB.setBounds(12, 271, 290, 19);
		contentPane.add(txtSenhaB);
		txtSenhaB.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(101, 302, 117, 25);
		contentPane.add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar(arg0);
			}
		});
	}
	
	private void cadastrar(java.awt.event.ActionEvent evt){
		String nome = txtNome.getText();
		String cp = txtCp.getText();
		String email = txtEmail.getText();
		String senhaA = txtSenhaA.getText();
		String senhaB = txtSenhaB.getText();
		if(senhaA.equals(senhaB)){
			try {
				boolean status = controlador.adicionarUsuario(nome, cp, email, senhaA);
				if (status) {
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			} catch (UsuarioException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "As senhas estão diferentes!", "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}
}
