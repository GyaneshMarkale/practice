package LLD.VechicleManagementSystem;

import java.util.List;
import java.util.Map;

public class VehicleServiceImpl implements VehicleService {

    @Override
    public VehicleDto updateVehicleDetails(Long id, VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public List<Map<String, Object>> compareCars(List<Long> ids, List<String> filters) {
        return List.of();
    }

    @Override
    public List<VehicleDto> searchCar(Integer engineCapacity, String gearType, Integer cylinders, Integer seatingCapacity) {
        return List.of();
    }
}
