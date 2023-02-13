package io.novelis.novyblog.web.rest;

import io.novelis.novyblog.domain.Comment;
import io.novelis.novyblog.exception.CommentNotFoundException;
import io.novelis.novyblog.service.CommentService;
import io.novelis.novyblog.service.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentRessource {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<CommentDTO> getAllComments() {
        return commentService.findAll();
    }

    @PostMapping("/comments")
    CommentDTO createComment(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    // Single item
    @GetMapping("/comments/{id}")
    Comment findComment(@PathVariable Long id) {
        return commentService.findOne(id)
                .orElseThrow(()->new CommentNotFoundException(id));
    }


    @PutMapping("/comments/{id}")
    CommentDTO replaceComment(@RequestBody Comment newComment, @PathVariable Long id) {
        return commentService.findOne(id)
                .map(comment -> {
                    comment.setContent(newComment.getContent());
                    comment.setPublishDate(newComment.getPublishDate());

                    return commentService.save(comment);
                })
                .orElseGet(() -> {
                    newComment.setId(id);
                    return commentService.save(newComment);
                });
    }

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }

}


