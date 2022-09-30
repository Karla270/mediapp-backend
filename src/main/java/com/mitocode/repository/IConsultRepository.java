package com.mitocode.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.*;

//@Repository si es interface no es obligatorio, solo en clases
public interface IConsultRepository extends IGenericRepository<Consult, Integer>{

	 //FR jaime | BD JAIME
    //FR jaime | BD Jaime
    @Query("FROM Consult c WHERE c.patient.dni = :dni OR LOWER(c.patient.firstName) LIKE %:fullname% OR LOWER(c.patient.lastName) LIKE %:fullname%")
    List<Consult> search(@Param("dni") String dni, @Param("fullname") String fullname);

    // >= <
    // 01-08-22 | 07-08-22
    @Query("FROM Consult c WHERE c.consultDate BETWEEN :date1 AND :date2")
    List<Consult> searchByDates(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2);

    @Query(value = "select * from fn_list()", nativeQuery = true)
    List<Object[]> callProcedureOrFunction();

        //[4	"02/07/2022]"
        //[1	"22/07/2022]"
        //[11  "23/07/2022]"
}
