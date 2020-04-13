package br.com.arquitetura.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class User {

	private String name;
	@JsonProperty("password_hash")
	private String passwordHash;
	@JsonProperty("hashing_algorithm")
	private String hashingAlgorithm;
	private String tags;

}
