package br.com.mathewsalves.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.mathewsalves.dto.CandidateDTO;
import br.com.mathewsalves.entity.Candidate;

public class CandidateMapper {
	public static Candidate dtoToModelMap(CandidateDTO dto) {

		Candidate model = new Candidate();

		BeanUtils.copyProperties(dto, model);
		return model;
	}

	public static CandidateDTO modelToDtoMap(Candidate model) {
		CandidateDTO dto = new CandidateDTO();

		BeanUtils.copyProperties(model, dto);
		return dto;
	}

	public static List<CandidateDTO> modelListToDtoList(List<Candidate> modelList) {
		List<CandidateDTO> dtoList = new ArrayList<>();

		for (Candidate model : modelList) {
			dtoList.add(modelToDtoMap(model));
		}
		return dtoList;
	}
}
