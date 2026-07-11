package co.istad.fary.elearning.features.student;


import co.istad.fary.elearning.config.props.KeycloakAdminClientProps;
import co.istad.fary.elearning.features.student.dto.StudentProfileResponse;
import co.istad.fary.elearning.features.student.dto.UpdateStudentProfileRequest;
import co.istad.fary.elearning.security.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService  {

    private final Keycloak keycloak;
    private final KeycloakAdminClientProps props;
    private final StudentProfileMapper studentProfileMapper;
    private final StudentProfileRepository studentProfileRepository;

    @Override
    public StudentProfileResponse updateProfile(UpdateStudentProfileRequest updateStudentProfileRequest) {
        String userId = AuthUtils.extractUserId();

        UserResource userResource = keycloak.realm(props.getTargetRealm())
                .users()
                .get(userId);
        UserRepresentation keycloakUser = userResource.toRepresentation();

        if (updateStudentProfileRequest.firstName() != null) {
            keycloakUser.setFirstName(updateStudentProfileRequest.firstName());
        }
        if (updateStudentProfileRequest.lastName() != null) {
            keycloakUser.setLastName(updateStudentProfileRequest.lastName());
        }

        Map<String, List<String>> attributes = new HashMap<>();
        if (updateStudentProfileRequest.gender() != null) {
            attributes.put("gender", List.of(updateStudentProfileRequest.gender().getGender()));
        }
        if (updateStudentProfileRequest.biography() != null) {
            attributes.put("biography",List.of(updateStudentProfileRequest.biography()));
        }
        keycloakUser.setAttributes(attributes);

        userResource.update(keycloakUser);

        StudentProfile studentProfile = studentProfileRepository.findById(keycloakUser.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student profile has not been found"));

        studentProfileMapper.mapUpdateStudentProfileRequestToStudentProfile(updateStudentProfileRequest, studentProfile);
        studentProfileRepository.save(studentProfile);

        return studentProfileMapper.toStudentProfileResponse(studentProfile, keycloakUser);
    }

    @Override
    public StudentProfileResponse me() {
        String userId = AuthUtils.extractUserId();
        // Retrieve profile from keycloak
        UserRepresentation user = keycloak.realm(props.getTargetRealm())
                .users()
                .get(userId)
                .toRepresentation();
        log.info("User {} logged in", user);

        // Retrieve profile from database table
        StudentProfile studentProfile = studentProfileRepository.findById(user.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student profile has not been found"));
        return studentProfileMapper.toStudentProfileResponse(studentProfile, user);
    }
}
