package org.sb.rm.inventory.model;

public enum VCS implements Type {

  SVN, GIT;

  @Override
  public boolean connect(String url, int timeOut, boolean isJson, String requestMethod) {
    return false;
  }

}
