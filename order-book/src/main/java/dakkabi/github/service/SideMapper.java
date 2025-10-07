package dakkabi.github.service;

/**
 * A service class to handle translations between proto package Side enum and domain package
 * Side enum.
 */
public class SideMapper {
  /**
   * Convert the proto Side enum into the domain Side enum.
   *
   * @param protoSide The proto generated Side enum class.
   * @return dakkabi.github.models.Side enum type.
   */
  public static dakkabi.github.models.Side getDomainSide(dakkabi.github.proto.Side protoSide) {
    return dakkabi.github.models.Side.valueOf(protoSide.name());
  }
}
