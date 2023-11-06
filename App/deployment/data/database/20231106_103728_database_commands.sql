ALTER TABLE "xpath$example_parentexample" DROP CONSTRAINT "uniq_xpath$example_parentexample_xpath$exampleid";
DROP INDEX "idx_xpath$example_parentexample_xpath$parentexample_xpath$example";
ALTER TABLE "xpath$example_parentexample" RENAME TO "b41a2f5e4003449f8a2c751692879c67";
ALTER TABLE "xpath$parentexample" RENAME TO "dcc9a4f936ce4b529c7929a92c3e9cfb";
DELETE FROM "mendixsystem$association" 
 WHERE "id" = 'da862914-bcea-4050-bbf9-3b3b04530e20';
DELETE FROM "mendixsystem$unique_constraint" 
 WHERE "name" = 'uniq_xpath$example_parentexample_xpath$exampleid' AND "column_id" = '5176ab55-15f5-3896-9c7c-31bf5a0ea691';
DELETE FROM "mendixsystem$entity" 
 WHERE "id" = 'd0fbb6bc-e056-4a5d-ab35-7d957fc2dd3f';
DELETE FROM "mendixsystem$entityidentifier" 
 WHERE "id" = 'd0fbb6bc-e056-4a5d-ab35-7d957fc2dd3f';
DELETE FROM "mendixsystem$sequence" 
 WHERE "attribute_id" IN (SELECT "id"
 FROM "mendixsystem$attribute"
 WHERE "entity_id" = 'd0fbb6bc-e056-4a5d-ab35-7d957fc2dd3f');
DELETE FROM "mendixsystem$remote_primary_key" 
 WHERE "entity_id" = 'd0fbb6bc-e056-4a5d-ab35-7d957fc2dd3f';
DELETE FROM "mendixsystem$attribute" 
 WHERE "entity_id" = 'd0fbb6bc-e056-4a5d-ab35-7d957fc2dd3f';
DROP TABLE "b41a2f5e4003449f8a2c751692879c67";
DROP TABLE "dcc9a4f936ce4b529c7929a92c3e9cfb";
UPDATE "mendixsystem$version"
 SET "versionnumber" = '4.2', 
"lastsyncdate" = '20231106 10:37:28';
