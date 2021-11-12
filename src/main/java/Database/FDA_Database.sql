DROP database if exists `fda_database`;
create database if not exists `FDA_Database`;
use `FDA_Database`;

-- DELETE CASCADE: When we create a foreign key using this option, it deletes the referencing rows in the child table when the referenced row is deleted in the parent table which has a primary key.

-- UPDATE CASCADE: When we create a foreign key using UPDATE CASCADE the referencing rows are updated in the child table when the referenced row is updated in the parent table which has a primary key.

-- The NOT NULL constraint enforces a column to NOT accept NULL values. error out if there is a null

-- if you want to drop a table and reload it, I suggest just dropping the whole schema and reruning the code
create table Ingredients (
	In_id				varchar(20) not null,
    Active_ingredients	varchar(200) DEFAULT NULL,
    Dose				varchar(200) DEFAULT NULL,
    primary key (In_id)
    );

-- -------------------------------------------------------------
create table Drug (
	D_id						varchar(20) not null,
    Lot_Number					varchar(200) DEFAULT NULL,
    Administered_by				varchar(200) DEFAULT NULL,
    Route						varchar(200) DEFAULT NULL,
    Used_According_to_label		varchar(200) DEFAULT NULL,
    Brand_name					varchar(200) DEFAULT NULL,
    Dosage_form					varchar(200) DEFAULT NULL,
    Manufacturer				varchar(200) DEFAULT NULL,
    Atc_vet_code				varchar(200) DEFAULT NULL,
    primary key (D_id));

create table Drug_ingredient (
	D_id						varchar(20) not null,
	In_id						varchar(20) not null,
    primary key (D_id, In_id),
    foreign key (`D_id`) references Drug(`D_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (`In_id`) references Ingredients(`In_id`) ON UPDATE CASCADE ON DELETE CASCADE);

-- -------------------------------------------------------------
create table Exposure (
	D_id						varchar(20) not null,
    First_exposure_date			varchar(20) DEFAULT NULL,
    Last_exposure_date			varchar(20) DEFAULT NULL,
    primary key (D_id),
	foreign key (`D_id`) references Drug(`D_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );

-- -------------------------------------------------------------
create table Owners (
	Ow_id						varchar(20) not null,
    Address						varchar(40) DEFAULT NULL,
    Name						varchar(20) DEFAULT NULL,
    primary key (Ow_id)
    );

-- -------------------------------------------------------------
    create table Animal (
	A_id						varchar(20) not null,
    Species						varchar(20) DEFAULT NULL,
    Gender						varchar(20) DEFAULT NULL,
    Reproductive_status			varchar(20) DEFAULT NULL,
    Physiological_status		varchar(45) DEFAULT NULL,
    Age							varchar(20) DEFAULT NULL,
    Weight						varchar(20) DEFAULT NULL,
    primary key (A_id)
    );

-- -------------------------------------------------------------
create table Vet (
	V_id							varchar(20) not null,
    Name							varchar(20) DEFAULT NULL,
    primary key (V_id)
    );

-- -------------------------------------------------------------
create table Records (
	Rec_id						varchar(20) not null,
    V_id						varchar(20) not null,
    Ow_id						varchar(20) not null,
    primary key (Rec_id),
    foreign key (`V_id`) references Vet(`V_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (`Ow_id`) references Owners(`Ow_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );

create table Animals_in_Records(
Rec_id						varchar(20) not null,
A_id						varchar(20) not null,
primary key(Rec_id, A_id),
foreign key (`A_id`) references Animal(`A_id`) ON UPDATE CASCADE ON DELETE CASCADE,
foreign key (`Rec_id`) references Records(`Rec_id`) ON UPDATE CASCADE ON DELETE CASCADE
);

create table Drugs_in_Records(
Rec_id						varchar(20) not null,
D_id						varchar(20) not null,
primary key(Rec_id, D_id),
foreign key (`D_id`) references Drug(`D_id`) ON UPDATE CASCADE ON DELETE CASCADE,
foreign key (`Rec_id`) references Records(`Rec_id`) ON UPDATE CASCADE ON DELETE CASCADE
);
-- -------------------------------------------------------------
create table Appointment_Outcome (
	Apt_Out_id						varchar(20) not null,
    Medical_status					varchar(200) DEFAULT NULL,
    Number_of_animals_affected		varchar(200) DEFAULT NULL,
    primary key (Apt_out_id)
    );

create table Animal_Outcome (
	Apt_Out_id						varchar(20) not null,
    A_id							varchar(20) not null,
    primary key (Apt_out_id, A_id),
    foreign key (`Apt_Out_id`) references Appointment_Outcome(`Apt_Out_id`) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key (`A_id`) references Animal(`A_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );
-- -------------------------------------------------------------
create table Appointment (
	Apt_id				varchar(20) not null,
    V_id				varchar(20) not null,
    Date				varchar(20) DEFAULT NULL,
    primary key (Apt_id),
	foreign key (`V_id`) references Vet(`V_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );
    
create table Appointment_Animals (
	Apt_id				varchar(20) not null,
    A_id				varchar(20) not null,
    primary key (Apt_id, A_id),
    foreign key (`A_id`) references Animal(`A_id`) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key (`Apt_id`) references Appointment(`Apt_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );
-- -------------------------------------------------------------
create table Login (
	ID					varchar(20) NOT NULL,
    Username			varchar(20) NOT NULL,
    Passwords			varchar(20) NOT NULL,
    primary key (ID)
    );
-- needed to insert random IDs for database to generate

-- -------------------------------------------------------------
create table Organizations (
	Or_id				varchar(20) not null,
    Address				varchar(200) DEFAULT NULL,
    Title				varchar(200) DEFAULT NULL,
    primary key (Or_id)
    );
Insert into Organizations values('0TUS6','','');
-- -------------------------------------------------------------
create table OR_Vet_Login (
	Cred_id				varchar(20) not null,
    Or_id				varchar(20) not null,
    V_id				varchar(20) not null,
    L_id				varchar(20) not null,
    primary key (Cred_id),
	foreign key (`Or_id`) references Organizations(`Or_id`) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key (`V_id`) references Vet(`V_id`) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key (`L_id`) references Login(`ID`) ON UPDATE CASCADE ON DELETE CASCADE
    );
