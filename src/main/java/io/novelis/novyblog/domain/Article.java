package io.novelis.novyblog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date publishDate;
    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    private Collection<Comment> comments;
    public Article(String title,String content,Date publishDate) {
        this.title=title;
        this.content = content;
        this.publishDate = publishDate;
    }
}
