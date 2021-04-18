package com.schema.backend.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tblMediaGeral")
public class MediaGeralModel{
		@Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Date data;

    @Column(nullable = true)
    private Float confirmado;

    @Column(nullable = true)
    private Float confirmado100k;

    @Column(nullable = true)
    private Float obito;

    @Column(nullable = true)
    private Float obito100k;



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
     * @return Date return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return Float return the confirmado
     */
    public Float getConfirmado() {
        return confirmado;
    }

    /**
     * @param confirmado the confirmado to set
     */
    public void setConfirmado(Float confirmado) {
        this.confirmado = confirmado;
    }

    /**
     * @return Float return the confirmado100k
     */
    public Float getConfirmado100k() {
        return confirmado100k;
    }

    /**
     * @param confirmado100k the confirmado100k to set
     */
    public void setConfirmado100k(Float confirmado100k) {
        this.confirmado100k = confirmado100k;
    }

    /**
     * @return Float return the obito
     */
    public Float getObito() {
        return obito;
    }

    /**
     * @param obito the obito to set
     */
    public void setObito(Float obito) {
        this.obito = obito;
    }

    /**
     * @return Float return the obito100k
     */
    public Float getObito100k() {
        return obito100k;
    }

    /**
     * @param obito100k the obito100k to set
     */
    public void setObito100k(Float obito100k) {
        this.obito100k = obito100k;
    }

}
