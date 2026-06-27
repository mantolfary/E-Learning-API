package co.istad.fary.elearning;

import co.istad.fary.elearning.features.course.Course;
import co.istad.fary.elearning.features.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class ELearningApplication implements CommandLineRunner {
    private CourseRepository courseRepository;

    @Autowired
    public ELearningApplication(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Course> courses = courseRepository.allCourses();
        Course course = courseRepository.byId(1);
        System.out.println(course.getTitle());
    }

    public static void main(String[] args) {
        SpringApplication.run(ELearningApplication.class, args);
    }

}
