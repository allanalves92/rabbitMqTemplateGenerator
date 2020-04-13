package br.com.arquitetura.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Exchange {

	private String name;
	private String type;
	private boolean durable;
	@JsonProperty("auto_delete")
	private boolean autoDelete;
	private String vhost;
	private boolean internal;
	private Map<String, Object> arguments = new HashMap<>();

}
