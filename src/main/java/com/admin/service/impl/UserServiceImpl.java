package com.admin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.admin.exception.BadRequestException;
import com.admin.exception.UnknownResourceException;
import com.admin.model.entity.User;
import com.admin.model.in.UserIn;
import com.admin.model.out.UserOut;
import com.admin.repository.UserRepository;
import com.admin.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserOut login(UserIn in) {
		log.info("--- login --- ", in);
		
		if (in == null)
			throw new BadRequestException("Invalid request.");
		
		User user = userRepository.findByUserAndPassword(in.getUser(), in.getPassword());
		
		if( user == null )
			throw new UnknownResourceException("user or password incorrect .");
		
		
		return UserOut.builder().token(getJWTToken(in)).user(user.getUser()).build();
		
	}
	
	private String getJWTToken(UserIn in) {
		log.info("--- getJWTToken --- ", in);

		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("api.jwt").setSubject(in.getUser())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
