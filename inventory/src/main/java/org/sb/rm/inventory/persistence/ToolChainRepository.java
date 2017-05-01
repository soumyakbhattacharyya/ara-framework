package org.sb.rm.inventory.persistence;

import org.sb.rm.inventory.model.ToolChain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ToolChainRepository extends MongoRepository<ToolChain, String> {

}