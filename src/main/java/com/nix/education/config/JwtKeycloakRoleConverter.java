package com.nix.education.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JwtKeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

  private final static String RESOURCE_ACCESS_FIELD = "resource_access";
  private final static String ROLES_FIELD = "roles";

  @Value("${spring.security.oauth2.client.registration.client-id}")
  private String clientId;

  @Override
  public Collection<GrantedAuthority> convert(Jwt jwt) {
    List<String> roles = Optional.ofNullable(jwt.getClaim(RESOURCE_ACCESS_FIELD))
            .filter(resourceAccessField -> resourceAccessField instanceof Map)
            .map(resourceAccessField -> ((Map<String, Object>) resourceAccessField).get(clientId))
            .filter(clientField -> clientField instanceof Map)
            .map(clientField -> ((Map<String, Object>) clientField).get(ROLES_FIELD))
            .filter(rolesField -> rolesField instanceof List)
            .map(rolesField -> (List<String>) rolesField)
            .orElse(List.of());

    return roles.stream()
            .map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
  }
}
