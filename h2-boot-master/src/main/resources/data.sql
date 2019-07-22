DROP TABLE IF EXISTS student;

CREATE TABLE student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  department VARCHAR(250) DEFAULT NULL
);

INSERT INTO student (first_name, last_name, department) VALUES
('John', 'Castle', 'Computer Science'),
('Jai', 'Vaidh', 'Computer Science'),
('Sarah', 'Nathan', 'Pre-School');

DROP TABLE IF EXISTS states;

CREATE TABLE states (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  state_name VARCHAR(250) NOT NULL,
  tax_max VARCHAR(250) NOT NULL
);
INSERT INTO states (state_name, tax_max) VALUES
('Alabama', '5.00'),
('Alaska', '0.00'),
('Arizona', '4.54'),
('Arkansas', '6.90'),
('California', '13.30'),
('Colorado', '4.63'),
('Connecticut', '6.99'),
('Delaware', '6.60'),
('Florida', '0.00'),
('Georgia', '5.75'),
('Hawaii', '11.00'),
('Idaho', '6.925'),
('Illinois', '4.95'),
('Indianapolis', '3.23'),
('Iowa', '8.53'),
('Kansas', '5.70'),
('Kentucky', '5.00'),
('Louisiana', '6.00'),
('Maine', '7.15'),
('Maddison', '5.75'),
('Massachusetts', '5.05'),
('Michigan', '4.25'),
('Minnesota', '9.85'),
('Mississippi', '5.00'),
('Missouri', '5.40'),
('Montana', '6.90'),
('Nebraska', '6.84'),
('Nevada', '0.00'),
('New Hampshire', '5.00'),
('New Jersy', '10.75'),
('New Mexico', '4.90'),
('New York', '8.82'),
('North Carolina', '5.25'),
('North Dakota', '2.90'),
('Ohio', '4.997');


DROP TABLE IF EXISTS federal_single;

CREATE TABLE federal_single (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  tax_rate VARCHAR(250) NOT NULL,
  min_pay VARCHAR(250) NOT NULL,
  max_pay VARCHAR(250) NOT NULL
);

INSERT INTO federal_single (tax_rate, min_pay, max_pay) VALUES
('10', '0', '1900'),
('12', '9701', '39475'),
('22', '39476', '84200'),
('24', '84201', '160725'),
('32', '160726', '204100'),
('35', '204101', '510300'),
('37', '510301', '1000000');

DROP TABLE IF EXISTS federal_married_together;

CREATE TABLE federal_married_together (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  tax_rate VARCHAR(250) NOT NULL,
  min_pay VARCHAR(250) NOT NULL,
  max_pay VARCHAR(250) NOT NULL
);

INSERT INTO federal_married_together (tax_rate, min_pay, max_pay) VALUES
('10', '0', '19400'),
('12', '19401', '78950'),
('22', '78951', '168400'),
('24', '168401', '321450'),
('32', '321451', '408200'),
('35', '408201', '612350'),
('37', '612351', '1000000');


