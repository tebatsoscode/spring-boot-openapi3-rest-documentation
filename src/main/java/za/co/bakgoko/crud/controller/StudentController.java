package za.co.bakgoko.crud.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bakgoko.crud.dto.response.CommonResponse;
import za.co.bakgoko.crud.model.Student;
import za.co.bakgoko.crud.service.StudentService;
import za.co.bakgoko.crud.enums.CommonEnum;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping(path = "v1/api/students/")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> post(@RequestBody Student student) {

        try {
            log.info("Started Creating Student {}", new Gson().toJson(student));
            Student studentCreated = service.create(student);
            log.info("Completed Creating Student{}", new Gson().toJson(studentCreated));
            return new ResponseEntity<>(studentCreated, HttpStatus.OK);
        } catch (Exception e) {
            log.error(CommonEnum.ERROR_MESSAGE.getValue(), e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> getAll() {

        try {
            log.info("Started Getting All Students ");
            Iterable<Student> all = service.getAll();
            if (!Objects.isNull(all)) {
                log.info("Completed  All Getting Students");
                return new ResponseEntity<>(all, HttpStatus.OK);
            } else {
                log.info("Completed Getting Student ");
                return new ResponseEntity<>("Student(s) Not found", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error(CommonEnum.ERROR_MESSAGE.getValue(), e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> get(@PathVariable(name = "id") Long id) {

        try {
            log.info("Started Getting Student");
            Student student = service.findById(id);
            log.info("Completed Getting Student");
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            log.error(CommonEnum.ERROR_MESSAGE.getValue(), e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> put(@PathVariable("id") long id,@Valid @RequestBody Student student) {

        try {
            log.info("Started Updating Student {}", new Gson().toJson(student));
            Student studentUpdate = service.updateById(id, student);
            log.info("Completed Updating Student {}", new Gson().toJson(studentUpdate));
            return new ResponseEntity<>(studentUpdate, HttpStatus.OK);
        } catch (Exception e) {
            log.error(CommonEnum.ERROR_MESSAGE.getValue(), e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {

        try {
            log.info("Started Deleting Student");
            service.deleteByID(id);
            CommonResponse commonResponse = buildSuccessResponse(CommonEnum.SUCCESS_DELETE.getValue().concat(String.valueOf(id)));
            log.info("Completed Deleting Student");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            CommonResponse commonResponse = logException(e);
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private CommonResponse buildSuccessResponse(String message) {
        return CommonResponse.builder()
                .success(Boolean.TRUE)
                .message(message)
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .type(CommonEnum.SUCCESS.getValue())
                .build();
    }

    private CommonResponse logException(Exception e) {
        return CommonResponse.builder()
                .success(Boolean.FALSE)
                .message(e.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .type(CommonEnum.EXCEPTION.getValue())
                .build();
    }
}
