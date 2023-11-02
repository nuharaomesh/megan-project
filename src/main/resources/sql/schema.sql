CREATE TABLE User(
    user_id VARCHAR(155) PRIMARY KEY,
    username VARCHAR(155) NOT NULL,
    password VARCHAR(155) NOT NULL,
    tel_no VARCHAR(10)
);

CREATE TABLE Employee(
    NIC VARCHAR(155) PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    address VARCHAR(155),
    position VARCHAR(155)
);

CREATE TABLE Salary (
    sal_id VARCHAR(155) PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    payment_date DATE,
    EmNIC VARCHAR(155),
    CONSTRAINT FOREIGN KEY (EmNIC) REFERENCES Employee(NIC) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Tenant (
    tenant_id VARCHAR(155) PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    address VARCHAR(155) NOT NULL,
    email VARCHAR(155),
    tel_no VARCHAR(10)
);

CREATE TABLE Payment (
    pay_id VARCHAR(155) PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    payment_date DATE
);

CREATE TABLE Property_owner (
    prpOwner_id VARCHAR(155) PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    email VARCHAR(155),
    tel_no VARCHAR(10)
);

CREATE TABLE Rent (
    rent_id VARCHAR(155) PRIMARY KEY,
    date DATE,
    amount DECIMAL(12,2),
    EmNIC VARCHAR(155),
    pay_id VARCHAR(155),
    tenant_id VARCHAR(155),
    CONSTRAINT FOREIGN KEY(EmNIC) REFERENCES Employee(NIC) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY(pay_id) REFERENCES Payment(pay_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY(tenant_id) REFERENCES Tenant(tenant_id) ON DELETE CASCADE ON UPDATE CASCADE
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
    name VARCHAR(155) NOT NULL,
    office_address VARCHAR(155),
    email VARCHAR(155),
    tel_no VARCHAR(10)
);

CREATE TABLE AgreementBailiff (
    agree_id VARCHAR(155),
    bail_id VARCHAR(155),
    Assignment_reason TEXT,
    CONSTRAINT FOREIGN KEY (agree_id) REFERENCES Agreement(agree_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (bail_id) REFERENCES Bailiff(bail_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Property (
    prop_id VARCHAR(155) PRIMARY KEY,
    property_name VARCHAR(155) NOT NULL,
    address VARCHAR(155),
    image blob,
    image2 blob,
    image3 blob,
    property_type VARCHAR(155),
    rent_amount DECIMAL(12,2),
    prpOwner_id VARCHAR(155),
    rent_id VARCHAR(155),
    CONSTRAINT FOREIGN KEY (prpOwner_id) REFERENCES Property_owner(prpOwner_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (rent_id) REFERENCES Rent(rent_id) ON DELETE CASCADE ON UPDATE CASCADE
);

