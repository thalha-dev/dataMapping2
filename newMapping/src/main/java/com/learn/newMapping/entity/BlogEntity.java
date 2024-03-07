package com.learn.newMapping.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blog")
public class BlogEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "blog_id")
  private Long Id;

  @Column(name = "blog_title")
  private String title;

  @Column(name = "blog_content")
  private String content;

  @Column(name = "blog_created_at")
  private Date blogCreatedAt;

  @Column(name = "user_id")
  private Long userId;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "blog_id")
  private List<CommentEntity> comments;
}
