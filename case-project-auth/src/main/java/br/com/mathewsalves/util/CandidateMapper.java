package br.com.mathewsalves.util;

import org.springframework.beans.BeanUtils;

import br.com.mathewsalves.dto.CandidateDTO;

public class CandidateMapper {
	public static CandidateDTO objectToDTO(Object obj) {

		CandidateDTO model = new CandidateDTO();

		BeanUtils.copyProperties(obj, model);
		return model;
	}

}
