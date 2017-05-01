package org.sb.rm.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.Enums;
import com.google.common.base.Optional;

public class TypeDeserializer extends StdDeserializer<Type> {

  protected TypeDeserializer() {
    super(Type.class);
  }

  @Override
  public Type deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    final String str = p.getText();
    Optional<VCS> vcs = Enums.getIfPresent(VCS.class, p.getText());
    Optional<CIServer> ciServer = Enums.getIfPresent(CIServer.class, p.getText());
    Optional<BinaryRepo> binaryRepo = Enums.getIfPresent(BinaryRepo.class, p.getText());
    if (vcs.isPresent())
      return VCS.valueOf(p.getText());
    if (ciServer.isPresent())
      return CIServer.valueOf(p.getText());
    if (binaryRepo.isPresent())
      return BinaryRepo.valueOf(p.getText());
    throw new AssertionError("unsupported tool");
  }
}