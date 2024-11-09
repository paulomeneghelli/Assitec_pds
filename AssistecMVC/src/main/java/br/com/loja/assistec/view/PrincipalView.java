package br.com.loja.assistec.view;

	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;

	import javax.swing.GroupLayout;
	import javax.swing.GroupLayout.Alignment;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JOptionPane;

	public class PrincipalView extends JFrame {

		private JMenuItem mSair;
		private JMenuItem mSobre;
		private JMenuItem mUsuario;
		

		public PrincipalView(String user, String perfil) {
			setTitle("Sistema de Gestão ASSISTEC");
			setBounds(100, 100, 450, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel lblUsuario = new JLabel("");
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblUsuario)
						.addContainerGap(378, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(214, Short.MAX_VALUE)
						.addComponent(lblUsuario)
						.addContainerGap())
			);
			getContentPane().setLayout(groupLayout);
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu menuArquivo = new JMenu("Arquivo");
			menuBar.add(menuArquivo);
			
			mSair = new JMenuItem("Sair");
			mSair.setActionCommand("MenuSairAction");
			menuArquivo.add(mSair);
			
			JMenu menuCadastro = new JMenu("Cadastro");
			menuCadastro.setEnabled(false);
			menuBar.add(menuCadastro);
			
			mUsuario = new JMenuItem("Usuários");
			mUsuario.setActionCommand("MenuUsuariosAction");
			menuCadastro.add(mUsuario);
			
			JMenu menuRelatorio = new JMenu("Relatórios");
			menuRelatorio.setEnabled(false);
			menuBar.add(menuRelatorio);
			
			JMenu menuAjuda = new JMenu("Ajuda");
			menuBar.add(menuAjuda);
			
			mSobre = new JMenuItem("Sobre");
			mSobre.setActionCommand("MenuSobreAction");
			
			menuAjuda.add(mSobre);
			
			lblUsuario.setText(user);
			
			if("Admin".equalsIgnoreCase(perfil)) {
				menuCadastro.setEnabled(true);
				menuRelatorio.setEnabled(true);
			}

		}
		

		public void addPrincipalListener(ActionListener listener) {
	        mSair.addActionListener(listener);
	        mSobre.addActionListener(listener);
	        mUsuario.addActionListener(listener);
	    }
		
		public void mostrarMensagem(String mensagem, String tipo) {
			int messageType = switch (tipo) {
			case "Atenção" -> JOptionPane.WARNING_MESSAGE;
			case "Informação" -> JOptionPane.INFORMATION_MESSAGE;
			case "Erro" -> JOptionPane.ERROR_MESSAGE;
			default -> JOptionPane.PLAIN_MESSAGE;
			};
			JOptionPane.showMessageDialog(this, mensagem, tipo, messageType);
		}
		
		public int SairSistema() {
			int sair = JOptionPane.showConfirmDialog(null,
	                "Você deseja sair??",
	                "Atenção", JOptionPane.YES_NO_OPTION);
			return sair;
		}


}