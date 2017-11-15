package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JanelaInfo extends JFrame {

	private JPanel contentPane;

	public JanelaInfo(String titulo, String dados) {
		this.setTitle(titulo);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 426, 276);
		contentPane.add(scrollPane);
		
		JTextArea txtDados = new JTextArea();
		txtDados.setEditable(false);
		scrollPane.setViewportView(txtDados);
		txtDados.setText(dados);
	}
}
