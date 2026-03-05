package com.nix.education.persistence.entity;

import com.nix.education.persistence.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private String id;
  @Field(name = "first_name")
  private String firstName;
  @Field(name = "last_name")
  private String lastName;
  private Role role;
}
