create database if not exists `FDA_Database`;
use `FDA_Database`;

-- DELETE CASCADE: When we create a foreign key using this option, it deletes the referencing rows in the child table when the referenced row is deleted in the parent table which has a primary key.

-- UPDATE CASCADE: When we create a foreign key using UPDATE CASCADE the referencing rows are updated in the child table when the referenced row is updated in the parent table which has a primary key.

-- The NOT NULL constraint enforces a column to NOT accept NULL values. error out if there is a null

-- if you want to drop a table and reload it, I suggest just dropping the whole schema and reruning the code
create table Ingredients (
	In_id				varchar(20) not null,
    Active_ingredients	varchar(20) not null,
    Dose				varchar(20) not null,
    primary key (In_id)
    );
Insert into Ingredients values('P0U17','','');
Insert into Ingredients values('9482E','','');
Insert into Ingredients values('P5WCM','','');
Insert into Ingredients values('ZUGLR','','');
Insert into Ingredients values('67YJ5','','');
-- -------------------------------------------------------------
create table Drug (
	D_id						varchar(20) not null,
    In_id						varchar(20) not null,
    Lot_Number					numeric(20) not null,
    Administered_by				numeric(20) not null,
    Route						varchar(20) not null,
    Used_According_to_label		varchar(20) not null,
    Previous_exposure			varchar(20) not null,
    Brand_name					varchar(20) not null,
    Dosage_form					varchar(20) not null,
    Manufacturer				varchar(20) not null,
    Atc_vet_code				varchar(20) not null,
    primary key (D_id),
    foreign key (`In_id`) references Ingredients(`In_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );
Insert into Drug values('AEU86','P0U17','0','0','','','','','','','');
Insert into Drug values('5B230','9482E','0','0','','','','','','','');
Insert into Drug values('6Y79J','P5WCM','0','0','','','','','','','');
Insert into Drug values('3549E','ZUGLR','0','0','','','','','','','');
Insert into Drug values('029Y6','67YJ5','0','0','','','','','','','');

-- -------------------------------------------------------------
create table Exposure (
	D_id						varchar(20) not null,
    First_exposure_date			Numeric(20) not null,
    Last_exposure_date			Numeric(20) not null,
    primary key (D_id),
	foreign key (`D_id`) references Drug(`D_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );
Insert into Exposure values('AEU86','0','0');
Insert into Exposure values('5B230','0','0');
Insert into Exposure values('6Y79J','0','0');
Insert into Exposure values('3549E','0','0');
Insert into Exposure values('029Y6','0','0');

-- -------------------------------------------------------------
create table Owners (
	Ow_id						varchar(20) not null,
    Address						varchar(40) not null,
    Name						varchar(20) not null,
    primary key (Ow_id)
    );
Insert into Owners values('C1YCW','4300 Glumack Drive','Tom');
Insert into Owners values('U7K66','2200 Norview Ave','Brad');
Insert into Owners values('23I57','5300 S Howell Ave','Alicia');
Insert into Owners values('9GEC6','2400 Yankee Clipper Dr','Liah');
Insert into Owners values('R5KUJ','300 Rodgers Blvd # 12','Alex');

-- -------------------------------------------------------------
    create table Animal (
	A_id						varchar(20) not null,
    Species						varchar(20) not null,
    Gender						varchar(20) not null,
    Reproductive_status			varchar(20) not null,
    Physiological_status		varchar(45) not null,
    Age							numeric(20) not null,
    Weight						varchar(20) not null,
    Breed						varchar(20) not null,
    primary key (A_id)
    );
Insert into Animal values('62G4H','','','','','0','','');
Insert into Animal values('2OEV7','','','','','0','','');
Insert into Animal values('6F96H','','','','','0','','');
Insert into Animal values('988XH','','','','','0','','');
Insert into Animal values('009D9','','','','','0','','');
-- -------------------------------------------------------------
create table Vet (
	V_id							varchar(20) not null,
    Name							varchar(20) not null,
    primary key (V_id)
    );
Insert into Vet values('H1B89','Dr. Chris');
Insert into Vet values('L1TPQ','Dr. Wallace');
Insert into Vet values('5Z3XT','Dr. Macy');
Insert into Vet values('3J2T3','Dr. Liah');
Insert into Vet values('6OPM7','Dr. Danny');

-- -------------------------------------------------------------
create table Records (
	A_id						varchar(20) not null,
    V_id						varchar(20) not null,
    D_id						varchar(20) not null,
    Ow_id						varchar(20) not null,
    primary key (A_id, V_id),
    foreign key (`A_id`) references Animal(`A_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (`V_id`) references Vet(`V_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (`D_id`) references Drug(`D_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (`Ow_id`) references Owners(`Ow_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );
Insert into Records values('62G4H','H1B89','AEU86','C1YCW');
Insert into Records values('2OEV7','L1TPQ','5B230','U7K66');
Insert into Records values('6F96H','5Z3XT','6Y79J','23I57');
Insert into Records values('988XH','3J2T3','3549E','9GEC6');
Insert into Records values('009D9','6OPM7','029Y6','R5KUJ');
-- -------------------------------------------------------------
create table Appointment_Outcome (
	Opt_Out_id						varchar(20) not null,
    A_id							varchar(20) not null,
    Medical_status					varchar(20) not null,
    Number_of_animals_affected		numeric(20) not null,
    primary key (Opt_out_id),
    foreign key (`A_id`) references Animal(`A_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );
Insert into Appointment_Outcome values('45G76','62G4H','','0');
Insert into Appointment_Outcome values('JXIJE','2OEV7','','0');
Insert into Appointment_Outcome values('VH089','6F96H','','0');
Insert into Appointment_Outcome values('JK7PG','988XH','','0');
Insert into Appointment_Outcome values('9FE13','009D9','','0');

-- -------------------------------------------------------------
create table Appointment (
	Apt_id				varchar(20) not null,
    A_id				varchar(20) not null,
    V_id				varchar(20) not null,
    Date				varchar(20) not null,
    primary key (Apt_id),
    foreign key (`A_id`) references Animal(`A_id`) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key (`V_id`) references Vet(`V_id`) ON UPDATE CASCADE ON DELETE CASCADE
    );
Insert into Appointment values('208PB','62G4H','H1B89','');
Insert into Appointment values('067Q7','2OEV7','L1TPQ','');
Insert into Appointment values('F7Q1O','6F96H','5Z3XT','');
Insert into Appointment values('YDXSM','988XH','3J2T3','');
Insert into Appointment values('6L85Q','009D9','6OPM7','');

-- -------------------------------------------------------------
create table Login (
	ID					varchar(20),
    Username			varchar(20),
    Passwords			varchar(20),
    primary key (ID)
    );
-- needed to insert random IDs for database to generate
Insert into Login values('S13PM','','');
Insert into Login values('D188J','','');
Insert into Login values('12K81','','');
Insert into Login values('Q34LU','','');
Insert into Login values('JP4A2','','');
-- -------------------------------------------------------------
create table Organizations (
	Or_id				varchar(20) not null,
    Address				varchar(20) not null,
    Title				varchar(20) not null,
    primary key (Or_id)
    );
Insert into Organizations values('0TUS6','','');
-- -------------------------------------------------------------
create table OR_Vet_Login (
	Cred_id				varchar(20) not null,
    Or_id				varchar(20) not null,
    V_id				varchar(20) not null,
    L_id				varchar(20),
    primary key (Cred_id),
	foreign key (`Or_id`) references Organizations(`Or_id`) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key (`V_id`) references Vet(`V_id`) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key (`L_id`) references Login(`ID`) ON UPDATE CASCADE ON DELETE CASCADE
    );
Insert into OR_Vet_Login values('45DJY','0TUS6','H1B89','S13PM');
Insert into OR_Vet_Login values('KV5H4','0TUS6','L1TPQ','D188J');
Insert into OR_Vet_Login values('961XG','0TUS6','5Z3XT','12K81');
Insert into OR_Vet_Login values('IHFVJ','0TUS6','3J2T3','Q34LU');
Insert into OR_Vet_Login values('3J92W','0TUS6','6OPM7','JP4A2');
