package org.sb.rm.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolChain {

  private DevOpsTool ci;
  private DevOpsTool repo;
  private DevOpsTool vcs;

}
