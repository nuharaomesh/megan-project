DROP DATABASE IF EXISTS Megan_Project;

CREATE DATABASE Megan_Project;

USE Megan_Project;

CREATE TABLE User(
    username VARCHAR(155) NOT NULL,
    user_id VARCHAR(155) PRIMARY KEY,
    password VARCHAR(155) NOT NULL,
    first_name VARCHAR(155),
    last_name VARCHAR(155),
    position VARCHAR(155)
);

INSERT INTO User VALUE ("omesh", "U001", "123", "Omesh", "Nuhara", "Property manager");

CREATE TABLE Employee(
    email VARCHAR(200),
    NIC VARCHAR(155) PRIMARY KEY,
    first_name VARCHAR(155) NOT NULL,
    last_name VARCHAR(155) NOT NULL,
    address VARCHAR(155),
    position VARCHAR(155),
    start_date DATE,
    gender ENUM("Male", "Female"),
    salary DECIMAL(12,0),
    dob DATE,
    emp_detail TEXT
);

INSERT INTO Employee VALUE ("omeshnuhara4@gmail.com", "200234653577", "Omesh", "nuhara", "Horana", "Proerty manager", "2023-11-28", "Male", "80000.00", "2002-11-06", "New Property manager");

CREATE TABLE Salary (
    sal_id VARCHAR(155) PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    payment_date DATE,
    EmNIC VARCHAR(155),
    CONSTRAINT FOREIGN KEY (EmNIC) REFERENCES Employee(NIC) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Tenant (
    tenant_id VARCHAR(155) PRIMARY KEY,
    first_name VARCHAR(155) NOT NULL,
    last_name VARCHAR(155) NOT NULL,
    email VARCHAR(155) UNIQUE,
    tel_no VARCHAR(10)
);

CREATE TABLE Request (
    req_id VARCHAR(155),
    request TEXT,
    tenant_id VARCHAR(155),
    CONSTRAINT FOREIGN KEY (tenant_id) REFERENCES Tenant(tenant_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Payment (
    pay_id VARCHAR(155) PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    payment_date DATE
);


CREATE TABLE Property_owner (
    email VARCHAR(155),
    prpOwner_id VARCHAR(155) PRIMARY KEY,
    first_name VARCHAR(155) NOT NULL,
    last_name VARCHAR(155) NOT NULL,
    tel_no VARCHAR(10)
);

Insert into Property_owner values("omeshnuhara4@gmail.com", "P001", "omesh", "nuhara", "0715138996");

CREATE TABLE Property (
    prop_id VARCHAR(155) PRIMARY KEY,
    property_name VARCHAR(155) NOT NULL,
    address VARCHAR(155),
    property_type VARCHAR(155),
    rent_amount DECIMAL(12,2),
    prpOwner_id VARCHAR(155),
    CONSTRAINT FOREIGN KEY (prpOwner_id) REFERENCES Property_owner(prpOwner_id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into Property values("PO001", "Lakya", "Horana", "House", "1200.00", "P001");

CREATE TABLE Rent (
    rent_id VARCHAR(155) PRIMARY KEY,
    date DATE,
    amount DECIMAL(12,2),
    EmNIC VARCHAR(155),
    pay_id VARCHAR(155),
    tenant_id VARCHAR(155),
    prop_id VARCHAR(155),
    CONSTRAINT FOREIGN KEY(EmNIC) REFERENCES Employee(NIC) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY(pay_id) REFERENCES Payment(pay_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY(tenant_id) REFERENCES Tenant(tenant_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (prop_id) REFERENCES Property(prop_id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Agreement (
    agree_id VARCHAR(155) PRIMARY KEY,
    lease_startDate DATE NOT NULL ,
    lease_endDate DATE NOT NULL ,
    rent_id VARCHAR(155),
    CONSTRAINT FOREIGN KEY(rent_id) REFERENCES Rent(rent_id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Bailiff (
    bail_id VARCHAR(155) PRIMARY KEY,
    first_name VARCHAR(155) NOT NULL,
    last_name VARCHAR(155) NOT NULL,
    office_address VARCHAR(155),
    email VARCHAR(155),
    tel_no VARCHAR(10)
);


CREATE TABLE AgreementBailiff (
    agree_id VARCHAR(155),
    bail_id VARCHAR(155),
    CONSTRAINT FOREIGN KEY (agree_id) REFERENCES Agreement(agree_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (bail_id) REFERENCES Bailiff(bail_id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Service (
    prop_id VARCHAR(155),
    NIC VARCHAR(155),
    service_startDate DATE,
    service_endDate DATE,
    service_desc VARCHAR(155),
    service_type VARCHAR(155),
    CONSTRAINT FOREIGN KEY (prop_id) REFERENCES Property(prop_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (NIC) REFERENCES Employee(NIC) ON DELETE CASCADE ON UPDATE CASCADE
);


# INSERT INTO Employee VALUES("E001", "Omesh", "nuhara", "dfghjk", "sdf");
# INSERT INTO Salary VALUES("34567", 1234567.12, "2023-2-2", "E001");
# INSERT INTO Tenant VALUES("T001", "mesh", "uhara", "Horan", "sdfgjnsbagdch", "d234567890");
# INSERT INTO Payment VALUES("P001", 12312323.12, "2022-1-1");
# INSERT INTO Property_owner VALUES("PO001", "Omes", "nuhaa", "dfghjkfghjk", "2345");
# INSERT INTO Property VALUES("PR001", "labba", "dfssdf3e4sf", "", "", "", "ghjk", 1231232.21, "PO001");
# INSERT INTO Rent VALUES("R001", "2023-12-2", 12313.22, "E001", "P001", "T001", "PR001");
# INSERT INTO Agreement VALUES("A001", "2002-12-2", "2022-1-2", "R001");
# INSERT INTO Bailiff VALUES("B001", "Ome", "nara", "Colo", "omeshnuhara", "345667");
# INSERT INTO AgreementBailiff VALUES("A001", "B001", "sdfghjk,mnbvcdfghj");
# INSERT INTO Service VALUES("P001", "E001", "2002-12-1", "2002-12-2", "hbnjkmjbn", "repair");
