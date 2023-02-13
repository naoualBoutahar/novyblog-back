package io.novelis.novyblog.dao;

import io.novelis.novyblog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Long> {
    List<Comment> findByPublishDate (Date publishDate);
}
