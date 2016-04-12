package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

@Entity
@Table(name="ruangan")
@Controller("/ruangan")
public class Ruangan {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "IDRUANGAN", nullable = false)
	private int id;

	@Size(min=5, max=5)
	@Column(name = "NORUANGAN", nullable = false)
	private String noRuangan;
	
	@NotNull
	@Size(max=20)
	@Column(name = "NAMARUANGAN", nullable = false)
	private String namaRuangan;

	@NotNull
	@Size(max=10)
	@Column(name = "JENISRUANGAN", nullable = false)
	private String jenisRuangan;

	public Ruangan(){
		
	}
	public Ruangan(String ruanganJSON){
		Gson gson = new Gson();
	    Ruangan ruangan = gson.fromJson(ruanganJSON, Ruangan.class);
	    this.id = ruangan.getId();
	    this.noRuangan = ruangan.getNoRuangan();
	    this.namaRuangan = ruangan.getNamaRuangan();
	    this.jenisRuangan = ruangan.getJenisRuangan();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNoRuangan() {
		return noRuangan;
	}
	
	public void setNoRuangan(String noRuangan) {
		this.noRuangan = noRuangan;
	}
	
	public String getNamaRuangan() {
		return namaRuangan;
	}

	public void setNamaRuangan(String namaRuangan) {
		this.namaRuangan = namaRuangan;
	}

	public String getJenisRuangan() {
		return jenisRuangan;
	}

	public void setJenisRuangan(String jenisRuangan) {
		this.jenisRuangan = jenisRuangan;
	}
}
