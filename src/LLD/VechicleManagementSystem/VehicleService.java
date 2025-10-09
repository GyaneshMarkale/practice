package LLD.VechicleManagementSystem;

import java.util.List;
import java.util.Map;

public interface VehicleService {
    VehicleDto updateVehicleDetails(Long id, VehicleDto vehicleDto);
    List<Map<String, Object>> compareCars(List<Long> ids, List<String> filters);
    List<VehicleDto> searchCar(Integer engineCapacity, String gearType, Integer cylinders, Integer seatingCapacity);
}
