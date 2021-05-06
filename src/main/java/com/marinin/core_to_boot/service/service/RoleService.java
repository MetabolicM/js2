package com.marinin.core_to_boot.service.service;


import com.marinin.core_to_boot.models.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getSetOfAllRoles();

    Set<Role> getSetOfRolesByName(String[] strArr);

    Set<Role> getSetOfRolesByName(String string);

    Role getRoleByID(int id);
}
