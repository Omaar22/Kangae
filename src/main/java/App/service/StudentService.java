package App.service;

import org.springframework.beans.factory.annotation.Autowired;
import App.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

}
