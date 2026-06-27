package co.istad.fary.elearning.features.course;

import co.istad.fary.elearning.features.course.dto.CourseResponse;
import co.istad.fary.elearning.features.course.dto.CreateCourseRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course mapCreateCourseRequestToCourse(CreateCourseRequest createCourseRequest);

    CourseResponse mapCourseToCourseResponse(Course course);

}
