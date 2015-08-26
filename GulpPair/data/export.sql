--------------------------------------------------------
--  File created - Monday-August-24-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table REVIEWS
--------------------------------------------------------

  CREATE TABLE "TESTDB"."REVIEWS" 
   (	"USERID" NUMBER(6,0), 
	"R_ID" NUMBER(6,0), 
	"RATING" BINARY_DOUBLE, 
	"COMMENTS" VARCHAR2(2000 BYTE), 
	"REVIEWDATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "TESTDB"."USERS" 
   (	"USERID" NUMBER(6,0), 
	"USERNAME" VARCHAR2(30 BYTE), 
	"ZIPCODE" VARCHAR2(5 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"password" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RESTAURANTS
--------------------------------------------------------

  CREATE TABLE "TESTDB"."RESTAURANTS" 
   (	"R_ID" NUMBER(6,0), 
	"name" VARCHAR2(30 BYTE), 
	"ADDRESS" VARCHAR2(100 BYTE), 
	"DESCRIPTION" VARCHAR2(1000 BYTE), 
	"AVG_RATING" BINARY_DOUBLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into TESTDB.REVIEWS
SET DEFINE OFF;
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (1,5,'4.8','OMG the food is amazing, and super cheap!Totally recommend this place.',to_date('08-AUG-08','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (3,4,'3.5','The food was pretty decent. It was pretty chilly in teh restaurant, and the staff wasn''t that nice. But overal meh. ',to_date('09-SEP-10','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (1,4,'3.1','This place looked really nice, but we were really dissapointed with the food. But the people were nice. ',to_date('10-OCT-15','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (2,5,'4.9','The food is so incredible. The staff was super friendly, and I now officially love Ethiopian food! ',to_date('17-JUN-15','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (2,3,'3.5','The food was pretty good, not amazing. But overall I guess I would recommend. ',to_date('07-JAN-15','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (3,3,'4.0','Loved the asian food! I''ve been looking for a go to spot, and now I''ve found it. They have a great lunch menu. ',to_date('23-JUL-14','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (4,1,'3.9','I love Olive Garden''s soup and salad!But that''s pretty much all I love about that place. The rest of the food is pretty okay. ',to_date('16-JUN-15','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (2,1,'4.2','Totally my favorite Italian place. I know its not "ITALIAN" but still, very good food, for good prices. Plus I love their take one home thing!',to_date('11-APR-15','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (5,2,'5.0','Amazing bar food!Great place to go grab a drink, and chill out. They have incredible sliders!',to_date('01-JUL-15','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (3,2,'2.0','This place was SO TERRIBLE! If it wasn''t for the staff being super nice, I would have given this place a 2. Food blah, place blah, drinks blah. Don''t go there!',to_date('20-APR-15','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (1,3,'3.6','This palce fits in with all the other Asian food places I''ve been to. Good prices, not extraordinary food though. But worth going every now and then. ',to_date('16-APR-15','DD-MON-RR'));
Insert into TESTDB.REVIEWS (USERID,R_ID,RATING,COMMENTS,REVIEWDATE) values (4,5,'4.6','One of the best ethopian joints I''ve been to. Food and pricing is on point. Could be a little cleaner though. ',to_date('19-DEC-13','DD-MON-RR'));
REM INSERTING into TESTDB.USERS
SET DEFINE OFF;
Insert into TESTDB.USERS (USERID,USERNAME,ZIPCODE,EMAIL,"password") values (1,'Jillian Mitchel','20850','jillian@gmail.com','foodlover45');
Insert into TESTDB.USERS (USERID,USERNAME,ZIPCODE,EMAIL,"password") values (2,'Yang Zen','26843','yangz@yahoo.com','chinaforlife');
Insert into TESTDB.USERS (USERID,USERNAME,ZIPCODE,EMAIL,"password") values (3,'Meenu Raj','01545','meenu@gmail.com','elephants65');
Insert into TESTDB.USERS (USERID,USERNAME,ZIPCODE,EMAIL,"password") values (4,'Chris Bangle','55320','chrisb92@gmail.com','password123');
REM INSERTING into TESTDB.RESTAURANTS
SET DEFINE OFF;
Insert into TESTDB.RESTAURANTS (R_ID,"name",ADDRESS,DESCRIPTION,AVG_RATING) values (1,'Olive Garden','4 Branch Avenue, Rockville Maryland','Casual Italian Dining','3.8');
Insert into TESTDB.RESTAURANTS (R_ID,"name",ADDRESS,DESCRIPTION,AVG_RATING) values (2,'Top of Hill','62 Franklin Street, Gaithersburg Maryland','American bar food','4.0');
Insert into TESTDB.RESTAURANTS (R_ID,"name",ADDRESS,DESCRIPTION,AVG_RATING) values (3,'Asian Cafe','9214 Hillsborough Street, Leesgburgh Virginia','Asian food','3.2');
Insert into TESTDB.RESTAURANTS (R_ID,"name",ADDRESS,DESCRIPTION,AVG_RATING) values (4,'Pho 75','523 Hungerford Drive, Silverspring Maryland','Vietnamese Food','4.5');
Insert into TESTDB.RESTAURANTS (R_ID,"name",ADDRESS,DESCRIPTION,AVG_RATING) values (5,'Zenebech Injera','74 Florida Avenue, Washington D.C.','Ethiopian Food','4.3');
--------------------------------------------------------
--  DDL for Index USER_RESTAURANT
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."USER_RESTAURANT" ON "TESTDB"."REVIEWS" ("USERID", "R_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007427
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."SYS_C007427" ON "TESTDB"."USERS" ("USERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007425
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."SYS_C007425" ON "TESTDB"."RESTAURANTS" ("R_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table REVIEWS
--------------------------------------------------------

  ALTER TABLE "TESTDB"."REVIEWS" ADD CONSTRAINT "USER_RESTAURANT" PRIMARY KEY ("USERID", "R_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "TESTDB"."USERS" ADD PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table RESTAURANTS
--------------------------------------------------------

  ALTER TABLE "TESTDB"."RESTAURANTS" ADD PRIMARY KEY ("R_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  DDL for Trigger USERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTDB"."USERS_TRG" 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.USERID IS NULL THEN
      SELECT USERS_SEQ.NEXTVAL INTO :NEW.USERID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTDB"."USERS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RESTAURANTS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTDB"."RESTAURANTS_TRG" 
BEFORE INSERT ON RESTAURANTS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.R_ID IS NULL THEN
      SELECT RESTAURANTS_SEQ.NEXTVAL INTO :NEW.R_ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "TESTDB"."RESTAURANTS_TRG" ENABLE;
