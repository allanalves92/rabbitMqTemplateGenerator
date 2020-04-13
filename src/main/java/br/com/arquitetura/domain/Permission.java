package br.com.arquitetura.domain;

import lombok.Data;

@Data
public class Permission {

	private String user;
	private String vhost;
	private String configure;
	private String write;
	private String read;

}
