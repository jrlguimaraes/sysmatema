package br.unesp.sysmatema.facade;

import br.unesp.sysmatema.dao.PessoaDAO;
import br.unesp.sysmatema.model.Pessoa;
import br.unesp.sysmatema.model.Usuario;

public class PessoaFacade {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();

	
	public Pessoa findPessoaByUser(Usuario usuario) {
		pessoaDAO.beginTransaction();
		Pessoa p = this.pessoaDAO.findByEmail(usuario.getEmail());
		this.pessoaDAO.closeTransaction();
		
		return p;
	}
	
	public Pessoa findPessoa(int idPessoa) {
		this.pessoaDAO.beginTransaction();
		Pessoa pessoa = this.pessoaDAO.find(idPessoa);
		this.pessoaDAO.closeTransaction();
		return pessoa;
	}
	
	public void save (Pessoa pessoa){
		PessoaDAO pessoaDAO = new PessoaDAO();	
		pessoaDAO.beginTransaction();
		pessoaDAO.save(pessoa);
		pessoaDAO.commitAndCloseTransaction();
	}

}
