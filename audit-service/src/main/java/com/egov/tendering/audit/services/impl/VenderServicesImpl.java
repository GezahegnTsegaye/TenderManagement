package com.egov.tendering.audit.services.impl;

import com.egov.tendering.audit.dal.model.Vender;
import com.egov.tendering.audit.dal.repository.VenderRepository;
import com.egov.tendering.audit.services.VenderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VenderServicesImpl implements VenderServices {


    private final VenderRepository venderRepository;



    @Override
    public Vender addVender(Vender vender) {

        venderRepository.save(vender);
        return new Vender();
    }

}
