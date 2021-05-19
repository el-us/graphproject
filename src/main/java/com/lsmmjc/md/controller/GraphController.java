package com.lsmmjc.md.controller;

import com.lsmmjc.md.controller.dto.GraphDTO;
import com.lsmmjc.md.controller.dto.GraphRequest;
import com.lsmmjc.md.service.GraphService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller("/graph")
public class GraphController {

    private final GraphService graphService;

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<GraphDTO> getGraph(@Body GraphRequest edgesMatrix){

//        log.info(edgesMatrix.toString());
        return HttpResponse.ok(graphService.createGraphForGivenEdges(edgesMatrix));
    }

}
