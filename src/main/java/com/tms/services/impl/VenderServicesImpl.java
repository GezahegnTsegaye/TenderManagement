package com.tms.services.impl;

import com.tms.model.Vender;
import com.tms.repository.VenderRepository;
import com.tms.services.VenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class VenderServicesImpl implements VenderServices {


    private final VenderRepository venderRepository;

    @Autowired
    public VenderServicesImpl(VenderRepository venderRepository) {
        this.venderRepository = venderRepository;
    }


    @Override
    public Vender addVender(Vender vender) {

        venderRepository.save(vender);
        return new Vender();
    }

}
