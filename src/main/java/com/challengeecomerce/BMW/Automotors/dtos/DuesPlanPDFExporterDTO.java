package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.DuesPlan;

import javax.servlet.http.HttpServletResponse;

public class DuesPlanPDFExporterDTO {

    private long id;
    private Car car;
    private DuesPlan duesPlan;

    public DuesPlanPDFExporterDTO() {
    }

    public long getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public DuesPlan getDuesPlan() {
        return duesPlan;
    }


}
