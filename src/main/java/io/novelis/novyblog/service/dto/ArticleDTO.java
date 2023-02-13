package io.novelis.novyblog.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.novelis.novyblog.domain.Comment;
import io.novelis.novyblog.domain.User;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NonNull;

import java.util.Collection;

@Data
public class ArticleDTO {
    private Long articleId;
    private String title;
    private String content;
    @JsonIgnoreProperties(value = {"article","user"})
    private Collection<Comment> comments;
}
