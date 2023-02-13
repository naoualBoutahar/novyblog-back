package io.novelis.novyblog.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.novelis.novyblog.domain.Article;
import io.novelis.novyblog.domain.User;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {
    private Long id;
    private String content;
    private Date publishDate;
    @JsonIgnoreProperties(value = {"comments"})
    private User user;
    @JsonIgnoreProperties(value = {"comments"})
    private Article article;
}
