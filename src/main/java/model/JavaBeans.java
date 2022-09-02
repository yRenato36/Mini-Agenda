/* FAZ PARTE DO MODEL
 * 
 * Função da classe: Responsável pela segurança dos dados
 */
package model;

public class JavaBeans {
	private String idcon;
	private String nome;
	private String fone;
	private String email;
	
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String idcon, String nome, String fone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	//para obter o conteúdos das variáveis desta classe, utilize os métodos públicos abaixo
	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
