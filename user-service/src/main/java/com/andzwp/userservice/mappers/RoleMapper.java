package com.andzwp.userservice.mappers;

import com.andzwp.userservice.dao.Role;
import com.andzwp.userservice.dto.RoleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;


    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public RoleDTO convertRoleToRoleDTO(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }


    public Role convertRoleDTOToRole(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, Role.class);
    }
}
