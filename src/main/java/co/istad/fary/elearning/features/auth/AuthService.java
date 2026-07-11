package co.istad.fary.elearning.features.auth;

import co.istad.fary.elearning.features.auth.dto.RegisterRequest;
import co.istad.fary.elearning.features.auth.dto.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest registerRequest);

}
