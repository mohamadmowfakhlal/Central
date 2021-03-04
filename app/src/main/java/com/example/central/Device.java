package com.example.central;

import java.util.UUID;

public class Device {
	private UUID id;

    public String deviceID;
    public String MAC;

    public Device() {
    }

    public Device(String deviceID, String MAC) {
    	id = UUID.randomUUID();
        this.deviceID = deviceID;
        this.MAC = MAC;
    }

    @Override
    public String toString() {
        return "Device [DeviceID=" + deviceID + ", MAC=" + MAC + "]";
    }
}
