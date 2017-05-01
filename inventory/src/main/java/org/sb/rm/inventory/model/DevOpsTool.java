package org.sb.rm.inventory.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DevOpsTool implements Reachable {

  @Id
  private String id;

  private Credential credential;
  private Endpoint endpoint;
  private Type type;

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
  public Boolean isReachable() {
    return true;
  }

  @JsonDeserialize(using = TypeDeserializer.class)
  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

}
