package org.sb.rm.inventory.model;

public enum CIServer implements Type {

  JENKINS, TEAMCITY;

  @Override
  public boolean connect(String url, int timeOut, boolean isJson, String requestMethod) {
//    URL targetUrl = new URL(url);
//    if (!targetUrl.getProtocol().startsWith("http")) {
//      throw new IllegalArgumentException("Not an http(s) url: " + url);
//    }
//
//    // Verifying if the HTTP_PROXY is available
//    final String httpProxyUrl = System.getenv().get("http_proxy");
//    URL proxyUrl = null;
//    if (httpProxyUrl != null && httpProxyUrl.length() > 0) {
//      proxyUrl = new URL(httpProxyUrl);
//      if (!proxyUrl.getProtocol().startsWith("http")) {
//        throw new IllegalArgumentException("Not an http(s) url: " + httpProxyUrl);
//      }
//    }
//
//    HttpURLConnection connection = null;
//    if (proxyUrl == null) {
//      connection = (HttpURLConnection) targetUrl.openConnection();
//
//    } else {
//      // Proxy connection to the address provided
//      final int proxyPort = proxyUrl.getPort() > 0 ? proxyUrl.getPort() : 80;
//      Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyUrl.getHost(), proxyPort));
//      connection = (HttpURLConnection) targetUrl.openConnection(proxy);
//    }
//
//    connection.setRequestProperty("Content-Type", String.format("application/%s;charset=UTF-8", isJson ? "json" : "xml"));
//    String userInfo = targetUrl.getUserInfo();
//    if (null != userInfo) {
//      String b64UserInfo = DatatypeConverter.printBase64Binary(userInfo.getBytes());
//      String authorizationHeader = "Basic " + b64UserInfo;
//      connection.setRequestProperty("Authorization", authorizationHeader);
//    }
//
//    connection.setDoInput(true);
//    connection.setDoOutput(true);
//    connection.setConnectTimeout(timeOut);
//    connection.setReadTimeout(timeOut);
//
//    connection.setRequestMethod(requestMethod);
//    connection.connect();
//    System.out.println(" connection.connect() has been invoked ");
//    try {
//      OutputStream output = connection.getOutputStream();
//      try {
//        output.write(data);
//        output.flush();
//      } catch (Exception e) {
//        throw new RuntimeException(e);
//      } finally {
//        output.close();
//      }
//    } finally {
//      if (connection.getResponseCode() > 204) {
//        // this signifies API has responded anything but acceptable codes
//        // close connection gracefully
//        int statusCode = connection.getResponseCode();
//        connection.disconnect();
//        throw new IOException("[MyST Studio] Received following response code from server: " + statusCode);
//      }
//      connection.disconnect();
//    }
    return true;
  }

}
