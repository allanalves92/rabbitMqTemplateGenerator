package br.com.arquitetura.service;

import java.io.IOException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import br.com.arquitetura.domain.EnvironmentEnum;

@Service
public class BrokerService {

	private final RestTemplate restTemplate;
	private String rabbitBaseUrl;

	public BrokerService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.basicAuthentication("guest", "guest").build();
		this.rabbitBaseUrl = "http://localhost:15672";
	}

	public void sendDefinitions(MultipartFile file, EnvironmentEnum form) throws IOException {
		String url = rabbitBaseUrl + "/api/definitions/";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", new ByteArrayResource(file.getBytes()));

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

		restTemplate.postForEntity(url, requestEntity, String.class);
	}

}
