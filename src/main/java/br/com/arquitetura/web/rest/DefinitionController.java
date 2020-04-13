package br.com.arquitetura.web.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.arquitetura.domain.EnvironmentEnum;
import br.com.arquitetura.service.BrokerService;

@RestController
@RequestMapping("api/v1/definition")
public class DefinitionController {

	@Autowired
	private BrokerService brokerService;

	@PostMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void sendVhostDefinition(@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "form") EnvironmentEnum form) throws IOException {
		brokerService.sendDefinitions(file, form);
	}

}
