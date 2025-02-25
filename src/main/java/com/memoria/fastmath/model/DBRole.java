package com.memoria.fastmath.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "dbrole")
public class DBRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String auth;
	
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> results = new ArrayList<>();
		for (String auth : this.auth.split(";")) {
			results.add(new SimpleGrantedAuthority(auth));
		}
		return results;
	}
}
