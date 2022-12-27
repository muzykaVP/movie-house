package movie.controller;

import java.util.List;
import javax.validation.Valid;
import movie.dto.request.CinemaHallRequestDto;
import movie.dto.response.CinemaHallResponseDto;
import movie.model.CinemaHall;
import movie.service.CinemaHallService;
import movie.service.mapper.RequestDtoMapper;
import movie.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final RequestDtoMapper<CinemaHallRequestDto, CinemaHall> cinemaHallRequestDtoMapper;
    private final ResponseDtoMapper<CinemaHallResponseDto, CinemaHall> cinemaHallResponseDtoMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
            RequestDtoMapper<CinemaHallRequestDto, CinemaHall> cinemaHallRequestDtoMapper,
            ResponseDtoMapper<CinemaHallResponseDto, CinemaHall> cinemaHallResponseDtoMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallRequestDtoMapper = cinemaHallRequestDtoMapper;
        this.cinemaHallResponseDtoMapper = cinemaHallResponseDtoMapper;
    }

    @PostMapping
    public CinemaHallResponseDto add(@RequestBody @Valid CinemaHallRequestDto requestDto) {
        CinemaHall cinemaHall = cinemaHallService.add(
                cinemaHallRequestDtoMapper.mapToModel(requestDto));
        return cinemaHallResponseDtoMapper.mapToDto(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallResponseDtoMapper::mapToDto)
                .toList();
    }
}
