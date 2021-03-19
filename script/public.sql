/*
Navicat PGSQL Data Transfer

Source Server         : POSTGRE
Source Server Version : 90309
Source Host           : localhost:5432
Source Database       : jdcadp
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90309
File Encoding         : 65001

Date: 2019-04-16 16:51:51
*/

-- ----------------------------
-- Sequence structure for seq_component
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_component";
CREATE SEQUENCE "public"."seq_component"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 33
 CACHE 1;
SELECT setval('"public"."seq_component"', 33, true);

-- ----------------------------
-- Sequence structure for seq_menu
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_menu";
CREATE SEQUENCE "public"."seq_menu"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 23
 CACHE 1;
SELECT setval('"public"."seq_menu"', 23, true);

-- ----------------------------
-- Sequence structure for seq_params
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_params";
CREATE SEQUENCE "public"."seq_params"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for seq_role
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_role";
CREATE SEQUENCE "public"."seq_role"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for seq_roledtl
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_roledtl";
CREATE SEQUENCE "public"."seq_roledtl"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for seq_user
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_user";
CREATE SEQUENCE "public"."seq_user"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for seq_userole
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_userole";
CREATE SEQUENCE "public"."seq_userole"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;
 
 
 -- ----------------------------
-- Sequence structure for seq_barcode
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_barcode";
CREATE SEQUENCE "public"."seq_barcode"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1;
 
 -- ----------------------------
-- Sequence structure for seq_images
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_images";
CREATE SEQUENCE "public"."seq_images"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
  -- ----------------------------
-- Sequence structure for seq_spk
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_spk";
CREATE SEQUENCE "public"."seq_spk"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
-- ----------------------------
-- Sequence structure for seq_qctrl
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_qctrl";
CREATE SEQUENCE "public"."seq_qctrl"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
-- ----------------------------
-- Sequence structure for seq_dpt
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_dpt";
CREATE SEQUENCE "public"."seq_dpt"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
 -- ----------------------------
-- Sequence structure for seq_org
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_org";
CREATE SEQUENCE "public"."seq_org"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
  -- ----------------------------
-- Sequence structure for seq_absen
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_absen";
CREATE SEQUENCE "public"."seq_absen"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
   -- ----------------------------
-- Sequence structure for seq_produksi
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_produksi";
CREATE SEQUENCE "public"."seq_produksi"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
 
-- ----------------------------
-- Sequence structure for seq_spk
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_spk";
CREATE SEQUENCE "public"."seq_spk"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
 -- ----------------------------
-- Sequence structure for seq_summary
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_summary";
CREATE SEQUENCE "public"."seq_summary"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
  -- ----------------------------
-- Sequence structure for seq_summary
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_stock";
CREATE SEQUENCE "public"."seq_stock"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 

-- ----------------------------
-- Sequence structure for seq_lot
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_lot";
CREATE SEQUENCE "public"."seq_lot"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
 -- ----------------------------
-- Sequence structure for seq_lotapprv
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_lotapprv";
CREATE SEQUENCE "public"."seq_lotapprv"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
  -- ----------------------------
-- Sequence structure for seq_rpph
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_rpph";
CREATE SEQUENCE "public"."seq_rpph"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9999
 START 1
 CACHE 1; 
 
 


-- ----------------------------
-- Table structure for jdcadp_mstabsen
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_mstabsen";
CREATE TABLE "public"."jdcadp_mstabsen" (
"absen_id" int8 NOT NULL,
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6),
"attend_date" timestamp(6),
"start_date" timestamp(6),
"end_date" timestamp(6),
"total" int4,
"attend_code" varchar(50) COLLATE "default",
"company_name" varchar(500) COLLATE "default",
"cost_code" varchar(50) COLLATE "default",
"fullname" varchar(302) COLLATE "default",
"grade_code" varchar(50) COLLATE "default",
"kelamin" varchar(6) COLLATE "default",
"nik" varchar(302) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jdcadp_txnbcode
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_txnbcode";
CREATE TABLE "public"."jdcadp_txnbcode" (
"barcode_id" int8 NOT NULL,
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6),
"trs_date" timestamp(6),
"dpt_id" int8,
"product_code" varchar(50) COLLATE "default",
"qty" float8,
"sample_req" varchar(50) COLLATE "default",
"size" varchar(50) COLLATE "default",
"type" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jdcadp_mstdptunit
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_mstdptunit";
CREATE TABLE "public"."jdcadp_mstdptunit" (
"dpt_id" int8 NOT NULL,
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6),
"date_input" timestamp(6),
"dpt_code" varchar(10) COLLATE "default",
"dpt_name" varchar(50) COLLATE "default",
"org_id" int8
)
WITH (OIDS=FALSE)
;

-- ----------------------------
-- Table structure for jdcadp_mstimage
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_mstimage";
CREATE TABLE "public"."jdcadp_mstimage" (
"images_id" int8 NOT NULL,
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6),
"product_desc" varchar(250) COLLATE "default",
"images_name" varchar(100) COLLATE "default",
"line_code" varchar(20) COLLATE "default",
"po_no" varchar(20) COLLATE "default",
"po_item" varchar(20) COLLATE "default",
"product_code" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jdcadp_mstorgunit
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_mstorgunit";
CREATE TABLE "public"."jdcadp_mstorgunit" (
"org_id" int8 NOT NULL,
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6),
"date_input" timestamp(6),
"development" int4,
"org_code" varchar(10) COLLATE "default",
"org_name" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jdcadp_mstparams
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_mstparams";
CREATE TABLE "public"."jdcadp_mstparams" (
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


-- ----------------------------
-- Table structure for jdcadp_mstproduksi
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_mstproduksi";
CREATE TABLE "public"."jdcadp_mstproduksi" (
"product_id" int8 NOT NULL,
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6),
"demand_date" timestamp(6),
"gac_date" timestamp(6),
"igac_date" timestamp(6),
"ogac_date" timestamp(6),
"rgac_date" timestamp(6),
"sch_start_date" timestamp(6),
"address1" varchar(150) COLLATE "default",
"address1_line" varchar(10) COLLATE "default",
"city" varchar(150) COLLATE "default",
"product_desc" varchar(150) COLLATE "default",
"fg_desc" varchar(150) COLLATE "default",
"jo_ppic" varchar(100) COLLATE "default",
"line_code" varchar(20) COLLATE "default",
"po_item" varchar(20) COLLATE "default",
"po_no" varchar(20) COLLATE "default",
"qty" float8,
"size" varchar(10) COLLATE "default",
"org_id" int8,
"dpt_id" int8,
"flag_log_save" int8,
"flag_log_submit" int8,
"flag_lot_upload" int8,
"job_order" int8,
"jo_start_date" timestamp(6),
"jo_end_date" timestamp(6),
"project_alias" varchar(150) COLLATE "default",
"label_ins" varchar(150) COLLATE "default"
"demand_class" varchar(150) COLLATE "default"
)
WITH (OIDS=FALSE)
;

-- ----------------------------
-- Table structure for jdcadp_mstspk
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_mstspk";
CREATE TABLE "public"."jdcadp_mstspk" (
"id" int8 NOT NULL,
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6),
"detc" timestamp(6),
"vcategory" varchar(50) COLLATE "default",
"vmodel" varchar(250) COLLATE "default",
"vproductcode" varchar(50) COLLATE "default",
"vqty" int4,
"vsamplereq" varchar(50) COLLATE "default",
"vseason" varchar(50) COLLATE "default",
"vsize" int4,
"vtypesample" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of jdcadp_mstspk
-- ----------------------------

