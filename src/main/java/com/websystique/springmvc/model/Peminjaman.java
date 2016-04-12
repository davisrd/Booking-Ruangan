package com.websystique.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Entity
@Table(name="peminjaman")
@Controller("/peminjaman")
public class Peminjaman {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "IDPEMINJAMAN", nullable = false)
	private int id;

	@Autowired
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "NIP")
	private Peminjam peminjam;

	@Autowired
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "IDRUANGAN")
	private Ruangan ruangan;
	
	@NotNull
	@Size(max=30)
	@Column(name = "JURUSAN", nullable = false)
	private String jurusan;
	
	@NotNull
	@Size(max=50)
	@Column(name = "KEGIATAN", nullable = false)
	private String kegiatan;

	@NotNull
	@Size(max=10)
	@Column(name = "TGLPEMINJAMAN", nullable = false)
	private String tgl_pinjam;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJurusan() {
		return jurusan;
	}

	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}

	public String getKegiatan() {
		return kegiatan;
	}

	public void setKegiatan(String kegiatan) {
		this.kegiatan = kegiatan;
	}

	public String getTgl_pinjam() {
		return tgl_pinjam;
	}

	public void setTgl_pinjam(String tgl_pinjam) {
		this.tgl_pinjam = tgl_pinjam;
	}

	public Peminjam getPeminjam() {
		return peminjam;
	}

	public void setPeminjam(Peminjam peminjam) {
		this.peminjam = peminjam;
	}

	public Ruangan getRuangan() {
		return ruangan;
	}

	public void setRuangan(Ruangan ruangan) {
		this.ruangan = ruangan;
	}
}
