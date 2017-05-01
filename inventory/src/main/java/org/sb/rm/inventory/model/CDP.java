package org.sb.rm.inventory.model;

import lombok.Data;

@Data
public class CDP {

  private DevOpsTool ci;
  private DevOpsTool repo;
  private DevOpsTool vcs;

}
