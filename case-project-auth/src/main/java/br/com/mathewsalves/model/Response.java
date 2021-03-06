package br.com.mathewsalves.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {

	private Integer status;
	private LocalDateTime dateTime;
	private Object data;
	private String message;
	private List<String> errors;

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<>();
		}
		return errors;
	}
}