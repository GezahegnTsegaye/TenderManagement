package com.tms.services.impl;

import com.tms.dal.model.Vender;
import com.tms.dal.repository.VenderRepository;
import com.tms.services.VenderServices;
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
