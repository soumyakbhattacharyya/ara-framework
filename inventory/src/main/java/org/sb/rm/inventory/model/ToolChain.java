package org.sb.rm.inventory.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolChain {
  
  @Id
  private String id;

  private DevOpsTool ci;
  private DevOpsTool repo;
  private DevOpsTool vcs;

}
