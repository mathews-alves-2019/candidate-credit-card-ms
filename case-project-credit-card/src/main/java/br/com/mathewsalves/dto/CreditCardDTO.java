package br.com.mathewsalves.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.mathewsalves.validator.annotation.CreditCardValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDTO {

	@NotNull(message = "Não foi possível recuperar o usuário.")
	private Integer candidateId;
	
	private Integer id;

    private String apelido;

    @NotEmpty(message = "Informe o número do cartão.")
    @CreditCardValidator
    private String cardNumber;

    @NotEmpty(message = "Informe a data de validade.")
    private String validateDate;

    @NotEmpty(message = "Informe o cvv.")
    private String cvv;
    
    private String creditCardBrand;
}
