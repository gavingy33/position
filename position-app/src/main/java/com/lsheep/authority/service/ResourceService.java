package com.lsheep.authority.service;

import com.lsheep.authority.dto.QueryResource;
import com.lsheep.authority.dto.ResourceDTO;

public interface ResourceService {

	ResourceDTO detail(QueryResource queryResource);

}
