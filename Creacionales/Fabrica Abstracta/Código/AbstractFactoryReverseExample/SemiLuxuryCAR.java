public class SemiLuxuryCAR implements SemiLuxury {
  private String name;
  public SemiLuxuryCAR(String cName) {
    name = cName;
  }
  public String getSemiLuxuryName() {
    return name;
  }
  public String getSemiLuxuryFeatures() {
    return "Semi luxury CAR-Features ";
  };

} // End of class


