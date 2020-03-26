package com.gennadziy.DEMO_REST.service;

import com.gennadziy.DEMO_REST.Exception;
import com.gennadziy.DEMO_REST.dao.AutoDao;
import com.gennadziy.DEMO_REST.model.Autoss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AutosServImpl implements AutosService {

    @Autowired
    private AutoDao autoDao;
    @Override
    public List<Autoss> all () {
        return autoDao.findAll ();
    }

    @Override
    public Autoss delete ( int id ) {
        autoDao.deleteById ( id );
        return null;
    }

    @Override
    public void save ( Autoss autoss ) {
        autoDao.save ( autoss );
    }

    @Override
    public Optional <Autoss> byId ( int id) {
        return autoDao.findById ( id );
    }

    @Override
    public Autoss update(Autoss autoss) {
        Optional < Autoss> autossDb = this.autoDao.findById(autoss.getId());

        if (autossDb.isPresent()) {
            Autoss productUpdate = autossDb.get();
            productUpdate.setId(autoss.getId());
            productUpdate.setName(autoss.getName());
            autoDao.save(productUpdate);
            return productUpdate;
        } else {
            throw new Exception ("Record not found with id : " + autoss.getId());
        }
    }

    @Override
    public Autoss createAutoss ( Autoss autoss ) {
        return autoDao.save ( autoss );
    }


}
