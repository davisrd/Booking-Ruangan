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
@Table(name="peminjam")
@Controller("/peminjam")
public class Peminjam {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "IDPEMINJAM", nullable = false)
	private int id;
	
	@NotNull
	@Size(min=9, max=9)
	@Column(name = "NIP", nullable = false)
	private String nip;
	
	@NotNull
	@Size(max=50)
	@Column(name = "NAMAPEMINJAM", nullable = false)
	private String nama;

	public Peminjam(){
		
	}
	
	public Peminjam(String peminjamJSON){
		Gson gson = new Gson();
	    Peminjam peminjam = gson.fromJson(peminjamJSON, Peminjam.class);
	    this.id = peminjam.getId();
	    this.nip = peminjam.getNip();
	    this.nama = peminjam.getNama();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
	
}
