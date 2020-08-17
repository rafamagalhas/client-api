package com.rafamagalhas.clientApi.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandartError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String message;
	private long timestamp;
}
