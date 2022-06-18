package com.tms.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.dto.AdministratorDto;
import com.tms.model.Administrator;
import com.tms.repository.AdministratorRepository;
import com.tms.services.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	private final AdministratorRepository administratorRepository;

	public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
		this.administratorRepository = administratorRepository;
	}


	@Override
	public List<AdministratorDto> listAdmin() {
		List<Administrator> adminList = administratorRepository.findAll();
		List<AdministratorDto> adminDTOs = new ArrayList<AdministratorDto>();
		AdministratorDto adminDto = new AdministratorDto();
		for (Administrator admin: adminList) {
			adminDto.setAdminId(admin.getId());
			adminDto.setAdminName(admin.getFirstName() +" "+ admin.getLastName());
			adminDTOs.add(adminDto);
		}

		return adminDTOs ;

	}

	@Override
	public List<Administrator> findAll() {

		return administratorRepository.findAll();
	}

	@Override
	public Administrator addAdmin(Administrator administrator) {
		return administratorRepository.save(administrator);
	}

	@Override
	public String deleteAdmin(Long id) {
		administratorRepository.deleteById(id);
		return "{'Message':'Admin Deleted Successfully'}";
	}

}
