package br.com.mathewsalves.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDTO {

	private Integer candidateId;
	
	private Integer id;

    private String apelido;

    private String cardNumber;

    private String validateDate;

    private String cvv;
    
    private String creditCardBrand;
}
