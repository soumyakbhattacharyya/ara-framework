package org.sb.rm.inventory.model;

import lombok.Data;

@Data
public class DevOpsTool implements Reachable {

  private final Credential credential;
  private final Endpoint endpoint;
  private final Type type;

  @Data
  public static final class Endpoint {
    private final String url;

  }

  @Data
  public static final class Credential {
    private final String userId;
    private final String password;

  }

  @Override
  public Boolean isReachable() {
    return true;
  }

}
