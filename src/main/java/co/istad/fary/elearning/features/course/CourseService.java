package co.istad.fary.elearning.features.course;


import co.istad.fary.elearning.features.course.dto.CourseResponse;
import co.istad.fary.elearning.features.course.dto.CreateCourseRequest;

public interface CourseService {

    // Create a new course
    CourseResponse createCourse(CreateCourseRequest createCourseRequest);
}
