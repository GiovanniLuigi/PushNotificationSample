package br.com.batcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.batcloud.model.Device;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Long> {

}
