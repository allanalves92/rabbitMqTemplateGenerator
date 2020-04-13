package br.com.arquitetura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.arquitetura.domain.Binding;
import br.com.arquitetura.domain.Exchange;
import br.com.arquitetura.domain.Parameter;
import br.com.arquitetura.domain.Permission;
import br.com.arquitetura.domain.Policy;
import br.com.arquitetura.domain.Queue;
import br.com.arquitetura.domain.User;
import br.com.arquitetura.domain.Vhost;

@Service
public class VhostService {

	private final RestTemplate restTemplate;
	private String rabbitBaseUrl;

	public VhostService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.basicAuthentication("guest", "guest").build();
		this.rabbitBaseUrl = "http://localhost:15672";
	}

	public User getUser(String userWithPermission) {

		String url = rabbitBaseUrl + "/api/users/" + userWithPermission;

		ResponseEntity<User> user = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<User>() {
				});

		return user.getBody();

	}

	public List<Permission> getPermissions(String vhostName) {

		String url = rabbitBaseUrl + "/api/vhosts/" + vhostName + "/permissions";

		ResponseEntity<List<Permission>> permissions = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Permission>>() {
				});

		return permissions.getBody();

	}

	public Vhost getInfo(String vhostName) {

		String url = rabbitBaseUrl + "/api/vhosts/" + vhostName;

		ResponseEntity<Vhost> vhost = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<Vhost>() {
				});

		return vhost.getBody();

	}

	public List<Parameter> getParameters(String vhostName) {
		String url = rabbitBaseUrl + "/api/parameters";

		ResponseEntity<List<Parameter>> parameters = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Parameter>>() {
				});

		List<Parameter> filteredParameters = parameters.getBody().stream()
				.filter(parameter -> parameter.getVhost().equals(vhostName)).collect(Collectors.toList());

		return filteredParameters;
	}

	public List<Policy> getPolicies(String vhostName) {
		String url = rabbitBaseUrl + "/api/policies/" + vhostName;

		ResponseEntity<List<Policy>> policies = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Policy>>() {
				});

		return policies.getBody();
	}

	public List<Queue> getQueues(String vhostName) {

		String url = rabbitBaseUrl + "/api/queues/" + vhostName;

		ResponseEntity<List<Queue>> queues = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Queue>>() {
				});

		return queues.getBody();

	}

	public List<Exchange> getExchanges(String vhostName) {

		String url = rabbitBaseUrl + "/api/exchanges/" + vhostName;

		ResponseEntity<List<Exchange>> users = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Exchange>>() {
				});

		return users.getBody();

	}

	public List<Binding> getBindings(String vhostName) {

		String url = rabbitBaseUrl + "/api/bindings/" + vhostName;

		ResponseEntity<List<Binding>> users = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Binding>>() {
				});

		return users.getBody();

	}

}
