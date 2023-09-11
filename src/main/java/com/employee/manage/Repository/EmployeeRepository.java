package com.employee.manage.Repository;

import com.employee.manage.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getByCnapsNum(String cnapsNum);

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%')",
            nativeQuery = true
    )
    List<Employee> findAllByCriteria(
            String role,
            String lastname,
            String firstname,
            String sexe
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "ORDER BY " +
                    "CASE WHEN :orderBy = 'role' THEN role END, " +
                    "CASE WHEN :orderBy = 'lastname' THEN lastname END, " +
                    "CASE WHEN :orderBy = 'firstname' THEN firstname END, " +
                    "CASE WHEN :orderBy = 'sexe' THEN sexe END " +
                    "ASC",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaWithSortAsc(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String orderBy
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "ORDER BY " +
                    "CASE WHEN :orderBy = 'role' THEN role END, " +
                    "CASE WHEN :orderBy = 'lastname' THEN lastname END, " +
                    "CASE WHEN :orderBy = 'firstname' THEN firstname END, " +
                    "CASE WHEN :orderBy = 'sexe' THEN sexe END " +
                    "DESC",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaWithSortDesc(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String orderBy
    );


    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND start_date >= TO_DATE(:startDate, 'YYYY-MM-DD')",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaAfterStart(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND departure_date <= TO_DATE(:departureDate, 'YYYY-MM-DD')",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaBeforeDeparture(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String departureDate
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND start_date >= TO_DATE(:startDate, 'YYYY-MM-DD') " +
                    "AND departure_date <= TO_DATE(:departureDate, 'YYYY-MM-DD')",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaBetweenStartAndDeparture(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate,
            String departureDate
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND start_date >= TO_DATE(:startDate, 'YYYY-MM-DD') " +
                    "ORDER BY " +
                    "CASE WHEN :orderBy = 'role' THEN role END, " +
                    "CASE WHEN :orderBy = 'lastname' THEN lastname END, " +
                    "CASE WHEN :orderBy = 'firstname' THEN firstname END, " +
                    "CASE WHEN :orderBy = 'sexe' THEN sexe END " +
                    "ASC",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaAfterStartWithSortAsc(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate,
            String orderBy
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND departure_date <= TO_DATE(:departureDate, 'YYYY-MM-DD') " +
                    "ORDER BY " +
                    "CASE WHEN :orderBy = 'role' THEN role END, " +
                    "CASE WHEN :orderBy = 'lastname' THEN lastname END, " +
                    "CASE WHEN :orderBy = 'firstname' THEN firstname END, " +
                    "CASE WHEN :orderBy = 'sexe' THEN sexe END " +
                    "ASC",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaBeforeDepartureWithSortAsc(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String departureDate,
            String orderBy
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND start_date >= TO_DATE(:startDate, 'YYYY-MM-DD') " +
                    "AND departure_date <= TO_DATE(:departureDate, 'YYYY-MM-DD') " +
                    "ORDER BY " +
                    "CASE WHEN :orderBy = 'role' THEN role END, " +
                    "CASE WHEN :orderBy = 'lastname' THEN lastname END, " +
                    "CASE WHEN :orderBy = 'firstname' THEN firstname END, " +
                    "CASE WHEN :orderBy = 'sexe' THEN sexe END " +
                    "ASC",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaBetweenStartAndDepartureWithSortAsc(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate,
            String departureDate,
            String orderBy
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND start_date >= TO_DATE(:startDate, 'YYYY-MM-DD') " +
                    "ORDER BY " +
                    "CASE WHEN :orderBy = 'role' THEN role END, " +
                    "CASE WHEN :orderBy = 'lastname' THEN lastname END, " +
                    "CASE WHEN :orderBy = 'firstname' THEN firstname END, " +
                    "CASE WHEN :orderBy = 'sexe' THEN sexe END " +
                    "DESC",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaAfterStartWithSortDesc(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate,
            String orderBy
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND departure_date <= TO_DATE(:departureDate, 'YYYY-MM-DD') " +
                    "ORDER BY " +
                    "CASE WHEN :orderBy = 'role' THEN role END, " +
                    "CASE WHEN :orderBy = 'lastname' THEN lastname END, " +
                    "CASE WHEN :orderBy = 'firstname' THEN firstname END, " +
                    "CASE WHEN :orderBy = 'sexe' THEN sexe END " +
                    "DESC",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaBeforeDepartureWithSortDesc(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String departureDate,
            String orderBy
    );

    @Query(
            value = "SELECT * FROM employee " +
                    "WHERE UPPER(role) LIKE CONCAT('%', UPPER(:role), '%') " +
                    "AND UPPER(lastname) LIKE CONCAT('%', UPPER(:lastname), '%') " +
                    "AND UPPER(firstname) LIKE CONCAT('%', UPPER(:firstname), '%') " +
                    "AND UPPER(sexe) LIKE CONCAT('%', UPPER(:sexe), '%') " +
                    "AND start_date >= TO_DATE(:startDate, 'YYYY-MM-DD') " +
                    "AND departure_date <= TO_DATE(:departureDate, 'YYYY-MM-DD') " +
                    "ORDER BY " +
                    "CASE WHEN :orderBy = 'role' THEN role END, " +
                    "CASE WHEN :orderBy = 'lastname' THEN lastname END, " +
                    "CASE WHEN :orderBy = 'firstname' THEN firstname END, " +
                    "CASE WHEN :orderBy = 'sexe' THEN sexe END " +
                    "DESC",
            nativeQuery = true
    )
    List<Employee> findAllByCriteriaBetweenStartAndDepartureWithSortDesc(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate,
            String departureDate,
            String orderBy
    );

    default List<Employee> findAllByCriteriaAfterStartWithSort(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate,
            String orderBy,
            String direction
    ) {
        if (direction.equals("ASC")) {
            return findAllByCriteriaAfterStartWithSortAsc(role, lastname, firstname, sexe, startDate, orderBy);
        }
        return findAllByCriteriaAfterStartWithSortDesc(role, lastname, firstname, sexe, startDate, orderBy);
    }

    default List<Employee> findAllByCriteriaBeforeDepartureWithSort(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String departureDate,
            String orderBy,
            String direction
    ) {
        if (direction.equals("ASC")) {
            return findAllByCriteriaBeforeDepartureWithSortAsc(role, lastname, firstname, sexe, departureDate, orderBy);
        }
        return findAllByCriteriaBeforeDepartureWithSortDesc(role, lastname, firstname, sexe, departureDate, orderBy);
    }

    default List<Employee> findAllByCriteriaBetweenStartAndDepartureWithSort(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate,
            String departureDate,
            String orderBy,
            String direction
    ) {
        if (direction.equals("ASC")) {
            return findAllByCriteriaBetweenStartAndDepartureWithSortAsc(role, lastname, firstname, sexe, startDate, departureDate, orderBy);
        }
        return findAllByCriteriaBetweenStartAndDepartureWithSortDesc(role, lastname, firstname, sexe, startDate, departureDate, orderBy);
    }
    Employee findFirstByOrderByIdDesc();

    default List<Employee> findAllByCriteriaWithSort(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String startDate,
            String departureDate,
            String orderBy,
            String direction
    ){
        if (direction.equals("ASC")) {
            return findAllByCriteriaWithSortAsc(role, lastname, firstname, sexe, orderBy);
        }
        return findAllByCriteriaWithSortDesc(role, lastname, firstname, sexe, orderBy);
    };


    default List<Employee> findAllByCriteriaWithSort(
            String role,
            String lastname,
            String firstname,
            String sexe,
            String orderBy,
            String direction
    ) {
        if (direction.equals("ASC")) {
            return findAllByCriteriaWithSortAsc(role, lastname, firstname, sexe, orderBy);
        }
        return findAllByCriteriaWithSortDesc(role, lastname, firstname, sexe, orderBy);
    }

}
