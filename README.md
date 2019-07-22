# h2-boot
Spring Boot and H2 DB 

Application will calculate tax for an individual based on the state of employment.
Federal and state income tax are consolidated together based on the state tax percentage and the income tax slab 
based on the total Income / State and Filing status.

Admin user can add new State entry with corresponding tax percentage which will be either saved or updated.
Admin user can view the federal tax slab for filing single / Married Filing Together.
Demo user can only calculate the tax for a given state / income / filing status.


Health End Point: http://localhost:8080/v1.0/employment/actuator/health
H2 Instance: http://localhost:8080/v1.0/employment/h2-console


