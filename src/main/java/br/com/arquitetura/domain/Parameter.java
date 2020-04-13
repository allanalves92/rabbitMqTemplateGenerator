package br.com.arquitetura.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Parameter {

	private Map<String, Object> value = new HashMap<>();
	private String vhost;
	private String component;
	private String name;
}
