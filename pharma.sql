	

/*CREATE MEDICINE TYPES MASTER DATA*/
CREATE TABLE MEDICINE_TYPE_MASTER(	MEDICINE_TYPE_CODE CHAR(2) PRIMARY KEY,
					MEDICINE_TYPE_NAME VARCHAR2(20));

/*CREATE TABLE MEDICINE_MASTER*/
CREATE TABLE MEDICINE_MASTER(		MEDICINE_CODE VARCHAR2(8) PRIMARY KEY,
					MEDICINE_NAME VARCHAR2(30));


/*Create Batch_info table*/

CREATE TABLE BATCH_INFO(	BATCH_CODE VARCHAR2(8) PRIMARY KEY,
				MEDICINE_CODE VARCHAR2(8),
				WEIGHT number,PRICE NUMBER(7,2),
				MEDICINE_TYPE_CODE CHAR(2),
				SHIPPING_CHARGE NUMBER(7,2),
				CARE_LEVEL VARCHAR2(5),

				FOREIGN KEY(MEDICINE_TYPE_CODE) REFERENCES MEDICINE_TYPE_MASTER(MEDICINE_TYPE_CODE),
				FOREIGN KEY(MEDICINE_CODE) REFERENCES MEDICINE_MASTER(MEDICINE_CODE)); 


/*SHIPPING_MASTER-CREATES THE SHIPPING_MASTER TABLE WHICH CONTAINS THE SHIPPING CHARGES FOR A BATCH OF MEDICINE FOR THE GIVEN TYPE AND WEIGHT*/

CREATE TABLE SHIPPING_MASTER (	MEDICINE_TYPE_CODE CHAR(2),
				WEIGHT_RANGE VARCHAR2(2),
				SHIPPING_CHARGE NUMBER(7,2));



/* Creates the medicine types master data*/


insert into MEDICINE_TYPE_MASTER values('T','Tablets');
insert into MEDICINE_TYPE_MASTER values('C','Capsules');
insert into MEDICINE_TYPE_MASTER values('S','Syrups');

/*Insert master data into SHIPPING_MASTER table*/

insert into SHIPPING_MASTER values('C','W1',500);
insert into SHIPPING_MASTER values('C','W2',1000);
insert into SHIPPING_MASTER values('C','W3',1500);
insert into SHIPPING_MASTER values('C','W4',3000);
insert into SHIPPING_MASTER values('T','W1',200);
insert into SHIPPING_MASTER values('T','W2',500);
insert into SHIPPING_MASTER values('T','W3',1000);
insert into SHIPPING_MASTER values('T','W4',1500);
insert into SHIPPING_MASTER values('S','W1',1000);
insert into SHIPPING_MASTER values('S','W2',1000);
insert into SHIPPING_MASTER values('S','W3',1500);
insert into SHIPPING_MASTER values('S','W4',2000);

/*Insert master data into medicine_master table*/

insert into MEDICINE_MASTER values('MC-300','Panadol');
insert into MEDICINE_MASTER values('MC_301','Fepanil');

insert into MEDICINE_MASTER values('MC-302','Crocin');
insert into MEDICINE_MASTER values('MC_303','Gelusis');

insert into MEDICINE_MASTER values('MC-304','Triprofen');
insert into MEDICINE_MASTER values('MC-305','Corex');

insert into MEDICINE_MASTER values('MC-306','benadryl');
insert into MEDICINE_MASTER values('MC-307','Fepanil');

insert into MEDICINE_MASTER values('MC-308','ABC AntiBio');
insert into MEDICINE_MASTER values('MC-309','Vicks Action 500');

insert into MEDICINE_MASTER values('MC-310','XYZ quick relief');



