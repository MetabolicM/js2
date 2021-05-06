package com.marinin.core_to_boot.service.impl;

import com.marinin.core_to_boot.dao.dao.RoleDAO;
import com.marinin.core_to_boot.models.Role;
import com.marinin.core_to_boot.service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private RoleDAO roleDAO;

    public RoleServiceImp() {}

    @Autowired
    public RoleServiceImp(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public Set<Role> getSetOfAllRoles() {
        return this.roleDAO.getSetOfAllRoles();
    }

    @Override
    public Set<Role> getSetOfRolesByName(String[] strArr) {
        return roleDAO.getSetOfRolesByName(strArr);
    }

    @Override
    public Set<Role> getSetOfRolesByName(String string) {
        return roleDAO.getSetOfRolesByName(string);
    }

    @Override
    public Role getRoleByID(int id){
        return roleDAO.getRoleByID(id);
    }
}
