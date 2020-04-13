package br.com.arquitetura.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Queue {

	private String name;
	private boolean durable;
	@JsonProperty("auto_delete")
	private boolean autoDelete;
	private String vhost;
	private Map<String, Object> arguments = new HashMap<>();
}
