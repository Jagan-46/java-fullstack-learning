package com.example.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.slf4j.*;
@Service
public class TeacherService {
    private static Logger logger = LoggerFactory.getLogger(TeacherService.class);
    @Autowired
    TeacherRepository teacherRepository;
    public Teacher getTeacherById(int id){
        logger.info("Getting teacher with id: "+id);
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if(teacher==null){
            logger.info("Teacher Not Found");
            throw new TeacherNotFoundException("Teacher with id " + id + " not found");
        }
        logger.info("Teacher Found: "+teacher.getName());
        return teacher;
    }
}
