package io.novelis.novyblog.service.mapper;

import io.novelis.novyblog.domain.Comment;
import io.novelis.novyblog.service.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface CommentMapper {
    CommentDTO commentToCommentDto(Comment comment);
}
