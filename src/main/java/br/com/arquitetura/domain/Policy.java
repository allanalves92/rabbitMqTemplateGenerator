package br.com.arquitetura.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Policy {

	private String vhost;
	private String name;
	private String pattern;
	@JsonProperty("apply-to")
	private String applyTo;
	private Map<String, Object> definition = new HashMap<>();
	private long priority;

}
