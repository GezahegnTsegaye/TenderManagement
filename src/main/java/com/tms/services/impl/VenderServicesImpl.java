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
    public Vender getVender(Vender vender) {

        venderRepository.save(vender);
        return new Vender();
    }


    @Override
    public Vender getVenders(String email) {
        if (StringUtils.isEmpty(email)) {
            System.out.println("in this case the machine will not accept empty");
        }

        return venderRepository.findByVenderEmail(email);
    }


}
