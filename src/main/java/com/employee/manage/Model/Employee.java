package com.employee.manage.Model;

import com.employee.manage.utils.Sexe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "\"employee\"")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String firstname;

	@Column(nullable = false, length = 100)
	private String lastname;

	@Temporal(TemporalType.DATE)
	private LocalDate birthdate;

	@Lob
	private String profilePhoto;

	private String matricule;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;

	private Sexe sexe;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "phone")
	private List<Phone> phones = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "industry_id")
	private IndustryConf industry;

	@OneToOne
	@JoinColumn(unique = true)
	private Email emailPerso;

	@OneToOne
	@JoinColumn(unique = true)
	private Email emailPro;

	@OneToOne
	@JoinColumn(nullable = false)
	private Cin cin;

	@Column(nullable = false)
	private String role;

	private Integer nombreEnfants;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private LocalDate dateEmbauche;

	@Temporal(TemporalType.DATE)
	private LocalDate dateDepart;

	private String category;

	@Column(unique = true)
	private String numeroCnaps;
}

