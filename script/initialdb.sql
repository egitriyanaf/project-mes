-- SEQUENCE
CREATE SEQUENCE "seq_user"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;
 
CREATE SEQUENCE "seq_component"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;
 
CREATE SEQUENCE "seq_userole"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;
 
CREATE SEQUENCE "seq_menu"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
CREATE SEQUENCE "seq_params"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
CREATE SEQUENCE "seq_role"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;  

CREATE SEQUENCE "seq_roledtl"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;  

CREATE SEQUENCE "seq_user"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;   
 

-- ----------------------------
-- Table structure for cms_uam_component
-- ----------------------------
CREATE TABLE "jdcuam_mstcomponent" (
"menu_comp_id" int4 NOT NULL,
"menu_id" int4,
"menu_comp_name" varchar(20) COLLATE "default",
"menu_comp_desc" varchar(255) COLLATE "default",
"menu_comp_icon" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcuam_mstcomponent" ADD PRIMARY KEY ("menu_comp_id");

-- ----------------------------
-- Table structure for jdcuam_userole
-- ----------------------------
CREATE TABLE "jdcuam_mstuserole" (
"userrole_id" int8 NOT NULL,
"user_id" int8 NOT NULL,
"role_id" int8 NOT NULL,
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8,
"usr_id" int8
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcuam_mstuserole" ADD PRIMARY KEY ("userrole_id");

-- ----------------------------
-- Table structure for jdcuam_menu
-- ----------------------------
CREATE TABLE "jdcuam_mstmenu" (
"menu_id" int4 NOT NULL,
"menu_name" varchar(50) COLLATE "default",
"menu_desc" varchar(50) COLLATE "default",
"menu_url" varchar(255) COLLATE "default",
"menu_icon" varchar(50) COLLATE "default",
"menu_parent_id" int4,
"menu_enabled" int4,
"menu_seq_no" int4,
"menu_parent_name" char(225) COLLATE "default"
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcuam_mstmenu" ADD PRIMARY KEY ("menu_id");

-- ----------------------------
-- Table structure for jdcadp_mstparams
-- ----------------------------
CREATE TABLE "jdcadp_mstparams" (
"param_id" int8 NOT NULL,
"param_name" varchar(50) COLLATE "default",
"param_value" varchar(50) COLLATE "default",
"param_desc" varchar(255) COLLATE "default",
"app_type" varchar(10) COLLATE "default",
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6)
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcadp_mstparams" ADD PRIMARY KEY ("param_id");

-- ----------------------------
-- Table structure for jdcuam_role
-- ----------------------------
CREATE TABLE "jdcuam_mstrole" (
"role_id" int8 NOT NULL,
"role_name" varchar(120) COLLATE "default",
"role_desc" varchar(255) COLLATE "default",
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcuam_mstrole" ADD PRIMARY KEY ("role_id");

----------
-- Table structure for jdcuam_role_dtl
-- ----------------------------
CREATE TABLE "jdcuam_mstroledtl" (
"role_dtl_id" int8 NOT NULL,
"role_id" int8 NOT NULL,
"menu_comp_id" int4,
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcuam_mstroledtl" ADD PRIMARY KEY ("role_dtl_id");

-- ----------------------------
-- Table structure for jdcuam_user
-- ----------------------------
CREATE TABLE "jdcuam_mstuser" (
"usr_id" int8 NOT NULL,
"usr_loginname" varchar(30) COLLATE "default",
"usr_password" varchar(32) COLLATE "default",
"usr_lastname" varchar(50) COLLATE "default",
"usr_firstname" varchar(50) COLLATE "default",
"usr_email" varchar(200) COLLATE "default",
"usr_phone" varchar(30) COLLATE "default",
"creation_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8,
"usr_type" varchar(50) COLLATE "default",
"enabled" varchar COLLATE "default",
"departement_id" int8
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcuam_mstuser" ADD PRIMARY KEY ("usr_id");

CREATE TABLE "jdcfnd_mstlookup" (
"lookup_id" int8 NOT NULL,
"lookup_type" varchar(50) COLLATE "default",
"lookup_value" varchar(50) COLLATE "default",
"lookup_description" varchar(100) COLLATE "default",
"display_flag" char(1) COLLATE "default" DEFAULT 'Y'::bpchar,
"creation_date" date,
"created_by" int8,
"last_updated_date" date,
"last_updated_by" int8
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcfnd_mstlookup" ADD PRIMARY KEY ("lookup_id");

CREATE TABLE "jdcfnd_mstparams" (
"param_id" int8 NOT NULL,
"param_name" varchar(50) COLLATE "default",
"param_value" varchar(50) COLLATE "default",
"param_desc" varchar(255) COLLATE "default",
"app_type" varchar(10) COLLATE "default",
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6)
)
WITH (OIDS=FALSE)
;
ALTER TABLE "jdcfnd_mstparams" ADD PRIMARY KEY ("param_id");


