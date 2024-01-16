public class CARVehicleFactory extends VehicleFactory {

  public LuxuryCAR getLuxury() {
    return new LuxuryCAR("Luxury-Car");
  }
  public NonLuxuryCAR getNonLuxury() {
    return new NonLuxuryCAR("NonLuxuryL-Car");
  }
  public SemiLuxury getSemiLuxury() { return new SemiLuxuryCAR("SemiLuxury-Car");}
} // End of class


