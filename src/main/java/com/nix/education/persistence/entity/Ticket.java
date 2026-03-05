package com.nix.education.persistence.entity;

import com.nix.education.persistence.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "tickets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
  @Id
  private String id;
  private String title;
  private String description;
  private String assignee;
  private String reporter;
  @Field(name = "created_date")
  private Date createdDate;
  @Field(name = "last_updated_date")
  private Date lastUpdatedDate;
  private TicketStatus status;
  private List<Comment> comments;
  private List<String> logs;
}
