package com.marinin.core_to_boot.converters;

import com.marinin.core_to_boot.models.Role;
import com.marinin.core_to_boot.service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class StringArrayToRoleSetConverter implements Converter<String[], Set<Role>> {

    @Autowired
    private RoleService roleService;

    public StringArrayToRoleSetConverter() {
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Set<Role> convert(String[] inputArr) {
        return roleService.getSetOfRolesByName(inputArr);
    }
}
