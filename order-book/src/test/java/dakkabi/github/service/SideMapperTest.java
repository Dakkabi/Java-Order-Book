package dakkabi.github.service;

import dakkabi.github.models.Side;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SideMapperTest {

  @Test
  public void getDomainSideTest() {
    new SideMapper(); // Required for Jacoco coverage.

    assertEquals(Side.class, SideMapper.getDomainSide(dakkabi.github.proto.Side.ASK).getClass());
  }
}
