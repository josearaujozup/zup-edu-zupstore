package br.com.zup.edu.zupstore.aplicativo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class QuantidadeLikes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private long quantidade;
	
	@Version
    private int versao;
	
	@OneToOne
	private Aplicativo aplicativo;

	public QuantidadeLikes(Aplicativo aplicativo) {
		this.aplicativo = aplicativo;
		this.quantidade=0;
	}
	
	/**
     * @deprecated
     */
    @Deprecated
	public QuantidadeLikes() {
		
	}
	
	public void incrementa() {
		this.quantidade++;
	}
	
}
