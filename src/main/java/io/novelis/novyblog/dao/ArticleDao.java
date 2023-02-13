package io.novelis.novyblog.dao;

import io.novelis.novyblog.domain.Article;
import io.novelis.novyblog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ArticleDao extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
    List<Comment> findByPublishDate (Date publishDate);

}
