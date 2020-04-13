package br.com.arquitetura.web.rest.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.arquitetura.domain.Binding;
import br.com.arquitetura.domain.Exchange;
import br.com.arquitetura.domain.Parameter;
import br.com.arquitetura.domain.Permission;
import br.com.arquitetura.domain.Policy;
import br.com.arquitetura.domain.Queue;
import br.com.arquitetura.domain.User;
import br.com.arquitetura.domain.Vhost;
import lombok.Data;

@Data
public class RabbitTemplateResponseDTO {

	private List<User> users = new ArrayList<User>();
	private List<Vhost> vhosts = new ArrayList<Vhost>();
	private List<Permission> permissions = new ArrayList<Permission>();
	private List<Parameter> parameters = new ArrayList<Parameter>();
	private List<Policy> policies = new ArrayList<Policy>();
	private List<Queue> queues = new ArrayList<Queue>();
	private List<Exchange> exchanges = new ArrayList<Exchange>();
	private List<Binding> bindings = new ArrayList<Binding>();
}
