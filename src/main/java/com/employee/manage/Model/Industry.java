package com.employee.manage.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "\"industry\"")
public class Industry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100)
	private String name;
	@Column(length = 100)
	private String nif;
	@Column(length = 100)
	private String stat;
	@Lob
	private String logo;
	@OneToOne
	private Address address;
	@Enumerated(EnumType.STRING)
	@OneToOne(mappedBy = "industry", cascade = CascadeType.ALL, orphanRemoval = true)
	private Phone phone;
	@OneToOne
	@JoinColumn(unique = true)
	private Email email;
	@Column(unique = true)
	private Integer id_image;
}

