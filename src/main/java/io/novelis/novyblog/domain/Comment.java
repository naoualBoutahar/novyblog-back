package io.novelis.novyblog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date publishDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Article article;

    public Comment(String content,Date publishDate) {
        this.content = content;
        this.publishDate = publishDate;
    }
}
