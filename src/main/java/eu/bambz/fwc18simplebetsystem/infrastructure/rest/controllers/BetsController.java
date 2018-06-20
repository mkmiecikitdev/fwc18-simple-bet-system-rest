package eu.bambz.fwc18simplebetsystem.infrastructure.rest.controllers;

import eu.bambz.fwc18simplebetsystem.domain.bets.BetsFacade;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetDto;
import eu.bambz.fwc18simplebetsystem.domain.bets.api.BetForm;
import eu.bambz.fwc18simplebetsystem.domain.bets.query.BetsQueryFacade;
import eu.bambz.fwc18simplebetsystem.infrastructure.rest.ResponseResolver;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
class BetsController {

    private final BetsFacade betsFacade;
    private final BetsQueryFacade betsQueryFacade;
    private final ResponseResolver responseResolver;

    @GetMapping("/bets")
    List<BetDto> bets() {
        return betsQueryFacade.list().toJavaList();
    }

    @PostMapping("/bet/{id}")
    ResponseEntity<Object> bet(@PathVariable long id, @RequestBody @Valid BetForm betForm) {
        return responseResolver.resolve(
                betsFacade.bet(id, betForm)
        );
    }



}
