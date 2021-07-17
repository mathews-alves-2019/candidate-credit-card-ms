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
@Table(name = "credit_card_tb")
public class CreditCard {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer candidateId;

    private String apelido;

    private String cardNumber;

    private String validateDate;

    private String cvv;
}
