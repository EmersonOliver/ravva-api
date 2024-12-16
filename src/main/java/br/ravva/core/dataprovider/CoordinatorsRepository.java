package br.ravva.core.dataprovider;

import br.ravva.core.model.CoordinatesMap;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CoordinatorsRepository implements PanacheRepositoryBase<CoordinatesMap, Long> {
}
