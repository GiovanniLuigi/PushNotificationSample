package br.com.batcloud.rest;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relayrides.pushy.apns.ApnsClient;
import com.relayrides.pushy.apns.ClientNotConnectedException;
import com.relayrides.pushy.apns.PushNotificationResponse;
import com.relayrides.pushy.apns.util.SimpleApnsPushNotification;

import br.com.batcloud.dao.DeviceRepo;
import br.com.batcloud.model.Device;
import br.com.batcloud.model.Payload;
import io.netty.util.concurrent.Future;

@RestController
public class NotificationController {

	@Autowired
	private ApnsClient apns;
	
	@Autowired
	private DeviceRepo deviceRepo;
	
	@Value("${bundleId}")
	private String bundleId;
	
	@PostMapping("notification/{deviceId}")
	public ResponseEntity<?> sendNotification(@RequestBody Payload payload,
			@PathVariable("deviceId") Long deviceId) throws Exception{
		
		Device d = deviceRepo.getOne(deviceId);
		
		sendNotification(payload, d.getToken());
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("notificationToAll")
	public ResponseEntity<?> sendToALl(@RequestBody Payload payload) throws Exception{
		List<Device> devices = deviceRepo.findAll();
		for (Device device : devices) {
			sendNotification(payload, device.getToken());	
		}
		return ResponseEntity.ok().build();
	}
	
	//TODO retornar erro caso aconteça
	private void sendNotification(Payload payload, String token) throws Exception {
		SimpleApnsPushNotification pushNotification = 
				new SimpleApnsPushNotification(token, bundleId, payload.payload());
		
		final Future<PushNotificationResponse<SimpleApnsPushNotification>> sendNotificationFuture =
				apns.sendNotification(pushNotification);
	    try {
	        final PushNotificationResponse<SimpleApnsPushNotification> pushNotificationResponse =
	                sendNotificationFuture.get();

	        if (pushNotificationResponse.isAccepted()) {
	            System.out.println("Push notification accepted by APNs gateway.");
	        } else {
	            System.out.println("Notification rejected by the APNs gateway: " +
	                    pushNotificationResponse.getRejectionReason());

	            if (pushNotificationResponse.getTokenInvalidationTimestamp() != null) {
	                System.out.println("\t…and the token is invalid as of " +
	                    pushNotificationResponse.getTokenInvalidationTimestamp());
	            }
	        }
	    } catch (final ExecutionException e) {
	        System.err.println("Failed to send push notification.");
	        e.printStackTrace();

	        if (e.getCause() instanceof ClientNotConnectedException) {
	            System.out.println("Waiting for client to reconnect…");
	            apns.getReconnectionFuture().await();
	            System.out.println("Reconnected.");
	        }
	    }
		
	}
	
}
