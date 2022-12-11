package com.api.parkingcontrol.services;

import com.api.parkingcontrol.common.dto.SpotDto;
import com.api.parkingcontrol.models.SpotModel;

public interface SpotService {
    public SpotModel create(SpotDto data);
}
