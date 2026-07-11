package co.istad.fary.elearning.features.student;

import co.istad.fary.elearning.features.student.dto.StudentProfileResponse;
import co.istad.fary.elearning.features.student.dto.UpdateStudentProfileRequest;

public interface StudentService {
    StudentProfileResponse me();

    StudentProfileResponse updateProfile(UpdateStudentProfileRequest updateStudentProfileRequest);
}
