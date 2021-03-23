package com.giphysearch.giphy_search.repositories;

import com.giphysearch.giphy_search.models.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends CrudRepository<Data, String> {
    List<Data> findAll();
}
