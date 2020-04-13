package br.com.arquitetura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arquitetura.domain.Permission;
import br.com.arquitetura.web.rest.dto.RabbitTemplateResponseDTO;

@Service
public class TemplateService {

	@Autowired
	private VhostService vhostService;

	public RabbitTemplateResponseDTO createFullTemplate(String vhostName) {
		RabbitTemplateResponseDTO response = new RabbitTemplateResponseDTO();
		List<Permission> permissions = vhostService.getPermissions(vhostName);
		response.setPermissions(permissions);
		permissions.stream().forEach(permission -> response.getUsers().add(vhostService.getUser(permission.getUser())));
		response.getVhosts().add(vhostService.getInfo(vhostName));
		response.setParameters(vhostService.getParameters(vhostName));
		response.setPolicies(vhostService.getPolicies(vhostName));
		response.setQueues(vhostService.getQueues(vhostName));
		response.setExchanges(vhostService.getExchanges(vhostName));
		response.setBindings(vhostService.getBindings(vhostName));

		return response;
	}

}
