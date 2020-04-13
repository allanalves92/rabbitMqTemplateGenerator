package br.com.arquitetura.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arquitetura.service.TemplateService;
import br.com.arquitetura.web.rest.dto.RabbitTemplateResponseDTO;

@RestController
@RequestMapping("api/v1/generator")
public class GenerateController {

	@Autowired
	private TemplateService templateService;

	@GetMapping
	public RabbitTemplateResponseDTO generateFullTemplate(String vhostName) {
		return templateService.createFullTemplate(vhostName);
	}

}
