package br.unesp.sysmatema.test;

import javax.swing.JOptionPane;

import br.unesp.sysmatema.facade.PessoaFacade;
import br.unesp.sysmatema.model.Endereco;
import br.unesp.sysmatema.model.Funcionario;
import br.unesp.sysmatema.model.Usuario;

public class FirstRun {

	public static void main(String[] args) {
		
		
		String adminName;
		String adminPassword;
		String adminConfirmPassword;
		
		Funcionario funcionario = new Funcionario();
		Endereco endereco = new Endereco();
		Usuario usuario = new Usuario();
		PessoaFacade pessoaFacade = new PessoaFacade();
		
		
		
		boolean isEqual;
		
		adminName = JOptionPane.showInputDialog(null, "Entre com o NOME COMPLETO do Administrador", "admin" );
		
		
		do {
			adminPassword = JOptionPane.showInputDialog(null, "Entre com a senha de Administrador", "admin" );
			adminConfirmPassword = JOptionPane.showInputDialog(null, "Confirme a senha de Administrador");
			
			isEqual = adminPassword.equals(adminConfirmPassword);
			
			if(!(isEqual)) {
				JOptionPane.showMessageDialog(null,  "AS SENHAS INFORMADAS SÃO DIFERENTES, REPITA OPERAÇÃO", "SENHAS DIFERENTES!", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(adminPassword.isEmpty()) {
				JOptionPane.showMessageDialog(null,  "Senha não foi informada", "Senha Irregular!", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(adminConfirmPassword.isEmpty()) {
				JOptionPane.showMessageDialog(null,  "Confirmação de Senha não foi informada", "Senha Irregular!", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}while (!(isEqual) && (adminPassword.isEmpty()) || (adminConfirmPassword.isEmpty()) );
		
		
		funcionario.setNome(adminName);
		
		funcionario.setCpf(JOptionPane.showInputDialog(null, "Entre com o CPF"));
		funcionario.setCargo(JOptionPane.showInputDialog(null, "Entre com o Cargo"));
		funcionario.setCel(JOptionPane.showInputDialog(null, "Entre com o Celular"));
		
		endereco.setDescricao(JOptionPane.showInputDialog(null, "Entre com o Endereço"));
		
		funcionario.setEndereco(endereco);
		funcionario.setMatricula(JOptionPane.showInputDialog(null, "Entre com o numero de Matricula"));
		
		usuario.setAtivo(true);
		usuario.setEmail(JOptionPane.showInputDialog(null, "Entre com o Email"));
		usuario.setNivelPermissao('4'); //admin
		usuario.setSenha(adminPassword);
		
		funcionario.setUsuario(usuario);
		
		pessoaFacade.save(funcionario);
		
		
		
		
		//JOptionPane.showMessageDialog(null, adminName, "Login Escolhido: ", JOptionPane.INFORMATION_MESSAGE);
		

	}

}
