package com.api.chamadosjdk.dto;
 
import java.time.LocalDateTime;

public class ChamadoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String solicitante;
    private String status;
    private LocalDateTime dataAbertura;
    
	public ChamadoDTO(Long id, String titulo, String descricao, String solicitante, String status,
			LocalDateTime dataAbertura) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.solicitante = solicitante;
		this.status = status;
		this.dataAbertura = dataAbertura;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
    
	
     
    
    
}
