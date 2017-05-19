package br.com.batcloud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.batcloud.dao.DeviceRepo;
import br.com.batcloud.model.Device;

@RestController
public class DeviceController {
	
	@Autowired
	private DeviceRepo repository;

	@PostMapping("device")
	public ResponseEntity<Void> postDevice (@RequestBody Device d) {
		repository.save(d);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/device")
	public ResponseEntity<Void> updateDevice(@RequestBody Device device){
		repository.save(device);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/device/{id}")
	public ResponseEntity<?> deleteDevice(@PathVariable("id") Long id){
		repository.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/device/{id}")
	public ResponseEntity<Device> getDevice (@PathVariable("id") Long id) {
		Device d = repository.findOne(id);
		if (d != null) return ResponseEntity.ok(d);
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/devices")
	public ResponseEntity<List<Device>> getDevices(){	
		List<Device> d = repository.findAll();
		if (d != null) return ResponseEntity.ok(d);
		return ResponseEntity.notFound().build();	
	}
	
}
