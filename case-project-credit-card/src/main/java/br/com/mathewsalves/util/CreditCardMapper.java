package br.com.mathewsalves.util;

import org.springframework.beans.BeanUtils;

import br.com.mathewsalves.dto.CreditCardDTO;
import br.com.mathewsalves.entity.CreditCard;

public class CreditCardMapper {
	public static CreditCard dtoToModelMap(CreditCardDTO dto) {

		CreditCard model = new CreditCard();

		BeanUtils.copyProperties(dto, model);
		return model;
	}

	public static CreditCardDTO modelToDtoMap(CreditCard model) {
		CreditCardDTO dto = new CreditCardDTO();

		BeanUtils.copyProperties(model, dto);
		return dto;
	}
}
