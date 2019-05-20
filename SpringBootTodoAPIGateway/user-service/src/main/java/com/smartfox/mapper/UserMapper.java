package com.smartfox.mapper;

import com.smartfox.dto.UserDTO;
import com.smartfox.model.User;

public class UserMapper {

    public static UserDTO convert(User source) {
        return new UserDTO(source.getUsername(), source.getName(), source.getOtherNames());
    }

}
