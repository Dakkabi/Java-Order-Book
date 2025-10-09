package dakkabi.github.service;

/**
 * An adapter class that provides services to translate between proto models and domain models,
 * such as Enums.
 */
public class ProtoAdapter {
  /**
   * Convert the proto Side enum into the domain Side enum.
   *
   * @param protoSide The proto generated Side enum class.
   * @return dakkabi.github.models.Side enum type.
   */
  public static dakkabi.github.models.Side getDomainSide(dakkabi.github.proto.Side protoSide) {
    return dakkabi.github.models.Side.valueOf(protoSide.name());
  }

  /**
   * Conver the proto Type enum into the domain Type enum.
   *
   * @param protoType The proto generated Type enum class.
   * @return dakkabi.github.models.Type enum type.
   */
  public static dakkabi.github.models.Type getDomainType(dakkabi.github.proto.Type protoType) {
    return dakkabi.github.models.Type.valueOf(protoType.name());
  }
}
