package LLD.VechicleManagementSystem;

public class VehicleDto {
    private Long id;
    private String model;
    private String manufacturer;
    private Integer engineCapacity;
    private String gearType;
    private Integer cylinders;
    private Integer seatingCapacity;

    public VehicleDto(Long id, String model, String manufacturer, Integer engineCapacity, String gearType, Integer cylinders, Integer seatingCapacity) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.engineCapacity = engineCapacity;
        this.gearType = gearType;
        this.cylinders = cylinders;
        this.seatingCapacity = seatingCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "VehicleDto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", gearType='" + gearType + '\'' +
                ", cylinders=" + cylinders +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }
}
