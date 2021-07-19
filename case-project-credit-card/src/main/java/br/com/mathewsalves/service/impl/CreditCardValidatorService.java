package br.com.mathewsalves.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import br.com.mathewsalves.exception.BusinessException;

@Service
public class CreditCardValidatorService {

	Map<String, String> acceptedCreditCards;

	public CreditCardValidatorService() {
		acceptedCreditCards = new HashMap<String, String>();
		acceptedCreditCards.put("VISA", "^(?<visa>4[0-9]{12}(?:[0-9]{3})?)");
		acceptedCreditCards.put("MASTERCARD", "^(?<mastercard>5[1-5][0-9]{14})");
		acceptedCreditCards.put("AMEX", "^(?<amex>3[47][0-9]{13})");
		acceptedCreditCards.put("DISCOVER", "^(?<discover>6(?:011|5[0-9]{2})[0-9]{12})");
		acceptedCreditCards.put("DINERS_CLUB", "^(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})");
		acceptedCreditCards.put("JCB", "^(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11})");
	}

	public String checkSupported(String cardNumber) {
		String cardNumberValidate = cardNumber.replaceAll("[^0-9]", "");

		for (String key : acceptedCreditCards.keySet()) {
			Pattern pattern = Pattern.compile(acceptedCreditCards.get(key));
			Matcher matcher = pattern.matcher(cardNumberValidate);

			if (matcher.matches()) {
				return key;
			}
		}

		throw new BusinessException("A bandeira do cartão informado não é suportada por este serviço.");
	}

}
