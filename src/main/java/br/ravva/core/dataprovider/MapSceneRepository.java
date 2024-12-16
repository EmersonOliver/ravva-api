package br.ravva.core.dataprovider;

import br.ravva.core.model.MapScene;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MapSceneRepository implements PanacheRepositoryBase<MapScene, Long> {
}
