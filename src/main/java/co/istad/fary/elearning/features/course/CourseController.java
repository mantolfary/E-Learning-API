package co.istad.fary.elearning.features.course;

import co.istad.fary.elearning.features.course.dto.CourseResponse;
import co.istad.fary.elearning.features.course.dto.CreateCourseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseResponse createCourse(
            @Valid @RequestBody CreateCourseRequest createCourseRequest
    ) {
        return courseService.createCourse(createCourseRequest);
    }

}
