package br.ravva.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

    private String userId;
    private String map;
    private String coordinateX;
    private String coodinateY;
    private String status;
    private String descriptionMap;
    private String triggerEvent;
}
