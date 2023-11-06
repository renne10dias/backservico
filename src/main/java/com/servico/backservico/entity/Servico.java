package com.servico.backservico.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    @Temporal(TemporalType.DATE)
    private Date dataInicio = new Date();
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    private String descricaoServico;
    private Double valorServico;
    private  Double valorPago;
    @Temporal(TemporalType.DATE)
    private Date dataPagameto;
    private String status; // pendente realizado ou cancelado

    public Servico() {
    }
    public Servico(Long id, String nomeCliente, Date dataInicio, Date dataTermino, String descricaoServico, Double valorServico, Double valorPago, Date dataPagameto, String status) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descricaoServico = descricaoServico;
        this.valorServico = valorServico;
        this.valorPago = valorPago;
        this.dataPagameto = dataPagameto;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagameto() {
        return dataPagameto;
    }

    public void setDataPagameto(Date dataPagameto) {
        this.dataPagameto = dataPagameto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