-- ----------------------------
-- Table structure for jdcadp_txnqctrl
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_txnqctrl";
CREATE TABLE "public"."jdcadp_txnqctrl" (
"qc_id" int8 NOT NULL,
"created_by" int8,
"created_date" timestamp(6),
"last_updated_by" int8,
"last_updated_date" timestamp(6),
"area" varchar(100) COLLATE "default",
"category" varchar(100) COLLATE "default",
"defect" varchar(100) COLLATE "default",
"product_desc" varchar(500) COLLATE "default",
"position" varchar(100) COLLATE "default",
"product_code" varchar(50) COLLATE "default",
"po_no" varchar(100) COLLATE "default",
"po_item" varchar(100) COLLATE "default",
"type" varchar(100) COLLATE "default",
"demand_class" varchar(100) COLLATE "default",
"dpt_id" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for jdcfnd_mstlookup
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcfnd_mstlookup";
CREATE TABLE "public"."jdcfnd_mstlookup" (
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

-- ----------------------------
-- Records of jdcfnd_mstlookup
-- ----------------------------
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('1', 'APPROVE', 'APPROVE', 'Approve', 'N', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('2', 'APPROVE', 'PENDING', 'Pending', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('3', 'APPROVE', 'REJECT', 'Reject', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('4', 'USER_TYPE', 'DIVISION IT', 'Division IT', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('5', 'KATEGORI', 'Web', 'Web', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('6', 'KATEGORI', 'Mobile', 'Mobile', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('7', 'USER_TYPE', 'Admin', 'Admin', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('8', 'USER_TYPE', 'Kantor Pusat', 'Kantor Pusat', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('9', 'USER_TYPE', 'Kantor Kanwil', 'Kantor Wilayah', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('10', 'USER_TYPE', 'Kantor Cabang', 'Kantor Cabang', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('11', 'USER_TYPE', 'Mitra', 'Mitra', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('12', 'ICONS_TYPE', 'fa-align-right                ', '&#xf038; fa-align-right         ', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('13', 'ICONS_TYPE', 'fa-amazon                     ', '&#xf270;fa-amazon', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('14', 'ICONS_TYPE', 'fa-ambulance                  ', '&#xf0f9;fa-ambulance', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('15', 'ICONS_TYPE', 'fa-anchor                     ', '&#xf13d;fa-anchor', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('16', 'ICONS_TYPE', 'fa-android                    ', '&#xf17b;fa-android', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('17', 'ICONS_TYPE', 'fa-angellist                  ', '&#xf209;fa-angellist', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('18', 'ICONS_TYPE', 'fa-angle-double-down          ', '&#xf103;fa-angle-double-down', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('19', 'ICONS_TYPE', 'fa-angle-double-left          ', '&#xf100;fa-angle-double-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('20', 'ICONS_TYPE', 'fa-angle-double-right         ', '&#xf101;fa-angle-double-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('21', 'ICONS_TYPE', 'fa-angle-double-up            ', '&#xf102;fa-angle-double-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('22', 'ICONS_TYPE', 'fa-angle-left                 ', '&#xf104;fa-angle-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('23', 'ICONS_TYPE', 'fa-angle-right                ', '&#xf105;fa-angle-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('24', 'ICONS_TYPE', 'fa-angle-up                   ', '&#xf106;fa-angle-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('25', 'ICONS_TYPE', 'fa-apple                      ', '&#xf179;fa-apple', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('26', 'ICONS_TYPE', 'fa-archive                    ', '&#xf187;fa-archive', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('27', 'ICONS_TYPE', 'fa-area-chart                 ', '&#xf1fe;fa-area-chart', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('28', 'ICONS_TYPE', 'fa-arrow-circle-down          ', '&#xf0ab;fa-arrow-circle-down', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('29', 'ICONS_TYPE', 'fa-arrow-circle-left          ', '&#xf0a8;fa-arrow-circle-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('30', 'ICONS_TYPE', 'fa-arrow-circle-o-down        ', '&#xf01a;fa-arrow-circle-o-down', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('31', 'ICONS_TYPE', 'fa-arrow-circle-o-left        ', '&#xf190;fa-arrow-circle-o-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('32', 'ICONS_TYPE', 'fa-arrow-circle-o-right       ', '&#xf18e;fa-arrow-circle-o-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('33', 'ICONS_TYPE', 'fa-arrow-circle-o-up          ', '&#xf01b;fa-arrow-circle-o-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('34', 'ICONS_TYPE', 'fa-arrow-circle-right         ', '&#xf0a9;fa-arrow-circle-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('35', 'ICONS_TYPE', 'fa-arrow-circle-up            ', '&#xf0aa;fa-arrow-circle-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('36', 'ICONS_TYPE', 'fa-arrow-down                 ', '&#xf063;fa-arrow-down', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('37', 'ICONS_TYPE', 'fa-arrow-left                 ', '&#xf060;fa-arrow-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('38', 'ICONS_TYPE', 'fa-arrow-right                ', '&#xf061;fa-arrow-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('39', 'ICONS_TYPE', 'fa-arrow-up                   ', '&#xf062;fa-arrow-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('40', 'ICONS_TYPE', 'fa-arrows                     ', '&#xf047;fa-arrows', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('41', 'ICONS_TYPE', 'fa-arrows-alt                 ', '&#xf0b2;fa-arrows-alt', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('42', 'ICONS_TYPE', 'fa-arrows-h                   ', '&#xf07e;fa-arrows-h', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('43', 'ICONS_TYPE', 'fa-arrows-v                   ', '&#xf07d;fa-arrows-v', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('44', 'ICONS_TYPE', 'fa-asterisk                   ', '&#xf069;fa-asterisk', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('45', 'ICONS_TYPE', 'fa-at                         ', '&#xf1fa;fa-at', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('46', 'ICONS_TYPE', 'fa-automobile                 ', '&#xf1b9;fa-automobile', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('47', 'ICONS_TYPE', 'fa-backward                   ', '&#xf04a;fa-backward', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('48', 'ICONS_TYPE', 'fa-balance-scale              ', '&#xf24e;fa-balance-scale', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('49', 'ICONS_TYPE', 'fa-ban                        ', '&#xf05e;fa-ban', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('50', 'ICONS_TYPE', 'fa-bank                       ', '&#xf19c;fa-bank', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('51', 'ICONS_TYPE', 'fa-bar-chart                  ', '&#xf080;fa-bar-chart', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('52', 'ICONS_TYPE', 'fa-bar-chart-o                ', '&#xf080;fa-bar-chart-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('53', 'ICONS_TYPE', 'fa-battery-full               ', '&#xf240;fa-battery-full', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('54', 'ICONS_TYPE', 'n value="fa-beer              ', '&#xf0fc;fa-beer', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('55', 'ICONS_TYPE', 'fa-behance                    ', '&#xf1b4;fa-behance', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('56', 'ICONS_TYPE', 'fa-behance-square             ', '&#xf1b5;fa-behance-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('57', 'ICONS_TYPE', 'fa-bell                       ', '&#xf0f3;fa-bell', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('58', 'ICONS_TYPE', 'fa-bell-o                     ', '&#xf0a2;fa-bell-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('59', 'ICONS_TYPE', 'fa-bell-slash                 ', '&#xf1f6;fa-bell-slash', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('60', 'ICONS_TYPE', 'fa-bell-slash-o               ', '&#xf1f7;fa-bell-slash-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('61', 'ICONS_TYPE', 'fa-bicycle                    ', '&#xf206;fa-bicycle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('62', 'ICONS_TYPE', 'fa-binoculars                 ', '&#xf1e5;fa-binoculars', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('63', 'ICONS_TYPE', 'fa-birthday-cake              ', '&#xf1fd;fa-birthday-cake', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('64', 'ICONS_TYPE', 'fa-bitbucket                  ', '&#xf171;fa-bitbucket', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('65', 'ICONS_TYPE', 'fa-bitbucket-square           ', '&#xf172;fa-bitbucket-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('66', 'ICONS_TYPE', 'fa-bitcoin                    ', '&#xf15a;fa-bitcoin', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('67', 'ICONS_TYPE', 'fa-black-tie                  ', '&#xf27e;fa-black-tie', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('68', 'ICONS_TYPE', 'fa-bold                       ', '&#xf032;fa-bold', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('69', 'ICONS_TYPE', 'fa-bolt                       ', '&#xf0e7;fa-bolt', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('70', 'ICONS_TYPE', 'fa-bomb                       ', '&#xf1e2;fa-bomb', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('71', 'ICONS_TYPE', 'fa-book                       ', '&#xf02d;fa-book', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('72', 'ICONS_TYPE', 'fa-bookmark                   ', '&#xf02e;fa-bookmark', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('73', 'ICONS_TYPE', 'fa-bookmark-o                 ', '&#xf097;fa-bookmark-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('74', 'ICONS_TYPE', 'fa-briefcase                  ', '&#xf0b1;fa-briefcase', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('75', 'ICONS_TYPE', 'fa-btc                        ', '&#xf15a;fa-btc', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('76', 'ICONS_TYPE', 'fa-bug                        ', '&#xf188;fa-bug', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('77', 'ICONS_TYPE', 'fa-building                   ', '&#xf1ad;fa-building', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('78', 'ICONS_TYPE', 'fa-building-o                 ', '&#xf0f7;fa-building-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('79', 'ICONS_TYPE', 'fa-bullhorn                   ', '&#xf0a1;fa-bullhorn', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('80', 'ICONS_TYPE', 'fa-bullseye                   ', '&#xf140;fa-bullseye', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('81', 'ICONS_TYPE', 'fa-bus                        ', '&#xf207;fa-bus', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('82', 'ICONS_TYPE', 'fa-cab                        ', '&#xf1ba;fa-cab', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('83', 'ICONS_TYPE', 'fa-calendar                   ', '&#xf073;fa-calendar', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('84', 'ICONS_TYPE', 'fa-camera                     ', '&#xf030;fa-camera', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('85', 'ICONS_TYPE', 'fa-car                        ', '&#xf1b9;fa-car', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('86', 'ICONS_TYPE', 'fa-caret-up                   ', '&#xf0d8;fa-caret-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('87', 'ICONS_TYPE', 'fa-cart-plus                  ', '&#xf217;fa-cart-plus', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('88', 'ICONS_TYPE', 'fa-cc                         ', '&#xf20a;fa-cc', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('89', 'ICONS_TYPE', 'fa-cc-amex                    ', '&#xf1f3;fa-cc-amex', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('90', 'ICONS_TYPE', 'fa-cc-jcb                     ', '&#xf24b;fa-cc-jcb', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('91', 'ICONS_TYPE', 'fa-cc-paypal                  ', '&#xf1f4;fa-cc-paypal', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('92', 'ICONS_TYPE', 'fa-cc-stripe                  ', '&#xf1f5;fa-cc-stripe', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('93', 'ICONS_TYPE', 'fa-cc-visa                    ', '&#xf1f0;fa-cc-visa', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('94', 'ICONS_TYPE', 'fa-chain                      ', '&#xf0c1;fa-chain', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('95', 'ICONS_TYPE', 'fa-check                      ', '&#xf00c;fa-check', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('96', 'ICONS_TYPE', 'fa-chevron-left               ', '&#xf053;fa-chevron-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('97', 'ICONS_TYPE', 'fa-chevron-right              ', '&#xf054;fa-chevron-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('98', 'ICONS_TYPE', 'fa-chevron-up                 ', '&#xf077;fa-chevron-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('99', 'ICONS_TYPE', 'fa-child                      ', '&#xf1ae;fa-child', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('100', 'ICONS_TYPE', 'fa-chrome                     ', '&#xf268;fa-chrome', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('101', 'ICONS_TYPE', 'fa-circle                     ', '&#xf111;fa-circle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('102', 'ICONS_TYPE', 'fa-circle-o                   ', '&#xf10c;fa-circle-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('103', 'ICONS_TYPE', 'fa-circle-o-notch             ', '&#xf1ce;fa-circle-o-notch', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('104', 'ICONS_TYPE', 'fa-circle-thin                ', '&#xf1db;fa-circle-thin', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('105', 'ICONS_TYPE', 'fa-clipboard                  ', '&#xf0ea;fa-clipboard', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('106', 'ICONS_TYPE', 'fa-clock-o                    ', '&#xf017;fa-clock-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('107', 'ICONS_TYPE', 'fa-clone                      ', '&#xf24d;fa-clone', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('108', 'ICONS_TYPE', 'fa-close                      ', '&#xf00d;fa-close', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('109', 'ICONS_TYPE', 'fa-cloud                      ', '&#xf0c2;fa-cloud', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('110', 'ICONS_TYPE', 'fa-cloud-download             ', '&#xf0ed;fa-cloud-download', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('111', 'ICONS_TYPE', 'fa-cloud-upload               ', '&#xf0ee;fa-cloud-upload', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('112', 'ICONS_TYPE', 'fa-cny                        ', '&#xf157;fa-cny', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('113', 'ICONS_TYPE', 'fa-code                       ', '&#xf121;fa-code', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('114', 'ICONS_TYPE', 'fa-code-fork                  ', '&#xf126;fa-code-fork', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('115', 'ICONS_TYPE', 'fa-codepen                    ', '&#xf1cb;fa-codepen', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('116', 'ICONS_TYPE', 'fa-coffee                     ', '&#xf0f4;fa-coffee', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('117', 'ICONS_TYPE', 'fa-cog                        ', '&#xf013;fa-cog', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('118', 'ICONS_TYPE', 'fa-cogs                       ', '&#xf085;fa-cogs', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('119', 'ICONS_TYPE', 'fa-columns                    ', '&#xf0db;fa-columns', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('120', 'ICONS_TYPE', 'fa-comment                    ', '&#xf075;fa-comment', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('121', 'ICONS_TYPE', 'fa-comment-o                  ', '&#xf0e5;fa-comment-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('122', 'ICONS_TYPE', 'fa-commenting                 ', '&#xf27a;fa-commenting', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('123', 'ICONS_TYPE', 'fa-commenting-o               ', '&#xf27b;fa-commenting-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('124', 'ICONS_TYPE', 'fa-comments                   ', '&#xf086;fa-comments', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('125', 'ICONS_TYPE', 'fa-comments-o                 ', '&#xf0e6;fa-comments-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('126', 'ICONS_TYPE', 'fa-compass                    ', '&#xf14e;fa-compass', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('127', 'ICONS_TYPE', 'fa-compress                   ', '&#xf066;fa-compress', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('128', 'ICONS_TYPE', 'fa-connectdevelop             ', '&#xf20e;fa-connectdevelop', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('129', 'ICONS_TYPE', 'fa-contao                     ', '&#xf26d;fa-contao', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('130', 'ICONS_TYPE', 'fa-copy                       ', '&#xf0c5;fa-copy', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('131', 'ICONS_TYPE', 'fa-copyright                  ', '&#xf1f9;fa-copyright', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('132', 'ICONS_TYPE', 'fa-creative-commons           ', '&#xf25e;fa-creative-commons', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('133', 'ICONS_TYPE', 'fa-credit-card                ', '&#xf09d;fa-credit-card', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('134', 'ICONS_TYPE', 'fa-crop                       ', '&#xf125;fa-crop', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('135', 'ICONS_TYPE', 'fa-crosshairs                 ', '&#xf05b;fa-crosshairs', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('136', 'ICONS_TYPE', 'fa-css3                       ', '&#xf13c;fa-css3', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('137', 'ICONS_TYPE', 'fa-cube                       ', '&#xf1b2;fa-cube', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('138', 'ICONS_TYPE', 'fa-cubes                      ', '&#xf1b3;fa-cubes', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('139', 'ICONS_TYPE', 'fa-cut                        ', '&#xf0c4;fa-cut', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('140', 'ICONS_TYPE', 'fa-cutlery                    ', '&#xf0f5;fa-cutlery', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('141', 'ICONS_TYPE', 'fa-dashboard                  ', '&#xf0e4;fa-dashboard', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('142', 'ICONS_TYPE', 'fa-dashcube                   ', '&#xf210;fa-dashcube', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('143', 'ICONS_TYPE', 'fa-database                   ', '&#xf1c0;fa-database', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('144', 'ICONS_TYPE', 'fa-dedent                     ', '&#xf03b;fa-dedent', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('145', 'ICONS_TYPE', 'fa-delicious                  ', '&#xf1a5;fa-delicious', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('146', 'ICONS_TYPE', 'fa-desktop                    ', '&#xf108;fa-desktop', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('147', 'ICONS_TYPE', 'fa-deviantart                 ', '&#xf1bd;fa-deviantart', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('148', 'ICONS_TYPE', 'fa-diamond                    ', '&#xf219;fa-diamond', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('149', 'ICONS_TYPE', 'fa-digg                       ', '&#xf1a6;fa-digg', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('150', 'ICONS_TYPE', 'fa-dollar                     ', '&#xf155;fa-dollar', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('151', 'ICONS_TYPE', 'fa-download                   ', '&#xf019;fa-download', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('152', 'ICONS_TYPE', 'fa-dribbble                   ', '&#xf17d;fa-dribbble', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('153', 'ICONS_TYPE', 'fa-dropbox                    ', '&#xf16b;fa-dropbox', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('154', 'ICONS_TYPE', 'fa-drupal                     ', '&#xf1a9;fa-drupal', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('155', 'ICONS_TYPE', 'fa-edit                       ', '&#xf044;fa-edit', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('156', 'ICONS_TYPE', 'fa-eject                      ', '&#xf052;fa-eject', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('157', 'ICONS_TYPE', 'fa-ellipsis-h                 ', '&#xf141;fa-ellipsis-h', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('158', 'ICONS_TYPE', 'fa-ellipsis-v                 ', '&#xf142;fa-ellipsis-v', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('159', 'ICONS_TYPE', 'fa-empire                     ', '&#xf1d1;fa-empire', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('160', 'ICONS_TYPE', 'fa-envelope                   ', '&#xf0e0;fa-envelope', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('161', 'ICONS_TYPE', 'fa-envelope-o                 ', '&#xf003;fa-envelope-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('162', 'ICONS_TYPE', 'fa-eur                        ', '&#xf153;fa-eur', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('163', 'ICONS_TYPE', 'fa-euro                       ', '&#xf153;fa-euro', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('164', 'ICONS_TYPE', 'fa-exchange                   ', '&#xf0ec;fa-exchange', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('165', 'ICONS_TYPE', 'fa-exclamation                ', '&#xf12a;fa-exclamation', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('166', 'ICONS_TYPE', 'fa-exclamation-circle         ', '&#xf06a;fa-exclamation-circle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('167', 'ICONS_TYPE', 'fa-exclamation-triangle       ', '&#xf071;fa-exclamation-triangle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('168', 'ICONS_TYPE', 'fa-expand                     ', '&#xf065;fa-expand', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('169', 'ICONS_TYPE', 'fa-expeditedssl               ', '&#xf23e;fa-expeditedssl', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('170', 'ICONS_TYPE', 'fa-external-link              ', '&#xf08e;fa-external-link', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('171', 'ICONS_TYPE', 'fa-external-link-square       ', '&#xf14c;fa-external-link-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('172', 'ICONS_TYPE', 'fa-eye                        ', '&#xf06e;fa-eye', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('173', 'ICONS_TYPE', 'fa-eye-slash                  ', '&#xf070;fa-eye-slash', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('174', 'ICONS_TYPE', 'fa-eyedropper                 ', '&#xf1fb;fa-eyedropper', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('175', 'ICONS_TYPE', 'fa-facebook                   ', '&#xf09a;fa-facebook', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('176', 'ICONS_TYPE', 'fa-facebook-f                 ', '&#xf09a;fa-facebook-f', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('177', 'ICONS_TYPE', 'fa-facebook-official          ', '&#xf230;fa-facebook-official', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('178', 'ICONS_TYPE', 'fa-facebook-square            ', '&#xf082;fa-facebook-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('179', 'ICONS_TYPE', 'fa-fast-backward              ', '&#xf049;fa-fast-backward', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('180', 'ICONS_TYPE', 'fa-fast-forward               ', '&#xf050;fa-fast-forward', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('181', 'ICONS_TYPE', 'fa-fax                        ', '&#xf1ac;fa-fax', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('182', 'ICONS_TYPE', 'fa-feed                       ', '&#xf09e;fa-feed', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('183', 'ICONS_TYPE', 'fa-female                     ', '&#xf182;fa-female', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('184', 'ICONS_TYPE', 'fa-fighter-jet                ', '&#xf0fb;fa-fighter-jet', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('185', 'ICONS_TYPE', 'fa-file                       ', '&#xf15b;fa-file', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('186', 'ICONS_TYPE', 'fa-file-archive-o             ', '&#xf1c6;fa-file-archive-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('187', 'ICONS_TYPE', 'fa-file-audio-o               ', '&#xf1c7;fa-file-audio-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('188', 'ICONS_TYPE', 'fa-file-code-o                ', '&#xf1c9;fa-file-code-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('189', 'ICONS_TYPE', 'fa-file-excel-o               ', '&#xf1c3;fa-file-excel-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('190', 'ICONS_TYPE', 'fa-file-image-o               ', '&#xf1c5;fa-file-image-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('191', 'ICONS_TYPE', 'fa-file-movie-o               ', '&#xf1c8;fa-file-movie-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('192', 'ICONS_TYPE', 'fa-file-o                     ', '&#xf016;fa-file-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('193', 'ICONS_TYPE', 'fa-file-pdf-o                 ', '&#xf1c1;fa-file-pdf-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('194', 'ICONS_TYPE', 'fa-file-photo-o               ', '&#xf1c5;fa-file-photo-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('195', 'ICONS_TYPE', 'fa-file-picture-o             ', '&#xf1c5;fa-file-picture-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('196', 'ICONS_TYPE', 'fa-file-powerpoint-o          ', '&#xf1c4;fa-file-powerpoint-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('197', 'ICONS_TYPE', 'fa-file-sound-o               ', '&#xf1c7;fa-file-sound-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('198', 'ICONS_TYPE', 'fa-file-text                  ', '&#xf15c;fa-file-text', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('199', 'ICONS_TYPE', 'fa-file-text-o                ', '&#xf0f6;fa-file-text-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('200', 'ICONS_TYPE', 'fa-file-video-o               ', '&#xf1c8;fa-file-video-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('201', 'ICONS_TYPE', 'fa-file-word-o                ', '&#xf1c2;fa-file-word-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('202', 'ICONS_TYPE', 'fa-file-zip-o                 ', '&#xf1c6;fa-file-zip-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('203', 'ICONS_TYPE', 'fa-files-o                    ', '&#xf0c5;fa-files-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('204', 'ICONS_TYPE', 'fa-film                       ', '&#xf008;fa-film', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('205', 'ICONS_TYPE', 'fa-filter                     ', '&#xf0b0;fa-filter', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('206', 'ICONS_TYPE', 'fa-fire                       ', '&#xf06d;fa-fire', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('207', 'ICONS_TYPE', 'fa-fire-extinguisher          ', '&#xf134;fa-fire-extinguisher', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('208', 'ICONS_TYPE', 'fa-firefox                    ', '&#xf269;fa-firefox', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('209', 'ICONS_TYPE', 'fa-flag                       ', '&#xf024;fa-flag', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('210', 'ICONS_TYPE', 'fa-flag-checkered             ', '&#xf11e;fa-flag-checkered', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('211', 'ICONS_TYPE', 'fa-flag-o                     ', '&#xf11d;fa-flag-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('212', 'ICONS_TYPE', 'fa-flash                      ', '&#xf0e7;fa-flash', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('213', 'ICONS_TYPE', 'fa-flask                      ', '&#xf0c3;fa-flask', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('214', 'ICONS_TYPE', 'fa-flickr                     ', '&#xf16e;fa-flickr', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('215', 'ICONS_TYPE', 'fa-floppy-o                   ', '&#xf0c7;fa-floppy-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('216', 'ICONS_TYPE', 'fa-folder                     ', '&#xf07b;fa-folder', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('217', 'ICONS_TYPE', 'fa-folder-o                   ', '&#xf114;fa-folder-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('218', 'ICONS_TYPE', 'fa-folder-open                ', '&#xf07c;fa-folder-open', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('219', 'ICONS_TYPE', 'fa-folder-open-o              ', '&#xf115;fa-folder-open-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('220', 'ICONS_TYPE', 'fa-font                       ', '&#xf031;fa-font', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('221', 'ICONS_TYPE', 'fa-fonticons                  ', '&#xf280;fa-fonticons', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('222', 'ICONS_TYPE', 'fa-forumbee                   ', '&#xf211;fa-forumbee', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('223', 'ICONS_TYPE', 'fa-forward                    ', '&#xf04e;fa-forward', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('224', 'ICONS_TYPE', 'fa-foursquare                 ', '&#xf180;fa-foursquare', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('225', 'ICONS_TYPE', 'fa-frown-o                    ', '&#xf119;fa-frown-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('226', 'ICONS_TYPE', 'fa-futbol-o                   ', '&#xf1e3;fa-futbol-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('227', 'ICONS_TYPE', 'fa-gamepad                    ', '&#xf11b;fa-gamepad', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('228', 'ICONS_TYPE', 'fa-gavel                      ', '&#xf0e3;fa-gavel', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('229', 'ICONS_TYPE', 'fa-gbp                        ', '&#xf154;fa-gbp', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('230', 'ICONS_TYPE', 'fa-ge                         ', '&#xf1d1;fa-ge', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('231', 'ICONS_TYPE', 'fa-gear                       ', '&#xf013;fa-gear', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('232', 'ICONS_TYPE', 'fa-gears                      ', '&#xf085;fa-gears', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('233', 'ICONS_TYPE', 'fa-genderless                 ', '&#xf22d;fa-genderless', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('234', 'ICONS_TYPE', 'fa-get-pocket                 ', '&#xf265;fa-get-pocket', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('235', 'ICONS_TYPE', 'fa-gg                         ', '&#xf260;fa-gg', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('236', 'ICONS_TYPE', 'fa-gg-circle                  ', '&#xf261;fa-gg-circle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('237', 'ICONS_TYPE', 'fa-gift                       ', '&#xf06b;fa-gift', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('238', 'ICONS_TYPE', 'fa-git                        ', '&#xf1d3;fa-git', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('239', 'ICONS_TYPE', 'fa-git-square                 ', '&#xf1d2;fa-git-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('240', 'ICONS_TYPE', 'fa-github                     ', '&#xf09b;fa-github', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('241', 'ICONS_TYPE', 'fa-github-alt                 ', '&#xf113;fa-github-alt', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('242', 'ICONS_TYPE', 'fa-github-square              ', '&#xf092;fa-github-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('243', 'ICONS_TYPE', 'fa-gittip                     ', '&#xf184;fa-gittip', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('244', 'ICONS_TYPE', 'fa-glass                      ', '&#xf000;fa-glass', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('245', 'ICONS_TYPE', 'fa-globe                      ', '&#xf0ac;fa-globe', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('246', 'ICONS_TYPE', 'fa-google                     ', '&#xf1a0;fa-google', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('247', 'ICONS_TYPE', 'fa-google-plus                ', '&#xf0d5;fa-google-plus', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('248', 'ICONS_TYPE', 'fa-google-plus-square         ', '&#xf0d4;fa-google-plus-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('249', 'ICONS_TYPE', 'fa-google-wallet              ', '&#xf1ee;fa-google-wallet', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('250', 'ICONS_TYPE', 'fa-graduation-cap             ', '&#xf19d;fa-graduation-cap', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('251', 'ICONS_TYPE', 'fa-gratipay                   ', '&#xf184;fa-gratipay', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('252', 'ICONS_TYPE', 'fa-group                      ', '&#xf0c0;fa-group', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('253', 'ICONS_TYPE', 'fa-h-square                   ', '&#xf0fd;fa-h-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('254', 'ICONS_TYPE', 'fa-hacker-news                ', '&#xf1d4;fa-hacker-news', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('255', 'ICONS_TYPE', 'fa-hand-grab-o                ', '&#xf255;fa-hand-grab-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('256', 'ICONS_TYPE', 'fa-hand-lizard-o              ', '&#xf258;fa-hand-lizard-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('257', 'ICONS_TYPE', 'fa-hand-o-down                ', '&#xf0a7;fa-hand-o-down', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('258', 'ICONS_TYPE', 'fa-hand-o-left                ', '&#xf0a5;fa-hand-o-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('259', 'ICONS_TYPE', 'fa-hand-o-right               ', '&#xf0a4;fa-hand-o-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('260', 'ICONS_TYPE', 'fa-hand-o-up                  ', '&#xf0a6;fa-hand-o-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('261', 'ICONS_TYPE', 'fa-hand-paper-o               ', '&#xf256;fa-hand-paper-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('262', 'ICONS_TYPE', 'fa-hand-peace-o               ', '&#xf25b;fa-hand-peace-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('263', 'ICONS_TYPE', 'fa-hand-pointer-o             ', '&#xf25a;fa-hand-pointer-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('264', 'ICONS_TYPE', 'fa-hand-rock-o                ', '&#xf255;fa-hand-rock-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('265', 'ICONS_TYPE', 'fa-hand-scissors-o            ', '&#xf257;fa-hand-scissors-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('266', 'ICONS_TYPE', 'fa-hand-spock-o               ', '&#xf259;fa-hand-spock-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('267', 'ICONS_TYPE', 'fa-hand-stop-o                ', '&#xf256;fa-hand-stop-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('268', 'ICONS_TYPE', 'fa-hdd-o                      ', '&#xf0a0;fa-hdd-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('269', 'ICONS_TYPE', 'fa-header                     ', '&#xf1dc;fa-header', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('270', 'ICONS_TYPE', 'fa-headphones                 ', '&#xf025;fa-headphones', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('271', 'ICONS_TYPE', 'fa-heart                      ', '&#xf004;fa-heart', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('272', 'ICONS_TYPE', 'fa-heart-o                    ', '&#xf08a;fa-heart-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('273', 'ICONS_TYPE', 'fa-heartbeat                  ', '&#xf21e;fa-heartbeat', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('274', 'ICONS_TYPE', 'fa-history                    ', '&#xf1da;fa-history', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('275', 'ICONS_TYPE', 'fa-home                       ', '&#xf015;fa-home', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('276', 'ICONS_TYPE', 'fa-hospital-o                 ', '&#xf0f8;fa-hospital-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('277', 'ICONS_TYPE', 'fa-hotel                      ', '&#xf236;fa-hotel', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('278', 'ICONS_TYPE', 'fa-hourglass                  ', '&#xf254;fa-hourglass', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('279', 'ICONS_TYPE', 'fa-hourglass-1                ', '&#xf251;fa-hourglass-1', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('280', 'ICONS_TYPE', 'fa-hourglass-2                ', '&#xf252;fa-hourglass-2', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('281', 'ICONS_TYPE', 'fa-hourglass-3                ', '&#xf253;fa-hourglass-3', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('282', 'ICONS_TYPE', 'fa-hourglass-end              ', '&#xf253;fa-hourglass-end', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('283', 'ICONS_TYPE', 'fa-hourglass-half             ', '&#xf252;fa-hourglass-half', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('284', 'ICONS_TYPE', 'fa-hourglass-o                ', '&#xf250;fa-hourglass-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('285', 'ICONS_TYPE', 'fa-hourglass-start            ', '&#xf251;fa-hourglass-start', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('286', 'ICONS_TYPE', 'fa-houzz                      ', '&#xf27c;fa-houzz', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('287', 'ICONS_TYPE', 'fa-html5                      ', '&#xf13b;fa-html5', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('288', 'ICONS_TYPE', 'fa-i-cursor                   ', '&#xf246;fa-i-cursor', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('289', 'ICONS_TYPE', 'fa-ils                        ', '&#xf20b;fa-ils', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('290', 'ICONS_TYPE', 'fa-image                      ', '&#xf03e;fa-image', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('291', 'ICONS_TYPE', 'fa-inbox                      ', '&#xf01c;fa-inbox', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('292', 'ICONS_TYPE', 'fa-indent                     ', '&#xf03c;fa-indent', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('293', 'ICONS_TYPE', 'fa-industry                   ', '&#xf275;fa-industry', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('294', 'ICONS_TYPE', 'fa-info                       ', '&#xf129;fa-info', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('295', 'ICONS_TYPE', 'fa-info-circle                ', '&#xf05a;fa-info-circle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('296', 'ICONS_TYPE', 'fa-inr                        ', '&#xf156;fa-inr', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('297', 'ICONS_TYPE', 'fa-instagram                  ', '&#xf16d;fa-instagram', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('298', 'ICONS_TYPE', 'fa-institution                ', '&#xf19c;fa-institution', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('299', 'ICONS_TYPE', 'fa-internet-explorer          ', '&#xf26b;fa-internet-explorer', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('300', 'ICONS_TYPE', 'fa-intersex                   ', '&#xf224;fa-intersex', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('301', 'ICONS_TYPE', 'fa-ioxhost                    ', '&#xf208;fa-ioxhost', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('302', 'ICONS_TYPE', 'fa-italic                     ', '&#xf033;fa-italic', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('303', 'ICONS_TYPE', 'fa-joomla                     ', '&#xf1aa;fa-joomla', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('304', 'ICONS_TYPE', 'fa-jpy                        ', '&#xf157;fa-jpy', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('305', 'ICONS_TYPE', 'fa-jsfiddle                   ', '&#xf1cc;fa-jsfiddle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('306', 'ICONS_TYPE', 'fa-key                        ', '&#xf084;fa-key', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('307', 'ICONS_TYPE', 'fa-keyboard-o                 ', '&#xf11c;fa-keyboard-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('308', 'ICONS_TYPE', 'fa-krw                        ', '&#xf159;fa-krw', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('309', 'ICONS_TYPE', 'fa-language                   ', '&#xf1ab;fa-language', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('310', 'ICONS_TYPE', 'fa-laptop                     ', '&#xf109;fa-laptop', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('311', 'ICONS_TYPE', 'fa-lastfm                     ', '&#xf202;fa-lastfm', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('312', 'ICONS_TYPE', 'fa-lastfm-square              ', '&#xf203;fa-lastfm-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('313', 'ICONS_TYPE', 'fa-leaf                       ', '&#xf06c;fa-leaf', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('314', 'ICONS_TYPE', 'fa-leanpub                    ', '&#xf212;fa-leanpub', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('315', 'ICONS_TYPE', 'fa-legal                      ', '&#xf0e3;fa-legal', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('316', 'ICONS_TYPE', 'fa-lemon-o                    ', '&#xf094;fa-lemon-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('317', 'ICONS_TYPE', 'fa-level-down                 ', '&#xf149;fa-level-down', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('318', 'ICONS_TYPE', 'fa-level-up                   ', '&#xf148;fa-level-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('319', 'ICONS_TYPE', 'fa-life-bouy                  ', '&#xf1cd;fa-life-bouy', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('320', 'ICONS_TYPE', 'fa-life-buoy                  ', '&#xf1cd;fa-life-buoy', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('321', 'ICONS_TYPE', 'fa-life-ring                  ', '&#xf1cd;fa-life-ring', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('322', 'ICONS_TYPE', 'fa-life-saver                 ', '&#xf1cd;fa-life-saver', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('323', 'ICONS_TYPE', 'fa-lightbulb-o                ', '&#xf0eb;fa-lightbulb-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('324', 'ICONS_TYPE', 'fa-line-chart                 ', '&#xf201;fa-line-chart', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('325', 'ICONS_TYPE', 'fa-link                       ', '&#xf0c1;fa-link', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('326', 'ICONS_TYPE', 'fa-linkedin                   ', '&#xf0e1;fa-linkedin', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('327', 'ICONS_TYPE', 'fa-linkedin-square            ', '&#xf08c;fa-linkedin-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('328', 'ICONS_TYPE', 'fa-linux                      ', '&#xf17c;fa-linux', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('329', 'ICONS_TYPE', 'fa-list                       ', '&#xf03a;fa-list', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('330', 'ICONS_TYPE', 'fa-list-alt                   ', '&#xf022;fa-list-alt', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('331', 'ICONS_TYPE', 'fa-list-ol                    ', '&#xf0cb;fa-list-ol', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('332', 'ICONS_TYPE', 'fa-list-ul                    ', '&#xf0ca;fa-list-ul', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('333', 'ICONS_TYPE', 'fa-location-arrow             ', '&#xf124;fa-location-arrow', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('334', 'ICONS_TYPE', 'fa-lock                       ', '&#xf023;fa-lock', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('335', 'ICONS_TYPE', 'fa-long-arrow-down            ', '&#xf175;fa-long-arrow-down', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('336', 'ICONS_TYPE', 'fa-long-arrow-left            ', '&#xf177;fa-long-arrow-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('337', 'ICONS_TYPE', 'fa-long-arrow-right           ', '&#xf178;fa-long-arrow-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('338', 'ICONS_TYPE', 'fa-long-arrow-up              ', '&#xf176;fa-long-arrow-up', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('339', 'ICONS_TYPE', 'fa-magic                      ', '&#xf0d0;fa-magic', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('340', 'ICONS_TYPE', 'fa-magnet                     ', '&#xf076;fa-magnet', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('341', 'ICONS_TYPE', 'fa-mars-stroke-v              ', '&#xf22a;fa-mars-stroke-v', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('342', 'ICONS_TYPE', 'fa-maxcdn                     ', '&#xf136;fa-maxcdn', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('343', 'ICONS_TYPE', 'fa-meanpath                   ', '&#xf20c;fa-meanpath', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('344', 'ICONS_TYPE', 'fa-medium                     ', '&#xf23a;fa-medium', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('345', 'ICONS_TYPE', 'fa-medkit                     ', '&#xf0fa;fa-medkit', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('346', 'ICONS_TYPE', 'fa-meh-o                      ', '&#xf11a;fa-meh-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('347', 'ICONS_TYPE', 'fa-mercury                    ', '&#xf223;fa-mercury', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('348', 'ICONS_TYPE', 'fa-microphone                 ', '&#xf130;fa-microphone', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('349', 'ICONS_TYPE', 'fa-mobile                     ', '&#xf10b;fa-mobile', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('350', 'ICONS_TYPE', 'fa-motorcycle                 ', '&#xf21c;fa-motorcycle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('351', 'ICONS_TYPE', 'fa-mouse-pointer              ', '&#xf245;fa-mouse-pointer', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('352', 'ICONS_TYPE', 'fa-music                      ', '&#xf001;fa-music', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('353', 'ICONS_TYPE', 'fa-navicon                    ', '&#xf0c9;fa-navicon', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('354', 'ICONS_TYPE', 'fa-neuter                     ', '&#xf22c;fa-neuter', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('355', 'ICONS_TYPE', 'fa-newspaper-o                ', '&#xf1ea;fa-newspaper-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('356', 'ICONS_TYPE', 'fa-opencart                   ', '&#xf23d;fa-opencart', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('357', 'ICONS_TYPE', 'fa-openid                     ', '&#xf19b;fa-openid', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('358', 'ICONS_TYPE', 'fa-opera                      ', '&#xf03b;fa-outdent', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('359', 'ICONS_TYPE', 'fa-outdent                    ', '&#xf26a;fa-opera', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('360', 'ICONS_TYPE', 'fa-pagelines                  ', '&#xf18c;fa-pagelines', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('361', 'ICONS_TYPE', 'fa-paper-plane-o              ', '&#xf1d9;fa-paper-plane-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('362', 'ICONS_TYPE', 'fa-paperclip                  ', '&#xf0c6;fa-paperclip', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('363', 'ICONS_TYPE', 'fa-paragraph                  ', '&#xf1dd;fa-paragraph', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('364', 'ICONS_TYPE', 'fa-paste                      ', '&#xf0ea;fa-paste', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('365', 'ICONS_TYPE', 'fa-pause                      ', '&#xf04c;fa-pause', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('366', 'ICONS_TYPE', 'fa-paw                        ', '&#xf1b0;fa-paw', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('367', 'ICONS_TYPE', 'fa-paypal                     ', '&#xf1ed;fa-paypal', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('368', 'ICONS_TYPE', 'fa-pencil                     ', '&#xf040;fa-pencil', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('369', 'ICONS_TYPE', 'fa-pencil-square-o            ', '&#xf044;fa-pencil-square-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('370', 'ICONS_TYPE', 'fa-phone                      ', '&#xf095;fa-phone', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('371', 'ICONS_TYPE', 'fa-photo                      ', '&#xf03e;fa-photo', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('372', 'ICONS_TYPE', 'fa-picture-o                  ', '&#xf03e;fa-picture-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('373', 'ICONS_TYPE', 'fa-pie-chart                  ', '&#xf200;fa-pie-chart', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('374', 'ICONS_TYPE', 'fa-pied-piper                 ', '&#xf1a8;fa-pied-piper-alt', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('375', 'ICONS_TYPE', 'fa-pied-piper-alt             ', '&#xf1a7;fa-pied-piper', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('376', 'ICONS_TYPE', 'fa-pinterest                  ', '&#xf0d2;fa-pinterest', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('377', 'ICONS_TYPE', 'fa-pinterest-p                ', '&#xf231;fa-pinterest-p', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('378', 'ICONS_TYPE', 'fa-pinterest-square           ', '&#xf0d3;fa-pinterest-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('379', 'ICONS_TYPE', 'fa-plane                      ', '&#xf072;fa-plane', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('380', 'ICONS_TYPE', 'fa-play                       ', '&#xf04b;fa-play', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('381', 'ICONS_TYPE', 'fa-play-circle                ', '&#xf144;fa-play-circle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('382', 'ICONS_TYPE', 'fa-play-circle-o              ', '&#xf01d;fa-play-circle-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('383', 'ICONS_TYPE', 'fa-plug                       ', '&#xf1e6;fa-plug', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('384', 'ICONS_TYPE', 'fa-plus                       ', '&#xf067;fa-plus', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('385', 'ICONS_TYPE', 'fa-plus-circle                ', '&#xf055;fa-plus-circle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('386', 'ICONS_TYPE', 'fa-plus-square                ', '&#xf0fe;fa-plus-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('387', 'ICONS_TYPE', 'fa-plus-square-o              ', '&#xf196;fa-plus-square-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('388', 'ICONS_TYPE', 'fa-power-off                  ', '&#xf011;fa-power-off', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('389', 'ICONS_TYPE', 'fa-print                      ', '&#xf02f;fa-print', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('390', 'ICONS_TYPE', 'fa-puzzle-piece               ', '&#xf12e;fa-puzzle-piece', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('391', 'ICONS_TYPE', 'fa-qq                         ', '&#xf1d6;fa-qq', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('392', 'ICONS_TYPE', 'fa-qrcode                     ', '&#xf029;fa-qrcode', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('393', 'ICONS_TYPE', 'fa-question                   ', '&#xf128;fa-question', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('394', 'ICONS_TYPE', 'fa-question-circle            ', '&#xf059;fa-question-circle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('395', 'ICONS_TYPE', 'fa-quote-left                 ', '&#xf10d;fa-quote-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('396', 'ICONS_TYPE', 'fa-quote-right                ', '&#xf10e;fa-quote-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('397', 'ICONS_TYPE', 'fa-ra                         ', '&#xf1d0;fa-ra', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('398', 'ICONS_TYPE', 'fa-random                     ', '&#xf074;fa-random', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('399', 'ICONS_TYPE', 'fa-rebel                      ', '&#xf1d0;fa-rebel', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('400', 'ICONS_TYPE', 'fa-recycle                    ', '&#xf1b8;fa-recycle', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('401', 'ICONS_TYPE', 'fa-reddit                     ', '&#xf1a1;fa-reddit', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('402', 'ICONS_TYPE', 'fa-reddit-square              ', '&#xf1a2;fa-reddit-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('403', 'ICONS_TYPE', 'fa-refresh                    ', '&#xf021;fa-refresh', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('404', 'ICONS_TYPE', 'fa-registered                 ', '&#xf25d;fa-registered', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('405', 'ICONS_TYPE', 'fa-remove                     ', '&#xf00d;fa-remove', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('406', 'ICONS_TYPE', 'fa-renren                     ', '&#xf18b;fa-renren', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('407', 'ICONS_TYPE', 'fa-reorder                    ', '&#xf0c9;fa-reorder', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('408', 'ICONS_TYPE', 'fa-repeat                     ', '&#xf01e;fa-repeat', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('409', 'ICONS_TYPE', 'fa-reply                      ', '&#xf112;fa-reply', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('410', 'ICONS_TYPE', 'fa-reply-all                  ', '&#xf122;fa-reply-all', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('411', 'ICONS_TYPE', 'fa-retweet                    ', '&#xf079;fa-retweet', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('412', 'ICONS_TYPE', 'fa-rmb                        ', '&#xf157;fa-rmb', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('413', 'ICONS_TYPE', 'fa-road                       ', '&#xf018;fa-road', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('414', 'ICONS_TYPE', 'fa-rocket                     ', '&#xf135;fa-rocket', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('415', 'ICONS_TYPE', 'fa-rotate-left                ', '&#xf0e2;fa-rotate-left', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('416', 'ICONS_TYPE', 'fa-rotate-right               ', '&#xf01e;fa-rotate-right', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('417', 'ICONS_TYPE', 'fa-rouble                     ', '&#xf158;fa-rouble', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('418', 'ICONS_TYPE', 'fa-rss                        ', '&#xf09e;fa-rss', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('419', 'ICONS_TYPE', 'fa-rss-square                 ', '&#xf143;fa-rss-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('420', 'ICONS_TYPE', 'fa-rub                        ', '&#xf158;fa-rub', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('421', 'ICONS_TYPE', 'fa-ruble                      ', '&#xf158;fa-ruble', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('422', 'ICONS_TYPE', 'fa-rupee                      ', '&#xf156;fa-rupee', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('423', 'ICONS_TYPE', 'fa-safari                     ', '&#xf267;fa-safari', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('424', 'ICONS_TYPE', 'fa-sliders                    ', '&#xf1de;fa-sliders', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('425', 'ICONS_TYPE', 'fa-slideshare                 ', '&#xf1e7;fa-slideshare', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('426', 'ICONS_TYPE', 'fa-smile-o                    ', '&#xf118;fa-smile-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('427', 'ICONS_TYPE', 'fa-sort-asc                   ', '&#xf0de;fa-sort-asc', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('428', 'ICONS_TYPE', 'fa-sort-desc                  ', '&#xf0dd;fa-sort-desc', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('429', 'ICONS_TYPE', 'fa-sort-down                  ', '&#xf0dd;fa-sort-down', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('431', 'ICONS_TYPE', 'fa-spoon                      ', '&#xf110;fa-spinner', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('432', 'ICONS_TYPE', 'fa-spotify                    ', '&#xf1b1;fa-spoon', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('433', 'ICONS_TYPE', 'fa-square                     ', '&#xf1bc;fa-spotify', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('434', 'ICONS_TYPE', 'fa-square-o                   ', '&#xf0c8;fa-square', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('435', 'ICONS_TYPE', 'fa-star                       ', '&#xf096;fa-square-o', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('436', 'ICONS_TYPE', 'fa-star-half                  ', '&#xf005;fa-star', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('437', 'ICONS_TYPE', 'fa-stop                       ', '&#xf089;fa-star-half', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('438', 'ICONS_TYPE', 'fa-subscript                  ', '&#xf04d;fa-stop', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('439', 'ICONS_TYPE', 'fa-tablet                     ', '&#xf12c;fa-subscript', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('440', 'ICONS_TYPE', 'fa-tachometer                 ', '&#xf10a;fa-tablet', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('441', 'ICONS_TYPE', 'fa-tag                        ', '&#xf0e4;fa-tachometer', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('442', 'ICONS_TYPE', 'fa-tags                       ', '&#xf02b;fa-tag', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('443', 'ICONS_TYPE', '&#xf02c; fa-tags', '&#xf02c;fa-tags', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('444', 'USER_STATUS_TYPE', '1', 'Active', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('445', 'USER_STATUS_TYPE', '0', 'Non Active', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('446', 'TYPE_MENU', 'Sub Menu', 'Sub Menu', 'Y', null, null, null, null);
INSERT INTO "public"."jdcfnd_mstlookup" VALUES ('447', 'TYPE_MENU', 'Menu', 'Menu', 'Y', null, null, null, null);

-- ----------------------------
-- Table structure for jdcfnd_mstparams
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcfnd_mstparams";
CREATE TABLE "public"."jdcfnd_mstparams" (
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

-- ----------------------------
-- Records of jdcfnd_mstparams
-- ----------------------------
INSERT INTO "public"."jdcfnd_mstparams" VALUES ('1', 'CRONS', 'CRONS', '0 0/5 * * * ?', '1', '1', '2018-10-01 15:04:40', null, null);
INSERT INTO "public"."jdcfnd_mstparams" VALUES ('2', 'CRONS', 'STATUS', 'ACTIVE', '1', '1', '2018-10-01 15:05:46', null, null);
INSERT INTO "public"."jdcfnd_mstparams" VALUES ('3', 'CRONS', 'JOB', '1', '1', '1', '2018-10-01 15:06:35', '1', null);
INSERT INTO "public"."jdcfnd_mstparams" VALUES ('4', 'CRONS', 'LIMIT', '10', '1', '1', '2018-10-01 15:06:58', null, null);

-- ----------------------------
-- Table structure for jdcuam_mstcomponent
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcuam_mstcomponent";
CREATE TABLE "public"."jdcuam_mstcomponent" (
"menu_comp_id" int4 NOT NULL,
"menu_id" int4,
"menu_comp_name" varchar(20) COLLATE "default",
"menu_comp_desc" varchar(255) COLLATE "default",
"menu_comp_icon" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE);

-- ----------------------------
-- Records of jdcuam_mstcomponent
-- ----------------------------
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('1', '1', 'VIEW', 'VIEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('2', '3', 'VIEW', 'VIEW', null);
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('4', '10', 'VIEW', 'VIEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('5', '10', 'EDIT', 'EDIT', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('6', '10', 'DELETE', 'DELETE', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('7', '10', 'NEW', 'NEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('8', '11', 'VIEW', 'VIEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('9', '11', 'NEW', 'NEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('10', '11', 'EDIT', 'EDIT', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('11', '11', 'DELETE', 'DELETE', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('12', '12', 'VIEW', 'VIEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('13', '12', 'NEW', 'NEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('14', '12', 'EDIT', 'EDIT', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('15', '12', 'DELETE', 'DELETE', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('16', '13', 'VIEW', 'VIEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('17', '13', 'NEW', 'NEW', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('18', '13', 'EDIT', 'EDIT', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('19', '13', 'DELETE', 'DELETE', '');
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('26', '21', 'VIEW', 'VIEW', null);
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('27', '21', 'NEW', 'NEW', null);
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('28', '21', 'EDIT', 'EDIT', null);
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('29', '21', 'DELETE', 'DELETE', null);
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('30', '23', 'VIEW', 'VIEW', null);
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('31', '23', 'NEW', 'NEW', null);
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('32', '23', 'EDIT', 'EDIT', null);
INSERT INTO "public"."jdcuam_mstcomponent" VALUES ('33', '23', 'DELETE', 'DELETE', null);

-- ----------------------------
-- Table structure for jdcuam_mstmenu
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcuam_mstmenu";
CREATE TABLE "public"."jdcuam_mstmenu" (
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

-- ----------------------------
-- Records of jdcuam_mstmenu
-- ----------------------------
INSERT INTO "public"."jdcuam_mstmenu" VALUES ('1', 'ADMINISTRATION', 'Adminstration', null, 'fa-home                       ', null, '1', '1', null);
INSERT INTO "public"."jdcuam_mstmenu" VALUES ('2', 'SAMPLE_ROOM', 'Sample Room', null, 'fa-bar-chart                  ', null, '1', '2', '                                                                                                                                                                                                                                 ');
INSERT INTO "public"."jdcuam_mstmenu" VALUES ('10', 'USER_MANAGEMENT', 'User Management', '/administration/cmsuser/', 'fa-group                      ', '1', '1', '1', 'ADMINISTRATION                                                                                                                                                                                                                   ');
INSERT INTO "public"."jdcuam_mstmenu" VALUES ('11', 'ROLE_MANAGEMENT', 'Role Management', '/administration/cmsrole/', 'fa-rotate-right               ', '1', '1', '2', 'ADMINISTRATION                                                                                                                                                                                                                   ');
INSERT INTO "public"."jdcuam_mstmenu" VALUES ('12', 'PARAM_CONFIG', 'Param Config', '/administration/cmsparam/', 'fa-edit                       ', '1', '1', '3', 'ADMINISTRATION                                                                                                                                                                                                                   ');
INSERT INTO "public"."jdcuam_mstmenu" VALUES ('13', 'MENU', 'Menu', '/administration/cmsmenu/', 'fa-list                       ', '1', '1', '4', 'ADMINISTRATION                                                                                                                                                                                                                   ');
INSERT INTO "public"."jdcuam_mstmenu" VALUES ('21', 'SPK', 'View Spk', '/sampleroom/spk', 'fa-cog                        ', '2', '1', '1', 'Sample Room                                                                                                                                                                                                                      ');
INSERT INTO "public"."jdcuam_mstmenu" VALUES ('23', 'SCAN_IN', 'QR Scan In', '/sampleroom/scanin', 'fa-instagram                  ', '2', '1', '2', 'Sample Room                                                                                                                                                                                                                      ');

-- ----------------------------
-- Table structure for jdcuam_mstrole
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcuam_mstrole";
CREATE TABLE "public"."jdcuam_mstrole" (
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

-- ----------------------------
-- Records of jdcuam_mstrole
-- ----------------------------
INSERT INTO "public"."jdcuam_mstrole" VALUES ('1', 'ROLE_SUPERADMIN', 'Super Administration Role', null, null, null, null);

-- ----------------------------
-- Table structure for jdcuam_mstroledtl
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcuam_mstroledtl";
CREATE TABLE "public"."jdcuam_mstroledtl" (
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

-- ----------------------------
-- Records of jdcuam_mstroledtl
-- ----------------------------
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('1', '1', '1', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('4', '1', '4', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('5', '1', '5', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('6', '1', '6', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('7', '1', '7', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('8', '1', '8', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('9', '1', '9', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('10', '1', '10', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('11', '1', '11', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('12', '1', '12', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('13', '1', '13', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('14', '1', '14', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('15', '1', '15', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('16', '1', '16', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('17', '1', '17', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('18', '1', '18', '2019-04-16 14:49:40', '1', null, null);
INSERT INTO "public"."jdcuam_mstroledtl" VALUES ('19', '1', '19', '2019-04-16 14:49:40', '1', null, null);

-- ----------------------------
-- Table structure for jdcuam_mstuser
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcuam_mstuser";
CREATE TABLE "public"."jdcuam_mstuser" (
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

-- ----------------------------
-- Records of jdcuam_mstuser
-- ----------------------------
INSERT INTO "public"."jdcuam_mstuser" VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'admin', 'admin@gmail.com', '123456789', '2018-09-19 09:57:18.913', '1', '2018-10-26 12:54:14.675', '1', 'ADMIN', 'Active', '18');

-- ----------------------------
-- Table structure for jdcuam_mstuserole
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcuam_mstuserole";
CREATE TABLE "public"."jdcuam_mstuserole" (
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

-- ----------------------------
-- Table structure for jdcadp_mstspk
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_mstspk";
CREATE TABLE "public"."jdcadp_mstspk" (
"spk_id" int8 NOT NULL
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8,
"etc_date" timestamp(6),
"category" varchar(200) COLLATE "default",
"model" varchar(200) COLLATE "default",
"product_code" varchar(200) COLLATE "default",
"qty" float8,
"sample_req" varchar(200) COLLATE "default",
"season" varchar(200) COLLATE "default",
"size" varchar(200) COLLATE "default",
"type_sample" varchar(200) COLLATE "default",
"start_date" timestamp(6)
)
WITH (OIDS=FALSE)
;


-- ----------------------------
-- Table structure for jdcadp_txnlogsummary
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_txnlogsummary";
CREATE TABLE "public"."jdcadp_txnlogsummary" (
"log_id" int8 NOT NULL
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8,
"input_date" timestamp(6),
"partial" int8,
"total_pairs" int8,
"cartoon" int8,
"sample" int8,
"pairs" int8,
"persentase" int8,
"code" varchar(200) COLLATE "default",
"issue" varchar(200) COLLATE "default",
"result" varchar(200) COLLATE "default",
"line_code" varchar(20) COLLATE "default",
"po_item" varchar(20) COLLATE "default",
"po_no" varchar(20) COLLATE "default",
"flag_save" int4,
"flag_submit" int4
)
WITH (OIDS=FALSE)
;

-- ----------------------------
-- Table structure for jdcadp_txnstock
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_txnstock";
CREATE TABLE "public"."jdcadp_txnstock" (
"request_id" int8 NOT NULL,
"sample_req" varchar(200) COLLATE "default",
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8,
"transfer_to" varchar(200) COLLATE "default",
"color_desc" varchar(200) COLLATE "default",
"estimated_return" timestamp(6),
"date_return" timestamp(6),
"remark" varchar(200) COLLATE "default",
"model" varchar(200) COLLATE "default",
"size" varchar(200) COLLATE "default",
"qty" float8,
"tnfr_qty" float8,
"rtrn_qty" float8,
"transfer_approve" int8,
"transfer_return" int8
)
WITH (OIDS=FALSE)
;


-- ----------------------------
-- Table structure for jdcadp_txnlotbasis
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_txnlotbasis";
CREATE TABLE "public"."jdcadp_txnlotbasis" (
"lot_id" int8 NOT NULL,
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8,
"hourly" int8,
"size_1" int8,
"flag_in_size_1" int8,
"flag_out_size_1" int8,
"size_1_t" int8,
"flag_in_size_1_t" int8,
"flag_out_size_1_t" int8,
"size_2" int8,
"flag_in_size_2" int8,
"flag_out_size_2" int8,
"size_2_t" int8,
"flag_in_size_2_t" int8,
"flag_out_size_2_t" int8,
"size_3" int8,
"flag_in_size_3" int8,
"flag_out_size_3" int8,
"size_3_t" int8,
"flag_in_size_3_t" int8,
"flag_out_size_3_t" int8,
"size_4" int8,
"flag_in_size_4" int8,
"flag_out_size_4" int8,
"size_4_t" int8,
"flag_in_size_4_t" int8,
"flag_out_size_4_t" int8,
"size_5" int8,
"flag_in_size_5" int8,
"flag_out_size_5" int8,
"size_5_t" int8,
"flag_in_size_5_t" int8,
"flag_out_size_5_t" int8,
"size_6" int8,
"flag_in_size_6" int8,
"flag_out_size_6" int8,
"size_6_t" int8,
"flag_in_size_6_t" int8,
"flag_out_size_6_t" int8,
"size_7" int8,
"flag_in_size_7" int8,
"flag_out_size_7" int8,
"size_7_t" int8,
"flag_in_size_7_t" int8,
"flag_out_size_7_t" int8,
"size_8" int8,
"flag_in_size_8" int8,
"flag_out_size_8" int8,
"size_8_t" int8,
"flag_in_size_8_t" int8,
"flag_out_size_8_t" int8,
"size_9" int8,
"flag_in_size_9" int8,
"flag_out_size_9" int8,
"size_9_t" int8,
"flag_in_size_9_t" int8,
"flag_out_size_9_t" int8,
"size_10" int8,
"flag_in_size_10" int8,
"flag_out_size_10" int8,
"size_10_t" int8,
"flag_in_size_10_t" int8,
"flag_out_size_10_t" int8,
"size_11" int8,
"flag_in_size_11" int8,
"flag_out_size_11" int8,
"size_11_t" int8,
"flag_in_size_11_t" int8,
"flag_out_size_11_t" int8,
"size_12" int8,
"flag_in_size_12" int8,
"flag_out_size_12" int8,
"size_12_t" int8,
"flag_in_size_12_t" int8,
"flag_out_size_12_t" int8,
"size_13" int8,
"flag_in_size_13" int8,
"flag_out_size_13" int8,
"size_13_t" int8,
"flag_in_size_13_t" int8,
"flag_out_size_13_t" int8,
"size_14" int8,
"flag_in_size_14" int8,
"flag_out_size_14" int8,
"size_15" int8,
"flag_in_size_15" int8,
"flag_out_size_15" int8,
"size_16" int8,
"flag_in_size_16" int8,
"flag_out_size_16" int8,
"size_17" int8,
"flag_in_size_17" int8,
"flag_out_size_17" int8,
"size_18" int8,
"flag_in_size_18" int8,
"flag_out_size_18" int8,
"line_code" varchar(20) COLLATE "default",
"po_item" varchar(20) COLLATE "default",
"po_no" varchar(20) COLLATE "default"

)
WITH (OIDS=FALSE)
;

-- ----------------------------
-- Table structure for jdcadp_txnlotapprv
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_txnlotapprv";
CREATE TABLE "public"."jdcadp_txnlotapprv" (
"lotapprv_id" int8 NOT NULL,
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8,
"hourly" int8,
"size_1" int8,
"size_1_t" int8,
"size_2" int8,
"size_2_t" int8,
"size_3" int8,
"size_3_t" int8,
"size_4" int8,
"size_4_t" int8,
"size_5" int8,
"size_5_t" int8,
"size_6" int8,
"size_6_t" int8,
"size_7" int8,
"size_7_t" int8,
"size_8" int8,
"size_8_t" int8,
"size_9" int8,
"size_9_t" int8,
"size_10" int8,
"size_10_t" int8,
"size_11" int8,
"size_11_t" int8,
"size_12" int8,
"size_12_t" int8,
"size_13" int8,
"size_13_t" int8,
"size_14" int8,
"size_15" int8,
"size_16" int8,
"size_17" int8,
"size_18" int8,
"lot_id" int8,
"status" int8

)
WITH (OIDS=FALSE)
;


-- ----------------------------
-- Table structure for jdcadp_txnrpph
-- ----------------------------
DROP TABLE IF EXISTS "public"."jdcadp_txnrpph";
CREATE TABLE "public"."jdcadp_txnrpph" (
"pph_id" int4 NOT NULL,
"created_date" timestamp(6),
"created_by" int8,
"last_updated_date" timestamp(6),
"last_updated_by" int8,
"date_pph" timestamp(6),
"pph_ct" int8,
"pph_st" int8,
"pph_as" int8,
)
WITH (OIDS=FALSE)

-- ----------------------------
-- Primary Key structure for table jdcadp_txnlotapprv
-- ----------------------------
ALTER TABLE "public"."jdcadp_txnlotapprv" ADD PRIMARY KEY ("lotapprv_id");

-- ----------------------------
-- Primary Key structure for table jdcadp_txnlotbasis
-- ----------------------------
ALTER TABLE "public"."jdcadp_txnlotbasis" ADD PRIMARY KEY ("lot_id");

-- ----------------------------
-- Primary Key structure for table jdcadp_txnlogsummary
-- ----------------------------
ALTER TABLE "public"."jdcadp_txnlogsummary" ADD PRIMARY KEY ("log_id");

-- ----------------------------
-- Primary Key structure for table jdcadp_mstspk
-- ----------------------------
ALTER TABLE "public"."jdcadp_mstspk" ADD PRIMARY KEY ("spk_id");

-- ----------------------------
-- Records of jdcuam_mstuserole
-- ----------------------------
INSERT INTO "public"."jdcuam_mstuserole" VALUES ('1', '1', '1', '2019-04-16 14:47:21', null, null, null, '1');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table jdcadp_mstparams
-- ----------------------------
ALTER TABLE "public"."jdcadp_mstparams" ADD PRIMARY KEY ("param_id");

-- ----------------------------
-- Primary Key structure for table jdcfnd_mstlookup
-- ----------------------------
ALTER TABLE "public"."jdcfnd_mstlookup" ADD PRIMARY KEY ("lookup_id");

-- ----------------------------
-- Primary Key structure for table jdcfnd_mstparams
-- ----------------------------
ALTER TABLE "public"."jdcfnd_mstparams" ADD PRIMARY KEY ("param_id");

-- ----------------------------
-- Primary Key structure for table jdcuam_mstcomponent
-- ----------------------------
ALTER TABLE "public"."jdcuam_mstcomponent" ADD PRIMARY KEY ("menu_comp_id");

-- ----------------------------
-- Primary Key structure for table jdcuam_mstmenu
-- ----------------------------
ALTER TABLE "public"."jdcuam_mstmenu" ADD PRIMARY KEY ("menu_id");

-- ----------------------------
-- Primary Key structure for table jdcuam_mstrole
-- ----------------------------
ALTER TABLE "public"."jdcuam_mstrole" ADD PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table jdcuam_mstroledtl
-- ----------------------------
ALTER TABLE "public"."jdcuam_mstroledtl" ADD PRIMARY KEY ("role_dtl_id");

-- ----------------------------
-- Primary Key structure for table jdcuam_mstuser
-- ----------------------------
ALTER TABLE "public"."jdcuam_mstuser" ADD PRIMARY KEY ("usr_id");

-- ----------------------------
-- Primary Key structure for table jdcuam_mstuserole
-- ----------------------------
ALTER TABLE "public"."jdcuam_mstuserole" ADD PRIMARY KEY ("userrole_id");

-- ----------------------------
-- Primary Key structure for table jdcadp_txnstock
-- ----------------------------
ALTER TABLE "public"."jdcadp_txnstock" ADD PRIMARY KEY ("request_id");

-- ----------------------------
-- Primary Key structure for table jdcadp_txnstock
-- ----------------------------
ALTER TABLE "public"."jdcadp_txnrpph" ADD PRIMARY KEY ("pph_id");


ALTER TABLE "public"."jdcadp_mstabsen" ADD PRIMARY KEY ("absen_id");
ALTER TABLE "public"."jdcadp_txnbcode" ADD PRIMARY KEY ("barcode_id");
ALTER TABLE "public"."jdcadp_mstdptunit" ADD PRIMARY KEY ("dpt_id");
ALTER TABLE "public"."jdcadp_mstimage" ADD PRIMARY KEY ("images_id");
ALTER TABLE "public"."jdcadp_mstorgunit" ADD PRIMARY KEY ("org_id");
ALTER TABLE "public"."jdcadp_mstproduksi" ADD PRIMARY KEY ("product_id");
ALTER TABLE "public"."jdcadp_txnqctrl" ADD PRIMARY KEY ("qc_id");
