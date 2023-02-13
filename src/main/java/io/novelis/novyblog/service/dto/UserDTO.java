package io.novelis.novyblog.service.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.novelis.novyblog.domain.Comment;
import lombok.Data;

import java.util.Collection;

@Data
public class UserDTO {
    private Long id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnoreProperties(value = {"user","article"})
    private Collection<Comment> comments;
}
