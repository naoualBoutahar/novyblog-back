package io.novelis.novyblog.service;

import io.novelis.novyblog.domain.Comment;
import io.novelis.novyblog.service.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    CommentDTO save(Comment Comment);
    CommentDTO update(Comment Comment);
    List<CommentDTO> findAll();
    Optional<Comment> findOne(Long id);
    void delete(Long id);
}
