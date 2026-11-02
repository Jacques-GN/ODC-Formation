
public final class EmployeeMapper {

    private EmployeeMapper() {
    }


    public static EmployeeResponseDTO toResponseDTO(Employee employee) {
        if (employee == null) {
            return null;
        }

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getMail()
        );
    }

   
    public static Employee toEntity(EmployeeRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setMail(dto.getMail());
        employee.setPassword(dto.getPassword());
        return employee;
    }
}