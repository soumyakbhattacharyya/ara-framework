package org.sb.rm.inventory.model;

public enum BinaryRepo implements Type{

  ARTIFACTORY, NEXUS;

  @Override
  public boolean connect(String url, int timeOut, boolean isJson, String requestMethod) {
    // TODO Auto-generated method stub
    return false;
  }

}
