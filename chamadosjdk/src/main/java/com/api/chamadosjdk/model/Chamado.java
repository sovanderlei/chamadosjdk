package com.api.chamadosjdk.model;
  
import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.api.chamadosjdk.Enums.EnumStatusChamado.StatusChamado;
 

@Entity
@Table(name = "chamados")
public class Chamado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    @Column(nullable = false, length = 1000)
    private String descricao;
    
    @Column(nullable = false)
    private String solicitante;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusChamado status = StatusChamado.ABERTO;
    
    @Column(nullable = false)
    private LocalDateTime dataAbertura = LocalDateTime.now();
    
    private LocalDateTime dataFechamento;
    
    // Construtores
    public Chamado() {}
    
    public Chamado(String titulo, String descricao, String solicitante) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.solicitante = solicitante;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public StatusChamado getStatus() {
		return status;
	}

	public void setStatus(StatusChamado status) {
		this.status = status;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
    


    
    
}


