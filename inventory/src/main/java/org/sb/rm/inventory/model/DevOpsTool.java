package org.sb.rm.inventory.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DevOpsTool implements Reachable {

  @Getter
  @Setter
  @Id
  private String id;

  @Getter
  @Setter
  private Credential credential;

  @Getter
  @Setter
  private Endpoint endpoint;

  @Getter
  @Setter
  private String type;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static final class Endpoint {
    private String url;

  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static final class Credential {
    private String userId;
    private String password;

  }

  @Override
  @JsonIgnore
  /**
   * Validates if the configured resource is reachable
   */
  public Boolean isReachable() {

    String endpoint = getEndpoint().getUrl();
    String userId = getCredential().getUserId();
    String pwd = getCredential().getPassword();
    String type = getType();

    // validate reachability
    if (VCS.valueOf(type) == VCS.GIT) {
      // do something
    }

    if (BinaryRepo.valueOf(type) == BinaryRepo.ARTIFACTORY) {
      // do something
    }

    if (CIServer.valueOf(type) == CIServer.JENKINS) {
      // do something
    }

    return true;
  }

}
