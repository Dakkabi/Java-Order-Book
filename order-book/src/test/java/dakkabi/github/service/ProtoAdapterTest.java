package dakkabi.github.service;

import dakkabi.github.models.Side;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProtoAdapterTest {

  @Test
  public void getDomainSideTest() {
    new ProtoAdapter(); // Required for Jacoco coverage.

    assertEquals(Side.class, ProtoAdapter.getDomainSide(dakkabi.github.proto.Side.ASK).getClass());
  }
}
