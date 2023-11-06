ALTER TABLE "xpath$example" ADD "sorttwo" INT NULL;
UPDATE "xpath$example"
 SET "sorttwo" = 0;
INSERT INTO "mendixsystem$attribute" ("id", 
"entity_id", 
"attribute_name", 
"column_name", 
"type", 
"length", 
"default_value", 
"is_auto_number")
 VALUES ('ce2a92ce-3bca-43a5-90b0-414ff53b09ef', 
'6fbc9cca-1740-4add-b8da-ec45cc8a97cb', 
'SortTwo', 
'sorttwo', 
3, 
0, 
'0', 
false);
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20231106 10:47:50';
