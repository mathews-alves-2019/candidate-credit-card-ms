package br.com.mathewsalves.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.mathewsalves.validator.annotation.CPFExists;
import br.com.mathewsalves.validator.annotation.CPFValidator;
import br.com.mathewsalves.validator.annotation.EmailExists;
import br.com.mathewsalves.validator.annotation.UsernameExists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDTO {

	private Integer id;

    @NotEmpty(message = "Informe o nome.")
    private String name;

    @NotEmpty(message = "Informe o usuário.")
    @UsernameExists
    private String username;

    @NotEmpty(message = "Informe a senha.")
    private String password;

    @NotEmpty(message = "Informe o cpf.")
    @CPFValidator
    @CPFExists
    private String cpf;

    @NotEmpty(message = "Informe o email.")
    @Email
    @EmailExists
    private String email;
}
