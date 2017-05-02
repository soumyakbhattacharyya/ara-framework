package org.sb.rm.inventory.model;

import org.sb.rm.inventory.exception.ResourceUnreachableException;

public interface Reachable {
  Boolean isReachable() throws ResourceUnreachableException;

}
