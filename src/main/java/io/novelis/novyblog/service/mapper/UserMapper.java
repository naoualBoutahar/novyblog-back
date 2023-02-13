package io.novelis.novyblog.service.mapper;

import io.novelis.novyblog.domain.User;
import io.novelis.novyblog.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    UserDTO userToUserDto(User user);
}
