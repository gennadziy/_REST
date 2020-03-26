package com.gennadziy.DEMO_REST.service;

import com.gennadziy.DEMO_REST.model.Autoss;

import java.util.List;
import java.util.Optional;


public interface AutosService {
     List<Autoss> all();
     Autoss delete( int id);
     void save(Autoss autoss);
     Optional <Autoss> byId( int id);
     Autoss update( Autoss autoss);
    Autoss createAutoss(Autoss autoss);


}
