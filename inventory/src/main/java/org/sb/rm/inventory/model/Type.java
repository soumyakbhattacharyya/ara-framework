package org.sb.rm.inventory.model;

public interface Type {

  boolean connect(String url, int timeOut, boolean isJson, String requestMethod);

}
