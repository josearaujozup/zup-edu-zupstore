package br.com.zup.edu.zupstore.aplicativo;

public class AplicativoRespostaDTO {
	
	private String link;

	public AplicativoRespostaDTO(Aplicativo aplicativo) {
		this.link = aplicativo.getLink();
	}
	
	public AplicativoRespostaDTO() {
		
	}

	public String getLink() {
		return link;
	}
	
}
