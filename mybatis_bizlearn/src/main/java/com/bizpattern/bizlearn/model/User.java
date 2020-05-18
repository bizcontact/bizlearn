package com.bizpattern.bizlearn.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String address;

}
