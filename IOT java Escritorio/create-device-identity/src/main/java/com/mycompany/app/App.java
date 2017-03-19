
package com.mycompany.app;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;
import com.microsoft.azure.sdk.iot.service.sdk.Device;
import com.microsoft.azure.sdk.iot.service.sdk.RegistryManager;

import java.io.IOException;
import java.net.URISyntaxException;

public class App{
 private static final String connectionString = "HostName=Aguacaneitor.azure-devices.net;SharedAccessKeyName=iothubowner;SharedAccessKey=Iu66SfUwgyXunyYt5WvKTciKic3A8l8PPJlEX9iDijw=";
 private static final String deviceId = "Movil2";

	public static void main( String[] args ) throws IOException, URISyntaxException, Exception
	{
	   
	    
	         RegistryManager registryManager = RegistryManager.createFromConnectionString(connectionString);

			 Device device = Device.createFromId(deviceId, null, null);
			 try {
			   device = registryManager.addDevice(device);
			 } catch (IotHubException iote) {
			   try {
			     device = registryManager.getDevice(deviceId);
			   } catch (IotHubException iotf) {
			     iotf.printStackTrace();
			   }
			 }
			 System.out.println("Device ID: " + device.getDeviceId());
			 System.out.println("Device key: " + device.getPrimaryKey());
	    
	}
}