package com.ccssoft.service;

import com.ccssoft.base.result.Results;
import com.ccssoft.model.Role;
import java.util.List;

public interface IRoleService {
    Results<Role> getAllRoles();
}
