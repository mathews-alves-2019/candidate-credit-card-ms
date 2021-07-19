package br.com.mathewsalves.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_tb")
public class Candidate {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private String username;

    private String password;

    private String cpf;

    private String email;
}