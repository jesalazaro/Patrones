public class SUVVehicleFactory extends VehicleFactory {

  public LuxurySUV getLuxury() {
    return new LuxurySUV("Luxury-SUV");
  }
  public NonLuxurySUV getNonLuxury() {
    return new NonLuxurySUV("Non-Luxury-SUV");
  }

  public SemiLuxury getSemiLuxury() { return new SemiLuxurySUV("Semi-Luxury-SUV");}

} // End of class


