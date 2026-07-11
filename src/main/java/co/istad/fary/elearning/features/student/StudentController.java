package co.istad.fary.elearning.features.student;

import co.istad.fary.elearning.features.student.dto.StudentProfileResponse;
import co.istad.fary.elearning.features.student.dto.UpdateStudentProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // Get students logged in profile
    @GetMapping("/me")
    public StudentProfileResponse me() {
        return studentService.me();
    }

    @PatchMapping("/{uerId}")
    public StudentProfileResponse updateProfile(@RequestBody UpdateStudentProfileRequest updateStudentProfileRequest){
        return studentService.updateProfile(updateStudentProfileRequest);
    }
}
