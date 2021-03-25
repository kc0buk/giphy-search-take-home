package com.giphysearch.giphy_search.repositories;

import com.giphysearch.giphy_search.models.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, String> {
    /**
     * Currently unused, but available for future expansion purposes.
     */
}
