package com.marinin.core_to_boot.dao.dao;

import com.marinin.core_to_boot.models.Role;

import java.util.Set;

public interface RoleDAO {
     Set<Role> getSetOfAllRoles();
     Role getRoleByID(int id);
     Set<Role> getSetOfRolesByName(String[] strArr);
     Set<Role> getSetOfRolesByName(String string);
     Role getRoleByName(String string);
}
