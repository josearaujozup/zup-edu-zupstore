package br.com.zup.edu.zupstore.aplicativo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Aplicativo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
    private String nome;
	
	@Column(nullable = false)
    private String descricao;
	
	@Column(nullable = false)
    private String link;
	
	@OneToOne(mappedBy = "aplicativo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeDownloads quantidadeDownloads;

    @OneToOne(mappedBy = "aplicativo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeLikes quantidadeLikes;
	
	@Version
    private int versao;
	
	/**
     * @deprecated construtor de uso exclusivo
     */
    @Deprecated
	public Aplicativo() {
	}

	public Aplicativo(String nome, String descricao, String link) {
		this.nome = nome;
		this.descricao = descricao;
		this.link = link;
		this.quantidadeLikes = new QuantidadeLikes(this);
		this.quantidadeDownloads = new QuantidadeDownloads(this);
	}
	
	public void aumentarDownloads() {
        this.quantidadeDownloads.incrementa();;
    }

    public void aumentarLikes() {
        this.quantidadeLikes.incrementa();
    }

	public String getLink() {
		return link;
	}
    
}
