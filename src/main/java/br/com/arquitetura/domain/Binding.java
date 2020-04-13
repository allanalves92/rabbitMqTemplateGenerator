package br.com.arquitetura.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Binding {

	private String source;
	private String vhost;
	private String destination;
	@JsonProperty("destination_type")
	private String destinationType;
	@JsonProperty("routing_key")
	private String routingKey;
	private Map<String, Object> arguments = new HashMap<>();
}
