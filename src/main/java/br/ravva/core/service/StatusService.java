package br.ravva.core.service;

import br.ravva.core.dataprovider.CoordinatorsRepository;
import br.ravva.core.dataprovider.MapSceneRepository;
import br.ravva.core.dataprovider.StatusRepository;
import br.ravva.core.model.CoordinatesMap;
import br.ravva.core.model.MapScene;
import br.ravva.core.model.StatusEntity;
import br.ravva.resources.dto.RequestDTO;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@ApplicationScoped
public class StatusService {

    @Inject
    CoordinatorsRepository coordinatorsRepository;

    @Inject
    MapSceneRepository mapSceneRepository;


    @Inject
    StatusRepository statusRepository;


    @Transactional
    public void salvar(RequestDTO request) {
        var mapScene = MapScene.builder()
                .description(request.getDescriptionMap())
                .triggerEvent(request.getTriggerEvent()).build();
        mapSceneRepository.persistAndFlush(mapScene);

        var coordinates = CoordinatesMap.builder()
                .x(request.getCoordinateX())
                .y(request.getCoordinateX())
                .status(request.getStatus())
                .idScene(mapScene.getIdScene())
                .build();
        coordinatorsRepository.persistAndFlush(coordinates);

        var status = StatusEntity.builder()
                .idScene(mapScene.getIdScene())
                .userId(request.getUserId())
                .timestamp(new Date())
                .build();
        statusRepository.persistAndFlush(status);
    }

    public List<StatusEntity> carregarCheckpoint(String userId) {
        return  statusRepository.find("userId=:userId order by timestamp desc", Parameters.with("userId", userId))
                .list();
    }

    public StatusEntity carregarCheckpointAtual(String userId) {
        return statusRepository.find("userId=:userId order by timestamp desc limit 1", Parameters.with("userId", userId))
                .singleResult();
    }

}
