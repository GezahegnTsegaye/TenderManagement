package com.egov.tendering.audit.services.impl;

import com.egov.tendering.audit.dal.dto.AdministratorDto;
import com.egov.tendering.audit.dal.model.Administrator;
import com.egov.tendering.audit.dal.repository.AdministratorRepository;
import com.egov.tendering.audit.services.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	private final AdministratorRepository administratorRepository;


	@Override
	public List<AdministratorDto> listAdmin() {
		List<Administrator> adminList = administratorRepository.findAll();
		List<AdministratorDto> adminDTOs = new ArrayList<>();
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
