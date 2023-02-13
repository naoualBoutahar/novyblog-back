package io.novelis.novyblog.service.Impl;

import io.novelis.novyblog.dao.CommentDao;
import io.novelis.novyblog.domain.Comment;
import io.novelis.novyblog.service.CommentService;
import io.novelis.novyblog.service.dto.CommentDTO;
import io.novelis.novyblog.service.dto.UserDTO;
import io.novelis.novyblog.service.mapper.CommentMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public CommentDTO save(Comment comment) {
        return commentMapper.commentToCommentDto(commentDao.save(comment));
    }

    @Override
    public CommentDTO update(Comment comment) {
        return commentMapper.commentToCommentDto(commentDao.save(comment));
    }

    @Override
    public List<CommentDTO> findAll() {
        return commentDao
                .findAll()
                .stream()
                .map(commentMapper::commentToCommentDto).collect(toList());
    }

    @Override
    public Optional<Comment> findOne(Long id) {
        return commentDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        commentDao.deleteById(id);
    }
}
