package com.hospitalcrud.ui;

import com.hospitalcrud.domain.model.MedRecordUI;
import com.hospitalcrud.domain.services.MedRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RestMedicalRecord {
    private final MedRecordService medRecordService;

    public RestMedicalRecord(MedRecordService medRecordService) {
        this.medRecordService = medRecordService;
    }

    //Find patient medRecords

    @GetMapping("/patients/{idPatient}/medRecords")
    public List<MedRecordUI> getAll(@PathVariable int idPatient)  {
        return medRecordService.getAll(idPatient);
    }

    //Add

    @PostMapping("/patients/medRecords")
    public int addMedRecord(@RequestBody MedRecordUI medRecordui) {

        return medRecordService.add(medRecordui);

    }

    //Delete

    @DeleteMapping("/patients/medRecords/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedRecord(@PathVariable int id) {
        medRecordService.delete(id);
    }

    //Update
    @PutMapping("/patients/medRecords")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMedRecord(@RequestBody MedRecordUI medRecordUI) {
        medRecordService.update(medRecordUI);
    }
}
