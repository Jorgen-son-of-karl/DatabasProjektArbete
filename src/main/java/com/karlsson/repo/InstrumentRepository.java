package com.karlsson.repo;

import com.karlsson.entity.Instrument;


import java.util.List;

public interface InstrumentRepository {
    void save(Instrument member);
    void update(Instrument member);
    void delete(Instrument member);
    Instrument findById(Long id);
    List<Instrument> findAll();

}
