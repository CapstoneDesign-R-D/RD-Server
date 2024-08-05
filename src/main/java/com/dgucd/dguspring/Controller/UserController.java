package com.dgucd.dguspring.Controller;


import com.dgucd.dguspring.DTO.ErrorResponseDTO;
import com.dgucd.dguspring.DTO.RegisterRequestDTO;
import com.dgucd.dguspring.DTO.RegisterResponseDTO;
import com.dgucd.dguspring.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name="user-controller", description = "User Controller")
public class UserController {
    private final UserService userService;

    @PostMapping("api/user/register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = RegisterResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Server Error",content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))) })
    @Operation(summary = "회원 등록",description = "회원 등록 api")
    public RegisterResponseDTO register(@RequestBody RegisterRequestDTO req){
        RegisterResponseDTO ret = userService.register(req);
        return ret;

    }


}
