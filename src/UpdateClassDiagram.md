
# Repository Layer Class Diagram

```plaintext
                         +------------------------+
                         |  Repository<T, ID>      |  (interface)
                         +------------------------+
                         | + save(T entity)        |
                         | + findById(ID id)        |
                         | + findAll()              |
                         | + delete(ID id)          |
                         +------------------------+
                                  ▲
                                  |
        ---------------------------------------------------
        |                        |                        |
+--------------------+ +----------------------+ +------------------------+
| StudentRepository   | | CounselorRepository   | | AppointmentRepository   | ...
| (interface)         | | (interface)            | | (interface)              |
| + findByMajor()     | | + findBySpecialization()| | + findByDateRange()      |
| + findByAcademicYear() |                        | + findByStatus()          |
+--------------------+ +----------------------+ +------------------------+
                                  ▲
                                  |
        ---------------------------------------------------
        |                        |                        |
+------------------------------+ +------------------------------+ +-------------------------------+
| InMemoryStudentRepository    | | InMemoryCounselorRepository  | | InMemoryAppointmentRepository |
| (class)                      | | (class)                      | | (class)                       |
| implements StudentRepository | | implements CounselorRepository | implements AppointmentRepository |
+------------------------------+ +------------------------------+ +-------------------------------+

                         +--------------------------+
                         | RepositoryFactory         |  (class)
                         +--------------------------+
                         | + getStudentRepository()  |
                         | + getCounselorRepository()|
                         | + getAppointmentRepository() |
                         | + getRepository(String storageType, Class<T>) |
                         +--------------------------+
