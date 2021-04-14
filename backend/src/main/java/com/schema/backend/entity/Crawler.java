package com.schema.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "web_crawler_model")
public class Crawler {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private String data;

	@Column(nullable = true)
	private String cidade;

	@Column(nullable = true)
	private String confirmado;

	@Column(nullable = true)
	private String confirmado100k;

	@Column(nullable = true)
	private String obito;

	@Column(nullable = true)
	private String letalitade;

	@Column(nullable = true)
	private String obito100k;


	    // all fields constructor:
	public Crawler(Long id, String data, String cidade, String confirmado,
		String confirmado100k, String obito, String letalidade, String obito100k) {
		this.id = id;
		this.data = data;
		this.cidade = cidade;
		this.confirmado = confirmado;
		this.confirmado100k = confirmado100k;
		this.obito = obito;
		this.letalitade = letalidade;
		this.obito100k = obito100k;
	}

	public Crawler(){};
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return String return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return String return the confirmado
     */
    public String getConfirmado() {
        return confirmado;
    }

    /**
     * @param confirmado the confirmado to set
     */
    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    /**
     * @return String return the confirmado100k
     */
    public String getConfirmado100k() {
        return confirmado100k;
    }

    /**
     * @param confirmado100k the confirmado100k to set
     */
    public void setConfirmado100k(String confirmado100k) {
        this.confirmado100k = confirmado100k;
    }

    /**
     * @return String return the obito
     */
    public String getObito() {
        return obito;
    }

    /**
     * @param obito the obito to set
     */
    public void setObito(String obito) {
        this.obito = obito;
    }

    /**
     * @return String return the letalitade
     */
    public String getLetalitade() {
        return letalitade;
    }

    /**
     * @param letalitade the letalitade to set
     */
    public void setLetalitade(String letalitade) {
        this.letalitade = letalitade;
    }

    /**
     * @return String return the obito100k
     */
    public String getObito100k() {
        return obito100k;
    }

    /**
     * @param obito100k the obito100k to set
     */
    public void setObito100k(String obito100k) {
        this.obito100k = obito100k;
    }

}
