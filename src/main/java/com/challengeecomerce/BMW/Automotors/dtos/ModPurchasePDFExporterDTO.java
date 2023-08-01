package com.challengeecomerce.BMW.Automotors.dtos;

import java.time.LocalDateTime;

public class ModPurchasePDFExporterDTO {



        private long id;
        private LocalDateTime localDateTimeStart;
        private LocalDateTime localDateTimeEnd;

    public ModPurchasePDFExporterDTO() {
    }

    public long getId() {
            return id;
        }

        public LocalDateTime getLocalDateTimeStart() {
            return localDateTimeStart;
        }

        public LocalDateTime getLocalDateTimeEnd() {
            return localDateTimeEnd;
        }


    }

