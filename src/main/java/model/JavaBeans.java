/* FAZ PARTE DO MODEL
 * 
 * Função da classe: A classe JavaBeans busca os dados de agenda.jsp, ela faz esse meio campo para garantir a segurança dos dados,
 * onde o que é puxado de agenda.jsp é transmitido para outras classes.
 */
package model;

public class JavaBeans {
	//definindo atributos privados
    private String idcon;
	private String nome;
	private String fone;
	private String email;
	
	
	public JavaBeans() {
		super();
	}
	
	//método contrutor recebendo argumentos/atributos
	public JavaBeans(String idcon, String nome, String fone, String email) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	//para obter o conteúdos das variáveis desta classe, utilize os métodos públicos abaixo
	public String getIdcon() { //método get retorna o que o valor dos atributos privados
		return idcon;
	}
	public void setIdcon(String idcon) { //método set ele atribui o valor aos atributos privados
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
