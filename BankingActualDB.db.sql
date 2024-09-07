BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "SavingsAccount" (
	"AccountNumber"	INTEGER,
	"Balance"	REAL,
	"InterestRate"	REAL,
	PRIMARY KEY("AccountNumber")
);
CREATE TABLE IF NOT EXISTS "Customer" (
	"FirstName"	TEXT,
	"LastName"	TEXT,
	"Address"	TEXT,
	"Phone"	TEXT,
	"CustomerID"	INTEGER,
	"AccountNumber"	INTEGER,
	FOREIGN KEY("AccountNumber") REFERENCES "SavingsAccount"("AccountNumber"),
	PRIMARY KEY("CustomerID")
);
INSERT INTO "SavingsAccount" VALUES (1,10321.22,0.1);
INSERT INTO "SavingsAccount" VALUES (2,999.99,0.08);
INSERT INTO "SavingsAccount" VALUES (3,1000000001.22,0.32);
INSERT INTO "SavingsAccount" VALUES (4,420.69,0.09);
INSERT INTO "Customer" VALUES ('Andrew','Larson','123 Easy St Omaha, NE 68108','402-285-3214',123456,1);
INSERT INTO "Customer" VALUES ('Albert','Einstein ','432 Dodge St.','402-911-1234',123457,2);
INSERT INTO "Customer" VALUES ('Conan','Barbarian','8008 Rd Omaha, NE 68132','800-456-1234',123458,3);
INSERT INTO "Customer" VALUES ('Maralyn','Monroe','7532 Cir Omaha, NE 68135','900-258-9321',123459,4);
COMMIT;
