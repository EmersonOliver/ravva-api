package br.ravva.core.dataprovider;

import br.ravva.core.model.StatusEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StatusRepository implements PanacheRepositoryBase<StatusEntity, Long> {
}
