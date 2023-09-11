package com.employee.manage.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="\"industry\"")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IndustryConf {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String industryName;
  private String industryDescription;
  private String industrySlogan;
  private String industryEmail;
  private IndustryAddress industryAddress;
  private byte[] industryLogo;
  @OneToMany(mappedBy = "industry", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<IndustryPhone> industryPhone;
  private String NIF;
  private String STAT;
  private String RCS;
}
